package util;

import domain.Order;
import domain.RecentOrders;

public class PrintHelper {
    
    public void printRecentOrders(RecentOrders recentOrders){
        System.out.println("------------------------------------------------------");
        System.out.format("%32s\n","Orders Report");
        System.out.println("------------------------------------------------------");
        System.out.println("Orders in past 1 hour:");
        System.out.println("      Total Number of Orders:"+recentOrders.getTotalNumberOfOrders());
        System.out.println("      Total Number Of RiceBowl Order with Beef:"+recentOrders.getTotalNumberOfRiceBowlsWithBeef());
        System.out.println("      Total Number Of RiceBowl Order with MixVegetables:"+recentOrders.getTotalNumberOfRiceBowlsWithMixVegetables());
        System.out.println("      Total Number Of RiceBowl Order with Chicken:"+recentOrders.getTotalNumberOfRiceBowlsWithChicken());
        System.out.println("Total Sale in last one hour:"+recentOrders.getTotalCostOfAllOrders()+"$");
        System.out.println();
    }

    public void printOrderDetails(Order order) {
        System.out.println("------------------------------------------------------");
        System.out.format("%32s\n","Order Number:"+order.getOrderNumber());
        System.out.println("------------------------------------------------------");
        System.out.println("Customer Details:");
        System.out.println("      Customer Name:"+order.getCustomer().getName());
        System.out.println("      Customer Emailid:"+order.getCustomer().getEmailId());
        System.out.println("      Customer PhoneNumber:"+order.getCustomer().getPhoneNumber());
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Rice Bowl:");
        System.out.println("  Meat:"+order.getRiceBowl().getMeat());
        System.out.println("  Rice:"+order.getRiceBowl().getRice());
        System.out.println("  Sauce:"+order.getRiceBowl().getSauce());
        if(order.getRiceBowl().getAddOns().size()!=0){
            System.out.println("AddOns:");
            for(String addOn:order.getRiceBowl().getAddOns()){
                System.out.println("  "+addOn);

            }
        }
        int orderPrice=order.getPrice();
        System.out.println("Total Price:"+orderPrice+"$");
        System.out.println();
    }
}
