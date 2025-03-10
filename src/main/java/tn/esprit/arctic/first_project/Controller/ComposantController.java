package tn.esprit.arctic.first_project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.first_project.entities.Composant;
import tn.esprit.arctic.first_project.services.IComposantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Composant")
public class ComposantController {
    IComposantService ComposantService;

    @GetMapping("/retrieve-all-Composants")
    public List<Composant> getComposant() {
        return ComposantService.findAll();
    }
    @GetMapping("/retrieve-Composant/{Composant-id}")
    public Composant retrieveComposant(@PathVariable("Composant-id") Long ComposantId) {
        return ComposantService.findById(ComposantId);
    }
    @PostMapping("/add-Composant")
    public Composant addCComposant(@RequestBody Composant c) {
        return ComposantService.save(c);
    }
    @DeleteMapping("/remove-Composant/{Composant-id}")
    public void removeComposant(@PathVariable("Composant-id") Long ComposantId) {
        ComposantService.delete(ComposantId);
    }
    @PutMapping("/update-Composant")
    public Composant updateComposant(@RequestBody Composant c) {
        return ComposantService.update(c);
    }
}
