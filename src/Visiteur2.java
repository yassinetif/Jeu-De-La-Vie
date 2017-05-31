/** 
 * @author Yassine M'CHAAR
 */
public class Visiteur2 extends Visiteur{
	/**
	 * constructeur d'un objet Visiteur2
	 */
	public Visiteur2(JeuDeLaVie jeu) {
		super(jeu);	
	}
	/**
	 * action à réaliser sur une cellule vivante
	 * @param c (Cellule) cellule sur laquelle l'action sera realisée
	 */
	public void visiteCelluleVivante(Cellule c) {
		if(c.nombreVoisinesVivantes(jeu)<3 || c.nombreVoisinesVivantes(jeu)==5 || c.nombreVoisinesVivantes(jeu)>8) {
			CommandeMeurt cm = new CommandeMeurt(c);
			jeu.ajouteCommande(cm);
		}
	}
	/**
	 * action à réaliser sur une cellule morte
	 * @param c  cellule sur laquelle l'action sera realisée
	 */
	public void visiteCelluleMorte(Cellule c) {
		if(c.nombreVoisinesVivantes(jeu)==3 || c.nombreVoisinesVivantes(jeu)==6 || c.nombreVoisinesVivantes(jeu)==7 || c.nombreVoisinesVivantes(jeu)==8) {
			CommandeVit cv = new CommandeVit(c);
			jeu.ajouteCommande(cv);
		}
	}
}
