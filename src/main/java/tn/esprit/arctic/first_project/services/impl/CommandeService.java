package tn.esprit.arctic.first_project.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.first_project.entities.Client;
import tn.esprit.arctic.first_project.entities.Commande;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.repositories.ClientRepository;
import tn.esprit.arctic.first_project.repositories.CommandeRepository;
import tn.esprit.arctic.first_project.repositories.MenuRepository;
import tn.esprit.arctic.first_project.services.ICommandeService;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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


    public void ajouterCommandeEtaffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu) {
        Client client = clientRepository.findByIdentifiant(identifiant);
        Menu menu = menuRepository.findByLibelle(libelleMenu);
        commande.setClient(client);
        commande.setMenu(menu);
        commande.setTotalCommande(menu.getPrixTotal());
        commandeRepository.save(commande);
    }


    @Override
    public void affecterNoteACommande(Long idCommande, Long Note) {
        Commande commande = commandeRepository.findById(idCommande).orElse(null);
        if (commande != null) {
            commande.setNote(Note);
            commandeRepository.save(commande);
        }
    }


    public Float montantDepenseParClientEntreDeuxDates(String identifiant, LocalDate date1, LocalDate
            date2) {
        Client client = clientRepository.findByIdentifiant(identifiant);
        List<Commande> commandes = commandeRepository.findByClientIdClientAndDateCommandeBetween(client.getIdClient(), date1, date2);
        Float total = 0f;
        for (Commande commande : commandes) {
            total += commande.getTotalCommande();
        }
        return total;
    }


    //@Scheduled(cron = "*/15 * * * * ?")

    void findCurrentYearCommandesOrderByNote() {

        log.info("Commandes de l'année en cours triées par note :");
        List<Commande> commandes = commandeRepository.findByDateCommandeBetween(
                LocalDate.of(LocalDate.now().getYear(), 1, 1),
                LocalDate.of(LocalDate.now().getYear(), 12, 31)
        );


        for (Commande commande : commandes) {
            System.out.println(commande);
        }

    }


    @Scheduled(cron = "*/15 * * * * ?")
    public void menuPlusCommande() {
        List<Commande> commandes = commandeRepository.findAll();
        List<Menu> menus = menuRepository.findAll();

        Menu menuPlusCommandé = null;
        int maxCommandes = 0;

        for (Menu menu : menus) {
            int count = 0;
            for (Commande commande : commandes) {
                if (commande.getMenu().getIdMenu().equals(menu.getIdMenu())) {
                    count++;
                }
            }
            if (count > maxCommandes) {
                maxCommandes = count;
                menuPlusCommandé = menu;
            }
        }


        for (Menu menu : menus) {
            if (menu.getIdMenu().equals(menuPlusCommandé.getIdMenu())) {
                menu.setPrixTotal(menu.getPrixTotal() * 0.8f);
                menuRepository.save(menu);
            } else {
                menu.setPrixTotal(menu.getPrixTotal() * 0.95f);
                menuRepository.save(menu);
            }

            log.info("Le menu le plus commandé dans votre restaurant est " + menuPlusCommandé.getLibelleMenu() + " commandé " + maxCommandes + " fois");
        }


    }


    public void ajouterCommandeEtAffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu) {
        Client client = clientRepository.findByIdentifiant(identifiant);
        Menu menu = menuRepository.findByLibelle(libelleMenu);
        commande.setClient(client);
        commande.setMenu(menu);
        float remise  =  - (menu.getPrixTotal() * commande.getPourcentageRemise() / 100);
        commande.setTotalRemise(remise);
        commande.setTotalCommande(commande.getTotalCommande() - remise);
        commandeRepository.save(commande);
    }





}