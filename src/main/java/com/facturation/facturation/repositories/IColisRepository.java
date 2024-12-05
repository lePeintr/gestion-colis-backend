package com.facturation.facturation.repositories;

import com.facturation.facturation.entities.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IColisRepository extends JpaRepository<Colis,String> {
    List<Colis> findByIdFicheDeDepot(Long idFicheDeDepot);

}
