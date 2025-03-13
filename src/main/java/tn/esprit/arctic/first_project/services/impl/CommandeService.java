package tn.esprit.arctic.first_project.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.Client;
import tn.esprit.arctic.first_project.entities.Commande;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.repositories.ClientRepository;
import tn.esprit.arctic.first_project.repositories.CommandeRepository;
import tn.esprit.arctic.first_project.repositories.MenuRepository;
import tn.esprit.arctic.first_project.services.ICommandeService;

import java.awt.*;
import java.util.List;

@Service
@AllArgsConstructor

public class CommandeService implements ICommandeService {

    private CommandeRepository commandeRepository;
  private MenuRepository menuRepository;

  private ClientRepository clientRepository;
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


    /*
    Créer un service permettant l’ajout d’une commande et de l’associer au client et menu en
paramètres et exposer le en respectant la signature suivante :
void ajouterCommandeEtaffecterAClientEtMenu(Commande commande, String identifiant,
String libelleMenu);
PS ; Le total commande et le total remise est calculable selon le prix du menu envoyé et le
pourcentage de la remise

    * */

    public void ajouterCommandeEtaffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu) {
        Client client = clientRepository.findByIdentifiant(identifiant);
        Menu menu = menuRepository.findByLibelleMenu(libelleMenu);
        commande.setClient(client);
        commande.setMenu(menu);
        commande.setTotalCommande(menu.getPrixTotal());
        commandeRepository.save(commande);
    }


}