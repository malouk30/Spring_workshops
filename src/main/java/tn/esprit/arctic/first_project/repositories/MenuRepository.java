package tn.esprit.arctic.first_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.arctic.first_project.entities.Commande;
import tn.esprit.arctic.first_project.entities.Menu;
import tn.esprit.arctic.first_project.entities.TypeComposant;
import tn.esprit.arctic.first_project.entities.TypeMenu;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {


    @Query("SELECT m FROM Menu m WHERE m.typeMenu = :typeMenu ORDER BY m.prixTotal ASC")
    List<Menu> findByTypeMenuAndOrderByPrixTotal(TypeMenu typeMenu);





    @Query("select m.libelleMenu from Menu m  join m.composants c where c.detailcomposant  = :typeComposant")
    List <Menu> findByTypeComposant(TypeComposant typeComposant);



        //findbylibelle
    @Query("SELECT m FROM Menu m WHERE m.libelleMenu = :libelleMenu")
    Menu findByLibelle(String libelleMenu);


    @Query("SELECT m FROM Menu m WHERE m.typeMenu = :typeMenu AND m.prixTotal > :prixTotal")
    List<Menu> findByTypeMenuAndPrixTotalGreaterThan(TypeMenu typeMenu , Float prixTotal);
}