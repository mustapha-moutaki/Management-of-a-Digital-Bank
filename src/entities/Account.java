package entities;

import java.util.HashSet;

public class Account {
    private int id;
    private String accountNumber;
    private double sold;
    private String accountType = "Courant";// Courant, Epargne

    HashSet<Transaction>history = new HashSet<>();

    Account(int id, String accountNumber, double sold, String accountType){
        this.id = id;
        this.accountNumber = accountNumber;
        this.sold = sold;
        this.accountType = accountType;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setSold(double sold){
        this.sold = sold;
    }
    public void setTypeCompte(String accountType){
        this.accountType = accountType;
    }
    public void setHistory(HashSet<Transaction> history){
        this.history = history;
    }

    // getters
    public int getId(){
        return this.id;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public double getSold(){
        return this.sold;
    }
    public String getAccountType(){
        return this.accountType;
    }
    public HashSet<Transaction> getHistory(){
        return this.history;
    }

}
