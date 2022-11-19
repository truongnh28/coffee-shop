public class Telegram implements AppChat{
    @Override
    public void update(String message) {
        System.out.println("Telegram: \n" + message);
    }
}
