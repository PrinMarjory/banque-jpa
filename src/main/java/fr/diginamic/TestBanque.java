package fr.diginamic;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entites.Adresse;
import fr.diginamic.entites.AssuranceVie;
import fr.diginamic.entites.Banque;
import fr.diginamic.entites.Client;
import fr.diginamic.entites.Compte;
import fr.diginamic.entites.LivretA;
import fr.diginamic.entites.Operation;
import fr.diginamic.entites.Virement;

/**
 * Tests de la base de donnée banque
 * 
 * @author Marjory PRIN
 */
public class TestBanque {

	public static void main(String[] args) {
		
		// Connection à la base de donnée
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		// Création d'une adresse postale
		Adresse adr = new Adresse();
		adr.setNumero(10);
		adr.setRue("Rue des Lilas");
		adr.setCodePostal(44000);
		adr.setVille("Nantes");
		
		// Création de deux clients
		Client client1 = new Client();
		client1.setNom("Prin");
		client1.setPrenom("Marjory");
		client1.setDateNaissance(new Date(95, 3, 29));
		client1.setAdresse(adr);
		
		Client client2 = new Client();
		client2.setNom("Leblanc");
		client2.setPrenom("Clément");
		client2.setDateNaissance(new Date(94, 9, 18));
		client2.setAdresse(adr);

		// Ajout de client dans la base de donnée
		em.persist(client1);
		em.persist(client2);
		
		// Création d'une banque
		Banque banque = new Banque();
		banque.setNom("Crédit Mutuel");
		
		// Ajout de la banque dans la base de donnée et association à un client
		em.persist(banque);
		client1.setBanque(banque);
		client2.setBanque(banque);
		
		// Création de trois comptes
		Compte compte1 = new Compte();
		compte1.setNumero("FR 1845 7035 5639");
		compte1.setSolde(2689);
		
		LivretA compte2 = new LivretA();
		compte2.setNumero("FR 3406 6932 4518");
		compte2.setSolde(18658);
		compte2.setTaux(0.02);
		
		AssuranceVie compte3 = new AssuranceVie();
		compte3.setNumero("FR 6408 1278 3951");
		compte3.setSolde(13904);
		compte3.setDateFin(new Date(138, 6, 24));
		compte3.setTaux(0.05);
		
		// Ajout d'un compte et association à un client
		em.persist(compte1);
		em.persist(compte2);
		em.persist(compte3);
		client1.getComptes().add(compte1);
		client2.getComptes().add(compte1);
		client2.getComptes().add(compte2);
		client2.getComptes().add(compte3);
		
		// Création d'opérations et ajout à la base de donnée
		Operation op = new Operation();
		op.setDate(new Date());
		op.setMontant(-34.50);
		op.setMotif("DEBIT");
		op.setCompte(compte1);
		em.persist(op);
		
		op = new Operation();
		op.setDate(new Date());
		op.setMontant(10.99);
		op.setMotif("CREDIT");
		op.setCompte(compte1);
		em.persist(op);
	
		Virement v = new Virement();
		v.setDate(new Date());
		v.setMontant(125.00);
		v.setMotif("VIREMENT");
		v.setBeneficiaire("Dupont Louis");
		v.setCompte(compte1);
		em.persist(v);
		
		// Commit
		transaction.commit();
	}

}
