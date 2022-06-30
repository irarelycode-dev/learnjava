package designpatterns.abstractfactory;

public class BankFactory extends AbstractFactory{
    public Bank getBank(String bank){
        if(bank.equalsIgnoreCase("HDFC")) return new HDFCBank();
        else if(bank.equalsIgnoreCase("SBI")) return new SBI();
        else if(bank.equalsIgnoreCase("ICICI")) return new ICICI();
        return null;
    }
    public Loan getLoan(String loan){
        return null;
    }
}
