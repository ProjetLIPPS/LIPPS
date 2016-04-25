package ihm.popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import actionListener.PopupListener;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;

public class CreationModele extends JDialog {

	private JPanel contentPane;
	private JTextField textField_GRN;
	private JTextField textField_Duree;
	private JTextField textField_Intitule;
	private JTextPane jtextEmploisAccessibles;
	private JComboBox<String> comboBoxSpecialite;

	

	/**
	 * Create the frame.
	 */
	public CreationModele() 
	{
		PopupListener listener = new PopupListener();
		
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 790);
		contentPane = new JPanel();
		contentPane.setBackground(ThemeLIPPS.BLUE);
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectionnerUnModle = new JLabel("Création modèle : ");
		lblSelectionnerUnModle.setForeground(Color.WHITE);
		lblSelectionnerUnModle.setBounds(222, 48, 276, 29);
		contentPane.add(lblSelectionnerUnModle);
		lblSelectionnerUnModle.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectionnerUnModle.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_TITLE));
		
		JLabel lblIntituler = new JLabel("Intitulé :");
		lblIntituler.setForeground(Color.WHITE);
		lblIntituler.setBounds(47, 157, 72, 16);
		contentPane.add(lblIntituler);
		lblIntituler.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblGrn = new JLabel("N° GRN :");
		lblGrn.setForeground(Color.WHITE);
		lblGrn.setBounds(47, 271, 77, 16);
		contentPane.add(lblGrn);
		lblGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblEmploisAccessibles = new JLabel("Emplois accessibles :");
		lblEmploisAccessibles.setForeground(Color.WHITE);
		lblEmploisAccessibles.setBounds(134, 356, 170, 29);
		contentPane.add(lblEmploisAccessibles);
		lblEmploisAccessibles.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.WHITE);
		scrollPane_3.setBounds(134, 396, 464, 136);
		contentPane.add(scrollPane_3);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		jtextEmploisAccessibles = new JTextPane();
		jtextEmploisAccessibles.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPane_3.setViewportView(jtextEmploisAccessibles);
		
		JButton btnNewButton = new JButton("Valider");
		
		btnNewButton.addActionListener(listener);
		btnNewButton.setName("modele");
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(210, 692, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getThis().dispose();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton_1.setBounds(381, 692, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblSpcialit = new JLabel("Spécialité :");
		lblSpcialit.setForeground(Color.WHITE);
		lblSpcialit.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblSpcialit.setBounds(311, 243, 91, 22);
		contentPane.add(lblSpcialit);
		
		comboBoxSpecialite = new JComboBox<String>();
		comboBoxSpecialite.setBackground(Color.WHITE);
		comboBoxSpecialite.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		comboBoxSpecialite.setBounds(424, 241, 174, 27);
		remplirComboSpe();
		contentPane.add(comboBoxSpecialite);
		
		textField_GRN = new JTextField();
		textField_GRN.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_GRN.setBounds(134, 268, 104, 25);
		contentPane.add(textField_GRN);
		textField_GRN.setColumns(10);
		
		JLabel lblDure = new JLabel("Durée :");
		lblDure.setForeground(Color.WHITE);
		lblDure.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblDure.setBounds(47, 217, 67, 14);
		contentPane.add(lblDure);
		
		textField_Duree = new JTextField();
		textField_Duree.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_Duree.setBounds(134, 213, 104, 25);
		contentPane.add(textField_Duree);
		textField_Duree.setColumns(10);
		
		textField_Intitule = new JTextField();
		textField_Intitule.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_Intitule.setBounds(131, 156, 467, 25);
		contentPane.add(textField_Intitule);
		textField_Intitule.setColumns(10);
		
		setVisible(true);
	}
	
	private void remplirComboSpe() 
	{
		String [] nomSpe = DaoFactory.getDaoSpecialisation().getNomSpecialisation();
		
		for (int i = 0; i < nomSpe.length; i++)
		{
			comboBoxSpecialite.addItem(nomSpe[i]);
		}
		
		
	}

	public CreationModele getThis()
	{
		return this;
	}
	
	
	public JTextField getTextField_GRN() 
	{
		return textField_GRN;
	}
	public JTextField getTextField_Intitule() 
	{
		return textField_Intitule;
	}
	public JTextPane getJtextEmploisAccessibles() 
	{
		return jtextEmploisAccessibles;
	}
	public JComboBox<String> getComboBoxSpecialite()
	{
		return comboBoxSpecialite;
	}
	public JTextField getTextField_Duree()
	{
		return textField_Duree;
	}
}
