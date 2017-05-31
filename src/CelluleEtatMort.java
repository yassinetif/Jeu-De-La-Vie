/** 
 * @author Yassine M'CHAAR
 */
public class CelluleEtatMort implements CelluleEtat{
	//variable d'instance représentant l'objet CelluleEtatMort qui sera crée (singleton)
		private static CelluleEtatMort cellEM;

		/**
		 * constructeur rendu privé pour empecher l'instantiation de plus d'un objet de ce type
		 */
		private CelluleEtatMort(){}
		/**
		 * méthode permettant de récupérer l'objet CelluleEtatMort et de le crée si il n'éxiste pas encore
		 * @return cellEM l'objet de singleton
		 */
		public static CelluleEtat getInstance(){
			if(cellEM==null)
				cellEM=new CelluleEtatMort();
			return cellEM;
		}
		 /**
		 * méthode renvoyant un objet CelluleEtatVivant
		 * @return une instance de CelluleEtatVivant
		 */
		public CelluleEtat vit(){
			return CelluleEtatVivant.getInstance();
		}
		/**
		 * méthode renvoyant un objet CelluleEtatMort
		 * @return CelluleEtat
		 */
		public CelluleEtat meurt(){
			return this;
		}
		/**
		 * méthode renvoyant faux
		 * @return un booléen false
		 */
		public boolean estVivante(){
			return false;
		}
		/**
		 * méthode permettant à un visiteur d'agir sur une cellule dont l'état est de type CelluleEtatMort
		 * @param v  le visiteur qui agira sur la cellule
		 * @param c  la cellule sur laquelle le visiteur devra intervenir
		 */
		public void accepte(Visiteur v, Cellule c){
			v.visiteCelluleMorte(c);
		}
}
