package fr.diginamic.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Représente une opération sur un compte bancaire avec son identifiant, sa date, son montant et son motif
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

	/** l'identifiant de l'opération */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** la date de l'opération */
	@Column(name = "DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	/** le montant de l'opération */
	@Column(name = "MONTANT", nullable = false)
	private double montant;
	
	/** le motif de l'opération */
	@Column(name = "MOTIF", length = 100, nullable = false)
	private String motif;
	
	/** le compte associé à l'opération */
	@ManyToOne
	@JoinColumn(name = "COMPTE_ID")
	private Compte compte;
	

	/** Constructeur pour JPA */
	public Operation() {
		super();
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/** Setter
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/** Getter
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/** Setter
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/** Getter
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/** Setter
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/** Getter
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/** Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
}
