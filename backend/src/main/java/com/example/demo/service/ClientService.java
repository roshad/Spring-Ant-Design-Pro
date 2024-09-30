package com.example.demo.service;
import com.example.demo.model.Client;

import java.util.List;

public interface ClientService {
    Client getClientById(int cid);
    List<Client> getAllClients();
    void addClient(Client client);
    void updateClient(Client client);
    void deleteClient(int cid);
}