package ihm.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ihm.theme.ThemeLIPPS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCFormation extends JPanel
{

	
	/**
	 * Create the panel.
	 */
	public PanelCFormation()
	{
		
		
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panelArianeWest = new JPanel();
		panelArianeWest.setPreferredSize(new Dimension(250, 10));
		panelArianeWest.setBackground(Color.decode("#1B5085"));
		this.add(panelArianeWest, BorderLayout.WEST);
		panelArianeWest.setBorder(new EmptyBorder(-20, 0, 0, 0));
		panelArianeWest.setLayout(new BoxLayout(panelArianeWest, BoxLayout.Y_AXIS));
		
		
		
		
		JPanel panelActionEast = new JPanel();
		panelActionEast.setBorder(new EmptyBorder(30, 50, 30, 50));
		panelActionEast.setBackground(Color.WHITE);
		this.add(panelActionEast, BorderLayout.CENTER);
		panelActionEast.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelTitle.setOpaque(false);
		panelActionEast.add(panelTitle, BorderLayout.NORTH);
		
		JTextPane txtpnTitre = new JTextPane();
		txtpnTitre.setBorder(null);
		txtpnTitre.setOpaque(false);
		txtpnTitre.setEditable(false);
		txtpnTitre.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 17));
		txtpnTitre.setText("Selectionnez une formation");
		panelTitle.add(txtpnTitre);
		
		JPanel panelList = new JPanel();
		panelList.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelList.setPreferredSize(new Dimension(300, 200));
		panelList.setBackground(Color.WHITE);
		panelActionEast.add(panelList, BorderLayout.CENTER);
		panelList.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setBorder(new LineBorder(Color.GRAY));
		list.setAlignmentX(1.0f);
		list.setAutoscrolls(false);
		list.setVisibleRowCount(6);
		
		list.setBackground(UIManager.getColor("Tree.textBackground"));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"- formation 1", "- formation 2", "- formation 3", "- formation 4", "- formation 5", "- formation 6", "- formation 7", "- formation 8", "- formation 9", "- formation 10", "- formation 11", "- formation 12", "- formation 13", "- formation 14", "- formation 15"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 17));
		list.setToolTipText("");
		panelList.add(list, BorderLayout.CENTER);
		
		JPanel panelButton = new JPanel();
		panelButton.setOpaque(false);
		panelButton.setBorder(new EmptyBorder(0, 20, 0, 20));
		panelActionEast.add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAjouterUneFormation = new JButton("Ajouter");

		btnAjouterUneFormation.setHorizontalAlignment(SwingConstants.LEFT);
		panelButton.add(btnAjouterUneFormation);
		
		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.setHorizontalAlignment(SwingConstants.LEFT);
		panelButton.add(btnSuivant);
	}

	
}
