package ihm.fenetre;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ContenuAriane extends JPanel
{
	private PanelCFormation panelCFormation;

	/**
	 * Create the panel.
	 */
	public ContenuAriane(PanelCFormation panelCFormation)
	{
		this.panelCFormation = panelCFormation;

		this.setBorder(new EmptyBorder(30, 0, 30, 0));
		this.setBackground(Color.ORANGE);
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel titreAriane = new JLabel("Formation");
		titreAriane.setAlignmentX(Component.CENTER_ALIGNMENT);
		titreAriane.setForeground(Color.WHITE);
		titreAriane.setHorizontalAlignment(SwingConstants.LEFT);
		titreAriane.setMinimumSize(new Dimension(150, 20));
		titreAriane.setBorder(new EmptyBorder(10, 10, 10, 10));
		titreAriane.setFont(new Font("Arial", Font.PLAIN, 20));
		
		this.add(titreAriane);

		//chargerModule();

	}
	/*
	public void chargerModule()
	{
		if (this.panelCFormation.getFenetre().getModule().size() == 0)
		{
			JLabel lblModule = new JLabel("Aucun module pour le moment !");
			lblModule.setForeground(Color.WHITE);
			lblModule.setBorder(new EmptyBorder(30, 10, 10, 10));
			this.add(lblModule);
		}
		else
		{
			for (int i = 0; i < this.panelCFormation.getFenetre().getModule().size(); i++)
			{
				JLabel lblModule = new JLabel("Module " + (i + 1));
				lblModule.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblModule.setForeground(Color.WHITE);
				lblModule.setHorizontalAlignment(SwingConstants.LEFT);
				lblModule.setMinimumSize(new Dimension(48, 12));
				lblModule.setBorder(new EmptyBorder(30, 10, 10, 10));
				lblModule.setHorizontalTextPosition(SwingConstants.LEFT);
				lblModule.setFont(new Font("Arial", Font.PLAIN, 20));
				lblModule.setIcon(new ImageIcon("./img/icon_true.png"));
				this.add(lblModule);

				for (int j = 0; j < this.panelCFormation.getFenetre().getModule().get(i).getSequence().size(); j++)
				{
					JLabel lblSequence = new JLabel("› Sequence " + (j + 1));
					lblSequence.setAlignmentX(Component.CENTER_ALIGNMENT);
					lblSequence.setForeground(Color.WHITE);
					lblSequence.setHorizontalAlignment(SwingConstants.LEFT);
					lblSequence.setPreferredSize(new Dimension(48, 12));
					lblSequence.setBorder(new EmptyBorder(10, 10, 10, 10));
					lblSequence.setHorizontalTextPosition(SwingConstants.LEFT);
					lblSequence.setFont(new Font("Arial", Font.PLAIN, 17));
					this.add(lblSequence);

				}

			}
		}
	}
*/
	
	
	
}
