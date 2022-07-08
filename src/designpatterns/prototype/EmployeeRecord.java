package designpatterns.prototype;
import designpatterns.prototype.Prototype;

public class EmployeeRecord implements Prototype {
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String address;

    public EmployeeRecord(){
        System.out.println("Employee records");
    }
    public EmployeeRecord(int id,String name,String address,String designation,double salary){
        this();this.id=id;
        this.name=name;
        this.address=address;
        this.designation=designation;
        this.salary=salary;
    }
    public void showRecord(){}
    public Prototype getClone(){
        return new EmployeeRecord(id,name,address,designation,salary);
    }
}
