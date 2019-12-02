package util;

import domain.Customer;
import domain.Order;
import domain.Waiter;

import java.io.BufferedReader;
import java.io.IOException;

public class DomainHelper {

    Validator validator=new Validator();

    public  Order createOrder(BufferedReader inputReader, Customer customer, Waiter waiter) throws IOException {
        OrderFactory orderFactory=new OrderFactory();
        String riceType,meatType,sauceType,sourCream,guacamole,mixveg;
        System.out.println("Enter Order Details:");
        while(true){
            System.out.println("enter W for white Rice or B for Brown Rice");
            riceType = inputReader.readLine();
            if(riceType.equalsIgnoreCase("w") || riceType.equalsIgnoreCase("b")){
                break;
            }else{
                System.out.println("Invalid Input ,try Again!");
            }
        }
        while(true){
            System.out.println("enter B for beef or C for Chicken");
            meatType=inputReader.readLine();
            if(meatType.equalsIgnoreCase("b") || meatType.equalsIgnoreCase("c")){
                break;
            }else{
                System.out.println("Invalid Input ,try Again!");
            }
        }
        while(true){
            System.out.println("enter SP for spicy or SW for Sweet");
            sauceType=inputReader.readLine();
            if(sauceType.equalsIgnoreCase("sp") || sauceType.equalsIgnoreCase("sw")){
                break;
            }else{
                System.out.println("Invalid Input ,try Again!");
            }
        }
        while(true){
            System.out.println("enter Y/N for sour cream");
            sourCream=inputReader.readLine();
            if(sourCream.equalsIgnoreCase("y") || sourCream.equalsIgnoreCase("n")){
                break;
            }else{
                System.out.println("Invalid Input ,try Again!");
            }
        }
        while(true){
            System.out.println("enter Y/N for guacamole");
            guacamole=inputReader.readLine();
            if(guacamole.equalsIgnoreCase("y") || guacamole.equalsIgnoreCase("n")){
                break;
            }else{
                System.out.println("Invalid Input ,try Again!");
            }
        }
        while(true){
            System.out.println("enter Y/N for mixveg");
            mixveg=inputReader.readLine();
            if(mixveg.equalsIgnoreCase("y") || mixveg.equalsIgnoreCase("n")){
                break;
            }else{
                System.out.println("Invalid Input ,try Again!");
            }
        }

        Order order=orderFactory.getOrder(riceType,meatType,sauceType,sourCream,guacamole,mixveg,customer,waiter);
        return order;
    }

    public  Customer createCustomer(BufferedReader inputReader) throws IOException{
        String customerEmailid;
        String customerPhoneNumber;
        System.out.println("Enter Customer Details:");
        System.out.println("CustomerName");
        String customerName = inputReader.readLine();


        while(true){
            System.out.println("Customer Email Id");
            customerEmailid=inputReader.readLine();
            if(validator.validateEmail(customerEmailid)){
                break;
            }else{
                System.out.println("Invalid Email id ,try Again!!");
            }
        }
        while(true) {
            System.out.println("Customer phone number");
            customerPhoneNumber = inputReader.readLine();
            if(validator.validatePhoneNumber(customerPhoneNumber)){
                break;
            }else{
                System.out.println("Invalid PhoneNumber ,try Again!!");
            }
        }
        Customer cust=new Customer(customerName,customerEmailid,customerPhoneNumber);
        return cust;
    }
}
