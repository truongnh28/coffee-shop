public class BeverageFactory {
    public static Beverage getBeverage(BeverageType beverageType) {
        if(beverageType == BeverageType.AMERICANO) {
            return new Americano();
        } else if(beverageType == BeverageType.CAPPUCCINO) {
            return new Cappuccino();
        } else {//if(beverageType == BeverageType.ESPRESSO) {
            return new Espresso();
        }
    }
}
