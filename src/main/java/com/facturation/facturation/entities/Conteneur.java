package com.facturation.facturation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

/**
 * Conteneur.java
 * <p>
 * Auteur: Administrateur
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Conteneur {
    @Id
    private String idConteneur;
    private String nomDuConteneur;
    @OneToMany(mappedBy = "conteneur", fetch= FetchType.LAZY)
    private List<FicheDeDepot> listeDesFichesDeDepot;
    private String idFicheDeDepot;
    private double coutTotalDesFichesDepotsDuConteneur;
}
