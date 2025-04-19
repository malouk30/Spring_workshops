package tn.esprit.arctic.first_project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.Composant;
import tn.esprit.arctic.first_project.repositories.ComposantRepository;
import tn.esprit.arctic.first_project.services.IComposantService;

import java.util.List;

@Service
@AllArgsConstructor

public class ComposantService implements IComposantService {

    private ComposantRepository composantRepository;

    @Override
    public Composant save(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public Composant update(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public void delete(Long id) {
        composantRepository.deleteById(id);
    }

    @Override
    public Composant findById(Long id) {
        return composantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Composant> findAll() {
        return composantRepository.findAll();
    }
}