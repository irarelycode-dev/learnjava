package com.datastructures.arrays;
import java.util.Arrays;

interface IRotateArray{
    int[] rotateArray(int[] arr,int d);
}

public class RotateArrays implements IRotateArray{

    //O(N), O(d)
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


    //O(N*d), O(1)
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

    //juggling algorithm
    //O(n), O(1)
    int getGCD(int a,int b){
        if(b==0) return a;
        else return getGCD(b,a%b);
    }
    public int[] rotateArrayByGCD(int[] arr,int d){
        int len=arr.length;
        int gcd=getGCD(len,d);
        d=d%len;
        for(int i=0;i<gcd;i++){
            int tmp=arr[i],j=i;
            while(true){
                int k=j+d;
                if(k>=len) k=k-len;
                if(k==i) break;
                arr[j]=arr[k];
                j=k;
            }
            arr[j]=tmp;
        }
        return arr;
    }


    void reversePart(int[] arr,int start,int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    //O(n),O(1)
    public int[] rotateArrayByReverse(int[] arr,int d){
        reversePart(arr,0,arr.length-1);
        reversePart(arr,0,arr.length-d-1);
        reversePart(arr,arr.length-d,arr.length-1);
        return arr;
    }

    public static void main(String[] args) {
        RotateArrays obj=new RotateArrays();
        int[] arr=obj.rotateOneByOne(new int[]{10, 20, 30, 40},2);
        int[] tmpArr=obj.rotateArrayByReverse(new int[]{1,2,3,4,5,6,7,8,9,10,11,12},3);
        for(Integer i:tmpArr){
            System.out.print(i+" ");
        }
    }
}
