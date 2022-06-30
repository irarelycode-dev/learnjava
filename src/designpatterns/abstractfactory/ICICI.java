package designpatterns.abstractfactory;

public class ICICI implements Bank{
    private String BName;
    public ICICI(){
        BName="icici";
    }
    public String getBankName(){
        return BName;
    }
}
