package accessmodifiers;

class PrivateParent{
    private String name;
    private String getName(){
        return name;
    }
}

public class PrivateAccess extends PrivateParent {
    public static void main(String[] args) {
        PrivateParent obj=new PrivateParent();
//        System.out.println(obj.getName());
    }
}

/*
* default variables and methods can be accessed within same package
* default variables and methods from superclass can be accessed from subclass within same package
*
* protected variables and methods can be accessed within same package
* protected variables and methods from superclass can be accessed from subclass from other packages too
*
* private variables and methods can be accessed within same class only.
*
* public variables and methods can be accessed from anywhere
*
* */