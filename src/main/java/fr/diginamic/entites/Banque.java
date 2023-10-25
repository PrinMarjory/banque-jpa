package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente une banque avec son identifiant et son nom
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "BANQUE")
public class Banque {
	
	/** l'identifiant de la banque */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom de la banque */
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	/** la liste des clients */
	@OneToMany(mappedBy = "banque")
	private Set<Client> clients;

	/** Constructeur pour JPA */
	public Banque() {
		super();
		clients = new HashSet<Client>();
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + "]";
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/** Setter
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
