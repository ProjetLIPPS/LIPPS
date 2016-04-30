package ihm.popup;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import ihm.theme.ThemeLIPPS;

public class RowSequence extends JPanel
{

	private CreationModule JFrame;
	private JTextArea textAreaSequenceDescription;
	
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 11, 370, 63);
		add(scrollPane);
		
		textAreaSequenceDescription = new JTextArea();
		scrollPane.setViewportView(textAreaSequenceDescription);
		textAreaSequenceDescription.setWrapStyleWord(true);
		textAreaSequenceDescription.setText("Entrez ici la description de la séquence.");
		textAreaSequenceDescription.setRows(3);
		textAreaSequenceDescription.setLineWrap(true);
		textAreaSequenceDescription.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 13));
		textAreaSequenceDescription.setColumns(30);
		textAreaSequenceDescription.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		textAreaSequenceDescription.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (textAreaSequenceDescription.getText().equals("Entrez ici la description de la séquence."))
				{
					textAreaSequenceDescription.setText("");
				}
				
			}
		});
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(Color.WHITE);
		btnSupprimer.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 12));
		btnSupprimer.setForeground(Color.DARK_GRAY);
		btnSupprimer.setBounds(531, 30, 98, 23);
		
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getJFrame().supprimerSequence(getThis());
			}
		});
		
		add(btnSupprimer);
		
		JLabel Move_up = new JLabel("");
		Move_up.setForeground(Color.WHITE);
		Move_up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				getJFrame().monterSequence(getThis());
			}
		});
		Move_up.setIcon(new ImageIcon("img/fleche_haut16x16.png"));
		Move_up.setBounds(500, 11, 16, 14);
		add(Move_up);
		
		JLabel Move_down = new JLabel("");
		Move_down.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				getJFrame().descendreSequence(getThis());
			}
		});
		Move_down.setIcon(new ImageIcon("img/fleche_bas16x16.png"));
		Move_down.setBounds(500, 60, 16, 14);
		add(Move_down);
	}
	
	public CreationModule getJFrame()
	{
		return this.JFrame;
	}
	
	public RowSequence getThis()
	{
		return this;
	}
	
	public JTextArea getTextAreaSequenceDescription()
	{
		return textAreaSequenceDescription;
	}
}
