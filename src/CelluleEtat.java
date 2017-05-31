/** 
 * @author Yassine M'CHAAR
 */
public interface CelluleEtat {
	public CelluleEtat vit(); //méthode renvoyant un objet CelluleEtatVivant
	public CelluleEtat meurt(); //méthode renvoyant un objet CelluleEtatMort
	public boolean estVivante();//méthode renvoyant vrai si la cellule est vivante, faux si non
	/**
	 * méthode permettant à un visiteur d'agir sur une cellule en fonction de son etat
	 * @param v  le visiteur qui agira sur la cellule
	 * @param c la cellule sur laquelle le visiteur devra intervenir
	 */
	public void accepte(Visiteur v, Cellule c);
}
