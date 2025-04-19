package tn.esprit.arctic.first_project.services;

import tn.esprit.arctic.first_project.entities.*;

import java.util.List;
import java.util.Set;

public interface IMenuService {
    Menu save(Menu menu);
    Menu update(Menu menu);
    void delete(Long id);
    Menu findById(Long id);
    List<Menu> findAll();
    
    Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu);

    List<String> nomMenuParTypeMenuOrdonneParPrixTotal(TypeMenu typeMenu);

    List <Menu> listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(
            TypeMenu  typeMenu, Float prixTotal);
}