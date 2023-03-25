package com.examprep;

class Animals{
    private int weight;
    private String name;
    public Animals(int weight,String name){
        this.weight=weight;
        this.name=name;
    }
    public String talk(){
        return "generic animal talk";
    }
    public String toString(){
        return ("I say "+talk()+"\n");
    }
}

class Pig1 extends Animals{
    public Pig1(int weight,String name){
        super(weight,name);
    }
    public String talk(){
        return "Oink! Oink!";
    }
}

class Cow extends Animals{
    public Cow(int weight,String name){
        super(weight,name);
    }
    public String talk(){
        return "Moo Moo";
    }
}

public class DynamicBindingStaticBinding {
    public static final int FARM_SIZE=3;
    String[] aType={"pig","cow","pig"};
    String[] aName={"Billy","lucky","arnold"};
    int[] aWeight={43,1789,899};
    Animals[] animal=new Animals[FARM_SIZE];

    public DynamicBindingStaticBinding(){
        String type;
        for(int i=0;i<FARM_SIZE;i++){
            type=aType[i];
            if(type.equals("pig")){
                animal[i]=new Pig1(aWeight[i],aName[i]);
            }else{
                animal[i]=new Cow(aWeight[i],aName[i]);
            }
        }
    }

    public static void main(String[] args) {
        DynamicBindingStaticBinding o=new DynamicBindingStaticBinding();
        for(int i=0;i<FARM_SIZE;i++){
            System.out.println(o.animal[i]);
        }
    }
}
