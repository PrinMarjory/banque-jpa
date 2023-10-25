package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Représente un compte bancaire de type Livret A avec son taux
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte {

	/** le taux du livret A */
	@Column(name = "TAUX", nullable = false)
	private double taux;

	/** Constructeur pour JPA */
	public LivretA() {
		super();
	}

	@Override
	public String toString() {
		return "LivretA [taux=" + taux + super.toString() + "]";
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
