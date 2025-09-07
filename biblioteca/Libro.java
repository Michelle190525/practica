 public class Libro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    public Libro(String isbn, String titulo, String autor, String categoria) {
        if (isbn == null || isbn.isEmpty() ||
            titulo == null || titulo.isEmpty() ||
            autor == null || autor.isEmpty() ||
            categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("Ningún campo puede ser nulo o vacío");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return String.format("[%s] \"%s\" por %s (%s)", isbn, titulo, autor, categoria);
    }
}

