package adapter;

public class ExternalPayPalService {
    public void makePayment(String currency, double amount) {
        System.out.println("PayPal: pago de " + currency + " " + amount + " procesado.");
    }
}
