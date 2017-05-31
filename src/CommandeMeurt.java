/** 
 * @author Yassine M'CHAAR
 */
public class CommandeMeurt extends Commande {
	/**
	 * constructeur d'un objet CommandeMeurt
	 */
	public CommandeMeurt(Cellule c){
		cellule=c;
	}
	/**
	 * methode qui permet d'execute la commande tue cellule 
	 */
	public void executer(){
		cellule.meurt();
	}
}
