//Assignment 2
//Question 2 part 4
//Vignesh Pugazhendhi- 40230262

package com.assignmentpps2fall2022;


import java.util.HashMap;
import java.util.Scanner;

public class TournamentResults {

    //This method is used to print team's qualifying status
    //Pos1,2,3 are compared for qualifying criteria.
    //By default remaining teams do not qualify because of lower points
    static void printStatus(int groupPos,TeamList.TeamNode[] node,String team){
        if(groupPos==0 || groupPos==1){
            TeamList.TeamNode currTeam=node[0];
            TeamList.TeamNode nextTeam=currTeam.getNextTeam();
            if(nextTeam.getTeam().getPoints()==currTeam.getTeam().getPoints()){
                System.out.println(team+" qualified for second round as it has higher net run rate");
            }else{
                System.out.println(team+" qualified for second round since it has higher points");
            }
        }
        else if(groupPos==2){
            TeamList.TeamNode currTeam=node[0];
            TeamList.TeamNode prevTeam=node[1];
            if(currTeam.getTeam().getPoints()<prevTeam.getTeam().getPoints()){
                System.out.println(team+" didn't qualify for second round as it has lower points");
            }
            if(prevTeam.getTeam().getPoints()==currTeam.getTeam().getPoints()){
                System.out.println(team+" didn't qualify for second round as it has lower net run rate");
            }
        }else{
            System.out.println(team+" didn't qualify as it has lower points");
        }
    }

    //driver method to print a team's qualifying status
    public static void teamStatus(String[] teams,TeamList groupA,TeamList groupB){
        TeamList tmpA=new TeamList();
        TeamList tmpB=new TeamList();
        int index=groupA.getSize()-1;
        while(index!=-1){
            tmpA.addSorted(groupA.getTeamNodeAt(index).getTeam());
            index--;
        }
        index=groupB.getSize()-1;
        while(index!=-1){
            tmpB.addSorted(groupB.getTeamNodeAt(index).getTeam());
            index--;
        }
        for(int i=0;i<teams.length;i++){
            String team=teams[i];
            HashMap<Integer, TeamList.TeamNode[]> groupAPos=tmpA.findByName(team);
            HashMap<Integer, TeamList.TeamNode[]> groupBPos=tmpB.findByName(team);
            Object[] keysA=  groupAPos.keySet().toArray();
            Object[] keysB=  groupBPos.keySet().toArray();
            if((Integer)keysA[0]!=-1){
                printStatus((Integer)keysA[0],groupAPos.get(keysA[0]),team);
            }
            if((Integer)keysB[0]!=-1){
                printStatus((Integer)keysB[0],groupBPos.get(keysB[0]),team);
            }
        }
    }

    //main driver code
    public static void main(String[] args) {
        TeamList groupA=new TeamList();
        TeamList groupB=new TeamList();
        Scanner scan=new Scanner(System.in);
        Team[] teams={
                new Team("ENG","ENGLAND",5,4,1,2.464,8,"A"),
                new Team("AUS","AUSTRALIA",5,4,1,1.216,8,"A"),
                new Team("RSA","SOUTH_AFRICA",5,4,1,0.739,8,"A"),
                new Team("SL","SRILANKA",5,2,3,-0.269,4,"A"),
                new Team("WI","WEST_INDIES",5,1,4,-1.641,2,"A"),
                new Team("BAN","BANGLADESH",5,0,5,-2.383,0,"A"),
        };
        for(int i=0;i<6;i++){
            groupA.addToStart(teams[i]);
        }

        //print groupA teams after adding to list
        System.out.println("********Group A***********");
        groupA.printTeams();
        System.out.println("**************************");

        //add teams to group B
        //uses add() method
        for(int i=0;i<6;i++){
            boolean flag=true;
            String id="";
            System.out.println("Enter team "+i+" details in group B");
            while(flag==true){
                System.out.println("Enter team ID:");
                id=scan.nextLine();
                if(groupB.contains(id) || groupA.contains(id)){
                    System.out.println("ID already exists!");
                }else{
                    flag=false;
                }
            }
            flag=true;
            String name="";
            while(flag==true){
                System.out.println("Enter team name:");
                name=scan.nextLine();
                if(groupB.containsName(name) || groupA.containsName(name)){
                    System.out.println("Name already exists!");
                }else{
                    flag=false;
                }
            }
            System.out.println("Enter number of matches played:");
            int matches=scan.nextInt();
            System.out.println("Enter number of matches won:");
            int matchesWon=scan.nextInt();
            int matchesLost=matches-matchesWon;
            System.out.println("Enter net runrate:");
            double nrr=scan.nextDouble();
            scan.nextLine();
            int points=matchesWon*2;
            Team team=new Team(id,name,matches,matchesWon,matchesLost,nrr,points,"B");
            groupB.addToStart(team);
        }

        //print groupB
        System.out.println("***********Team B**********");
        groupB.printTeams();
        System.out.println("***************************");

        System.out.println("*****************TEAM QUALIFYING STATUS*********************");
        System.out.println("Enter number of teams for which you need details:");
        int N=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter teams to find their status");
        String[] tms=new String[N];
        for(int i=0;i<tms.length;i++){
            tms[i]=scan.nextLine();
        }
        teamStatus(tms,groupA,groupB);
        System.out.println("**************************************************************");


        System.out.println("Enter 2 team ids to find the location in the list:");
        for(int i=0;i<2;i++){
            String teamId=scan.nextLine();
            groupB.find(teamId);
        }

        for(int i=0;i<10;i++) System.out.println();

        System.out.println("***********************************Testing other methods manually**************");
        //equals() method for testing equality of two lists
        System.out.println("Equality of two lists:"+groupA.equals(groupB));

        //replaceAtIndex()
        System.out.println("GroupA list before replaceAtIndex");
        groupA.printTeams();
        Team team=new Team("ZM","Zimbabwe",5,2,3,-1.213,4,"A");
        groupA.replaceAtIndex(team,2);
        System.out.println("GroupA list after replaceAtIndex() method:");
        groupA.printTeams();

        //deleteFromIndex()
        System.out.println("GroupA list before deleteFromIndex:");
        groupA.printTeams();
        groupA.deleteFromIndex(groupA.getSize()-1);
        System.out.println("GroupA list after deleteFromIndex:");
        groupA.printTeams();

        //deleteFromStart()
        System.out.println("GroupA list before deleteFromStart:");
        groupA.printTeams();
        groupA.deleteFromStart();
        System.out.println("GroupA list after deleteFromStart method:");
        groupA.printTeams();

        //isInTheGroup
        System.out.println("Checking isInTheGroup:");
        System.out.println(team.isInTheGroup(groupA.getTeamNodeAt(0).getTeam()));

        //copy constructor of TeamNode class
        TeamList.TeamNode clonedTeamNode=new TeamList.TeamNode(team,null);
        System.out.println("clonedTeamNode using copy constructor:"+clonedTeamNode.toString());
    }
}
