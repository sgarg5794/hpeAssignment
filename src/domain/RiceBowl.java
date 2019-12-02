package domain;

import java.util.LinkedList;

public class RiceBowl implements RiceBowlInterface {
    private Rice rice;
    private Meat meat;
    private Sauce sauce;
    private LinkedList<String> addOns;

    public RiceBowl(Rice rice, Meat meat, Sauce sauce) {
        this.rice = rice;
        this.meat = meat;
        this.sauce = sauce;
        addOns=new LinkedList<>();
    }

    public Rice getRice() {
        return rice;
    }

    public Meat getMeat() {
        return meat;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public LinkedList<String> getAddOns() {
        return addOns;
    }

    public int getprice(){
        return 10;
    }


}
