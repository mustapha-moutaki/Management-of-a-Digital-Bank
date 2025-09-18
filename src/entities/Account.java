package entities;

import java.util.HashSet;

public class Account {
    private static int counter = 100;// we made it static to save the old number
    private int id;
    private String accountNumber;
    private double sold;
    private AccountType accountType = AccountType.CURRENT;//deafult account type

    HashSet<Transaction>history = new HashSet<>();

    Account(int id, String accountNumber, double sold, AccountType accountType){
        this.id = ++counter;
        this.accountNumber = accountNumber;
        this.sold = sold;
        this.accountType = accountType != null ? accountType : AccountType.CURRENT; ;
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
    public void setTypeCompte(AccountType accountType){
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
    public AccountType getAccountType(){
        return this.accountType;
    }
    public HashSet<Transaction> getHistory(){
        return this.history;
    }

}
