package accessmodifiers;

class TreeNode{
    TreeNode(){}
    void msg(){
        System.out.println("Test default modifiers");
    }
}

public class DefaultModifiers {
    public static void main(String[] args) {
        TreeNode object=new TreeNode();
    }
}

//default access modifiers can be accessed within same class and same package