package tn.esprit.arctic.first_project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.first_project.entities.ChefCuisinier;
import tn.esprit.arctic.first_project.entities.TypeChef;
import tn.esprit.arctic.first_project.services.IChefCuisinierService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ChefCuisinier")
public class ChefCuisinierController {
    IChefCuisinierService ChefCuisinierService;


    @GetMapping("/retrieve-all-Chefs")
    public List<ChefCuisinier> getChefs() {
        return ChefCuisinierService.findAll();
    }
    @GetMapping("/retrieve-ChefCuisinier/{ChefCuisinier-id}")
    public ChefCuisinier retrieveChefCuisinier(@PathVariable("ChefCuisinier-id") Long ChefCuisinierId) {
        return ChefCuisinierService.findById(ChefCuisinierId);
    }
    @PostMapping("/add-ChefCuisinier")
    public ChefCuisinier addChefCuisinier(@RequestBody ChefCuisinier c) {
        return ChefCuisinierService.save(c);
    }
    @DeleteMapping("/remove-ChefCuisinier/{ChefCuisinier-id}")
    public void removeChefCuisinier(@PathVariable("ChefCuisinier-id") Long ChefCuisinierId) {
        ChefCuisinierService.delete(ChefCuisinierId);
    }
    @PutMapping("/update-ChefCuisinier")
    public ChefCuisinier updateChefCuisinier(@RequestBody ChefCuisinier c) {
        return ChefCuisinierService.update(c);
    }
    @DeleteMapping("/desaffecter-chef-menu/{idMenu}/{idChef}")
    public ChefCuisinier desaffecterChefCuisinierDuMenu(
            @PathVariable("idMenu") Long idMenu,
            @PathVariable("idChef") Long idChef) {
        return ChefCuisinierService.desaffecterChefCuisinierDuMenu(idMenu, idChef);
    }
    @PutMapping("/affecter-chef-menu/{idChef}/{idMenu}")
    public ChefCuisinier affecterChefCuisinierAMenu(
            @PathVariable("idChef") Long idChef,
            @PathVariable("idMenu") Long idMenu) {
        return ChefCuisinierService.affecterChefCuisinierAMenu(idChef, idMenu);
    }
    @GetMapping("/list-chef-cuisinier-by-type-chef-and-nom-restaurant/{typeChef}/{nomRestaurant}")
    public List<ChefCuisinier> listChefCuisinierByTypeChefAndNomRestaurant(
            @PathVariable("typeChef") String typeChef,
            @PathVariable("nomRestaurant") String nomRestaurant) {
        TypeChef typeChefEnum = TypeChef.valueOf(typeChef.toUpperCase());
        return ChefCuisinierService.listChefCuisinierByTypeChefAndNomRestaurant(typeChefEnum, nomRestaurant);
    }
}
