/** 
 * @author Yassine M'CHAAR
 */
public interface Observable {
	// permet d'ajouter un observateur dans la liste des observateurs des objets Observables
	public void attacheObservateur(Observateur o);

	// permet de retirer un observateur de la liste des observateurs des objets Observables
	public void detacheObservateur(Observateur o);

	 // permet d'actualiser tout les observateurs de la liste
	public void notifieObservateurs();
}
