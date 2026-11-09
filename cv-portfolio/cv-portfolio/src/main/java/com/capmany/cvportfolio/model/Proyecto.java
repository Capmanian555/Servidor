package com.capmany.cvportfolio.model;

/** enlace e imagen pueden ser null cuando no existen. */
public record Proyecto(String tituloKey, int anio, Categoria categoria, Estado estado,
                       String descripcionKey, String[] tecnologias,
                       String enlace, String imagen, String imagenAltKey) {
}
