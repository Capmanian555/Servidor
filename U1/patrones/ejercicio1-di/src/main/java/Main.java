public class Main {

    public static void main(String[] args) {
        // Casa 1: con tejado básico (las dependencias se crean fuera y se inyectan)
        Casa casa1 = new Casa(80.0, new Tejado(),
                new Pared(), new Pared(), new Pared(), new Pared());

        // Casa 2: con tejado de tejas
        Casa casa2 = new Casa(120.5, new TejadoTejas(),
                new Pared(), new Pared(), new Pared(), new Pared());

        casa1.mostrar();
        casa2.mostrar();
    }
}
