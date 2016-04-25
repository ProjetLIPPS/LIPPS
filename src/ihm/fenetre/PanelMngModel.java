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

import actionListener.PanelMngModelListener;
import ihm.popup.CreationModele;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.Utilisateur;


public class PanelMngModel extends JPanel  {
	
	

	private static final long serialVersionUID = 1L;
	private JTextField txtIntitule;
	private JTextField txtDuree;
	private JTextField txtSpe;
	private JTextField txtGrn;
	private JTextArea txtDebouche;
	private JList<String> list;
	private Utilisateur user;
	
	private PanelMngModelListener modelListener;
	
	
	
	public PanelMngModel()	 {
		
		modelListener = new PanelMngModelListener(this);
		
		
		setOpaque(false);
		setMinimumSize(new Dimension(400, 10));
		
		
		this.setBorder(null);
		this.setBackground(ThemeLIPPS.BLUE);
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
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
		lblMesFormations.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_TITLE));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 70));
		
		JPanel panelJlist = new JPanel();
		panelJlist.setOpaque(false);
		panelLeft.add(panelJlist, BorderLayout.WEST);
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
		scrollPane.setBorder(null);
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
				newModele.setVisible(true);
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
		
		JPanel panelTrioMargin = new JPanel();
		panelTrioMargin.setOpaque(false);
		panelTrioMargin.setBackground(Color.WHITE);
		panelTrioMargin.setBackground(ThemeLIPPS.BLUE_DARK);
		panelTrioMargin.setPreferredSize(new Dimension(10, 28));
		panelTrio.add(panelTrioMargin);
		
		JPanel panelBox = new JPanel();
		panelBox.setBorder(new EmptyBorder(0, 25, 0, 25));
		panelBox.setBackground(Color.WHITE);
		panelTrio.add(panelBox);
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		
		JPanel panelFlow1stLine = new JPanel();
		panelFlow1stLine.setBorder(new EmptyBorder(0, 0, 5, 0));
		panelFlow1stLine.setMinimumSize(new Dimension(10, 20));
		panelFlow1stLine.setPreferredSize(new Dimension(0, 0));
		panelFlow1stLine.setBackground(Color.WHITE);
		panelBox.add(panelFlow1stLine);
		panelFlow1stLine.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box horizontalBox1 = Box.createHorizontalBox();
		horizontalBox1.setMinimumSize(new Dimension(0, 100));
		panelFlow1stLine.add(horizontalBox1);
		horizontalBox1.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JLabel lblIntitul = new JLabel("Intitulé:");
		lblIntitul.setMinimumSize(new Dimension(38, 50));
		lblIntitul.setForeground(Color.BLACK);
		lblIntitul.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox1.add(lblIntitul);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(5, 5));
		horizontalBox1.add(rigidArea);
		
		txtIntitule = new JTextField();
		txtIntitule.setMinimumSize(new Dimension(6, 50));
		txtIntitule.setEditable(false);
		txtIntitule.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox1.add(txtIntitule);
		txtIntitule.setColumns(25);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4.setPreferredSize(new Dimension(45, 20));
		horizontalBox1.add(rigidArea_4);
		
		JLabel lblSpcialit = new JLabel("Spécialité:");
		lblSpcialit.setMinimumSize(new Dimension(49, 50));
		lblSpcialit.setForeground(Color.BLACK);
		lblSpcialit.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox1.add(lblSpcialit);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(5, 5));
		horizontalBox1.add(rigidArea_1);
		
		txtSpe = new JTextField();
		txtSpe.setMinimumSize(new Dimension(6, 50));
		txtSpe.setEditable(false);
		txtSpe.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox1.add(txtSpe);
		txtSpe.setColumns(10);
		
		JPanel panelFlow2ndLine = new JPanel();
		panelFlow2ndLine.setMinimumSize(new Dimension(10, 20));
		panelFlow2ndLine.setPreferredSize(new Dimension(0, 0));
		panelFlow2ndLine.setBackground(Color.WHITE);
		panelBox.add(panelFlow2ndLine);
		
		Box horizontalBox2 = Box.createHorizontalBox();
		horizontalBox2.setMinimumSize(new Dimension(0, 20));
		panelFlow2ndLine.add(horizontalBox2);
		
		JLabel lblNGrn = new JLabel("N° GRN:");
		lblNGrn.setForeground(Color.BLACK);
		lblNGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox2.add(lblNGrn);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_6.setPreferredSize(new Dimension(5, 5));
		horizontalBox2.add(rigidArea_6);
		
		txtGrn = new JTextField();
		txtGrn.setEditable(false);
		txtGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox2.add(txtGrn);
		txtGrn.setColumns(10);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_8.setPreferredSize(new Dimension(45, 20));
		horizontalBox2.add(rigidArea_8);
		
		JLabel lblDure = new JLabel("Durée:");
		lblDure.setForeground(Color.BLACK);
		lblDure.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox2.add(lblDure);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox2.add(rigidArea_2);
		rigidArea_2.setPreferredSize(new Dimension(5, 5));
		
		txtDuree = new JTextField();
		txtDuree.setEditable(false);
		txtDuree.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox2.add(txtDuree);
		txtDuree.setColumns(6);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox2.add(rigidArea_3);
		rigidArea_3.setPreferredSize(new Dimension(5, 5));
		
		JLabel lblHeures = new JLabel("heures");
		lblHeures.setForeground(Color.BLACK);
		lblHeures.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		horizontalBox2.add(lblHeures);
		
		JPanel panelCcpDebGridLbl = new JPanel();
		panelCcpDebGridLbl.setBackground(Color.WHITE);
		panelBox.add(panelCcpDebGridLbl);
		panelCcpDebGridLbl.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblDbouchs = new JLabel("Débouchés:");
		lblDbouchs.setPreferredSize(new Dimension(0, 0));
		lblDbouchs.setForeground(Color.BLACK);
		lblDbouchs.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		panelCcpDebGridLbl.add(lblDbouchs);
		lblDbouchs.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelCcpDebTxt = new JPanel();
		panelCcpDebTxt.setBackground(Color.WHITE);
		panelBox.add(panelCcpDebTxt);
		panelCcpDebTxt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPaneDeb = new JScrollPane();
		panelCcpDebTxt.add(scrollPaneDeb);
		
		txtDebouche = new JTextArea();
		txtDebouche.setTabSize(10);
		txtDebouche.setLineWrap(true);
		txtDebouche.setEditable(false);
		txtDebouche.setPreferredSize(new Dimension(0, 0));
		txtDebouche.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPaneDeb.setViewportView(txtDebouche);
		txtDebouche.setColumns(20);
		txtDebouche.setRows(7);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelBox.add(verticalStrut);
		
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
			
			List<Formation> listFormation = (List) DaoFactory.getDaoFormation().readAll(Formation.class);
			values = new String[listFormation.size()];
						
			for (int i = 0 ; i < listFormation.size() ; i++)
				{
							
				values[i] = listFormation.get(i).getIntitule();
				
				}
			
					
			} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "La liste des formations n'a pu être importée.", "Erreur connexion base de données", JOptionPane.WARNING_MESSAGE);
			e1.printStackTrace();
			}
		
		Arrays.sort(values);
				
		this.list.setListData(values);
	
	}
	
	
	
}
