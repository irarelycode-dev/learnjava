package com.datastructures.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class Worth{
        Integer weight,value;
        float valuePerWeight;
        Worth(Integer weight,Integer value){
            this.weight=weight;
            this.value=value;
            this.valuePerWeight=value/weight;
        }
        @Override
        public String toString(){
            return weight+" "+value;
        }
    }
    static double fKnapsack(Worth[] worth,float c){
        int len=worth.length;
        double value=0.0;
        Arrays.sort(worth, new Comparator<Worth>() {
            @Override
            public int compare(Worth o1, Worth o2) {
                return Integer.signum((int) (o2.valuePerWeight-o1.valuePerWeight));
            }
        });
        System.out.println(Arrays.toString(worth));
        for(int i=0;i<len;i++){
            float fraction=Math.min(c,worth[i].weight)/worth[i].weight;
            c=c-fraction*worth[i].weight;
            value+=fraction*worth[i].value;
        }
        return value;
    }

    public static void main(String[] args) {
        Worth[] worth={new Worth(10,60),new Worth(20,100),new Worth(30,120)};
        int c=50;
        System.out.println(fKnapsack(worth,c));
    }
}
