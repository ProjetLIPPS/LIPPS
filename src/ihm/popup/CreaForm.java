package ihm.popup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import com.toedter.calendar.*;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class CreaForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaForm frame = new CreaForm();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreaForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 790);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(55, 135, 200));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelElement = new JPanel();
		panelElement.setOpaque(false);
		panelElement.setBounds(20, 26, 664, 736);
		panelElement.setBackground(Color.GRAY);
		panelElement.setPreferredSize(new Dimension(200, 550));
		contentPane.add(panelElement);
		panelElement.setLayout(null);
		
		JLabel lblSelectionnerUnModle = new JLabel("Selectionner un modèle :");
		lblSelectionnerUnModle.setForeground(Color.WHITE);
		lblSelectionnerUnModle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionnerUnModle.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblSelectionnerUnModle.setBounds(12, 0, 663, 16);
		panelElement.add(lblSelectionnerUnModle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 663, 125);
		panelElement.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Century Gothic", Font.PLAIN, 15));
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
		lblDure.setForeground(Color.WHITE);
		lblDure.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblDure.setBounds(450, 190, 66, 16);
		panelElement.add(lblDure);
		
		textField_1 = new JTextField();
		textField_1.setBounds(348, 189, 90, 22);
		panelElement.add(textField_1);
		textField_1.setColumns(5);
		
		JLabel lblHeures = new JLabel("heures");
		lblHeures.setForeground(Color.WHITE);
		lblHeures.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblHeures.setBounds(605, 190, 64, 16);
		panelElement.add(lblHeures);
		
		JLabel lblSpcialit_1 = new JLabel("Spécialité :");
		lblSpcialit_1.setForeground(Color.WHITE);
		lblSpcialit_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblSpcialit_1.setBounds(0, 190, 90, 16);
		panelElement.add(lblSpcialit_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(15);
		textField_2.setBounds(92, 189, 171, 22);
		panelElement.add(textField_2);
		
		JLabel lblGrn = new JLabel("N° GRN :");
		lblGrn.setForeground(Color.WHITE);
		lblGrn.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblGrn.setBounds(275, 191, 75, 16);
		panelElement.add(lblGrn);
		
		textField_3 = new JTextField();
		textField_3.setBounds(511, 189, 82, 22);
		panelElement.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmploisAccessibles = new JLabel("Emplois accessibles :");
		lblEmploisAccessibles.setForeground(Color.WHITE);
		lblEmploisAccessibles.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblEmploisAccessibles.setBounds(273, 236, 164, 16);
		panelElement.add(lblEmploisAccessibles);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(92, 265, 500, 80);
		panelElement.add(scrollPane_3);
		
		JTextPane champ3 = new JTextPane();
		scrollPane_3.setViewportView(champ3);
		
		JLabel lblCcp = new JLabel("CCP :");
		lblCcp.setForeground(Color.WHITE);
		lblCcp.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblCcp.setBounds(318, 358, 50, 16);
		panelElement.add(lblCcp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(92, 387, 500, 78);
		panelElement.add(scrollPane_1);
		
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(147, 554, 135, 26);
		panelElement.add(dateChooser);
		
		JLabel lblLesDates = new JLabel("Les dates :");
		lblLesDates.setForeground(Color.WHITE);
		lblLesDates.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblLesDates.setBounds(0, 554, 88, 16);
		panelElement.add(lblLesDates);
		
		JLabel lblDu = new JLabel("Du ");
		lblDu.setForeground(Color.WHITE);
		lblDu.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblDu.setBounds(100, 554, 61, 16);
		panelElement.add(lblDu);
		
		JLabel lblAu = new JLabel("Au");
		lblAu.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblAu.setForeground(Color.WHITE);
		lblAu.setBounds(325, 554, 61, 16);
		panelElement.add(lblAu);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(365, 554, 135, 26);
		panelElement.add(dateChooser_1);
		
		JLabel lblNbStages = new JLabel("Nb Stages :");
		lblNbStages.setForeground(Color.WHITE);
		lblNbStages.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNbStages.setBounds(0, 615, 101, 16);
		panelElement.add(lblNbStages);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 614, 50, 22);
		panelElement.add(textField_4);
		textField_4.setColumns(2);
		
		JButton btnNewButton = new JButton("Créer");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setBounds(161, 675, 117, 29);
		panelElement.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_1.setBounds(368, 675, 117, 29);
		panelElement.add(btnNewButton_1);
	}
}
