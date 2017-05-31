/** 
 * @author Yassine M'CHAAR
 */
public class Observateur2 implements Observateur {
		//objet jeu de la vie auquel est rattaché l'observateur 
		private JeuDeLaVie jeu;
		//variable contenant le nombre de generationCourante depuis le lancement du jeu
		private static int generationCourante=0;
		/**
		 * constructeur d'un objet Observateur2
		 * @param jeu  jeu de la vie 
		 */
		public Observateur2(JeuDeLaVie jeu) {
			this.jeu = jeu;	
		}
		/**
		 * action réalisé par l'observateur
		 */
		public void actualise(){
			int nbVivant=0;
			
			generationCourante+=1;
			System.out.println("Generation n° "+generationCourante);
			for(int i=0;i<jeu.getXMax();i++)
				for(int j=0;j<jeu.getYMax();j++)
					if(jeu.getGrilleXY(i,j).estVivante())
						nbVivant+=1;
			System.out.println(nbVivant+" cellules vivantes\n");
		}
}
