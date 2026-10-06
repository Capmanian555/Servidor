package ferroviaria.maquinaria;

import ferroviaria.personal.Mecanico;

public class Locomotora implements Mantenible {

    private String matricula;
    private int potenciaMotor;
    private int anioFabricacion;
    private Mecanico mecanico;

    public Locomotora(String matricula, int potenciaMotor,
                      int anioFabricacion) {

        this.matricula = matricula;
        this.potenciaMotor = potenciaMotor;
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public void asignarMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }
}