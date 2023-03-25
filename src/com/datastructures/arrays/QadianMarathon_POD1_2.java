package com.datastructures.arrays;

import java.util.*;

public class QadianMarathon_POD1_2 {
    public static int findMaximumScore(int[] prizes,int money){
        Arrays.sort(prizes);
        int ptr1=0,ptr2=prizes.length-1;
        int score=0,currIdx=ptr1;
        while(ptr1<ptr2){
            if(money<prizes[currIdx] && score==0){
                break;
            }
            if(money>=prizes[currIdx]){
                money-=prizes[currIdx];
                score++;
                ptr1++;
                currIdx=ptr2;
            }else if(score>0){
                money+=prizes[currIdx];
                score--;
                ptr2--;
                currIdx=ptr1;
            }
        }
        return score;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] sizeMoney=scan.nextLine().split(" ");
        int size=Integer.parseInt(sizeMoney[0]),money=Integer.parseInt(sizeMoney[1]);
        String prize=scan.nextLine();
        prize=prize.substring(1,prize.length()-1);
        String[] prizes=prize.split(",");
        int[] prizeAmount=new int[size];
        for(int i=0;i<size;i++){
            prizeAmount[i]=Integer.parseInt(prizes[i]);
        }
        int score=findMaximumScore(prizeAmount,money);
        System.out.println(score);
    }
}
