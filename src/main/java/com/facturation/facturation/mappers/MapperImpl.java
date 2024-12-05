package com.facturation.facturation.mappers;

import com.facturation.facturation.dtos.ColisDTO;
import com.facturation.facturation.dtos.ConteneurDTO;
import com.facturation.facturation.dtos.FicheDeDepotDTO;
import com.facturation.facturation.entities.Colis;
import com.facturation.facturation.entities.Conteneur;
import com.facturation.facturation.entities.FicheDeDepot;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * MapperImpl.java
 * <p>
 * Auteur: Administrateur
 */
@Service
public class MapperImpl {
    private ModelMapper modelMapper = new ModelMapper();

    public ColisDTO fromColis(Colis colis){
        return modelMapper.map(colis, ColisDTO.class);
    }
    public Colis fromColisDTO(ColisDTO colisDTO){
        return modelMapper.map(colisDTO, Colis.class);
    }
    public List<ColisDTO> fromListColis(List<Colis> listeColis){
        return listeColis.stream().map(c->modelMapper.map(c, ColisDTO.class)).collect(Collectors.toList());
    }
    public List<Colis> fromListColisDTO(List<ColisDTO> listeColisDTO){
        return listeColisDTO.stream().map(c->modelMapper.map(c, Colis.class)).collect(Collectors.toList());
    }
    public ConteneurDTO fromConteneur(Conteneur conteneur){
        return modelMapper.map(conteneur, ConteneurDTO.class);
    }
    public Conteneur fromConteneurDTO(ConteneurDTO ConteneurDTO){
        return modelMapper.map(ConteneurDTO, Conteneur.class);
    }
    public List<ConteneurDTO> fromListConteneur(List<Colis> listeConteneur){
        return listeConteneur.stream().map(c->modelMapper.map(c, ConteneurDTO.class)).collect(Collectors.toList());
    }
    public List<Conteneur> fromListConteneurDTO(List<ColisDTO> listeConteneurDTO){
        return listeConteneurDTO.stream().map(c->modelMapper.map(c, Conteneur.class)).collect(Collectors.toList());
    }
    public FicheDeDepotDTO fromFicheDeDepot(FicheDeDepot ficheDeDepot){
        return modelMapper.map(ficheDeDepot, FicheDeDepotDTO.class);
    }
    public FicheDeDepot fromFicheDeDepotDTO(FicheDeDepotDTO FicheDeDepotDTO){
        return modelMapper.map(FicheDeDepotDTO, FicheDeDepot.class);
    }
    public List<FicheDeDepotDTO> fromListFicheDeDepot(List<FicheDeDepot> listeFicheDeDepot){
        return listeFicheDeDepot.stream().map(c->modelMapper.map(c, FicheDeDepotDTO.class)).collect(Collectors.toList());
    }
    public List<FicheDeDepot> fromListFicheDeDepotDTO(List<FicheDeDepotDTO> listeFicheDeDepotDTO){
        return listeFicheDeDepotDTO.stream().map(c->modelMapper.map(c, FicheDeDepot.class)).collect(Collectors.toList());
    }
}
