package entities;

import java.util.HashMap;

public class Client extends Person {
    private String idClient;
    private HashMap<String, Account> accounts = new HashMap<>();
    private static int counter = 100;

    //remove id and client id from the constructor to avoid require it in account creation
    public Client(String firstName, String lastName, String email, String password, HashMap<String, Account> accounts) {
        super(++counter, firstName, lastName, email, password);
        this.idClient = "Mus" + counter;
    }

    public String getIdClient() {
        return this.idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }


}
