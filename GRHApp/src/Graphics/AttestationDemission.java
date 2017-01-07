package Graphics;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

public class AttestationDemission extends JInternalFrame  implements ActionListener{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttestationDemission frame = new AttestationDemission();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JPanel mypanel;
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel professionLabel;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField professionField;
	private JLabel dateAtesLabel;
	private JDateChooser dateAtes;
	private JTextField anneeDebutContraField;
	private JLabel anneeDebutContraLabel;
	private JLabel dateDeaprtLabel;
	private JDateChooser dateDeaprt;
	private JButton imprimerButton;
	private JLabel raisonLabel;
	private JTextField raisonfield;

	/**
	 * Create the frame.
	 */
	public AttestationDemission() {
		super("attestation de démission");
		init();
		getContentPane().setBounds(new Rectangle(10, 0, 1230, 543));
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
		mypanel.add(anneeDebutContraLabel); mypanel.add(anneeDebutContraField, "wrap");
		mypanel.add(dateAtesLabel); mypanel.add(dateAtes, "wrap");
		mypanel.add(dateDeaprtLabel); mypanel.add(dateDeaprt, "wrap");
		mypanel.add(raisonLabel); mypanel.add(raisonfield, "wrap");
		mypanel.add(imprimerButton, "cell 1 7,gapx 83");
		pack();
		setClosable(true);
		
		//ecouteurs
		imprimerButton.addActionListener(this);

	}
	
	public void init()
	{
		mypanel = new JPanel(new MigLayout());
		mypanel.setBorder(new TitledBorder(null, "Attestation de Démission", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		mypanel.setBackground(Color.WHITE);
		
		nomLabel = new JLabel("Nom :");
		prenomLabel = new JLabel("Prénom :");
		professionLabel = new JLabel("Profession :");
		anneeDebutContraLabel = new JLabel("Année début contrat :");
		dateAtesLabel = new JLabel("Date attestation :");
		dateDeaprtLabel = new JLabel("Date départ :");
		raisonLabel = new JLabel("Raison démission :");
	 
		nomField = new JTextField(20);
		prenomField = new JTextField(20);
		professionField = new JTextField(20);
		anneeDebutContraField = new JTextField(20);
		dateAtes = new JDateChooser();
		dateAtes.setDateFormatString("dd-MM-yyyy");
		dateAtes.setMinimumSize(new Dimension(167, 20));
		dateAtes.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateAtes.setBackground(Color.WHITE);
		dateDeaprt = new JDateChooser();
		dateDeaprt.setDateFormatString("dd-MM-yyyy");
		dateDeaprt.setMinimumSize(new Dimension(167, 20));
		dateDeaprt.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		dateDeaprt.setBackground(Color.WHITE);
		raisonfield = new JTextField(20);
		
		imprimerButton = new JButton("Imprimer");
		imprimerButton.setToolTipText("Imprimer attestation");
		imprimerButton.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == imprimerButton)
		{
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			try {
				PdfWriter.getInstance(document, new FileOutputStream("E:/Travail/mini projet java swing/PdfFolder/attestationDémission.pdf"));
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
				
				Paragraph title1 = new Paragraph("                            Attestation de démission"
												, FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, new CMYKColor(0, 255, 255,17) ));				    
				Chapter chapter1 = new Chapter(title1,1);  
				chapter1.setNumberDepth(0);
				Paragraph title11 = new Paragraph("\nMadame, Monsieur,");			    
				Section section1 = chapter1.addSection(title11);
				Paragraph someSectionText = new Paragraph("je vous informe moi "+nomField.getText().toString()+" "+prenomField.getText().toString() + " par la présente de ma décision de démissionner du poste de"
						+professionField.getText().toString() +" que j’occupe dans votre entreprise depuis "+anneeDebutContraField.getText().toString());			 
				section1.add(someSectionText);
				someSectionText = new Paragraph("\nje vous remercie de bien vouloir me dispenser du préavis de mon poste actuelle afin que mon départ devienne effectif le "
						+dateDeaprt.getDate().toLocaleString());
				section1.add(someSectionText);
				
				someSectionText = new Paragraph("\nJe vous saurais gré également de bien vouloir tenir à ma disposition le solde de mon compte, mon certificat de travail ainsi que mon attestation Pôle emploi.\n");
				section1.add(someSectionText);
				someSectionText = new Paragraph("\nAvec mes remerciements, je vous prie de bien vouloir agréer, (Madame, Monsieur), l’expression de mes salutations distinguées.\n");
				section1.add(someSectionText);
				someSectionText = new Paragraph("                               La DIRECTION :  "+dateAtes.getDate().toLocaleString());
				section1.add(someSectionText);
				
				document.add(chapter1);
				
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			document.close();
			JOptionPane.showMessageDialog(null, "Votre attestation de démission crée avec succès");
		}
	}

}
