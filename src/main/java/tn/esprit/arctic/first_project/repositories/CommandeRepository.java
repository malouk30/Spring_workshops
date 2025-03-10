package tn.esprit.arctic.first_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.arctic.first_project.entities.Commande;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByClientIdClient(Long id);
    List<Commande> findByClientIdClientAndDateCommandeBetween(Long id, LocalDate date1, LocalDate date2);

    List<Commande> findByDateCommandeBetweenOrderByTotalCommandeAscNoteAsc(LocalDate date1, LocalDate date2);

}