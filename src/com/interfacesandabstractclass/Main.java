package com.interfacesandabstractclass;

public class Main {
    public static void main(String[] args) {
        DeskPhone phone=new DeskPhone(12345);
        phone.powerOn();
        phone.dial(12345);
        phone.answer();
    }
}
