package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.Client;

import java.util.List;

public interface IClientService {
    Client save(Client client);
    Client update(Client client);
    void delete(Long id);
    Client findById(Long id);
    List<Client> findAll();

}