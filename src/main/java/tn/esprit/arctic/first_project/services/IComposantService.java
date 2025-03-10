package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.Composant;

import java.util.List;

public interface IComposantService {
    Composant save(Composant composant);
    Composant update(Composant composant);
    void delete(Long id);
    Composant findById(Long id);
    List<Composant> findAll();
}