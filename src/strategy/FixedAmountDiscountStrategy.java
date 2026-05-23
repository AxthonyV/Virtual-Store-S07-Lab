package strategy;

public class FixedAmountDiscountStrategy implements DiscountStrategy {
    private double amount;

    public FixedAmountDiscountStrategy(double amount) {
        this.amount = amount;
    }
    @Override
    public double applyDiscount(double total) {
        System.out.println("Descuento fijo de: -S/ " + amount);
        if (total < amount) return 0;
        return total - amount;
    }
}
