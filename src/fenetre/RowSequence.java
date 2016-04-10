package fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RowSequence extends JPanel {

	private CreationModule JFrame;
	
	
	/**
	 * Create the panel.
	 */
	public RowSequence()
	{
		
		this.setMaximumSize(new Dimension(32767, 60));
		this.setBackground(Color.WHITE);
		this.setAlignmentX(0.0f);
		JLabel lblEnregistrementDesSquences = new JLabel("Enregistrement des séquences :");
		lblEnregistrementDesSquences.setFont(new Font("Arial", Font.PLAIN, 17));
		this.add(lblEnregistrementDesSquences);
	}
	
	public RowSequence(CreationModule JFrame) 
	{
		this.JFrame = JFrame;
		
		setPreferredSize(new Dimension(628, 85));
		this.setMinimumSize(new Dimension(10, 100));
		this.setMaximumSize(new Dimension(32767, 100));
		this.setBorder(new MatteBorder(2, 0, 0, 0, (Color) Color.LIGHT_GRAY));
		this.setBackground(Color.WHITE);
		this.setAlignmentX(0.0f);
		this.setLayout(null);
		
		JLabel label = new JLabel("Description de la s\u00E9quence " + " :");
		label.setBounds(20, 20, 167, 15);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		this.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(193, 19, 332, 47);
		textArea.setWrapStyleWord(true);
		textArea.setText("Entrez ici la description de la séquence.");
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
		textArea.setColumns(30);
		textArea.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (textArea.getText().equals("Entrez ici la description de la séquence."))
				{
					textArea.setText("");
				}
				
			}
		});
		
		this.add(textArea);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(40, 43, 98, 23);
		
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getJFrame().supprimerSequence((RowSequence)(((JButton)e.getSource()).getParent()));
			}
		});
		
		add(btnSupprimer);
		
		JLabel Move_up = new JLabel("");
		Move_up.setIcon(new ImageIcon(RowSequence.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		Move_up.setBounds(546, 21, 46, 14);
		add(Move_up);
		
		JLabel Move_down = new JLabel("");
		Move_down.setIcon(new ImageIcon(RowSequence.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		Move_down.setBounds(546, 43, 46, 14);
		add(Move_down);
	}
	
	public CreationModule getJFrame()
	{
		return this.JFrame;
	}
	
	public RowSequence getRowSequence()
	{
		return this;
	}
	
}
