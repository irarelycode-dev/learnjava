// Assignment 1 Part II-B (COMP 6481 Fall22)
// Name: Vignesh Pugazhendhi
// Student Id: 40230262

package com.assignmentppsfall2022;

import java.util.*;

public class VoterApplication {
    private static final String password = "password";
    Voter[] voters;
    private int countWrongPassword = 0;
    private long voterId = 0;
    Scanner scan;


    //Following method insert new voter
    private void storeVoters(int votersCount) {
        int i = 0;
        while (i < votersCount) {
            System.out.println("****** Enter voter number " + Voter.findNumberOfCreatedVoters() + " details******");
            System.out.println("Enter voter email:");
            String voterEmail = this.scan.nextLine();
            System.out.println("Enter voter name:");
            String voterName = this.scan.nextLine();
            System.out.println("Enter voter age:");
            byte voterAge = 0;
            while (true) {
                try {
                    voterAge = this.scan.nextByte();
                    if (voterAge <= 0) throw new InputMismatchException();
                    this.scan.nextLine();
                    break;
                } catch (InputMismatchException error) {
                    System.out.println("Please enter a valid age. Age cannot be negative or zero and can be maximum of 127 and should consists of numericals alone");
                    System.out.println("Re-enter age please:");
                    this.scan.nextLine();
                }
            }
            System.out.println("Enter postal code:");
            String voterPCode = this.scan.nextLine();
            char[] pcode = voterPCode.toCharArray();
            Voter voter = new Voter(++voterId, voterEmail, voterName, voterAge, pcode);
            int voterIndex = Voter.findNumberOfCreatedVoters() - 1;
            this.voters[voterIndex] = voter;
            i++;
        }
    }

