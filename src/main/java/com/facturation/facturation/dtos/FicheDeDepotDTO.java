package com.facturation.facturation.dtos;

import com.facturation.facturation.enums.TypeFacture;
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
@ToString
@Builder
public class FicheDeDepotDTO {
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
    private List<ColisDTO> listeDesColis;
    private double coutTotalDesColis;
    private TypeFacture typeFacture;
    private ConteneurDTO conteneur;
    private String idConteneur;

}
