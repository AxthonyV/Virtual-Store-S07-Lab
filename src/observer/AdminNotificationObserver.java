package observer;

public class AdminNotificationObserver implements OrderObserver {
    @Override
    public void update(String message) {
        System.out.println("[Admin] Nueva orden registrada: " + message);
    }
}
