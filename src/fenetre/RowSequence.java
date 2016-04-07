package fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class RowSequence extends JPanel {

	
	
	
	/**
	 * Create the panel.
	 */
	public RowSequence() 
	{
		setPreferredSize(new Dimension(508, 85));
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
		textArea.setText("Prendre en charge un VL ou un VUL pour r\u00E9aliser des supports m\u00E9caniques");
		textArea.setRows(3);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
		textArea.setColumns(30);
		textArea.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		this.add(textArea);
	}
	
	

}
