package com.capmany.cvportfolio.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capmany.cvportfolio.model.Estudio;
import com.capmany.cvportfolio.model.Experiencia;
import com.capmany.cvportfolio.model.Habilidad;
import com.capmany.cvportfolio.model.Idioma;

/** Hito 1: pagina /curriculum. */
@Controller
public class CvController {

    // Se lee de application.properties (cv.nombre). Es final: no cambia entre peticiones.
    private final String nombre;

    public CvController(@Value("${cv.nombre}") String nombre) {
        this.nombre = nombre;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/curriculum";
    }

    @GetMapping("/curriculum")
    public String curriculum(Model model) {
        // Datos en arrays Java; Thymeleaf los recorre con th:each.
        // anioFin = null significa "En curso".
        Estudio[] formacion = {
                new Estudio("cv.formacion.daw", "(IES Velazquez)", null),
                new Estudio("cv.formacion.bachillerato", "IES Martinez Montannes", 2024),
                new Estudio("cv.formacion.eso", "Juan Nepomuceno Rojas", 2022)
        };

        // Array vacio: la plantilla mostrara "En busca de mi primera experiencia".
        Experiencia[] experiencia = {};

        Habilidad[] habilidades = {
                new Habilidad("Java", "medio"),
                new Habilidad("JavaScript", "medio"),
                new Habilidad("HTML y CSS", "medio"),
                new Habilidad("Git y GitHub", "bajo")
        };

        Idioma[] idiomas = {
                new Idioma("idioma.espanol", "alto"),
                new Idioma("idioma.ingles", "medio")
        };

        model.addAttribute("nombre", nombre);
        model.addAttribute("ciudad", "Sevilla");
        // Si email y github estan vacios, la plantilla oculta todo el apartado de contacto.
        model.addAttribute("email", "angelcapmanysanchez@gmail.com");
        model.addAttribute("github", "https://github.com/Capmanian555");
        model.addAttribute("formacion", formacion);
        model.addAttribute("experiencia", experiencia);
        model.addAttribute("habilidades", habilidades);
        model.addAttribute("idiomas", idiomas);
        return "curriculum";
    }
}
