package tn.esprit.arctic.first_project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.ChaineRestauration;
import tn.esprit.arctic.first_project.entities.Commande;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.entities.Restaurant;
import tn.esprit.arctic.first_project.repositories.ChaineRestaurationRepository;
import tn.esprit.arctic.first_project.repositories.RestaurantRepository;
import tn.esprit.arctic.first_project.services.IRestaurantService;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor

public class RestaurantService implements IRestaurantService {

    private RestaurantRepository restaurantRepository;

    private ChaineRestaurationRepository chaineRestaurationRepository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }



    public Restaurant affecterRestaurantAChaineRestauration(String nomRestaurant, String libelleChaine) {
        Restaurant restaurant = restaurantRepository.findByNom(nomRestaurant);

        ChaineRestauration chaineRestauration = chaineRestaurationRepository.findByLibelle(libelleChaine);

        restaurant.setChainerestauration(chaineRestauration);

        return restaurantRepository.save(restaurant);
    }

    public Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant) {
        Set<Menu> menus  =  new HashSet<>();
        for (Menu menu : restaurant.getMenus()) {

            menu.setPrixTotal((float) 0);
            menus.add(menu);

        }

        restaurant.setMenus(menus);

        restaurantRepository.save(restaurant);
        return restaurant;
    }









}