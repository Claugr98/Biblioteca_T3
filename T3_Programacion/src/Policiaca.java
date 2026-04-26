public class Policiaca extends Libro {
    public enum Trama { MISTERIO, INTRIGA }
    private Trama trama;
    private String personaje;

    public Policiaca(String titulo, String autor, int pag, String isbn, Trama trama, String personaje) {
        super(titulo, autor, pag, isbn);
        this.trama = trama;
        this.personaje = personaje;
    }
}


