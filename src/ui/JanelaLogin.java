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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaLogin {

	private JFrame frmClinicsystem;
	private JTextField usuarioTextField;
	private JLabel usuarioLbl;
	private JLabel fotoInicial;
	private JLabel erroLbl;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogin window = new JanelaLogin();
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
	public JanelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaLogin.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		usuarioLbl = new JLabel("Usuário:");
		usuarioLbl.setHorizontalAlignment(SwingConstants.LEFT);
		usuarioLbl.setBackground(Color.WHITE);
		usuarioLbl.setForeground(Color.GRAY);
		usuarioLbl.setOpaque(true);
		usuarioLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		usuarioLbl.setBounds(699, 263, 380, 14);
		frmClinicsystem.getContentPane().add(usuarioLbl);
		
		JLabel logoInicial = new JLabel("");
		logoInicial.setIcon(new ImageIcon(JanelaLogin.class.getResource("/midia/logo_inicio.png")));
		logoInicial.setBounds(688, 79, 380, 120);
		frmClinicsystem.getContentPane().add(logoInicial);
		
		usuarioTextField = new JTextField();
		usuarioTextField.setToolTipText("Usuário");
		usuarioTextField.setActionCommand("");
		usuarioTextField.setBackground(Color.WHITE);
		usuarioTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		usuarioTextField.setForeground(Color.GRAY);
		usuarioTextField.setMargin(new Insets(10, 10, 10, 10));
		usuarioTextField.setHorizontalAlignment(SwingConstants.LEFT);
		usuarioTextField.setBounds(699, 285, 380, 50);
		usuarioTextField.setColumns(10);
		frmClinicsystem.getContentPane().add(usuarioTextField);
		
		fotoInicial = new JLabel("");
		fotoInicial.setIcon(new ImageIcon(JanelaLogin.class.getResource("/midia/foto_inicio.png")));
		fotoInicial.setBounds(37, 110, 588, 434);
		frmClinicsystem.getContentPane().add(fotoInicial);
		
		erroLbl = new JLabel("Ocorreu um erro inesperado. Tente novamente.");
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.CENTER);
		erroLbl.setForeground(new Color(0, 102, 204));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(699, 195, 380, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Senha");
		passwordField.setCaretColor(Color.GRAY);
		passwordField.setMargin(new Insets(10, 10, 10, 10));
		passwordField.setBounds(699, 401, 380, 50);
		frmClinicsystem.getContentPane().add(passwordField);
		
		JLabel senhaLbl = new JLabel("Senha:");
		senhaLbl.setOpaque(true);
		senhaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLbl.setForeground(Color.GRAY);
		senhaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		senhaLbl.setBackground(Color.WHITE);
		senhaLbl.setBounds(699, 376, 380, 14);
		frmClinicsystem.getContentPane().add(senhaLbl);
		
		//Botão
		JButton entrarBtn = new JButton("Entrar");
		entrarBtn.setBorderPainted(false);
		entrarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		entrarBtn.setBackground(new Color(255, 255, 255));
		entrarBtn.setForeground(new Color(0, 102, 255));
		entrarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		entrarBtn.setBounds(839, 507, 89, 34);
		entrarBtn.setContentAreaFilled(false);
		frmClinicsystem.getContentPane().add(entrarBtn);
		
		entrarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        //Inserir ação aqui
		 
		    	//Janela principal Admin
		    	JanelaPrincipalAdmin janelaAdministrador = new JanelaPrincipalAdmin();
		    	janelaAdministrador.getJanela().setVisible(true);
		    	
		    	//Janela principal Recepcionista
		    	JanelaPrincipalRecepcionista janelaRecepcionista = new JanelaPrincipalRecepcionista();
		    	janelaRecepcionista.getJanela().setVisible(true);
		    	
		    	//Janela principal Médico
		    	JanelaPrincipalMedico janelaMedico = new JanelaPrincipalMedico();
		    	janelaMedico.getJanela().setVisible(true);
		    	
		    	//Esconde a janela de login
		    	frmClinicsystem.dispose();
		    }
		});
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
