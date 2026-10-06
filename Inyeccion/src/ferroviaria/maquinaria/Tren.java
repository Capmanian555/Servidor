package ferroviaria.maquinaria;

import ferroviaria.personal.Maquinista;

public class Tren {

    private Locomotora locomotora;
    private Vagon[] vagones;
    private Maquinista maquinista;

    public Tren(Locomotora locomotora, Maquinista maquinista) {

        this.locomotora = locomotora;
        this.maquinista = maquinista;
        this.vagones = new Vagon[5];
    }

    public void agregarVagon(double capacidadMaxima,
                             double capacidadActual,
                             String tipoMercancia) {

        for (int i = 0; i < vagones.length; i++) {

            if (vagones[i] == null) {

                vagones[i] = new Vagon(
                        capacidadMaxima,
                        capacidadActual,
                        tipoMercancia
                );

                return;
            }
        }

        System.out.println("El tren ya tiene 5 vagones.");
    }

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public Maquinista getMaquinista() {
        return maquinista;
    }

    public Vagon[] getVagones() {
        return vagones;
    }
}
