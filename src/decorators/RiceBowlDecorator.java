package decorators;

import domain.RiceBowl;

import java.util.LinkedList;

public class RiceBowlDecorator extends RiceBowl {

    protected RiceBowl riceBowl;


    public RiceBowlDecorator(RiceBowl riceBowl) {

        super(riceBowl.getRice(),riceBowl.getMeat(),riceBowl.getSauce());
        this.riceBowl=riceBowl;
    }

    @Override
    public LinkedList<String> getAddOns() {
        return riceBowl.getAddOns();
    }

    @Override
    public int getprice(){
        return riceBowl.getprice();
    }


}
