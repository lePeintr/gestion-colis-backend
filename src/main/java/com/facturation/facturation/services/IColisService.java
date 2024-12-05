package com.facturation.facturation.services;

import com.facturation.facturation.dtos.ColisDTO;
import com.facturation.facturation.exceptions.FicheDeDepotNotFoundException;

import java.util.List;

/**
 * IColisService.java
 * <p>
 * Auteur: Administrateur
 */
public interface IColisService {
    ColisDTO ajouterUnColis(Long idFicheDeDepot, ColisDTO colisDTO) throws FicheDeDepotNotFoundException;
    ColisDTO modifierUnColis(ColisDTO colisDTO);
    ColisDTO retournerUnColisParId(String idColis);
    List<ColisDTO> listerTousLesColis();
    void suprimmerUnColis(String idColis);
    double coutTotalParColis(String idColis);
    double volumeDuColis(String idColis);

    List<ColisDTO> recupererLaListeDesColisParFiche(Long idFicheDeDepot);
    double coutTotalDesColisParFiche(Long idFicheDeDepot);
    int nombreTotalDeColisParFiche(Long idFicheDeDepot);
}
