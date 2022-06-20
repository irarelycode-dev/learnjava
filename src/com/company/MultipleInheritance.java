package com.company;

interface AB{
    static int a=10;
    void download();
}
interface CD{
    static int b=23;
    void download();
}

public class MultipleInheritance implements AB,CD {
    public static void main(String[] args) {

    }
    public void download(){}
}
