package ferroviaria.personal;

public class JefeEstacion {

    private String nombreCompleto;
    private String dni;

    public JefeEstacion(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDni() {
        return dni;
    }
}