package fenetre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreationModule extends JFrame {

	private JPanel panelGlobal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationModule frame = new CreationModule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreationModule() {
		setResizable(false);
		setMinimumSize(new Dimension(700, 700));
		setTitle("Cr\u00E9er un module");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelGlobal = new JPanel();
		panelGlobal.setAutoscrolls(true);
		panelGlobal.setBackground(Color.decode("#3787C8"));
		JScrollPane scrollGlobal = new JScrollPane();
		scrollGlobal.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollGlobal.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollGlobal.setViewportView(panelGlobal);
		scrollGlobal.getVerticalScrollBar().setUnitIncrement(10);
		
		getContentPane().add(scrollGlobal);
		panelGlobal.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		panelGlobal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBorder(new EmptyBorder(10, 10, 50, 10));
		panelNorth.setFont(new Font("Arial", Font.PLAIN, 20));
		panelNorth.setBackground(Color.WHITE);
		panelGlobal.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JLabel lblModule = new JLabel("Cr\u00E9ation d'un nouveau module :");
		lblModule.setPreferredSize(new Dimension(153, 45));
		lblModule.setHorizontalAlignment(SwingConstants.CENTER);
		lblModule.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModule.setFont(new Font("Arial", Font.PLAIN, 17));
		panelNorth.add(lblModule, BorderLayout.NORTH);
		
		JTextArea labelDescription = new JTextArea();
		labelDescription.setLineWrap(true);
		labelDescription.setRows(3);
		labelDescription.setFont(new Font("Arial", Font.PLAIN, 13));
		labelDescription.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		labelDescription.setMargin(new Insets(10, 10, 10, 10));
		labelDescription.setText("Effectuer les op\u00E9rations d'entretient des VL et des VUL, poser des accessoires");
		panelNorth.add(labelDescription, BorderLayout.SOUTH);
		
		JLabel lblDescriptionDuModule = new JLabel("Description du module :");
		lblDescriptionDuModule.setPreferredSize(new Dimension(200, 40));
		lblDescriptionDuModule.setFont(new Font("Arial", Font.PLAIN, 14));
		panelNorth.add(lblDescriptionDuModule, BorderLayout.WEST);
		
		JPanel panelBoutton = new JPanel();
		panelBoutton.setOpaque(false);
		panelBoutton.setBackground(Color.WHITE);
		panelGlobal.add(panelBoutton, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ajouter S\u00E9quence");
		
		btnNewButton.setBackground(Color.WHITE);
		panelBoutton.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider le module");
		btnNewButton_1.setBackground(Color.WHITE);
		panelBoutton.add(btnNewButton_1);
		
		JPanel panelSequence = new JPanel();
		panelSequence.setOpaque(false);
		panelSequence.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelGlobal.add(panelSequence, BorderLayout.CENTER);
		panelSequence.setBackground(Color.WHITE);
		panelSequence.setMaximumSize(new Dimension(32767, 32767));
		panelSequence.setLayout(new BoxLayout(panelSequence, BoxLayout.Y_AXIS));
		
		
		JPanel sequenceTitre = new JPanel();
		sequenceTitre.setMaximumSize(new Dimension(32767, 60));
		sequenceTitre.setBorder(new MatteBorder(12, 0, 0, 0, (Color) new Color(55, 135, 200)));
		sequenceTitre.setBackground(Color.WHITE);
		sequenceTitre.setAlignmentX(0.0f);
		panelSequence.add(sequenceTitre);
		
		JLabel lblEnregistrementDesSquences = new JLabel("Enregistrement des s\u00E9quences :");
		lblEnregistrementDesSquences.setFont(new Font("Arial", Font.PLAIN, 17));
		sequenceTitre.add(lblEnregistrementDesSquences);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				panelSequence.add(new RowSequence());
			}
		});
		
		
		
		
		panelSequence.add(new RowSequence());
		
		
		
		

		//SwingUtilities.updateComponentTreeUI(/*panelCenterMain*/ this);
		
	}

}
