package com.facturation.facturation;

import com.facturation.facturation.dtos.ColisDTO;
import com.facturation.facturation.dtos.FicheDeDepotDTO;
import com.facturation.facturation.entities.FicheDeDepot;
import com.facturation.facturation.enums.TypeFacture;
import com.facturation.facturation.services.IColisService;
import com.facturation.facturation.services.IFicheDeDepotService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class FacturationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturationApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(IFicheDeDepotService ficheDeDepotService, IColisService colisService){
		return args -> {

			FicheDeDepotDTO ficheDeDepot1 =  FicheDeDepotDTO.builder()
					.dateDeDepotDuColis(new Date())
					.destination("YAOUNDE")
					.emailDestinataire("destinataire1@gmail.com")
					.emailExpediteur("expediteur1@gmail.com")
					.nomExpediteur("expediteur1")
					.nomDuDestinataire("desinataire1")
					.numeroExpediteur(123456789)
					.numeroDestinataire(987654321)
					.typeFacture(TypeFacture.FACTURE_REELLE)
					.build();
			ficheDeDepotService.ajouterUneFicheDeDepot(ficheDeDepot1);
			FicheDeDepotDTO ficheDeDepot2 =  FicheDeDepotDTO.builder()
					.dateDeDepotDuColis(new Date())
					.destination("DOUALA")
					.emailDestinataire("destinataire2@gmail.com")
					.emailExpediteur("expediteur2@gmail.com")
					.nomExpediteur("expediteur2")
					.nomDuDestinataire("desinataire2")
					.numeroExpediteur(123456789)
					.numeroDestinataire(987654321)
					.typeFacture(TypeFacture.FACTURE_REELLE)
					.build();
			ficheDeDepotService.ajouterUneFicheDeDepot(ficheDeDepot2);
			FicheDeDepotDTO ficheDeDepot3 =  FicheDeDepotDTO.builder()
					.dateDeDepotDuColis(new Date())
					.destination("KRIBI")
					.emailDestinataire("destinataire3@gmail.com")
					.emailExpediteur("expediteur3@gmail.com")
					.nomExpediteur("expediteur3")
					.nomDuDestinataire("desinataire3")
					.numeroExpediteur(123456789)
					.numeroDestinataire(987654321)
					.typeFacture(TypeFacture.FACTURE_FICTIVE)
					.build();
			ficheDeDepotService.ajouterUneFicheDeDepot(ficheDeDepot3);

			List<FicheDeDepotDTO> listeDesFichesDeDepot = ficheDeDepotService.listerToutesLesFicheDeDepot();

			for (FicheDeDepotDTO ficheDeDepotDTO:listeDesFichesDeDepot){
				ColisDTO colis1 = ColisDTO.builder()
						.idColis(UUID.randomUUID().toString())
						.descriptionColis("tv smart")
						.coutParMetreCube(2)
						.lageur(5)
						.hauteur(3)
						.longueur(10)
						.quantite(4)
						.build();
				colisService.ajouterUnColis(ficheDeDepotDTO.getIdFicheDeDepot(), colis1);
				ColisDTO colis2 = ColisDTO.builder()
						.idColis(UUID.randomUUID().toString())
						.descriptionColis("laptop")
						.coutParMetreCube(4)
						.lageur(1)
						.hauteur(2)
						.longueur(5)
						.quantite(10)
						.build();
				colisService.ajouterUnColis(ficheDeDepotDTO.getIdFicheDeDepot(),colis2);
				ColisDTO colis3 = ColisDTO.builder()
						.idColis(UUID.randomUUID().toString())
						.descriptionColis("Refrégirateur")
						.coutParMetreCube(10)
						.lageur(10)
						.hauteur(10)
						.longueur(20)
						.quantite(1)
						.build();
				colisService.ajouterUnColis(ficheDeDepotDTO.getIdFicheDeDepot(),colis3);

			}

			ColisDTO colis7 = ColisDTO.builder()
					.idColis(UUID.randomUUID().toString())
					.descriptionColis("téléphone")
					.coutParMetreCube(5)
					.lageur(2)
					.hauteur(10)
					.longueur(20)
					.quantite(6)
					.build();
			colisService.ajouterUnColis(1L,colis7);
			};


	}
}
