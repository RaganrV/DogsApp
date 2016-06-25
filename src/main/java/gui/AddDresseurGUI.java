package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import entities.Dresseur;
import entities.Veterinaire;
import esprit.tn.businessDeleguate.ManageDresseurDeleguate;
import esprit.tn.businessDeleguate.ManageVeterinaireDeleguate;
import gui.panels.ImagePanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.panels.MenuPanel;

public class AddDresseurGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textAdresse;
	private JTextField textMobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDresseurGUI frame = new AddDresseurGUI();
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
	public AddDresseurGUI() {
		setMinimumSize(new Dimension(800, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(68, 260, 46, 14);
		contentPane.add(lblNewLabel);
		
		textNom = new JTextField();
		textNom.setBounds(214, 252, 390, 30);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(68, 296, 62, 17);
		contentPane.add(lblNewLabel_1);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(214, 289, 390, 30);
		contentPane.add(textPrenom);
		textPrenom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Adresse");
		lblNewLabel_2.setBounds(68, 329, 96, 28);
		contentPane.add(lblNewLabel_2);
		
		textAdresse = new JTextField();
		textAdresse.setBounds(214, 329, 390, 30);
		contentPane.add(textAdresse);
		textAdresse.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile");
		lblNewLabel_3.setBounds(68, 370, 96, 21);
		contentPane.add(lblNewLabel_3);
		
		textMobile = new JTextField();
		textMobile.setBounds(214, 370, 390, 30);
		contentPane.add(textMobile);
		textMobile.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(214, 411, 390, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"- - Autre - -", "Dressage de base", "Formation des chiens de police", "Recherche et de dressage de chiens de sauvetage", "Formation Dog Show", "Physique de dressage de chiens d'assistance"}));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Specialite");
		lblNewLabel_4.setBounds(68, 414, 134, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton buttonAddDresseur = new JButton("Ajouter Dresseur");
		buttonAddDresseur.setBounds(289, 479, 155, 47);
		buttonAddDresseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JPanel panel = new JPanel();
				Dresseur dresseur= new Dresseur();
				dresseur.setNom(textNom.getText());
				dresseur.setPrenom(textPrenom.getText());
				dresseur.setAdresse(textAdresse.getText());
				dresseur.setMobile(textMobile.getText());
				dresseur.setSpecialite(comboBox.getSelectedItem().toString());
				if((textNom.getText().length()==0)||(textPrenom.getText().length()==0)||(textMobile.getText().length()==0)||(textAdresse.getText().length()==0)){
					 JOptionPane.showMessageDialog(panel, "Obligatory Field Empty", "Error", JOptionPane.ERROR_MESSAGE);
				}	
				else{
				ManageDresseurDeleguate.getInstance().addDresseur(dresseur);
				//AddAgencyGui.this.hide();
				//new ManageAgencyGui().setVisible(true);
				}
			}
		});
		contentPane.add(buttonAddDresseur);
		
		ImagePanel imagePanel = new ImagePanel();
		imagePanel.setBounds(0, 0, -1, -1);
		
		imagePanel.setImage(new ImageIcon("src//main//resources//images//fond1.jpg").getImage());
		imagePanel.setMinimumSize(new Dimension(800, 600));
		contentPane.add(imagePanel);
		imagePanel.setLayout(null);
		
		MenuPanel menuPanel = new MenuPanel((JFrame) null);
		menuPanel.setBounds(0, 0, 794, 36);
		contentPane.add(menuPanel);
	}
}
