package com.company;
import static java.lang.System.out;

//only one class per file is allowed. If no modifier is specified then it is default modifier by default
class Employee{
    int id;
    String name;
    int salary;
    public int getEmployeeSalary(){
        return this.salary;
    }
    public String getEmployeeDetails(){
        return this.name+" with employee id: "+this.id+" is earning "+this.salary+" per month";
    }
}

public class OOPS1 {
    public static void main(String[] args){
        Employee vignesh=new Employee();
        vignesh.id=10;
        vignesh.salary=175000;
        vignesh.name=new String("vignesh");
        out.println("vignesh id:"+vignesh.id);
        out.println("vignesh's per month salary:"+vignesh.getEmployeeSalary());
        out.print(vignesh.getEmployeeDetails());
    }
}
