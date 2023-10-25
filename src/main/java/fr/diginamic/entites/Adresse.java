package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** 
 * Représente l'adresse postale d'un client avec son numéro de rue, 
 * son nom de rue, son code postale et le nom de la ville
 * 
 * @author Marjory PRIN
 */
@Embeddable
public class Adresse {
	
	/** le numéro de la rue */
	@Column(name = "NUMERO", nullable = true)
	private int numero;
	
	/** le nom de la rue */
	@Column(name = "RUE", length = 100, nullable = false)
	private String rue;
	
	/** le code postale de la rue */
	@Column(name = "CODE_POSTAL", nullable = false)
	private int codePostal;
	
	/** le nom de la ville */
	@Column(name = "VILLE", length = 50, nullable = false)
	private String ville;

	/** Constructeur pour JPA */
	public Adresse() {
		super();
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

	/** Getter
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/** Setter
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/** Getter
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/** Setter
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/** Getter
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/** Setter
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
