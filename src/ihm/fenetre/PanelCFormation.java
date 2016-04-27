package ihm.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import actionListener.PanelCFormationListener;
import ihm.popup.CreaForm;
import ihm.theme.ThemeLIPPS;
import model.baseDAO.DaoFactory;
import model.objet.Formation;
import model.objet.Utilisateur;


public class PanelCFormation extends JPanel
{
	private JTextField txtIntitule;
	private JTextField txtDuree;
	private JTextField txtSpe;
	private JTextField txtGrn;
	private JTextField txtOffre;
	private JTextField txtNbStage;
	private JTextArea textCcp;
	private JTextArea textDebouche;
	private JList<String> list = new JList<String>(); 
	
	private PanelCFormationListener panelCFormationListSelectionListener = new PanelCFormationListener(this);

	
	/**
	 * Create the panel.
	 */
	
	public PanelCFormation()
	{
				
		setMinimumSize(new Dimension(400, 10));
		
		
		this.setBorder(null);
		this.setBackground(ThemeLIPPS.BLUE);
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(ThemeLIPPS.BLUE_DARK);
		panelLeft.setPreferredSize(new Dimension(300, 10));
		add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLabel = new JPanel();
		panelLabel.setPreferredSize(new Dimension(10, 50));
		panelLabel.setBackground(ThemeLIPPS.BLUE_DARK);
		panelLeft.add(panelLabel, BorderLayout.NORTH);
		panelLabel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblMesFormations = new JLabel("Mes Formations");
		lblMesFormations.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMesFormations.setForeground(Color.WHITE);
		panelLabel.add(lblMesFormations);
		lblMesFormations.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_TITLE));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 150));
		
		JPanel panelJlist = new JPanel();
		panelJlist.setOpaque(false);
		panelJlist.setBorder(new EmptyBorder(20, 10, 0, 2));
		panelJlist.setBackground(ThemeLIPPS.BLUE_DARK);
		panelLeft.add(panelJlist, BorderLayout.CENTER);
		panelJlist.setLayout(new BorderLayout(0, 0));
		
		list = new JList<String>();
		list.setVisibleRowCount(5);
		list.setFixedCellHeight(40);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setForeground(Color.WHITE);
		list.setBackground(ThemeLIPPS.BLUE_DARK);
		list.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.BOLD, ThemeLIPPS.FONT_SIZE_DEFAULT));
		//initList();
				
				
		list.addListSelectionListener(panelCFormationListSelectionListener);
		panelJlist.add(list, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(list);
		panelJlist.add(scrollPane, BorderLayout.NORTH);
		
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.WHITE);
		add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBox = new JPanel();
		panelBox.setBorder(new EmptyBorder(20, 0, 10, 0));
		panelBox.setBackground(Color.WHITE);
		panelBox.setPreferredSize(new Dimension(10, 550));
		panelRight.add(panelBox, BorderLayout.CENTER);
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		
		JPanel panelFlow1stLine = new JPanel();
		panelBox.add(panelFlow1stLine);
		panelFlow1stLine.setBorder(new EmptyBorder(0, 0, 5, 0));
		panelFlow1stLine.setMinimumSize(new Dimension(10, 20));
		panelFlow1stLine.setPreferredSize(new Dimension(0, 0));
		panelFlow1stLine.setBackground(Color.WHITE);
		panelFlow1stLine.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblIntitul = new JLabel("Intitulé:");
		panelFlow1stLine.add(lblIntitul);
		lblIntitul.setMinimumSize(new Dimension(38, 50));
		lblIntitul.setForeground(Color.BLACK);
		lblIntitul.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panelFlow1stLine.add(rigidArea);
		rigidArea.setPreferredSize(new Dimension(5, 5));
		
		txtIntitule = new JTextField();
		panelFlow1stLine.add(txtIntitule);
		txtIntitule.setMinimumSize(new Dimension(6, 50));
		txtIntitule.setText("Développeur Logiciel");
		txtIntitule.setEditable(false);
		txtIntitule.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtIntitule.setColumns(25);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow1stLine.add(rigidArea_4);
		rigidArea_4.setPreferredSize(new Dimension(45, 20));
		
		JLabel lblSpcialit = new JLabel("Spécialité:");
		panelFlow1stLine.add(lblSpcialit);
		lblSpcialit.setMinimumSize(new Dimension(49, 50));
		lblSpcialit.setForeground(Color.BLACK);
		lblSpcialit.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow1stLine.add(rigidArea_1);
		rigidArea_1.setPreferredSize(new Dimension(5, 5));
		
		txtSpe = new JTextField();
		panelFlow1stLine.add(txtSpe);
		txtSpe.setMinimumSize(new Dimension(6, 50));
		txtSpe.setText("Informatique");
		txtSpe.setEditable(false);
		txtSpe.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtSpe.setColumns(10);
		
		JPanel panelFlow2ndLine = new JPanel();
		panelBox.add(panelFlow2ndLine);
		panelFlow2ndLine.setBorder(new EmptyBorder(0, 0, 5, 0));
		panelFlow2ndLine.setMinimumSize(new Dimension(10, 20));
		panelFlow2ndLine.setPreferredSize(new Dimension(0, 0));
		panelFlow2ndLine.setBackground(Color.WHITE);
		
		JLabel lblNGrn = new JLabel("N° GRN:");
		panelFlow2ndLine.add(lblNGrn);
		lblNGrn.setForeground(Color.BLACK);
		lblNGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_6);
		rigidArea_6.setPreferredSize(new Dimension(5, 5));
		
		txtGrn = new JTextField();
		panelFlow2ndLine.add(txtGrn);
		txtGrn.setText("123456");
		txtGrn.setEditable(false);
		txtGrn.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtGrn.setColumns(10);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_8);
		rigidArea_8.setPreferredSize(new Dimension(45, 20));
		
		JLabel lblNDoffre = new JLabel("N° d'offre:");
		panelFlow2ndLine.add(lblNDoffre);
		lblNDoffre.setForeground(Color.BLACK);
		lblNDoffre.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_7);
		rigidArea_7.setPreferredSize(new Dimension(5, 20));
		
		txtOffre = new JTextField();
		panelFlow2ndLine.add(txtOffre);
		txtOffre.setText("654321");
		txtOffre.setEditable(false);
		txtOffre.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtOffre.setColumns(7);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_5);
		rigidArea_5.setPreferredSize(new Dimension(40, 20));
		
		JLabel lblDure = new JLabel("Durée:");
		panelFlow2ndLine.add(lblDure);
		lblDure.setForeground(Color.BLACK);
		lblDure.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_2);
		rigidArea_2.setPreferredSize(new Dimension(5, 5));
		
		txtDuree = new JTextField();
		panelFlow2ndLine.add(txtDuree);
		txtDuree.setText("1295\r\n");
		txtDuree.setEditable(false);
		txtDuree.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtDuree.setColumns(6);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow2ndLine.add(rigidArea_3);
		rigidArea_3.setPreferredSize(new Dimension(5, 5));
		
		JLabel lblHeures = new JLabel("heures");
		panelFlow2ndLine.add(lblHeures);
		lblHeures.setForeground(Color.BLACK);
		lblHeures.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		JPanel panelFlow3rdLine = new JPanel();
		panelBox.add(panelFlow3rdLine);
		panelFlow3rdLine.setBorder(new EmptyBorder(0, 0, 5, 0));
		panelFlow3rdLine.setPreferredSize(new Dimension(0, 0));
		panelFlow3rdLine.setBackground(Color.WHITE);
		
		JLabel lblNombdreDeStages = new JLabel("Nombre de stages:");
		panelFlow3rdLine.add(lblNombdreDeStages);
		lblNombdreDeStages.setForeground(Color.BLACK);
		lblNombdreDeStages.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		panelFlow3rdLine.add(rigidArea_9);
		rigidArea_9.setPreferredSize(new Dimension(5, 5));
		
		txtNbStage = new JTextField();
		panelFlow3rdLine.add(txtNbStage);
		txtNbStage.setText("1");
		txtNbStage.setEditable(false);
		txtNbStage.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		txtNbStage.setColumns(2);
		
		JPanel panelCcpDebGridLbl = new JPanel();
		panelBox.add(panelCcpDebGridLbl);
		panelCcpDebGridLbl.setBackground(Color.WHITE);
		panelCcpDebGridLbl.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblCcp = new JLabel("CCP:");
		lblCcp.setForeground(Color.BLACK);
		lblCcp.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		lblCcp.setPreferredSize(new Dimension(0, 0));
		panelCcpDebGridLbl.add(lblCcp);
		lblCcp.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDbouchs = new JLabel("Débouchés:");
		lblDbouchs.setPreferredSize(new Dimension(0, 0));
		lblDbouchs.setForeground(Color.BLACK);
		lblDbouchs.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		panelCcpDebGridLbl.add(lblDbouchs);
		lblDbouchs.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelCcpDebTxt = new JPanel();
		panelBox.add(panelCcpDebTxt);
		panelCcpDebTxt.setBackground(Color.WHITE);
		panelCcpDebTxt.setLayout(new GridLayout(0, 2, 10, 0));
		
			
		textCcp = new JTextArea();
		textCcp.setTabSize(10);
		textCcp.setEditable(false);
		textCcp.setText("Sed ut tum ad senem senex de senectute, sic hoc libro ad amicum amicissimus scripsi de amicitia. Tum est Cato locutus, quo erat nemo fere senior temporibus illis, nemo prudentior; nunc Laelius et sapiens (sic enim est habitus) et amicitiae gloria excellens de amicitia loquetur. Tu velim a me animum parumper avertas, Laelium loqui ipsum putes. C. Fannius et Q. Mucius ad socerum veniunt post mortem Africani; ab his sermo oritur, respondet Laelius, cuius tota disputatio est de amicitia, quam legens te ipse cognosces.\r\n\r\nAc ne quis a nobis hoc ita dici forte miretur, quod alia quaedam in hoc facultas sit ingeni, neque haec dicendi ratio aut disciplina, ne nos quidem huic uni studio penitus umquam dediti fuimus. Etenim omnes artes, quae ad humanitatem pertinent, habent quoddam commune vinculum, et quasi cognatione quadam inter se continentur.\r\n\r\nSed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?\r\n\r\nEt quia Mesopotamiae tractus omnes crebro inquietari sueti praetenturis et stationibus servabantur agrariis, laevorsum flexo itinere Osdroenae subsederat extimas partes, novum parumque aliquando temptatum commentum adgressus. quod si impetrasset, fulminis modo cuncta vastarat. erat autem quod cogitabat huius modi.\r\n\r\nHoc inmaturo interitu ipse quoque sui pertaesus excessit e vita aetatis nono anno atque vicensimo cum quadriennio imperasset. natus apud Tuscos in Massa Veternensi, patre Constantio Constantini fratre imperatoris, matreque Galla sorore Rufini et Cerealis, quos trabeae consulares nobilitarunt et praefecturae.\r\nSed ut tum ad senem senex de senectute, sic hoc libro ad amicum amicissimus scripsi de amicitia. Tum est Cato locutus, quo erat nemo fere senior temporibus illis, nemo prudentior; nunc Laelius et sapiens (sic enim est habitus) et amicitiae gloria excellens de amicitia loquetur. Tu velim a me animum parumper avertas, Laelium loqui ipsum putes. C. Fannius et Q. Mucius ad socerum veniunt post mortem Africani; ab his sermo oritur, respondet Laelius, cuius tota disputatio est de amicitia, quam legens te ipse cognosces.\r\n\r\nAc ne quis a nobis hoc ita dici forte miretur, quod alia quaedam in hoc facultas sit ingeni, neque haec dicendi ratio aut disciplina, ne nos quidem huic uni studio penitus umquam dediti fuimus. Etenim omnes artes, quae ad humanitatem pertinent, habent quoddam commune vinculum, et quasi cognatione quadam inter se continentur.\r\n\r\nSed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?\r\n\r\nEt quia Mesopotamiae tractus omnes crebro inquietari sueti praetenturis et stationibus servabantur agrariis, laevorsum flexo itinere Osdroenae subsederat extimas partes, novum parumque aliquando temptatum commentum adgressus. quod si impetrasset, fulminis modo cuncta vastarat. erat autem quod cogitabat huius modi.\r\n\r\nHoc inmaturo interitu ipse quoque sui pertaesus excessit e vita aetatis nono anno atque vicensimo cum quadriennio imperasset. natus apud Tuscos in Massa Veternensi, patre Constantio Constantini fratre imperatoris, matreque Galla sorore Rufini et Cerealis, quos trabeae consulares nobilitarunt et praefecturae.");
		textCcp.setPreferredSize(new Dimension(0, 0));
		textCcp.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textCcp.setRows(7);
		textCcp.setLineWrap(true);
		textCcp.setColumns(20);
		
		JScrollPane scrollPaneCcp = new JScrollPane();
		scrollPaneCcp.setOpaque(false);
		scrollPaneCcp.setViewportView(textCcp);
		
		panelCcpDebTxt.add(scrollPaneCcp);
		
				
		textDebouche = new JTextArea();
		textDebouche.setTabSize(10);
		textDebouche.setText("Sed ut tum ad senem senex de senectute, sic hoc libro ad amicum amicissimus scripsi de amicitia. Tum est Cato locutus, quo erat nemo fere senior temporibus illis, nemo prudentior; nunc Laelius et sapiens (sic enim est habitus) et amicitiae gloria excellens de amicitia loquetur. Tu velim a me animum parumper avertas, Laelium loqui ipsum putes. C. Fannius et Q. Mucius ad socerum veniunt post mortem Africani; ab his sermo oritur, respondet Laelius, cuius tota disputatio est de amicitia, quam legens te ipse cognosces.\r\n\r\nAc ne quis a nobis hoc ita dici forte miretur, quod alia quaedam in hoc facultas sit ingeni, neque haec dicendi ratio aut disciplina, ne nos quidem huic uni studio penitus umquam dediti fuimus. Etenim omnes artes, quae ad humanitatem pertinent, habent quoddam commune vinculum, et quasi cognatione quadam inter se continentur.\r\n\r\nSed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?\r\n\r\nEt quia Mesopotamiae tractus omnes crebro inquietari sueti praetenturis et stationibus servabantur agrariis, laevorsum flexo itinere Osdroenae subsederat extimas partes, novum parumque aliquando temptatum commentum adgressus. quod si impetrasset, fulminis modo cuncta vastarat. erat autem quod cogitabat huius modi.\r\n\r\nHoc inmaturo interitu ipse quoque sui pertaesus excessit e vita aetatis nono anno atque vicensimo cum quadriennio imperasset. natus apud Tuscos in Massa Veternensi, patre Constantio Constantini fratre imperatoris, matreque Galla sorore Rufini et Cerealis, quos trabeae consulares nobilitarunt et praefecturae.");
		textDebouche.setLineWrap(true);
		textDebouche.setEditable(false);
		textDebouche.setPreferredSize(new Dimension(0, 0));
		textDebouche.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_DEFAULT));
		textDebouche.setColumns(20);
		textDebouche.setRows(7);
		
		JScrollPane scrollPaneDeb = new JScrollPane();
		panelCcpDebTxt.add(scrollPaneDeb);
		scrollPaneDeb.setViewportView(textDebouche);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 15));
		panelBox.add(verticalStrut);
		
		JPanel panelBtn_1 = new JPanel();
		panelBtn_1.setOpaque(false);
		panelBox.add(panelBtn_1);
		panelBtn_1.setLayout(new BoxLayout(panelBtn_1, BoxLayout.X_AXIS));
		
		JButton btnCrerOuvelleFormation = new JButton("Créer nouvelle formation");
		btnCrerOuvelleFormation.setMnemonic('n');
		btnCrerOuvelleFormation.setFont(new Font(ThemeLIPPS.FONT_DEFAULT, Font.PLAIN, ThemeLIPPS.FONT_SIZE_BUTTON));
		
		btnCrerOuvelleFormation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CreaForm newFormation = new CreaForm();
			}
		});

		panelBtn_1.add(btnCrerOuvelleFormation);
		

	}
	
