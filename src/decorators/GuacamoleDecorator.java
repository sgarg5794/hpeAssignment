package decorators;

import domain.RiceBowl;
import java.util.LinkedList;

public class GuacamoleDecorator extends RiceBowlDecorator {
    boolean guacamole;
    RiceBowl riceBowl;

    public GuacamoleDecorator(RiceBowl riceBowl, boolean guacamole) {
        super(riceBowl);
        this.guacamole=guacamole;
        this.riceBowl=riceBowl;
    }

    @Override
    public LinkedList<String> getAddOns() {
        LinkedList<String> addOns = super.getAddOns();
        if(addOns.contains("guacamole")){
            return addOns;
        }
        addOns.add("guacamole");
        return addOns;
    }

    public int getprice(){
        return super.getprice()+2;
    }
}
