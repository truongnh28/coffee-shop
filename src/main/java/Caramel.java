public class Caramel extends Topping{
    @Override
    public Topping setValue(int cost) {
        this.description = "Caramel";
        this.cost = cost;
        return this;
    }
}
