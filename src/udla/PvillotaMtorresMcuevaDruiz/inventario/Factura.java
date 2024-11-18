package udla.PvillotaMtorresMcuevaDruiz.inventario;

import java.util.ArrayList;
import java.util.Iterator;

class Factura {
    private static ArrayList<Factura> facturasGuardadas = new ArrayList();
    private String nombreLibro;


    private int cantidadComprada;
    private int idUsuario;

    public Factura(int idUsuario, String nombreLibro, int cantidadComprada) {
        this.idUsuario = idUsuario;
        this.nombreLibro = nombreLibro;
        this.cantidadComprada = cantidadComprada;
    }

    public void generarFactura() {
        System.out.println("--- Factura ---");
        System.out.println("\nInformación del Usuario:");
        Usuario.imprimirInfoUsuarioPorId(this.idUsuario);
        System.out.println("\nInformación de la Compra:");
        Libro.comprarLibro(this.nombreLibro, this.cantidadComprada);
        facturasGuardadas.add(this);
        System.out.println("Factura generada y guardada exitosamente.");
    }

    public static void mostrarFacturas() {
        if (facturasGuardadas.isEmpty()) {
            System.out.println("No hay facturas guardadas.");
        } else {
            System.out.println("\n=== Facturas Guardadas ===");
            Iterator var0 = facturasGuardadas.iterator();

            while(var0.hasNext()) {
                Factura factura = (Factura)var0.next();
                System.out.println("Usuario ID: " + factura.idUsuario + ", Libro: " + factura.nombreLibro + ", Cantidad Comprada: " + factura.cantidadComprada);
                System.out.println("Detalles del Usuario:");
                Usuario.imprimirInfoUsuarioPorId(factura.idUsuario);
                System.out.println("--------------------------------------");
            }
        }

    }

    public static void buscarFactura(int idUsuario) {
        int contadorBusqueda = 0;
        Iterator var2 = facturasGuardadas.iterator();

        while(var2.hasNext()) {
            Factura factura = (Factura)var2.next();
            if (factura.idUsuario == idUsuario) {
                System.out.println("Se ha encontrado una factura");
                System.out.println("Facturas registradas del usuario con ID: " + idUsuario);
                System.out.println("Libro: " + factura.nombreLibro + ", Cantidad Comprada: " + factura.cantidadComprada);
                ++contadorBusqueda;
            }
        }

        if (contadorBusqueda == 0) {
            System.out.println("No se encontro una factura registrada del usuario con ID:" + idUsuario);
        }

    }

    public static void GenerarFactura(int idUsuario, String nombreLibro, int cantidadComprada) {
        Factura nuevaFactura = new Factura(idUsuario, nombreLibro, cantidadComprada);
        nuevaFactura.generarFactura();
    }
}
