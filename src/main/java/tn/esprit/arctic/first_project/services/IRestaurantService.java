package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.Restaurant;

import java.util.List;

public interface IRestaurantService {
    Restaurant save(Restaurant restaurant);
    Restaurant update(Restaurant restaurant);
    void delete(Long id);
    Restaurant findById(Long id);
    List<Restaurant> findAll();

    Restaurant affecterRestaurantAChaineRestauration(String nomRestaurant, String libelleChaine);
    Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant);



}