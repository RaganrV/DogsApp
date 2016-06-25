package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.sql.Date;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import java.awt.SystemColor;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import entities.Dresseur;
import esprit.tn.businessDeleguate.ManageDresseurDeleguate;
import gui.panels.ImagePanel;

import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import gui.panels.MenuPanel;
import java.awt.Color;

public class Alldresseur extends JFrame {

	List<Dresseur> dresseurs;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
JFrame j= this;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alldresseur frame = new Alldresseur();
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
	public Alldresseur() {
		
		dresseurs=new ArrayList<Dresseur>();
		
		dresseurs=new ManageDresseurDeleguate().getAllDresseur();
		setMinimumSize(new Dimension(800, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ImagePanel imagePanel = new ImagePanel();
		
		imagePanel.setImage(new ImageIcon("src//main//resources//images//fond1.jpg").getImage());
		imagePanel.setMinimumSize(new Dimension(800, 600));
		contentPane.add(imagePanel, BorderLayout.CENTER);
		imagePanel.setLayout(null);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.text);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageDresseurDeleguate delegate = new ManageDresseurDeleguate();
				Dresseur dresseur = new Dresseur();
				dresseur =dresseurs.get(table.getSelectedRow());
				delegate.deleteDresseur(dresseur);
				 //JOptionPane.showMessageDialog(rootPane, "Deleted !");
	               // this.dispose();
				dresseurs=new ManageDresseurDeleguate().getAllDresseur();
				 initDataBindings();
	
			}
		});
		
		MenuPanel menuPanel = new MenuPanel((JFrame) this);
		menuPanel.setBounds(0, 0, 784, 36);
		imagePanel.add(menuPanel);
		menuPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 99, 736, 306);
		imagePanel.add(scrollPane);
		table = new JTable();
		table.setBounds(20, 28, 760, 440);


		JComboBox comboBox = new JComboBox();
    	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dressage de base", "Formation des chiens de police", "Recherche et de dressage de chiens de sauvetage", "Formation Dog Show", "Physique de dressage de chiens d'assistance"}));
    	comboBox.setBounds(283, 431, 232, 22);

    	
    	imagePanel.add(comboBox);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

		    	if(table.getSelectedRow()!=-1){
		        	System.out.println(table.getValueAt(table.getSelectedRow(), 4));
		        	
		        	
		        	String [] specialite = new String[] {"Dressage de base", "Formation des chiens de police", "Recherche et de dressage de chiens de sauvetage", "Formation Dog Show", "Physique de dressage de chiens d'assistance"};
		        	System.out.println(specialite[0]);
		        	for (int i = 0; i < specialite.length; i++) {
		    		if (table.getValueAt(table.getSelectedRow(), 4).equals(specialite[i])) {
		    comboBox.setSelectedIndex(i);
		    		}
		    	}}
		
			}
		});
		btnDelete.setBounds(662, 427, 97, 30);
		imagePanel.add(btnDelete);
		initDataBindings();
	     
    	
    	scrollPane.setViewportView(table);
    	
    	JButton btnUpdate = new JButton("Update");
    	btnUpdate.setBackground(SystemColor.text);
    	btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    //	table.getColumnModel().getColumn(4).setCellRenderer(new Cell generateBox());  

    	btnUpdate.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
				System.out.println("ok2");
				int row = table.getSelectedRow();
				
				ManageDresseurDeleguate delegate = new ManageDresseurDeleguate();
				if (table.getSelectedColumn()==0) {
					
					
					Dresseur dresseur = new Dresseur();
					dresseur=dresseurs.get(row);
					dresseur.setAdresse((String) table.getValueAt(row, table.getSelectedColumn()));
				delegate.updateDresseur(dresseur);
				 
			
				System.out.println("ok");
				dresseurs=new ManageDresseurDeleguate().getAllDresseur();
				 initDataBindings();
				}
				Dresseur dresseur = new Dresseur();
				if (table.getSelectedColumn()==1) {
					
				
					
					dresseur=dresseurs.get(row);
					dresseur.setNom((String) table.getValueAt(row, table.getSelectedColumn()));
		
				}
				if (table.getSelectedColumn()==2) {
					
					
					
					dresseur=dresseurs.get(row);
					dresseur.setPrenom((String) table.getValueAt(row, table.getSelectedColumn()));
	
				}
				if (table.getSelectedColumn()==3) {
					
					
					
					dresseur=dresseurs.get(row);
					dresseur.setMobile((String) table.getValueAt(row, table.getSelectedColumn()));
				
				}
dresseur.setSpecialite((String) comboBox.getSelectedItem());
				delegate.updateDresseur(dresseur);
				 
				
				System.out.println("ok");
				dresseurs=new ManageDresseurDeleguate().getAllDresseur();
				 initDataBindings();

			
				
				
    		}
    	});
    	btnUpdate.setBounds(553, 427, 97, 30);
    	imagePanel.add(btnUpdate);
    	
    	JButton button = new JButton("Ajouter");
    	button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			AddDresseurGUI a = new AddDresseurGUI();
    			a.show();
    			j.hide();
    		}
    	});
    
    	button.setBackground(Color.WHITE);
    	button.setBounds(33, 430, 97, 30);
    	imagePanel.add(button);
    	
    	

	}
	protected void initDataBindings() {
		JTableBinding<Dresseur, List<Dresseur>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, dresseurs, table);
		//
		BeanProperty<Dresseur, String> dresseurBeanProperty = BeanProperty.create("adresse");
		jTableBinding.addColumnBinding(dresseurBeanProperty).setColumnName("Adresse");
		//
		BeanProperty<Dresseur, String> dresseurBeanProperty_1 = BeanProperty.create("nom");
		jTableBinding.addColumnBinding(dresseurBeanProperty_1).setColumnName("Nom");
		//
		BeanProperty<Dresseur, String> dresseurBeanProperty_2 = BeanProperty.create("prenom");
		jTableBinding.addColumnBinding(dresseurBeanProperty_2).setColumnName("Prenom");
		//
		BeanProperty<Dresseur, String> dresseurBeanProperty_3 = BeanProperty.create("mobile");
		jTableBinding.addColumnBinding(dresseurBeanProperty_3).setColumnName("Telephone");
		//
		
		BeanProperty<Dresseur, String> dresseurBeanProperty_4 = BeanProperty.create("specialite");
		jTableBinding.addColumnBinding(dresseurBeanProperty_4).setColumnName("Specialite");
		
		//
		jTableBinding.bind();
		
	}
	private JComboBox generateBox(){
		
		JComboBox bx=null;
		bx.setModel(new DefaultComboBoxModel(new String[] {"Dressage de base", "Formation des chiens de police", "Recherche et de dressage de chiens de sauvetage", "Formation Dog Show", "Physique de dressage de chiens d'assistance"}));
		return bx;
		
		
	}
}
