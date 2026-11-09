package com.capmany.cvportfolio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capmany.cvportfolio.model.Categoria;
import com.capmany.cvportfolio.model.Estado;
import com.capmany.cvportfolio.model.Proyecto;

/** Hito 2: pagina /portfolio con filtro en el servidor (formulario GET). */
@Controller
public class PortfolioController {

    @GetMapping("/portfolio")
    public String portfolio(@RequestParam(defaultValue = "TODAS") String categoria,
                            @RequestParam(defaultValue = "") String anio,
                            Model model) {

        // "TODAS" (o cualquier valor desconocido) no filtra por categoria
        Categoria categoriaFiltro = Categoria.desdeTexto(categoria);

        // El anio llega como texto y se convierte a numero de forma explicita
        Integer anioFiltro = null;
        boolean anioInvalido = false;
        String anioTexto = anio.trim();
        if (!anioTexto.isEmpty()) {
            try {
                anioFiltro = Integer.valueOf(anioTexto);
            } catch (NumberFormatException e) {
                anioInvalido = true; // no se filtra por anio
            }
        }

        List<Proyecto> resultado = filtrarProyectos(proyectos(), categoriaFiltro, anioFiltro);

        model.addAttribute("proyectos", resultado);
        model.addAttribute("total", resultado.size());
        model.addAttribute("categorias", Categoria.values());
        // Se devuelven los valores elegidos para que sigan visibles en el formulario
        model.addAttribute("categoriaSel", categoriaFiltro == null ? "TODAS" : categoriaFiltro.name());
        model.addAttribute("anioSel", anioTexto);
        model.addAttribute("anioInvalido", anioInvalido);
        return "portfolio";
    }

    /**
     * Filtra la coleccion. categoria == null o anio == null significan "sin limite";
     * si se indican los dos, deben cumplirse ambos.
     */
    static List<Proyecto> filtrarProyectos(List<Proyecto> proyectos, Categoria categoria, Integer anio) {
        return proyectos.stream()
                .filter(p -> categoria == null || p.categoria() == categoria)
                .filter(p -> anio == null || p.anio() == anio)
                .toList();
    }

    // Datos en memoria; se crean en cada peticion (no hay estado compartido).
    private static List<Proyecto> proyectos() {
        return List.of(
                new Proyecto("proyecto.cvweb.titulo", 2026, Categoria.APLICACIONES, Estado.EN_CURSO,
                        "proyecto.cvweb.descripcion",
                        new String[] {"Java", "Spring Boot", "Thymeleaf", "Maven"},
                        "https://github.com/Capmanian555/Servidor",
                        "/img/cv-web.svg", "proyecto.cvweb.alt"),
                new Proyecto("proyecto.regex.titulo", 2026, Categoria.SITIOS_WEB, Estado.TERMINADO,
                        "proyecto.regex.descripcion",
                        new String[] {"HTML", "JavaScript", "Node.js"},
                        null, // sin enlace: no se genera el enlace
                        "/img/regex.svg", "proyecto.regex.alt"),
                new Proyecto("proyecto.patrones.titulo", 2026, Categoria.APLICACIONES, Estado.TERMINADO,
                        "proyecto.patrones.descripcion",
                        new String[] {"Java", "Maven", "IntelliJ IDEA"},
                        null,
                        null, null), // sin imagen: no se genera <img>
                new Proyecto("proyecto.css.titulo", 2026, Categoria.DISENO, Estado.TERMINADO,
                        "proyecto.css.descripcion",
                        new String[] {"HTML", "CSS"},
                        null,
                        null, null));
    }
}
