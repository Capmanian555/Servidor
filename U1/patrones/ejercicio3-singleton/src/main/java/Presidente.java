public class Presidente {

    // Única instancia, creada al cargar la clase (segura en entornos con hilos)
    private static final Presidente INSTANCIA = new Presidente();

    private String nombre;
    private String apellidos;
    private int anioEleccion;

    // Constructor privado: nadie puede hacer new Presidente() desde fuera
    private Presidente() {
    }

    public static Presidente getInstance() {
        return INSTANCIA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAnioEleccion() {
        return anioEleccion;
    }

    public void setAnioEleccion(int anioEleccion) {
        this.anioEleccion = anioEleccion;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (elegido en " + anioEleccion + ")";
    }
}
