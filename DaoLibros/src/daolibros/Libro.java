package daolibros;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private int annoPublicacion;

    public Libro(int id, String titulo, String autor, int annoPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.annoPublicacion = annoPublicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnnoPublicacion() {
        return annoPublicacion;
    }

    public void setAnnoPublicacion(int annoPublicacion) {
        this.annoPublicacion = annoPublicacion;
    }

    @Override
    public String toString() {
        return id + " - \"" + titulo + "\" por " + autor + ", " + annoPublicacion;
    }
}
