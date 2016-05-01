package ihm.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ihm.theme.ThemeLIPPS;


public class PanelMngRowSeq extends JPanel {

	
	private static final long serialVersionUID = 1L;

	public PanelMngRowSeq(String intitSequence) 
	{
		setOpaque(false);
		setMinimumSize(new Dimension(10, 70));
		setMaximumSize(new Dimension(32767, 100));
		setBackground(ThemeLIPPS.BLUE_DARK);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(ThemeLIPPS.BLUE_DARK);
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setText(" "+intitSequence); 
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textArea.setColumns(30);
		textArea.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(0, 8, 250, 63);
		scrollPane.setViewportView(textArea);
		this.add(scrollPane);
		
}
	
}
