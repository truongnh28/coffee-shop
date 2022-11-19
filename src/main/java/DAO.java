import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    public static boolean checkLogin(String userName, String password) throws FileNotFoundException {
        Map<String, String> login = new HashMap<>();
        String url = "/home/truongnh3/Downloads/coffee-vng/src/main/java/data/login.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner sc = new Scanner(fileInputStream);
        try {
            while(sc.hasNextLine()) {
                String t = sc.nextLine();
                login.put(t.split(" ")[0], t.split(" ")[1]);
            }
        } finally {
            try {
                sc.close();
                fileInputStream.close();
            } catch (IOException e) {
                Logger.getLogger(ReadOnlyFileSystemException.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        for(Map.Entry<String, String> item : login.entrySet()) {
            if(item.getKey().equals(userName) && item.getValue().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static Map<String, Integer> getDiscount() throws FileNotFoundException {
        Map<String, Integer> discount = new HashMap<>();
        String url = "/home/truongnh3/Downloads/coffee-vng/src/main/java/data/discount.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner sc = new Scanner(fileInputStream);
        try {
            while(sc.hasNextLine()) {
                String t = sc.nextLine();
                discount.put(t.split(" ")[0], Integer.parseInt(t.split(" ")[1]));
            }
        } finally {
            try {
                sc.close();
                fileInputStream.close();
            } catch (IOException e) {
                Logger.getLogger(ReadOnlyFileSystemException.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return discount;
//        for(Map.Entry<String, Integer> item : discount.entrySet()) {
//            if(item.getKey().equals(code)) {
//                return item.getValue();
//            }
//        }
//        return 0;
    }
    public static Map<BeverageType, Beverage> getBeveragePrice() throws FileNotFoundException {
        Map<BeverageType, Beverage> price = new HashMap<>();
        String url = "/home/truongnh3/Downloads/coffee-vng/src/main/java/data/beverage.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner sc = new Scanner(fileInputStream);
        try {
            while(sc.hasNextLine()) {
                String t = sc.nextLine();
                BeverageType beverageType = BeverageType.AMERICANO;
                switch (t.split(" ")[0]) {
                    case "CAPPUCCINO":
                        beverageType = BeverageType.CAPPUCCINO;
                        break;
                    case "ESPRESSO":
                        beverageType = BeverageType.ESPRESSO;
                        break;
                    case "AMERICANO":
                        break;
                }
                price.put(beverageType, BeverageFactory.getBeverage(beverageType).setPrice(Integer.parseInt(t.split(" ")[1])));
            }
        } finally {
            try {
                sc.close();
                fileInputStream.close();
            } catch (IOException e) {
                Logger.getLogger(ReadOnlyFileSystemException.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return price;
    }
    public static Map<ToppingType, Topping> getToppingPrice() throws FileNotFoundException {
        Map<ToppingType, Topping> price = new HashMap<>();
        String url = "/home/truongnh3/Downloads/coffee-vng/src/main/java/data/toppings.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner sc = new Scanner(fileInputStream);
        try {
            while(sc.hasNextLine()) {
                String t = sc.nextLine();
                ToppingType toppingType = ToppingType.CARAMEL;
                switch (t.split(" ")[0]) {
                    case "CREAM":
                        toppingType = ToppingType.CREAM;
                        break;
                    case "MILK":
                        toppingType = ToppingType.MILK;
                        break;
                    case "CARAMEL":
                        break;
                }
                price.put(toppingType, ToppingFactory.getTopping(toppingType).setValue(Integer.parseInt(t.split(" ")[1])));
            }
        } finally {
            try {
                sc.close();
                fileInputStream.close();
            } catch (IOException e) {
                Logger.getLogger(ReadOnlyFileSystemException.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return price;
    }
    public static void latency(String message) {
        try {
            int i = 0;
            System.out.println(message);
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
            System.out.println();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
