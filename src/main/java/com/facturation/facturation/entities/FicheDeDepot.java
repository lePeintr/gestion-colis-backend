package com.facturation.facturation.entities;

import com.facturation.facturation.enums.TypeFacture;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * FicheDeDepot.java
 * <p>
 * Auteur: Administrateur
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class FicheDeDepot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFicheDeDepot;
    private String numeroDuConteneur;
    private String nomExpediteur;
    private double numeroExpediteur;
    private String emailExpediteur;
    private int nombreTotalColis;
    private Date dateDeDepotDuColis;
    private String nomDuDestinataire;
    private double numeroDestinataire;
    private String emailDestinataire;
    private String destination;
    @OneToMany(mappedBy = "ficheDeDepot", fetch=FetchType.LAZY)
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private List<Colis> listeDesColis;
    private double coutTotalDesColis;
    @Enumerated(EnumType.STRING)
    private TypeFacture typeFacture;
    @ManyToOne
    private Conteneur conteneur;
    private String idConteneur;

}
