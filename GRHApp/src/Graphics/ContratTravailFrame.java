package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

public class ContratTravailFrame extends JFrame {

	private JPanel contentPane;
	private JLabel matriculLabel;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel cinLabel;
	private JLabel typePresonnelLabel;
	private JLabel natureContartLabel;
	private JLabel dateRecrutementLabel;
	private JLabel dureeContratLabel;
	private JLabel tacheFonctionnelleLabel;
	private JTextField matriculeField;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField cinField;
	private JRadioButton agentRadioButton;
	private JRadioButton employeeRadioButton;
	private DefaultComboBoxModel natureContratmodel;
	private JComboBox natureContratCombo;
	private JDateChooser dateRecruttementChooser;
	private JTextField dureeContratField;
	private JTextField tacheFonctionnelleField;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton validercontratButton;
	private JPanel panelRadio;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel framePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ContratTravailFrame ff = new ContratTravailFrame();
	}

	/**
	 * Create the frame.
	 */
	public ContratTravailFrame() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new MigLayout());
		setContentPane(contentPane);
		contentPane.add(framePanel, "dock center");
		
		panelRadio.add(agentRadioButton); panelRadio.add(employeeRadioButton);
		panel1.add(matriculLabel);panel1.add(matriculeField, "gapx 26,wrap");
		panel1.add(nomLabel);panel1.add(nomField, "gapx 26,wrap");
		panel1.add(prenomLabel);panel1.add(prenomField, "gapx 26,wrap");
		panel1.add(cinLabel);panel1.add(cinField, "gapx 26,wrap");
		panel1.add(typePresonnelLabel);panel1.add(panelRadio,"gapx 20");
		
		panel2.add(natureContartLabel); panel2.add(natureContratCombo, "gapx 26,wrap");
		panel2.add(dateRecrutementLabel); panel2.add(dateRecruttementChooser, "gapx 26,wrap");
		panel2.add(dureeContratLabel); panel2.add(dureeContratField, "gapx 26,wrap");
		panel2.add(tacheFonctionnelleLabel); panel2.add(tacheFonctionnelleField, "gapx 26,wrap");
		framePanel.add(panel3, "wrap");
		framePanel.add(panel1);
		framePanel.add(panel2, "wrap");
		framePanel.add(panel4, "wrap");
		framePanel.add(validercontratButton, "gapx 222, cell 1 2");
		
		pack();
	}

	public void init()
	{
		matriculLabel = new JLabel("Matricule :");
		nomLabel = new JLabel("Nom :");
		prenomLabel = new JLabel("Prénom :");
		cinLabel = new JLabel("CIN :");
		typePresonnelLabel = new JLabel("Type personnel :");
		natureContartLabel = new JLabel("Nature contrat :");
		dateRecrutementLabel = new JLabel("Date recrutement :");
		dureeContratLabel = new JLabel("Durée contrat :");
		tacheFonctionnelleLabel = new JLabel("Tâche fonctionnelle");
		
		matriculeField = new JTextField(20);
		nomField = new JTextField(20);
		prenomField = new JTextField(20);
		cinField = new JTextField(20);
		agentRadioButton = new JRadioButton("Agent administratif"); agentRadioButton.setBackground(Color.WHITE);
		employeeRadioButton = new JRadioButton("Employée"); employeeRadioButton.setBackground(Color.WHITE);
		ButtonGroup bg2 = new ButtonGroup(); agentRadioButton.setBackground(Color.WHITE);
		bg2.add(agentRadioButton);
		bg2.add(employeeRadioButton);
		
		natureContratmodel=new DefaultComboBoxModel();
		natureContratCombo =new JComboBox(natureContratmodel);
		natureContratCombo.setMinimumSize(new Dimension(165, 20));
		dateRecruttementChooser = new JDateChooser();
		dateRecruttementChooser.setDateFormatString("dd-MM-yyyy");
		dateRecruttementChooser.setMinimumSize(new Dimension(167, 20));
		dateRecruttementChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateRecruttementChooser.setBackground(Color.WHITE);
		dureeContratField = new JTextField(20);
		tacheFonctionnelleField = new JTextField(20);
		
		framePanel = new JPanel();
		framePanel.setLayout(new MigLayout());  framePanel.setBackground(Color.WHITE);
		framePanel.setBorder(new TitledBorder(null, "Contrat travail", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		
		
		panel1 = new JPanel(new MigLayout()); panel1.setBackground(Color.WHITE);
		panel2 = new JPanel(new MigLayout()); panel2.setBackground(Color.WHITE);
		panel3 = new JPanel(new MigLayout());panel3.setBackground(Color.WHITE);
		panel3.setMinimumSize(new Dimension(10, 20));
		
		panel4 = new JPanel(new MigLayout());panel4 = new JPanel(new MigLayout());
		panel4.setBackground(Color.WHITE);
		panel4.setMinimumSize(new Dimension(10, 20));
		
		panel5 = new JPanel(new MigLayout());panel5 = new JPanel(new MigLayout());
		panel5.setBackground(Color.WHITE);
		panel5.setMinimumSize(new Dimension(10, 20));
		
		panelRadio = new JPanel(new MigLayout()); panelRadio.setBackground(Color.WHITE);
		panelRadio.setLayout(new GridLayout(1, 2));
		
    	validercontratButton = new JButton("Valider");
    	validercontratButton.setToolTipText("Valider le nouveau contrat");
    	validercontratButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
    	//validercontratButton.setMinimumSize(new Dimension(15, 20));
    	
   // 	validercontratButton.setDefaultCapable(false);
    	
    //	validercontratButton.setContentAreaFilled(false);
		
		
		
		
	}
}
