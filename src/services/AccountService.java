package services;

import entities.Account;

public class AccountService {

    public void deposit(Account account, double amount){
        if(amount > 0){
            account.setSold(account.getSold()+ amount);
        }else{
            System.out.println("please try again with positive amount");
        }
    }

    public void withdraw(Account account, double amount){
        if(amount > 0 && account.getSold() >= amount){
            account.setSold(account.getSold() - amount);
        }else{
            System.out.println(" u don't have enough sold, please try again");
        }
    }

    public void transfer(Account source,Account destination, double amount){
        withdraw(source, amount);
        deposit(destination, amount);
    }
}
