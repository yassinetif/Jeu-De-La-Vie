/** 
 * @author Yassine M'CHAAR
 */
public class VisiteurClassique extends Visiteur {
	/**
	 * constructeur d'un objet VisiteurClassique
	 */
	VisiteurClassique(JeuDeLaVie jeu) {
		super(jeu);
	}
	
	/**
	 * action à réaliser sur une cellule vivante
	 * @param c  cellule sur laquelle l'action sera realisée
	 */
	public void visiteCelluleVivante(Cellule c) {
		if(c.nombreVoisinesVivantes(jeu)<2 || c.nombreVoisinesVivantes(jeu)>3)
			jeu.ajouteCommande(new CommandeMeurt(c));
	}
	/**
	 * action à réaliser sur une cellule morte
	 * @param c  cellule sur laquelle l'action sera realisée
	 */
	public void visiteCelluleMorte(Cellule c) {
		if(c.nombreVoisinesVivantes(jeu)==3)
			jeu.ajouteCommande(new CommandeVit(c));
	}
}
