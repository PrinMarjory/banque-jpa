package fr.diginamic.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Représente une opération de virement sur un compte bancaire avec son identifiant, 
 * sa date, son montant, son motif et son bénéficiaire
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "VIREMENT")
public class Virement extends Operation {
	
	/** le bénéficiaire du virement */
	@Column(name = "BENEFICIAIRE", length = 50, nullable = false)
	private String beneficiaire;

	/** Constructeur pour JPA */
	public Virement() {
		super();
	}

	@Override
	public String toString() {
		return "Virement [beneficiaire=" + beneficiaire + super.toString() + "]";
	}

	/** Getter
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/** Setter
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}
