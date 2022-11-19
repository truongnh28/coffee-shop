import java.util.Scanner;

public class Customer {
    private final String name;
    private final String phoneNumber;
    private final String address;

    Customer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter customer name: ");
        String customerName = sc.nextLine();
        System.out.println("Please enter customer phone number:  ");
        String customerPhoneNumber = sc.nextLine();
        System.out.println("Please enter customer address: ");
        String customerAddress = sc.nextLine();
        this.name = customerName;
        this.phoneNumber = customerPhoneNumber;
        this.address = customerAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
}
