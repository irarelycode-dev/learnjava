package com.pod;

import java.util.Scanner;

public class POD_3_3 {
    public static int findCombo(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        return findCombo(n-1)+findCombo(n-2);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        System.out.println(findCombo(n));
    }
}
