package udla.PvillotaMtorresMcuevaDruiz.inventario;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("=== Sistema de inventario ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Crear usuario");
            System.out.println("4. Mostrar usuarios");
            System.out.println("5. Generar factura");
            System.out.println("6. Mostrar facturas guardadas");
            System.out.println("7. Buscar facturas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese la cantidad disponible: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    Libro.agregarLibro(nombre, autor, cantidad);
                    break;
                case 2:
                    Libro.mostrarLibros();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese el apellido del usuario: ");
                    String apellidoUsuario = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del usuario: ");
                    String telefonoUsuario = scanner.nextLine();
                    Usuario.crearUsuario(nombreUsuario, apellidoUsuario, telefonoUsuario);
                    break;
                case 4:
                    Usuario.mostrarUsuarios();
                    break;
                case 5:
                    System.out.print("Ingrese el ID del usuario: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombreLibro = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a comprar: ");
                    int cantidadComprada = scanner.nextInt();
                    Factura.GenerarFactura(idUsuario, nombreLibro, cantidadComprada);
                    break;
                case 6:
                    Factura.mostrarFacturas();
                    break;
                case 7:
                    System.out.print("Ingrese el ID de un usuario para buscar sus facturas: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();
                    Factura.buscarFactura(idBuscar);
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
