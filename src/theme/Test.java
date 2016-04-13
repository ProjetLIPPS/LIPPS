package theme;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class Test extends JFrame
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
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 475);
		contentPane = new JPanel();
		contentPane.setBackground(ThemeLIPPS.BLEU);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(ThemeLIPPS.BLEU_FONCE);
		contentPane.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnChangeLaFont = new JButton("medium");
		panel_1.add(btnChangeLaFont);
		
		JButton btnRegular = new JButton("regular");
		panel_1.add(btnRegular);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(20, 20, 0, 0));
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JLabel lblRalewayThin = new JLabel("Raleway Thin");
		lblRalewayThin.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_THIN, Font.PLAIN, 18));
		panel_2.add(lblRalewayThin);
		
		JLabel lblRalewayExtraLight = new JLabel("Raleway ExtraLight");
		lblRalewayExtraLight.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_EXTRALIGHT, Font.PLAIN, 18));
		panel_2.add(lblRalewayExtraLight);
		
		JLabel lblRalewayLight = new JLabel("Raleway Light");
		lblRalewayLight.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_LIGHT, Font.PLAIN, 18));
		panel_2.add(lblRalewayLight);
		
		JLabel lblRalewayRegular = new JLabel("Raleway Regular");
		lblRalewayRegular.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_REGULAR, Font.PLAIN, 18));
		panel_2.add(lblRalewayRegular);
		
		JLabel lblRalewayMedium = new JLabel("Raleway Medium");
		lblRalewayMedium.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_MEDIUM, Font.PLAIN, 18));
		panel_2.add(lblRalewayMedium);
		
		JLabel lblRalewaySemibold = new JLabel("Raleway SemiBold");
		lblRalewaySemibold.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_SEMIBOLD, Font.PLAIN, 18));
		panel_2.add(lblRalewaySemibold);
		
		JLabel lblRalewayBold = new JLabel("Raleway Bold");
		lblRalewayBold.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_BOLD, Font.PLAIN, 18));
		panel_2.add(lblRalewayBold);
		
		JLabel lblRalewayExtrabold = new JLabel("Raleway ExtraBold");
		lblRalewayExtrabold.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_EXTRABOLD, Font.PLAIN, 18));
		panel_2.add(lblRalewayExtrabold);
		
		JLabel lblRalewayHeavy = new JLabel("Raleway Heavy");
		lblRalewayHeavy.setFont(new Font(ThemeLIPPS.FONT_RALEWAY_HEAVY, Font.PLAIN, 18));
		panel_2.add(lblRalewayHeavy);
		
	}

	
	protected void refresh()
	{
		SwingUtilities.updateComponentTreeUI(/*panelCenterMain*/ this);
		
	}
}
