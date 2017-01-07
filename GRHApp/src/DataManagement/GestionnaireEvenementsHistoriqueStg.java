package DataManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.DepartStagiaire;
import Graphics.HistoriqueStagiaireFrame;

public class GestionnaireEvenementsHistoriqueStg implements ActionListener {
	DepartStagiaire dep;
	public GestionBD gestionbase;
	public HistoriqueStagiaireFrame hh;
	
	public GestionnaireEvenementsHistoriqueStg(DepartStagiaire hh)
    {
    	this.dep = hh;
    	gestionbase=new GestionBD();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dep.remplirTable();
	}

}
