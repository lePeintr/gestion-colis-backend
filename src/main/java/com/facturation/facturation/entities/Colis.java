package com.facturation.facturation.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Colis.java
 * <p>
 * Auteur: Administrateur
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Colis {
    @Id
    private String idColis;
    private String descriptionColis;
    private int quantite;
    private double longueur;
    private double lageur;
    private double hauteur;
    private double coutParMetreCube;
    @ManyToOne
    private FicheDeDepot ficheDeDepot;
    private Long idFicheDeDepot;

    @PrePersist
    public void generateId() {
        if (idColis == null) {
            idColis = UUID.randomUUID().toString();
        }
    }
}
