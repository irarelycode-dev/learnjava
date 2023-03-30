package com.graphs;

import java.util.*;

import java.util.*;

public class PartyInvite {

    public static int partyAlgo(int numPeople, boolean[][] connections) {

        int accepted = 0;
        boolean[] invite = new boolean[numPeople];
        Queue<Integer> rejects = new LinkedList<>();

        //First screen of invitees
        for (int i = 0; i < numPeople; i++) {
            invite[i] = true; //start off by inviting everyone
            int numConnections = 0;
            for (int j = 0; j < numPeople; j++) {
                if (connections[i][j]) {
                    numConnections++;
                }
            }
            if (numConnections < 5) {
                rejects.offer(i); //this person is blacklisted
                invite[i] = false; //un-invite those who know <5 people
            }
        }

        //Make sure everyone knows 5+ people
        while (!rejects.isEmpty()) {
            int j = rejects.poll();
            for (int i = 0; i < numPeople; i++) {
                if (connections[i][j]) {
                    connections[i][j] = false;
                    connections[j][i] = false;
                    if (invite[i] && countConnections(i, connections) < 5) { //Now they can't come
                        rejects.offer(i);
                        invite[i] = false;
                    }
                }
            }
        }

        //Final count of invited guests
        System.out.println();
        for (int i = 0; i < numPeople; i++) {
            if (invite[i]) {
                System.out.println("Person " + i + " can come");
                accepted++;
            }
        }

        return accepted;
    }

    public static int countConnections(int person, boolean[][] connections) {
        int count = 0;
        for (int i = 0; i < connections.length; i++) {
            if (connections[person][i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int numPeople = sc.nextInt();

        boolean[][] connections = new boolean[numPeople][numPeople];
        System.out.println("Enter connections between people (1 if they know each other, 0 otherwise):");
        for (int i = 0; i < numPeople; i++) {
            for (int j = 0; j < numPeople; j++) {
                connections[i][j] = sc.nextInt() == 1;
            }
        }

        //Send to algorithm
        int output = partyAlgo(numPeople, connections);

        //Inform user of results
        if (output == numPeople) {
            System.out.println("Everyone knows each other, so everyone can come!");
        } else if (output == 0) {
            System.out.println("No one knew enough people, so there cannot be a party.");
        } else {
            System.out.println("Out of " + numPeople + " people, " + output + " can come to the party.");
        }
    }
}
