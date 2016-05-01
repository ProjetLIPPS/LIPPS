package ihm.fenetre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import actionListener.MngModeleListener;
import ihm.popup.CreationModele;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.Utilisateur;
import java.awt.ComponentOrientation;


public class PanelMngModele extends JPanel  {
	
	

	private static final long serialVersionUID = 1L;
	private JTextField txtIntitule;
	private JTextField txtDuree;
	private JTextField txtSpe;
	private JTextField txtGrn;
	private JTextArea txtDebouche;
	private JList<String> list;
	private Utilisateur user;
	
	private MngModeleListener modelListener;
	
	
	
	public PanelMngModele()	 {
		
		modelListener = new MngModeleListener(this);
		
		
		setOpaque(false);
		setMinimumSize(new Dimension(400, 10));
		
		
		this.setBorder(null);
		this.setBackground(ThemeLIPPS.BLUE);
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new EmptyBorder(0, 15, 0, 0));
		panelLeft.setBackground(ThemeLIPPS.BLUE_DARK);
		panelLeft.setPreferredSize(new Dimension(350, 10));
		add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLabel = new JPanel();
		panelLabel.setOpaque(false);
		panelLabel.setBackground(ThemeLIPPS.BLUE);
		panelLeft.add(panelLabel, BorderLayout.NORTH);
		panelLabel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesFormations = new JLabel("Modèles");
		lblMesFormations.setVerticalTextPosition(SwingConstants.TOP);
		lblMesFormations.setVerticalAlignment(SwingConstants.TOP);
		lblMesFormations.setForeground(Color.WHITE);
		panelLabel.add(lblMesFormations, BorderLayout.NORTH);
		lblMesFormations.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_TITLE));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 70));
		
		JPanel panelJlist = new JPanel();
		panelJlist.setOpaque(false);
		panelLeft.add(panelJlist, BorderLayout.CENTER);
		panelJlist.setLayout(new BorderLayout(0, 0));
		
		list = new JList<String>();
		list.setBounds(new Rectangle(100, 0, 0, 0));
		list.setSelectionForeground(Color.WHITE);
		list.setSelectionBackground(ThemeLIPPS.BLUE);
		list.setOpaque(true);
		list.setFixedCellHeight(40);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setForeground(Color.WHITE);
		list.setBackground(ThemeLIPPS.BLUE_DARK);
		list.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		//panelJlist.add(list, BorderLayout.NORTH);
		list.addListSelectionListener(modelListener);
		
		initList();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setViewportView(list);
		scrollPane.setBackground(ThemeLIPPS.BLUE_DARK);
		panelJlist.add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		
		JPanel panelBtn = new JPanel();
		panelBtn.setOpaque(false);
		panelBtn.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelBtn.setBackground(ThemeLIPPS.BLUE);
		panelLeft.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnCrerNouvelleFormation = new JButton("Créer nouveau modèle");
	
		btnCrerNouvelleFormation.setOpaque(false);
		btnCrerNouvelleFormation.setMnemonic('n');
		btnCrerNouvelleFormation.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		
		btnCrerNouvelleFormation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreationModele newModele = new CreationModele();
				newModele.setLocationRelativeTo(null);
				initList();
			}
		});
		
		panelBtn.add(btnCrerNouvelleFormation);
		
		JPanel panelRight = new JPanel();
		panelRight.setOpaque(false);
		panelRight.setBackground(Color.WHITE);
		add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTrio = new JPanel();
		panelTrio.setBackground(Color.WHITE);
		panelTrio.setPreferredSize(new Dimension(10, 550));
		panelRight.add(panelTrio, BorderLayout.CENTER);
		panelTrio.setLayout(new BoxLayout(panelTrio, BoxLayout.Y_AXIS));
		
		JPanel panelBox = new JPanel();
		panelBox.setMinimumSize(new Dimension(10, 50));
		panelBox.setBorder(new EmptyBorder(40, 25, 60, 25));
		panelBox.setBackground(Color.WHITE);
		panelTrio.add(panelBox);
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		
		JPanel panelFlow1stLine = new JPanel();
		panelFlow1stLine.setBorder(new EmptyBorder(20, 0, 0, 0));
		panelFlow1stLine.setMinimumSize(new Dimension(10, 20));
		panelFlow1stLine.setBackground(Color.WHITE);
		panelBox.add(panelFlow1stLine);
		panelFlow1stLine.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblIntitul = new JLabel("Intitulé:");
		panelFlow1stLine.add(lblIntitul);
		lblIntitul.setMinimumSize(new Dimension(38, 50));
		lblIntitul.setForeground(Color.BLACK);
		lblIntitul.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panelFlow1stLine.add(rigidArea);
		rigidArea.setPreferredSize(new Dimension(5, 5));
		
		txtIntitule = new JTextField();
		panelFlow1stLine.add(txtIntitule);
		txtIntitule.setMinimumSize(new Dimension(6, 30));
		txtIntitule.setEditable(false);
		txtIntitule.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtIntitule.setColumns(20);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow1stLine.add(rigidArea_4);
		rigidArea_4.setPreferredSize(new Dimension(30, 20));
		
		JLabel lblSpcialit = new JLabel("Spécialité:");
		panelFlow1stLine.add(lblSpcialit);
		lblSpcialit.setMinimumSize(new Dimension(49, 50));
		lblSpcialit.setForeground(Color.BLACK);
		lblSpcialit.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow1stLine.add(rigidArea_1);
		rigidArea_1.setPreferredSize(new Dimension(5, 5));
		
		txtSpe = new JTextField();
		panelFlow1stLine.add(txtSpe);
		txtSpe.setMinimumSize(new Dimension(6, 50));
		txtSpe.setEditable(false);
		txtSpe.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtSpe.setColumns(10);
		
		JPanel panelFlow2ndLine = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelFlow2ndLine.getLayout();
		panelFlow2ndLine.setBorder(null);
		panelFlow2ndLine.setMinimumSize(new Dimension(10, 20));
		panelFlow2ndLine.setBackground(Color.WHITE);
		panelBox.add(panelFlow2ndLine);
		
		JLabel lblNGrn = new JLabel("N° GRN:");
		panelFlow2ndLine.add(lblNGrn);
		lblNGrn.setForeground(Color.BLACK);
		lblNGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_6);
		rigidArea_6.setPreferredSize(new Dimension(5, 5));
		
		txtGrn = new JTextField();
		panelFlow2ndLine.add(txtGrn);
		txtGrn.setEditable(false);
		txtGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtGrn.setColumns(10);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_8);
		rigidArea_8.setPreferredSize(new Dimension(45, 20));
		
		JLabel lblDure = new JLabel("Durée:");
		panelFlow2ndLine.add(lblDure);
		lblDure.setForeground(Color.BLACK);
		lblDure.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_2);
		rigidArea_2.setPreferredSize(new Dimension(5, 5));
		
		txtDuree = new JTextField();
		panelFlow2ndLine.add(txtDuree);
		txtDuree.setEditable(false);
		txtDuree.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtDuree.setColumns(6);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_3);
		rigidArea_3.setPreferredSize(new Dimension(5, 5));
		
		JLabel lblHeures = new JLabel("heures");
		panelFlow2ndLine.add(lblHeures);
		lblHeures.setForeground(Color.BLACK);
		lblHeures.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JPanel panelLblDeb = new JPanel();
		panelLblDeb.setOpaque(false);
		panelBox.add(panelLblDeb);
		panelLblDeb.setLayout(new BoxLayout(panelLblDeb, BoxLayout.X_AXIS));
		
		JLabel lblDbouchs = new JLabel("Débouchés:");
		panelLblDeb.add(lblDbouchs);
		lblDbouchs.setPreferredSize(new Dimension(0, 30));
		lblDbouchs.setForeground(Color.BLACK);
		lblDbouchs.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JScrollPane scrollPaneDeb = new JScrollPane();
		panelBox.add(scrollPaneDeb);
		scrollPaneDeb.setPreferredSize(new Dimension(200, 100));
		
		txtDebouche = new JTextArea();
		txtDebouche.setTabSize(10);
		txtDebouche.setLineWrap(true);
		txtDebouche.setEditable(false);
		txtDebouche.setPreferredSize(new Dimension(0, 10));
		txtDebouche.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPaneDeb.setViewportView(txtDebouche);
		txtDebouche.setColumns(20);
		txtDebouche.setRows(7);
		
		JPanel panelButton = new JPanel();
		panelButton.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelButton.setBackground(Color.WHITE);
		panelRight.add(panelButton, BorderLayout.SOUTH);
		
		JButton delModel = new JButton("Supprimer");
		delModel.setMnemonic('e');
		delModel.setOpaque(false);
		delModel.setMnemonic('f');
		delModel.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		
		delModel.addActionListener(modelListener);
		
		panelButton.add(delModel);
		
	}



	public JTextField getTxtIntitule() {
		return txtIntitule;
	}



	public JTextField getTxtDuree() {
		return txtDuree;
	}



	public JTextField getTxtSpe() {
		return txtSpe;
	}



	public JTextField getTxtGrn() {
		return txtGrn;
	}



	public JTextArea getTxtDebouche() {
		return txtDebouche;
	}

	public JList<String> getList() {
		return list;
	}
	
	public void initList() {
		
		String[] values = null;
		
		try {
			
			List<Formation> listFormation = (List) DaoFactory.getDaoFormation().readAllModele();
			values = new String[listFormation.size()];
						
			for (int i = 0 ; i < listFormation.size() ; i++)
				{
				
				values[i] = listFormation.get(i).getIntitule();
				
				}
			
					
			} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "La liste des formations n'a pu être importée.", "Erreur importation données", JOptionPane.WARNING_MESSAGE);
			e1.printStackTrace();
			}
		
		Arrays.sort(values);
				
		this.list.setListData(values);
	
	}
	
	
	
}
