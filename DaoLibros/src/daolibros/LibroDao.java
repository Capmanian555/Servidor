package daolibros;

import java.util.List;

public interface LibroDao {
    List<Libro> obtenerTodos();

    Libro obtenerPorId(int id);

    void agregar(Libro libro);

    void actualizar(Libro libro);

    void eliminar(int id);
}
