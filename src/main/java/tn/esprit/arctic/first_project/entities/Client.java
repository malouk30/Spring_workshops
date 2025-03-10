package tn.esprit.arctic.first_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Client implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String identifiant;
    @Temporal(TemporalType.DATE)
    private Date datePremiereVisite;
    @Transient /* ki nheb nestaaemlou fel java menghir ma yetzed fel base*/
            Integer diff;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;
    public Client(long idClient, String identifiant, Date datePremiereVisite) {
        this.idClient = idClient;
        this.identifiant = identifiant;
        this.datePremiereVisite = datePremiereVisite;
    }

    public Client(String identifiant, Date datePremiereVisite) {
        this.identifiant = identifiant;
        this.datePremiereVisite = datePremiereVisite;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Date getDatePremiereVisite() {
        return datePremiereVisite;
    }

    public void setDatePremiereVisite(Date datePremiereVisite) {
        this.datePremiereVisite = datePremiereVisite;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", identifiant='" + identifiant + '\'' +
                ", datePremiereVisite=" + datePremiereVisite +
                '}';
    }
}