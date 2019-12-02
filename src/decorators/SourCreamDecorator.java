package decorators;

import domain.RiceBowl;

import java.util.LinkedList;

public class SourCreamDecorator  extends RiceBowlDecorator{
    boolean sourCream;
    RiceBowl riceBowl;


    public SourCreamDecorator(RiceBowl riceBowl, boolean sourCream) {
        super(riceBowl);
        this.sourCream=sourCream;
        this.riceBowl=riceBowl;

    }

    @Override
    public LinkedList<String> getAddOns() {
        LinkedList<String> addOns = super.getAddOns();
        if(addOns.contains("sourCream")){
            return addOns;
        }
        addOns.add("sourCream");
        return addOns;
    }

    public int getprice(){
        return super.getprice()+2;
    }
}
