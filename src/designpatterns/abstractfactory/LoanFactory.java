package designpatterns.abstractfactory;

public class LoanFactory extends AbstractFactory{
    public Loan getLoan(String loan){
        if(loan.equalsIgnoreCase("BUSINESS")) return new BusinessLoan();
        if(loan.equalsIgnoreCase("EDUCATION")) return new EducationLoan();
        if(loan.equalsIgnoreCase("HOME")) return new HomeLoan();
        return null;
    }
    public Bank getBank(String bank){
        return null;
    }
}
