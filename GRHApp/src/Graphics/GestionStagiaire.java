package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Graphics.DossierStagiaireFrame;

public class GestionStagiaire extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionStagiaire frame = new GestionStagiaire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel panelGlobale;
	private JTabbedPane tabbedPaneGlobale;

	/**
	 * Create the frame.
	 */
	public GestionStagiaire() {
		super ("Gestion des stagiaires");
		setMinimumSize(new Dimension(10, 10));
		setMaximumSize(new Dimension(32767, 32767));
		setBounds(new Rectangle(0, 106, 1252, 578));
		setFrameIcon(new ImageIcon(GestionPersonnel.class.getResource("/Ressources/student.png")));
		setForeground(Color.GRAY);
		setFont(new Font("Arial", Font.BOLD, 14));
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		getContentPane().setBackground(Color.WHITE);
		//setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		//this.setBounds(0,106,1252,578);
		panelGlobale = new JPanel();
		panelGlobale.setFont(new Font("Arial", Font.BOLD, 16));
		//panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Recrutement et suivi", TitledBorder.LEADING,  TitledBorder.TOP, null, Color.BLACK));
		panelGlobale.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Stage Manager", TitledBorder.LEADING, TitledBorder.TOP, (new Font("Calibri", Font.LAYOUT_LEFT_TO_RIGHT, 18))));
	
		//panel.setBorder(BorderFactory.createTitledBorder("Box Title"));
		panelGlobale.setForeground(Color.red);
		panelGlobale.setBackground(Color.WHITE);
		panelGlobale.setBounds(10, 0, 1230, 543);
		getContentPane().add(panelGlobale);
		
		JLabel lab = new JLabel();
        lab.setPreferredSize(new Dimension(200, 30));
		panelGlobale.setLayout(new BorderLayout(0, 0));
		
		tabbedPaneGlobale = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneGlobale.setOpaque(true);
		tabbedPaneGlobale.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneGlobale.setForeground(new Color(0, 0, 0));
		tabbedPaneGlobale.setBackground(new Color(255, 255, 255));
		tabbedPaneGlobale.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tabbedPaneGlobale.setFont(new Font("Arial", Font.BOLD, 12));
		tabbedPaneGlobale.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		tabbedPaneGlobale.setOpaque(false);
		tabbedPaneGlobale.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane(tabbedPaneGlobale,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 
		//tabbedPaneGlobale.
		panelGlobale.add(scrollPane);
		tabbedPaneGlobale.addTab("Dossier stagiaire", null, new DossierStagiaireFrame().getContentPane(), null);
		tabbedPaneGlobale.addTab("Départ stagiaire", null, new DepartStagiaire().getContentPane(), null);
		tabbedPaneGlobale.addTab("Historiques", null, new HistoriqueStagiaireFrame().getContentPane(), null);
		
		setClosable(true);
		pack();

	}

}
