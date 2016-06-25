package gui.panels;



import gui.Alldresseur;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;



 







import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {
	private boolean subs = false;
	private boolean itin = false;
	private boolean notif = false;
	private boolean ware = false;
	private static final String VOICENAME="kevin16";
	
	/**
	 * Create the panel.
	 */
	public MenuPanel(JFrame frame) {
		setMinimumSize(new Dimension(750, 70));
		setLayout(null);
		this.setOpaque(false);
		JButton btnNewButton = new JButton("Dresseur");



		btnNewButton.setBounds(0, 0, 161, 35);
		add(btnNewButton);

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alldresseur j= new Alldresseur();
				j.show();
				frame.hide();
				
			}
		});

	}
}
