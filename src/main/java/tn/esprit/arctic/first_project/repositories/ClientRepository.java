package tn.esprit.arctic.first_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.arctic.first_project.entities.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByIdentifiant(String identifiant);
}