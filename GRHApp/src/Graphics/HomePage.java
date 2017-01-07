package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import Graphics.GestionPersonnel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import java.awt.SystemColor;
import java.awt.Point;
import javax.swing.border.MatteBorder;

public class HomePage implements ActionListener{
	private JFrame frame;
	
	private JButton homeButton;
	private JButton persButton;
	private JButton stgButton;
	private JButton attesButton;
	private JButton statButton;
	private JButton settingButton;
	private JButton contactButton;
	private JButton searchButton;
	
	private JLabel logoLabel;
	private JLabel englishLabel;
	private JLabel frenshLabel;
	private JLabel helpLabel;
	
	private JTextField searchField;
	
	//desktoppane
	private JDesktopPane dp;
	JPanel panelCenterRest;

	private JScrollPane jsp;
	
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.white));
        //UIManager.put("ComboBox.selectionForeground", new ColorUIResource(Color.black));
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.black ));
		UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.WHITE));
		UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.PLAIN, 11));
		
		
	}
	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
		//Button section
		//home button
		homeButton.setHorizontalTextPosition(JLabel.CENTER);
		homeButton.setVerticalTextPosition(JLabel.BOTTOM);
		homeButton.setForeground(new Color(255, 255, 255));
		//personnel button
		persButton.setHorizontalTextPosition(JLabel.CENTER);
		persButton.setVerticalTextPosition(JLabel.BOTTOM);
		persButton.setForeground(new Color(255, 255, 255));
		
		//stagiaire button
		stgButton.setHorizontalTextPosition(JLabel.CENTER);
		stgButton.setVerticalTextPosition(JLabel.BOTTOM);
		stgButton.setForeground(new Color(255, 255, 255));
		
		//attestation button
		attesButton.setHorizontalTextPosition(JLabel.CENTER);
		attesButton.setVerticalTextPosition(JLabel.BOTTOM);
		attesButton.setForeground(new Color(255, 255, 255));
		
		//statistiques button
		statButton.setHorizontalTextPosition(JLabel.CENTER);
		statButton.setVerticalTextPosition(JLabel.BOTTOM);
		statButton.setForeground(new Color(255, 255, 255));
		
		//settings button
		settingButton.setHorizontalTextPosition(JLabel.CENTER);
		settingButton.setVerticalTextPosition(JLabel.BOTTOM);
		settingButton.setForeground(new Color(255, 255, 255));
		
		//contact button
		contactButton.setHorizontalTextPosition(JLabel.CENTER);
		contactButton.setVerticalTextPosition(JLabel.BOTTOM);
		contactButton.setForeground(new Color(255, 255, 255));
		//logo DRH
		logoLabel.setHorizontalTextPosition(JLabel.CENTER);
		logoLabel.setVerticalTextPosition(JLabel.BOTTOM);
		logoLabel.setForeground(new Color(255, 255, 255));
		
		//toolBar labels
		englishLabel.setHorizontalAlignment(JLabel.RIGHT);
		englishLabel.setVerticalTextPosition(JLabel.CENTER);
		
		frenshLabel.setHorizontalAlignment(JLabel.RIGHT);
		frenshLabel.setVerticalTextPosition(JLabel.CENTER);

		helpLabel.setHorizontalAlignment(JLabel.RIGHT);
		helpLabel.setVerticalTextPosition(JLabel.CENTER);
		
		//searchButton.setHorizontalTextPosition(JLabel.CENTER);
		//searchButton.setVerticalTextPosition(JLabel.RIGHT);
		
		
		//Panel section
		//panelWest
		JPanel panelWest=new JPanel();
		panelWest.setBackground(Color.DARK_GRAY);
		panelWest.setPreferredSize(new Dimension(100,600));
		panelWest.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel GRHLabel=new JLabel("DRH Application");
		GRHLabel.setForeground(Color.WHITE);
		GRHLabel.setFont(new Font("Times New Roman", Font.BOLD, 10));
		JLabel DashboardLabel=new JLabel("Dashboard");
		DashboardLabel.setForeground(Color.WHITE);
		DashboardLabel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		//top.setPreferredSize(new Dimension(60,50));
		panelWest.add(GRHLabel);
		panelWest.add(DashboardLabel);
		panelWest.add(homeButton);
		panelWest.add(persButton);
		panelWest.add(stgButton);
		panelWest.add(attesButton);
		panelWest.add(statButton);
		panelWest.add(settingButton);
		panelWest.add(contactButton);
		panelWest.add(logoLabel);
		
		//panelCenter
		JPanel panelCenter=new JPanel();
		panelCenter.setPreferredSize(new Dimension(900,150));
		panelCenter.setLayout(null);
		JPanel panelCenterCent=new JPanel();
		panelCenterCent.setBackground(Color.DARK_GRAY);
		panelCenterCent.setBounds(0,50,1252,57);
		
		//desktop
		dp = new JDesktopPane();
		
		panelCenterRest=new JPanel();
		panelCenterRest.setBorder(null);
		panelCenterRest.setLayout(new BorderLayout());
		panelCenterRest.setBackground(Color.white);
		panelCenterRest.setBounds(0,106,1252,578);
		
	//panelCenterRest.add(new AcceuilFrame());new AcceuilFrame().setVisible(true);
		panelCenterRest.add("East",dp);
		
		
		AcceuilFrame gp = new AcceuilFrame();
		panelCenterRest.add(gp);
		gp.setVisible(true);
		
		panelCenter.add(panelCenterCent);
		panelCenter.add(panelCenterRest);
		
				//frame.setContentPane(dp);
				frame.getContentPane();
				frame.getContentPane().add("Center",panelCenter);
				
				
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.menu);
				panel.setBounds(0, 685, 1252, 34);
				panelCenter.add(panel);
				
				JLabel lblNewLabel = new JLabel("Solution developed by");
				panel.add(lblNewLabel);
				
				JLabel lblTarekMansour = new JLabel("Tarek Mansour");
				lblTarekMansour.setForeground(SystemColor.textHighlight);
				panel.add(lblTarekMansour);
				
				JLabel lblNewLabel_1 = new JLabel("", new ImageIcon(HomePage.class.getResource("/Ressources/Tunisia2.png")), SwingConstants.CENTER);
				panel.add(lblNewLabel_1);
				
				JPanel searchPanel = new JPanel();
				searchPanel.setLayout(new FlowLayout());
				searchPanel.add(searchButton);
				searchPanel.add(searchField);
				
				JPanel toolBarPanel = new JPanel();
				toolBarPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
				toolBarPanel.setBounds(0, 0, 1252, 49);
				toolBarPanel.add(searchPanel);
				toolBarPanel.add(helpLabel);
				toolBarPanel.add(englishLabel);
				toolBarPanel.add(frenshLabel);
								
				panelCenter.add(toolBarPanel);
				frame.getContentPane().add("West",panelWest);
				
				
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//region VARIABLES
		//home button
		homeButton=new JButton("Accueil", new ImageIcon(getClass().getResource("/Ressources/home2.png")));
		homeButton.setToolTipText("Accueil g\u00E9n\u00E9rale");
		homeButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		homeButton.setContentAreaFilled(false);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);
		//endregion
		//personnel button
		persButton=new JButton("Personnel", new ImageIcon(HomePage.class.getResource("/Ressources/mypers.png")));
		persButton.setToolTipText("Gestion de personnels");
		persButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		persButton.setContentAreaFilled(false);
		persButton.setBorderPainted(false);
		persButton.setFocusPainted(false);
		
		//stagiaire button
		stgButton=new JButton("Stagiaire", new ImageIcon(HomePage.class.getResource("/Ressources/stagiaire.png")));
		stgButton.setToolTipText("Gestion de stagiaires");
		stgButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		stgButton.setContentAreaFilled(false);
		stgButton.setBorderPainted(false);
		stgButton.setFocusPainted(false);

		//stagiaire button
		attesButton=new JButton("Attestations", new ImageIcon(HomePage.class.getResource("/Ressources/attestation.png")));
		attesButton.setToolTipText("Gestion des Attestations");
		attesButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		attesButton.setContentAreaFilled(false);
		attesButton.setBorderPainted(false);
		attesButton.setFocusPainted(false);
		
		//statistiques button
		statButton=new JButton("Statistiques", new ImageIcon(HomePage.class.getResource("/Ressources/stat2.png")));
		statButton.setToolTipText("Statistiques");
		statButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		statButton.setContentAreaFilled(false);
		statButton.setBorderPainted(false);
		statButton.setFocusPainted(false);
		
		//settings button
		settingButton=new JButton("Paramètres", new ImageIcon(HomePage.class.getResource("/Ressources/settings.png")));
		settingButton.setToolTipText("Paramètres application");
		settingButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		settingButton.setContentAreaFilled(false);
		settingButton.setBorderPainted(false);
		settingButton.setFocusPainted(false);
				
		//contact button
		contactButton=new JButton("Contact", new ImageIcon(HomePage.class.getResource("/Ressources/contact.png")));
		contactButton.setToolTipText("Contact");
		contactButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contactButton.setContentAreaFilled(false);
		contactButton.setBorderPainted(false);
		contactButton.setFocusPainted(false);
		
		//logoLabel=new JLabel(new ImageIcon("/Ressources/contact.png"), SwingConstants.CENTER);
		logoLabel = new JLabel("", new ImageIcon(HomePage.class.getResource("/Ressources/DRHL.jpg")),SwingConstants.CENTER);
		
		//tool bar labels
		englishLabel = new JLabel("Anglais",SwingConstants.RIGHT);
		englishLabel.setToolTipText("Traduction en anglais");
		englishLabel.setPreferredSize(new Dimension(65, 38));
		englishLabel.setMinimumSize(new Dimension(40, 20));
		englishLabel.setMaximumSize(new Dimension(40, 20));
		englishLabel.setLocation(new Point(40, 60));
		englishLabel.setForeground(new Color(51, 153, 255));
		englishLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		frenshLabel = new JLabel("Français",SwingConstants.RIGHT);
		frenshLabel.setToolTipText("Traduction en fran\u00E7ais");
		frenshLabel.setPreferredSize(new Dimension(65, 38));
		frenshLabel.setMinimumSize(new Dimension(40, 20));
		frenshLabel.setMaximumSize(new Dimension(40, 20));
		frenshLabel.setLocation(new Point(40, 60));
		frenshLabel.setForeground(new Color(51, 153, 255));
		frenshLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		helpLabel= new JLabel("", new ImageIcon(HomePage.class.getResource("/Ressources/help4.png")),SwingConstants.CENTER);
		helpLabel.setToolTipText("help");
		helpLabel.setPreferredSize(new Dimension(60, 24));
		searchField = new JTextField();
		searchField.setFont(new Font("Arial", Font.PLAIN, 12));
		searchField.setToolTipText("");
		searchField.setPreferredSize(new Dimension(120, 28));
		
		searchButton=new JButton(new ImageIcon(HomePage.class.getResource("/Ressources/search3.png")));
		searchButton.setPreferredSize(new Dimension(25, 28));
		searchButton.setToolTipText("rechercher");
		searchButton.setContentAreaFilled(false);
		//searchButton.setBorderPainted(false);
		searchButton.setFocusPainted(false);
		
		frame = new JFrame("Direction Ressources Humaines");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		//Les écouteurs
		homeButton.addActionListener(this);
		persButton.addActionListener(this);
		stgButton.addActionListener(this);
		attesButton.addActionListener(this);
		statButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()== homeButton)
		{
			AcceuilFrame gp = new AcceuilFrame();
			panelCenterRest.add(gp);
			gp.setVisible(true);
		}
		
		if (e.getSource()== persButton)
		{
			panelCenterRest.removeAll();
			GestionPersonnel gp = new GestionPersonnel();
			panelCenterRest.add(gp);
			gp.setVisible(true);
		}
		if (e.getSource()== stgButton)
		{
			panelCenterRest.removeAll();
			GestionStagiaire gs = new GestionStagiaire();
			panelCenterRest.add(gs);
			gs.setVisible(true);
		}
		
		if (e.getSource()== attesButton)
		{
			GestionAttestation ats = new GestionAttestation();
			panelCenterRest.add(ats);
			ats.setVisible(true);
		}
		
		if (e.getSource()== statButton)
		{
			StatistiqueFrame ats = new StatistiqueFrame();
			panelCenterRest.add(ats);
			ats.setVisible(true);
		}
		
	
	}
	
}
