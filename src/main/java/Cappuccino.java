public class Cappuccino extends Beverage{
    @Override
    public Beverage setPrice(int cost) {
        this.description = "Cappuccino";
        this.costBeverage = cost;
        return this;
    }
}
