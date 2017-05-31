/** 
 * @author Yassine M'CHAAR
 */
public class CelluleEtatVivant implements CelluleEtat {
	//variable d'instance représentant l'objet CelluleEtatVivant qui sera crée (singleton)
		private static CelluleEtatVivant cellEV;

		/**
		 * constructeur rendu privé pour empecher l'instantiation de plus d'un objet de ce type
		 */
		private CelluleEtatVivant(){}
		/**
		 * méthode permettant de récupérer l'objet CelluleEtatVivant et de le crée si il n'éxiste pas encore
		 * @return cellEV l'objet de singleton
		 */
		public static CelluleEtat getInstance(){
			if(cellEV==null)
				cellEV=new CelluleEtatVivant();
			return cellEV;
		}
		/**
		 * méthode renvoyant un objet CelluleEtatVivant
		 * @return CelluleEtatVivant 
		 */
		public CelluleEtat vit(){
			return this;
		}
		/**
		 * méthode renvoyant un objet CelluleEtatMort
		 * @return une instance de CelluleEtatMort
		 */
		public CelluleEtat meurt(){
			return CelluleEtatMort.getInstance();
		}
		/**
		 * méthode renvoyant vrai
		 * @return un booléen true
		 */
		public boolean estVivante(){
			return true;
		}
		
		/**
		 * méthode permettant à un visiteur d'agir sur une cellule dont l'état est de type CelluleEtatVivant
		 * @param v  le visiteur qui agira sur la cellule
		 * @param c  la cellule sur laquelle le visiteur devra intervenir
		 */
		public void accepte(Visiteur v, Cellule c){
			v.visiteCelluleVivante(c);
		}
}
