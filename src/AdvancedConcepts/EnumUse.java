package AdvancedConcepts;
import AdvancedConcepts.Color;

public class EnumUse {
    public static void main(String[] args) {
        Color color=Color.RED;
        System.out.println(color.name());
        System.out.println(color.getValue());
        for(Color colour:Color.values()){
            System.out.println(colour.name()+":"+colour.getValue());
        }
    }
}
