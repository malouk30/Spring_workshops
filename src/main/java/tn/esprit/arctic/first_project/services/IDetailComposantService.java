package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.DetailComposant;

import java.util.List;

public interface IDetailComposantService {
    DetailComposant save(DetailComposant detailComposant);
    DetailComposant update(DetailComposant detailComposant);
    void delete(Long id);
    DetailComposant findById(Long id);
    List<DetailComposant> findAll();
}