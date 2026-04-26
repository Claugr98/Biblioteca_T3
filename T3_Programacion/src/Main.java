import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca miBiblio = new Biblioteca("Municipal", "Laura G.");
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Construir catálogo");
            System.out.println("2. Añadir libro");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Borrar libro");
            System.out.println("5. Ver catálogo completo");
            System.out.println("6. Exportar y Salir");
            System.out.print("Selecciona una opción: ");

            try {
                int op = Integer.parseInt(sc.nextLine());
                switch (op) {
                    case 1 -> {
                        System.out.print("Introduce capacidad: ");
                        miBiblio.construirCatalogo(Integer.parseInt(sc.nextLine()));
                    }
                    case 2 -> {
                        System.out.println("\nTipo de libro:");
                        System.out.println("1. Terror");
                        System.out.println("2. Comedia");
                        System.out.println("3. Policiaca");
                        System.out.println("4. Ensayo");
                        System.out.print("Opción: ");
                        int t = Integer.parseInt(sc.nextLine());

                        System.out.print("Título: "); String tit = sc.nextLine();
                        System.out.print("Autor: "); String aut = sc.nextLine();
                        System.out.print("Páginas: "); int p = Integer.parseInt(sc.nextLine());
                        System.out.print("ISBN: "); String is = sc.nextLine();

                        if(t == 1) {
                            System.out.print("Calificación (1-10): ");
                            int cal = Integer.parseInt(sc.nextLine());
                            miBiblio.agregarLibro(new Terror(tit, aut, p, is, cal));
                        } else if(t == 2) {
                            System.out.print("Tipo de humor: ");
                            String humor = sc.nextLine();
                            miBiblio.agregarLibro(new Comedia(tit, aut, p, is, humor));
                        } else if(t == 3) {
                            System.out.print("Trama (1. Misterio / 2. Intriga): ");
                            int tr = Integer.parseInt(sc.nextLine());
                            Policiaca.Trama trama = (tr == 1) ? Policiaca.Trama.MISTERIO : Policiaca.Trama.INTRIGA;
                            System.out.print("Personaje: ");
                            String per = sc.nextLine();
                            miBiblio.agregarLibro(new Policiaca(tit, aut, p, is, trama, per));
                        } else {
                            miBiblio.agregarLibro(new Ensayo(tit, aut, p, is));
                        }
                    }
                    case 3 -> {
                        System.out.print("Introduce ISBN a buscar: ");
                        miBiblio.buscarLibro(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Introduce ISBN a borrar: ");
                        miBiblio.sacarLibro(sc.nextLine());
                    }
                    case 5 -> miBiblio.mostrarCatalogo();
                    case 6 -> {
                        miBiblio.exportarAFichero("libros.obj");
                        salir = true;
                    }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}


