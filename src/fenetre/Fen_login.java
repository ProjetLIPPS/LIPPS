package fenetre;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Fen_login extends JFrame {
	private JTextField txtEmail;
	private JPasswordField pwdMotDePasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_login frame = new Fen_login();
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
	public Fen_login() {
		
		
		
		setTitle("LIPPS - Connexion");
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/60x60.gif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		txtEmail.setText("Email");
		txtEmail.setBounds(125, 230, 200, 35);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		pwdMotDePasse = new JPasswordField();
		pwdMotDePasse.setFont(new Font("Arial", Font.PLAIN, 16));
		pwdMotDePasse.setText("Mot de passe");
		pwdMotDePasse.setBounds(125, 313, 200, 35);
		getContentPane().add(pwdMotDePasse);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(125, 192, 80, 35);
		getContentPane().add(lblEmail);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMotDePasse.setBounds(125, 276, 110, 35);
		getContentPane().add(lblMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConnexion.setBounds(165, 404, 120, 34);
		getContentPane().add(btnConnexion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./img/Logo_couleur_200x76.png"));
		label.setBounds(125, 70, 200, 76);
		getContentPane().add(label);
		
		JLabel lblMotDePasse_1 = new JLabel("Mot de passe oubli\u00E9 ?");
		lblMotDePasse_1.setForeground(Color.BLUE);
		lblMotDePasse_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMotDePasse_1.setBounds(162, 359, 123, 14);
		getContentPane().add(lblMotDePasse_1);
	}
}
