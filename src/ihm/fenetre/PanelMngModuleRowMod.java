package ihm.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import ihm.theme.ThemeLIPPS;
import model.objet.Module;


public class PanelMngModuleRowMod extends JPanel {

	
	private static final long serialVersionUID = 1L;

	public PanelMngModuleRowMod(Module  module) 	{
		
		setOpaque(false);
		setPreferredSize(new Dimension(250, 50));
		setMinimumSize(new Dimension(10, 70));
		setMaximumSize(new Dimension(32767, 100));
		//this.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.WHITE));
		//this.setAlignmentX(0.0f);
		setBackground(ThemeLIPPS.BLUE_DARK);
		
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 8, 250, 63);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setText(module.getIntitule()); 
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textArea.setColumns(30);
		textArea.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	
}
	
}
