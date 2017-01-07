package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

import DataManagement.GestionModificationPers;
import DataManagement.GestionnaireEvenementsPersonne;

import java.awt.SystemColor;
import java.awt.Toolkit;

public class ModifierPersonne extends JFrame {

	private JPanel contentPane;
	private JLabel typePersLabel;
	public JRadioButton agentR;
	public JRadioButton employeeR;
	public ButtonGroup bg;
	private JLabel adressElectroLabel;
	private JLabel numCompteLabel;
	private JLabel nomBanqueLabel;
	private JLabel nomDipabel;
	private JLabel specLabel;
	public JComboBox<Object> etatcivilCombo;
	private JLabel etatcivilLabel;
	public JTextField adresseElctroField;
	public JTextField spcField;
	public JTextField numCompteField;
	public JTextField nomBanqueField;
	public JTextField nomdipField;
	private JPanel panelComponents;
	private JPanel typePanel;
	public JButton modifierButton;
	GestionModificationPers controleur;
	DossierPersonnelFrame gPers;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierPersonne frame = new ModifierPersonne();
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
	public ModifierPersonne() {
		super("Modifier coordonnées personnel");
		setPreferredSize(new Dimension(500, 350));
		init();
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new MigLayout());
		contentPane.add(panelComponents, "dock center");
		setContentPane(contentPane);
		
		typePanel.add(agentR); typePanel.add(employeeR);
		panelComponents.add(typePersLabel);panelComponents.add(typePanel, "gapx 20,wrap");
		panelComponents.add(etatcivilLabel);panelComponents.add(etatcivilCombo, "gapx 20,wrap");
		panelComponents.add(adressElectroLabel);panelComponents.add(adresseElctroField, "gapx 20,wrap");
		panelComponents.add(numCompteLabel);panelComponents.add(numCompteField, "gapx 20,wrap");
		panelComponents.add(nomBanqueLabel);panelComponents.add(nomBanqueField, "gapx 20,wrap");
		panelComponents.add(nomDipabel);panelComponents.add(nomdipField, "gapx 20,wrap");
		panelComponents.add(specLabel);panelComponents.add(spcField, "gapx 20,wrap");
		panelComponents.add(modifierButton, "cell 1 7,gapx 115");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		
		controleur=new GestionModificationPers(this);
		modifierButton.addActionListener(controleur);
		
		agentR.setActionCommand("Agent administratif");
		employeeR.setActionCommand("employé(e)");
	}
	
	public void init()
	{
		typePersLabel = new JLabel("Type personnel :");
		agentR = new JRadioButton("Agent administratif");
		agentR.setBackground(Color.WHITE);
		employeeR = new JRadioButton("employé(e)");
		employeeR.setBackground(Color.WHITE);

		bg = new ButtonGroup();
		bg.add(agentR);
		bg.add(employeeR);
		
		etatcivilLabel = new JLabel("Etat civil :");
		adressElectroLabel = new JLabel("Adresse électronique :");
		numCompteLabel = new JLabel("N° compte :");
    	nomBanqueLabel = new JLabel("Nom du banque :");
    	nomDipabel = new JLabel("Diplome :");
    	specLabel = new JLabel("Spécialité :");
    	
    	String[] etatcivil = { "----","Célibataire", "Mariée"};
		etatcivilCombo = new JComboBox<Object>(etatcivil);
		etatcivilCombo.setPreferredSize(new Dimension(165, 20));
		etatcivilCombo.setBackground(Color.WHITE);
		adresseElctroField = new JTextField(20);
		numCompteField = new JTextField(20);
    	nomBanqueField = new JTextField(20);
    	nomdipField = new JTextField(20);
    	spcField = new JTextField(20);
    	
    	modifierButton = new JButton("Modifier");
    			
    	panelComponents = new JPanel(new MigLayout());
    	panelComponents.setBorder(new TitledBorder(null, "Information \u00E0 modifier", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
    	panelComponents.setBackground(Color.WHITE);
    	typePanel = new JPanel(new GridLayout(1, 2));
    	
		
	}

}
