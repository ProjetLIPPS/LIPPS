package ihm.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import actionListener.MngModuleListener;
import controleur.ControleurFMain;
import ihm.popup.CreationModule;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.Utilisateur;
import javax.swing.border.EmptyBorder;



public class PanelMngModule extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	private MngModuleListener mngModuleListener;
	private JPanel panelLoadMod = new JPanel();
	private JPanel panelLoadSeq = new JPanel();
	private JList<String> listFormation = new JList<String>();
	
	

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
		panelListForm.setPreferredSize(new Dimension(250, 10));
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
		
		listFormation = new JList<String>();
		listFormation.setForeground(Color.WHITE);
		listFormation.setBackground(ThemeLIPPS.BLUE_DARK);
		listFormation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFormation.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_BUTTON));
		listFormation.addListSelectionListener(mngModuleListener);
		initListFormation();
		
		JScrollPane scrollAllFormation = new JScrollPane();
		scrollAllFormation.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollAllFormation.setBackground(ThemeLIPPS.BLUE_DARK);
		scrollAllFormation.setOpaque(true);
		scrollAllFormation.setViewportView(listFormation);
		
		panelMyForm.add(scrollAllFormation, BorderLayout.CENTER);
		
		
	
		
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
		
		
		panelLoadMod.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelLoadMod.setLayout(new BoxLayout(panelLoadMod, BoxLayout.Y_AXIS));
		panelLoadMod.setBackground(ThemeLIPPS.BLUE_DARK);
		

		JScrollPane scrollPaneLoadMod = new JScrollPane();
		scrollPaneLoadMod.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPaneLoadMod.setViewportView(panelLoadMod);
		scrollPaneLoadMod.setBackground(ThemeLIPPS.BLUE_DARK);
		
		panelMid.add(scrollPaneLoadMod, BorderLayout.CENTER);
	
			
	
		
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
		
			
		
		panelLoadSeq.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelLoadSeq.setBackground(ThemeLIPPS.BLUE_DARK);
		panelLoadSeq.setLayout(new BoxLayout(panelLoadSeq, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPaneLoadSeq = new JScrollPane();
		scrollPaneLoadSeq.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPaneLoadSeq.setViewportView(panelLoadSeq);
		scrollPaneLoadSeq.setBackground(ThemeLIPPS.BLUE_DARK);
		
		panelRight.add(scrollPaneLoadSeq, BorderLayout.CENTER);

		
		JPanel panelButton = new JPanel();
		add(panelButton, BorderLayout.SOUTH);
		panelButton.setBackground(ThemeLIPPS.BLUE);
		
		JButton btnCrerNouveauModule = new JButton("Créer nouveau module");
		btnCrerNouveauModule.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnCrerNouveauModule.setMnemonic('n');
		panelButton.add(btnCrerNouveauModule);
		
		
		btnCrerNouveauModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				// Edited by Michmich to include the selected formation in order to create module and sequences for it
				Formation formationSelectionnee = new Formation();
				String selectedFormation = listFormation.getSelectedValue();
				
				String[] split = selectedFormation.split(" ");
				String intitule = split[0];
				String date = split[1];
				
				try {
					formationSelectionnee = DaoFactory.getDaoFormation().findFormationByIntituleAndDate(intitule, date);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				new CreationModule(formationSelectionnee);	
			}
		});
		
	}
	
	
	
	public void initListFormation() {
		
		String[] values = null;
	
		try {
			
			Utilisateur user = ControleurFMain.getUtilisateur();
			
			List<Formation> listFormation = (List<Formation>)DaoFactory.getDaoFormation().readAllFormationFromUser(user);
			
			values = new String[listFormation.size()];
						
			for (int i = 0 ; i < listFormation.size() ; i++)  {
				
				values[i] = listFormation.get(i).getIntitule() + " " +  listFormation.get(i).getDateDebut().toString();
				
				}
			
					
			} catch (Exception e1) {
				
			JOptionPane.showMessageDialog(null, "La liste des formations n'a pu être importée.", "Erreur importation données", JOptionPane.WARNING_MESSAGE);
			e1.printStackTrace();
			}
		
		Arrays.sort(values);
				
		this.listFormation.setListData(values);
				
	
	}
	
	public void refresh()
	{
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	
	public JPanel getPanelLoadMod() {
		return panelLoadMod;
	}
	
	public JPanel getPanelLoadSeq() {
		return panelLoadSeq;
	}
	
	public JList<String> getListFormation() {
		return this.listFormation;
	}
	
	public void removePanelLoadMod() {
		this.remove(this.panelLoadMod);
	}
	
	public void removePanelLoadSeq() {
		this.remove(this.panelLoadSeq);
	}
	
	public void setPanelLoadMod(JPanel panelLoadMod) {
		this.panelLoadMod = panelLoadMod;
	}
	
	
	
	
	
}
