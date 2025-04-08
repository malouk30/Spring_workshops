package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.ChefCuisinier;
import tn.esprit.arctic.first_project.entities.Composant;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.entities.Restaurant;

import java.util.List;
import java.util.Set;

public interface IMenuService {
    Menu save(Menu menu);
    Menu update(Menu menu);
    void delete(Long id);
    Menu findById(Long id);
    List<Menu> findAll();


    Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu);
}