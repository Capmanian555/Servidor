package ferroviaria.maquinaria;

class Vagon {

    private double capacidadMaxima;
    private double capacidadActual;
    private String tipoMercancia;

    Vagon(double capacidadMaxima, double capacidadActual,
          String tipoMercancia) {

        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadActual;
        this.tipoMercancia = tipoMercancia;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }
}