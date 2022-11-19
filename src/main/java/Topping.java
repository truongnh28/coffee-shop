public abstract class Topping {
    public String description = "";
    public int cost = 0;
    public abstract Topping setValue(int cost);
    public String getDescription() {
        return description;
    }
    public int getCost() {
        return cost;
    }
}
