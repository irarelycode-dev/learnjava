package com.datastructures.arrays;

import java.util.*;

public class moneyprize {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        String[] result = value.split(" ");
        int prizeMoney = Integer.parseInt(result[0]);
        int money = Integer.parseInt(result[1]);
        String list = sc.nextLine();
        String[] int_values = list.substring(1, list.length()-1).split(",");
        List<Integer> ans = new ArrayList<>();
        for(int k=0;k< int_values.length;k++)
        {
            ans.add(Integer.parseInt(int_values[k]));
        }
        int score = 0;
        Collections.sort(ans);
        while(ans.size()!=0) {
            if(money>=ans.get(0)) {
                score+=1;
                money-=ans.get(0);
                ans.remove(0);
                prizeMoney--;
            } else if(score>0&&prizeMoney>1) {
                score-=1;
                money+=ans.get(ans.size()-1);
                ans.remove(ans.size()-1);
                prizeMoney--;
            } else {
                ans.remove(0);
            }
        }
        System.out.print(score);
    }
}
