package ihm.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import ihm.theme.ThemeLIPPS;

public class CreationModule extends JDialog {

	private JPanel panelSequence;
	private ArrayList<RowSequence> listeSequence = new ArrayList<RowSequence>();
	

	
	public CreationModule() {
		getContentPane().setBackground(ThemeLIPPS.BLUE);
		setModal(true);
		setResizable(false);
		setMinimumSize(new Dimension(700, 700));
		setTitle("Créer un module");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelGlobal = new JPanel();
		panelGlobal.setOpaque(false);
		panelGlobal.setAutoscrolls(true);
		
		
		getContentPane().add(panelGlobal);
		
		panelGlobal.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		panelGlobal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		panelNorth.setBorder(new MatteBorder(0, 0, 12, 0, (Color) new Color(55, 135, 200)));
		panelNorth.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 20));
		panelNorth.setBackground(Color.WHITE);
		panelGlobal.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JLabel lblModule = new JLabel("Création d'un nouveau module");
		lblModule.setForeground(Color.WHITE);
		lblModule.setPreferredSize(new Dimension(153, 45));
		lblModule.setHorizontalAlignment(SwingConstants.CENTER);
		lblModule.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModule.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 17));
		panelNorth.add(lblModule, BorderLayout.NORTH);
		
		JTextArea labelDescription = new JTextArea();
		labelDescription.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (labelDescription.getText().equals("Entrez ici la description du module."))
				{
					labelDescription.setText("");
				}
				
			}
		});
		labelDescription.setLineWrap(true);
		labelDescription.setRows(3);
		labelDescription.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 13));
		labelDescription.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		labelDescription.setMargin(new Insets(10, 10, 10, 10));
		labelDescription.setText("Entrez ici la description du module.");
		
		panelNorth.add(labelDescription, BorderLayout.SOUTH);
		
		JLabel lblDescriptionDuModule = new JLabel("Description du module :");
		lblDescriptionDuModule.setForeground(Color.WHITE);
		lblDescriptionDuModule.setPreferredSize(new Dimension(200, 40));
		lblDescriptionDuModule.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 14));
		panelNorth.add(lblDescriptionDuModule, BorderLayout.WEST);
		
		JPanel panelBoutton = new JPanel();
		panelBoutton.setPreferredSize(new Dimension(10, 50));
		panelBoutton.setMinimumSize(new Dimension(10, 80));
		panelBoutton.setOpaque(false);
		panelBoutton.setBackground(Color.WHITE);
		panelGlobal.add(panelBoutton, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ajouter Séquence");
		btnNewButton.setBounds(152, 5, 173, 29);
		btnNewButton.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton.setBackground(Color.WHITE);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ajouterSequence();
			}
		});
		panelBoutton.setLayout(null);
		
		
		
		panelBoutton.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setBounds(384, 5, 114, 29);
		btnNewButton_1.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		btnNewButton_1.setBackground(Color.WHITE);
		panelBoutton.add(btnNewButton_1);
		
		
		
		panelSequence = new JPanel();
		panelSequence.setBackground(ThemeLIPPS.BLUE);
		panelSequence.setBorder(null);
		
		JScrollPane scrollSeq = new JScrollPane();
		scrollSeq.setEnabled(false);
		scrollSeq.setRequestFocusEnabled(false);
		scrollSeq.setIgnoreRepaint(true);
		scrollSeq.setBorder(new LineBorder(null, 0));
		scrollSeq.setBackground(ThemeLIPPS.BLUE);
		scrollSeq.setPreferredSize(new Dimension(2, 400));
		scrollSeq.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSeq.getVerticalScrollBar().setUnitIncrement(10);
		scrollSeq.setViewportView(panelSequence);
		
		panelGlobal.add(scrollSeq, BorderLayout.CENTER);
		panelSequence.setMaximumSize(new Dimension(32767, 32767));
		panelSequence.setLayout(new BoxLayout(panelSequence, BoxLayout.Y_AXIS));
		
		
		
		listeSequence.add(new RowSequence());
		ajouterSequence();
		
		
		
	}
	
	public void chargerSequence()
	{
		
		panelSequence.removeAll();
		
		for (int i = 0; i < listeSequence.size(); i++)
		{
			panelSequence.add(listeSequence.get(i));
		}
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void ajouterSequence()
	{
		
		listeSequence.add(new RowSequence(this));
		chargerSequence();
	}
	
	
	public void supprimerSequence(RowSequence seq)
	{
		listeSequence.remove(seq);
		chargerSequence();
	}
	
	
	public void monterSequence(RowSequence seq)
	{
		int position = listeSequence.indexOf(seq);
		if (position > 1)
		{
			listeSequence.remove(seq);
			listeSequence.add((position-1), seq);
			chargerSequence();
		}
	}
	
	public void descendreSequence(RowSequence seq)
	{
		int position = listeSequence.indexOf(seq);
		if (position < listeSequence.size()-1)
		{
			listeSequence.remove(seq);
			listeSequence.add((position+1), seq);
			chargerSequence();
		}
	}
	
	

}
