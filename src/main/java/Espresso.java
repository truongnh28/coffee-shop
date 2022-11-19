public class Espresso extends Beverage{
    @Override
    public Beverage setPrice(int cost) {
        this.description = "Espresso";
        this.costBeverage = cost;
        return this;
    }
}
