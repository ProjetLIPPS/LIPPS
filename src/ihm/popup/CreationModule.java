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

import actionListener.PopupListener;
import ihm.theme.ThemeLIPPS;

public class CreationModule extends JDialog {

	private JPanel panelSequence;
	private ArrayList<RowSequence> listeRowSequence = new ArrayList<RowSequence>();
	private JTextArea textAreaDescription;
	
	private PopupListener listener = null;

	
	public CreationModule(/*PopupListener listener*/)
	{
		this.listener = listener;
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
		
		textAreaDescription = new JTextArea();
		textAreaDescription.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (textAreaDescription.getText().equals("Entrez ici la description du module."))
				{
					textAreaDescription.setText("");
				}
				
			}
		});
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setRows(3);
		textAreaDescription.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, 13));
		textAreaDescription.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		textAreaDescription.setMargin(new Insets(10, 10, 10, 10));
		textAreaDescription.setText("Entrez ici la description du module.");
		
		panelNorth.add(textAreaDescription, BorderLayout.SOUTH);
		
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
		
		btnNewButton_1.addActionListener(listener);
		btnNewButton_1.setName("module");
		
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
		
		
		
		listeRowSequence.add(new RowSequence());
		ajouterSequence();
		
		
		
	}
	
	public void chargerSequence()
	{
		
		panelSequence.removeAll();
		
		for (int i = 0; i < listeRowSequence.size(); i++)
		{
			panelSequence.add(listeRowSequence.get(i));
		}
		
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void ajouterSequence()
	{
		
		listeRowSequence.add(new RowSequence(this));
		chargerSequence();
	}
	
	
	public void supprimerSequence(RowSequence seq)
	{
		listeRowSequence.remove(seq);
		chargerSequence();
	}
	
	
	public void monterSequence(RowSequence seq)
	{
		int position = listeRowSequence.indexOf(seq);
		if (position > 1)
		{
			listeRowSequence.remove(seq);
			listeRowSequence.add((position-1), seq);
			chargerSequence();
		}
	}
	
	public void descendreSequence(RowSequence seq)
	{
		int position = listeRowSequence.indexOf(seq);
		if (position < listeRowSequence.size()-1)
		{
			listeRowSequence.remove(seq);
			listeRowSequence.add((position+1), seq);
			chargerSequence();
		}
	}
	
	

	public JTextArea getTextAreaDescription() 
	{
		return textAreaDescription;
	}

	public ArrayList<RowSequence> getListeSequence() {
		return listeRowSequence;
	}
	
	
}
