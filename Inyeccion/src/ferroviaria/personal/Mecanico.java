package ferroviaria.personal;

public class Mecanico {

    private String nombreCompleto;
    private String telefono;
    private String especialidad;

    public Mecanico(String nombreCompleto, String telefono,
                    String especialidad) {

        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}