    //checks password for entering new user
    //compares password with static final password variable-"password"
    //if entered incorrectly for 3 times, returns to main menu
    //if this happens 12 times, program will exit with status code 0
    private boolean checkPassword() {
        while (true) {
            System.out.print("Enter password to continue:");
            String password = scan.nextLine();
            if (password.equals(VoterApplication.password)) break;
            else {
                System.out.println("Incorrect password");
                countWrongPassword++;
                if (countWrongPassword == 12) {
                    System.out.println("Program detected suspicious activities and will terminate immediately!");
                    System.exit(0);
                }
                if (countWrongPassword % 3 == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //actual method to enter new voters
    //above two methods are called from here based on given conditions
    //this method checks how many voters can be added by comparing with voterCount variable and Voter[]
    public void enterNewVoters() {
        String proceed = "N";
        boolean doPasswordsMatch = checkPassword();
        if (!doPasswordsMatch) {
            return;
        }
        int voterCount = Voter.findNumberOfCreatedVoters();
        if (voterCount == voters.length) {
            System.out.println("Our system is flooded as of now. You cannot enter new voters");
            return;
        }
        System.out.println("How many voters do you want to enter details for:");
        int n = scan.nextInt();
        scan.nextLine();
        int sum = voterCount + n;
        if (sum > voters.length) {
            System.out.println("You can only enter " + (voters.length - voterCount) + " new voter(s)");
            if (voterCount > 0)
                System.out.println("There are already " + voterCount + " voters in our system and the capacity is:" + voters.length);
            System.out.print("Proceed? (Y/N):");
            while (true) {
                proceed = scan.nextLine();
                if (proceed.equals("Y")) {
                    storeVoters(voters.length - voterCount);
                    break;
                } else if (proceed.equals("N")) {
                    return;
                } else {
                    System.out.println("You must enter one of (Y/N)");
                    System.out.print("Proceed? (Y/N):");
                }
            }
        } else {
            storeVoters(n);
        }
        System.out.println("New voters added");
        return;
    }


    // Following methods update a voter's information


    //This method checks password before updating a voter's information
    private boolean checkPasswordForUpdating() {
        int i = 0;
        while (i < 3) {
            System.out.print("Enter password to continue:");
            String password = scan.nextLine();
            if (password.equals(VoterApplication.password)) break;
            else {
                System.out.println("Incorrect password");
                i++;
            }
        }
        if (i == 3) return false;
        return true;
    }

    //finds and returns the Voter Object and it's index based on voterId
    private ArrayList<Object> findAndReturnVoter(long voterId) {
        Voter targetVoter = null;
        int index = 0;
        for (Voter voter : this.voters) {
            if (voter.getVoterId() == voterId) {
                targetVoter = voter;
                index++;
                break;
            }
        }
        ArrayList<Object> al = new ArrayList<>();
        al.add(index - 1);
        al.add(targetVoter);
        return al;
    }

    //displays a voter's information
    private void displayVoterInformation(Voter voterObj, int voterIndex) {
        System.out.println("*******Voter***************************************");
        System.out.println("Voter: #" + voterIndex);
        System.out.println(voterObj.toString());
        System.out.println("****************************************************");
    }

    // updates user by asking the voterId first
    // If found, the loop is broke and subsequent lines are excuted
    // Else asks for alternate voterId or return to main menu
    private boolean updateUser() {
        String proceed = "Y";
        long voterId=0;
        while (true) {
            System.out.print("Enter voter Id of the voter whose details you want to update:");
            try{
                voterId = this.scan.nextLong();
            }catch(Exception e){
                System.out.println("Invalid voterId");
                System.exit(1);
            }
            long finalVoterId = voterId;
            boolean doesVoterExist = Arrays.stream(this.voters).anyMatch(voter -> voter.getVoterId() == finalVoterId);
            if (doesVoterExist) break;
            System.out.println("Voter with given voterId could not be found");
            System.out.print("Do you want to enter another voterId? (Y/N):");
            this.scan.nextLine();
            String ans = this.scan.nextLine();
            if (!ans.equals(proceed)) return false;
            else break;
        }
        ArrayList<Object> voter = findAndReturnVoter(voterId);
        Integer voterIndex = (Integer) voter.get(0);
        Voter voterObj = (Voter) voter.get(voter.size() - 1);
        System.out.println("********Current information about the voter********");
        displayVoterInformation(voterObj, voterIndex);
        while (true) {
            int choice;
            System.out.println("Which information would you like to change?");
            System.out.println("1.Name");
            System.out.println("2.Age");
            System.out.println("3.Email");
            System.out.println("4.PCode");
            System.out.println("5.Quit");
            while (true) {
                try {
                    String chose = this.scan.nextLine();
                    if (chose.equals("1") || chose.equals("2") || chose.equals("3") || chose.equals("4") || chose.equals("5")) {
                        choice = Integer.parseInt(chose);
                        break;
                    } else {
                        System.out.println("Choose one of five options:");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input mismatch exception");
                }
            }

            System.out.println();
            if (choice == 5) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter new name:");
                    System.out.println();
                    String name = this.scan.nextLine();
                    System.out.println("get name:" + name);
                    voterObj.setVoterName(name);
                    System.out.println("Name has been updated");
                    displayVoterInformation(voterObj, voterIndex);
                    break;
                case 2:
                    System.out.print("Enter new age:");
                    System.out.println();
                    byte voterAge = 0;
                    while (true) {
                        try {
                            voterAge = this.scan.nextByte();
                            if (voterAge <= 0) throw new InputMismatchException();
                            this.scan.nextLine();
                            break;
                        } catch (InputMismatchException error) {
                            System.out.println("Please enter a valid age. Age cannot be negative or zero and can be maximum of 127 and should consists of numericals alone");
                            System.out.println("Re-enter age please:");
                            this.scan.nextLine();
                        }
                    }
                    voterObj.setAge(voterAge);
                    System.out.println("Age has been updated");
                    displayVoterInformation(voterObj, voterIndex);
                    break;
                case 3:
                    System.out.print("Enter email:");
                    System.out.println();
                    String email = this.scan.nextLine();
                    voterObj.setVoterEmail(email);
                    System.out.println("Email has been updated");
                    displayVoterInformation(voterObj, voterIndex);
                    break;
                case 4:
                    System.out.println("Enter PCode:");
                    System.out.println();
                    String pCode = this.scan.nextLine();
                    voterObj.setVoterPCode(pCode.toCharArray());
                    System.out.println("Postal code has been updated");
                    displayVoterInformation(voterObj, voterIndex);
                    break;
                default:
                    System.out.println("Enter one of the 5 ");
                    break;
            }
        }
        return true;
    }

    //Above two methods are called from this method for updating a voter's information
    public void changeVoterInformation() {
        int voterCount = Voter.findNumberOfCreatedVoters();
        if (voterCount == 0) {
            System.out.println("Our system is empty :(");
            System.out.println("There are no voters in our system");
            return;
        }
        boolean verifyPassword = checkPasswordForUpdating();
        if (!verifyPassword) {
            return;
        }
        boolean res = updateUser();
        if (!res) return;
    }


    //Following method retrieves all voters in a postal code
    public void findVotersBy() {
        int voterCount = Voter.findNumberOfCreatedVoters();
        System.out.println("Enter postal code:");
        char[] postalCode = this.scan.nextLine().toCharArray();
        boolean flag = false;
        for (int i = 0; i < voterCount; i++) {
            if (Arrays.equals(voters[i].getVoterPCode(), postalCode)) {
                flag = true;
                displayVoterInformation(voters[i], i);
            }
        }
        if (flag == false) System.out.println("There are no voters in the postal code " + new String(postalCode));
    }


    //Following method(s) help to retrieve voters under a certain age
    public void findYoungerThan() {
        int voterCount = Voter.findNumberOfCreatedVoters();
        System.out.print("Enter age:");
        byte age = 0;
        while (true) {
            try {
                age = this.scan.nextByte();
                if (age <= 0) throw new InputMismatchException();
                this.scan.nextLine();
                break;
            } catch (InputMismatchException error) {
                System.out.println("Please enter a valid age. Age cannot be negative or zero and can be maximum of 127 and should consists of numericals alone");
                System.out.println("Re-enter age please:");
                this.scan.nextLine();
            }
        }
        boolean flag = false;
        System.out.println("Voters of age less than " + age + " details:");
        for (int i = 0; i < voterCount; i++) {
            if (voters[i].getVoterAge() < age) {
                flag = true;
                displayVoterInformation(voters[i], i);
            }
        }
        if (flag == false) System.out.println("There are no voters under the age " + age);
    }


    //driver code
    public static void main(String[] args) {
        VoterApplication app = new VoterApplication();
        System.out.println("Welcome");
        app.scan = new Scanner(System.in);
        System.out.print("What is the maximum number of voters in your area:");
        int n = 0;
        try {
            n = app.scan.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid number of voters.");
            System.exit(1);
        }
        app.scan.nextLine();
        app.voters = new Voter[n];
        int option = 0;
        while (option != 5) {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("    1.Enter new voters(password required)");
            System.out.println("    2.Change information of a voter (password required)");
            System.out.println("    3.Display all voters by a specific voterPcode");
            System.out.println("    4.Display all voters under a certain age");
            System.out.println("    5.Quit");
            System.out.print("You choose:");
            while (true) {
                String chose = app.scan.nextLine();
                if (chose.equals("1") || chose.equals("2") || chose.equals("3") || chose.equals("4") || chose.equals("5")) {
                    option = Integer.parseInt(chose);
                    break;
                } else {
                    System.out.println("Choose one of five options:");
                }
            }
            System.out.println();
            if (option > 5 || option <= 0) {
                System.out.println("Only one of the five can be chosen");
            } else {
                switch (option) {
                    case 1:
                        app.enterNewVoters();
                        break;
                    case 2:
                        app.changeVoterInformation();
                        break;
                    case 3:
                        app.findVotersBy();
                        break;
                    case 4:
                        app.findYoungerThan();
                        break;
                    case 5:
                        System.out.println("Bye!");
                        break;
                    default:
                }
            }
        }

    }
}
