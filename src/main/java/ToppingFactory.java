public class ToppingFactory {
    public static Topping getTopping(ToppingType toppingType) {
        if(toppingType == ToppingType.CARAMEL) {
            return new Caramel();
        } else if(toppingType == ToppingType.CREAM) {
            return new Cream();
        } else{// if(toppingType == ToppingType.MILK) {
            return new Milk();
        }
    }
}
