package com.datastructures.greedy;

import java.util.*;

public class IntervalPartioning {
    static class Interval{
        int start;
        int end;
        String name;
    }

    static class Classroom{
        int currEnd;
        List<Interval> intervals;
        Classroom(){
            intervals=new LinkedList<>();
        }
    }

    static List<Classroom> scheduleClasses(List<Interval> list){
        List<Classroom> classrooms=new LinkedList<>();
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.signum(o1.start-o2.start);
            }
        });

        Interval tmp=list.get(0);
        Classroom first=new Classroom();
        first.currEnd=tmp.end;
        first.intervals.add(tmp);
        classrooms.add(first);

        for(int i=1;i<list.size();i++){
            Interval it=list.get(i);
            int j=0;
            boolean assigned=false;
            while(j<classrooms.size()){
                Classroom room=classrooms.get(j);
                if(it.start>=room.currEnd){
                    room.currEnd=it.end;
                    room.intervals.add(it);
                    assigned=true;
                    break;
                }
                j++;
            }
            if(!assigned){
                Classroom newClass=new Classroom();
                newClass.currEnd=it.end;
                newClass.intervals.add(it);
                classrooms.add(newClass);
            }
        }

        return classrooms;
    }

    public static void main(String[] args) {
        Interval a=new Interval();
        a.start=9;
        a.end=10;
        a.name="A";
        Interval b=new Interval();
        b.start=9;
        b.end=12;
        b.name="B";
        Interval c=new Interval();
        c.start=9;
        c.end=10;
        c.name="C";
        Interval d=new Interval();
        d.start=11;
        d.end=12;
        d.name="D";
        LinkedList<Interval> intervals=new LinkedList<>();
        intervals.add(a);
        intervals.add(b);
        intervals.add(c);
        intervals.add(d);
        List<Classroom> rooms=scheduleClasses(intervals);
        Iterator<Classroom> itr=rooms.iterator();
        while(itr.hasNext()){
            Classroom curr=itr.next();
            List<Interval> itvls=curr.intervals;
            Iterator<Interval> itr2=itvls.iterator();
            while(itr2.hasNext()){
                System.out.println(itr2.next().name);
            }
        }
    }

}
