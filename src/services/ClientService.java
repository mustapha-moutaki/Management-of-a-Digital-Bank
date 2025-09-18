package services;

import entities.Client;

import java.util.HashMap;

public class ClientService {


    HashMap<String,Client>clients = new HashMap<>();

    public void addClient(Client client){
        clients.put(client.getIdClient(), client);
    }
    public Client findClient(String id){// return type is client to return client object
        return clients.get(id);
    }
}
