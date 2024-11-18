package udla.PvillotaMtorresMcuevaDruiz.inventario;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class Usuario {
    private static ArrayList<Integer> idsGenerados = new ArrayList();
    private static ArrayList<Usuario> usuarios = new ArrayList();


    private int id = generarId();
    private String nombre;
    private String apellido;
    private String telefono;

    public Usuario(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        usuarios.add(this);
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    private static int generarId() {
        Random random = new Random();

        int idRandom;
        do {
            idRandom = 1000 + random.nextInt(701);
        } while(idsGenerados.contains(idRandom));

        idsGenerados.add(idRandom);
        return idRandom;
    }

    public static Usuario crearUsuario(String nombre, String apellido, String telefono) {
        return new Usuario(nombre, apellido, telefono);
    }

    public static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios");
        } else {
            System.out.println("\n=== Lista de Usuarios ===");
            Iterator var0 = usuarios.iterator();

            while(var0.hasNext()) {
                Usuario usuario = (Usuario)var0.next();
                PrintStream var10000 = System.out;
                int var10001 = usuario.getId();
                var10000.println("ID: " + var10001 + ", Nombre: " + usuario.getNombre() + ", Apellido: " + usuario.getApellido() + ", Teléfono: " + usuario.getTelefono());
            }
        }

    }

    public static void imprimirInfoUsuarioPorId(int id) {
        Iterator var1 = usuarios.iterator();

        Usuario usuario;
        do {
            if (!var1.hasNext()) {
                System.out.println("No se encontró un usuario con el ID: " + id);
                return;
            }

            usuario = (Usuario)var1.next();
        } while(usuario.getId() != id);

        PrintStream var10000 = System.out;
        String var10001 = usuario.getNombre();
        var10000.println("Nombre: " + var10001 + ", Apellido: " + usuario.getApellido() + ", Teléfono: " + usuario.getTelefono());
    }


}
