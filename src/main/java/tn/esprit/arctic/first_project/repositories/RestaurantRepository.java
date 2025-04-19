package tn.esprit.arctic.first_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.arctic.first_project.entities.Commande;
import tn.esprit.arctic.first_project.entities.Restaurant;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByNbPlacesMaxGreaterThanAndChainerestaurationDateCreationBefore(Long capacite, LocalDate date);


    Restaurant findByNom(String nom);
}