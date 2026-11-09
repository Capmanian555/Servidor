package com.capmany.cvportfolio.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capmany.cvportfolio.form.PortfolioForm;
import com.capmany.cvportfolio.form.ProyectoForm;
import com.capmany.cvportfolio.model.Categoria;
import com.capmany.cvportfolio.model.Estado;

/** Hito 3: editor /portfolio/editar con vista previa. Todo se procesa en el servidor. */
@Controller
@RequestMapping("/portfolio/editar")
public class EditorController {

    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    // Se lee de application.properties (portfolio.max-proyectos); final = no cambia entre peticiones
    private final int maxProyectos;

    public EditorController(@Value("${portfolio.max-proyectos}") int maxProyectos) {
        this.maxProyectos = maxProyectos;
    }

    // Datos que necesita la plantilla en todas las respuestas
    @ModelAttribute("maximo")
    public int maximo() {
        return maxProyectos;
    }

    @ModelAttribute("categorias")
    public Categoria[] categorias() {
        return Categoria.values();
    }

    @ModelAttribute("estados")
    public Estado[] estados() {
        return Estado.values();
    }

    @GetMapping
    public String mostrar(Model model) {
        model.addAttribute("form", new PortfolioForm());
        return "editor";
    }

    @PostMapping
    public String procesar(@ModelAttribute("form") PortfolioForm form,
                           BindingResult result,
                           @RequestParam(required = false) String accion,
                           @RequestParam(required = false) Integer quitar) {

        // Boton "Quitar este proyecto": llega el indice de la fila
        if (quitar != null) {
            modificarFilas(form, "quitar", quitar, result);
            return "editor";
        }

        // Defensa en el servidor: aunque se manipulen los campos, no se admite pasar del maximo
        if (form.getProyectos().size() > maxProyectos) {
            result.reject("proyectos.limite");
            return "editor";
        }

        if ("anadir".equals(accion)) {
            modificarFilas(form, "anadir", null, result);
            return "editor";
        }

        if ("vista".equals(accion)) {
            validar(form, result);
            if (result.hasErrors()) {
                return "editor";
            }
            // Las filas totalmente vacias se descartan
            form.getProyectos().removeIf(ProyectoForm::estaVacio);
            return "vista-previa";
        }

        // Cualquier otra accion (p. ej. "Volver a editar" desde la vista previa)
        asegurarUnaFila(form);
        return "editor";
    }

    /** Metodo 1: valida los datos personales y los proyectos. Los errores van a BindingResult. */
    private void validar(PortfolioForm form, BindingResult result) {
        if (esVacio(form.getNombre())) {
            result.rejectValue("nombre", "campo.obligatorio");
        }
        if (esVacio(form.getTitular())) {
            result.rejectValue("titular", "campo.obligatorio");
        }
        if (esVacio(form.getPresentacion())) {
            result.rejectValue("presentacion", "campo.obligatorio");
        }
        // El correo es opcional, pero si se rellena debe tener formato valido
        if (!esVacio(form.getEmail()) && !EMAIL.matcher(form.getEmail().trim()).matches()) {
            result.rejectValue("email", "email.invalido");
        }

        List<ProyectoForm> proyectos = form.getProyectos();
        for (int i = 0; i < proyectos.size(); i++) {
            ProyectoForm p = proyectos.get(i);
            if (p.estaVacio()) {
                continue; // fila vacia: se descarta, no se valida
            }
            String campo = "proyectos[" + i + "].";
            if (esVacio(p.getTitulo())) {
                result.rejectValue(campo + "titulo", "campo.obligatorio");
            }
            if (esVacio(p.getAnio())) {
                result.rejectValue(campo + "anio", "campo.obligatorio");
            } else if (!anioValido(p.getAnio())) {
                result.rejectValue(campo + "anio", "anio.invalido");
            }
            if (Categoria.desdeTexto(p.getCategoria()) == null) {
                result.rejectValue(campo + "categoria", "campo.obligatorio");
            }
            if (Estado.desdeTexto(p.getEstado()) == null) {
                result.rejectValue(campo + "estado", "campo.obligatorio");
            }
            if (esVacio(p.getDescripcion())) {
                result.rejectValue(campo + "descripcion", "campo.obligatorio");
            }
        }
    }

    /** Metodo 2: anade o quita la fila indicada por el boton pulsado. */
    private void modificarFilas(PortfolioForm form, String accion, Integer indice, BindingResult result) {
        List<ProyectoForm> proyectos = form.getProyectos();
        if ("anadir".equals(accion)) {
            if (proyectos.size() < maxProyectos) {
                proyectos.add(new ProyectoForm());
            } else {
                result.reject("proyectos.limite");
            }
        } else if ("quitar".equals(accion) && indice != null
                && indice >= 0 && indice < proyectos.size()) {
            proyectos.remove(indice.intValue());
        }
        asegurarUnaFila(form);
    }

    // Siempre debe quedar al menos una fila visible para seguir editando
    private void asegurarUnaFila(PortfolioForm form) {
        if (form.getProyectos().isEmpty()) {
            form.getProyectos().add(new ProyectoForm());
        }
    }

    private static boolean esVacio(String texto) {
        return texto == null || texto.isBlank();
    }

    private static boolean anioValido(String texto) {
        try {
            int anio = Integer.parseInt(texto.trim());
            return anio >= 1900 && anio <= 2100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
