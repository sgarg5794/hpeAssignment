package domain;

public enum Meat {
    CHICKEN,
    BEEF;

    public boolean isChicken(Order order){
        if(order.getRiceBowl().getMeat() == Meat.CHICKEN){
            return true;
        }
        return false;
    }

    public boolean isBeef(Order order){
        if(order.getRiceBowl().getMeat() == Meat.BEEF){
            return true;
        }
        return false;
    }
}
