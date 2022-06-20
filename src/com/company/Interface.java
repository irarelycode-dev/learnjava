package com.company;
import static java.lang.System.out;

interface Bicycle {
        int battery=45;
        void applyBrake(int decrement);
        void increaseSpeed(int increment);
        static void autopilot(){
                out.println("autopilot feature");
        }
}
interface AutoBicycle{
        void recharge(float units);
}
interface SmartBicycle{
        boolean fixMonitoring();
}
class AvonCycle implements Bicycle,AutoBicycle,SmartBicycle{
        void blowHorn(){
                out.println("Pee pee poo poo");
                Bicycle.autopilot();
        }
        public void applyBrake(int decrement){      // make all interface methods public
                out.println("decrement");
        }
        public void increaseSpeed(int increment){
                out.println("increment");
        }
        public void recharge(float units){
                //this.battery+=units;  //this will throw error
                out.println("battery has been recharged");
        }
        public boolean fixMonitoring(){
                out.println("fixed monitoring");
                return true;
        }
}
class HeroCycle implements Bicycle{
        void blowHorn(){
                out.println("hero cycle is blowing its horn");
        }
        public void applyBrake(int decrement){}
        public void increaseSpeed(int increment){}
}

public class Interface{
        public static void main(String[] args){
                AvonCycle cycle=new AvonCycle();
                out.println(cycle.fixMonitoring());
        }
}

//interfaces can only have abstract methods
//you can create properties in interfaces
//you cannot modify properties in interfaces since they are final and public by default
// interfaces can have static members also but static methods should have a body
//interface cannot provide implementation of abstract class
//interface can implement only another interface
//you can create the reference of an interface but not an object