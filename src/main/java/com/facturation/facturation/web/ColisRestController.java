package com.facturation.facturation.web;

import com.facturation.facturation.dtos.ColisDTO;
import com.facturation.facturation.exceptions.FicheDeDepotNotFoundException;
import com.facturation.facturation.services.IColisService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ColisController.java
 * <p>
 * Auteur: Administrateur
 */
@RestController
@RequestMapping("/gestion-colis")
@AllArgsConstructor
@CrossOrigin("*")
public class ColisRestController {
    private IColisService colisService;

    @GetMapping("/colis")
    public List<ColisDTO> allColis(){
        return colisService.listerTousLesColis();
    }

    @GetMapping("/colis/{idColis}")
    public ColisDTO getColisByIdColis(@PathVariable String idColis) {
        return colisService.retournerUnColisParId(idColis);
    }
    @GetMapping("/colis/volume/{idColis}")
    public double volumeDuColis(@PathVariable String idColis){
        return colisService.volumeDuColis(idColis);
    }
    @GetMapping("colis/cout/{idColis}")
    public double coutTotalDuColis(@PathVariable String idColis){
        return colisService.coutTotalParColis(idColis);
    }

    @PostMapping("/{idFicheDeDepot}/ajouterColis")
    public ColisDTO addColis(@PathVariable Long idFicheDeDepot, @RequestBody ColisDTO colisDTO) throws FicheDeDepotNotFoundException {
        return colisService.ajouterUnColis(idFicheDeDepot, colisDTO);
    }
  /*  @PutMapping("/colis/{idColis}")
    public ColisDTO updateCustomer(@PathVariable String idColis, @RequestBody ColisDTO customerDTO) {
        return colisService.modifierUnColis(idColis,customerDTO);
    }*/
    @DeleteMapping("/colis/{idColis}")
    public void deleteColis(@PathVariable String idColis)  {
        colisService.suprimmerUnColis(idColis);
    }
    @GetMapping("/colis-liste/{idFicheDepot}")
    public List<ColisDTO> recupererLaListeDesColisParFiche(@PathVariable Long idFicheDepot){
        return  colisService.recupererLaListeDesColisParFiche(idFicheDepot);
    }

    @GetMapping("/colis/{idFicheDepot}/totalColis")
    public int nombreTotalDeColisParFiche(@PathVariable Long idFicheDepot){
        return  colisService.nombreTotalDeColisParFiche(idFicheDepot);
    }

    @GetMapping("/colis/{idFicheDepot}/coutColis")
    public double coutTotalDesColisParFiche(@PathVariable Long idFicheDepot){
        return  colisService.coutTotalDesColisParFiche(idFicheDepot);
    }
    

}
