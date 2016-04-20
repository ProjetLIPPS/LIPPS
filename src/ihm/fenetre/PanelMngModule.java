package ihm.fenetre;

import controleur.*;
import ihm.popup.CreationModule;
import ihm.theme.ThemeLIPPS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


public class PanelMngModule extends JPanel
{

	
	/**
	 * TODO implementation rowsequences !!!
	 */
	
	public PanelMngModule()	{
		
		setMinimumSize(new Dimension(400, 10));
		
		
		this.setBorder(null);
		//this.setBackground(ThemeLIPPS.BLUE_DARK);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelBoxTrio = new JPanel();
		panelBoxTrio.setBackground(ThemeLIPPS.BLUE_DARK);
		add(panelBoxTrio);
		panelBoxTrio.setLayout(new BoxLayout(panelBoxTrio, BoxLayout.X_AXIS));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setOpaque(false);
		panelBoxTrio.add(panelLeft);
		panelLeft.setBorder(new LineBorder(Color.WHITE));
		panelLeft.setPreferredSize(new Dimension(300, 10));
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel panelExistingMod = new JPanel();
		panelExistingMod.setOpaque(false);
		panelLeft.add(panelExistingMod, BorderLayout.NORTH);
		panelExistingMod.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesFormations = new JLabel("Modules existants");
		lblMesFormations.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblMesFormations.setForeground(Color.WHITE);
		panelExistingMod.add(lblMesFormations, BorderLayout.NORTH);
		lblMesFormations.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_TITLE));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 70));
		
		JPanel panelCenterModList = new JPanel();
		panelCenterModList.setOpaque(false);
		panelCenterModList.setMinimumSize(new Dimension(0, 10));
		panelLeft.add(panelCenterModList, BorderLayout.CENTER);
		panelCenterModList.setPreferredSize(new Dimension(50, 10));
		
		JPanel panelMid = new JPanel();
		panelMid.setOpaque(false);
		panelBoxTrio.add(panelMid);
		panelMid.setBorder(new LineBorder(Color.WHITE));
		panelMid.setPreferredSize(new Dimension(300, 10));
		panelMid.setBackground(new Color(0, 60, 110));
		panelMid.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMyMod = new JPanel();
		panelMyMod.setOpaque(false);
		panelMyMod.setBackground(new Color(0, 60, 110));
		panelMid.add(panelMyMod, BorderLayout.NORTH);
		panelMyMod.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesModules = new JLabel("Mes modules ");
		lblMesModules.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblMesModules.setPreferredSize(new Dimension(75, 70));
		lblMesModules.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesModules.setForeground(Color.WHITE);
		lblMesModules.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_TITLE));
		panelMyMod.add(lblMesModules, BorderLayout.NORTH);
		
		
		JPanel panelLoadMod = new JPanel();
		panelLoadMod.setOpaque(false);
		panelMid.add(panelLoadMod, BorderLayout.CENTER);
		
		JPanel panelRight = new JPanel();
		panelRight.setOpaque(false);
		panelBoxTrio.add(panelRight);
		panelRight.setBorder(new LineBorder(Color.WHITE));
		panelRight.setPreferredSize(new Dimension(300, 10));
		panelRight.setBackground(new Color(0, 60, 110));
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMySeq = new JPanel();
		panelMySeq.setOpaque(false);
		panelMySeq.setBackground(new Color(0, 60, 110));
		panelRight.add(panelMySeq, BorderLayout.NORTH);
		panelMySeq.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSodules = new JLabel("Séquences liées");
		lblSodules.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblSodules.setPreferredSize(new Dimension(75, 70));
		lblSodules.setHorizontalAlignment(SwingConstants.CENTER);
		lblSodules.setForeground(Color.WHITE);
		lblSodules.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_TITLE));
		panelMySeq.add(lblSodules, BorderLayout.NORTH);
		
		JPanel panelLoadSeq = new JPanel();
		panelLoadSeq.setOpaque(false);
		panelLoadSeq.setPreferredSize(new Dimension(50, 10));
		panelLoadSeq.setMinimumSize(new Dimension(0, 10));
		panelLoadSeq.setBackground(new Color(0, 60, 110));
		panelRight.add(panelLoadSeq, BorderLayout.CENTER);
		
		JPanel panelButton = new JPanel();
		add(panelButton, BorderLayout.SOUTH);
		
		JButton btnCrerNouveauModule = new JButton("Créer nouveau module");
		btnCrerNouveauModule.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnCrerNouveauModule.setMnemonic('n');
		panelButton.add(btnCrerNouveauModule);
		
		
		btnCrerNouveauModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreationModule newModule = new CreationModule();	
				newModule.setVisible(true);
			}
		});
		
	
		
		
	}

	
}
