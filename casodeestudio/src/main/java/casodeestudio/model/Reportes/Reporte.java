package casodeestudio.model.Reportes;

public class Reporte {
	private double totalVentas;
	private int cantidadPedidos;

	public Reporte() {
		this.totalVentas = 0;
		this.cantidadPedidos = 0;
	}

	public void registrarPedido(double totalPedido) {
		if (totalPedido <= 0) {
			return;
		}
		totalVentas += totalPedido;
		cantidadPedidos++;
	}

	public void mostrarReporte() {
		System.out.println("===== REPORTE DE VENTAS =====");
		System.out.println("Cantidad de pedidos realizados: " + cantidadPedidos);
		System.out.println("Total de ventas: $" + totalVentas);
	}

	public double getTotalVentas() {
		return totalVentas;
	}

	public int getCantidadPedidos() {
		return cantidadPedidos;
	}
}
