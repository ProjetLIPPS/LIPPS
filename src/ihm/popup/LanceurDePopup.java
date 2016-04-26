package ihm.popup;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import actionListener.PopupListener;
import model.baseDAO.DaoFactory;
import model.objet.Utilisateur;

public class LanceurDePopup extends JFrame
{

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LanceurDePopup frame = new LanceurDePopup();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public LanceurDePopup()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnCrationFormation = new JButton("Création Formation");
		btnCrationFormation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JDialog pop = new CreaForm();
			}
		});
		panel_3.add(btnCrationFormation);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnCrationModleDe = new JButton("Création Modèle de Formation");
		btnCrationModleDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JDialog pop = new CreationModele();
			}
		});
		panel_2.add(btnCrationModleDe);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnCrationCompte = new JButton("Création Compte");
		btnCrationCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JDialog pop = new CreationCompte();
			}
		});
		panel_4.add(btnCrationCompte);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCreationModule = new JButton("Creation Module");
		btnCreationModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JDialog pop = new CreationModule();
			}
		});
		btnCreationModule.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(btnCreationModule);
	}

}
