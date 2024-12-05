package com.facturation.facturation.web;

import com.facturation.facturation.dtos.FicheDeDepotDTO;
import com.facturation.facturation.exceptions.FicheDeDepotNotFoundException;
import com.facturation.facturation.services.IColisService;
import com.facturation.facturation.services.IFicheDeDepotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * FicheDeDepotRestController.java
 * <p>
 * Auteur: Administrateur
 */
@RestController
@RequestMapping("/fiche-de-depot")
@AllArgsConstructor
@CrossOrigin("*")
public class FicheDeDepotRestController {
    private IColisService colisService;
    private IFicheDeDepotService ficheDeDepotService;

    @GetMapping("/fiches")
    public List<FicheDeDepotDTO> allFicheDeDepot(){
        return ficheDeDepotService.listerToutesLesFicheDeDepot();
    }

    @GetMapping("/fiches/{idFicheDeDepot}")
    public FicheDeDepotDTO getFicheDepotByIdFicheDepot(@PathVariable Long idFicheDeDepot) {
        return ficheDeDepotService.afficherUneFicheDeDepotParId(idFicheDeDepot);
    }

    @PostMapping("/ajouterFiche")
    public FicheDeDepotDTO addFicheDeDepot(@RequestBody FicheDeDepotDTO ficheDeDepotDTO) throws FicheDeDepotNotFoundException {
        return ficheDeDepotService.ajouterUneFicheDeDepot(ficheDeDepotDTO);
    }
    /*  @PutMapping("/colis/{idColis}")
      public ColisDTO updateCustomer(@PathVariable String idColis, @RequestBody ColisDTO customerDTO) {
          return colisService.modifierUnColis(idColis,customerDTO);
      }*/
    @DeleteMapping("/fiches/{idFicheDeDepot}")
    public void deleteColis(@PathVariable Long idFicheDeDepot)  {
        ficheDeDepotService.suprimmerUneFicheDeDepot(idFicheDeDepot);
    }


}
