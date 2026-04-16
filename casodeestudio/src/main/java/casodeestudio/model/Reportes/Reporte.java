package casodeestudio.model.Reportes;

import casodeestudio.model.Pedidos.Pedido;

import java.util.ArrayList;

public class Reporte {
    private ArrayList<Pedido> pedidos;

    public Reporte() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    //Calcula el total de ventas
    public double totalVentas() {
        double total = 0;
        for (Pedido p : pedidos) {
            total += p.calcularTotal();
        }
        return total;
    }

    public int cantidadPedidos() {
        return  pedidos.size();
    }

    public void mostrarReporte() {
        System.out.println("--- REPORTE ---");
        System.out.println("Total ventas: $" + totalVentas());
        System.out.println("Cantidad de pedidos: " + cantidadPedidos());
    }
}
