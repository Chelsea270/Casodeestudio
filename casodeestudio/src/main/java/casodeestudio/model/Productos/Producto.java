package casodeestudio.model.Productos;

import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private String nombre;
    private double precio;
    private boolean disponible;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(String nombre, double precio, boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Método para registrar productos
    public static ArrayList<Producto> registrarProductos() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

        System.out.print("¿Cuántos productos desea ingresar? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre del producto #" + (i+1) + ": ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el precio: ");
            double precio = sc.nextDouble();

            System.out.print("¿Está disponible? (true/false): ");
            boolean disponible = sc.nextBoolean();
            sc.nextLine(); // limpiar buffer

            Producto p = new Producto(nombre, precio, disponible);
            productos.add(p);
        }

        System.out.println("\nLista de productos registrados:");
        for (Producto p : productos) {
            System.out.println("Nombre: " + p.getNombre() +
                    ", Precio: " + p.getPrecio() +
                    ", Disponible: " + p.isDisponible());
        }

        return productos;
    }

    // Método para consultar disponibilidad de un producto por nombre
    public static boolean consultarProducto(ArrayList<Producto> productos, String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p.isDisponible(); // retorna el estado de disponibilidad
            }
        }
        return false; // si no se encuentra, se asume no disponible
    }

    // Método main para probar
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = Producto.registrarProductos();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre del producto a consultar: ");
        String consulta = sc.nextLine();

        boolean estado = Producto.consultarProducto(listaProductos, consulta);
        if (estado) {
            System.out.println("El producto está DISPONIBLE.");
        } else {
            System.out.println("El producto NO está disponible o no existe.");
        }

        sc.close();
    }
}

