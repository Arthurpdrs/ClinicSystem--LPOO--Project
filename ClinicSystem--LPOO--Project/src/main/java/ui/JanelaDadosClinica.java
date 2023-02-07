package ui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import core.model.Clinica;
import core.services.ClinicaService;
import core.services.TextFieldService;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
public class JanelaDadosClinica {

	private JFrame frmClinicsystem;
	private JTextField nomeTextField;
	private JLabel nomeLbl;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel titulodapaginaLbl;
	private JLabel senhaLbl;
	private JLabel numeroLbl;
	private JTextField telefoneTextField;
	private JLabel emailLbl;
	private JTextField emailTextField;
	private JPasswordField senhaTextField;
	private JTextField enderecoTextField;
	private JLabel enderecoDaClinicaLbl;
	private JLabel logoMenu;

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
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaNovoRegistro.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		titulodapaginaLbl = new JLabel("Alterar dados da clínica");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(22, -1, 380, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
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
		
		nomeTextField = new JTextField(new TextFieldService(100), null, 0);
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
		
		erroLbl = new JLabel("");
		erroLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		erroLbl.setForeground(new Color(0, 102, 255));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(415, 508, 664, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
	
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
		        String nome = nomeTextField.getText();
		        String endereco = enderecoTextField.getText();
		        String telefone = telefoneTextField.getText();
		        String email = emailTextField.getText();
		        String senha = new String (senhaTextField.getPassword());
					try {
						ClinicaService clinicaService = new ClinicaService();
						if (clinicaService.atualizarDadosDaClinica(nome, email, senha, telefone, endereco) == true) {
							erroLbl.setText("Dados atualizados com sucesso");
						} else {
							erroLbl.setText("Verifique o preenchimento e formato de todos os campos");
						}
					} catch (SQLException e) {
						erroLbl.setText("Ocorreu um erro inesperado. Tente novamente");
		        }
		    }
		});
		
		senhaLbl = new JLabel("Senha do e-mail:");
		senhaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		senhaLbl.setForeground(Color.GRAY);
		senhaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		senhaLbl.setBackground(Color.WHITE);
		senhaLbl.setBounds(802, 65, 277, 24);
		frmClinicsystem.getContentPane().add(senhaLbl);
		
		numeroLbl = new JLabel("Número de telefone:");
		numeroLbl.setHorizontalAlignment(SwingConstants.LEFT);
		numeroLbl.setForeground(Color.GRAY);
		numeroLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		numeroLbl.setBackground(Color.WHITE);
		numeroLbl.setBounds(22, 161, 380, 24);
		frmClinicsystem.getContentPane().add(numeroLbl);
		
		try {
			telefoneTextField = new JFormattedTextField(new MaskFormatter("** *****-****"));
		} catch (ParseException e2) {
			erroLbl.setText("Ocorreu um erro inesperado. Tente novamente.");
		}
		telefoneTextField.setToolTipText("");
		telefoneTextField.setMargin(new Insets(10, 10, 10, 10));
		telefoneTextField.setHorizontalAlignment(SwingConstants.LEFT);
		telefoneTextField.setForeground(Color.GRAY);
		telefoneTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		telefoneTextField.setColumns(10);
		telefoneTextField.setBackground(Color.WHITE);
		telefoneTextField.setActionCommand("");
		telefoneTextField.setBounds(22, 196, 380, 50);
		telefoneTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldNumerica(telefoneTextField))) {
					erroLbl.setText("O campo telefone deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(telefoneTextField);
		
		emailLbl = new JLabel("E-mail para envio de lembretes (Outlook):");
		emailLbl.setHorizontalAlignment(SwingConstants.LEFT);
		emailLbl.setForeground(Color.GRAY);
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		emailLbl.setBackground(Color.WHITE);
		emailLbl.setBounds(412, 65, 380, 24);
		frmClinicsystem.getContentPane().add(emailLbl);
		
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
		        nomeTextField.setText("");
		        emailTextField.setText("");
		        enderecoTextField.setText("");
		        senhaTextField.setText("");
		        telefoneTextField.setText("");
		        erroLbl.setText("");
		    }
		});
		
		emailTextField = new JTextField(new TextFieldService(100), null, 0);
		emailTextField.setText("");
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
		
		senhaTextField = new JPasswordField(new TextFieldService(15), null, 0);
		senhaTextField.setBackground(Color.WHITE);
		senhaTextField.setForeground(Color.GRAY);
		senhaTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		senhaTextField.setBounds(802, 100, 277, 50);
		frmClinicsystem.getContentPane().add(senhaTextField);
		
		enderecoTextField = new JTextField(new TextFieldService(100), null, 0);
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
		
		frmClinicsystem.getContentPane().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					ClinicaService clinicaService = new ClinicaService();
					Clinica clinica = clinicaService.retornarDadosDaClinica ();
					nomeTextField.setText(clinica.getNome());
					emailTextField.setText(clinica.getEmail());
				    enderecoTextField.setText(clinica.getEndereco());
				    senhaTextField.setText(clinica.getSenha());
				    telefoneTextField.setText(clinica.getTelefone());
				} catch (SQLException e1) {
					erroLbl.setText("Ocorreu um erro ao tentar restaurar os dados. Tente novamente");
				}
			}
		});
	}
}