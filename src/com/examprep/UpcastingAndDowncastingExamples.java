package com.examprep;


class Creature{
    private int age;
    private int weight;
    private String name;

    public Creature(int age,int weight,String name){
        this.age=age;
        this.weight=weight;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public double getCost(){
        return (weight*age)/2;
    }
}

class Platypus extends Creature{
    public Platypus(int age,int weight,String name){
        super(age,weight,name);
    }
    public void printFoo(){
        System.out.println("Foo");
    }
}

public class UpcastingAndDowncastingExamples {
    static void show_animal_cost(Creature myCreature){
        System.out.println("I'm"+myCreature.getName()+" and my cost is:"+myCreature.getCost());
    }

    public static void main(String[] args) {
        Creature creature1=new Creature(4,60,"Jellybean");
        show_animal_cost(creature1);
        //Platypus myCreature3=new Creature(44,17,"Wally");//This will not compile
        //Platypus myCreature4=(Platypus)new Creature(44,17,"Wally");//this will give ClassCastException
        Platypus myPlatypus1=new Platypus(4,60,"peeps");
        Creature myCreature5=myPlatypus1;
        Platypus myPlatypus2=(Platypus)myCreature5;
        myPlatypus2.printFoo();
        show_animal_cost(myPlatypus2);
    }
}
