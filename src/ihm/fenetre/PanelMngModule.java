package ihm.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import actionListener.MngModuleListener;
import controleur.RenvoiListeFormation;
import ihm.popup.CreationModule;
import ihm.theme.ThemeLIPPS;



public class PanelMngModule extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	private MngModuleListener mngModuleListener;
	private JPanel panelAllModList = new JPanel();
	
	

	public PanelMngModule()	{
		
		mngModuleListener = new MngModuleListener(this);
		
		setMinimumSize(new Dimension(400, 10));
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelBoxTrio = new JPanel(); // CONTIENT 4 PANELS PRINCIPAUX LISTFORM + LEFT + MID + RIGHT
		
		panelBoxTrio.setBackground(ThemeLIPPS.BLUE_DARK);
		add(panelBoxTrio);
		panelBoxTrio.setLayout(new BoxLayout(panelBoxTrio, BoxLayout.X_AXIS));
		
		// LISTFORM en borderlayout contient panels formselec pour le label (north) et myform (center) pour la Jlist de formations
		
		JPanel panelListForm = new JPanel();
		panelListForm.setBorder(new MatteBorder(2, 2, 2, 1, (Color) new Color(0, 0, 0)));
		panelListForm.setPreferredSize(new Dimension(200, 10));
		panelListForm.setOpaque(false);
		panelBoxTrio.add(panelListForm);
		panelListForm.setLayout(new BorderLayout(0, 0));
		
		JPanel panelFormSelec = new JPanel();
		panelFormSelec.setOpaque(false);
		panelListForm.add(panelFormSelec, BorderLayout.NORTH);
		panelFormSelec.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesFormations_1 = new JLabel("Mes Formations");
		lblMesFormations_1.setPreferredSize(new Dimension(75, 40));
		lblMesFormations_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations_1.setForeground(Color.WHITE);
		lblMesFormations_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_BUTTON));
		lblMesFormations_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		panelFormSelec.add(lblMesFormations_1, BorderLayout.NORTH);
		
		JPanel panelMyForm = new JPanel();
		panelMyForm.setOpaque(false);
		panelListForm.add(panelMyForm, BorderLayout.CENTER);
		panelMyForm.setLayout(new BorderLayout(0, 0));
		
		JList<String> listFormation = new JList<String>();
		listFormation.setModel(new AbstractListModel<String>() {
	
			private static final long serialVersionUID = 1L;
			
			String[] values = RenvoiListeFormation.renvoiListeFormation();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
			
		listFormation.setOpaque(false);		
		listFormation.setForeground(Color.WHITE);
		listFormation.setBackground(ThemeLIPPS.BLUE_DARK);
		listFormation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFormation.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_BUTTON));
		listFormation.addListSelectionListener(mngModuleListener);
		
		panelMyForm.add(listFormation, BorderLayout.CENTER);
		
		// PANELLEFT en borderlayout contient panels existingmod  pour le label (north) et allmodlist (center) pour afficher les modules (via des panelmngmodulerowmod)
		
		JPanel panelLeft = new JPanel();
		panelLeft.setOpaque(false);
		panelLeft.setBackground(ThemeLIPPS.BLUE_DARK);
		panelBoxTrio.add(panelLeft);
		panelLeft.setBorder(new MatteBorder(2, 0, 2, 1, (Color) new Color(0, 0, 0)));
		panelLeft.setPreferredSize(new Dimension(250, 10));
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel panelExistingMod = new JPanel();
		panelExistingMod.setOpaque(false);
		panelLeft.add(panelExistingMod, BorderLayout.NORTH);
		panelExistingMod.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesFormations = new JLabel("Modules existants");
		lblMesFormations.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblMesFormations.setForeground(Color.WHITE);
		panelExistingMod.add(lblMesFormations, BorderLayout.NORTH);
		lblMesFormations.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_BUTTON));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 40));
		
		
		panelAllModList.setOpaque(true);
		panelAllModList.setBackground(ThemeLIPPS.BLUE_DARK);
		panelAllModList.setMinimumSize(new Dimension(0, 10));
		panelAllModList.setPreferredSize(new Dimension(50, 10));
		panelAllModList.setLayout(new BoxLayout(panelAllModList, BoxLayout.Y_AXIS));
		
		
		panelLeft.add(panelAllModList, BorderLayout.CENTER);
		/*JScrollPane scrollAllModList = new JScrollPane();
		scrollAllModList.setBorder(null);
		scrollAllModList.setBackground(ThemeLIPPS.BLUE_DARK);
		scrollAllModList.setOpaque(true);
		scrollAllModList.setViewportView(panelAllModList);*/
		//panelLeft.add(scrollAllModList, BorderLayout.CENTER);
		
	
		
		// PANELMID en borderlayout contient panels mymod  pour le label (north) et loadmod (center) pour afficher les modules (via des panelmngmodulerowmod)

		
		JPanel panelMid = new JPanel();
		panelMid.setOpaque(false);
		panelBoxTrio.add(panelMid);
		panelMid.setBorder(new MatteBorder(2, 0, 2, 1, (Color) new Color(0, 0, 0)));
		panelMid.setPreferredSize(new Dimension(250, 10));
		panelMid.setBackground(new Color(0, 60, 110));
		panelMid.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMyMod = new JPanel();
		panelMyMod.setOpaque(false);
		panelMyMod.setBackground(new Color(0, 60, 110));
		panelMid.add(panelMyMod, BorderLayout.NORTH);
		panelMyMod.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesModules = new JLabel("Mes modules ");
		lblMesModules.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblMesModules.setPreferredSize(new Dimension(75, 40));
		lblMesModules.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesModules.setForeground(Color.WHITE);
		lblMesModules.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_BUTTON));
		panelMyMod.add(lblMesModules, BorderLayout.NORTH);
		
		
		JPanel panelLoadMod = new JPanel();
		panelLoadMod.setOpaque(false);
		panelMid.add(panelLoadMod, BorderLayout.CENTER);
		panelLoadMod.setLayout(new BoxLayout(panelLoadMod, BoxLayout.Y_AXIS));
		

	/*	JScrollPane scrollPaneLoadMod = new JScrollPane();
		scrollPaneLoadMod.setViewportView(panelLoadMod);
		*/
		/*// ICI ON RECUPERE VIA LE CONTROLLER LES MODULES QU'ON INTEGRE A DES PANELROWMODS AVANT DE LES ENVOYER DANS LE PANEL (BOXLAYOUT)
		List<PanelMngModuleRowMod> listMod = LoadModSeqList.listeModule();
		
		for (PanelMngModuleRowMod mod : listMod)  {
			
			panelLoadMod.add(mod);
		}
		*/
		//	panelMid.add(scrollPaneLoadMod, BorderLayout.CENTER);
		
		panelMid.add(panelLoadMod, BorderLayout.CENTER);
		
	
		
		// PARTIE SEQUENCES
		
		JPanel panelRight = new JPanel();
		panelRight.setOpaque(false);
		panelBoxTrio.add(panelRight);
		panelRight.setBorder(new MatteBorder(2, 0, 2, 2, (Color) new Color(0, 0, 0)));
		panelRight.setPreferredSize(new Dimension(250, 10));
		panelRight.setBackground(new Color(0, 60, 110));
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMySeq = new JPanel();
		panelMySeq.setOpaque(false);
		panelMySeq.setBackground(new Color(0, 60, 110));
		panelRight.add(panelMySeq, BorderLayout.NORTH);
		panelMySeq.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSodules = new JLabel("Séquences liées");
		lblSodules.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		lblSodules.setPreferredSize(new Dimension(75, 40));
		lblSodules.setHorizontalAlignment(SwingConstants.CENTER);
		lblSodules.setForeground(Color.WHITE);
		lblSodules.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_BUTTON));
		panelMySeq.add(lblSodules, BorderLayout.NORTH);
		
			
		JPanel panelLoadSeq = new JPanel();
		panelLoadSeq.setOpaque(false);
		panelLoadSeq.setPreferredSize(new Dimension(50, 10));
		panelLoadSeq.setMinimumSize(new Dimension(0, 10));
		panelLoadSeq.setBackground(new Color(0, 60, 110));
		panelRight.add(panelLoadSeq, BorderLayout.CENTER);
		panelLoadSeq.setLayout(new BoxLayout(panelLoadSeq, BoxLayout.X_AXIS));
		
		JScrollPane scrollPaneLoadSeq = new JScrollPane();
		scrollPaneLoadSeq.setBorder(null);
		//scrollPaneLoadSeq.add(panelLoadSeq);
		
		panelRight.add(scrollPaneLoadSeq, BorderLayout.SOUTH);
		
		JPanel panelButton = new JPanel();
		add(panelButton, BorderLayout.SOUTH);
		panelButton.setBackground(ThemeLIPPS.BLUE);
		
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
	
	public JPanel getPanelAllModList() {
		return panelAllModList;
	}

	
}