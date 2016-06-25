package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import esprit.tn.businessDeleguate.ManageVeterinaireDeleguate;
import entities.Veterinaire;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VeterinaireGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextprenom;
	private JTextField jTextnom;
	private JTextField jTextAddresse;
	private JTextField jTextMobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeterinaireGUI frame = new VeterinaireGUI();
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
	public VeterinaireGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jTextprenom = new JTextField();
		jTextprenom.setBounds(171, 53, 86, 20);
		contentPane.add(jTextprenom);
		jTextprenom.setColumns(10);
		
		jTextnom = new JTextField();
		jTextnom.setBounds(171, 109, 86, 20);
		contentPane.add(jTextnom);
		jTextnom.setColumns(10);
		
		jTextAddresse = new JTextField();
		jTextAddresse.setBounds(171, 169, 86, 20);
		contentPane.add(jTextAddresse);
		jTextAddresse.setColumns(10);
		
		jTextMobile = new JTextField();
		jTextMobile.setBounds(171, 230, 86, 20);
		contentPane.add(jTextMobile);
		jTextMobile.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pr\u00E9nom");
		lblNewLabel.setBounds(32, 56, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(32, 112, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Addresse");
		lblNewLabel_2.setBounds(32, 172, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Phone");
		lblNewLabel_3.setBounds(32, 233, 77, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton AddVet = new JButton("Ajout Veterinaire");
		AddVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JPanel panel = new JPanel();
				Veterinaire vet= new Veterinaire();
				vet.setNom(jTextnom.getText());
				vet.setPrenom(jTextprenom.getText());
				vet.setAdresse(jTextAddresse.getText());
				vet.setMobile(jTextMobile.getText());
				
				if((jTextnom.getText().length()==0)||(jTextprenom.getText().length()==0)||(jTextAddresse.getText().length()==0)||(jTextMobile.getText().length()==0)){
					 JOptionPane.showMessageDialog(panel, "Obligatory Field Empty", "Error", JOptionPane.ERROR_MESSAGE);
				}	
				else{
				ManageVeterinaireDeleguate.getInstance().addVeterinaire(vet);
				//AddAgencyGui.this.hide();
				//new ManageAgencyGui().setVisible(true);
				}
			}
		});
		AddVet.setBounds(293, 229, 120, 23);
		getContentPane().add(AddVet);
	}
}
