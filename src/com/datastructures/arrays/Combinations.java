package com.datastructures.arrays;

public class Combinations {
    static void printCombinations(char[] input,int index,char[] output,int outIndex){
        if(index==input.length){
            System.out.println(String.valueOf(output));
            return;
        }
        output[outIndex]=input[index];
        output[outIndex+1]=' ';
        printCombinations(input,index+1,output,outIndex+2);
        if(index+1!=input.length){
            printCombinations(input,index+1,output,outIndex+1);
        }
    }
    public static void main(String[] args) {
        char input[] = "1214".toCharArray();
        char []output = new char[100];
        printCombinations(input, 0, output, 0);
    }
}
