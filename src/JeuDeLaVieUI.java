/** 
 * @author Yassine M'CHAAR
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;


public class JeuDeLaVieUI extends JFrame implements Observateur, ActionListener{
	private JeuDeLaVie jeu;
	private JButton arret=new JButton("Arreter");
	private JButton next=new JButton("Next Gen");
	private JButton regNv=new JButton("Regle Nouvelle");
	private JSlider slide=new JSlider(JSlider.HORIZONTAL, -2000, -1, -1000);

	public JeuDeLaVieUI(JeuDeLaVie j){
		jeu=j;
		this.setTitle("Jeu de la vie");
		this.setSize(700,700);
		this.setResizable(false);		
		setVisible(true);		
		
		BorderLayout bd=new BorderLayout();
		
		slide.addChangeListener(new ChangeListener() {
      		public void stateChanged(ChangeEvent e) {
      			jeu.setTemps(-(slide.getValue()));
      		}
    	});
		
		this.arret.setPreferredSize(new Dimension(150,50));
		this.arret.addActionListener(this);
		this.next.setPreferredSize(new Dimension(150,50));
		this.next.addActionListener(this);
		this.next.setEnabled(false);
		this.regNv.setPreferredSize(new Dimension(150,50));
		this.regNv.addActionListener(this);

		this.getContentPane().setLayout(bd);
		this.getContentPane().add(pannel(),BorderLayout.SOUTH);
	}
	public JPanel pannel(){
		JPanel pan=new JPanel();
		pan.add(this.arret);
		pan.add(this.next);
		pan.add(this.regNv);
		pan.add(this.slide);
		return pan;
	}


	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Arreter")){
			jeu.changeArretBoucle();
			this.next.setEnabled(true);
			this.arret.setText("Executer");
		}
		else if(e.getActionCommand().equals("Executer")){
			jeu.changeArretBoucle();
			this.next.setEnabled(false);
			this.arret.setText("Arreter");
		}
		else if(e.getActionCommand().equals("Next Gen") && this.arret.getText().equals("Executer")){
			jeu.nextGen();
		}
		else if(e.getActionCommand().equals("Regle Nouvelle")){
			jeu.setVisiteur(new Visiteur2(jeu));
			this.regNv.setText("Regle Classique");
		}
		else if(e.getActionCommand().equals("Regle Classique")){
			jeu.setVisiteur(new VisiteurClassique(jeu));
			this.regNv.setText("Regle Nouvelle");
		}
	}
	
	public void actualise(){
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		int taille=3;
		for(int x=0;x<jeu.getXMax();x++){
			for(int y=0;y<jeu.getYMax();y++){
				if(jeu.getGrilleXY(x,y).estVivante()){
					g.fillOval(x*taille,y*taille,taille,taille);
				}
			}
		}
	}
}