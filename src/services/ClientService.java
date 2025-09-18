package services;

import entities.Client;
import exceptions.AccountInexistantException;

import java.util.HashMap;

public class ClientService {


    HashMap<String,Client>clients = new HashMap<>();
    // to create an account
    public void addClient(Client client){
        clients.put(client.getIdClient(), client);
    }
    // to search for an account

    public Client findClient(String id){// return type is client to return client object

        if(id == null|| !clients.containsKey(id)){
            // if the id is null or is not exist in the hashmap
            throw new AccountInexistantException("account with id: " + id +" is not exist");
        }
        return clients.get(id);
    }
    //to update client info
    public void updateClient(String id, String firstName, String lastName, String email){
        Client client = findClient(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(lastName);
    }
}
