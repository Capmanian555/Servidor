import java.util.List;

public class Casa {

    private final double area;
    private final Tejado tejado;
    private final List<Pared> paredes;

    // Inyección de dependencias por constructor: Casa NO crea sus objetos, los recibe
    public Casa(double area, Tejado tejado, Pared pared1, Pared pared2, Pared pared3, Pared pared4) {
        this.area = area;
        this.tejado = tejado;
        this.paredes = List.of(pared1, pared2, pared3, pared4);
    }

    public void mostrar() {
        System.out.println("Casa de " + area + " m2 con " + paredes.size() + " paredes");
        tejado.darSoporte();
    }
}
