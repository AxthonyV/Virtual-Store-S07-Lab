package adapter;

public class PayPalAdapter implements PaymentProcessor {
    private ExternalPayPalService paypal;

    public PayPalAdapter(ExternalPayPalService paypal) {
        this.paypal = paypal;
    }
    @Override
    public void pay(double amount) {
        paypal.makePayment("PEN", amount);
    }
}
