package ihm.popup;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.AbstractListModel;
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

import ihm.theme.ThemeLIPPS;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class CreaForm extends JDialog {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CreaForm() {
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(55, 135, 200));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectionnerUnModle = new JLabel("Selectionner un modèle :");
		lblSelectionnerUnModle.setBounds(153, 27, 383, 35);
		contentPane.add(lblSelectionnerUnModle);
		lblSelectionnerUnModle.setForeground(Color.WHITE);
		lblSelectionnerUnModle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionnerUnModle.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_TITLE));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 115, 584, 125);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"- modèle 1", "- modèle 2", "- modèle 3", "- modèle 4", "- modèle 1", "- modèle 2", "- modèle 3", "- modèle 4", "- modèle 1", "- modèle 2", "- modèle 3", "- modèle 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblDure = new JLabel("Durée :");
		lblDure.setBounds(201, 257, 66, 16);
		contentPane.add(lblDure);
		lblDure.setForeground(Color.WHITE);
		lblDure.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_1.setBounds(534, 254, 103, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(5);
		
		JLabel lblHeures = new JLabel("heures");
		lblHeures.setBounds(359, 257, 64, 16);
		contentPane.add(lblHeures);
		lblHeures.setForeground(Color.WHITE);
		lblHeures.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblSpcialit_1 = new JLabel("Spécialité :");
		lblSpcialit_1.setBounds(433, 255, 91, 21);
		contentPane.add(lblSpcialit_1);
		lblSpcialit_1.setForeground(Color.WHITE);
		lblSpcialit_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_2.setBounds(232, 519, 171, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(15);
		
		JLabel lblGrn = new JLabel("N° GRN :");
		lblGrn.setBounds(52, 257, 75, 16);
		contentPane.add(lblGrn);
		lblGrn.setForeground(Color.WHITE);
		lblGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_3.setBounds(267, 254, 82, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmploisAccessibles = new JLabel("Emplois accessibles :");
		lblEmploisAccessibles.setBounds(46, 320, 176, 21);
		contentPane.add(lblEmploisAccessibles);
		lblEmploisAccessibles.setForeground(Color.WHITE);
		lblEmploisAccessibles.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(232, 320, 405, 80);
		contentPane.add(scrollPane_3);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JTextPane champ3 = new JTextPane();
		champ3.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPane_3.setViewportView(champ3);
		
		JLabel lblCcp = new JLabel("CCP :");
		lblCcp.setBounds(172, 418, 50, 16);
		contentPane.add(lblCcp);
		lblCcp.setForeground(Color.WHITE);
		lblCcp.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(232, 418, 405, 78);
		contentPane.add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		scrollPane_1.setViewportView(textPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(232, 577, 135, 26);
		contentPane.add(dateChooser);
		
		JLabel lblLesDates = new JLabel("Les dates :");
		lblLesDates.setBounds(53, 587, 101, 16);
		contentPane.add(lblLesDates);
		lblLesDates.setForeground(Color.WHITE);
		lblLesDates.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblDu = new JLabel("Du ");
		lblDu.setBounds(194, 587, 28, 16);
		contentPane.add(lblDu);
		lblDu.setForeground(Color.WHITE);
		lblDu.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JLabel lblAu = new JLabel("Au");
		lblAu.setBounds(400, 587, 23, 16);
		contentPane.add(lblAu);
		lblAu.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblAu.setForeground(Color.WHITE);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(428, 577, 135, 26);
		contentPane.add(dateChooser_1);
		
		JLabel lblNbStages = new JLabel("Nombre de stages :");
		lblNbStages.setBounds(53, 517, 171, 26);
		contentPane.add(lblNbStages);
		lblNbStages.setForeground(Color.WHITE);
		lblNbStages.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textField_4.setBounds(134, 255, 50, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(2);
		
		JButton btnNewButton = new JButton("Créer");
		btnNewButton.setBounds(198, 704, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setAction(action);
		btnNewButton_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton_1.setBounds(402, 704, 117, 29);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Annuler");
			putValue(SHORT_DESCRIPTION, "Ferme cette fenetre");
		}
		public void actionPerformed(ActionEvent e) 
		{
			getThis().dispose();
		}
	}
	
	private CreaForm getThis()
	{
		return this;
	}
}
