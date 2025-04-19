package tn.esprit.arctic.first_project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.*;
import tn.esprit.arctic.first_project.repositories.ChefCuisinierRepository;
import tn.esprit.arctic.first_project.repositories.ComposantRepository;
import tn.esprit.arctic.first_project.repositories.MenuRepository;
import tn.esprit.arctic.first_project.services.IMenuService;

import java.util.*;

@Service
@AllArgsConstructor

public class MenuService implements IMenuService {

    private MenuRepository menuRepository;
    private ComposantRepository composantRepository;
    private ChefCuisinierRepository chefCuisinierService;

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








    public  List<String> nomMenuParTypeMenuOrdonneParPrixTotal(TypeMenu typeMenu){
        List<Menu> menus = menuRepository.findByTypeMenuAndOrderByPrixTotal(typeMenu);
        List<String> nomMenus = new ArrayList<>();

        for (Menu menu : menus) {
            nomMenus.add(menu.getLibelleMenu());
        }

        return nomMenus;
    }


    public List <Menu> listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(
            TypeMenu  typeMenu, Float prixTotal){
      return menuRepository.findByTypeMenuAndPrixTotalGreaterThan(typeMenu, prixTotal);
    }




    @Override
    public Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu) {
        Menu menu = menuRepository.findById(idMenu).orElse(null);
        if (menu == null) {
            return null;
        }

        float totalPrice = 0;
        for (Composant composant : composants) {
            totalPrice += composant.getPrix();
            composant.setMenu(menu);
        }

        if (totalPrice > 20) {
            return null;
        }

        composantRepository.saveAll(composants);



        if (menu.getComposants() == null) {
            menu.setComposants(new HashSet<>());
        }
        menu.getComposants().addAll(composants);
        menu.setPrixTotal(totalPrice);

        return menuRepository.save(menu);
    }



}