package fr.diginamic.entites;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Représente un client d'une banque avec son identifiant, son nom, son prénom et sa date de naissance
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "CLIENT")
public class Client {
	
	/** l'identifiant du client */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le nom du client */
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	/** le prénom du client */
	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;
	
	/** la date de naissance du client */
	@Column(name = "DATE_NAISSANCE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	/** l'adresse du client */
	@Embedded
	private Adresse adresse;
	
	/** la banque du client */
	@ManyToOne
	@JoinColumn(name = "BANQUE_ID")
	private Banque banque;
	
	/** le(s) compte(s) du client */
	@ManyToMany
	@JoinTable(name = "COMPTE_CLIENT",
			joinColumns = @JoinColumn(name="ID_CLIENT", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name="ID_COMPTE", referencedColumnName = "ID")
	)
	private Set<Compte> comptes;

	/** Constructeur pour JPA */
	public Client() {
		super();
		comptes = new HashSet<Compte>();
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", adresse=" + adresse + ", banque=" + banque + ", comptes=" + comptes + "]";
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Getter
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/** Setter
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
