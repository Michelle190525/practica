import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Registro de usuarios
        biblioteca.registrarUsuario(new Usuario("U1", "Ana"));
        biblioteca.registrarUsuario(new Usuario("U2", "Luis"));

        // Agregar libros
        biblioteca.añadirLibro(new Libro("ISBN-001", "Clean Code", "Robert C. Martin", "Software"));
        biblioteca.añadirLibro(new Libro("ISBN-002", "Effective Java", "Joshua Bloch", "Java"));

        // Préstamos
        biblioteca.prestarLibro("U1", "ISBN-001");
        biblioteca.prestarLibro("U2", "ISBN-002");

        // Libros prestados por U1
        System.out.println("Libros prestados por Ana:");
        imprimirLista(biblioteca.listarPrestados("U1"));

        // Devolver libro
        biblioteca.devolverLibro("U1", "ISBN-001");

        // Buscar por autor
        System.out.println("\nBuscar libros por autor 'Bloch':");
        imprimirLista(biblioteca.buscarPorAutor("Bloch"));

        // Buscar por categoría
        System.out.println("\nBuscar libros por categoría 'Software':");
        imprimirLista(biblioteca.buscarPorCategoria("Software"));
    }

    private static void imprimirLista(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}
 
