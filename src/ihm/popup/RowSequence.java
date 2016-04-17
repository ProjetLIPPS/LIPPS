package popup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import theme.ThemeLIPPS;

public class RowSequence extends JPanel {

	private CreationModule JFrame;
	
	
	/**
	 * Create the panel.
	 */
	
	public RowSequence()
	{
		setOpaque(false);
		
		this.setMaximumSize(new Dimension(32767, 60));
		this.setBackground(Color.WHITE);
		this.setAlignmentX(0.0f);
		JLabel lblEnregistrementDesSquences = new JLabel("Enregistrement des séquences :");
		lblEnregistrementDesSquences.setForeground(Color.WHITE);
		lblEnregistrementDesSquences.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 17));
		this.add(lblEnregistrementDesSquences);
	}
	
	
	public RowSequence(CreationModule JFrame) 
	{
		setOpaque(false);
		this.JFrame = JFrame;
		
		setPreferredSize(new Dimension(689, 85));
		this.setMinimumSize(new Dimension(10, 100));
		this.setMaximumSize(new Dimension(32767, 100));
		this.setBorder(new MatteBorder(2, 0, 0, 0, (Color) Color.WHITE));
		this.setBackground(Color.WHITE);
		this.setAlignmentX(0.0f);
		this.setLayout(null);
		
		JLabel lblDescription = new JLabel("Description  :");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setBounds(10, 29, 88, 15);
		lblDescription.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 14));
		this.add(lblDescription);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(120, 11, 370, 47);
		textArea.setWrapStyleWord(true);
		textArea.setText("Entrez ici la description de la séquence.");
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 13));
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
		btnSupprimer.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 12));
		btnSupprimer.setForeground(Color.DARK_GRAY);
		btnSupprimer.setBounds(539, 22, 98, 23);
		
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getJFrame().supprimerSequence(getRowSequence());
			}
		});
		
		add(btnSupprimer);
		
		JLabel Move_up = new JLabel("");
		Move_up.setForeground(Color.BLACK);
		Move_up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				getJFrame().monterSequence(getRowSequence());
			}
		});
		Move_up.setIcon(new ImageIcon(RowSequence.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		Move_up.setBounds(500, 11, 12, 14);
		add(Move_up);
		
		JLabel Move_down = new JLabel("");
		Move_down.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				getJFrame().descendreSequence(getRowSequence());
			}
		});
		Move_down.setIcon(new ImageIcon(RowSequence.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		Move_down.setBounds(500, 44, 12, 14);
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
