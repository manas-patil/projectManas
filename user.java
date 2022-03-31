package com.projectManas;

class Node{
    double data;
    double available;
    Node prev;
    String type;
    public Node(double data){
        this.data = data;
        this.prev = null;
        this.type = "";
        this.available = 0;
    }
}

public class user {
    private int id;
    private String password;
    private long mobNumber;
    private double balance;
    public Node dummy = new Node(1), curr = dummy;

    public Node getPassbook(int id){
        return dummy.prev;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(long mobNumber) {
        this.mobNumber = mobNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        // this.curr.prev = new Node(balance);
        // curr.prev.type = "Cr";
        // curr = curr.prev;
    } 

    public void passbook(double balance){
        double bal = this.getBalance();
        if(balance<0){
            this.curr.prev = new Node(Math.abs(balance));
            curr.prev.type = "Dr";
            curr.prev.available = (bal-Math.abs(balance));
        }else{
            this.curr.prev = new Node(Math.abs(balance));
            curr.prev.type = "Cr";
            curr.prev.available = (bal+balance);
        }
        curr = curr.prev;
    }


    user(int id, String password){
        this.id = id;
        this.password = password;
        this.balance = 1000;
        this.curr.prev = new Node(1000);
        curr.prev.type = "Cr";
        curr.prev.available = 1000;
        curr = curr.prev;
    }
}
