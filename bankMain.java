package com.projectManas;

import java.util.*;

public class bankMain {
    /*
     * Create Account
     * Send Money -> user, password, amount, destinationAccountNumber
     * Check Balance -> user, password
     * Withdraw Money -> user, password, amount
     * Bank passbook
     * 
     * Delete Account -> user, password
     */


    public static void main(String[] args) {
        Bank bank = new Bank();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Toy Bank");

        int option;
        do{
            System.out.println("Choose an option - ");
            System.out.println("1. Create Account");
            System.out.println("2. Transfer Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Passbook");
            
            System.out.println("7. Delete acc");
            System.out.println("8. Exit");

            int id;
            String password;
            boolean loggedIn;

            option = sc.nextInt();
            switch(option){
                case 1:
                    System.out.println("Enter id: ");
                    id = sc.nextInt();
                    System.out.println("Enter a password");
                    password = sc.next();

                    bank.addUser(id, password);
                    break;

                case 2:
                    System.out.println("Enter id: ");
                    id = sc.nextInt();
                    System.out.println("Enter a password");
                    password = sc.next();
                    loggedIn = bank.verifyCredentials(id, password);
                    if(loggedIn){
                        System.out.println("Enter the receiver id");
                        int receiverId = sc.nextInt();
                        System.out.println("Enter the amount to transfer: ");
                        double money = sc.nextDouble();
                        bank.sendMoney(receiverId, id, money);
                    }
                    else{
                        System.out.println("Bad Credentials");
                    }
                    break;
                case 3:
                    System.out.println("Enter id to check balance: ");
                    id = sc.nextInt();
                    System.out.println("Enter password: ");
                    password = sc.next();
                    loggedIn = bank.verifyCredentials(id, password);
                    if(loggedIn){
                        bank.checkBal(id);
                    }
                    else{
                        System.out.println("Bad Credentials");
                    }
                    break;
                case 4:
                    System.out.println("Enter id: ");
                    id = sc.nextInt();
                    System.out.println("Enter a password");
                    password = sc.next();
                    loggedIn = bank.verifyCredentials(id, password);
                    if(loggedIn){
                        System.out.println("Enter the amount to be withdraw: ");
                        Double money = sc.nextDouble();
                        bank.withdraw(id, money);
                        
                    }
                    else{
                        System.out.println("Bad Credentials");
                    }
                    break;
                case 5:
                    System.out.println("Enter id: ");
                    id = sc.nextInt();
                    System.out.println("Enter a password");
                    password = sc.next();
                    loggedIn = bank.verifyCredentials(id, password);
                    if(loggedIn){
                        bank.passbook(id);
                    }
                    else{
                        System.out.println("Bad Credentials");
                    }
                    break;

                case 7:
                    System.out.println("Enter the id to be removed: ");
                    id = sc.nextInt();
                    System.out.println("Enter the password to the given Id: ");
                    password = sc.next();
                    loggedIn = bank.verifyCredentials(id, password);
                    if(loggedIn)
                        bank.delete(id);
                    else
                        System.out.println("Bad credentials");
                    break;
                case 8:
                    System.out.println("You can close the terminal, Thank You!");
                    break;
            }
        }while(option!=8);




    }
}
