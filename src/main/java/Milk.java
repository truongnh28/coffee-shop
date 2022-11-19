public class Milk extends Topping{
    @Override
    public Topping setValue(int cost) {
        this.description = "Milk";
        this.cost = cost;
        return this;
    }
}
