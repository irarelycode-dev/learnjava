package com.pod;

import java.util.*;
import java.util.stream.IntStream;

public class POD_6_2 {
    public static int removeGateCrashers(int[] celebs1,int[] celebs2){
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<celebs1.length;i++){
            if(!hm.containsKey(celebs1)){
                hm.put(celebs1[i],1);
            }else{
                hm.put(celebs1[i],hm.get(celebs1[i])+1);
            }
        }
        for(int i=0;i<celebs2.length;i++){
            if(!hm.containsKey(celebs2)){
                hm.put(celebs2[i],1 );
            }else{
                hm.put(celebs2[i],hm.get(celebs2[i])+1);
            }
        }
        Set<Integer> keys=hm.keySet();
        Iterator<Integer> itr=keys.iterator();
        int count=0;
        while(itr.hasNext()){
            int tmp=itr.next();
            if(tmp<2) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        scan.nextLine();
        String[] celebs1= scan.nextLine().split(",");
        String[] celebs2=scan.nextLine().split(",");
        int[] celeb1=new int[celebs1.length];
        int[] celeb2=new int[celebs2.length];
        for(int i=0;i<celeb1.length;i++){
            celeb1[i]=Integer.parseInt(celebs1[i]);
            celeb2[i]=Integer.parseInt(celebs2[i]);
        }
        System.out.println(removeGateCrashers(celeb1,celeb2));
    }
}
