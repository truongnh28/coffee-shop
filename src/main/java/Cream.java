public class Cream extends Topping{
    @Override
    public Topping setValue(int cost) {
        this.description = "Cream";
        this.cost = cost;
        return this;
    }
}
