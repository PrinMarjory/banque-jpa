package fr.diginamic.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Représente un compte bancaire de type Livret A avec son taux
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte {
	
	/** la date de fin du contrat d'assurance vie */
	@Column(name = "DATE_FIN", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	/** le taux de l'assurance vie */
	@Column(name = "TAUX", nullable = false)
	private double taux;

	/** Constructeur pour JPA */
	public AssuranceVie() {
		super();
	}

	@Override
	public String toString() {
		return "AssuranceVie [dateFin=" + dateFin + ", taux=" + taux + super.toString() + "]";
	}

	/** Getter
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
