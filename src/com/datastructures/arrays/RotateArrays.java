package com.datastructures.arrays;
import java.util.Arrays;

interface IRotateArray{
    int[] rotateArray(int[] arr,int d);
}

public class RotateArrays implements IRotateArray{
    public int[] rotateArray(int[] arr,int d){
        int[] tmp=new int[d];
        for(int i=0;i<d;i++){
            tmp[i]=arr[i];
        }
        for(int i=0,j=d;j<arr.length;j++,i++){
            arr[i]=arr[j];
        }
        for(int i=arr.length-d,j=0;i<arr.length;i++,j++){
            arr[i]=tmp[j];
        }
        return arr;
    }
    public int[] rotateOneByOne(int[] arr,int d){
        for(int i=0;i<d;i++) {
            int tmp = arr[0];
            for (int j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        RotateArrays obj=new RotateArrays();
        int[] arr=obj.rotateOneByOne(new int[]{10, 20, 30, 40},2);
        for(Integer i:arr){
            System.out.print(i+" ");
        }
    }
}
