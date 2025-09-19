
import entities.Account;
import entities.AccountType;
import entities.Transaction;
import repository.AccountRepository;
import ui.Menu;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

//        Menu menu = new Menu();
//        menu.start();

        // create an account
        Account account = new Account(123, AccountType.CURRENT);
        Account account2 = new Account(23, AccountType.CURRENT);

        // make transactions
        Transaction t1 = new Transaction("id1","deposit", 10, LocalDate.now(), "mus1", "mus2");
        Transaction t2 = new Transaction("id2","withdraw", 50, LocalDate.now(), "mus1", "mus2");

        // save it in file .txt
        AccountRepository accRepository = new AccountRepository();
        accRepository.transactionsDataSave(account, t1);
        accRepository.transactionsDataSave(account, t2);

        // dipslay transaction
        accRepository.showTransactions(account.getAccountNumber());
    }
}
