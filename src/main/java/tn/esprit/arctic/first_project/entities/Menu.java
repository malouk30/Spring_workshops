package tn.esprit.arctic.first_project.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenu;
    private String libelleMenu;
    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;
    private Float prixTotal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="menu")
    private Set<Commande> commandes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="menu")
    private Set<Composant> composants;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ChefCuisinier> chefCuisiniers;
}
