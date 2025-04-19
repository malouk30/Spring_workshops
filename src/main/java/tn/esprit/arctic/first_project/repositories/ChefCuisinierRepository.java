package tn.esprit.arctic.first_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.arctic.first_project.entities.ChefCuisinier;
import tn.esprit.arctic.first_project.entities.TypeChef;

import java.util.List;

@Repository
public interface ChefCuisinierRepository extends JpaRepository<ChefCuisinier, Long> {


}