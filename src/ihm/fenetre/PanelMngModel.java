package ihm.fenetre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

import ihm.theme.ThemeLIPPS;


public class PanelMngModel extends JPanel
{
	private JTextField txtDveloppeurLogiciel;
	private JTextField textField_1;
	private JTextField txtInformatique;
	private JTextField textField_3;

	
	/**
	 * Create the panel.
	 */
	public PanelMngModel()
	{
		setMinimumSize(new Dimension(400, 10));
		
		
		this.setBorder(null);
		this.setBackground(ThemeLIPPS.BLUE);
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.decode("#003C6E"));
		panelLeft.setPreferredSize(new Dimension(350, 10));
		add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLeftMargin = new JPanel();
		panelLeftMargin.setMinimumSize(new Dimension(0, 10));
		panelLeftMargin.setBackground(Color.decode("#003C6E"));
		panelLeft.add(panelLeftMargin, BorderLayout.WEST);
		panelLeftMargin.setPreferredSize(new Dimension(50, 10));
		
		JPanel panelLabel = new JPanel();
		panelLabel.setBackground(Color.decode("#003C6E"));
		panelLeft.add(panelLabel, BorderLayout.NORTH);
		panelLabel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMesFormations = new JLabel("Modèles");
		lblMesFormations.setForeground(Color.WHITE);
		panelLabel.add(lblMesFormations, BorderLayout.NORTH);
		lblMesFormations.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblMesFormations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesFormations.setPreferredSize(new Dimension(75, 150));
		
		JPanel panelJlist = new JPanel();
		panelJlist.setBackground(Color.decode("#003C6E"));
		panelLeft.add(panelJlist, BorderLayout.CENTER);
		panelJlist.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setOpaque(false);
		list.setVisibleRowCount(5);
		list.setFixedCellHeight(40);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setForeground(Color.WHITE);
		list.setBackground(Color.decode("#003C6E"));
		list.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panelJlist.add(list);
		
