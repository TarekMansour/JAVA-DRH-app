package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 

public class AttestationTravail extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel mypanel;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel professionLabel;
	private JDateChooser dateAtes;
	private JLabel dateAtesLabel;
	private JLabel dateEmbaucheLabel;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField professionField;
	private JDateChooser dateembauche;
	private JButton imprimerButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttestationTravail frame = new AttestationTravail();
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
	public AttestationTravail() {
		super("attestation de travail");
		init();
		getContentPane().setBounds(new Rectangle(10, 0, 1230, 543));
		//init();
		//setBounds(new Rectangle(0, 106, 1252, 578));
		setFrameIcon(new ImageIcon(GestionPersonnel.class.getResource("/Ressources/student.png")));
		setForeground(Color.GRAY);
		setFont(new Font("Arial", Font.BOLD, 14));
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		getContentPane().setBackground(Color.WHITE);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new MigLayout());
		contentPane.add(mypanel);
		setContentPane(contentPane);
		
		mypanel.add(nomLabel); mypanel.add(nomField, "wrap");
		mypanel.add(prenomLabel); mypanel.add(prenomField, "wrap");
		mypanel.add(professionLabel); mypanel.add(professionField, "wrap");
		mypanel.add(dateAtesLabel); mypanel.add(dateAtes, "wrap");
		mypanel.add(dateEmbaucheLabel); mypanel.add(dateembauche, "wrap");
		mypanel.add(imprimerButton, "cell 1 5,gapx 83");
		pack();
		setClosable(true);
		
		//ecouteurs
		imprimerButton.addActionListener(this);
	}
	
	public void init()
	{
		mypanel = new JPanel(new MigLayout());
		mypanel.setBorder(new TitledBorder(null, "Attestation de travail", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		mypanel.setBackground(Color.WHITE);
		
		nomLabel = new JLabel("Nom :");
		prenomLabel = new JLabel("Prénom :");
		professionLabel = new JLabel("Profession :");
		dateAtesLabel = new JLabel("Date attestation :");
		dateEmbaucheLabel = new JLabel("Date embauche :");
	 
		nomField = new JTextField(20);
		prenomField = new JTextField(20);
		professionField = new JTextField(20);
		dateAtes = new JDateChooser();
		dateAtes.setDateFormatString("dd-MM-yyyy");
		dateAtes.setMinimumSize(new Dimension(167, 20));
		dateAtes.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateAtes.setBackground(Color.WHITE);
		dateembauche = new JDateChooser();
		dateembauche.setDateFormatString("dd-MM-yyyy");
		dateembauche.setMinimumSize(new Dimension(167, 20));
		dateembauche.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateembauche.setBackground(Color.WHITE);
		
		imprimerButton = new JButton("Imprimer");
		imprimerButton.setToolTipText("Imprimer attestation");
		imprimerButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == imprimerButton)
		{
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			try {
				PdfWriter.getInstance(document, new FileOutputStream("E:/Travail/mini projet java swing/PdfFolder/attestationTravail.pdf"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			document.open();
			try {
				//doc.add(new Paragraph(nomField.getText().toString()));
				
				Paragraph title1 = new Paragraph("                            Attestation de travail"
												, FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, new CMYKColor(0, 255, 255,17) ));				    
				Chapter chapter1 = new Chapter(title1,1);  
				chapter1.setNumberDepth(0);
				Paragraph title11 = new Paragraph("\nNous soussigné societé Bad Boys developers Services Informatique regional, 5000 Monastir, Tunisie.");			    
				Section section1 = chapter1.addSection(title11);
				Paragraph someSectionText = new Paragraph("\nCertifions que Monsieur(Mme) "+nomField.getText().toString()+" "+prenomField.getText().toString()
														 +" est employé(e) chez nous en qualité d'un(e): "+professionField.getText().toString()
														 +"recruté depuis "+dateembauche.getDate().toLocaleString());			 
				section1.add(someSectionText);
				someSectionText = new Paragraph("\nEn fois de quoi, nous lui délivrons cette présente attestation pour servir et valoir ce que de droit. ");
				section1.add(someSectionText);
				someSectionText = new Paragraph("\n                               La DIRECTION :  "+dateAtes.getDate().toLocaleString());
				section1.add(someSectionText);
				
				document.add(chapter1);
				
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			document.close();
			JOptionPane.showMessageDialog(null, "Votre attestation de travail crée avec succès");
		}
		
	}

}