/*public void initList() {
		
		String[] values = null;
		
		try {
			
			// simulation objet user actuellement loggé
			Utilisateur user = DaoFactory.getDaoUtilisateur().findById(Utilisateur.class, 1);
			
			List<Formation> listFormation = (List) DaoFactory.getDaoFormation().readAllFormationFromUser(user.getId());
			
			values = new String[listFormation.size()];
						
			for (int i = 0 ; i < listFormation.size() ; i++)
				{
				
				values[i] = listFormation.get(i).getIntitule();
				
				}
			
					
			} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "La liste des formations n'a pu être importée.", "Erreur connexion base de données", JOptionPane.WARNING_MESSAGE);
			e1.printStackTrace();
			}
		
		Arrays.sort(values);
				
		this.list.setListData(values);
	
	}*/


	public JTextField getTxtIntitule() {
		return txtIntitule;
	}


	public JTextField getTxtDuree() {
		return txtDuree;
	}


	public JTextField getTxtSpe() {
		return txtSpe;
	}


	public JTextField getTxtGrn() {
		return txtGrn;
	}


	public JTextField getTxtOffre() {
		return txtOffre;
	}


	public JTextField getTxtNbStage() {
		return txtNbStage;
	}

	public JTextArea getTextCcp() {
		return textCcp;
	}
	
	public JTextArea getTextDebouche() {
		return textDebouche;
	}
	
	
}
