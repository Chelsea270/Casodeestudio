package casodeestudio.model.Pagos;

public class PagoEfectivo implements Pago{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago en efectivo realizado por $" + monto);
    }
}
