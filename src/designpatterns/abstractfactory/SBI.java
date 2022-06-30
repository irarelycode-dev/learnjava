package designpatterns.abstractfactory;

public class SBI implements Bank{
    private String BName;
    public SBI(){
        BName="sbi bank";
    }
    public String getBankName(){
        return BName;
    }
}
