import adapter.*;
import model.*;
import observer.*;
import service.OrderService;
import strategy.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Tienda Virtual ===");
        Product laptop   = new Product("Laptop Dell", 2500.0);
        Product mouse    = new Product("Mouse Logitech", 150.0);
        Product teclado  = new Product("Teclado Mecanico", 350.0);

        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(teclado);

        OrderService orderService = new OrderService();
        orderService.setDiscountStrategy(new PercentageDiscountStrategy(10));
        orderService.setPaymentProcessor(new PayPalAdapter(new ExternalPayPalService()));
        orderService.addObserver(new EmailNotificationObserver());
        orderService.addObserver(new InventoryObserver());
        orderService.addObserver(new AdminNotificationObserver());
        orderService.confirmOrder(cart);

        System.out.println("\n=== Segunda Compra ===");
        Cart cart2 = new Cart();
        cart2.addProduct(new Product("Audifonos Sony", 250.0));
        cart2.addProduct(new Product("Cargador USB-C", 80.0));

        orderService.setDiscountStrategy(new FixedAmountDiscountStrategy(20));
        orderService.setPaymentProcessor(new YapePaymentProcessor());
        orderService.confirmOrder(cart2);
    }
}
