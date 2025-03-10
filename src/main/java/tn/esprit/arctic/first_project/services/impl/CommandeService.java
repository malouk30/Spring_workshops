package tn.esprit.arctic.first_project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.Commande;
import tn.esprit.arctic.first_project.repositories.CommandeRepository;
import tn.esprit.arctic.first_project.services.ICommandeService;

import java.util.List;

@Service
@AllArgsConstructor

public class CommandeService implements ICommandeService {

    private CommandeRepository commandeRepository;

    @Override
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande update(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void delete(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public Commande findById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }


    public List<Commande> findByClientId(Long id) {
        return commandeRepository.findByClientIdClient(id);
    }
}