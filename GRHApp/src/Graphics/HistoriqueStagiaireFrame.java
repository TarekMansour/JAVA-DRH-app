package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DataManagement.GestionnaireEvenementsDepartStg;
import DataManagement.GestionnaireEvenementsHistoriqueStg;
import net.miginfocom.swing.MigLayout;

public class HistoriqueStagiaireFrame extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane sp;
	public GestionnaireEvenementsHistoriqueStg controleur;
	DepartStagiaire dep;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoriqueStagiaireFrame frame = new HistoriqueStagiaireFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HistoriqueStagiaireFrame() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new MigLayout());
		contentPane.add(sp);
		setContentPane(contentPane);
		
		//Les ecouteurs-----------------------------------------------
    	controleur=new GestionnaireEvenementsHistoriqueStg(dep);
    	remplirTable();
	}
	public void init()
	{
		//table de stage
    	String enteteTab[]={"ID","Nom","Prenom", "Cin", "Date de naissance", "E-Mail", "Crédit", "Décision"};
    	model=new DefaultTableModel(enteteTab,0);
    	table=new JTable(model);
    	table.setRowMargin(10);
    	table.setGridColor(SystemColor.window);
    	table.setRowHeight(20);
    	table.setBackground(Color.WHITE);
    	sp=new JScrollPane(table);
    	sp.setPreferredSize(new Dimension(780, 390));
    	sp.setBackground(Color.WHITE);
	}
	
	public void remplirTable()
    {
    	controleur.gestionbase.requeteSelection("SELECT id, nom, prenom, cin, datenaiss, email, creditfinal, décision FROM departstagiaire",model);
    }

}
