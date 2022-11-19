import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String []args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Please enter login name: ");
            String userName = sc.nextLine();
            System.out.println("Please enter password: ");
            String password = sc.nextLine();
            if(DAO.checkLogin(userName, password)) {
                System.out.println("Login success");
                break;
            }
            System.out.println("Login Fail");
        }
        OrderService orderService = new OrderService();
        orderService.createOrder();
    }
}
