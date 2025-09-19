package services;

import entities.Account;
import entities.Client;
import exceptions.AccountInexistantException;
import exceptions.SoldInsuffisantException;

import java.nio.channels.AcceptPendingException;
import java.util.Collection;
import java.util.HashMap;

public class AccountService {

    public void deposit(Account account, double amount){
        if(amount > 0){
            account.setSold(account.getSold()+ amount);
        }else{
           throw new SoldInsuffisantException("try again with enough sold");
        }
    }

    public void withdraw(Account account, double amount){
        if (account == null) {
            throw new AccountInexistantException("account is not exist !");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("amount is negative");
        }
        if (account.getSold() < amount) {
//            throw new SoldInsuffisantException("Sold is not enough!");
            System.out.println("sold is not enough sir");
        }
        account.setSold(account.getSold() - amount);

    }

    public void transfer(Account source,Account destination, double amount){
        withdraw(source, amount);
        deposit(destination, amount);
    }

        public static Account findAccountByNumber(String accNumb){
            ClientService clientService = new ClientService();
//            AccountService accountService = new AccountService();
            HashMap<String ,Client> allClient = clientService.getClients();
            for(Client client: allClient.values()){
               if(client.getAccounts().containsKey(accNumb)){
                   return client.getAccounts().get(accNumb);
               }
            }
            return null;
        }
}
