package ui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaCadastrarProfissional {

	private JFrame frmClinicsystem;
	private JTextField nomeTextField;
	private JLabel nomeLbl;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JLabel usuarioLbl;
	private JTextField usuarioTextField;
	private JLabel senhaLbl;
	private JLabel funcaoLbl;
	private JLabel especialidadeLbl;
	private JTextField especialidadeTextField;
	private JLabel emailLbl;
	private JTextField emailTextField;
	private JComboBox funcaoComboBox;
	private JPasswordField senhaPasswordField;
	private JTextField crmTextField;
	private JTextField telefoneTextField;

	/**
	 * Launch the application.
	 */
	
	public JFrame getJanela() {
		return this.frmClinicsystem;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarProfissional window = new JanelaCadastrarProfissional();
					window.frmClinicsystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaCadastrarProfissional() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaCadastrarProfissional.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		titulodapaginaLbl = new JLabel("Cadastrar profissional");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(22, -1, 380, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaCadastrarProfissional.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		nomeLbl = new JLabel("*Nome completo:");
		nomeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLbl.setBackground(Color.WHITE);
		nomeLbl.setForeground(Color.GRAY);
		nomeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		nomeLbl.setBounds(22, 65, 380, 24);
		frmClinicsystem.getContentPane().add(nomeLbl);
		
		barraAzul = new JLabel("");
		barraAzul.setBackground(new Color(0, 102, 255));
		barraAzul.setBounds(-1, -1, 1131, 55);
		barraAzul.setOpaque(true);
		frmClinicsystem.getContentPane().add(barraAzul);
		
		nomeTextField = new JTextField();
		nomeTextField.setToolTipText("");
		nomeTextField.setActionCommand("");
		nomeTextField.setBackground(Color.WHITE);
		nomeTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		nomeTextField.setForeground(Color.GRAY);
		nomeTextField.setMargin(new Insets(10, 10, 10, 10));
		nomeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nomeTextField.setBounds(22, 100, 380, 50);
		nomeTextField.setColumns(10);
		frmClinicsystem.getContentPane().add(nomeTextField);
		
		erroLbl = new JLabel("Preencha todos os campos obrigat??rios (Indicados pelo * )");
		erroLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		erroLbl.setForeground(new Color(0, 102, 255));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(415, 508, 664, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		//Bot??o
		JButton enviarBtn = new JButton("Enviar");
		enviarBtn.setBorderPainted(false);
		enviarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviarBtn.setBackground(new Color(255, 255, 255));
		enviarBtn.setForeground(new Color(0, 102, 255));
		enviarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		enviarBtn.setBounds(990, 553, 89, 34);
		enviarBtn.setContentAreaFilled(false);
		frmClinicsystem.getContentPane().add(enviarBtn);
		
		enviarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        //Inserir a????o aqui
		    }
		});
		
		usuarioLbl = new JLabel("*Usu??rio:");
		usuarioLbl.setHorizontalAlignment(SwingConstants.LEFT);
		usuarioLbl.setForeground(Color.GRAY);
		usuarioLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		usuarioLbl.setBackground(Color.WHITE);
		usuarioLbl.setBounds(412, 65, 380, 24);
		frmClinicsystem.getContentPane().add(usuarioLbl);
		
		usuarioTextField = new JTextField();
		usuarioTextField.setToolTipText("");
		usuarioTextField.setMargin(new Insets(10, 10, 10, 10));
		usuarioTextField.setHorizontalAlignment(SwingConstants.LEFT);
		usuarioTextField.setForeground(Color.GRAY);
		usuarioTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		usuarioTextField.setColumns(10);
		usuarioTextField.setBackground(Color.WHITE);
		usuarioTextField.setActionCommand("");
		usuarioTextField.setBounds(412, 100, 380, 50);
		frmClinicsystem.getContentPane().add(usuarioTextField);
		
		senhaLbl = new JLabel("*Senha:");
		senhaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLbl.setForeground(Color.GRAY);
		senhaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		senhaLbl.setBackground(Color.WHITE);
		senhaLbl.setBounds(802, 65, 277, 24);
		frmClinicsystem.getContentPane().add(senhaLbl);
		
		funcaoLbl = new JLabel("*Fun????o:");
		funcaoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		funcaoLbl.setForeground(Color.GRAY);
		funcaoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		funcaoLbl.setBackground(Color.WHITE);
		funcaoLbl.setBounds(22, 161, 380, 24);
		frmClinicsystem.getContentPane().add(funcaoLbl);
		
		especialidadeLbl = new JLabel("Especialidade:");
		especialidadeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		especialidadeLbl.setForeground(Color.GRAY);
		especialidadeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		especialidadeLbl.setBackground(Color.WHITE);
		especialidadeLbl.setBounds(415, 257, 380, 24);
		frmClinicsystem.getContentPane().add(especialidadeLbl);
		
		especialidadeTextField = new JTextField();
		especialidadeTextField.setToolTipText("");
		especialidadeTextField.setMargin(new Insets(10, 10, 10, 10));
		especialidadeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		especialidadeTextField.setForeground(Color.GRAY);
		especialidadeTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		especialidadeTextField.setColumns(10);
		especialidadeTextField.setBackground(Color.WHITE);
		especialidadeTextField.setActionCommand("");
		especialidadeTextField.setBounds(415, 292, 380, 50);
		frmClinicsystem.getContentPane().add(especialidadeTextField);
		
		emailLbl = new JLabel("*E-mail:");
		emailLbl.setHorizontalAlignment(SwingConstants.LEFT);
		emailLbl.setForeground(Color.GRAY);
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		emailLbl.setBackground(Color.WHITE);
		emailLbl.setBounds(802, 161, 277, 24);
		frmClinicsystem.getContentPane().add(emailLbl);
		
		//Bot??o
		JButton limparBtn = new JButton("Limpar");
		limparBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limparBtn.setForeground(Color.GRAY);
		limparBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		limparBtn.setContentAreaFilled(false);
		limparBtn.setBorderPainted(false);
		limparBtn.setBackground(Color.WHITE);
		limparBtn.setBounds(891, 553, 89, 34);
		frmClinicsystem.getContentPane().add(limparBtn);
		
		limparBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        //Inserir a????o aqui
		    }
		});
		
		emailTextField = new JTextField();
		emailTextField.setToolTipText("");
		emailTextField.setMargin(new Insets(10, 10, 10, 10));
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setForeground(Color.GRAY);
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		emailTextField.setColumns(10);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setActionCommand("");
		emailTextField.setBounds(802, 196, 277, 50);
		frmClinicsystem.getContentPane().add(emailTextField);
		
		funcaoComboBox = new JComboBox();
		funcaoComboBox.setBackground(Color.WHITE);
		funcaoComboBox.setForeground(Color.GRAY);
		funcaoComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		funcaoComboBox.setModel(new DefaultComboBoxModel(new String[] {"RECEPCIONISTA", "M??DICO(A)"}));
		funcaoComboBox.setBounds(22, 196, 380, 50);
		frmClinicsystem.getContentPane().add(funcaoComboBox);
		
		senhaPasswordField = new JPasswordField();
		senhaPasswordField.setBackground(Color.WHITE);
		senhaPasswordField.setForeground(Color.GRAY);
		senhaPasswordField.setFont(new Font("Arial", Font.PLAIN, 12));
		senhaPasswordField.setBounds(802, 100, 277, 50);
		frmClinicsystem.getContentPane().add(senhaPasswordField);
		
		crmTextField = new JTextField();
		crmTextField.setToolTipText("");
		crmTextField.setMargin(new Insets(10, 10, 10, 10));
		crmTextField.setHorizontalAlignment(SwingConstants.LEFT);
		crmTextField.setForeground(Color.GRAY);
		crmTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		crmTextField.setColumns(10);
		crmTextField.setBackground(Color.WHITE);
		crmTextField.setActionCommand("");
		crmTextField.setBounds(22, 292, 380, 50);
		frmClinicsystem.getContentPane().add(crmTextField);
		
		JLabel crmLbl = new JLabel("CRM:");
		crmLbl.setHorizontalAlignment(SwingConstants.LEFT);
		crmLbl.setForeground(Color.GRAY);
		crmLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		crmLbl.setBackground(Color.WHITE);
		crmLbl.setBounds(22, 257, 380, 24);
		frmClinicsystem.getContentPane().add(crmLbl);
		
		telefoneTextField = new JTextField();
		telefoneTextField.setToolTipText("");
		telefoneTextField.setMargin(new Insets(10, 10, 10, 10));
		telefoneTextField.setHorizontalAlignment(SwingConstants.LEFT);
		telefoneTextField.setForeground(Color.GRAY);
		telefoneTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		telefoneTextField.setColumns(10);
		telefoneTextField.setBackground(Color.WHITE);
		telefoneTextField.setActionCommand("");
		telefoneTextField.setBounds(415, 196, 380, 50);
		frmClinicsystem.getContentPane().add(telefoneTextField);
		
		JLabel telefoneLbl = new JLabel("*Telefone:");
		telefoneLbl.setHorizontalAlignment(SwingConstants.LEFT);
		telefoneLbl.setForeground(Color.GRAY);
		telefoneLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		telefoneLbl.setBackground(Color.WHITE);
		telefoneLbl.setBounds(415, 161, 380, 24);
		frmClinicsystem.getContentPane().add(telefoneLbl);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}