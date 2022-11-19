import java.util.ArrayList;
import java.util.List;

public abstract class Beverage {
    public String description = "";
    public int costBeverage = 0;
    public List<Topping> toppings = new ArrayList<>();
    public abstract Beverage setPrice(int cost);
    public String getDescription() {
        StringBuilder descriptionTopping = new StringBuilder("Beverage: " + description);
        if(toppings.size() > 0) {
            descriptionTopping.append( "\nTopping: ");
            for (Topping topping : toppings) {
                descriptionTopping.append(" ").append(topping.getDescription());
            }
        }
        return descriptionTopping.toString() + '\n';
    }
    public int getCostBeverage() {
        return costBeverage;
    }
    public void setCostBeverage(int cost) {
        this.costBeverage = cost;
    }
    public int getCost() {
        int costTopping = 0;
        for(Topping topping : toppings) {
            costTopping += topping.getCost();
        }
        return costTopping + getCostBeverage();
    }
    public List<Topping> getToppings() {
        return toppings;
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }
}
