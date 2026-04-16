package casodeestudio.model;

import casodeestudio.model.Clientes.Cliente;
import casodeestudio.model.Productos.Producto;
import casodeestudio.model.Pedidos.Pedido;
import casodeestudio.model.Pagos.*;
import casodeestudio.model.Reportes.Reporte;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();

        int opcion;

        do {
            System.out.println("===== MENÚ =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar producto");
            System.out.println("3. Crear pedido");
            System.out.println("4. Ver reporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    clientes.add(new Cliente(nombre, direccion, telefono));
                    System.out.println("Cliente registrado.");
                    break;

                case 2:
                    System.out.print("Nombre del producto: ");
                    String nomProd = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Disponible (true/false): ");
                    boolean disponible = sc.nextBoolean();
                    sc.nextLine();

                    productos.add(new Producto(nomProd, precio, disponible));
                    System.out.println("Producto registrado.");
                    break;

                case 3:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                        break;
                    }

                    Pedido pedido = new Pedido();
                    int opProd;

                    do {
                        System.out.println("--- PRODUCTOS DISPONIBLES ---");
                        for (int i = 0; i < productos.size(); i++) {
                            Producto p = productos.get(i);
                            System.out.println((i + 1) + ". " + p.getNombre() +
                                    " - $" + p.getPrecio() +
                                    " - Disponible: " + p.isDisponible());
                        }

                        System.out.println("0. Terminar pedido");
                        System.out.print("Seleccione producto: ");
                        opProd = sc.nextInt();

                        if (opProd > 0 && opProd <= productos.size()) {
                            pedido.agregarProducto(productos.get(opProd - 1));
                        }

                    } while (opProd != 0);

                    pedido.mostrarPedido();

                    // PAGO
                    System.out.println("Método de pago:");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    int metodo = sc.nextInt();

                    Pago pago;

                    if (metodo == 1) {
                        pago = new PagoEfectivo();
                    } else {
                        pago = new PagoTarjeta();
                    }

                    pago.procesarPago(pedido.calcularTotal());

                    //reporte
                    break;

                case 4:
                    //Reporte
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}