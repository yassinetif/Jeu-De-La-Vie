/** 
 * @author Yassine M'CHAAR
 */
public abstract class Visiteur {
	protected JeuDeLaVie jeu;
	/**
	 * constructeur d'un objet Visiteur
	 */
	protected  Visiteur(JeuDeLaVie jeu) {
		this.jeu = jeu;
	}
	/**
	 * action à réaliser sur une cellule vivante
	 */
	abstract  void visiteCelluleVivante(Cellule c);
	/**
	 * action à réaliser sur une cellule morte
	 */
	abstract void visiteCelluleMorte(Cellule c);
}
