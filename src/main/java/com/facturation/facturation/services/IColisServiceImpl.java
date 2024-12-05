package com.facturation.facturation.services;

import com.facturation.facturation.dtos.ColisDTO;
import com.facturation.facturation.entities.Colis;
import com.facturation.facturation.entities.FicheDeDepot;
import com.facturation.facturation.exceptions.FicheDeDepotNotFoundException;
import com.facturation.facturation.mappers.MapperImpl;
import com.facturation.facturation.repositories.IColisRepository;
import com.facturation.facturation.repositories.IFicheDeDepotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * IColisServiceImpl.java
 * <p>
 * Auteur: Administrateur
 */
@Service
@AllArgsConstructor
@Slf4j
public class IColisServiceImpl implements IColisService {
    private MapperImpl mapper;
    private IColisRepository colisRepository;
    private IFicheDeDepotRepository ficheDeDepotRepository;
    @Override
    public ColisDTO ajouterUnColis(Long idFicheDeDepot, ColisDTO colisDTO) throws FicheDeDepotNotFoundException {
        log.info("Saving new colis");
        FicheDeDepot ficheDeDepot = ficheDeDepotRepository.findById(idFicheDeDepot)
                .orElseThrow(()->new FicheDeDepotNotFoundException("Aucune fiche de depot trouvé."));;
        Colis colis = new Colis();
        colis.setDescriptionColis(colisDTO.getDescriptionColis());
        colis.setIdFicheDeDepot(ficheDeDepot.getIdFicheDeDepot());
        colis.setHauteur(colisDTO.getHauteur());
        colis.setLageur(colisDTO.getLageur());
        colis.setLongueur(colisDTO.getLongueur());
        colis.setQuantite(colisDTO.getQuantite());
        colis.setCoutParMetreCube(colisDTO.getCoutParMetreCube());
        Colis savedColis =  colisRepository.save(colis);
        log.info("Id fiche de depot:::::"+colis.getFicheDeDepot());
        log.info("Id fiche de depot----"+ficheDeDepot.getIdFicheDeDepot());
        return mapper.fromColis(savedColis);
    }

    @Override
    public ColisDTO modifierUnColis(ColisDTO colisDTO) {
        return null;
    }

    @Override
    public ColisDTO retournerUnColisParId(String idColis) {
        Colis colis = colisRepository.findById(idColis).orElse(null);
        if(colis == null){
            //throw new ColisNotFoundException("Aucun colis trouvé.");
        }
        ColisDTO colisDTO = mapper.fromColis(colis);
        return colisDTO;
    }

    @Override
    public List<ColisDTO> listerTousLesColis() {
        List<Colis> listColis = colisRepository.findAll();
        List<ColisDTO> colisDTOS = mapper.fromListColis(listColis);
        return colisDTOS;
    }

    @Override
    public void suprimmerUnColis(String idColis) {
        ColisDTO colisDTO = retournerUnColisParId(idColis);
        Colis colis = mapper.fromColisDTO(colisDTO);
        colisRepository.delete(colis);
    }

    @Override
    public double volumeDuColis(String idColis) {
        ColisDTO colisDTO = retournerUnColisParId(idColis);
        Colis colis = mapper.fromColisDTO(colisDTO);
        double volume = colis.getLageur()*colis.getLongueur()*colis.getHauteur();
        return volume;
    }
    @Override
    public double coutTotalParColis(String idColis) {
        ColisDTO colisDTO = retournerUnColisParId(idColis);
        Colis colis = mapper.fromColisDTO(colisDTO);
        double cout = volumeDuColis(idColis)*colis.getCoutParMetreCube()*colis.getQuantite();
        return cout;
    }

    @Override
    public List<ColisDTO> recupererLaListeDesColisParFiche(Long idFicheDeDepot) {
        List<Colis> listeColis = colisRepository.findByIdFicheDeDepot(idFicheDeDepot);
        return mapper.fromListColis(listeColis);
    }
    @Override
    public int nombreTotalDeColisParFiche(Long idFicheDeDepot) {
        int quantiteTotale = 0;
        List<ColisDTO> colisDTOS = recupererLaListeDesColisParFiche(idFicheDeDepot);
        List<Colis> colisList = mapper.fromListColisDTO(colisDTOS);
        for(Colis colis:colisList){
            quantiteTotale += colis.getQuantite();
        }
        return quantiteTotale;
    }

    @Override
    public double coutTotalDesColisParFiche(Long idFicheDeDepot) {
        double sommeTotalParColis=0;
        List<ColisDTO> colisDTOS = recupererLaListeDesColisParFiche(idFicheDeDepot);
        List<Colis> colisList = mapper.fromListColisDTO(colisDTOS);
        for(Colis colis:colisList){
            sommeTotalParColis +=coutTotalParColis(colis.getIdColis());
        }
        return sommeTotalParColis;
    }
}
