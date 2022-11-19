import java.io.FileNotFoundException;
import java.util.*;

public class OrderService {
    public List<Beverage> drinks;
    public State state;
    public int discount;
    public Customer customer;
    public AppChatManagement appChatManagement;
    Map<BeverageType, Beverage> beverages;
    Map<ToppingType, Topping> toppings;
    Map<String, Integer> discountCode;
    Map<AppChatType, AppChat> appChats;
    OrderService() throws FileNotFoundException {
        drinks = new ArrayList<>();
        appChatManagement = new AppChatManagement();
        state = State.ORDERING;
        this.beverages = DAO.getBeveragePrice();
        this.toppings = DAO.getToppingPrice();
        this.discountCode = DAO.getDiscount();
        this.appChats = new HashMap<>();
        appChats.put(AppChatType.ZALO, new Zalo());
        appChats.put(AppChatType.TELEGRAM, new Telegram());
    }
    public void setState (State state) {
        this.state = state;
    }
    public void addBeverage(Beverage beverage) {
        drinks.add(beverage);
    }
    public List<Beverage> getDrinks() {
        return drinks;
    }
    public int payment() {
        int cost = 0;
        for(Beverage beverage : drinks) {
            cost += beverage.getCost();
        }
        return Math.max(cost - discount, 0);
    }
    public String getBill() {
        StringBuilder bill = new StringBuilder("-------------------------------------------\n                    BILL                    \n" + "Customer: \n" + "Name: " + customer.getName() + "\nPhone Number: " + customer.getPhoneNumber() + "\nAddress: " + customer.getAddress() + "\n");
        bill.append("Drinks: \n");
        int idx = 0;
        for(Beverage beverage:drinks) {
            bill.append(String.valueOf(idx + 1)).append(". ").append(beverage.getDescription());
            idx++;
        }
        bill.append("Cost: ").append(payment());
        return bill.toString() + "\n-------------------------------------------";
    }
    public void createOrder() {
        Scanner sc = new Scanner(System.in);
        this.customer = new Customer();
        System.out.println("Please enter your discount: ");
        String discountCodeStr = sc.nextLine();
        this.discount = discountCode.getOrDefault(discountCodeStr, 0);
        this.appChatManagement.addAppChat(appChats.get(AppChatType.ZALO));
        this.appChatManagement.addAppChat(appChats.get(AppChatType.TELEGRAM));
        this.setState(State.ORDERING);
        this.changeState();

        while(true) {
            Beverage item;
            System.out.println("--------------MENU--------------");
            System.out.println("1. CAPPUCCINO: " + beverages.get(BeverageType.CAPPUCCINO).getCostBeverage());
            System.out.println("2. ESPRESSO  : " + beverages.get(BeverageType.ESPRESSO).getCostBeverage());
            System.out.println("3. AMERICANO : " + beverages.get(BeverageType.AMERICANO).getCostBeverage());
            System.out.println("4. Complete   ");
            System.out.println("--------------------------------");
            System.out.println("Pleas choose a drink!");
            int choose = sc.nextInt();
            if(choose == 4) {
                this.setState(State.PROCESSING);
                this.changeState();
                DAO.latency("Processing");
                this.setState(State.DELIVERING);
                this.changeState();
                DAO.latency("Delivering");
                this.setState(State.DONE);
                System.out.println("Done");
                this.changeState();
                System.out.println(this.getBill());
                boolean isContinue = true;
                while (true) {
                    System.out.println("Would you like to order more?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    choose = sc.nextInt();
                    if(choose != 2 && choose != 1) {
                        continue;
                    }
                    isContinue = choose == 1;
                    break;
                }
                if(isContinue) {
                    drinks.clear();
                    continue;
                }
                else {
                    System.out.println("Thanks");
                    break;
                }
            } else if(choose == 1) {
                item = BeverageFactory.getBeverage(BeverageType.CAPPUCCINO)
                        .setPrice(beverages.get(BeverageType.CAPPUCCINO)
                                .getCostBeverage());
            } else if(choose == 2) {
                item = BeverageFactory.getBeverage(BeverageType.ESPRESSO)
                        .setPrice(beverages.get(BeverageType.ESPRESSO)
                                .getCostBeverage());
            } else if(choose == 3) {
                item = BeverageFactory.getBeverage(BeverageType.AMERICANO)
                        .setPrice(beverages.get(BeverageType.AMERICANO)
                                .getCostBeverage());
            } else {
                System.out.println("Please choose");
                continue;
            }
            while(true) {
                System.out.println(item.getDescription());
                System.out.println("------------TOPPINGS------------");
                System.out.println("1. CREAM  : " + toppings.get(ToppingType.CREAM).getCost());
                System.out.println("2. CARAMEL: " + toppings.get(ToppingType.CARAMEL).getCost());
                System.out.println("3. MILK   : " + toppings.get(ToppingType.MILK).getCost());
                System.out.println("4. Complete");
                System.out.println("--------------------------------");
                System.out.println("Pleas choose a topping!");
                choose = sc.nextInt();
                if(choose == 1) {
                    item.addTopping(toppings.get(ToppingType.CREAM));
                } else if (choose == 2) {
                    item.addTopping(toppings.get(ToppingType.CARAMEL));
                } else if(choose == 3) {
                    item.addTopping(toppings.get(ToppingType.MILK));
                } else if(choose == 4) {
                    this.addBeverage(item);
                    break;
                } else {
                    System.out.println("Please choose");
                }
            }
        }
    }
    public void changeState() {
        appChatManagement.notifyChat(state, getBill());
    }
}
