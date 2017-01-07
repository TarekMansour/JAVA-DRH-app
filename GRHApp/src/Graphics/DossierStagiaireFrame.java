package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTree;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.Insets;

import DataManagement.GestionnaireEvenementsStage;
import DataManagement.GestionBD;

public class DossierStagiaireFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel cinLabel;
	private JLabel dateNaissLabel;
	private JLabel niveauEtudeLabel;
	private JLabel numTelLabel;
	private JLabel adressResLabel;
	private JLabel adressElectroLabel;
	public JTextField nomField;
	public JTextField prenomField;
	public JTextField cinField;
	public JDateChooser dateNaissChooser;
	public JTextField niveauetudeField;
	public JTextField telephoneField;
	public JTextField adressResField;
	public JTextField adressElectroField;
	public JLabel photoprofil;
	private JButton profilPhotoButton;
	private JPanel profilPhotoPanel;
	private JLabel sujetLabel;
	private JLabel lieuLAbel;
	private JLabel creditLabel;
	private JLabel dateDebutLabel;
	private JLabel dateFinLabel;
	private JLabel formateurLabel;
	public JTextField sujetField;
	public JTextField lieuField;
	public JTextField creditField;
	public JComboBox formateurCombo;
	public JDateChooser dateDebutChooser;
	public JDateChooser dateFinChooser;
	private JPanel panelStage;
	private JPanel panelStagiaire;
	private JPanel stgPanel;
	public JButton validercontratButton;
	private DefaultTableModel model;
	public JTable table;
	private JScrollPane sp;
	private JPanel stgDataPanel;
	
	public GestionnaireEvenementsStage controleur;
	public JButton modifierButton;
	public JButton supprimerButton;
	private JPanel btnpanel;
	private JPanel btnpanel1;
	private JLabel idLabel;
	public JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DossierStagiaireFrame frame = new DossierStagiaireFrame();
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
	public DossierStagiaireFrame() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new MigLayout());
		contentPane.add(stgPanel,"dock west");
		contentPane.add(stgDataPanel,"dock east, wrap");
		setContentPane(contentPane);
		
		panelStage.add(profilPhotoButton, ""); panelStage.add(photoprofil,"wrap");
		panelStage.add(idLabel); panelStage.add(idField,"wrap");  //idField.setEnabled(false);
		panelStage.add(nomLabel); panelStage.add(nomField,"wrap");
		panelStage.add(prenomLabel); panelStage.add(prenomField,"wrap");
		panelStage.add(cinLabel); panelStage.add(cinField,"wrap");
		panelStage.add(dateNaissLabel); panelStage.add(dateNaissChooser,"wrap");
		panelStage.add(niveauEtudeLabel); panelStage.add(niveauetudeField,"wrap");
		panelStage.add(numTelLabel); panelStage.add(telephoneField,"wrap");
		panelStage.add(adressElectroLabel); panelStage.add(adressElectroField,"wrap");
		panelStage.add(adressResLabel); panelStage.add(adressResField,"wrap");
		
		panelStagiaire.add(sujetLabel); panelStagiaire.add(sujetField,"wrap");
		panelStagiaire.add(lieuLAbel); panelStagiaire.add(lieuField,"wrap");
		panelStagiaire.add(creditLabel); panelStagiaire.add(creditField,"wrap");
		panelStagiaire.add(dateDebutLabel); panelStagiaire.add(dateDebutChooser,"wrap");
		panelStagiaire.add(dateFinLabel); panelStagiaire.add(dateFinChooser,"wrap");
		panelStagiaire.add(formateurLabel); panelStagiaire.add(formateurCombo,"wrap");
		
		stgPanel.add(panelStage,"wrap"); 
		stgPanel.add(panelStagiaire, "wrap");stgPanel.add(validercontratButton,"gapx 232,wrap");
		
		btnpanel.add(modifierButton);
		btnpanel.add(supprimerButton);
		
		stgDataPanel.add(sp,"wrap");
		stgDataPanel.add(btnpanel1,"wrap"); 
		stgDataPanel.add(btnpanel,"gapx 320,wrap");
		pack();
		
		//Les ecouteurs-----------------------------------------------
    	controleur=new GestionnaireEvenementsStage(this);
    	remplirTable();
    	//sur les bouttons
    	validercontratButton.addActionListener(controleur);
    	modifierButton.addActionListener(controleur);
    	supprimerButton.addActionListener(controleur);
    	profilPhotoButton.addActionListener(this);
	}
	
	public void init()
	{	idLabel = new JLabel("Matricule :");
		nomLabel = new JLabel("Nom :");
		prenomLabel = new JLabel("Prénom :");
		cinLabel = new JLabel("CIN :");
		dateNaissLabel = new JLabel("Date naissance :");
		niveauEtudeLabel = new JLabel("Niveau d'etude :");
		numTelLabel = new JLabel("N° téléphone :");
		adressResLabel = new JLabel("Adresse résidentielle :");
		adressElectroLabel = new JLabel("Adresse électronique :");
		
		idField = new JTextField(20);
		nomField = new JTextField(20);
		prenomField = new JTextField(20);
		cinField = new JTextField(20);
		dateNaissChooser = new JDateChooser();
		dateNaissChooser.setDateFormatString("yyyy-MM-dd");
		dateNaissChooser.setMinimumSize(new Dimension(167, 20));
		dateNaissChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateNaissChooser.setBackground(Color.WHITE);
		niveauetudeField = new JTextField(20);
		telephoneField = new JTextField(20);
		adressResField = new JTextField(20);
		adressElectroField = new JTextField(20);  
		
		photoprofil= new JLabel(new ImageIcon((getClass().getResource("/Ressources/bb6.png"))));
    	profilPhotoButton=new JButton(new ImageIcon((getClass().getResource("/Ressources/profilPhoto1.png"))));
    	profilPhotoButton.setMargin(new Insets(0, 2, 2, 14));
    	profilPhotoButton.setContentAreaFilled(false);
		profilPhotoButton.setBorderPainted(false);
		
    	//coordonné stagiaire
    	sujetLabel = new JLabel("Sujet du stage :");
    	lieuLAbel = new JLabel("Lieu du stage :");
    	creditLabel = new JLabel("Crédir initial stagiaire :");
    	dateDebutLabel = new JLabel("Date début :");
    	dateFinLabel = new JLabel("Date fin :");
    	formateurLabel = new JLabel("Formateur :");
    	
    	sujetField = new JTextField(20);
    	lieuField = new JTextField(20);
    	creditField = new JTextField(20);
    	formateurCombo = new JComboBox<>();
    	formateurCombo.setMinimumSize(new Dimension(167, 20));
    	dateDebutChooser = new JDateChooser();
    	dateDebutChooser.setDateFormatString("yyyy-MM-dd");
    	dateDebutChooser.setMinimumSize(new Dimension(167, 20));
    	dateDebutChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    	dateDebutChooser.setBackground(Color.WHITE);

		dateFinChooser = new JDateChooser();
		dateFinChooser.setDateFormatString("yyyy-MM-dd");
		dateFinChooser.setMinimumSize(new Dimension(167, 20));
		dateFinChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateFinChooser.setBackground(Color.WHITE);
		
		stgPanel = new JPanel(new MigLayout());
		stgPanel.setBackground(Color.WHITE);
		panelStage = new JPanel(new MigLayout());
		panelStage.setBorder(new TitledBorder(null, "coordonn\u00E9es stage ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelStage.setBackground(Color.WHITE);
		panelStagiaire = new JPanel(new MigLayout());
		panelStagiaire.setBorder(new TitledBorder(null, "coordonn\u00E9es stagiaire ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelStagiaire.setBackground(Color.WHITE);
    	
		//buttons
		validercontratButton = new JButton("Valider");
    	validercontratButton.setToolTipText("Valider coordonnées stages");
    	validercontratButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
    	
    	modifierButton = new JButton("Modifier");
    	modifierButton.setToolTipText("Modifier stagiaire");
    	modifierButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
    	
    	supprimerButton = new JButton("Supprimer"); 
    	supprimerButton.setToolTipText("");
    	supprimerButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
    	btnpanel1 = new JPanel(new MigLayout());
    	btnpanel1.setBackground(Color.WHITE);
    	btnpanel = new JPanel(new MigLayout());
    	btnpanel.setBackground(Color.WHITE);
    	
    	//table de stage
    	String enteteTab[]={"ID","Nom","Prenom", "Cin", "Date de naissance", "E-Mail", "Sujet stage", "Crédit", "Date début", "Date fin"};
    	model=new DefaultTableModel(enteteTab,0);
    	table=new JTable(model);
    	table.setRowMargin(10);
    	table.setGridColor(SystemColor.window);
    	table.setRowHeight(20);
    	table.setBackground(Color.WHITE);
    	sp=new JScrollPane(table);
    	sp.setPreferredSize(new Dimension(452, 320));
    	sp.setMinimumSize(new Dimension(840, 400));
    	sp.setBackground(Color.WHITE);
    	stgDataPanel = new JPanel(new MigLayout());
    	stgDataPanel.setMinimumSize(new Dimension(840, 14));
    	stgDataPanel.setBorder(new TitledBorder(null, "Stage ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
    	stgDataPanel.setBackground(Color.WHITE);
    	
    	
		
	}
	
	public void remplirTable()
    {
    	controleur.gestionbase.requeteSelection("SELECT id, nom, prenom, cin, datenaiss, email, sujetstage, credit, datedeb, datefin FROM stage",model);
    }
	
	public void effacer()
    {
    	nomField.setText("");
    	prenomField.setText("");
    	cinField.setText("");
    	((JTextField)(dateNaissChooser.getDateEditor().getUiComponent())).setText("");
    	niveauetudeField.setText("");
    	telephoneField.setText("");
    	adressElectroField.setText("");
    	adressResField.setText("");
    	sujetField.setText("");
    	lieuField.setText("");
    	creditField.setText("");
    	((JTextField)(dateDebutChooser.getDateEditor().getUiComponent())).setText(""); 
    	((JTextField)(dateFinChooser.getDateEditor().getUiComponent())).setText("");
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == profilPhotoButton)
		{	
	                JFileChooser fc = new JFileChooser();
	                FileNameExtensionFilter filtre = new FileNameExtensionFilter("*.Images", "jpg", "png", "gif");
	                fc.addChoosableFileFilter(filtre);
	                int result = fc.showOpenDialog(null);
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File file = fc.getSelectedFile();
	                    try {
	                    	photoprofil.setIcon(new ImageIcon(ImageIO.read(file)));
	                    	
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }
		}
	}
}
