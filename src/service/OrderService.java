package service;

import adapter.PaymentProcessor;
import model.Cart;
import observer.OrderObserver;
import strategy.DiscountStrategy;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private DiscountStrategy discountStrategy;
    private PaymentProcessor paymentProcessor;
    private List<OrderObserver> observers = new ArrayList<>();

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }
    public void setPaymentProcessor(PaymentProcessor processor) {
        this.paymentProcessor = processor;
    }
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }
    public void confirmOrder(Cart cart) {
        double total = cart.getTotal();
        System.out.println("\nTotal antes del descuento: S/ " + total);

        double finalTotal = discountStrategy.applyDiscount(total);

        System.out.println("Total a pagar: S/ " + finalTotal);
        paymentProcessor.pay(finalTotal);

        System.out.println("Compra confirmada por S/ " + finalTotal);

        String mensaje = "Compra por S/ " + finalTotal + " confirmada.";
        for (OrderObserver o : observers) {
            o.update(mensaje);
        }
    }
}
