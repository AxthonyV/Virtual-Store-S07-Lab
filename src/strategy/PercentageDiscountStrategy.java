package strategy;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }
    @Override
    public double applyDiscount(double total) {
        double descuento = total * percentage / 100;
        System.out.println("Descuento del " + percentage + "%: -S/ " + descuento);
        return total - descuento;
    }
}