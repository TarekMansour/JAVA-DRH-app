package DataManagement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Graphics.DossierPersonnelFrame;
import Graphics.ListePersonnelFrame;
import Graphics.ModifierPersonne;
import Graphics.TestPerso;;

public class GestionnaireEvenementsPersonne implements ActionListener{
	DossierPersonnelFrame gPers;
	ListePersonnelFrame lts;
	ModifierPersonne mdpers;
	public GestionBD gestionbase;
	
	public GestionnaireEvenementsPersonne(DossierPersonnelFrame gPers)
    {
    	this.gPers=gPers;
    	gestionbase=new GestionBD();
    }
	
	public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==gPers.validerAjoutButton)
    { 
    String req="INSERT INTO dossierpersonnel (typePers, nom, prenom, cin, sexe, etatcivil, dateNaiss, lieuNaiss, telephone, adresseElctro, adresseRes, numCompte, nomBanque, agence, nomConjoint, prenomConjoint, nbEnfantConjoint, nomDiplome, etablissement, pieceJointe, specialite, entreprise, certeficat, photo) "
    +"VALUES('"+gPers.bg.getSelection().getActionCommand()+"', '"+gPers.nomField.getText()+"', '"+gPers.prenomField.getText()+
    "', '"+gPers.cinField.getText()+"','"+gPers.bg2.getSelection().getActionCommand()+
    "', '"+gPers.etatcivilCombo.getSelectedItem()+"', '"+((JTextField)(gPers.dayChooser.getDateEditor().getUiComponent())).getText()+
    "', '"+gPers.lieuNaissField.getText()+"', '"+gPers.telephoneField.getText()+"', '"+gPers.adressElectroField.getText()+
    "', '"+gPers.adressResField.getText()+"', '"+gPers.numCompteField.getText()+"', '"+gPers.nomBanqueField.getText()+
    "', '"+gPers.agenceField.getText()+"', '"+gPers.nomCnjField.getText()+"', '"+gPers.prenomCnjField.getText()+
    "', '"+gPers.nbEnfantField.getText()+"', '"+gPers.nomDipField.getText()+"', '"+gPers.etablissementField.getText()+
    "', '"+gPers.pieceJointeField.getText()+"', '"+gPers.spcField.getText()+"', '"+gPers.entrepriseField.getText()+
    "', '"+gPers.certifField.getText()+"', '"+gPers.jj.getText()+
    
    "')";
    		if(gestionbase.requeteModification(req)>0)
    			javax.swing.JOptionPane.showMessageDialog(gPers,"Validation avec succée");
    		else
    			javax.swing.JOptionPane.showMessageDialog(gPers,"Echec !!");
    		gPers.effacer();
    	}
    
    
    	lts.remplirTable();
    	
    	
    }

}
