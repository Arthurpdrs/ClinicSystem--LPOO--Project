package ui;

import java.awt.Insets;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import core.services.FuncionarioService;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class JanelaLogin {

	JFrame frmClinicsystem;
	private JTextField usuarioTextField;
	private JLabel usuarioLbl;
	private JLabel fotoInicial;
	private JLabel erroLbl;
	private JPasswordField senhaTextField;

	public JFrame getJanela() {
		return this.frmClinicsystem;
	}
	
	public JanelaLogin() {
		initialize();
	}
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
		
		erroLbl = new JLabel("");
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.CENTER);
		erroLbl.setForeground(new Color(0, 102, 204));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(699, 195, 380, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		senhaTextField = new JPasswordField();
		senhaTextField.setToolTipText("Senha");
		senhaTextField.setCaretColor(Color.GRAY);
		senhaTextField.setMargin(new Insets(10, 10, 10, 10));
		senhaTextField.setBounds(699, 401, 380, 50);
		frmClinicsystem.getContentPane().add(senhaTextField);
		
		JLabel senhaLbl = new JLabel("Senha:");
		senhaLbl.setOpaque(true);
		senhaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLbl.setForeground(Color.GRAY);
		senhaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		senhaLbl.setBackground(Color.WHITE);
		senhaLbl.setBounds(699, 376, 380, 14);
		frmClinicsystem.getContentPane().add(senhaLbl);
		
		
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
		    	System.clearProperty("cpf_logado");
		    	System.clearProperty("cargo");
		    	String login = usuarioTextField.getText().toLowerCase().trim();
		    	String senha = new String(senhaTextField.getPassword());
		    	
		        try {
		        	FuncionarioService funcionarioService = new FuncionarioService();
					if (funcionarioService.fazerLogin(login, senha)) {
						erroLbl.setText("Login realizado com sucesso");
						String cargo = System.getProperty("cargo");
						if (cargo.equals("Recepcionista")) {
							JanelaPrincipalRecepcionista janelaRecepcionista = new JanelaPrincipalRecepcionista();
					    	janelaRecepcionista.getJanela().setVisible(true);
						} else if (cargo.equals("Medico")) {
							JanelaPrincipalMedico janelaMedico = new JanelaPrincipalMedico();
					    	janelaMedico.getJanela().setVisible(true);
						} else {
							JanelaPrincipalAdmin janelaAdministrador = new JanelaPrincipalAdmin();
					    	janelaAdministrador.getJanela().setVisible(true);
						}
						frmClinicsystem.dispose();
					} else {
						erroLbl.setText("Verifique os valores informados");
					}
			
				} catch (SQLException e) {
					erroLbl.setText("Ocorreu um erro inesperado. Tente novamente.");
				}
		    }
		});
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
