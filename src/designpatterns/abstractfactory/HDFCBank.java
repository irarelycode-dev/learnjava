package designpatterns.abstractfactory;

public class HDFCBank implements Bank{
    private final String BName;
    public HDFCBank(){
        BName="hdfc bank";
    }
    public String getBankName(){
        return BName;
    }
}
