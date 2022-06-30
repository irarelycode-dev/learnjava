package designpatterns.factory;

abstract public class Plan {
    protected double rate;
    abstract void setRate();
    public double calculateBill(int units){
        return rate*units;
    }
}
