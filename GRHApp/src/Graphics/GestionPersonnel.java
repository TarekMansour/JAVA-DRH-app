package Graphics;
import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.BorderLayout;

import Graphics.ListePersonnelFrame;
import Graphics.DossierPersonnelFrame;
import Graphics.ContratTravailFrame;
import Graphics.DepartementFrame;
import Graphics.DepartPersonnelFrame;
import Graphics.Historique;

public class GestionPersonnel extends JInternalFrame  implements ChangeListener{
	JPanel panelGlobale;
	JTabbedPane tabbedPaneGlobale;
	JPanel listePersonnelPanel;
	JPanel dossierPersonnelPanel;
	
	//Main
    public static void main (String [] args){
		GestionPersonnel g1 = new GestionPersonnel();
	}
    /**
	 * Create the frame.
	 */
	public GestionPersonnel() {
		super ("Gestion de personnel");
		setMinimumSize(new Dimension(10, 10));
		setMaximumSize(new Dimension(32767, 32767));
		setBounds(new Rectangle(0, 106, 1252, 578));
		setFrameIcon(new ImageIcon(GestionPersonnel.class.getResource("/Ressources/GP1.png")));
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
		panelGlobale.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Recrutement et suivi", TitledBorder.LEADING, TitledBorder.TOP, (new Font("Calibri", Font.LAYOUT_LEFT_TO_RIGHT, 18))));
	
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
		tabbedPaneGlobale.addTab("Liste personnel", null, new ListePersonnelFrame().getContentPane(), null);
		tabbedPaneGlobale.addTab("Dossier personnel", null, new DossierPersonnelFrame().getContentPane(), null);
		tabbedPaneGlobale.addTab("Contrat travail", null, new ContratTravailFrame().getContentPane(), null);
		tabbedPaneGlobale.addTab("Affecter departement", null, new DepartementFrame().getContentPane(), null);
		tabbedPaneGlobale.addTab("Départ personnel", null, new DepartPersonnelFrame().getContentPane(), null);
		tabbedPaneGlobale.addTab("Historique", null, new Historique().getContentPane(), null);
		setClosable(true);
		pack();
		
		//ecouteur
		tabbedPaneGlobale.addChangeListener(this);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
		//tabbedPaneGlobale = (JTabbedPane) e.getSource();
		
       /* int selectedIndex = tabbedPaneGlobale.getSelectedIndex();
        JOptionPane.showMessageDialog(null, "Selected Index: " + selectedIndex);*/
        
		//tabbedPaneGlobale = (JTabbedPane) e.getSource();
        /*if (tabbedPaneGlobale.getSelectedIndex() == 1)
        {	
        	ListePersonnelFrame pl = new ListePersonnelFrame();
        	dossierPersonnelPanel.add(pl);
        	 JOptionPane.showMessageDialog(null, "Selectggggggggggggggggggg ");
        }*/
		
		
	}
}

