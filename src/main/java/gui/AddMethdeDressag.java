package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import entities.MethodeDressage;
import esprit.tn.businessDeleguate.ManageMethodeDressageDeleguate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMethdeDressag extends JFrame {

	private JPanel contentPane;
	private JTextField JtextTitre;
	private JTextField jtextRace;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMethdeDressag frame = new AddMethdeDressag();
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
	public AddMethdeDressag() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JtextTitre = new JTextField();
		JtextTitre.setBounds(94, 51, 86, 20);
		contentPane.add(JtextTitre);
		JtextTitre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(20, 122, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Race");
		lblNewLabel_1.setBounds(20, 173, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Titre");
		lblNewLabel_2.setBounds(20, 54, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		jtextRace = new JTextField();
		jtextRace.setBounds(94, 170, 86, 20);
		contentPane.add(jtextRace);
		jtextRace.setColumns(10);
		JTextArea jTextDescription = new JTextArea();
		jTextDescription.setText("Votre Methode de dressage (Description)");
		jTextDescription.setBounds(94, 96, 316, 63);
		contentPane.add(jTextDescription);
		
		JButton btnAddMethodeDressage = new JButton("Ajouter Methode Dressage");
		btnAddMethodeDressage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
			final JPanel panel = new JPanel();
			MethodeDressage dresseur= new MethodeDressage();
			dresseur.setTitreMethodeDressage(JtextTitre.getText());
			dresseur.setDescriptionMethodeDressage(jTextDescription.getText());
			dresseur.setRace(jtextRace.getText());
			
			
			if((JtextTitre.getText().length()==0)||(jTextDescription.getText().length()==0)||(jtextRace.getText().length()==0)){
				 JOptionPane.showMessageDialog(panel, "Obligatory Field Empty", "Error", JOptionPane.ERROR_MESSAGE);
			}	
			else{
			ManageMethodeDressageDeleguate.getInstance().addMethodeDressage(dresseur);
			//AddAgencyGui.this.hide();
			//new ManageAgencyGui().setVisible(true);
			}
		}
	});
		btnAddMethodeDressage.setBounds(132, 216, 218, 23);
		contentPane.add(btnAddMethodeDressage);
		
		
	}
}