		String[] values = new String[] {"Test1", "Test2", "Test3"};
		list.setListData(values); 
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelBtn.setBackground(Color.decode("#003C6E"));
		panelLeft.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnCrerNouvelleFormation = new JButton("Créer nouveau modèle");
		btnCrerNouvelleFormation.setOpaque(false);
		btnCrerNouvelleFormation.setMnemonic('n');
		btnCrerNouvelleFormation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panelBtn.add(btnCrerNouvelleFormation);
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.WHITE);
		add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTrio = new JPanel();
		panelTrio.setBackground(Color.WHITE);
		panelTrio.setPreferredSize(new Dimension(10, 550));
		panelRight.add(panelTrio, BorderLayout.CENTER);
		panelTrio.setLayout(new BoxLayout(panelTrio, BoxLayout.Y_AXIS));
		
		JPanel panelTrioMargin = new JPanel();
		panelTrioMargin.setOpaque(false);
		panelTrioMargin.setBackground(Color.WHITE);
		panelTrioMargin.setBackground(Color.decode("#3787C8"));
		panelTrioMargin.setPreferredSize(new Dimension(10, 28));
		panelTrio.add(panelTrioMargin);
		
		JPanel panelBox = new JPanel();
		panelBox.setBorder(new EmptyBorder(0, 25, 0, 25));
		panelBox.setBackground(Color.WHITE);
		panelTrio.add(panelBox);
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		
		JPanel panelFlow1stLine = new JPanel();
		panelFlow1stLine.setBorder(new EmptyBorder(0, 0, 5, 0));
		panelFlow1stLine.setMinimumSize(new Dimension(10, 20));
		panelFlow1stLine.setPreferredSize(new Dimension(0, 0));
		panelFlow1stLine.setBackground(Color.WHITE);
		panelBox.add(panelFlow1stLine);
		panelFlow1stLine.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box horizontalBox1 = Box.createHorizontalBox();
		horizontalBox1.setMinimumSize(new Dimension(0, 100));
		panelFlow1stLine.add(horizontalBox1);
		horizontalBox1.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JLabel lblIntitul = new JLabel("Intitulé:");
		lblIntitul.setMinimumSize(new Dimension(38, 50));
		lblIntitul.setForeground(Color.BLACK);
		lblIntitul.setFont(new Font("Century Gothic", Font.BOLD, 14));
		horizontalBox1.add(lblIntitul);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(5, 5));
		horizontalBox1.add(rigidArea);
		
		txtDveloppeurLogiciel = new JTextField();
		txtDveloppeurLogiciel.setMinimumSize(new Dimension(6, 50));
		txtDveloppeurLogiciel.setText("Développeur Logiciel");
		txtDveloppeurLogiciel.setEditable(false);
		txtDveloppeurLogiciel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		horizontalBox1.add(txtDveloppeurLogiciel);
		txtDveloppeurLogiciel.setColumns(25);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4.setPreferredSize(new Dimension(45, 20));
		horizontalBox1.add(rigidArea_4);
		
		JLabel lblSpcialit = new JLabel("Spécialité:");
		lblSpcialit.setMinimumSize(new Dimension(49, 50));
		lblSpcialit.setForeground(Color.BLACK);
		lblSpcialit.setFont(new Font("Century Gothic", Font.BOLD, 14));
		horizontalBox1.add(lblSpcialit);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(5, 5));
		horizontalBox1.add(rigidArea_1);
		
		txtInformatique = new JTextField();
		txtInformatique.setMinimumSize(new Dimension(6, 50));
		txtInformatique.setText("Informatique");
		txtInformatique.setEditable(false);
		txtInformatique.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		horizontalBox1.add(txtInformatique);
		txtInformatique.setColumns(10);
		
		JPanel panelFlow2ndLine = new JPanel();
		panelFlow2ndLine.setMinimumSize(new Dimension(10, 20));
		panelFlow2ndLine.setPreferredSize(new Dimension(0, 0));
		panelFlow2ndLine.setBackground(Color.WHITE);
		panelBox.add(panelFlow2ndLine);
		
		Box horizontalBox2 = Box.createHorizontalBox();
		horizontalBox2.setMinimumSize(new Dimension(0, 20));
		panelFlow2ndLine.add(horizontalBox2);
		
		JLabel lblNGrn = new JLabel("N° GRN:");
		lblNGrn.setForeground(Color.BLACK);
		lblNGrn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		horizontalBox2.add(lblNGrn);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_6.setPreferredSize(new Dimension(5, 5));
		horizontalBox2.add(rigidArea_6);
		
		textField_3 = new JTextField();
		textField_3.setText("123456");
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		horizontalBox2.add(textField_3);
		textField_3.setColumns(10);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_8.setPreferredSize(new Dimension(45, 20));
		horizontalBox2.add(rigidArea_8);
		
		JLabel lblDure = new JLabel("Durée:");
		lblDure.setForeground(Color.BLACK);
		lblDure.setFont(new Font("Century Gothic", Font.BOLD, 14));
		horizontalBox2.add(lblDure);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox2.add(rigidArea_2);
		rigidArea_2.setPreferredSize(new Dimension(5, 5));
		
		textField_1 = new JTextField();
		textField_1.setText("1295\r\n");
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		horizontalBox2.add(textField_1);
		textField_1.setColumns(6);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox2.add(rigidArea_3);
		rigidArea_3.setPreferredSize(new Dimension(5, 5));
		
		JLabel lblHeures = new JLabel("heures");
		lblHeures.setForeground(Color.BLACK);
		lblHeures.setFont(new Font("Century Gothic", Font.BOLD, 14));
		horizontalBox2.add(lblHeures);
		
		JPanel panelCcpDebGridLbl = new JPanel();
		panelCcpDebGridLbl.setBackground(Color.WHITE);
		panelBox.add(panelCcpDebGridLbl);
		panelCcpDebGridLbl.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblCcp = new JLabel("CCP:");
		lblCcp.setForeground(Color.BLACK);
		lblCcp.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCcp.setPreferredSize(new Dimension(0, 0));
		panelCcpDebGridLbl.add(lblCcp);
		lblCcp.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDbouchs = new JLabel("Débouchés:");
		lblDbouchs.setPreferredSize(new Dimension(0, 0));
		lblDbouchs.setForeground(Color.BLACK);
		lblDbouchs.setFont(new Font("Century Gothic", Font.BOLD, 14));
		panelCcpDebGridLbl.add(lblDbouchs);
		lblDbouchs.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelCcpDebTxt = new JPanel();
		panelCcpDebTxt.setBackground(Color.WHITE);
		panelBox.add(panelCcpDebTxt);
		panelCcpDebTxt.setLayout(new GridLayout(0, 2, 10, 0));
		
		JScrollPane scrollPaneCcp = new JScrollPane();
		scrollPaneCcp.setOpaque(false);
		panelCcpDebTxt.add(scrollPaneCcp);
		
		JTextArea textCcp = new JTextArea();
		textCcp.setTabSize(10);
		textCcp.setEditable(false);
		textCcp.setText("Sed ut tum ad senem senex de senectute, sic hoc libro ad amicum amicissimus scripsi de amicitia. Tum est Cato locutus, quo erat nemo fere senior temporibus illis, nemo prudentior; nunc Laelius et sapiens (sic enim est habitus) et amicitiae gloria excellens de amicitia loquetur. Tu velim a me animum parumper avertas, Laelium loqui ipsum putes. C. Fannius et Q. Mucius ad socerum veniunt post mortem Africani; ab his sermo oritur, respondet Laelius, cuius tota disputatio est de amicitia, quam legens te ipse cognosces.\r\n\r\nAc ne quis a nobis hoc ita dici forte miretur, quod alia quaedam in hoc facultas sit ingeni, neque haec dicendi ratio aut disciplina, ne nos quidem huic uni studio penitus umquam dediti fuimus. Etenim omnes artes, quae ad humanitatem pertinent, habent quoddam commune vinculum, et quasi cognatione quadam inter se continentur.\r\n\r\nSed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?\r\n\r\nEt quia Mesopotamiae tractus omnes crebro inquietari sueti praetenturis et stationibus servabantur agrariis, laevorsum flexo itinere Osdroenae subsederat extimas partes, novum parumque aliquando temptatum commentum adgressus. quod si impetrasset, fulminis modo cuncta vastarat. erat autem quod cogitabat huius modi.\r\n\r\nHoc inmaturo interitu ipse quoque sui pertaesus excessit e vita aetatis nono anno atque vicensimo cum quadriennio imperasset. natus apud Tuscos in Massa Veternensi, patre Constantio Constantini fratre imperatoris, matreque Galla sorore Rufini et Cerealis, quos trabeae consulares nobilitarunt et praefecturae.\r\nSed ut tum ad senem senex de senectute, sic hoc libro ad amicum amicissimus scripsi de amicitia. Tum est Cato locutus, quo erat nemo fere senior temporibus illis, nemo prudentior; nunc Laelius et sapiens (sic enim est habitus) et amicitiae gloria excellens de amicitia loquetur. Tu velim a me animum parumper avertas, Laelium loqui ipsum putes. C. Fannius et Q. Mucius ad socerum veniunt post mortem Africani; ab his sermo oritur, respondet Laelius, cuius tota disputatio est de amicitia, quam legens te ipse cognosces.\r\n\r\nAc ne quis a nobis hoc ita dici forte miretur, quod alia quaedam in hoc facultas sit ingeni, neque haec dicendi ratio aut disciplina, ne nos quidem huic uni studio penitus umquam dediti fuimus. Etenim omnes artes, quae ad humanitatem pertinent, habent quoddam commune vinculum, et quasi cognatione quadam inter se continentur.\r\n\r\nSed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?\r\n\r\nEt quia Mesopotamiae tractus omnes crebro inquietari sueti praetenturis et stationibus servabantur agrariis, laevorsum flexo itinere Osdroenae subsederat extimas partes, novum parumque aliquando temptatum commentum adgressus. quod si impetrasset, fulminis modo cuncta vastarat. erat autem quod cogitabat huius modi.\r\n\r\nHoc inmaturo interitu ipse quoque sui pertaesus excessit e vita aetatis nono anno atque vicensimo cum quadriennio imperasset. natus apud Tuscos in Massa Veternensi, patre Constantio Constantini fratre imperatoris, matreque Galla sorore Rufini et Cerealis, quos trabeae consulares nobilitarunt et praefecturae.");
		textCcp.setPreferredSize(new Dimension(0, 0));
		textCcp.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneCcp.setViewportView(textCcp);
		textCcp.setRows(7);
		textCcp.setLineWrap(true);
		textCcp.setColumns(20);
		
		JScrollPane scrollPaneDeb = new JScrollPane();
		panelCcpDebTxt.add(scrollPaneDeb);
		
		JTextArea textDebouche = new JTextArea();
		textDebouche.setTabSize(10);
		textDebouche.setText("Sed ut tum ad senem senex de senectute, sic hoc libro ad amicum amicissimus scripsi de amicitia. Tum est Cato locutus, quo erat nemo fere senior temporibus illis, nemo prudentior; nunc Laelius et sapiens (sic enim est habitus) et amicitiae gloria excellens de amicitia loquetur. Tu velim a me animum parumper avertas, Laelium loqui ipsum putes. C. Fannius et Q. Mucius ad socerum veniunt post mortem Africani; ab his sermo oritur, respondet Laelius, cuius tota disputatio est de amicitia, quam legens te ipse cognosces.\r\n\r\nAc ne quis a nobis hoc ita dici forte miretur, quod alia quaedam in hoc facultas sit ingeni, neque haec dicendi ratio aut disciplina, ne nos quidem huic uni studio penitus umquam dediti fuimus. Etenim omnes artes, quae ad humanitatem pertinent, habent quoddam commune vinculum, et quasi cognatione quadam inter se continentur.\r\n\r\nSed si ille hac tam eximia fortuna propter utilitatem rei publicae frui non properat, ut omnia illa conficiat, quid ego, senator, facere debeo, quem, etiamsi ille aliud vellet, rei publicae consulere oporteret?\r\n\r\nEt quia Mesopotamiae tractus omnes crebro inquietari sueti praetenturis et stationibus servabantur agrariis, laevorsum flexo itinere Osdroenae subsederat extimas partes, novum parumque aliquando temptatum commentum adgressus. quod si impetrasset, fulminis modo cuncta vastarat. erat autem quod cogitabat huius modi.\r\n\r\nHoc inmaturo interitu ipse quoque sui pertaesus excessit e vita aetatis nono anno atque vicensimo cum quadriennio imperasset. natus apud Tuscos in Massa Veternensi, patre Constantio Constantini fratre imperatoris, matreque Galla sorore Rufini et Cerealis, quos trabeae consulares nobilitarunt et praefecturae.");
		textDebouche.setLineWrap(true);
		textDebouche.setEditable(false);
		textDebouche.setPreferredSize(new Dimension(0, 0));
		textDebouche.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneDeb.setViewportView(textDebouche);
		textDebouche.setColumns(20);
		textDebouche.setRows(7);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 150));
		panelBox.add(verticalStrut);
		
		JPanel panelButton = new JPanel();
		panelButton.setBorder(new EmptyBorder(0, 0, 10, 0));
		panelButton.setBackground(Color.WHITE);
		panelRight.add(panelButton, BorderLayout.SOUTH);
		
		JButton btnCrerModule = new JButton("Éditer");
		btnCrerModule.setMnemonic('c');
		btnCrerModule.setOpaque(false);
		btnCrerModule.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCrerModule.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCrerModule.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnCrerModule.setMnemonic('m');
		panelButton.add(btnCrerModule);
		
		JButton btnditerFormation = new JButton("Supprimer");
		btnditerFormation.setMnemonic('e');
		btnditerFormation.setOpaque(false);
		btnditerFormation.setMnemonic('f');
		btnditerFormation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panelButton.add(btnditerFormation);
	}

	
}
