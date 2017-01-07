package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class GestionAttestation extends JInternalFrame implements ActionListener {
	private JPanel panelGlobale;
	private JPanel buttonsPanel;
	private JPanel showPanel;
	private JButton attestationTravailButton;
	private JButton attestationDemissionButton;
	private JButton attestationStageButton;
	private JButton attestationSalaireButton;
	private JButton attestationaccButton;
	private JPanel mypanel;
	private JInternalFrame xpanel;
	private JDesktopPane dp;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAttestation frame = new GestionAttestation();
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
	public GestionAttestation() {
		super ("Gestion des attestation");
		getContentPane().setBounds(new Rectangle(10, 0, 1230, 543));
		init();
		//setBounds(new Rectangle(0, 106, 1252, 578));
		setFrameIcon(new ImageIcon(GestionPersonnel.class.getResource("/Ressources/student.png")));
		setForeground(Color.GRAY);
		setFont(new Font("Arial", Font.BOLD, 14));
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new MigLayout());
		
		
		panelGlobale = new JPanel();
		//panelGlobale.setBounds(new Rectangle(10, 0, 1230, 543));
		panelGlobale.setLayout(new MigLayout());
		//panelGlobale.setFont(new Font("Arial", Font.BOLD, 16));
		panelGlobale.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Liste des attestations", TitledBorder.LEADING, TitledBorder.TOP, (new Font("Calibri", Font.LAYOUT_LEFT_TO_RIGHT, 18))));
	
		panelGlobale.setBackground(Color.WHITE);
		//panelGlobale.setBounds(10, 0, 1230, 543);
		getContentPane().add(panelGlobale);
		buttonsPanel.add(attestationTravailButton, "wrap");
		buttonsPanel.add(attestationDemissionButton, "wrap");
		buttonsPanel.add(attestationStageButton, "wrap");
		buttonsPanel.add(attestationSalaireButton, "wrap");
		buttonsPanel.add(attestationaccButton, "wrap");
		
		showPanel.add(dp);
		
		panelGlobale.add(buttonsPanel,"dock west");
		panelGlobale.add(showPanel,"east,gapx 25");
			
		//setClosable(true);	
		
		attestationTravailButton.addActionListener(this);
		attestationDemissionButton.addActionListener(this);
		setClosable(true);
		pack();
		}
	
	public void init()
	{
		buttonsPanel = new JPanel(new MigLayout());buttonsPanel.setBackground(Color.WHITE);
		showPanel = new JPanel(new MigLayout());
		showPanel.setBackground(Color.WHITE);
		//showPanel.setMinimumSize(new Dimension(500, 300));
		
		/*xpanel = new JInternalFrame();
		xpanel.setMinimumSize(new Dimension(500, 30));*/
		
		dp = new JDesktopPane();
		
		attestationTravailButton=new JButton("Attestation de travail", new ImageIcon(GestionAttestation.class.getResource("/Ressources/doc1.png")));
		attestationTravailButton.setContentAreaFilled(false);
		
		attestationDemissionButton=new JButton("Attestation de démission", new ImageIcon(GestionAttestation.class.getResource("/Ressources/doc2.png")));
		attestationDemissionButton.setContentAreaFilled(false);
		
		attestationStageButton=new JButton("Attestation de stage", new ImageIcon(GestionAttestation.class.getResource("/Ressources/doc3.png")));
		attestationStageButton.setContentAreaFilled(false);
		
		attestationSalaireButton=new JButton("Attestation de salaire", new ImageIcon(GestionAttestation.class.getResource("/Ressources/doc4.png")));
		attestationSalaireButton.setContentAreaFilled(false);
		
		attestationaccButton=new JButton("Attestation d'accident travail", new ImageIcon(GestionAttestation.class.getResource("/Ressources/doc5.png")));
		attestationaccButton.setContentAreaFilled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == attestationTravailButton)
		{
			AttestationTravail gs = new AttestationTravail();
			showPanel.add(gs);
			gs.setVisible(true);
			
		}
		
		if(e.getSource() == attestationDemissionButton)
		{
			AttestationDemission gs = new AttestationDemission();
			showPanel.add(gs);
			gs.setVisible(true);
			
		}
		
	}
}
