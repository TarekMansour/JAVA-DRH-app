package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.UIManager;

public class DepartPersonnelFrame extends JFrame {

	private JPanel contentPane;
	private JLabel idDepLabel;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel dateDepartLabel;
	private JLabel categDepLabel;
	private JLabel raisonDepLabel;
	private JLabel periodeTravailLabel;
	private JLabel fraisLabel;
	private JTextField idField;
	private JTextField nomField;
	private JTextField prenomField;
	private JDateChooser dateDepartChooser;
	private JComboBox categDepCombo;
	private JTextArea raisonDepField;
	private JTextField periodeTravailField;
	private JTextField fraisField;
	private JPanel panelDepart;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel22;
	private JButton validerDepartButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartPersonnelFrame frame = new DepartPersonnelFrame();
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
	public DepartPersonnelFrame() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new MigLayout());
		contentPane.add(panelDepart, "dock center");
		setContentPane(contentPane);
		
		panel1.add(idDepLabel); panel1.add(idField, "gapx 42,wrap");
		panel1.add(nomLabel); panel1.add(nomField, "gapx 42,wrap");
		panel1.add(prenomLabel); panel1.add(prenomField, "gapx 42,wrap");
		
		panel2.add(dateDepartLabel); panel2.add(dateDepartChooser, "gapx 42,wrap");
		panel2.add(categDepLabel); panel2.add(categDepCombo, "gapx 42,wrap");
		panel2.add(raisonDepLabel); panel2.add(raisonDepField,"gapx 42,wrap");
		
		panel3.add(periodeTravailLabel); panel3.add(periodeTravailField, "gapx 42,wrap");
		panel3.add(fraisLabel); panel3.add(fraisField, "gapx 42,wrap");
		
		panelDepart.add(panel1);
		panelDepart.add(panel2);
		panelDepart.add(panel3, "wrap");
		//panelDepart.add(panel4, "wrap");
		panelDepart.add(validerDepartButton, "cell 2 1,gapx 250,aligny top");
		pack();
	}
	
	public void init()
	{
		idDepLabel = new JLabel("Identifiant :");
		nomLabel = new JLabel("Nom :");
		prenomLabel = new JLabel("Prénom :");
		dateDepartLabel = new JLabel("Date départ :");
		categDepLabel = new JLabel("Catégorie départ :");
		raisonDepLabel = new JLabel("Raison départ :");
		periodeTravailLabel = new JLabel("Période travaillée :");
		fraisLabel = new JLabel("Frais professionnels :");
		
		idField = new JTextField(20);
		nomField = new JTextField(20);
		prenomField = new JTextField(20);
		dateDepartChooser = new JDateChooser();
		dateDepartChooser.setDateFormatString("dd-MM-yyyy");
		dateDepartChooser.setMinimumSize(new Dimension(167, 20));
		dateDepartChooser.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateDepartChooser.setBackground(Color.WHITE);
		categDepCombo = new JComboBox<>();
		categDepCombo.setBackground(Color.WHITE);
		categDepCombo.setMinimumSize(new Dimension(165, 20));
		raisonDepField = new JTextArea(2,20);
		raisonDepField.setToolTipText("TextArea pour d\u00E9crire le raison de d\u00E9part pour un personnel");
		raisonDepField.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		periodeTravailField = new JTextField(20);
		fraisField = new JTextField(20);
		
		panelDepart = new JPanel(new MigLayout()); panelDepart.setBackground(Color.WHITE);
		panelDepart.setBorder(new TitledBorder(null, "Départ personnel ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		
		panel1 = new JPanel(new MigLayout()); panel1.setBackground(Color.WHITE);
		panel2 = new JPanel(new MigLayout()); panel2.setBackground(Color.WHITE);
		panel22 = new JPanel(new MigLayout()); panel22.setBackground(Color.WHITE);
		panel3 = new JPanel(new MigLayout()); panel3.setBackground(Color.WHITE);panel3.setMinimumSize(new Dimension(10, 20));
		panel4 = new JPanel(new MigLayout()); panel4.setBackground(Color.WHITE);panel4.setMinimumSize(new Dimension(10, 20));
		
		validerDepartButton = new JButton("Valider");
		validerDepartButton.setToolTipText("Valider le départ");
		validerDepartButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
		
	}

}
