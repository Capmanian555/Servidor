public class Main {

    public static void main(String[] args) {
        Presidente p1 = Presidente.getInstance();
        p1.setNombre("Manolo");
        p1.setApellidos("Garcia");
        p1.setAnioEleccion(2020);

        Presidente p2 = Presidente.getInstance();

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        // Comprobación: ambas variables apuntan al mismo objeto
        System.out.println("¿p1 y p2 son la misma instancia? " + (p1 == p2));

        // Un cambio hecho a través de p2 se ve en p1
        p2.setAnioEleccion(2024);
        System.out.println("p1 tras cambiar p2: " + p1);
    }
}
