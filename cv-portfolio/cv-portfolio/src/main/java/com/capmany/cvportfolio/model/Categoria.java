package com.capmany.cvportfolio.model;

public enum Categoria {
    APLICACIONES, SITIOS_WEB, DISENO;

    /** Clave i18n de la etiqueta de la categoria. */
    public String clave() {
        return "categoria." + name();
    }

    /** Devuelve la categoria o null si el texto no corresponde a ninguna (por ejemplo "TODAS"). */
    public static Categoria desdeTexto(String texto) {
        if (texto == null) {
            return null;
        }
        for (Categoria c : values()) {
            if (c.name().equals(texto.trim())) {
                return c;
            }
        }
        return null;
    }
}
