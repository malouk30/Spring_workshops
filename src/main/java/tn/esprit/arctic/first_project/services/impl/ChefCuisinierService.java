package tn.esprit.arctic.first_project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.ChefCuisinier;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.repositories.ChefCuisinierRepository;
import tn.esprit.arctic.first_project.repositories.MenuRepository;
import tn.esprit.arctic.first_project.services.IChefCuisinierService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class ChefCuisinierService implements IChefCuisinierService {

    private ChefCuisinierRepository chefCuisinierRepository;
    private MenuRepository menuRepository;
    private ChefCuisinierRepository   chefCuisinierService;

    @Override
    public ChefCuisinier save(ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public ChefCuisinier update(ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public void delete(Long id) {
        chefCuisinierRepository.deleteById(id);
    }

    @Override
    public ChefCuisinier findById(Long id) {
        return chefCuisinierRepository.findById(id).orElse(null);
    }

    @Override
    public List<ChefCuisinier> findAll() {
        return chefCuisinierRepository.findAll();
    }


    @Override
    public ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu, Long idChefCuisinier) {
        Menu menu = menuRepository.findById(idMenu).orElse(null);
        ChefCuisinier chefCuisinier = chefCuisinierService.findById(idChefCuisinier).orElse(null);

        Set<Menu> menus = new HashSet<>();

        if(chefCuisinier.getMenus()!=null){
            menus = chefCuisinier.getMenus();
        }

        menus.remove(menu);

        chefCuisinier.setMenus(menus);

        chefCuisinierService.save(chefCuisinier);

        return chefCuisinier;
    }



    @Override
    public ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu) {
        Menu menu = menuRepository.findById(idMenu).orElse(null);
        ChefCuisinier chefCuisinier = chefCuisinierService.findById(idChefCuisinier).orElse(null);

        Set<Menu> menus = new HashSet<>();

        if(chefCuisinier.getMenus()!=null){
            menus = chefCuisinier.getMenus();
        }

        menus.add(menu);

        chefCuisinier.setMenus(menus);

        chefCuisinierService.save(chefCuisinier);

        return chefCuisinier;
    }

}