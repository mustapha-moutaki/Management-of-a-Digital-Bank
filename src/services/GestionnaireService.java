package services;

import entities.Client;
import exceptions.AccountInexistantException;

import java.util.HashMap;

public class GestionnaireService {
    private HashMap<String, Client>clients = new HashMap();

        public Client searchClient(String clientId) throws AccountInexistantException {
            if (clientId == null || !clients.containsKey(clientId)) {
                throw new AccountInexistantException("Client with this ID does not exist");
            }
            return clients.get(clientId);
        }

    public void addClient(Client client){
        //
    }
    public void editClientInfo(Client client, String firstName, String lastName, String email) {
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
    }
}
