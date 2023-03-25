package com.datastructures.arrays;


import java.util.*;

public class BlacklistGamers {

    public int compareStrings(String str1,String str2){
        boolean flag=true;
        for(int i=0;i<str1.length();i++){
            if(str2.charAt(i)=='*'){
                continue;
            }
            if(str1.charAt(i)!=str2.charAt(i)){
                flag=false;
                break;
            }
        }
        return flag?1:0;
    }

    public int blackListGamers(String[] gamers,String[] blacklisted){
        HashMap<Integer,ArrayList<String>> hm=new HashMap<>();
        ArrayList<String> al;
        for(int i=0;i<gamers.length;i++){
            int len=gamers[i].length();
            if(!hm.containsKey(len)){
                al=new ArrayList<>();
                al.add(gamers[i]);
                hm.put(len,al);
            }else{
                al=hm.get(len);
                al.add(gamers[i]);
                hm.put(len,al);
            }
        }

        int[] matches=new int[blacklisted.length];
        for(int i=0;i<blacklisted.length;i++){
            int len=blacklisted[i].length();
            int sum=0;
            if(hm.containsKey(len)){
                al=hm.get(len);
                Iterator<String> itr=al.iterator();
                while(itr.hasNext()) {
                    String str = itr.next();
                    sum += compareStrings(str, blacklisted[i]) == 0 ? 0 : 1;
                }
            }
            matches[i]=sum;
        }
        int countZeros=0,sets=1;
        for(int i=0;i<matches.length;i++){
            if(matches[i]==0){
                countZeros++;
                continue;
            }
            sets=sets*matches[i];
        }
        return countZeros==matches.length?0:sets;
    }
    public static void main(String[] args) {
        BlacklistGamers obj=new BlacklistGamers();
        Scanner scan=new Scanner(System.in);
        String players=scan.nextLine();
        players=players.substring(1,players.length()-1);
        String[] player=players.split(" ");
        String blacklisted=scan.nextLine();
        blacklisted=blacklisted.substring(1,blacklisted.length()-1);
        String[] blackList=blacklisted.split(" ");
        System.out.println(obj.blackListGamers(player,blackList));
    }
}
