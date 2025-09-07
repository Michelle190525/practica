import java.util.*;

public class Biblioteca {
    private final Map<String, Libro> catalogoPorIsbn;
    private final Map<String, Usuario> usuariosPorId;
    private final Set<String> isbnsPrestados;

    public Biblioteca() {
        catalogoPorIsbn = new HashMap<>();
        usuariosPorId = new HashMap<>();
        isbnsPrestados = new HashSet<>();
    }

    public void añadirLibro(Libro libro) {
        catalogoPorIsbn.put(libro.getIsbn(), libro);
    }

    public void quitarLibro(String isbn) {
        if (!isbnsPrestados.contains(isbn)) {
            catalogoPorIsbn.remove(isbn);
        } else {
            System.out.println("No se puede quitar un libro prestado.");
        }
    }

    public void registrarUsuario(Usuario u) {
        usuariosPorId.put(u.getId(), u);
    }

    public void darBajaUsuario(String id) {
        Usuario u = usuariosPorId.get(id);
        if (u != null && u.getIsbnsPrestados().isEmpty()) {
            usuariosPorId.remove(id);
        } else {
            System.out.println("No se puede dar de baja un usuario con libros prestados.");
        }
    }

    public void prestarLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = catalogoPorIsbn.get(isbn);
        if (usuario == null || libro == null) {
            System.out.println("Usuario o libro no existe.");
            return;
        }
        if (isbnsPrestados.contains(isbn)) {
            System.out.println("Libro ya está prestado.");
            return;
        }
        usuario.getIsbnsPrestados().add(isbn);
        isbnsPrestados.add(isbn);
    }

    public void devolverLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        if (usuario != null && usuario.getIsbnsPrestados().remove(isbn)) {
            isbnsPrestados.remove(isbn);
        } else {
            System.out.println("El usuario no tenía prestado ese libro.");
        }
    }

    public List<Libro> buscarPorTitulo(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> buscarPorAutor(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getAutor().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> buscarPorCategoria(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getCategoria().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> listarPrestados(String idUsuario) {
        List<Libro> prestados = new ArrayList<>();
        Usuario u = usuariosPorId.get(idUsuario);
        if (u != null) {
            for (String isbn : u.getIsbnsPrestados()) {
                Libro libro = catalogoPorIsbn.get(isbn);
                if (libro != null) {
                    prestados.add(libro);
                }
            }
        }
        return prestados;
    }
}
 
