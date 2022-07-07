package designpatterns.factory;

public class PlanFactory {
    public Plan getPlan(String planType) {
        if (planType.equalsIgnoreCase("COMMERCIAL")) return new CommercialPlan();
        else if (planType.equalsIgnoreCase("INSTITUTIONAL")) return new InstitutionalPlan();
        else if (planType.equalsIgnoreCase("DOMESTIC")) return new DomesticPlan();
        return null;
    }
}
