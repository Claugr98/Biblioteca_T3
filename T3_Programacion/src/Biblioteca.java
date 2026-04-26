import java.io.*;

public class Biblioteca {
    private String nombre;
    private String director;
    private Catalogo catalogo;

    private class Catalogo implements Serializable {
        private Libro[] listaLibros;
        private int contador = 0;
        public Catalogo(int capacidad) { this.listaLibros = new Libro[capacidad]; }
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

    public void construirCatalogo(int cantidad) {
        this.catalogo = new Catalogo(cantidad);
        System.out.println("Catálogo creado para " + cantidad + " libros.");
    }

    public void agregarLibro(Libro libro) throws BibliotecaException {
        if (this.catalogo == null) throw new RuntimeException("Catálogo no iniciado.");
        if (catalogo.contador >= catalogo.listaLibros.length) {
            throw new BibliotecaException("Sin hueco en el catálogo para: " + libro.getIsbn());
        }
        catalogo.listaLibros[catalogo.contador++] = libro;
        System.out.println("Libro añadido con éxito.");
    }

    public void buscarLibro(String isbn) throws BibliotecaException {
        for (Libro l : catalogo.listaLibros) {
            if (l != null && l.getIsbn().equals(isbn)) {
                System.out.println("Encontrado -> " + l);
                return;
            }
        }
        throw new BibliotecaException("Libro no encontrado con ISBN: " + isbn);
    }

    public void sacarLibro(String isbn) {
        for (int i = 0; i < catalogo.listaLibros.length; i++) {
            if (catalogo.listaLibros[i] != null && catalogo.listaLibros[i].getIsbn().equals(isbn)) {
                catalogo.listaLibros[i] = null;
                System.out.println("Libro eliminado.");
                return;
            }
        }
        System.out.println("No se encontró el ISBN.");
    }

    public void mostrarCatalogo() {
        System.out.println("\n--- LISTADO ---");
        for (Libro l : catalogo.listaLibros) if (l != null) System.out.println(l);
    }

    public void exportarAFichero(String nombre) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre))) {
            oos.writeObject(catalogo.listaLibros);
            System.out.println("Fichero guardado.");
        } catch (Exception e) { System.out.println("Error al guardar."); }
    }
}
