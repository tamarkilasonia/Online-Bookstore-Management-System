class NewUserDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.90; // 10% discount for new users
    }
}
