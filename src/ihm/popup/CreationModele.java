package ihm.popup;

import java.awt.Color;
import java.awt.Font;

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

import ihm.theme.ThemeLIPPS;

public class CreationModele extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	

	/**
	 * Create the frame.
	 */
	public CreationModele() {
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
		
		JTextPane champ3 = new JTextPane();
		champ3.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPane_3.setViewportView(champ3);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(381, 692, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton_1.setBounds(212, 692, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblSpcialit = new JLabel("Spécialité :");
		lblSpcialit.setForeground(Color.WHITE);
		lblSpcialit.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblSpcialit.setBounds(311, 243, 91, 22);
		contentPane.add(lblSpcialit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		comboBox.setBounds(424, 241, 174, 27);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"spe 1", "spe 2", "spe 3"}));
		
		textField = new JTextField();
		textField.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField.setBounds(134, 268, 104, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDure = new JLabel("Durée :");
		lblDure.setForeground(Color.WHITE);
		lblDure.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblDure.setBounds(47, 217, 67, 14);
		contentPane.add(lblDure);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_1.setBounds(134, 213, 104, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_2.setBounds(131, 156, 467, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
