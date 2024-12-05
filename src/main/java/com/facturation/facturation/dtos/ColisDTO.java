package com.facturation.facturation.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

/**
 * Colis.java
 * <p>
 * Auteur: Administrateur
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ColisDTO {
    private String idColis;
    private String descriptionColis;
    private int quantite;
    private double longueur;
    private double lageur;
    private double hauteur;
    private double coutParMetreCube;
    private FicheDeDepotDTO ficheDeDepot;
    private String idFicheDeDepot;

}
