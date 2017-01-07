package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;

public class AcceuilFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilFrame frame = new AcceuilFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel panelGlobale;
	private JLabel imageLabel;
	private JPanel panelsecondaire;

	/**
	 * Create the frame.
	 */
	public AcceuilFrame() {
		super ("Acceuil");
		getContentPane().setBackground(Color.WHITE);
		imageLabel= new JLabel("", new ImageIcon(AcceuilFrame.class.getResource("/Ressources/DRHapp1.jpg")),SwingConstants.CENTER);
		imageLabel.setPreferredSize(new Dimension(1230, 540));
		imageLabel.setMinimumSize(new Dimension(950, 600));
		imageLabel.setMaximumSize(new Dimension(1000, 1000));
		panelGlobale = new JPanel(); 
		panelGlobale.setBackground(Color.WHITE);panelGlobale.setLayout(new FlowLayout());
		panelsecondaire = new JPanel(); 
		panelsecondaire.setBackground(Color.WHITE);
		
		panelGlobale.add(imageLabel);
		JLabel label = new JLabel("DRH");
		label.setFont(new Font("Consolas", Font.PLAIN, 16));
		panelsecondaire.add(label);
		
		getContentPane().setLayout(new BorderLayout());
		//getContentPane().add("West", panelsecondaire);
		getContentPane().add("Center",panelGlobale);
		setMinimumSize(new Dimension(10, 10));
		setMaximumSize(new Dimension(32767, 32767));
		setBounds(new Rectangle(0, 106, 1252, 578));
		setClosable(true);

	}
}
