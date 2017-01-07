package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.awt.geom.Point;

import DataManagement.GestionnaireEvenementsPersonne;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ListePersonnelFrame extends JFrame {
	GestionnaireEvenementsPersonne controleur;
	DossierPersonnelFrame gPers;
	public JTextField matriculeField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListePersonnelFrame frame = new ListePersonnelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private DefaultTableModel model;
	private JTable table;
	private JScrollPane sp;
	private JPanel stgDataPanel;
	private JPanel pap;

	/**
	 * Create the frame.
	 */
	public ListePersonnelFrame() {
		
		
		String enteteTab[]={"Matricule","type personnel","nom", "prenom", "cin", "sexe", "état civil", "date naissance", "E-mail","num banque",  "nom de banque", "Diplome", "spécialitée"};
		model=new DefaultTableModel(enteteTab,0);
		table=new JTable(model);
		table.setBorder(null);
		table.setBackground(Color.WHITE);
		sp=new JScrollPane(table);
		sp.setForeground(new Color(0, 0, 0));
		sp.setFont(new Font("Calibri", Font.PLAIN, 13));
    	sp.setBackground(Color.WHITE);
    	pap = new JPanel(new MigLayout());
    	pap.setBackground(Color.WHITE);
    	pap.add(sp,"dock center");
		setContentPane(pap);
		pack();
		
		table.addMouseListener(new MouseAdapter() {
		    

			public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        java.awt.Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		        	//javax.swing.JOptionPane.showMessageDialog(gPers,"Validation avec succée");
		        	ModifierPersonne ats = new ModifierPersonne();
		        	
		        	ats.show();
		        }
		    }
		});
		
		controleur=new GestionnaireEvenementsPersonne(gPers);
	    remplirTable();
	}
	
	 public void remplirTable()
	    {
	    	controleur.gestionbase.requeteSelection("SELECT matricue, typePers, nom, prenom, cin, sexe, etatcivil, dateNaiss, adresseElctro, numCompte, nomBanque, nomDiplome, specialite   FROM dossierpersonnel",model);
	    }

}
