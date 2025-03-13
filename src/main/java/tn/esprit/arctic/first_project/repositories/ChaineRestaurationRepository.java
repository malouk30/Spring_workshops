package tn.esprit.arctic.first_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.arctic.first_project.entities.ChaineRestauration;
@Repository
public interface ChaineRestaurationRepository extends JpaRepository<ChaineRestauration, Long> {
    ChaineRestauration findByLibelle(String libelleChaine);
}