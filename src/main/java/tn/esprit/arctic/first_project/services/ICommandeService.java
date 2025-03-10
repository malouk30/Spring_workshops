package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.Commande;

import java.util.List;

public interface ICommandeService {
    Commande save(Commande commande);
    Commande update(Commande commande);
    void delete(Long id);
    Commande findById(Long id);
    List<Commande> findAll();
}