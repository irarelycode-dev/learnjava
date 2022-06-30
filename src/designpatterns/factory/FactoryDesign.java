package designpatterns.factory;

public class FactoryDesign {
    public static void main(String[] args) {
        Plan plan=new PlanFactory().getPlan("DOMESTIC");
        plan.setRate();
        System.out.println(plan.calculateBill(100));
    }
}
