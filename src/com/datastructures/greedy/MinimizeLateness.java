package com.datastructures.greedy;

import java.util.*;

public class MinimizeLateness {
    static class Job{
        int duration;
        int deadline;
        int start;
        int end;
    }
    static List<Job> minimizeLateness(List<Job> jobs){
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.signum(o1.deadline-o2.deadline);
            }
        });
        int t=0;
        for(int i=0;i<jobs.size();i++){
            Job job=jobs.get(i);
            job.start=t;
            job.end=t+job.duration;
            t=t+job.duration;
        }
        return jobs;
    }
}
