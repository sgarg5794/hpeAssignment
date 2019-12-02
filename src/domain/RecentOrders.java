package domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class RecentOrders {

    private int nextOrderNumber=1;
    private LinkedList<Order> orderList;

    public RecentOrders(){
        orderList=new LinkedList<>();
    }

    public int getNextOrderNumber() {
        return nextOrderNumber;
    }

    public Order placeOrder(Order order){
        order.setOrderNumber(this.nextOrderNumber);
        orderList.add(order);
        this.nextOrderNumber++;
        //delete orders oder than 1 hr
        removeOrderOlderThanOneHour();
        return order;
    }

    private void removeOrderOlderThanOneHour() {
        Duration duration = Duration.between(this.orderList.getFirst().getOrderTime(), LocalDateTime.now());
        if(duration.getSeconds()>3600){
            this.orderList.removeFirst();
        }
    }

    public int getTotalNumberOfRiceBowlsWithChicken(){

        this.removeOrderOlderThanOneHour();
        int[] totalNumberOfRiceBowlsWithChicken=new int[1];

        this.orderList.forEach(order->{
            if(order.getRiceBowl().getMeat().isChicken(order)){
                totalNumberOfRiceBowlsWithChicken[0]++;
            }
        });
        return totalNumberOfRiceBowlsWithChicken[0];
    }

    public int getTotalNumberOfRiceBowlsWithBeef(){

        this.removeOrderOlderThanOneHour();
        int[] totalNumberOfRiceBowlsWithBeef=new int[1];

        this.orderList.forEach(order->{
            if(order.getRiceBowl().getMeat().isBeef(order)){
                totalNumberOfRiceBowlsWithBeef[0]++;
            }
        });
        return totalNumberOfRiceBowlsWithBeef[0];
    }

    public int getTotalNumberOfRiceBowlsWithMixVegetables(){
        this.removeOrderOlderThanOneHour();
        int[] totalNumberOfRiceBowlsWithMixVegetable=new int[1];

        this.orderList.forEach(order->{
            if(order.getRiceBowl().getAddOns().contains("mixveg")){
                totalNumberOfRiceBowlsWithMixVegetable[0]++;
            }
        });
        return totalNumberOfRiceBowlsWithMixVegetable[0];
    }
    public int getTotalNumberOfOrders(){
        this.removeOrderOlderThanOneHour();
        return this.orderList.size();
    }

    public int getTotalCostOfAllOrders(){
        this.removeOrderOlderThanOneHour();
        int[] totalCostOfAllOrders=new int[1];

        this.orderList.forEach(order->{
           totalCostOfAllOrders[0]+=order.getPrice();
        });
        return totalCostOfAllOrders[0];
    }
}
