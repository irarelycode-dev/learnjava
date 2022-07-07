package designpatterns.abstractfactory;
import designpatterns.abstractfactory.FactoryCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryGenerator {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the bank service:");
        String bankName=br.readLine();
        System.out.println("Enter type of loan:");
        String loanType=br.readLine();
        AbstractFactory bankFactory=FactoryCreator.getFactory("Bank");
        AbstractFactory loanFactory=FactoryCreator.getFactory("Loan");
        Bank bank=bankFactory.getBank(bankName);
        Loan loan=loanFactory.getLoan(loanType);
    }
}
