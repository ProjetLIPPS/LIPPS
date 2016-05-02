package ihm.popup;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import actionListener.PopupListener;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;

import java.awt.event.ActionListener;

public class CreaForm extends JDialog 
{

	private JPanel contentPane;
	private JTextField textField_specialite;
	private JTextField textField_nb_stage;
	private JTextField textField_duree;
	private JTextField textField_grn;
	private JList<String> listModele;
	private JTextPane textPaneCCP;
	private JTextPane champEmploisAccessibles;
	private JDateChooser dateChooserAu;
	private JDateChooser dateChooserDu;
	private JTextField textFieldNoOffre;

	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CreaForm()
	{
		PopupListener listener = new PopupListener();
		
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(55, 135, 200));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectionnerUnModle = new JLabel("Création d'une formation");
		lblSelectionnerUnModle.setBounds(153, 27, 383, 35);
		contentPane.add(lblSelectionnerUnModle);
		lblSelectionnerUnModle.setForeground(Color.WHITE);
		lblSelectionnerUnModle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionnerUnModle.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_TITLE));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 115, 584, 125);
		contentPane.add(scrollPane);
		
		listModele = new JList<String>();
		listModele.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPane.setViewportView(listModele);
		listModele.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		remplirListeModele();
		listModele.addListSelectionListener(listener);
		
		JLabel lblDure = new JLabel("Durée :");
		lblDure.setBounds(200, 259, 64, 16);
		contentPane.add(lblDure);
		lblDure.setForeground(Color.WHITE);
		lblDure.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_specialite = new JTextField();
		textField_specialite.setEditable(false);
		textField_specialite.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_specialite.setBounds(508, 254, 129, 26);
		contentPane.add(textField_specialite);
		textField_specialite.setColumns(5);
		
		JLabel lblHeures = new JLabel("heures");
		lblHeures.setBounds(337, 259, 64, 16);
		contentPane.add(lblHeures);
		lblHeures.setForeground(Color.WHITE);
		lblHeures.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblSpcialit_1 = new JLabel("Spécialité :");
		lblSpcialit_1.setBounds(413, 257, 91, 21);
		contentPane.add(lblSpcialit_1);
		lblSpcialit_1.setForeground(Color.WHITE);
		lblSpcialit_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_nb_stage = new JTextField();
		textField_nb_stage.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_nb_stage.setBounds(232, 559, 135, 26);
		contentPane.add(textField_nb_stage);
		textField_nb_stage.setColumns(15);
		
		JLabel lblGrn = new JLabel("N° GRN :");
		lblGrn.setBounds(53, 259, 75, 16);
		contentPane.add(lblGrn);
		lblGrn.setForeground(Color.WHITE);
		lblGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_duree = new JTextField();
		textField_duree.setEditable(false);
		textField_duree.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_duree.setBounds(263, 255, 66, 26);
		contentPane.add(textField_duree);
		textField_duree.setColumns(10);
		
		JLabel lblEmploisAccessibles = new JLabel("Emplois accessibles :");
		lblEmploisAccessibles.setBounds(46, 320, 176, 21);
		contentPane.add(lblEmploisAccessibles);
		lblEmploisAccessibles.setForeground(Color.WHITE);
		lblEmploisAccessibles.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(232, 320, 405, 80);
		contentPane.add(scrollPane_3);
		
		champEmploisAccessibles = new JTextPane();
		champEmploisAccessibles.setEditable(false);
		champEmploisAccessibles.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPane_3.setViewportView(champEmploisAccessibles);
		
		JLabel lblCcp = new JLabel("CCP :");
		lblCcp.setBounds(172, 418, 50, 16);
		contentPane.add(lblCcp);
		lblCcp.setForeground(Color.WHITE);
		lblCcp.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(232, 418, 405, 78);
		contentPane.add(scrollPane_1);
		
		textPaneCCP = new JTextPane();
		textPaneCCP.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPane_1.setViewportView(textPaneCCP);
		
		dateChooserDu = new JDateChooser();
		dateChooserDu.setBounds(232, 617, 135, 26);
		contentPane.add(dateChooserDu);
		
		JLabel lblLesDates = new JLabel("Les dates :");
		lblLesDates.setBounds(56, 623, 101, 16);
		contentPane.add(lblLesDates);
		lblLesDates.setForeground(Color.WHITE);
		lblLesDates.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblDu = new JLabel("Du :");
		lblDu.setBounds(189, 623, 33, 16);
		contentPane.add(lblDu);
		lblDu.setForeground(Color.WHITE);
		lblDu.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblAu = new JLabel("Au :");
		lblAu.setBounds(390, 623, 33, 16);
		contentPane.add(lblAu);
		lblAu.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblAu.setForeground(Color.WHITE);
		
		dateChooserAu = new JDateChooser();
		dateChooserAu.setBounds(428, 617, 135, 26);
		contentPane.add(dateChooserAu);
		
		JLabel lblNbStages = new JLabel("Nombre de stages :");
		lblNbStages.setBounds(57, 559, 165, 26);
		contentPane.add(lblNbStages);
		lblNbStages.setForeground(Color.WHITE);
		lblNbStages.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_grn = new JTextField();
		textField_grn.setEditable(false);
		textField_grn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_grn.setBounds(129, 254, 50, 26);
		contentPane.add(textField_grn);
		textField_grn.setColumns(2);
		
		JButton btnNewButton = new JButton("Créer");
		
		btnNewButton.addActionListener(listener);
		btnNewButton.setName("formation");
		
		btnNewButton.setBounds(198, 704, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getThis().dispose();
			}
		});

		btnNewButton_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton_1.setBounds(402, 704, 117, 29);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel lblNewLabel = new JLabel("Sélectionner un modèle de formation :");
		lblNewLabel.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(53, 93, 324, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNoOffre = new JTextField();
		textFieldNoOffre.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textFieldNoOffre.setBounds(232, 516, 86, 26);
		contentPane.add(textFieldNoOffre);
		textFieldNoOffre.setColumns(10);
		
		JLabel lblNumeroDoffre = new JLabel("Numero d'offre :");
		lblNumeroDoffre.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblNumeroDoffre.setForeground(Color.WHITE);
		lblNumeroDoffre.setBounds(87, 513, 135, 26);
		contentPane.add(lblNumeroDoffre);
		
		setVisible(true);
	}
	
	
	private void remplirListeModele()
	{
		//TODO : finir
		//String [] nomSpe = DaoFactory.getDaoFormation().getListeNomModelesBySpe(spe);
		
		//listModele.setListData(nomSpe);
		
	}


	
	private CreaForm getThis()
	{
		return this;
	}
	public JTextField getTextField_grn() 
	{
		return textField_grn;
	}
	public JTextField getTextField_duree()
	{
		return textField_duree;
	}
	public JList<String> getListModele()
	{
		return listModele;
	}
	public JTextPane getTextPaneCCP()
	{
		return textPaneCCP;
	}
	public JTextPane getChampEmploisAccessibles()
	{
		return champEmploisAccessibles;
	}
	public JDateChooser getDateChooserAu()
	{
		return dateChooserAu;
	}
	public JTextField getTextField_nb_stage()
	{
		return textField_nb_stage;
	}
	public JDateChooser getDateChooserDu()
	{
		return dateChooserDu;
	}
	public JTextField getTextField_specialite()
	{
		return textField_specialite;
	}

	public JTextField getTextFieldNoOffre() {
		return textFieldNoOffre;
	}
	
	
	
}
