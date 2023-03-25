// Assignment 1 Part II-A (COMP 6481 Fall22)
// Name: Vignesh Pugazhendhi
// Student Id: 40230262

package com.assignmentppsfall2022;

import java.util.Arrays;

public class Voter implements Cloneable {
    private long voterId;
    private char[] voterPCode;
    private String voterName, voterEmail;
    byte voterAge;

    static int voterCount = 0;

    public Voter() {
        voterPCode = new char[]{'N', '/', 'A'};
        voterName = "";
        voterEmail = "";
        Voter.voterCount++;
        voterId = voterCount;
    }

    public Voter(long voterId, String voterEmail, String voterName, byte voterAge, char[] voterPCode) {
        this.voterAge = voterAge;
        this.voterId = voterId;
        this.voterPCode = voterPCode;
        this.voterEmail = voterEmail;
        this.voterName = voterName;
        Voter.voterCount++;
    }

    public static int findNumberOfCreatedVoters() {
        return Voter.voterCount;
    }

    //setters
    public void setVoterName(String name) {
        this.voterName = name;
    }

    public void setVoterEmail(String email) {
        this.voterEmail = email;
    }

    public void setVoterPCode(char[] pCode) {
        this.voterPCode = pCode;
    }

    public void setAge(byte age) {
        this.voterAge = age;
    }

    //getters
    public String getVoterName() {
        return this.voterName;
    }

    public String getVoterEmail() {
        return this.voterEmail;
    }

    public char[] getVoterPCode() {
        return this.voterPCode;
    }

    public byte getVoterAge() {
        return this.voterAge;
    }

    public long getVoterId() {
        return this.voterId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[voterId:" + voterId + " ,voterName:" + voterName + " ,voterPCode:" + Arrays.toString(this.voterPCode) + " ,voterEmail:" + voterEmail + " ,voterAge:" + voterAge + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Voter)) return false;
        return ((Voter) obj).voterId == this.voterId && Arrays.equals(this.voterPCode, ((Voter) obj).voterPCode);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //This driver code is for testing the above implementation of static variables,getters,setters
    //Above implementation is also used in part B of Question 2
    public static void main(String[] args) throws CloneNotSupportedException {

        //to check default constructors and actuators and mutators
        Voter voter1=new Voter();
        voter1.setVoterPCode(new char[]{'H','3','H',' ','2','E','7'});
        voter1.setVoterEmail("chennaisuperkings@gmail.com");
        voter1.setVoterName("vignesh");
        voter1.setAge((byte)24);
        System.out.println(voter1.toString());


        //to check parametrized constructors
        char[] pCode={'H','3','H',' ','2','E','7'};
        String voterName="Rochelle";
        byte age=23;
        String voterEmail="vickynsp15@gmail.com";
        long voterId=1234;
        Voter voter2=new Voter();
        System.out.println(voter2.toString());



        //to check if both voter objects are equal
        System.out.println("Equality of voter 1 and voter2: "+voter1.equals(voter2));



        //next two lines create a clone of a Voter object and checks for equality based on voterId and voterPCode
        //But this does not increment the static variable voterCount since we are only cloning it.
        //This is purely to test the overridden equals method
        Voter voter3=(Voter)voter1.clone();
        System.out.println("Equality of voter 1 and cloned voter3: "+voter1.equals(voter3));



        //to check number of voters created
        System.out.println(Voter.findNumberOfCreatedVoters());
    }
}
