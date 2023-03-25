package com.examprep;

public class Overriding2 {
    private void function(){
        System.out.println("private function");
    }

    public static void main(String[] args) {
        Overriding2 po=new Derived2();
        po.function();
    }
}

class Derived2 extends Overriding2{
    public void function(){
        System.out.println("public function");
    }
}
