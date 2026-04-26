public class Comedia extends Libro {
    private String tipoHumor;
    public Comedia(String titulo, String autor, int pag, String isbn, String humor) {
        super(titulo, autor, pag, isbn);
        this.tipoHumor = humor;
    }
}
