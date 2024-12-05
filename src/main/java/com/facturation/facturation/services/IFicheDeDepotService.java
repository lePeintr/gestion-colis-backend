package com.facturation.facturation.services;

import com.facturation.facturation.dtos.ColisDTO;
import com.facturation.facturation.dtos.FicheDeDepotDTO;
import com.facturation.facturation.entities.Colis;

import java.util.List;

public interface IFicheDeDepotService {
    FicheDeDepotDTO ajouterUneFicheDeDepot(FicheDeDepotDTO ficheDeDepotDTO);
    FicheDeDepotDTO modifierUneFicheDeDepot(FicheDeDepotDTO FicheDeDepotDTO);
    FicheDeDepotDTO afficherUneFicheDeDepotParId(Long idFicheDeDepot);
    List<FicheDeDepotDTO> listerToutesLesFicheDeDepot();
    void suprimmerUneFicheDeDepot(Long idFicheDeDepot);

}
