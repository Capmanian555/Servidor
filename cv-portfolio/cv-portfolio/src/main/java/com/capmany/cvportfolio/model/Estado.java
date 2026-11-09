package com.capmany.cvportfolio.model;

public enum Estado {
    EN_CURSO, TERMINADO;

    public String clave() {
        return "estado." + name();
    }

    public static Estado desdeTexto(String texto) {
        if (texto == null) {
            return null;
        }
        for (Estado e : values()) {
            if (e.name().equals(texto.trim())) {
                return e;
            }
        }
        return null;
    }
}
