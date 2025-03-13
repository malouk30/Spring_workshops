package tn.esprit.arctic.first_project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.entities.Restaurant;
import tn.esprit.arctic.first_project.entities.TypeMenu;
import tn.esprit.arctic.first_project.repositories.RestaurantRepository;
import tn.esprit.arctic.first_project.services.IRestaurantService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Restaurant")
public class RestaurantController {
IRestaurantService RestaurantService;

RestaurantRepository restaurantRepository;

    @GetMapping("/retrieve-all-Restaurants")
    public List<Restaurant> getRestaurants() {
        return RestaurantService.findAll();
    }
    @GetMapping("/retrieve-Restaurant/{Restaurant-id}")
    public Restaurant retrieveRestaurant(@PathVariable("Restaurant-id") Long RestaurantId) {
        return RestaurantService.findById(RestaurantId);
    }
    @PostMapping("/add-Restaurant")
    public Restaurant addCRestaurant(@RequestBody Restaurant c) {
        return RestaurantService.save(c);
    }
    @DeleteMapping("/remove-Restaurant/{Restaurant-id}")
    public void removeRestaurant(@PathVariable("Restaurant-id") Long RestaurantId) {
        RestaurantService.delete(RestaurantId);
    }
    @PutMapping("/update-Restaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant c) {
        return RestaurantService.update(c);
    }



    @GetMapping("/findByNbPlacesMaxGreaterThanAndChainerestaurationDateCreationBefore/{capacite}/{date}")
    public List<Restaurant> findByNbPlacesMaxGreaterThanAndChainerestaurationDateCreationBefore(
            @PathVariable("capacite") Long capacite,
            @PathVariable("date") LocalDate date)
    {
        return restaurantRepository.findByNbPlacesMaxGreaterThanAndChainerestaurationDateCreationBefore(capacite,date);
    }




    }
