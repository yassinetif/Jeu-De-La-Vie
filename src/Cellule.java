/** 
 * @author Yassine M'CHAAR
 */
public class Cellule {
	private CelluleEtat etat; //etat de la cellule
	private int x, y; //abscisse et ordonnee de la cellule
	
	/**
	 * constructeur de la classe cellule
	 * @param x abcisse de la cellule dans la grille
	 * @param y ordonnee de la cellule dans la grille
	 * @param etat etat de la cellule lors de sa creation
	 */
	public Cellule(int x, int y, CelluleEtat etat) {
		this.x = x;
		this.y = y;
		this.etat = etat;	
	}
	
	/**
	 * méthode modifiant l'état de la cellule en la faisant vivre 
	 */
	public void vit(){
		etat=etat.vit();
	}
	/**
	 * méthode modifiant l'état de la cellule en la faisant mourrir 
	 */
	public void meurt(){
		etat=etat.meurt();
	}
	/**
	 * methode verifiant si la cellule est vivante 
	 * @return  vrai si la cellule est vivante, faux sinon
	 */
	public boolean estVivante(){
		return etat.estVivante();
	}
	/**
	 * méthode comptant le nombre de cellule vivante autour de la cellule
	 * @param jeu  objet contenant la matrice et nous permettant d'acceder aux voisines
	 * @return  le nombre de voisines vivantes de la cellule
	 */
	public int nombreVoisinesVivantes(JeuDeLaVie jeu){
		int cpt=0;
		
		if(x-1 >=0 && y-1>=0 && jeu.getGrilleXY(x-1,y-1).estVivante())
			cpt+=1;
		if(y+1<jeu.getYMax() && jeu.getGrilleXY(x,y+1).estVivante())
			cpt+=1;
		if(y-1>=0 && jeu.getGrilleXY(x,y-1).estVivante())
			cpt+=1;
		if(x+1 < jeu.getXMax() && y-1>=0 && jeu.getGrilleXY(x+1,y-1).estVivante())
			cpt+=1;
		if(x+1 < jeu.getXMax() && jeu.getGrilleXY(x+1,y).estVivante())
			cpt+=1;
		if(x-1 >=0 && jeu.getGrilleXY(x-1,y).estVivante())
			cpt+=1;
		if(x-1 >=0 && y+1<jeu.getYMax() && jeu.getGrilleXY(x-1,y+1).estVivante())
			cpt+=1;
		if(x+1 < jeu.getXMax() && y+1<jeu.getYMax() && jeu.getGrilleXY(x+1,y+1).estVivante())
			cpt+=1;
		return cpt;
	}
	/**
	 * méthode permettant à un visiteur de réaliser une action sur la cellule
	 * @param v le visiteur qui agira sur la cellule
	 */
	public void accepte(Visiteur v){
		etat.accepte(v,this);
	}	
	
}
