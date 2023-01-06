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
import java.awt.Toolkit;
public class JanelaDadosClinica {

	private JFrame frmClinicsystem;
	private JTextField nomeTextField;
	private JLabel nomeLbl;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JLabel senhaLbl;
	private JLabel especialidadeLbl;
	private JTextField numeroDeWhatsappTextField;
	private JLabel emailLbl;
	private JTextField emailTextField;
	private JPasswordField senhaPasswordField;
	private JTextField enderecoTextField;
	private JLabel enderecoDaClinicaLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDadosClinica window = new JanelaDadosClinica();
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
	public JanelaDadosClinica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaDadosClinica.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		
		titulodapaginaLbl = new JLabel("Alterar dados da clínica");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(22, -1, 380, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaDadosClinica.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		nomeLbl = new JLabel("Nome da clínica:");
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
		nomeTextField.setText("ClinicSystem");
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
		
		erroLbl = new JLabel("Dados atualizados com sucesso");
		erroLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		erroLbl.setForeground(new Color(0, 102, 255));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(415, 508, 664, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		//Botão
		JButton enviarBtn = new JButton("Enviar");
		enviarBtn.setBorderPainted(false);
		enviarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviarBtn.setBackground(new Color(255, 255, 255));
		enviarBtn.setForeground(new Color(0, 102, 255));
		enviarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		enviarBtn.setBounds(990, 553, 89, 34);
		enviarBtn.setContentAreaFilled(false);
		frmClinicsystem.getContentPane().add(enviarBtn);
		
		senhaLbl = new JLabel("Senha do e-mail:");
		senhaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLbl.setForeground(Color.GRAY);
		senhaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		senhaLbl.setBackground(Color.WHITE);
		senhaLbl.setBounds(802, 65, 277, 24);
		frmClinicsystem.getContentPane().add(senhaLbl);
		
		especialidadeLbl = new JLabel("Número de WhatsApp:");
		especialidadeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		especialidadeLbl.setForeground(Color.GRAY);
		especialidadeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		especialidadeLbl.setBackground(Color.WHITE);
		especialidadeLbl.setBounds(22, 161, 380, 24);
		frmClinicsystem.getContentPane().add(especialidadeLbl);
		
		numeroDeWhatsappTextField = new JTextField();
		numeroDeWhatsappTextField.setToolTipText("");
		numeroDeWhatsappTextField.setMargin(new Insets(10, 10, 10, 10));
		numeroDeWhatsappTextField.setHorizontalAlignment(SwingConstants.LEFT);
		numeroDeWhatsappTextField.setForeground(Color.GRAY);
		numeroDeWhatsappTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		numeroDeWhatsappTextField.setColumns(10);
		numeroDeWhatsappTextField.setBackground(Color.WHITE);
		numeroDeWhatsappTextField.setActionCommand("");
		numeroDeWhatsappTextField.setBounds(22, 196, 380, 50);
		frmClinicsystem.getContentPane().add(numeroDeWhatsappTextField);
		
		emailLbl = new JLabel("E-mail para envio de lembretes (Outlook):");
		emailLbl.setHorizontalAlignment(SwingConstants.LEFT);
		emailLbl.setForeground(Color.GRAY);
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		emailLbl.setBackground(Color.WHITE);
		emailLbl.setBounds(412, 65, 380, 24);
		frmClinicsystem.getContentPane().add(emailLbl);
		
		//Botão
		JButton limparBtn = new JButton("Limpar");
		limparBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limparBtn.setForeground(Color.GRAY);
		limparBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		limparBtn.setContentAreaFilled(false);
		limparBtn.setBorderPainted(false);
		limparBtn.setBackground(Color.WHITE);
		limparBtn.setBounds(891, 553, 89, 34);
		frmClinicsystem.getContentPane().add(limparBtn);
		
		emailTextField = new JTextField();
		emailTextField.setText("clinicsystem@hotmail.com");
		emailTextField.setToolTipText("");
		emailTextField.setMargin(new Insets(10, 10, 10, 10));
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setForeground(Color.GRAY);
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		emailTextField.setColumns(10);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setActionCommand("");
		emailTextField.setBounds(412, 100, 380, 50);
		frmClinicsystem.getContentPane().add(emailTextField);
		
		senhaPasswordField = new JPasswordField();
		senhaPasswordField.setBackground(Color.WHITE);
		senhaPasswordField.setForeground(Color.GRAY);
		senhaPasswordField.setFont(new Font("Arial", Font.PLAIN, 12));
		senhaPasswordField.setBounds(802, 100, 277, 50);
		frmClinicsystem.getContentPane().add(senhaPasswordField);
		
		enderecoTextField = new JTextField();
		enderecoTextField.setToolTipText("");
		enderecoTextField.setMargin(new Insets(10, 10, 10, 10));
		enderecoTextField.setHorizontalAlignment(SwingConstants.LEFT);
		enderecoTextField.setForeground(Color.GRAY);
		enderecoTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		enderecoTextField.setColumns(10);
		enderecoTextField.setBackground(Color.WHITE);
		enderecoTextField.setActionCommand("");
		enderecoTextField.setBounds(415, 196, 663, 50);
		frmClinicsystem.getContentPane().add(enderecoTextField);
		
		enderecoDaClinicaLbl = new JLabel("Endereço da clínica:");
		enderecoDaClinicaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		enderecoDaClinicaLbl.setForeground(Color.GRAY);
		enderecoDaClinicaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		enderecoDaClinicaLbl.setBackground(Color.WHITE);
		enderecoDaClinicaLbl.setBounds(415, 161, 663, 24);
		frmClinicsystem.getContentPane().add(enderecoDaClinicaLbl);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}