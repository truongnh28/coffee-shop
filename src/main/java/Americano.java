public class Americano extends Beverage {
    @Override
    public Beverage setPrice(int cost) {
        this.description = "Americano";
        this.costBeverage = cost;
        return this;
    }
}
