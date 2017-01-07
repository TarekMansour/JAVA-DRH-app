package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;

import com.toedter.calendar.JDateChooser;

import DataManagement.GestionnaireEvenementsPersonne;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.util.Date;
import java.util.Calendar;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class DossierPersonnelFrame extends JFrame implements ActionListener{
	// Attribut
	private JPanel contentPane;
	private JPanel matriculePanel;
	private JPanel infoPanel;
	private JPanel infoPersonnelPanel;
	private JPanel infoPers1;
	private JPanel infoPers2;
	private JPanel sexePanel;
	private JPanel panelDate;
	
	//labels for infoPers1
	private JLabel matriculeLabel;
	private JLabel typePersLabel;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel cinLabel;
	private JLabel sexLabel;
	private JLabel etatcivilLabel;
	//labels for infoPers2
	private JLabel dateNaissLabel;
	private JLabel lieuNaissLabel;
	private JLabel telephoneLabel;
	private JLabel adressResLabel;
	private JLabel adressElectroLabel;

	public JTextField matriculeField;
	public JTextField nomField;
	public JTextField prenomField;
	public JTextField cinField;
	public JTextField lieuNaissField;
	public JTextField telephoneField;
	public JTextField adressResField;
	public JTextField adressElectroField;
	public JRadioButton agentR;
	public JRadioButton employeeR;
	public JRadioButton masculinR;
	public JRadioButton femininR;
	
	public JComboBox<?> etatcivilCombo ;
	public JTextField dateT;
	private JButton btnDate;
	private JPanel profilPhotoPanel;
	private JButton profilPhotoButton;
	public JLabel photoprofil;
	private JLabel numCompteLabel;
	private JLabel nomBanqueLabel;
	private JLabel agenceLabel;
	public JTextField numCompteField;
	public JTextField nomBanqueField;
	public JTextField agenceField;
	private JPanel panelbank1;
	private JPanel panelbank2;
	private JPanel panelbank3;
	private JLabel nomCnjLabel;
	private JLabel prenomCnjLabel;
	private JLabel nbEnfantLabel;
	private JPanel panelconjoint1;
	private JPanel panelconjoint2;
	private JPanel panelconjoint3;
	public JTextField nomCnjField;
	public JTextField prenomCnjField;
	public JTextField nbEnfantField;
	private JPanel panelBank;
	private JPanel panelConjoint;
	private JLabel nomDescLabel;
	private JLabel prenomDescLabel;
	private JLabel dateNaissDescLabel;
	private JPanel paneldescendant;
	private JPanel paneldescendant1;
	private JPanel paneldescendant2;
	private JPanel paneldescendant3;
	private JTextField nomDescField;
	private JTextField prenomDescField;
	private JTextField dateNaissDescField;
	private JLabel nomDipabel;
	private JLabel etablissementLabel;
	private JLabel pieceJointeLabel;
	private JPanel panelDiplome;
	private JPanel panelDiplome1;
	private JPanel panelDiplome2;
	private JPanel panelDiplome3;
	public JTextField nomDipField;
	public JTextField etablissementField;
	public JTextField pieceJointeField;
	private JButton pieceJointeButton;
	private JLabel specLabel;
	private JLabel entrpriseLabel;
	private JLabel certifLabel;
	private JPanel panelCompetences;
	private JPanel panelCompetence1;
	private JPanel panelCompetence2;
	private JPanel panelCompetence3;
	public JTextField spcField;
	public JTextField entrepriseField;
	public JTextField certifField;
	private JButton certifButton;
	public JDateChooser dayChooser;
	private JDateChooser dateNaissDescChooser;
	public JButton validerAjoutButton;
	private JPanel validerAjoutPanel;
	private JPanel paneldiv;
	private JPanel paneldiv2;
	
	GestionnaireEvenementsPersonne controleur;
	public ButtonGroup bg;
	public ButtonGroup bg2;
	public JTextField jj;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DossierPersonnelFrame frame = new DossierPersonnelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public DossierPersonnelFrame() {
		super("Dossier personnel");
		init();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel framePAnel = new JPanel();
		framePAnel.setLayout(new MigLayout());
		framePAnel.setBackground(Color.WHITE);
		framePAnel.add(matriculePanel,"north,gapx 13");
		framePAnel.add(infoPanel, "dock center");
		
		setContentPane(contentPane);
		contentPane.add(framePAnel);
		//infopers1
		sexePanel.add(masculinR); sexePanel.add(femininR);
		infoPers1.add(nomLabel);infoPers1.add(nomField, "wrap");
		infoPers1.add(prenomLabel);infoPers1.add(prenomField, "wrap");
		infoPers1.add(cinLabel);infoPers1.add(cinField, "wrap");
		infoPers1.add(sexLabel);infoPers1.add(sexePanel, "wrap");
		infoPers1.add(etatcivilLabel);infoPers1.add(etatcivilCombo, "wrap");
		//infopers2
		infoPers2.add(dateNaissLabel); infoPers2.add(dayChooser, "wrap");
		infoPers2.add(lieuNaissLabel); infoPers2.add(lieuNaissField, "wrap");
		infoPers2.add(telephoneLabel); infoPers2.add(telephoneField, "wrap");
		infoPers2.add(adressElectroLabel); infoPers2.add(adressElectroField, "wrap");
		infoPers2.add(adressResLabel); infoPers2.add(adressResField, "wrap");
		
		//photo profil
		profilPhotoPanel.add(photoprofil, "wrap");
		profilPhotoPanel.add(profilPhotoButton);
		
		//panel des information personelles
		infoPersonnelPanel.add(infoPers1, "cell 0 0");
		infoPersonnelPanel.add(infoPers2, "cell 2 0,gapx 40");
		infoPersonnelPanel.add(profilPhotoPanel, "cell 3 0,gapx 20");
		
		//info bancaires
		panelbank1.add(numCompteLabel); panelbank1.add(numCompteField); 
		panelbank2.add(nomBanqueLabel, "gapx 7");panelbank2.add(nomBanqueField, "gapx 24");
		panelbank3.add(agenceLabel); panelbank3.add(agenceField);
		
		//info conjoint
		panelconjoint1.add(nomCnjLabel); panelconjoint1.add(nomCnjField, "gapx 27"); 
		panelconjoint2.add(prenomCnjLabel, "gapx 7");panelconjoint2.add(prenomCnjField, "gapx 64");
		panelconjoint3.add(nbEnfantLabel); panelconjoint3.add(nbEnfantField);
		
		//info descendant
		paneldescendant1.add(nomDescLabel); paneldescendant1.add(nomDescField, "gapx 27"); 
		paneldescendant2.add(prenomDescLabel, "gapx 7");paneldescendant2.add(prenomDescField, "gapx 64");
		paneldescendant3.add(dateNaissDescLabel); paneldescendant3.add(dateNaissDescChooser);
		
		//info diplome
		panelDiplome1.add(nomDipabel); panelDiplome1.add(nomDipField, "gapx 27"); 
		panelDiplome2.add(etablissementLabel, "gapx 7");panelDiplome2.add(etablissementField, "gapx 30");
		panelDiplome3.add(pieceJointeLabel); panelDiplome3.add(pieceJointeField, "gapx 26"); panelDiplome3.add(pieceJointeButton, "cell 1 0");
		
		//info compétences
		panelCompetence1.add(specLabel); panelCompetence1.add(spcField, "gapx 3"); 
		panelCompetence2.add(entrpriseLabel, "gapx 7");panelCompetence2.add(entrepriseField, "gapx 45");
		panelCompetence3.add(certifLabel); panelCompetence3.add(certifField, "gapx 33"); panelCompetence3.add(certifButton, "cell 1 0");
		
		panelBank.add(panelbank1, "split 3");
		panelBank.add(panelbank2, "gapx 46");
		panelBank.add(panelbank3, "gapx 30,wrap");
		
		panelConjoint.add(panelconjoint1, "split 3");
		panelConjoint.add(panelconjoint2, "gapx 46");
		panelConjoint.add(panelconjoint3, "gapx 30");
		
		paneldescendant.add(paneldescendant1, "split 3");
		paneldescendant.add(paneldescendant2, "gapx 46");
		paneldescendant.add(paneldescendant3, "gapx 30");
		
		panelDiplome.add(panelDiplome1, "split 3");
		panelDiplome.add(panelDiplome2, "gapx 46");
		panelDiplome.add(panelDiplome3, "gapx 30");
		
		panelCompetences.add(panelCompetence1, "split 3");
		panelCompetences.add(panelCompetence2, "gapx 46");
		panelCompetences.add(panelCompetence3, "gapx 30");
		
		paneldiv = new JPanel();
		paneldiv.setBackground(Color.WHITE);
		paneldiv.setMinimumSize(new Dimension(10, 20));
		
		paneldiv2 = new JPanel();
		paneldiv2.setBackground(Color.WHITE);
		paneldiv2.setMinimumSize(new Dimension(10, 20));
		
		infoPanel.add(infoPersonnelPanel, "wrap");
		infoPanel.add(panelBank, "wrap");
		infoPanel.add(panelConjoint, "wrap");
		//infoPanel.add(paneldescendant, "wrap");
		infoPanel.add(panelDiplome, "wrap");
		infoPanel.add(panelCompetences, "wrap");
		infoPanel.add(paneldiv, "gapx 500,wrap");
		infoPanel.add(validerAjoutButton ,"gapx 500,wrap");
		infoPanel.add(paneldiv2, "gapx 500,wrap");
		pack();
		 etatcivilCombo.addItemListener(new ItemListener() {

	            public void itemStateChanged(ItemEvent e) {
	            	if (etatcivilCombo.getSelectedItem().equals("----")) {
	                	panelConjoint.setVisible(true);
	                }
	            	if (etatcivilCombo.getSelectedItem().equals("Célibataire")) {
	                	panelConjoint.setVisible(false);
	                }
	            	if (etatcivilCombo.getSelectedItem().equals("Mariée")) {
	                	panelConjoint.setVisible(true);
	                }
	            	
	            	
	            }
	        });
		 
		
		 
		//Les ecouteurs-----------------------------------------------
		 controleur=new GestionnaireEvenementsPersonne(this);
	     //remplirTable();
	    
	    validerAjoutButton.addActionListener(controleur);
	    
	    agentR.setActionCommand("Agent administratif"); employeeR.setActionCommand("employé(e)");
	    masculinR.setActionCommand("Masculin"); femininR.setActionCommand("féminin");
	}

	private void init() {
		// TODO Auto-generated method stub
		matriculeLabel = new JLabel("Matricule :");
		typePersLabel = new JLabel("Type personnel :");
		matriculeField = new JTextField("0"); matriculeField.setEnabled(false);
		matriculeField.setBackground(Color.WHITE);
		matriculeField.setEnabled(false);
		matriculeField.setPreferredSize(new Dimension(115, 20));
		agentR = new JRadioButton("Agent administratif");
		agentR.setBackground(Color.WHITE);
		employeeR = new JRadioButton("employé(e)");
		employeeR.setBackground(Color.WHITE);

		bg = new ButtonGroup();// to able the selection just for one radioButton
		bg.add(agentR);
		bg.add(employeeR);
		// agentR.setSelected(true);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout());
		contentPane.setLayout(new MigLayout("flowy, ins -14"));

		matriculePanel = new JPanel();
		matriculePanel.setBackground(Color.WHITE);
		//matriculePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		matriculePanel.setLayout(new MigLayout());
		matriculePanel.add(matriculeLabel);
		matriculePanel.add(matriculeField);
		matriculePanel.add(typePersLabel);
		matriculePanel.add(agentR);
		matriculePanel.add(employeeR);

		infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setLayout(new MigLayout());

		infoPersonnelPanel = new JPanel();
		infoPersonnelPanel.setBackground(Color.WHITE);
		infoPersonnelPanel.setLayout(new MigLayout("", "[][]", "[]"));

		infoPers1 = new JPanel();
		infoPers1.setBackground(Color.WHITE);
		infoPers1.setLayout(new MigLayout());
		
		infoPers2 = new JPanel();
		infoPers2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		infoPers2.setBackground(Color.WHITE);
		infoPers2.setLayout(new MigLayout());
		
		sexePanel = new JPanel(); 
		sexePanel.setLayout(new GridLayout(1, 2));
		masculinR = new JRadioButton("Masculin");
		masculinR.setBackground(Color.WHITE);
		femininR = new JRadioButton("féminin");
		femininR.setBackground(Color.WHITE);
		 bg2 = new ButtonGroup();// to able the selection just for one radioButton
		bg2.add(masculinR);
		bg2.add(femininR);
		
		nomLabel = new JLabel("Nom :");
		prenomLabel = new JLabel("Prénom :");
		cinLabel = new JLabel("CIN :");
		sexLabel = new JLabel("Sexe :");
		etatcivilLabel = new JLabel("Etat civil :");

		nomField = new JTextField(20);
		prenomField = new JTextField(20);
		cinField = new JTextField(20);
		String[] etatcivil = { "----","Célibataire", "Mariée"};
		etatcivilCombo = new JComboBox<Object>(etatcivil);
		etatcivilCombo.setBackground(Color.WHITE);
		//etatcivilCombo.setSelectedItem();
		
		dateNaissLabel = new JLabel("Date naissance :");
		lieuNaissLabel = new JLabel("Lieu naissance :");
		telephoneLabel = new JLabel("N° téléphone :");
		adressResLabel = new JLabel("Adresse résidentielle :");
		adressElectroLabel = new JLabel("Adresse électronique :");
		
		dayChooser = new JDateChooser();
		dayChooser.setDateFormatString("yyyy-MM-dd");
		dayChooser.setMinimumSize(new Dimension(167, 20));
		dayChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dayChooser.setBackground(Color.WHITE);
		
		lieuNaissField = new JTextField(20);
		telephoneField = new JTextField(20);
		adressResField = new JTextField(20);
		adressResField.setBackground(Color.WHITE);
		adressElectroField = new JTextField(20);  
		
    	photoprofil= new JLabel(new ImageIcon((getClass().getResource("/Ressources/bb2.png"))));
    	profilPhotoButton=new JButton("Changer photo");
    	profilPhotoButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	profilPhotoButton.setContentAreaFilled(false);
		profilPhotoButton.setBorderPainted(false);
    	profilPhotoPanel=new JPanel();
    	profilPhotoPanel.setBackground(Color.white);
    	profilPhotoPanel.setPreferredSize(new Dimension(160,160));
    	profilPhotoPanel.setLayout(new MigLayout());
    	
    	//panel pour les informations bancaires
    	numCompteLabel = new JLabel("N\u00B0 compte :");
    	nomBanqueLabel = new JLabel("Nom du banque :");
    	agenceLabel = new JLabel("Agence :");

    	panelBank = new JPanel(); 
    	panelBank.setBorder(new TitledBorder(null, "Information bancaires", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));panelBank.setBackground(Color.WHITE);panelBank.setLayout(new MigLayout()); 
    	panelbank1 = new JPanel(); panelbank1.setBackground(Color.WHITE);panelbank1.setLayout(new MigLayout());
    	panelbank2 = new JPanel(); panelbank2.setBackground(Color.WHITE); panelbank2.setLayout(new MigLayout());
    	panelbank3 = new JPanel(); panelbank3.setBackground(Color.WHITE); panelbank3.setLayout(new MigLayout());
    	
    	numCompteField = new JTextField(19);
    	nomBanqueField = new JTextField(20);
    	agenceField = new JTextField(18);
    	
    	//panel pour les informations familiale
    	nomCnjLabel = new JLabel("Nom :");
    	prenomCnjLabel = new JLabel("Prénom :");
    	nbEnfantLabel = new JLabel("Enfants :");
    	
    	panelConjoint = new JPanel();  
    	panelConjoint.setBorder(new TitledBorder(null, "Conjoint", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));panelConjoint.setBackground(Color.WHITE);panelConjoint.setLayout(new MigLayout());
    	panelconjoint1 = new JPanel(); panelconjoint1.setBackground(Color.WHITE);panelconjoint1.setLayout(new MigLayout());
    	panelconjoint2 = new JPanel(); panelconjoint2.setBackground(Color.WHITE); panelconjoint2.setLayout(new MigLayout());
    	panelconjoint3 = new JPanel(); panelconjoint3.setBackground(Color.WHITE); panelconjoint3.setLayout(new MigLayout());
    	
    	nomCnjField = new JTextField(19);
    	prenomCnjField = new JTextField(20);
    	nbEnfantField = new JTextField(18);
    	
    	//panel pour les informations des descendants
    	nomDescLabel = new JLabel("Nom :");
    	prenomDescLabel = new JLabel("Prénom :");
    	dateNaissDescLabel = new JLabel("Date naissance :");
    	
    	paneldescendant = new JPanel();  
    	paneldescendant.setBorder(new TitledBorder(null, "Descendants", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));paneldescendant.setBackground(Color.WHITE);paneldescendant.setLayout(new MigLayout());
    	paneldescendant1 = new JPanel(); paneldescendant1.setBackground(Color.WHITE);paneldescendant1.setLayout(new MigLayout());
    	paneldescendant2 = new JPanel(); paneldescendant2.setBackground(Color.WHITE); paneldescendant2.setLayout(new MigLayout());
    	paneldescendant3 = new JPanel(); paneldescendant3.setBackground(Color.WHITE); paneldescendant3.setLayout(new MigLayout());
    	
    	nomDescField = new JTextField(19);
    	prenomDescField = new JTextField(20);
    	dateNaissDescChooser = new JDateChooser();
    	dateNaissDescChooser.setDateFormatString("dd-MM-yyyy");
    	dateNaissDescChooser.setMinimumSize(new Dimension(118, 20));
    	dateNaissDescChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    	dateNaissDescChooser.setBackground(Color.WHITE);
    	
    	//panel pour le diplome
    	nomDipabel = new JLabel("Nom :");
    	etablissementLabel = new JLabel("Etablissement :");
    	pieceJointeLabel = new JLabel("pièce jointe :");
    	
    	panelDiplome = new JPanel();  
    	panelDiplome.setBorder(new TitledBorder(null, "Diplôme", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));panelDiplome.setBackground(Color.WHITE);panelDiplome.setLayout(new MigLayout());
    	panelDiplome1 = new JPanel(); panelDiplome1.setBackground(Color.WHITE);panelDiplome1.setLayout(new MigLayout());
    	panelDiplome2 = new JPanel(); panelDiplome2.setBackground(Color.WHITE); panelDiplome2.setLayout(new MigLayout());
    	panelDiplome3 = new JPanel(); panelDiplome3.setBackground(Color.WHITE); panelDiplome3.setLayout(new MigLayout());
    	
    	nomDipField = new JTextField(19);
    	etablissementField = new JTextField(20);
    	pieceJointeField = new JTextField(18);
    	pieceJointeButton=new JButton(new ImageIcon(getClass().getResource("/Ressources/attachment1.png")));
    	pieceJointeButton.setContentAreaFilled(false);
    	pieceJointeButton.setBorderPainted(false);
    	
    	//panel pour les compétences
    	specLabel = new JLabel("Spécialité :");
    	entrpriseLabel = new JLabel("Entreprises :");
    	certifLabel = new JLabel("Certificats :");
    	
    	panelCompetences = new JPanel();  
    	panelCompetences.setBorder(new TitledBorder(null, "Compétence", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));panelCompetences.setBackground(Color.WHITE);panelCompetences.setLayout(new MigLayout());
    	panelCompetence1 = new JPanel(); panelCompetence1.setBackground(Color.WHITE);panelCompetence1.setLayout(new MigLayout());
    	panelCompetence2 = new JPanel(); panelCompetence2.setBackground(Color.WHITE); panelCompetence2.setLayout(new MigLayout());
    	panelCompetence3 = new JPanel(); panelCompetence3.setBackground(Color.WHITE); panelCompetence3.setLayout(new MigLayout());
    	
    	spcField = new JTextField(19);
    	entrepriseField = new JTextField(20);
    	certifField = new JTextField(18);
    	certifButton=new JButton(new ImageIcon(getClass().getResource("/Ressources/attachment1.png")));
    	certifButton.setContentAreaFilled(false);
    	certifButton.setBorderPainted(false);
    	
    	validerAjoutPanel = new JPanel(new MigLayout());
    	validerAjoutButton = new JButton("Valider");
    	validerAjoutButton.setToolTipText("Valider la nouvelle cr\u00E9ation de cet personnel");
    	//validerAjoutButton.setDefaultCapable(false);
    	validerAjoutButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
    	//validerAjoutButton.setContentAreaFilled(false);
    	//validerAjoutButton.setBorderPainted(false);
    	
    	//les écouteurs
		profilPhotoButton.addActionListener(this);
		pieceJointeButton.addActionListener(this);
		certifButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
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
	                    	jj = new JTextField();
	                    	jj.setText(fc.getSelectedFile().getName());
	                    	
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }
		}

		if (e.getSource() == pieceJointeButton)
		{	
	                JFileChooser fc = new JFileChooser();
	                FileNameExtensionFilter filtre = new FileNameExtensionFilter("*.Files", "docx", "pdf");
	                fc.addChoosableFileFilter(filtre);
	                int result = fc.showOpenDialog(null);
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File file = fc.getSelectedFile();
	                    pieceJointeField.setText(fc.getSelectedFile().getName());
	                }
		}
		
		if (e.getSource() == certifButton)
		{	
	                JFileChooser fc = new JFileChooser();
	                FileNameExtensionFilter filtre = new FileNameExtensionFilter("*.Files", "docx", "pdf");
	                fc.addChoosableFileFilter(filtre);
	                int result = fc.showOpenDialog(null);
	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File file = fc.getSelectedFile();
	                    certifField.setText(fc.getSelectedFile().getName());
	                }
		}
	}

	public void effacer()
	{
		nomField.setText(""); prenomField.setText("");cinField.setText("");
		etatcivilCombo.setSelectedItem("----"); ((JTextField)(dayChooser.getDateEditor().getUiComponent())).setText("");
		lieuNaissField.setText(""); telephoneField.setText(""); adressElectroField.setText(""); adressResField.setText(""); numCompteField.setText("");
		nomBanqueField.setText(""); agenceField.setText(""); nomCnjField.setText(""); prenomCnjField.setText("");nbEnfantField.setText(""); nomDipField.setText("");
		etablissementField.setText("");pieceJointeField.setText("");spcField.setText(""); entrepriseField.setText("");certifField.setText(""); 
	}


	
	   
}
