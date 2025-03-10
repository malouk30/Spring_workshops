package tn.esprit.arctic.first_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.arctic.first_project.entities.DetailComposant;
@Repository
public interface DetailComposantRepository extends JpaRepository<DetailComposant, Long> {
}