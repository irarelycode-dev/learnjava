package com.datastructures.greedy;

import java.util.*;

public class IntervalScheduling {

    static class Interval{
        int start;
        int end;
        String name;
    }

    static List<Interval> sortByFinishTime(List<Interval> intervals){
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.signum(o1.end-o2.end);
            }
        });
        return intervals;
    }

    static List<Interval> sortByStartTime(List<Interval> intervals){
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.signum(o1.start-o2.start);
            }
        });
        return intervals;
    }

    //this one does not give an optimal solution
    static List<Interval> sortByTime(List<Interval> intervals){
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.signum((o1.end-o1.start)-(o2.end-o2.start));
            }
        });
        return intervals;
    }

    static Set<Interval> getOptimalSet(List<Interval> intervals){
        intervals=sortByTime(intervals);
        for(int i=0;i<intervals.size();i++){
            Interval itl=intervals.get(i);
            System.out.println("Interval:"+itl.name+" "+itl.start+" "+itl.end);
        }
        Set<Interval> res=new HashSet<>();
        res.add(intervals.get(0));
        int k=0;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start>=intervals.get(k).end){
                res.add(intervals.get(i));
                k=i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Interval i1=new Interval();
        i1.start=1;
        i1.end=3;
        i1.name="A";
        Interval i2=new Interval();
        i2.start=2;
        i2.end=5;
        i2.name="B";
        Interval i3=new Interval();
        i3.start=3;
        i3.end=9;
        i3.name="C";
        Interval i4=new Interval();
        i4.start=6;
        i4.end=8;
        i4.name="D";
        LinkedList<Interval> list=new LinkedList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        Set<Interval> res=getOptimalSet(list);
        Iterator<Interval> itr=res.iterator();
        while(itr.hasNext()){
            Interval i=itr.next();
            System.out.println("Task:"+i.name+" "+i.start+" "+i.end);
        }
    }
}
