import java.util.ArrayList;
import java.util.List;

public class AppChatManagement {
    public List<AppChat> appChatList = new ArrayList<>();
    public void addAppChat(AppChat appChat) {
        if(appChatList.contains(appChat)) return;
        appChatList.add(appChat);
    }
    public void removeAppChat(AppChat appChat) {
        appChatList.remove(appChat);
    }
    public void notifyChat(State state, String bill) {
        String message = "";
        if(state == State.ORDERING) {
            message = "Your order is being prepared";
        } else if(state == State.PROCESSING) {
            message = "Your order is being processed";
        } else if(state == State.DELIVERING) {
            message = "Your order is being delivered";
        } else if(state == State.DONE) {
            message = "Your order has been completed\n" + bill;
        }
        for(AppChat appChat:appChatList) {
            appChat.update(message);
        }
    }
}
