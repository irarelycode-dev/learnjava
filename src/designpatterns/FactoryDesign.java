package designpatterns;
import designpatterns.classes.Android;
import designpatterns.classes.Windows;
import designpatterns.classes.IOS;
import designpatterns.base.OS;

//factory generator
class FactoryMain{
    public OS getInstance(String str){
        if(str.equals("Open")) return new Android();
        else if(str.equals("Closed")) return new IOS();
        return new Windows();
    }
}

public class FactoryDesign {
    public static void main(String[] args) {
        FactoryMain factory=new FactoryMain();
        OS os=factory.getInstance("Open");
        os.spec();
    }
}
