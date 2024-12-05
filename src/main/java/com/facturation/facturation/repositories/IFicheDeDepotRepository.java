package com.facturation.facturation.repositories;

import com.facturation.facturation.entities.Colis;
import com.facturation.facturation.entities.FicheDeDepot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFicheDeDepotRepository extends JpaRepository<FicheDeDepot,Long> {
}
