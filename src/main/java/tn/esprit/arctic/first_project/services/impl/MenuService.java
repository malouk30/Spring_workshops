package tn.esprit.arctic.first_project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.ChefCuisinier;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.entities.Restaurant;
import tn.esprit.arctic.first_project.repositories.ChefCuisinierRepository;
import tn.esprit.arctic.first_project.repositories.MenuRepository;
import tn.esprit.arctic.first_project.services.IMenuService;

import java.util.*;

@Service
@AllArgsConstructor

public class MenuService implements IMenuService {

    private MenuRepository menuRepository;
    private ChefCuisinierRepository   chefCuisinierService;

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }






}