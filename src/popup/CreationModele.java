package popup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class CreationModele extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationModele frame = new CreationModele();
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
	public CreationModele() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 790);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelElement = new JPanel();
		panelElement.setBounds(20, 26, 663, 736);
		panelElement.setBackground(Color.WHITE);
		panelElement.setPreferredSize(new Dimension(200, 550));
		contentPane.add(panelElement);
		panelElement.setLayout(null);
		
		JLabel lblSelectionnerUnModle = new JLabel("Edition modèle : ");
		lblSelectionnerUnModle.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectionnerUnModle.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSelectionnerUnModle.setBounds(193, 0, 124, 16);
		panelElement.add(lblSelectionnerUnModle);
		
		JLabel lblNumrodescription = new JLabel("Numéro/description");
		lblNumrodescription.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNumrodescription.setForeground(Color.GRAY);
		lblNumrodescription.setBounds(329, 1, 155, 16);
		panelElement.add(lblNumrodescription);
		
		JLabel lblIntituler = new JLabel("Intituler :");
		lblIntituler.setFont(new Font("Arial", Font.PLAIN, 15));
		lblIntituler.setBounds(12, 86, 56, 16);
		panelElement.add(lblIntituler);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(80, 86, 571, 45);
		panelElement.add(scrollPane_1);
		
		JTextPane champ1 = new JTextPane();
		scrollPane_1.setViewportView(champ1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 150, 639, 12);
		panelElement.add(separator_1);
		
		JLabel lblGrn = new JLabel("N° GRN :");
		lblGrn.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGrn.setBounds(12, 184, 75, 16);
		panelElement.add(lblGrn);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(91, 184, 560, 45);
		panelElement.add(scrollPane_2);
		
		JTextPane champ2 = new JTextPane();
		scrollPane_2.setViewportView(champ2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 253, 639, 12);
		panelElement.add(separator_2);
		
		JLabel lblEmploisAccessibles = new JLabel("Emplois accessibles :");
		lblEmploisAccessibles.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmploisAccessibles.setBounds(12, 292, 143, 16);
		panelElement.add(lblEmploisAccessibles);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(12, 322, 639, 80);
		panelElement.add(scrollPane_3);
		
		JTextPane champ3 = new JTextPane();
		scrollPane_3.setViewportView(champ3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(159, 520, 135, 26);
		panelElement.add(dateChooser);
		
		JLabel lblLesDates = new JLabel("Les dates :");
		lblLesDates.setBounds(12, 520, 75, 16);
		panelElement.add(lblLesDates);
		
		JLabel lblDu = new JLabel("Du ");
		lblDu.setBounds(112, 520, 61, 16);
		panelElement.add(lblDu);
		
		JLabel lblAu = new JLabel("Au");
		lblAu.setBounds(337, 520, 61, 16);
		panelElement.add(lblAu);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(377, 520, 135, 26);
		panelElement.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(159, 694, 117, 29);
		panelElement.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBounds(366, 694, 117, 29);
		panelElement.add(btnNewButton_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 428, 639, 12);
		panelElement.add(separator_3);
		
		JLabel lblSpcialit = new JLabel("Spécialité :");
		lblSpcialit.setBounds(12, 457, 80, 16);
		panelElement.add(lblSpcialit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"spe 1", "spe 2", "spe 3"}));
		comboBox.setBounds(107, 457, 150, 27);
		panelElement.add(comboBox);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(12, 573, 639, 12);
		panelElement.add(separator_5);
	}
}
