//Assignment 2
//Question 2 part 2
//Vignesh Pugazhendhi- 40230262

package com.assignmentpps2fall2022;

public class Team implements Groupable{
    private String teamName,teamID,group;
    private int gamesPlayed,gamesWon,gamesLost;
    private double netRunRate;
    private int points;

    public Team(String teamID,String teamName,int gamesPlayed,int gamesWon,int gamesLost,double netRunRate,int points,String group){
        this.teamID=teamID;
        this.teamName=teamName;
        this.gamesPlayed=gamesPlayed;
        this.gamesWon=gamesWon;
        this.gamesLost=gamesLost;
        this.netRunRate=netRunRate;
        this.points=points;
        this.group=group;
    }
    public Team(Team team,String teamID){
        this.teamID=teamID;
        this.teamName=team.getTeamName();
        this.gamesPlayed=team.getGamesPlayed();
        this.gamesWon=team.getGamesWon();
        this.gamesLost=team.getGamesLost();
        this.netRunRate=team.getNetRunRate();
        this.points=team.getPoints();
        this.group=team.group;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public String getGroup(){
        return group;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public double getNetRunRate() {
        return netRunRate;
    }

    public void setNetRunRate(double netRunRate) {
        this.netRunRate = netRunRate;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Team clone(String teamID) {
        Team team=new Team(teamID,this.getTeamName(),this.getGamesPlayed(),this.getGamesWon(),this.getGamesLost(),this.getNetRunRate(),this.getPoints(),this.getGroup());
        return team;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[teamID:" + teamID + " ,teamName:" + teamName  + " ,gamesPlayed:" + gamesPlayed + " ,gamesWon:" + gamesWon + " ,gamesLost:" + gamesLost +" ,netRunRate:"+netRunRate+" ,points:"+points+" ,group:"+group+ "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Team)) return false;
        return ((Team)obj).teamName == this.teamName && ((Team) obj).gamesPlayed==this.gamesPlayed && ((Team) obj).gamesWon==this.gamesWon && ((Team) obj).gamesLost==this.gamesLost && ((Team) obj).netRunRate==this.netRunRate && ((Team) obj).points==this.points;
    }

    @Override
    public boolean isInTheGroup(Team T){
        return this.getGroup()==T.getGroup();
    }
}
