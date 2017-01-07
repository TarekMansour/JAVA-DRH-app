package DataManagement;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Graphics.DossierStagiaireFrame;
import Graphics.HistoriqueStagiaireFrame;
import Graphics.DepartStagiaire;

public class GestionnaireEvenementsDepartStg  implements ActionListener{
	 DepartStagiaire dep;
	public GestionBD gestionbase;
	public HistoriqueStagiaireFrame hh;
	
	public GestionnaireEvenementsDepartStg(DepartStagiaire dep)
    {
    	this.dep = dep;
    	gestionbase=new GestionBD();
    }
	//ActionListener------------------------------------------------------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e)
    {
    	//depart stg
    	if(e.getSource()==dep.validepartButton)
    	{
    	String req="INSERT INTO departstagiaire (nom, prenom, cin, datenaiss, email, datedepart, creditfinal, décision) "
    	+"VALUES('"+dep.nomField.getText()+"', '"+dep.prenomField.getText()+"', '"+dep.cinField.getText()
    			 +"', '"+((JTextField)(dep.dateNaissChooser.getDateEditor().getUiComponent())).getText()+"', '"+dep.adressElectroField.getText()
    	
    			 +"', '"+((JTextField)(dep.dateDepartChooser.getDateEditor().getUiComponent())).getText()
    			 +"', '"+dep.creditField.getText()+"', '"+dep.decisionField.getSelectedItem()+"')";
    		
    	
    	if(gestionbase.requeteModification(req)>0)
    			{javax.swing.JOptionPane.showMessageDialog(dep,"départ effectuée");  }
    		else
    			javax.swing.JOptionPane.showMessageDialog(dep,"Echec !!");
    	//dstg.effacer();
    	}
    	this.hh.remplirTable();
    		
    }

 
}
