package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import DataManagement.GestionnaireEvenementsStage;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import DataManagement.GestionnaireEvenementsStage;
import DataManagement.GestionBD;
import DataManagement.GestionnaireEvenementsDepartStg;

public class DepartStagiaire extends JFrame {

	private JPanel contentPane;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel dateDepartLabel;
	private JLabel creditFinalLabel;
	private JLabel descisionLabel;
	public JTextField nomField;
	public JTextField prenomField;
	public JTextField creditField;
	public JDateChooser dateDepartChooser;
	private JPanel panelListeStg;
	private JPanel panelDepStg;
	private JPanel depPanel;
	public JButton validepartButton;
	public JComboBox decisionField;
	private JLabel cinLabel;
	private JLabel dateNaissLabel;
	private JLabel adressElectroLabel;
	public JTextField cinField;
	public JDateChooser dateNaissChooser;
	public JTextField adressElectroField;
	private DefaultTableModel model;
	private JTable table;
	public GestionnaireEvenementsDepartStg controleur;
	private JScrollPane sp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartStagiaire frame = new DepartStagiaire();
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
	public DepartStagiaire() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new MigLayout());
		contentPane.add(depPanel,"dock center");
		setContentPane(contentPane);
		
		panelDepStg.add(nomLabel); panelDepStg.add(nomField, "gapx 30,wrap"); 
		panelDepStg.add(prenomLabel); panelDepStg.add(prenomField, "gapx 30, wrap");
		panelDepStg.add(cinLabel); panelDepStg.add(cinField, "gapx 30, wrap");
		panelDepStg.add(dateNaissLabel); panelDepStg.add(dateNaissChooser, "gapx 30, wrap");
		panelDepStg.add(adressElectroLabel); panelDepStg.add(adressElectroField, "gapx 30, wrap");
		panelDepStg.add(dateDepartLabel); panelDepStg.add(dateDepartChooser, "gapx 30, wrap");
		panelDepStg.add(creditFinalLabel); panelDepStg.add(creditField, "gapx 30, wrap");
		panelDepStg.add(descisionLabel); panelDepStg.add(decisionField, "gapx 30, wrap");
		
		panelListeStg.add(sp);
		
		depPanel.add(panelListeStg, "wrap");
		depPanel.add(panelDepStg, "wrap");
		depPanel.add(validepartButton, "gapx 218");
		pack();
		
		//Les ecouteurs-----------------------------------------------
    	controleur=new GestionnaireEvenementsDepartStg(this);
    	remplirTable();
    	validepartButton.addActionListener(controleur);
	}
	
	public void init()
	{
		nomLabel = new JLabel("Nom :");
		prenomLabel = new JLabel("Prenom :");
		cinLabel = new JLabel("CIN :");
		dateNaissLabel = new JLabel("Date naissance :");
		adressElectroLabel = new JLabel("Adresse électronique :");
		dateDepartLabel = new JLabel("Date départ :");
		creditFinalLabel = new JLabel("Crédit final :");
		descisionLabel = new JLabel("Décision :");
		
		nomField = new JTextField(20);
		prenomField = new JTextField(20);
		cinField = new JTextField(20);
		dateNaissChooser = new JDateChooser();
		dateNaissChooser.setDateFormatString("yyyy-MM-dd");
		dateNaissChooser.setMinimumSize(new Dimension(167, 20));
		dateNaissChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateNaissChooser.setBackground(Color.WHITE);
		adressElectroField = new JTextField(20);
		creditField = new JTextField(20);
		String [] decisions ={"Validé", "Non validé"};
		decisionField = new JComboBox(decisions);
		decisionField.setMinimumSize(new Dimension(167, 20));
		decisionField.setBackground(Color.WHITE);
		dateDepartChooser = new JDateChooser();
		dateDepartChooser.setDateFormatString("yyyy-MM-dd");
		dateDepartChooser.setMinimumSize(new Dimension(167, 20));
		dateDepartChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateDepartChooser.setBackground(Color.WHITE);
		
		panelListeStg = new JPanel(new MigLayout());
		panelListeStg.setBorder(new TitledBorder(null, "Liste des stagiaires ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelListeStg.setBackground(Color.WHITE);
		panelDepStg = new JPanel(new MigLayout());
		panelDepStg.setBorder(new TitledBorder(null, "D\u00E9part stagiaires", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelDepStg.setBackground(Color.WHITE);
		depPanel = new JPanel(new MigLayout());
		depPanel.setBackground(Color.WHITE);
		
		validepartButton = new JButton("Valider");
		validepartButton.setToolTipText("Valider coordonnées stages");
		validepartButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
		
		//table de stage
    	String enteteTab[]={"ID","Nom","Prenom", "Cin", "Date de naissance", "E-Mail", "Crédit"};
    	model=new DefaultTableModel(enteteTab,0);
    	table=new JTable(model);
    	table.setRowMargin(10);
    	table.setGridColor(SystemColor.window);
    	table.setRowHeight(20);
    	table.setBackground(Color.WHITE);
    	sp=new JScrollPane(table);
    	sp.setPreferredSize(new Dimension(520, 140));
    	sp.setBackground(Color.WHITE);
	}
	
	public void remplirTable()
    {
    	controleur.gestionbase.requeteSelection("SELECT id, nom, prenom, cin, datenaiss, email, credit FROM stage",model);
    }

}
