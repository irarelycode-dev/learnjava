package com.datastructures.arrays;

import java.util.*;

public class HotelRoomTutorialFall {
    public List<Integer> getRooms(int[] arr,int n){
        Map<Integer,Boolean> hm=new HashMap<>();
        List<Integer> al=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int requested=arr[i];
            if(!hm.containsKey(requested)){
                al.add(requested);
                hm.put(requested,true);
            }else{
                for(int j=arr[i];j<=n;j++){
                    if(!hm.containsKey(j)){
                        hm.put(j,true);
                        al.add(j);
                        break;
                    }
                }
            }
        }
        return al;
    }

    public List<Integer> getRoomsTreeMap(int[] arr,int n){
        Map<Integer,Boolean> tm=new TreeMap<>();
        List<Integer> rooms=new ArrayList<>();
        for(int i=1;i<=n;i++) tm.put(i,false);
        Iterator<Integer> itr=tm.keySet().iterator();
        for(int i=0;i<arr.length;i++){
            if(tm.get(arr[i])==false){
                tm.put(arr[i],true);
                rooms.add(arr[i]);
            }else{
                while(itr.hasNext()){
                    int key=itr.next();
                    if(tm.get(key)==false && key>arr[i]){
                        tm.put(key,true);
                        rooms.add(key);
                        break;
                    }
                }
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        HotelRoomTutorialFall obj=new HotelRoomTutorialFall();
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        scan.nextLine();
        String[] s=scan.nextLine().split(" ");
        int[] requested=new int[s.length];
        for(int i=0;i<s.length;i++){
            requested[i]=Integer.parseInt(s[i]);
        }
        List<Integer> allocated=obj.getRooms(requested,n);
        for(Integer al:allocated){
            System.out.print(al+" ");
        }
    }
}