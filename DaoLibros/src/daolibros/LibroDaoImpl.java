package daolibros;

import java.util.ArrayList;
import java.util.List;

public class LibroDaoImpl implements LibroDao{
    private List<Libro> libros;

    public LibroDaoImpl() {
        libros = new ArrayList<>();
    }

    @Override
    public List<Libro> obtenerTodos() {
        return libros;
    }

    @Override
    public Libro obtenerPorId(int id) {

        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }

        throw new IllegalArgumentException(
                "No existe ningun libro con el ID " + id
        );
    }

    @Override
    public void agregar(Libro libro) {

        for (Libro libroExistente : libros) {

            if (libroExistente.getId() == libro.getId()) {
                throw new IllegalArgumentException(
                        "Ya existe un libro con el ID " + libro.getId()
                );
            }
        }

        libros.add(libro);
    }

    @Override
    public void actualizar(Libro libro) {

        for (int i = 0; i < libros.size(); i++) {

            if (libros.get(i).getId() == libro.getId()) {
                libros.set(i, libro);
                return;
            }
        }

        throw new IllegalArgumentException(
                "No existe ningun libro con el ID " + libro.getId()
        );
    }

    @Override
    public void eliminar(int id) {

        for (int i = 0; i < libros.size(); i++) {

            if (libros.get(i).getId() == id) {
                libros.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException(
                "No existe ningun libro con el ID " + id
        );
    }
}
