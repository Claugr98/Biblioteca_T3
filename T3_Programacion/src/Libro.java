import java.io.Serializable;

public abstract class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private String isbn;

    public Libro(String titulo, String autor, int numeroPaginas, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Autor: " + autor + " | ISBN: " + isbn + " | Páginas: " + numeroPaginas;
    }
}
