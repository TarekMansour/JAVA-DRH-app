package Graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class Historique extends JFrame {

	private JPanel contentPane;
	private JPanel historiqueContratPanel;
	private JPanel historiqueDepartPanel;
	private JPanel show1Panel;
	private JPanel contenu1Panel;
	private JPanel show2Panel;
	private JPanel contenu2Panel;
	private JButton show1Button;
	private JButton historiquecontratLabel;
	private JLabel show1;
	private JLabel show2;
	private JButton historiqueDepartLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historique frame = new Historique();
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
	public Historique() {
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new MigLayout());
		setContentPane(contentPane);
		contentPane.add(historiqueContratPanel, "gapx 130");
		contentPane.add(historiqueDepartPanel);
		
		show1Panel.add(show1); show1Panel.add(historiquecontratLabel);
		historiqueContratPanel.add(show1Panel, "dock north");
		historiqueContratPanel.add(contenu1Panel, "dock center");
		
		show2Panel.add(show2); show2Panel.add(historiqueDepartLabel);
		historiqueDepartPanel.add(show2Panel, "dock north");
		historiqueDepartPanel.add(contenu2Panel, "dock center");
		pack();
	}
	
	public void init()
	{
		historiqueContratPanel = new JPanel(new MigLayout());
		historiqueContratPanel.setBackground(Color.WHITE);
		show1Panel = new JPanel(new MigLayout());
		show1Panel.setBackground(Color.WHITE);
		contenu1Panel = new JPanel(new MigLayout());
		show1 = new JLabel("", new ImageIcon(Historique.class.getResource("/Ressources/Tunisia2.png")), SwingConstants.CENTER);
		historiquecontratLabel = new JButton("Historique contrat");
		historiquecontratLabel.setContentAreaFilled(false);
		//historiquecontratLabel.setFocusPainted(false);
		
		
		historiqueDepartPanel = new JPanel(new MigLayout());
		historiqueDepartPanel.setBackground(Color.WHITE);
		show2Panel = new JPanel(new MigLayout());
		show2Panel.setBackground(Color.WHITE);
		contenu2Panel = new JPanel(new MigLayout());
		show2 = new JLabel("", new ImageIcon(Historique.class.getResource("/Ressources/Tunisia2.png")), SwingConstants.CENTER);
		historiqueDepartLabel = new JButton("Historique départ");
		historiqueDepartLabel.setContentAreaFilled(false);
		//historiqueDepartLabel.setFocusPainted(false);
	}
}
