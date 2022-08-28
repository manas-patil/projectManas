package com.projectManas;
import java.util.*;

public class Bank {
    
    private HashMap<Integer, user> users;
    // private Stack<Integer> stack;

    Bank(){
        users = new HashMap<>();
    }

    public void addUser(int id, String pass){
        user newUser = new user(id, pass);
        if(users.containsKey(id)){
            System.out.println("User already exists");
        }
        else{
            users.put(id, newUser);
            System.out.println("User account sucessfully created");

        }        
    }

    public boolean verifyCredentials(int id, String pass){
        if(!users.containsKey(id)){
            System.out.println("User doesn't exist.");
            return false;
        }
        user check = users.get(id);
        
        return check.getPassword().equals(pass);
    }

    public void sendMoney(int receiverId, int senderId, Double money){
        if(users.containsKey(receiverId)==false){
            System.out.println("Entered Id doesn't exist");
            return;
        }
        user sender = users.get(senderId);
        if(sender.getBalance()>=money){
            System.out.println("Transferring amount");

            user receiver = users.get(receiverId);
            
            receiver.passbook(money);
            sender.passbook(money*-1);
            sender.setBalance(sender.getBalance()-money);
            receiver.setBalance(receiver.getBalance()+money);

            System.out.println("Money transfer is successful");
            System.out.println("Your updated balance is "+ sender.getBalance());
        }
        else{
            System.out.println("Balance low! Add money to tranfer.");
        }
    }

    public void withdraw(int id, double money){
        user cust = users.get(id);
        
        if(money<cust.getBalance()){
            cust.passbook(money*-1);
            cust.setBalance(cust.getBalance()-money);
            System.out.println("Print the receipt & Collect the money from any TOY bank branch.");
        }
        else{
            System.out.println("Insufficient balance, cann't process request.");
        }
        
    }
    public void delete(int id){
        if(users.remove(id)==null){

        }
        System.out.println("User id "+ id +" has been sucessfully deleted");
    }
    public void checkBal(int id) {
        user check = users.get(id);
        System.out.println("The available balance is Rs."+ check.getBalance());
    }

    public void passbook(int id){
        user check = users.get(id);

        Node head = check.getPassbook(id);
        System.out.println("Credits/Withdrawls            Closing Balance");
        while(head!=null){
            System.out.println(head.data+head.type+" ----------------- "+ head.available);
            head = head.prev;
        }

        System.out.println("Available balance is: " + check.getBalance());
    }


}
