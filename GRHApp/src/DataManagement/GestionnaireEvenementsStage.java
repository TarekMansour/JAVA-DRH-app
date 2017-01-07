package DataManagement;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Graphics.DossierStagiaireFrame;
import Graphics.DepartStagiaire;

public class GestionnaireEvenementsStage implements ActionListener, MouseListener
{
	 DossierStagiaireFrame dstg ;
	 DepartStagiaire dep;
	public GestionBD gestionbase;
	Border border = BorderFactory.createLineBorder(Color.red);
	
	public GestionnaireEvenementsStage(DossierStagiaireFrame dstg)
    {
    	this.dstg = dstg;
    	gestionbase=new GestionBD();
    }
	
	
	//ActionListener------------------------------------------------------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e)
    {	
    	//ajouter stagiaire
    	if(e.getSource()==dstg.validercontratButton)
    	{
    	String req="INSERT INTO stage (nom, prenom, cin, datenaiss, niveauetude, numtel, email, adresse, sujetstage, lieustage, credit, datedeb, datefin) "
    	+"VALUES('"+dstg.nomField.getText()+"', '"+dstg.prenomField.getText()+"', '"+dstg.cinField.getText()
    			 +"', '"+((JTextField)(dstg.dateNaissChooser.getDateEditor().getUiComponent())).getText()+"', '"+dstg.niveauetudeField.getText()
    			 +"', '"+dstg.telephoneField.getText()+"', '"+dstg.adressElectroField.getText()+"', '"+dstg.adressResField.getText()
    			 +"', '"+dstg.sujetField.getText()+"', '"+dstg.lieuField.getText()+"', '"+dstg.creditField.getText()
    			 +"', '"+((JTextField)(dstg.dateDebutChooser.getDateEditor().getUiComponent())).getText()
    			 +"', '"+((JTextField)(dstg.dateFinChooser.getDateEditor().getUiComponent())).getText()+"')";
    		
    	
    	if((gestionbase.requeteModification(req)>0)&& ((dstg.nomField.getText()!="")|| (dstg.prenomField.getText()!="") || (dstg.cinField.getText()!="") || (((JTextField)(dstg.dateNaissChooser.getDateEditor().getUiComponent())).getText()=="")
    			||(dstg.niveauetudeField.getText()!="") || (dstg.telephoneField.getText()!="") || (dstg.adressElectroField.getText()!="") || (dstg.adressResField.getText()!="")
    			|| (dstg.sujetField.getText()!="") || (dstg.lieuField.getText()!="") || (dstg.creditField.getText()!="") 
    			|| (((JTextField)(dstg.dateDebutChooser.getDateEditor().getUiComponent())).getText()=="") 
    			|| (((JTextField)(dstg.dateFinChooser.getDateEditor().getUiComponent())).getText()=="") ))
    			javax.swing.JOptionPane.showMessageDialog(dstg,"Insertion effectuée");
    		else
    			{
    			dstg.nomField.setBorder(border); dstg.prenomField.setBorder(border); dstg.cinField.setBorder(border);
    			dstg.dateNaissChooser.setBorder(border); dstg.niveauetudeField.setBorder(border); dstg.telephoneField.setBorder(border);
    			dstg.adressElectroField.setBorder(border); dstg.adressResField.setBorder(border); dstg.sujetField.setBorder(border);
    			dstg.lieuField.setBorder(border); dstg.creditField.setBorder(border);
    			dstg.dateDebutChooser.setBorder(border); dstg.dateFinChooser.setBorder(border); 
    			javax.swing.JOptionPane.showMessageDialog(dstg,"Echec d'insertion, SVP vérifier les champs à saisir !!");
    			}
    			
    	dstg.effacer();
    	}
    	
    	if(e.getSource()==dstg.supprimerButton)
    	{
    		String req="DELETE FROM stage WHERE id="+dstg.idField.getText();
    		if(gestionbase.requeteModification(req)>0)
    			//javax.swing.JOptionPane.showMessageDialog(dstg,"Suppression effectuée");
    			JOptionPane.showConfirmDialog(dstg, "Voulez-vous supprimer cet personne ?", "Suppression", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    		else
    			javax.swing.JOptionPane.showMessageDialog(dstg,"Echec de Suppression");
    		//dstg.effacer();
    	}
    	
    	/*if(e.getSource()==gPers.modifier)
    	{
    		String req="UPDATE personne SET "
    			+"nom='"+gPers.nomT.getText()+"', prenom='"+gPers.prenomT.getText()+"', ville='"+gPers.villeT.getText()+"', datenaiss='"+gPers.dateT.getText()+"', email='"+gPers.emailT.getText()+"', salaire="+gPers.salaireT.getText()+", profil='"+gPers.profilT.getSelectedItem()+"' WHERE id="+gPers.idT.getText();
    		if(gestionbase.requeteModification(req)>0)
    			javax.swing.JOptionPane.showMessageDialog(gPers,"Mise à jour effectuée");
    		else
    			javax.swing.JOptionPane.showMessageDialog(gPers,"Echec de mise à jour");
    		gPers.effacer();
    	}
    	
    	if(e.getSource()==gPers.annuler)
    	{
    		gPers.effacer();
    	}*/
    	dstg.remplirTable();
    	
    	
    }

  //MouseListener---------------------------------------------------------------------------------------------------------------------------------
    public void mouseClicked(MouseEvent e)
    {
    	int numLigne=dstg.table.getSelectedRow();
    	dstg.idField.setText(dstg.table.getValueAt(numLigne,0).toString());
    	dstg.nomField.setText(dstg.table.getValueAt(numLigne,1).toString());
    	dstg.prenomField.setText(dstg.table.getValueAt(numLigne,2).toString());
    	dstg.cinField.setText(dstg.table.getValueAt(numLigne,3).toString());
    	((JTextField)(dstg.dateNaissChooser.getDateEditor().getUiComponent())).setText(dstg.table.getValueAt(numLigne,4).toString());
    	/*dstg.niveauetudeField.setText(dstg.table.getValueAt(numLigne,5).toString());
    	
    	dstg.adressElectroField.setText(dstg.table.getValueAt(numLigne,6).toString());
    	dstg.adressResField.setText(dstg.table.getValueAt(numLigne,7).toString());
    	dstg.sujetField.setText(dstg.table.getValueAt(numLigne,8).toString());
    	dstg.lieuField.setText(dstg.table.getValueAt(numLigne,9).toString());
    	dstg.creditField.setText(dstg.table.getValueAt(numLigne,10).toString());
    	((JTextField)(dstg.dateDebutChooser.getDateEditor().getUiComponent())).setText(dstg.table.getValueAt(numLigne,11).toString());
    	((JTextField)(dstg.dateFinChooser.getDateEditor().getUiComponent())).setText(dstg.table.getValueAt(numLigne,12).toString());*/
    }
    public void mousePressed(MouseEvent e)	{}
    public void mouseReleased(MouseEvent e)	{}
    public void mouseEntered(MouseEvent e)	{}
    public void mouseExited(MouseEvent e)	{}
}
