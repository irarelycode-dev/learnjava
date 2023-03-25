//Assignment 2
//Question 2 part 3
//Vignesh Pugazhendhi- 40230262


package com.assignmentpps2fall2022;

import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class TeamList{
    private TeamNode head;
    private TeamNode tail;
    private int size;
    private TeamListComparator comparator;


    public TeamNode getHead(){
        return head;
    }

    static class TeamNode{
        public Team team;
        public TeamNode nextTeam;

        //constructor
        TeamNode(){
            team=null;
            nextTeam=null;
        }

        //parameterized constructor
        TeamNode(Team T,TeamNode next){
            team=T;
            nextTeam=next;
        }

        //copy constructor
        TeamNode(TeamNode teamNode){
            this.team=teamNode.team;
            this.nextTeam=teamNode.nextTeam;
        }

        //getters and setters
        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public TeamNode getNextTeam() {
            return nextTeam;
        }

        public void setNextTeam(TeamNode nextTeam) {
            this.nextTeam = nextTeam;
        }

        //clone method()
        public TeamNode getClone(){
            return new TeamNode(this.getTeam(),this.getNextTeam());
        }
    }

    public TeamList(){
        head=null;
        tail=null;
        comparator=new TeamListComparator();
    }
    public TeamList(TeamList list){
        head=list.head;
        tail=list.getTeamNodeAt(list.getSize()-1);
        comparator=new TeamListComparator();
    }

    public int getSize() {
        return size;
    }

    //addToStart()
    public TeamNode addToStart(Team node){
        if(this.contains(node.getTeamID())) return null;
        TeamNode newNode=new TeamNode(node,null);
        size++;
        newNode.setNextTeam(head);
        if(tail== null){
            tail=newNode;
        }
        head=newNode;
        return head;
    }

    //add()
    public TeamNode add(Team node){
        TeamNode newNode=new TeamNode(node,null);
        size++;
        TeamNode traversalNode=head;
        while(traversalNode.nextTeam!=null){
            traversalNode=traversalNode.nextTeam;
        }
        traversalNode.nextTeam=newNode;
        tail=newNode;
        return head;
    }

    //insertAtIndex()
    public boolean insertAtIndex(Team node,int index){
        if(!(index>=0 && index<=size-1)) throw new NoSuchElementException(); //terminate the program
        TeamNode newNode=new TeamNode(node,null);
        if(index==0){
            newNode.setNextTeam(head);
            head=newNode;
        }else{
            TeamNode traversalNode=head;
            int idx=0;
            while(idx<index){
                traversalNode=traversalNode.getNextTeam();
                idx++;
            }
            TeamNode nextNode=traversalNode.getNextTeam();
            traversalNode.setNextTeam(newNode);
            newNode.setNextTeam(nextNode);
        }
        size++;
        return true;
    }

    //deleteFromIndex
    public boolean deleteFromIndex(int index){
        if(!(index>=0 && index<=size-1)) throw new NoSuchElementException(); //terminate the program
        if(index==0) {
            head = head.getNextTeam();
        }else{
            TeamNode traversalNode=head;
            int idx=0;
            while(idx<index-1){
                traversalNode=traversalNode.getNextTeam();
                idx++;
            }
            TeamNode nextNode=null;
            if(index!=size-1) nextNode=traversalNode.getNextTeam().getNextTeam();
            TeamNode removeNode=traversalNode.getNextTeam();
            traversalNode.setNextTeam(nextNode);
            if(index==size-1){
                tail=traversalNode;
            }
            if(index!=size-1) removeNode.setNextTeam(null);
        }
        size--;
        return true;
    }

    //delete from start
    public boolean deleteFromStart(){
        return deleteFromIndex(0);
    }

    //replace at index
    public boolean replaceAtIndex(Team team,int index){
        if(!(index>=0 && index<=size-1)) return false;
        TeamNode newNode=new TeamNode(team,null);
        if(index==0){
            TeamNode nextNode=head.getNextTeam();
            head=newNode;
            newNode.setNextTeam(nextNode);
        }else{
            TeamNode traversalNode=head;
            int count=0;
            while(count<index-1){
                traversalNode=traversalNode.getNextTeam();
                count++;
            }
            TeamNode nextNode=traversalNode.getNextTeam();
            TeamNode nextNextNode=traversalNode.getNextTeam().getNextTeam();
            nextNode=newNode;
            traversalNode.setNextTeam(newNode);
            newNode.setNextTeam(nextNextNode);
        }
        return true;
    }

    //find() method
    public TeamNode find(String id){
        if(size==0) return null;
        TeamNode traversalNode=head;
        int count=0;
        while(traversalNode!=null){
            if(traversalNode.getTeam().getTeamID().equals(id)){
                System.out.println("found at index:"+count);
                return traversalNode;
            }
            traversalNode=traversalNode.getNextTeam();
            count++;
        }
        return null;
    }

    //contains()
    public boolean contains(String id){
        TeamNode node=find(id);
        return node!=null?true:false;
    }

    //equals() method
    public boolean equals(TeamList list){
        TeamNode thisTraversalNode=this.head;
        TeamNode traversalNode=list.head;
        if(this.size!=list.size) return false;
        while(thisTraversalNode!=null && traversalNode!=null){
            boolean test=thisTraversalNode.equals(traversalNode);
            if(!test) return false;
            thisTraversalNode=thisTraversalNode.getNextTeam();
            traversalNode=traversalNode.getNextTeam();
        }
        return true;
    }

    //extra helper methods for testing
    public TeamNode getTeamNodeAt(int index){
        int count=0;
        if(index==0) return head;
        if(index==size-1) return tail;
        TeamNode traversalNode=head;
        while(index!=count) {
            traversalNode = traversalNode.getNextTeam();
            count++;
        }
        return traversalNode;
    }

    //extra helper to print teams
    public void printTeams(){
        TeamNode traversalNode=head;
        while (traversalNode!=null){
            String name=traversalNode.getTeam().getTeamName();
            TeamNode next=traversalNode.getNextTeam();
            if(next!=null) {
                System.out.print(name+"->");
            }else{
                System.out.println(name);
            }
            traversalNode=next;
        }
        System.out.println();
    }

    //addSorted() helper
    public TeamNode addSorted(Team o){
        if (o == null) {
            return null;
        }
        TeamNode newnode = new TeamNode(o,null);
        if (head == null) {
            head = tail= newnode;
        } else {
            //check if it is to be inserted before tail
            if (comparator.compare(newnode, head) <= 0) {
                newnode.setNextTeam(head);
                head = newnode;
            }
            // Check if it is to be inserted after tail
            else if (comparator.compare(newnode, tail) >= 0) {
                tail.setNextTeam(newnode);
                tail = newnode;
            } else {
                // Check if needs to be inserted into the middle of the list
                TeamNode next = head.getNextTeam();
                TeamNode prev = head;
                while (comparator.compare(newnode, next) > 0) {
                    prev = next;
                    next = next.getNextTeam();
                }
                prev.setNextTeam( newnode);
                newnode.setNextTeam(next);
            }
        }
        size++;
        return head;
    }

    //helper class
    class TeamListComparator implements Comparator<TeamNode>{
        @Override
        public int compare(TeamNode t1,TeamNode t2){
            if(t1.getTeam().getPoints()>t2.getTeam().getPoints()){
                return -1;
            }
            else if(t1.getTeam().getPoints()==t2.getTeam().getPoints()){
                if(t1.getTeam().getNetRunRate()>t2.getTeam().getNetRunRate()) {
                    return -1;
                }
                return 1;
            }
            return 1;
        }
    }

    //containsName
    public boolean containsName(String name){
        if(size==0) return false;
        TeamNode traversalNode=head;
        int count=0;
        while(traversalNode!=null){
            if(traversalNode.getTeam().getTeamName().equals(name)){
                return true;
            }
            traversalNode=traversalNode.getNextTeam();
            count++;
        }
        return false;
    }

    //findByName
    public HashMap<Integer,TeamNode[]> findByName(String name){
        HashMap<Integer, TeamNode[]> hm=new HashMap<>();
        if(size==0) {
            hm.put(-1,new TeamNode[]{null,null});
        }
        TeamNode traversalNode=head;
        TeamNode previousNode=null;
        int count=0;
        while(traversalNode!=null){
            if(traversalNode.getTeam().getTeamName().equals(name)){
                hm.put(count,new TeamNode[]{traversalNode,previousNode});
                return hm;
            }
            previousNode=traversalNode;
            traversalNode=traversalNode.getNextTeam();
            count++;
        }
        hm.put(-1,new TeamNode[]{null,null});
        return hm;
    }
}
