package repository;

import entities.Transaction;
import entities.Account;

import java.io.FileWriter;
import java.io.IOException;

public class AccountRepository {

    public void transactionsDataSave(Account account, Transaction transaction){
        // we must use try pecause all the time the file throw an exception
        try (FileWriter writer = new FileWriter(account.getAccountNumber() + ".txt", true)) {
            writer.write(transaction.getDate() + " | "
                    + transaction.getType() + " | "
                    + transaction.getMontant() + " | "
                    + transaction.getAccountSource() + " | "
                    + transaction.getIdTransaction() + "\n");
        } catch (IOException e) {
            System.out.println("access to file is failed" + e);
        }
    }
}
