package entities;

import java.util.HashMap;

public class Client extends Person {
    private String idClient;
    private HashMap<String, Account> accounts = new HashMap<>();


    public Client(int id, String firstName, String lastName, String email, String password, String idClient, HashMap<String, Account> accounts) {
        super(id, firstName, lastName, email, password);
        this.idClient = idClient;
        this.accounts = accounts;
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
