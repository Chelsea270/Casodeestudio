package casodeestudio.model.Pedidos;

import casodeestudio.model.Productos.Producto;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<Producto> productos;

    public Pedido() {
      productos = new ArrayList<>();
    }

    //Se agrega el producto solo si está disponible
    public void agregarProducto(Producto producto) {
        if (producto.isDisponible()) {
            productos.add(producto);
            System.out.println("Producto agregado.");
        } else {
            System.out.println("El producto no está disponible.");
        }
    }

    //Se elimina el producto por su nombre
    public void eliminarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                productos.remove(p);
                System.out.println("Producto eliminado.");
                return;
            }
        }
        System.out.println("Producto no encontrado en el pedido.");
    }

    //Se calcula el total
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public void mostrarPedido() {
        System.out.println("Productos en el pedido:");
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }
        System.out.println("Total: $" + calcularTotal());
    }
}
