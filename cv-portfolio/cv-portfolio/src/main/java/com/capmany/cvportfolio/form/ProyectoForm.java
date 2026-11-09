package com.capmany.cvportfolio.form;

/** Una fila de proyecto del editor. Todo son textos: el servidor valida y convierte. */
public class ProyectoForm {

    private String titulo = "";
    private String anio = "";
    private String categoria = "";
    private String estado = "";
    private String descripcion = "";

    public boolean estaVacio() {
        return vacio(titulo) && vacio(anio) && vacio(categoria) && vacio(estado) && vacio(descripcion);
    }

    private static boolean vacio(String texto) {
        return texto == null || texto.isBlank();
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAnio() { return anio; }
    public void setAnio(String anio) { this.anio = anio; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
