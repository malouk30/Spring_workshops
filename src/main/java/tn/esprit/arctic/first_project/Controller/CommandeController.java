package tn.esprit.arctic.first_project.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.first_project.entities.Commande;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.entities.TypeMenu;
import tn.esprit.arctic.first_project.repositories.CommandeRepository;
import tn.esprit.arctic.first_project.services.ICommandeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Commande")
public class CommandeController {
ICommandeService CommandeService;
CommandeRepository commandeRepository;


    @GetMapping("/retrieve-all-Commandes")
    public List<Commande> getCommandes() {
        return CommandeService.findAll();
    }
    @GetMapping("/retrieve-Commande/{Commande-id}")
    public Commande retrieveCommande(@PathVariable("Commande-id") Long CommandeId) {
        return CommandeService.findById(CommandeId);
    }
    @PostMapping("/add-Commande")
    public Commande addCommande(@RequestBody Commande c) {
        return CommandeService.save(c);
    }
    @DeleteMapping("/remove-Commande/{Commande-id}")
    public void removeCommande(@PathVariable("Commande-id") Long CommandeId) {
        CommandeService.delete(CommandeId);
    }
    @PutMapping("/update-Commande")
    public Commande updateCommande(@RequestBody Commande c) {
        return CommandeService.update(c);
    }

    @GetMapping("/findByClientIdClient/{id}")
    public List<Commande> findByClientIdClient(@PathVariable("id") Long id){
        return commandeRepository.findByClientIdClient(id);
    }

    @GetMapping("/findByClientIdClientAndDateCommandeBetween/{id}/{date1}/{date2}")
    public List<Commande> findByClientIdClientAndDateCommandeBetween(@PathVariable("id") Long id,@PathVariable("date1") LocalDate date1,@PathVariable("date2") LocalDate date2){
        return commandeRepository.findByClientIdClientAndDateCommandeBetween(id,date1,date2);
    }

    @GetMapping("/findByDateCommandeBetweenOrderByTotalCommandeAscNoteAsc/{date1}/{date2}")
    public List<Commande> findByDateCommandeBetweenOrderByTotalCommandeAscNoteAsc(@PathVariable("date1") LocalDate date1, @PathVariable("date2") LocalDate date2){
        return commandeRepository.findByDateCommandeBetweenOrderByTotalCommandeAscNoteAsc(date1,date2);
    }

}
