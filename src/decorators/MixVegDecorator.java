package decorators;

import domain.RiceBowl;

import java.util.LinkedList;

public class MixVegDecorator extends RiceBowlDecorator {
    boolean mixVegetables;
    RiceBowl riceBowl;

    public MixVegDecorator(RiceBowl riceBowl, boolean mixVegetables) {
        super(riceBowl);
        this.mixVegetables=mixVegetables;
        this.riceBowl=riceBowl;
    }

    @Override
    public LinkedList<String> getAddOns() {
        LinkedList<String> addOns = super.getAddOns();
        if(addOns.contains("mixveg")){
            return addOns;
        }
        addOns.add("mixveg");
        return addOns;
    }

    public int getprice(){
        return super.getprice()+2;
    }
}
