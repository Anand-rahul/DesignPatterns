package org.designPatterns.Observer;


import java.util.ArrayList;
import java.util.List;

/*
Problem Statement:
The goal is to create a "Notify Me" feature similar to the one on e-commerce platforms like Amazon.
When a product is out of stock, users can subscribe to notifications (via email or SMS) to be alerted
when the product is back in stock.

Solution:
We use the Observer Design Pattern to implement this feature.
- The `StockObservable` interface represents the product's stock status.
- The `CarObservableImpl` class tracks the stock count and notifies subscribed observers when stock is added.
- Observers (`EmailAlertObserverImpl`, `MobileAlertObserverImpl`) receive notifications through their respective communication channels (email or SMS).
*/

public class ObserverDesignPattern {

    // Observable interface for stock updates
    public interface StockObservable {
        void add(NotificationAlertObserver observer);  // Add a subscriber
        void remove(NotificationAlertObserver observer); // Remove a subscriber
        void notifySubscribers(); // Notify all subscribers
        void setStockCount(int newStockAdded); // Update stock count
        int getStockCount(); // Retrieve stock count
    }

    // Concrete implementation of StockObservable
    public static class CarObservableImpl implements StockObservable {
        public List<NotificationAlertObserver> observerList = new ArrayList<>(); // List of observers
        public int stockCount = 0;

        @Override
        public void add(NotificationAlertObserver observer) {
            observerList.add(observer); // Add an observer
        }

        @Override
        public void remove(NotificationAlertObserver observer) {
            observerList.remove(observer); // Remove an observer
        }

        @Override
        public void notifySubscribers() {
            // Notify all subscribed observers
            for (var obs : observerList) {
                obs.update();
            }
        }

        @Override
        public void setStockCount(int newStockAdded) {
            // Update stock count first
            stockCount += newStockAdded;

            // Notify observers if stock was previously zero and new stock is added
            if (stockCount > 0 && newStockAdded > 0) {
                notifySubscribers();
            }
        }

        @Override
        public int getStockCount() {
            return stockCount; // Return current stock count
        }
    }

    // Observer interface
    public interface NotificationAlertObserver {
        void update(); // Action to perform when notified
    }

    // Concrete implementation of Observer for Email alerts
    public static class EmailAlertObserverImpl implements NotificationAlertObserver {
        String email; // Subscriber's email
        StockObservable observable; // Associated observable

        public EmailAlertObserverImpl(String email, StockObservable observable) {
            this.observable = observable;
            this.email = email;
        }

        @Override
        public void update() {
            // Send an email notification
            sendMail(email, "The product is now back in stock! Current stock: " + observable.getStockCount());
        }

        private void sendMail(String emailId, String msg) {
            // Simulate sending an email
            System.out.println("Email sent to: " + emailId + " with message: " + msg);
        }
    }

    // Concrete implementation of Observer for SMS alerts
    public static class MobileAlertObserverImpl implements NotificationAlertObserver {
        String userName; // Subscriber's name
        StockObservable observable; // Associated observable

        public MobileAlertObserverImpl(String userName, StockObservable observable) {
            this.userName = userName;
            this.observable = observable;
        }

        @Override
        public void update() {
            // Send an SMS notification
            sendMessage(userName, "The product is now back in stock! Current stock: " + observable.getStockCount());
        }

        private void sendMessage(String user, String msg) {
            // Simulate sending an SMS
            System.out.println("SMS sent to: " + user + " with message: " + msg);
        }
    }

    public static void main(String[] args) {
        // Observable object representing car stock
        StockObservable carStockObservable = new CarObservableImpl();

        // Observers subscribing to notifications
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("anandrahul596@example.com", carStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("anandr232596@example.com", carStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("anand543", carStockObservable);

        // Adding observers to the observable
        carStockObservable.add(observer1);
        carStockObservable.add(observer2);
        carStockObservable.add(observer3);

        // Simulating stock update
        System.out.println("Adding stock...");
        carStockObservable.setStockCount(30); // This should trigger notifications

        // Output:
        // Email sent to: anandrahul596@example.com with message: The product is now back in stock! Current stock: 30
        // Email sent to: anandr232596@example.com with message: The product is now back in stock! Current stock: 30
        // SMS sent to: anand543 with message: The product is now back in stock! Current stock: 30
    }
}
