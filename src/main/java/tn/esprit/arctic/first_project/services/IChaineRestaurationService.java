package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.ChaineRestauration;

import java.util.List;

public interface IChaineRestaurationService {
    ChaineRestauration save(ChaineRestauration chaineRestauration);
    ChaineRestauration update(ChaineRestauration chaineRestauration);
    void delete(Long id);
    ChaineRestauration findById(Long id);
    List<ChaineRestauration> findAll();
}