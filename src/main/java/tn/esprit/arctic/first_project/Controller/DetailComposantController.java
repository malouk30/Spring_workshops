package tn.esprit.arctic.first_project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.first_project.entities.DetailComposant;
import tn.esprit.arctic.first_project.services.IDetailComposantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Dcomposant")
public class DetailComposantController {
IDetailComposantService DetailComposantService;

    @GetMapping("/retrieve-all-Dcomposant")
    public List<DetailComposant> getDcomposants() {
        return DetailComposantService.findAll();
    }
    @GetMapping("/retrieve-Dcomposant/{Dcomposant-id}")
    public DetailComposant retrieveDcomposants(@PathVariable("Dcomposant-id") Long Dcomposantid) {
        return DetailComposantService.findById(Dcomposantid);
    }
    @PostMapping("/add-Dcomposant")
    public DetailComposant addDcomposant(@RequestBody DetailComposant Dcomposant) {
        return DetailComposantService.save(Dcomposant);
    }
    @DeleteMapping("/remove-Dcompsant/{Dcomposant-id}")
    public void removeDcomposant(@PathVariable("Dcomposant-id") Long Dcomposantid) {
        DetailComposantService.delete(Dcomposantid);
    }
    @PutMapping("/update-Dcomposant")
    public DetailComposant updateDcomposant(@RequestBody DetailComposant Dcomposant) {
        return DetailComposantService.update(Dcomposant);
    }
}
