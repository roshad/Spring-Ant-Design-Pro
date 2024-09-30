package com.example.demo.service.impl;


import com.example.demo.mapper.ClientMapper;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Client getClientById(int cid) {
        return clientMapper.findById(cid);
    }

    @Override
    public List<Client> getAllClients() {
        return clientMapper.findAll();
    }

    @Override
    public void addClient(Client client) {
        clientMapper.insert(client);
    }

    @Override
    public void updateClient(Client client) {
        clientMapper.update(client);
    }

    @Override
    public void deleteClient(int cid) {
        clientMapper.delete(cid);
    }
}