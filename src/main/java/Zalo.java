public class Zalo implements AppChat{
    @Override
    public void update(String message) {
        System.out.println("Zalo: \n" + message);
    }
}
