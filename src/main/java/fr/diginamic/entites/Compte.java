package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Représente un compte bancaire avec son identifiant, son numéro et son solde
 * Compte abstrait : LivretA ou AssuranceVie
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	/** l'identifiant du compte */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** le numéro du compte */
	@Column(name = "NUMERO", length = 20, nullable = false)
	private String numero;
	
	/** le solde du compte */
	@Column(name = "SOLDE", nullable = false)
	private double solde;
	
	/** le(s) client(s) du compte */
	@ManyToMany(mappedBy = "comptes")
	private Set<Client> clients;
	
	/** les opérations du compte */
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;

	/** Constructeur pour JPA */
	public Compte() {
		super();
		operations = new HashSet<Operation>();
		clients = new HashSet<Client>();
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", clients=" + clients + ", operations="
				+ operations + "]";
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/** Setter
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
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

	/** Getter
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/** Setter
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
}
