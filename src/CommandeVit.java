/** 
 * @author Yassine M'CHAAR
 */
public class CommandeVit extends Commande {
	/**
	 * constructeur d'un objet CommandeVit
	 */
	public CommandeVit(Cellule c){
		cellule=c;
	}
	/**
	 * execute la commance : ressuscite la cellule 
	 */
	public void executer(){
		cellule.vit();
	}
}
