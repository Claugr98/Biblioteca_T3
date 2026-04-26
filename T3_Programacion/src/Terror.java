public class Terror extends Libro {
    private int calificacion;
    public Terror(String titulo, String autor, int pag, String isbn, int cal) {
        super(titulo, autor, pag, isbn);
        this.calificacion = cal;
    }
}

