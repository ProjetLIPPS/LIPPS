package ihm.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import ihm.LippsIhm;
import ihm.theme.ThemeLIPPS;
import model.objet.Module;


public class PanelMngModuleRowMod extends JPanel {

	
	private LippsIhm lippsMainFrame;
	
	public PanelMngModuleRowMod(Module  module) 
	{
		setOpaque(false);
		this.lippsMainFrame = lippsMainFrame;
		
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
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setText("//METHODE CONTROLLER QUI RECUPERE INTITULE MODULE"); // TODO
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textArea.setColumns(30);
		textArea.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	
}
	
}
