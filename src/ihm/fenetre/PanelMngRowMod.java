package ihm.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import actionListener.MngModuleListener;
import ihm.theme.ThemeLIPPS;


public class PanelMngRowMod extends JPanel {

	
	private static final long serialVersionUID = 1L;
	

	
	private JTextArea textArea = new JTextArea();
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public PanelMngRowMod(String intitModule, PanelMngModule panelMngModule)
	{

		MngModuleListener mngModuleListener = new MngModuleListener(panelMngModule);
		
		
		setOpaque(false);
		setMinimumSize(new Dimension(10, 70));
		setMaximumSize(new Dimension(32767, 100));
		setBackground(ThemeLIPPS.BLUE_DARK);
		
		
		textArea.setBackground(ThemeLIPPS.BLUE_DARK);
		textArea.setForeground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setText(intitModule); 
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textArea.setColumns(30);
		textArea.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		textArea.setFocusable(true);
		textArea.addFocusListener(mngModuleListener);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(0, 8, 250, 63);
		scrollPane.setViewportView(textArea);
		this.add(scrollPane);
		
	
	
}
	
}
