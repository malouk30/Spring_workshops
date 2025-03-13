package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.ChefCuisinier;

import java.util.List;

public interface IChefCuisinierService {
    ChefCuisinier save(ChefCuisinier chefCuisinier);
    ChefCuisinier update(ChefCuisinier chefCuisinier);
    void delete(Long id);
    ChefCuisinier findById(Long id);
    List<ChefCuisinier> findAll();

    ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu);
    ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu, Long idChefCuisinier);}