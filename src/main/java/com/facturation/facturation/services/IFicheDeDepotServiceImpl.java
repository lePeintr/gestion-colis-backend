package com.facturation.facturation.services;

import com.facturation.facturation.dtos.ColisDTO;
import com.facturation.facturation.dtos.FicheDeDepotDTO;
import com.facturation.facturation.entities.Colis;
import com.facturation.facturation.entities.FicheDeDepot;
import com.facturation.facturation.mappers.MapperImpl;
import com.facturation.facturation.repositories.IFicheDeDepotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * IFicheDeDepotServiceImpl.java
 * <p>
 * Auteur: Administrateur
 */
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class IFicheDeDepotServiceImpl implements IFicheDeDepotService {
    private MapperImpl mapper;
    private IFicheDeDepotRepository ficheDeDepotRepository;
    private IColisService colisService;

    @Override
    public FicheDeDepotDTO ajouterUneFicheDeDepot(FicheDeDepotDTO ficheDeDepotDTO) {
        log.info("Saving new fiche de dépot");
        FicheDeDepot ficheDeDepot = mapper.fromFicheDeDepotDTO(ficheDeDepotDTO);
        FicheDeDepot savedFicheDeDepot =  ficheDeDepotRepository.save(ficheDeDepot);
        return mapper.fromFicheDeDepot(savedFicheDeDepot);
    }

    @Override
    public FicheDeDepotDTO modifierUneFicheDeDepot(FicheDeDepotDTO FicheDeDepotDTO) {
        return null;
    }

    @Override
    public FicheDeDepotDTO afficherUneFicheDeDepotParId(Long idFicheDeDepot) {
        FicheDeDepot ficheDeDepot = ficheDeDepotRepository.findById(idFicheDeDepot).orElse(null);
        if(ficheDeDepot == null){
            //throw new ColisNotFoundException("Aucun colis trouvé.");
        }
        FicheDeDepotDTO ficheDeDepotDTO = mapper.fromFicheDeDepot(ficheDeDepot);
        return ficheDeDepotDTO;
    }

    @Override
    public List<FicheDeDepotDTO> listerToutesLesFicheDeDepot() {
        List<FicheDeDepot> listFicheDeDepot = ficheDeDepotRepository.findAll();
        List<FicheDeDepotDTO> ficheDeDepotDTOS = mapper.fromListFicheDeDepot(listFicheDeDepot);
        return ficheDeDepotDTOS;
    }

    @Override
    public void suprimmerUneFicheDeDepot(Long idFicheDeDepot) {
        FicheDeDepotDTO ficheDeDepotDTO = afficherUneFicheDeDepotParId(idFicheDeDepot);
        FicheDeDepot ficheDeDepot = mapper.fromFicheDeDepotDTO(ficheDeDepotDTO);
        ficheDeDepotRepository.delete(ficheDeDepot);
    }





}
