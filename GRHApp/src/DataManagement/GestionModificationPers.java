package DataManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Graphics.DossierPersonnelFrame;
import Graphics.ListePersonnelFrame;
import Graphics.ModifierPersonne;


public class GestionModificationPers implements ActionListener {
	ModifierPersonne mdpers;
	ListePersonnelFrame lts;
	public GestionBD gestionbase;
	private JTextField matriculeField;
	
	public GestionModificationPers(ModifierPersonne mdpers)
    {
    	this.mdpers=mdpers;
    	gestionbase=new GestionBD();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		matriculeField = new JTextField(20);
   	 	String name = JOptionPane.showInputDialog(matriculeField,"SVP tapez la matricule du personnel à modifier", null);
		if(e.getSource()==mdpers.modifierButton)	
		{String req="UPDATE dossierpersonnel SET etatcivil=('"+mdpers.etatcivilCombo.getSelectedItem()+"'), adresseElctro=('"+mdpers.adresseElctroField.getText()+"'), numCompte=('"+mdpers.numCompteField.getText()+
				"'), nomBanque=('"+mdpers.nomBanqueField.getText()+"'), nomDiplome=('"+mdpers.nomdipField+"'),specialite=('"+mdpers.spcField.getText()+"') WHERE matricue='"+matriculeField.getText()+"'";
       	 		
			if(gestionbase.requeteModification(req)>0)
				javax.swing.JOptionPane.showMessageDialog(mdpers,"Mise à jour effectuée");
			else
				javax.swing.JOptionPane.showMessageDialog(mdpers,"Echec de mise à jour");
		}
	}

}
