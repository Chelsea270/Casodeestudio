package casodeestudio.model.Pagos;

public class PagoTarjeta implements Pago{
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con tarjeta realizado por $" + monto);
    }
}
