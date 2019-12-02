package util;

import decorators.GuacamoleDecorator;
import decorators.MixVegDecorator;
import decorators.SourCreamDecorator;
import domain.Customer;
import domain.Meat;
import domain.Order;
import domain.Rice;
import domain.RiceBowl;
import domain.Sauce;
import domain.Waiter;

public class OrderFactory {

    public Order getOrder(String ricetype, String meatType, String sauceType, String sourCream, String guacamole, String mixveg,
                          Customer customer, Waiter waiter){

        if(sourCream.equalsIgnoreCase("y") && guacamole.equalsIgnoreCase("n")
                && mixveg.equalsIgnoreCase("n")){
            return new Order(
                    customer,waiter,new SourCreamDecorator(getBasicRiceBowl(ricetype,meatType,sauceType),true));

        } else if(sourCream.equalsIgnoreCase("y") && guacamole.equalsIgnoreCase("y")
                && mixveg.equalsIgnoreCase("n")){
            return new Order(
                    customer,waiter,new SourCreamDecorator(
                            new GuacamoleDecorator(getBasicRiceBowl(ricetype,meatType,sauceType),true),true));

        } else if(sourCream.equalsIgnoreCase("y") && guacamole.equalsIgnoreCase("y")
                && mixveg.equalsIgnoreCase("y")){
            return new Order(
                    customer,waiter,new MixVegDecorator(
                    new SourCreamDecorator(new GuacamoleDecorator(getBasicRiceBowl(ricetype,meatType,sauceType),true),
                            true),true));
        }
        else if(sourCream.equalsIgnoreCase("y") && guacamole.equalsIgnoreCase("n")
                && mixveg.equalsIgnoreCase("y")){
            return new Order(
                    customer,waiter,new MixVegDecorator(
                    new SourCreamDecorator(getBasicRiceBowl(ricetype,meatType,sauceType),
                            true),true));
        }else if(sourCream.equalsIgnoreCase("n") && guacamole.equalsIgnoreCase("y")
                && mixveg.equalsIgnoreCase("n")){
            return new Order(
                    customer,waiter,new GuacamoleDecorator(getBasicRiceBowl(ricetype,meatType,sauceType),true));
        }else if(sourCream.equalsIgnoreCase("n") && guacamole.equalsIgnoreCase("y")
                && mixveg.equalsIgnoreCase("y")){
            return new Order(
                    customer,waiter,
                    new MixVegDecorator(new GuacamoleDecorator(getBasicRiceBowl(ricetype,meatType,sauceType),true),
                            true));
        }else if(sourCream.equalsIgnoreCase("n") && guacamole.equalsIgnoreCase("n")
                && mixveg.equalsIgnoreCase("n")){
            return new Order(
                    customer,waiter,getBasicRiceBowl(ricetype,meatType,sauceType));
        } else if(sourCream.equalsIgnoreCase("n") && guacamole.equalsIgnoreCase("n")
                && mixveg.equalsIgnoreCase("y")){
            return new Order(
                    customer,waiter,
                    new MixVegDecorator(getBasicRiceBowl(ricetype,meatType,sauceType),
                            true));
        }
        return null;
    }


    public RiceBowl getBasicRiceBowl(String ricetype, String meatType, String sauceType){
        Rice rice;
        Meat meat;
        Sauce sauce;
        if(ricetype.equalsIgnoreCase("b")){
             rice= Rice.BROWN;
        }else{
            rice=Rice.WHITE;
        }

        if(meatType.equalsIgnoreCase("c")){
            meat=Meat.CHICKEN;
        }else{
            meat=Meat.BEEF;
        }

        if(sauceType.equalsIgnoreCase("SP")){
            sauce=Sauce.SPICY;
        }else{
            sauce=Sauce.SWEET;
        }

        return new RiceBowl(rice,meat,sauce);
    }



}
