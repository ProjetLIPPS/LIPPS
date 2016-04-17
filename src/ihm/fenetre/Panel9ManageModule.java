package fenetre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;


public class Panel9ManageModule extends JPanel
{

	
	/**
	 * TODO implementation rowsequences !!!
	 */
	
	public PanelMngModule()	{
		
		setMinimumSize(new Dimension(400, 10));
		
		
		this.setBorder(null);
		this.setBackground(Color.decode("#3787C8"));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelBoxTrio = new JPanel();
		add(panelBoxTrio);
		panelBoxTrio.setLayout(new BoxLayout(panelBoxTrio, BoxLayout.X_AXIS));
		
		JPanel panelLeft = new JPanel();
		panelBoxTrio.add(panelLeft);
		panelLeft.setBorder(new LineBorder(Color.WHITE));
		panelLeft.setBackground(Color.decode("#003C6E"));
		panelLeft.setPreferredSize(new Dimension(300, 10));
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel panelExistingMod = new JPanel();
		panelLeft.add(panelExistingMod, BorderLayout.NORTH);
		panelExistingMod.setBackground(Color.decode("#003C6E"));
		panelExistingMod.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesFormations = new JLabel("Modules existants");
		lblMesFormations.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblMesFormations.setForeground(Color.WHITE);
		panelExistingMod.add(lblMesFormations, BorderLayout.NORTH);
		lblMesFormations.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 150));
		
		JPanel panelCenterLbl = new JPanel();
		panelCenterLbl.setMinimumSize(new Dimension(0, 10));
		panelCenterLbl.setBackground(Color.decode("#003C6E"));
		panelLeft.add(panelCenterLbl, BorderLayout.CENTER);
		panelCenterLbl.setPreferredSize(new Dimension(50, 10));
		
		JPanel panelMid = new JPanel();
		panelBoxTrio.add(panelMid);
		panelMid.setBorder(new LineBorder(Color.WHITE));
		panelMid.setPreferredSize(new Dimension(300, 10));
		panelMid.setBackground(new Color(0, 60, 110));
		panelMid.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMyMod = new JPanel();
		panelMyMod.setBackground(new Color(0, 60, 110));
		panelMid.add(panelMyMod, BorderLayout.NORTH);
		panelMyMod.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesModules = new JLabel("Mes modules ");
		lblMesModules.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblMesModules.setPreferredSize(new Dimension(75, 150));
		lblMesModules.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesModules.setForeground(Color.WHITE);
		lblMesModules.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panelMyMod.add(lblMesModules, BorderLayout.NORTH);
		
		JPanel panelLoadMod = new JPanel();
		
		panelLoadMod.setPreferredSize(new Dimension(50, 10));
		panelLoadMod.setMinimumSize(new Dimension(0, 10));
		panelLoadMod.setBackground(Color.decode("#003C6E"));
		panelMid.add(panelLoadMod, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.decode("#003C6E"));
		scrollPane.add(panelLoadMod);
		panelMid.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelRight = new JPanel();
		panelBoxTrio.add(panelRight);
		panelRight.setBorder(new LineBorder(Color.WHITE));
		panelRight.setPreferredSize(new Dimension(300, 10));
		panelRight.setBackground(new Color(0, 60, 110));
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMySeq = new JPanel();
		panelMySeq.setBackground(new Color(0, 60, 110));
		panelRight.add(panelMySeq, BorderLayout.NORTH);
		panelMySeq.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSodules = new JLabel("Séquences liées");
		lblSodules.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblSodules.setPreferredSize(new Dimension(75, 150));
		lblSodules.setHorizontalAlignment(SwingConstants.CENTER);
		lblSodules.setForeground(Color.WHITE);
		lblSodules.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panelMySeq.add(lblSodules, BorderLayout.NORTH);
		
		JPanel panelLoadSeq = new JPanel();
		panelLoadSeq.setPreferredSize(new Dimension(50, 10));
		panelLoadSeq.setMinimumSize(new Dimension(0, 10));
		panelLoadSeq.setBackground(new Color(0, 60, 110));
		panelRight.add(panelLoadSeq, BorderLayout.CENTER);
		
		JPanel panelButton = new JPanel();
		add(panelButton, BorderLayout.SOUTH);
		
		JButton btnCrerNouveauModule = new JButton("Créer nouveau module");
		btnCrerNouveauModule.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnCrerNouveauModule.setMnemonic('n');
		panelButton.add(btnCrerNouveauModule);
	}

	
}
