package tn.esprit.arctic.first_project.services;

import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.Commande;
import tn.esprit.arctic.first_project.repositories.CommandeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public List<Commande> retrieveAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(Commande e) {
        return commandeRepository.save(e);
    }

    @Override
    public Commande updateCommande(Commande e) {
        return commandeRepository.save(e);
    }

    @Override
    public Commande retrieveCommande(Long idCommande) {
        Optional<Commande> commande = commandeRepository.findById(idCommande);
        return commande.orElse(null);
    }

    @Override
    public void removeCommande(Long idCommande) {
        commandeRepository.deleteById(idCommande);
    }

    @Override
    public List<Commande> addCommandes(List<Commande> commandes) {
        return commandeRepository.saveAll(commandes);
    }
}