package domain;

import java.time.LocalDateTime;

public class Order {

    private Customer customer;
    private Waiter waiter;
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    private LocalDateTime orderTime;
    private RiceBowl riceBowl;
    private int price;

    public Customer getCustomer() {
        return customer;
    }

    public RiceBowl getRiceBowl() {
        return riceBowl;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    private int orderNumber;



    public Order(Customer customer, Waiter waiter, RiceBowl riceBowl) {
        this.customer = customer;
        this.waiter = waiter;
        this.orderTime = LocalDateTime.now();
        this.riceBowl = riceBowl;
        this.price=riceBowl.getprice();
    }

    public int getPrice() {
        return price;
    }
}
