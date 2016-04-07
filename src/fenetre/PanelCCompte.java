package fenetre;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class PanelCCompte extends JPanel
{

	/**
	 * Create the panel.
	 */
	public PanelCCompte()
	{
		setLayout(new BorderLayout(0, 0));
		
		JPanel Ariane = new JPanel();
		add(Ariane, BorderLayout.WEST);
		Ariane.setBackground(Color.DARK_GRAY);
		
		JLabel lblCePanneauNe = new JLabel("CE panneau ne sert a rien");
		lblCePanneauNe.setForeground(Color.WHITE);
		Ariane.add(lblCePanneauNe);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panel.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblComptesExistants = new JLabel("Comptes existants :");
		panelNorth.add(lblComptesExistants);
		
		JPanel panelCentre = new JPanel();
		panel.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"-Krikri", "-vivi", "-yaya", "-michmich"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		panelCentre.add(list, BorderLayout.CENTER);
		
		JPanel panelCentreSud = new JPanel();
		panelCentreSud.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelCentre.add(panelCentreSud, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelCentreSud.add(btnNewButton);
		
		JButton btnCreerUnNouveau = new JButton("Creer un nouveau compte");
		panelCentreSud.add(btnCreerUnNouveau);

	}

}
