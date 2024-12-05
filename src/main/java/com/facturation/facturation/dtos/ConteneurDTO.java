package com.facturation.facturation.dtos;

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
@ToString
@Builder
public class ConteneurDTO {
    private String idConteneur;
    private String nomDuConteneur;
    private List<FicheDeDepotDTO> listeDesFichesDeDepot;
    private String idFicheDeDepot;
    private double coutTotalDesFichesDepotsDuConteneur;
}
