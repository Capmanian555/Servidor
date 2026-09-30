package daolibros;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        LibroDao dao = new LibroDaoImpl();

        Libro libro1 = new Libro(
                1,
                "Cien annos de soledad",
                "Gabriel García Márquez",
                1967
        );

        Libro libro2 = new Libro(
                2,
                "Don Quijote de la Mancha",
                "Miguel de Cervantes",
                1605
        );

        dao.agregar(libro1);
        dao.agregar(libro2);

        System.out.println("Todos los libros:");

        List<Libro> libros = dao.obtenerTodos();

        for (Libro libro : libros) {
            System.out.println(libro);
        }

        System.out.println("\nLibro con ID 1:");

        try {
            Libro libro = dao.obtenerPorId(1);
            System.out.println(libro);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nActualizando libro con ID 1...");

        try {
            Libro libroActualizado = new Libro(
                    1,
                    "Cien annos de soledad",
                    "Gabriel García Marquez",
                    1969
            );

            dao.actualizar(libroActualizado);

            System.out.println("Libro actualizado con exito.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nTodos los libros despues de actualizar:");

        for (Libro libro : dao.obtenerTodos()) {
            System.out.println(libro);
        }

        System.out.println("\nEliminando libro con ID 2...");

        try {
            dao.eliminar(2);

            System.out.println("Libro eliminado con exito.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nTodos los libros despues de eliminar:");

        for (Libro libro : dao.obtenerTodos()) {
            System.out.println(libro);
        }
    }
}
