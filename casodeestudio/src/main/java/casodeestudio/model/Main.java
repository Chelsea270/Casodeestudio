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
        Reporte reporte = new Reporte();

        int opcion;

        do {
            System.out.println("===== MENÚ =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar producto");
            System.out.println("3. Crear pedido");
            System.out.println("4. Ver reporte");
            System.out.println("0. Salir");
            opcion = leerEntero(sc, "Seleccione una opción: ");

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

                    double precio = leerDouble(sc, "Precio: ");

                    boolean disponible = leerBoolean(sc, "Disponible (true/false): ");

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
                        opProd = leerEntero(sc, "Seleccione producto: ");

                        if (opProd > 0 && opProd <= productos.size()) {
                            pedido.agregarProducto(productos.get(opProd - 1));
                        } else if (opProd != 0) {
                            System.out.println("Opción de producto inválida.");
                        }

                    } while (opProd != 0);

                    pedido.mostrarPedido();

                    // PAGO
                    System.out.println("Método de pago:");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Tarjeta");
                    int metodo = leerEntero(sc, "Seleccione método: ");

                    Pago pago;

                    if (metodo == 1) {
                        pago = new PagoEfectivo();
                    } else {
                        pago = new PagoTarjeta();
                    }

                    double totalPedido = pedido.calcularTotal();
                    pago.procesarPago(totalPedido);
                    reporte.registrarPedido(totalPedido);
                    break;

                case 4:
                    reporte.mostrarReporte();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }

    private static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            try {
                return Double.parseDouble(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número válido.");
            }
        }
    }

    private static boolean leerBoolean(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim().toLowerCase();
            if ("true".equals(entrada)) {
                return true;
            }
            if ("false".equals(entrada)) {
                return false;
            }
            System.out.println("Entrada inválida. Escriba true o false.");
        }
    }
}