package udla.PvillotaMtorresMcuevaDruiz.inventario;

class Libro {
    private String nombre;
    private String autor;
    private int cantidad;



    private static Libro[] libros = new Libro[10];
    private static int cantidadLibros = 0;

    public Libro(String nombre, String autor, int cantidad) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getCantidad() {
        return this.cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static void agregarLibro(String nombre, String autor, int cantidad) {
        if (cantidadLibros < libros.length) {
            libros[cantidadLibros] = new Libro(nombre, autor, cantidad);
            ++cantidadLibros;
            System.out.println("Libro agregado exitosamente.");
        } else {
            System.out.println("No se pueden agregar más libros");
        }

    }

    public static void mostrarLibros() {
        if (cantidadLibros == 0) {
            System.out.println("No hay libros en el sistema.");
        } else {
            System.out.println("\n=== Lista de Libros ===");

            for(int i = 0; i < cantidadLibros; ++i) {
                Libro libro = libros[i];
                System.out.println(i + 1 + ". Título: " + libro.getNombre() + ", Autor: " + libro.getAutor() + ", Cantidad: " + libro.getCantidad());
            }
        }

    }

    public static void comprarLibro(String nombre, int cantidadComprada) {
        for(int i = 0; i < cantidadLibros; ++i) {
            if (libros[i].getNombre().equalsIgnoreCase(nombre)) {
                if (libros[i].getCantidad() >= cantidadComprada) {
                    libros[i].setCantidad(libros[i].getCantidad() - cantidadComprada);
                    Libro var10001 = libros[i];
                    System.out.println("Compra realizada exitosamente. Cantidad restante: " + var10001.getCantidad());
                } else {
                    System.out.println("No hay suficientes unidades de " + nombre + " para realizar la compra.");
                }

                return;
            }
        }

        System.out.println("El libro " + nombre + " no se encuentra en el sistema.");
    }
}
