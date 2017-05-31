/** 
 * @author Yassine M'CHAAR
 */
import java.util.*;

public class JeuDeLaVie implements Observable{
	//matrice contenant les cellules
		private Cellule[][] grille;
		//longueur maximale
		private int xMax;
		//largeur maximale
		private int yMax;
		//liste des observateurs du jeu
		private List<Observateur> observateurs;
		//liste des commandes du jeu
		private List<Commande> commandes;
		//le visiteur du jeu
		private Visiteur visiteur;
		//boolean permettant d'arreter la partie
		private boolean arretBoucle =true;
		//temps d'attente entre chaque tour
		public int temps;
		/**
		 * constructeur du jeu de la vie
		 */ 
		public JeuDeLaVie(){
			xMax=220;
			yMax=220;
			temps=1000;
			grille=new Cellule[yMax][xMax];
			observateurs=new ArrayList<Observateur>();
			commandes=new ArrayList<Commande>();
		}
		/**
		 * méthode d'initialisation de la grille
		 */
		public void initialiseGrille(){
			for(int i=0;i<xMax;i++){
				for(int j=0;j<yMax;j++){
					if(Math.random() < 0.6)
						grille[i][j]=new Cellule(i,j,CelluleEtatVivant.getInstance());
					else
						grille[i][j]=new Cellule(i,j,CelluleEtatMort.getInstance());
				}
			}
		}
		/**
		 * méthode permettant d'appliquer l'action du visiteur à chaque cellule de la grille
		 */
		public void distribueVisiteur(){
			for(int i=0;i<xMax;i++)
				for(int j=0;j<yMax;j++)
					grille[i][j].accepte(visiteur);
		}
		/**
		 * méthode permettant de modifier le visiteur
		 */
		public void setVisiteur(Visiteur v){
			visiteur=v;
		}
		/**
		 * méthode calculant la génération suivante si la variable arretBoucle est à vrai, ne fait RIEN sinon
		 */
		public void calculerGenerationSuivante(){
			if(arretBoucle){
				this.distribueVisiteur();
				this.executeCommandes();
				this.notifieObservateurs();
			}		
		}
		/**
		 * méthode calculant la génération suivante 
		 */
		public void nextGen(){
			this.distribueVisiteur();
			this.executeCommandes();
			this.notifieObservateurs();		
		}
		/**
		 * méthode permettant de récupérer la cellule au coordonnées (x;y)
		 * @param x (int) abscisse de la cellule recherchée
		 * @param y (int) ordonnee de la cellule recherchée
		 * @return renvoie la cellule si les coorodnnées sont éxacte, null si non
		 */
		public Cellule getGrilleXY(int x, int y){
			if(x>=0 && x<xMax && y>=0 && y<yMax)
				return grille[x][y];
			return null;
		}
		/**
		 * méthode permettant d'ajouter une commande à la liste des commandes 
		 * @param o commande à ajouter
		 */
		public void ajouteCommande(Commande o){
			commandes.add(o);
		}
		/**
		 * méthode permettant d'éxécuter les commandes de la liste   
		 */
		public void executeCommandes(){
			for(Commande c: commandes)
				c.executer();
			commandes.clear();
		}
		/**
		 * méthode permettant d'ajouter un observateur à la liste des observateurs 
		 * @param o (Observateur) à ajouter
		 */
		public void attacheObservateur(Observateur o){
			observateurs.add(o);
		}
		/**
		 * méthode permettant de retirer un observateur de la liste des observateurs 
		 * @param o (Observateur) à retirer
		 */
		public void detacheObservateur(Observateur o){
			observateurs.remove(o);
		}
		/**
		 * méthode permettant d'actualiser les observateurs
		 */
		public void notifieObservateurs(){
			for(Observateur o: observateurs)
				o.actualise();
		}
		/**
		 * méthode permettant de renvoyer la longueur max de la grille
		 * @return la variable xMax
		 */
		public int getXMax(){
			return xMax;
		}
		/**
		 * méthode permettant de renvoyer la largeur max de la grille
		 * @return la variable yMax
		 */
		public int getYMax(){
			return yMax;
		}
		/**
		 * méthode renvoyant la liste des observateurs
		 * @return List<Observateur> 
		 */
		public List<Observateur> getObs(){
			return observateurs;
		}
		/**
		 * permet de changer la valeur de arretBoucle, devient faux si vrai et inversement
		 */
		public void changeArretBoucle(){
			if(arretBoucle)
				arretBoucle=false;
			else
				arretBoucle=true;
		}
		/**
		 * permet de changer la valeur du temps
		 */
		public void setTemps(int tmps){
			this.temps=tmps;
		}
		/**
		 * permet d'attendre un temps égale à la valeur de la variable d'instance temps
		 * @throws Exception due au Thread.sleep
		 */
		public void attend() throws Exception{
			Thread.sleep(temps);
		}
		
		public static void main(String[] args){
			JeuDeLaVie jd=new JeuDeLaVie();
			jd.initialiseGrille();
			Visiteur v=new VisiteurClassique(jd);
			jd.setVisiteur(v);
			
			Observateur j=new JeuDeLaVieUI(jd);
			Observateur o=new Observateur2(jd);
			jd.attacheObservateur(j);
			jd.attacheObservateur(o);
			while(true){
				jd.calculerGenerationSuivante();
				try{
					jd.attend();
				}catch(Exception e){
					System.out.println("bouse");
				}
			}
		}
}
