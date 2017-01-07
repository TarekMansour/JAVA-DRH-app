package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
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

public class DepartementFrame extends JFrame {

	private JPanel contentPane;
	private JLabel matriculLabel;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel cinLabel;
	private JLabel typePresonnelLabel;
	private JLabel dateAffectationLabel;
	private JLabel departementLabel;
	private JLabel serviceLabel;
	private JTextField matriculeField;
	private JTextField nomField;
	private JRadioButton agentRadioButton;
	private JRadioButton employeeRadioButton;
	private JTextField prenomField;
	private JTextField cinField;
	private JDateChooser dateAffectationChooser;
	private JComboBox departementCombo;
	private JTextField serviceField;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JButton validerAffectationButton;
	private JPanel panelDepartement;
	private JPanel panelRadio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartementFrame frame = new DepartementFrame();
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
	public DepartementFrame() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(new MigLayout());
		setContentPane(contentPane);
		contentPane.add(panelDepartement, "dock center");
		
		panel1.add(matriculLabel); panel1.add(matriculeField, "gapx 55,wrap");
		panel1.add(nomLabel); panel1.add(nomField, "gapx 55,wrap");
		panel1.add(prenomLabel); panel1.add(prenomField, "gapx 55,wrap");
		panel1.add(cinLabel); panel1.add(cinField, "gapx 55,wrap");
		
		panelRadio.add(agentRadioButton); panelRadio.add(employeeRadioButton);
		panel2.add(typePresonnelLabel); panel2.add(panelRadio, "gapx 50,wrap");
		panel2.add(dateAffectationLabel); panel2.add(dateAffectationChooser, "gapx 55,wrap");
		panel2.add(departementLabel); panel2.add(departementCombo, "gapx 55,wrap");
		panel2.add(serviceLabel); panel2.add(serviceField, "gapx 55,wrap");
		
		panelDepartement.add(panel3,"wrap");
		panelDepartement.add(panel1);
		panelDepartement.add(panel2, "gapx 60,wrap");
		panelDepartement.add(panel4, "wrap");
		panelDepartement.add(validerAffectationButton, "cell 1 2,gapx 307");
		
		pack();
	}
	
	public void init()
	{
		matriculLabel = new JLabel("Matricule :");
		nomLabel = new JLabel("Nom :");
		prenomLabel = new JLabel("Prénom :");
		cinLabel = new JLabel("CIN :");
		typePresonnelLabel = new JLabel("Type personnel :");
		dateAffectationLabel = new JLabel("Date affectation :");
		departementLabel = new JLabel("Département :");
		serviceLabel = new JLabel("Service :");
		
		matriculeField = new JTextField(20);
		nomField = new JTextField(20);
		prenomField = new JTextField(20);
		cinField = new JTextField(20);
		agentRadioButton = new JRadioButton("Agent administratif"); agentRadioButton.setBackground(Color.WHITE);
		employeeRadioButton = new JRadioButton("Employée"); employeeRadioButton.setBackground(Color.WHITE);
		ButtonGroup bg2 = new ButtonGroup(); agentRadioButton.setBackground(Color.WHITE);
		bg2.add(agentRadioButton);
		bg2.add(employeeRadioButton);
		
		dateAffectationChooser = new JDateChooser();
		dateAffectationChooser.setDateFormatString("dd-MM-yyyy");
		dateAffectationChooser.setMinimumSize(new Dimension(167, 20));
		dateAffectationChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateAffectationChooser.setBackground(Color.WHITE);
		departementCombo = new JComboBox<>();
		departementCombo.setBackground(Color.WHITE);
		departementCombo.setMinimumSize(new Dimension(165, 20));
		serviceField = new JTextField(20);
		
		panelDepartement = new JPanel(new MigLayout()); panelDepartement.setBackground(Color.WHITE);
		panelDepartement.setBorder(new TitledBorder(null, "Département ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		
		panelRadio = new JPanel(); panelRadio.setBackground(Color.WHITE);
		panelRadio.setLayout(new GridLayout(1, 2));
		panel1 = new JPanel(new MigLayout()); panel1.setBackground(Color.WHITE);
		panel2 = new JPanel(new MigLayout()); panel2.setBackground(Color.WHITE);
		panel3 = new JPanel(new MigLayout()); panel3.setBackground(Color.WHITE);panel3.setMinimumSize(new Dimension(10, 20));
		panel4 = new JPanel(new MigLayout()); panel4.setBackground(Color.WHITE);panel4.setMinimumSize(new Dimension(10, 20));
		
		validerAffectationButton = new JButton("Valider");
		validerAffectationButton.setToolTipText("Valider affectation");
		validerAffectationButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
		
	}

}
