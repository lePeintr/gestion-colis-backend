package com.facturation.facturation.services;

import com.facturation.facturation.dtos.ConteneurDTO;

import java.util.List;

public interface IConteneurService {
    ConteneurDTO ajouterUnConteneur(ConteneurDTO ConteneurDTO);
    ConteneurDTO modifierUnConteneur(ConteneurDTO ConteneurDTO);
    ConteneurDTO afficherUnConteneurParId(String idConteneur);
    List<ConteneurDTO> listerTousLesConteneurs();
    void suprimmerUnConteneur(String idConteneur);
    double coutTotalDesFichesDepotDuConteneur(String idConteneur);
}
