package repository;

import entities.Account;
import entities.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccountRepository {

    public void transactionsDataSave(Account account, Transaction transaction) {
        String fileName = account.getAccountNumber() + "_transactions.txt";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(
                    "ID: " + transaction.getIdTransaction() + " | "
                            + "Date: " + transaction.getDate() + " | "
                            + "Type: " + transaction.getType() + " | "
                            + "Amount: " + transaction.getMontant() + " | "
                            + "Source: " + transaction.getAccountSource() + " | "
                            + "Destination: " + transaction.getAccountDestination()
                            + System.lineSeparator()
            );
        } catch (IOException e) {// best practice to use existing exceptions handlers
            System.out.println("Failed to save transaction: " + e.getMessage());
        }
    }

    public void showTransactions(String accountNumber) {
        String fileName = accountNumber + "_transactions.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("===== Transactions of account " + accountNumber + " =====");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("=========================================");
        } catch (IOException e) {
            System.out.println("No transactions found on this accot" + accountNumber);
        }
    }
}
