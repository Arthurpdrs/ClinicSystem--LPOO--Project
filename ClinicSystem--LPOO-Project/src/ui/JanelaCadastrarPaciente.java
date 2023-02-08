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

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import core.model.Responsavel;
import core.services.EnderecoService;
import core.services.PacienteService;
import core.services.ResponsavelService;
import core.services.TextFieldService;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JanelaCadastrarPaciente {

	private JFrame frmClinicsystem;
	private JTextField nomeTextField;
	private JLabel nomeLbl;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JLabel logradouroLbl;
	private JTextField logradouroTextField;
	private JLabel cpfLbl;
	private JTextField cpfTextField;
	private JLabel emailLbl;
	private JTextField emailTextField;
	private JLabel CelularLbl;
	private JTextField celularTextField;
	private JLabel alergiaLbl;
	private JTextField alergiaTextField;
	private JLabel observacaoLbl;
	private JTextField observacaoTextField;
	private JLabel tipoSanguineoLbl;
	private JComboBox tipoSanguineoComboBox;
	private JLabel dataDeNascimentoLbl;
	private JTextField dataTextField;
	private JTextField responsavelNomeCompletoTextField;
	private JLabel NomeCompletoResponsavelLbl;
	private JTextField responsavelCelularTextField;
	private JLabel celularResponsavelLbl;
	private JTextField responsavelCpfTextField;
	private JLabel cpfResponsavelLbl;
	private JTextField numeroTextField;
	private JLabel numeroLbl;
	private JTextField bairroTextField;
	private JLabel bairroLbl;
	private JTextField cidadeTextField;
	private JLabel cidadeLbl;
	private JTextField cepTextField;
	private JLabel cepLbl;

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
					JanelaCadastrarPaciente window = new JanelaCadastrarPaciente();
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
	public JanelaCadastrarPaciente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaCadastrarPaciente.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		titulodapaginaLbl = new JLabel("Cadastrar paciente");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(22, -1, 380, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaCadastrarPaciente.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		nomeLbl = new JLabel("*Nome completo:");
		nomeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLbl.setBackground(Color.WHITE);
		nomeLbl.setForeground(Color.GRAY);
		nomeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		nomeLbl.setBounds(22, 65, 277, 24);
		frmClinicsystem.getContentPane().add(nomeLbl);
		
		barraAzul = new JLabel("");
		barraAzul.setBackground(new Color(0, 102, 255));
		barraAzul.setBounds(-1, -1, 1131, 55);
		barraAzul.setOpaque(true);
		frmClinicsystem.getContentPane().add(barraAzul);
		
		nomeTextField = new JTextField(new TextFieldService(100), null, 0);
		nomeTextField.setToolTipText("");
		nomeTextField.setActionCommand("");
		nomeTextField.setBackground(Color.WHITE);
		nomeTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		nomeTextField.setForeground(Color.GRAY);
		nomeTextField.setMargin(new Insets(10, 10, 10, 10));
		nomeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nomeTextField.setBounds(22, 100, 277, 50);
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
		
		enviarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        
		    	String nome = nomeTextField.getText();
		        String email = emailTextField.getText();
		        String cpf = cpfTextField.getText();
		        String tipoSanguineo = (String) tipoSanguineoComboBox.getSelectedItem();
		        String alergia = alergiaTextField.getText();
		        String celular = celularTextField.getText();
		        String observacao = observacaoTextField.getText();
		        String dataDeNascimento = dataTextField.getText();
		        String logradouro = logradouroTextField.getText().toLowerCase();
		        String numero = numeroTextField.getText();
		        String bairro = bairroTextField.getText();
		        String cidade = cidadeTextField.getText();
		        String cep = cepTextField.getText();
		        String nomeResponsavel = responsavelNomeCompletoTextField.getText();
		        String celularResponsavel = responsavelCelularTextField.getText();
		        String cpfResponsavel = responsavelCpfTextField.getText();
		        
		        PacienteService paciente = new PacienteService();
		        String endereco = EnderecoService.montarEndereco(logradouro, numero, bairro, cidade, cep);
		        ResponsavelService responsavelService = new ResponsavelService();
		        Responsavel responsavel = null;
		        
		        if (endereco.length() > 100) {
		        	erroLbl.setText("O endereço ultrapassa cem caracteres");
		        }
		        if(!(nomeResponsavel.isBlank() && celularResponsavel.isBlank() && cpfResponsavel.isBlank())) {
		        	
		        	try {
						responsavel = responsavelService.inserir(nomeResponsavel, cpfResponsavel, celularResponsavel);
					} catch (SQLException e) {
						e.printStackTrace();
					}
		        }
				try {
					paciente.cadastrar(nome, celular, email, cpf, tipoSanguineo, alergia, dataDeNascimento, endereco, observacao, responsavel);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		        
		    }
		});
		
		logradouroLbl = new JLabel("Logradouro:");
		logradouroLbl.setHorizontalAlignment(SwingConstants.LEFT);
		logradouroLbl.setForeground(Color.GRAY);
		logradouroLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		logradouroLbl.setBackground(Color.WHITE);
		logradouroLbl.setBounds(22, 257, 277, 24);
		frmClinicsystem.getContentPane().add(logradouroLbl);
		
		logradouroTextField = new JTextField(new TextFieldService(100), null, 0);
		logradouroTextField.setToolTipText("");
		logradouroTextField.setMargin(new Insets(10, 10, 10, 10));
		logradouroTextField.setHorizontalAlignment(SwingConstants.LEFT);
		logradouroTextField.setForeground(Color.GRAY);
		logradouroTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		logradouroTextField.setColumns(10);
		logradouroTextField.setBackground(Color.WHITE);
		logradouroTextField.setActionCommand("");
		logradouroTextField.setBounds(22, 292, 277, 50);
		frmClinicsystem.getContentPane().add(logradouroTextField);
		
		cpfLbl = new JLabel("*CPF:");
		cpfLbl.setHorizontalAlignment(SwingConstants.LEFT);
		cpfLbl.setForeground(Color.GRAY);
		cpfLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		cpfLbl.setBackground(Color.WHITE);
		cpfLbl.setBounds(596, 65, 277, 24);
		frmClinicsystem.getContentPane().add(cpfLbl);
		
		cpfTextField = new JTextField(new TextFieldService(11), null, 0);
		cpfTextField.setToolTipText("");
		cpfTextField.setMargin(new Insets(10, 10, 10, 10));
		cpfTextField.setHorizontalAlignment(SwingConstants.LEFT);
		cpfTextField.setForeground(Color.GRAY);
		cpfTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		cpfTextField.setColumns(10);
		cpfTextField.setBackground(Color.WHITE);
		cpfTextField.setActionCommand("");
		cpfTextField.setBounds(596, 100, 277, 50);
		cpfTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldNumerica(cpfTextField))) {
					erroLbl.setText("O campo CPF deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(cpfTextField);
		
		emailLbl = new JLabel("*E-mail:");
		emailLbl.setHorizontalAlignment(SwingConstants.LEFT);
		emailLbl.setForeground(Color.GRAY);
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		emailLbl.setBackground(Color.WHITE);
		emailLbl.setBounds(309, 65, 225, 24);
		frmClinicsystem.getContentPane().add(emailLbl);
		
		emailTextField = new JTextField(new TextFieldService(100), null, 0);
		emailTextField.setToolTipText("");
		emailTextField.setMargin(new Insets(10, 10, 10, 10));
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setForeground(Color.GRAY);
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		emailTextField.setColumns(10);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setActionCommand("");
		emailTextField.setBounds(309, 100, 277, 50);
		frmClinicsystem.getContentPane().add(emailTextField);
		
		CelularLbl = new JLabel("*Celular:");
		CelularLbl.setHorizontalAlignment(SwingConstants.LEFT);
		CelularLbl.setForeground(Color.GRAY);
		CelularLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		CelularLbl.setBackground(Color.WHITE);
		CelularLbl.setBounds(309, 161, 277, 24);
		frmClinicsystem.getContentPane().add(CelularLbl);
		
		try {
			celularTextField = new JFormattedTextField(new MaskFormatter("** *****-****"));
		} catch (ParseException e1) {
			erroLbl.setText("Ocorreu um erro inesperado");
		}
		celularTextField.setToolTipText("");
		celularTextField.setMargin(new Insets(10, 10, 10, 10));
		celularTextField.setHorizontalAlignment(SwingConstants.LEFT);
		celularTextField.setForeground(Color.GRAY);
		celularTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		celularTextField.setColumns(10);
		celularTextField.setBackground(Color.WHITE);
		celularTextField.setActionCommand("");
		celularTextField.setBounds(309, 196, 277, 50);
		celularTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldNumerica(celularTextField))) {
					erroLbl.setText("O campo de celular deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(celularTextField);
		
		alergiaLbl = new JLabel("Alergia:");
		alergiaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		alergiaLbl.setForeground(Color.GRAY);
		alergiaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		alergiaLbl.setBackground(Color.WHITE);
		alergiaLbl.setBounds(22, 161, 277, 24);
		frmClinicsystem.getContentPane().add(alergiaLbl);
		
		alergiaTextField = new JTextField(new TextFieldService(100), null, 0);
		alergiaTextField.setToolTipText("");
		alergiaTextField.setMargin(new Insets(10, 10, 10, 10));
		alergiaTextField.setHorizontalAlignment(SwingConstants.LEFT);
		alergiaTextField.setForeground(Color.GRAY);
		alergiaTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		alergiaTextField.setColumns(10);
		alergiaTextField.setBackground(Color.WHITE);
		alergiaTextField.setActionCommand("");
		alergiaTextField.setBounds(22, 196, 277, 50);
		frmClinicsystem.getContentPane().add(alergiaTextField);
		
		observacaoLbl = new JLabel("Observação:");
		observacaoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		observacaoLbl.setForeground(Color.GRAY);
		observacaoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		observacaoLbl.setBackground(Color.WHITE);
		observacaoLbl.setBounds(596, 161, 277, 24);
		frmClinicsystem.getContentPane().add(observacaoLbl);
		
		observacaoTextField = new JTextField();
		observacaoTextField.setToolTipText("");
		observacaoTextField.setMargin(new Insets(10, 10, 10, 10));
		observacaoTextField.setHorizontalAlignment(SwingConstants.LEFT);
		observacaoTextField.setForeground(Color.GRAY);
		observacaoTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		observacaoTextField.setColumns(10);
		observacaoTextField.setBackground(Color.WHITE);
		observacaoTextField.setActionCommand("");
		observacaoTextField.setBounds(596, 196, 277, 50);
		frmClinicsystem.getContentPane().add(observacaoTextField);
		
		tipoSanguineoLbl = new JLabel("Tipo sanguíneo:");
		tipoSanguineoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		tipoSanguineoLbl.setForeground(Color.GRAY);
		tipoSanguineoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		tipoSanguineoLbl.setBackground(Color.WHITE);
		tipoSanguineoLbl.setBounds(883, 65, 196, 24);
		frmClinicsystem.getContentPane().add(tipoSanguineoLbl);
		
		dataDeNascimentoLbl = new JLabel("*Data de nascimento:");
		dataDeNascimentoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		dataDeNascimentoLbl.setForeground(Color.GRAY);
		dataDeNascimentoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		dataDeNascimentoLbl.setBackground(Color.WHITE);
		dataDeNascimentoLbl.setBounds(883, 161, 196, 24);
		frmClinicsystem.getContentPane().add(dataDeNascimentoLbl);
		
		tipoSanguineoComboBox = new JComboBox();
		tipoSanguineoComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		tipoSanguineoComboBox.setForeground(new Color(128, 128, 128));
		tipoSanguineoComboBox.setBackground(Color.WHITE);
		tipoSanguineoComboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		tipoSanguineoComboBox.setBounds(883, 100, 196, 50);
		frmClinicsystem.getContentPane().add(tipoSanguineoComboBox);
		
		try {
			dataTextField = new JFormattedTextField(new MaskFormatter("**/**/****"));
		} catch (ParseException e1) {
			erroLbl.setText("Ocorreu um erro inesperado");
		}
		dataTextField.setToolTipText("");
		dataTextField.setMargin(new Insets(10, 10, 10, 10));
		dataTextField.setHorizontalAlignment(SwingConstants.LEFT);
		dataTextField.setForeground(Color.GRAY);
		dataTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		dataTextField.setColumns(10);
		dataTextField.setBackground(Color.WHITE);
		dataTextField.setActionCommand("");
		dataTextField.setBounds(883, 196, 196, 50);
		dataTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldData(dataTextField))) {
					erroLbl.setText("O campo data deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(dataTextField);
		
		responsavelNomeCompletoTextField = new JTextField(new TextFieldService(100), null, 0);
		responsavelNomeCompletoTextField.setToolTipText("Do responsável");
		responsavelNomeCompletoTextField.setMargin(new Insets(10, 10, 10, 10));
		responsavelNomeCompletoTextField.setHorizontalAlignment(SwingConstants.LEFT);
		responsavelNomeCompletoTextField.setForeground(Color.GRAY);
		responsavelNomeCompletoTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		responsavelNomeCompletoTextField.setColumns(10);
		responsavelNomeCompletoTextField.setBackground(Color.WHITE);
		responsavelNomeCompletoTextField.setActionCommand("");
		responsavelNomeCompletoTextField.setBounds(309, 388, 277, 50);
		frmClinicsystem.getContentPane().add(responsavelNomeCompletoTextField);
		
		NomeCompletoResponsavelLbl = new JLabel("Nome completo (Responsável):");
		NomeCompletoResponsavelLbl.setHorizontalAlignment(SwingConstants.LEFT);
		NomeCompletoResponsavelLbl.setForeground(Color.GRAY);
		NomeCompletoResponsavelLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		NomeCompletoResponsavelLbl.setBackground(Color.WHITE);
		NomeCompletoResponsavelLbl.setBounds(309, 353, 277, 24);
		frmClinicsystem.getContentPane().add(NomeCompletoResponsavelLbl);
		
		try {
			responsavelCelularTextField = new JFormattedTextField(new MaskFormatter("** *****-****"));
		} catch (ParseException e1) {
			erroLbl.setText("Ocorreu um erro inesperado");
		}
		responsavelCelularTextField.setToolTipText("Do responsável");
		responsavelCelularTextField.setMargin(new Insets(10, 10, 10, 10));
		responsavelCelularTextField.setHorizontalAlignment(SwingConstants.LEFT);
		responsavelCelularTextField.setForeground(Color.GRAY);
		responsavelCelularTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		responsavelCelularTextField.setColumns(10);
		responsavelCelularTextField.setBackground(Color.WHITE);
		responsavelCelularTextField.setActionCommand("");
		responsavelCelularTextField.setBounds(596, 388, 277, 50);
		responsavelCelularTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldNumerica(responsavelCelularTextField))) {
					erroLbl.setText("O campo telefone deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(responsavelCelularTextField);
		
		celularResponsavelLbl = new JLabel("Celular (Responsável):");
		celularResponsavelLbl.setHorizontalAlignment(SwingConstants.LEFT);
		celularResponsavelLbl.setForeground(Color.GRAY);
		celularResponsavelLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		celularResponsavelLbl.setBackground(Color.WHITE);
		celularResponsavelLbl.setBounds(596, 353, 277, 24);
		frmClinicsystem.getContentPane().add(celularResponsavelLbl);
		
		responsavelCpfTextField = new JTextField(new TextFieldService(11), null, 0);
		responsavelCpfTextField.setToolTipText("Do responsável");
		responsavelCpfTextField.setMargin(new Insets(10, 10, 10, 10));
		responsavelCpfTextField.setHorizontalAlignment(SwingConstants.LEFT);
		responsavelCpfTextField.setForeground(Color.GRAY);
		responsavelCpfTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		responsavelCpfTextField.setColumns(10);
		responsavelCpfTextField.setBackground(Color.WHITE);
		responsavelCpfTextField.setActionCommand("");
		responsavelCpfTextField.setBounds(883, 388, 196, 50);
		responsavelCpfTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldNumerica(responsavelCpfTextField))) {
					erroLbl.setText("O campo CPF deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(responsavelCpfTextField);
		
		cpfResponsavelLbl = new JLabel("CPF (Responsável):");
		cpfResponsavelLbl.setHorizontalAlignment(SwingConstants.LEFT);
		cpfResponsavelLbl.setForeground(Color.GRAY);
		cpfResponsavelLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		cpfResponsavelLbl.setBackground(Color.WHITE);
		cpfResponsavelLbl.setBounds(883, 353, 196, 24);
		frmClinicsystem.getContentPane().add(cpfResponsavelLbl);
		
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
		
		numeroTextField = new JTextField(new TextFieldService(20), null, 0);
		numeroTextField.setToolTipText("");
		numeroTextField.setMargin(new Insets(10, 10, 10, 10));
		numeroTextField.setHorizontalAlignment(SwingConstants.LEFT);
		numeroTextField.setForeground(Color.GRAY);
		numeroTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		numeroTextField.setColumns(10);
		numeroTextField.setBackground(Color.WHITE);
		numeroTextField.setActionCommand("");
		numeroTextField.setBounds(309, 292, 277, 50);
		numeroTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldNumerica(numeroTextField))) {
					erroLbl.setText("O campo de número deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(numeroTextField);
		
		numeroLbl = new JLabel("Número:");
		numeroLbl.setHorizontalAlignment(SwingConstants.LEFT);
		numeroLbl.setForeground(Color.GRAY);
		numeroLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		numeroLbl.setBackground(Color.WHITE);
		numeroLbl.setBounds(309, 257, 277, 24);
		frmClinicsystem.getContentPane().add(numeroLbl);
		
		bairroTextField = new JTextField(new TextFieldService(100), null, 0);
		bairroTextField.setToolTipText("");
		bairroTextField.setMargin(new Insets(10, 10, 10, 10));
		bairroTextField.setHorizontalAlignment(SwingConstants.LEFT);
		bairroTextField.setForeground(Color.GRAY);
		bairroTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		bairroTextField.setColumns(10);
		bairroTextField.setBackground(Color.WHITE);
		bairroTextField.setActionCommand("");
		bairroTextField.setBounds(596, 292, 277, 50);
		frmClinicsystem.getContentPane().add(bairroTextField);
		
		bairroLbl = new JLabel("Bairro:");
		bairroLbl.setHorizontalAlignment(SwingConstants.LEFT);
		bairroLbl.setForeground(Color.GRAY);
		bairroLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		bairroLbl.setBackground(Color.WHITE);
		bairroLbl.setBounds(596, 257, 277, 24);
		frmClinicsystem.getContentPane().add(bairroLbl);
		
		cidadeTextField = new JTextField(new TextFieldService(100), null, 0);
		cidadeTextField.setToolTipText("");
		cidadeTextField.setMargin(new Insets(10, 10, 10, 10));
		cidadeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		cidadeTextField.setForeground(Color.GRAY);
		cidadeTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		cidadeTextField.setColumns(10);
		cidadeTextField.setBackground(Color.WHITE);
		cidadeTextField.setActionCommand("");
		cidadeTextField.setBounds(883, 292, 196, 50);
		frmClinicsystem.getContentPane().add(cidadeTextField);
		
		cidadeLbl = new JLabel("Cidade:");
		cidadeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		cidadeLbl.setForeground(Color.GRAY);
		cidadeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		cidadeLbl.setBackground(Color.WHITE);
		cidadeLbl.setBounds(883, 257, 196, 24);
		frmClinicsystem.getContentPane().add(cidadeLbl);
		
		cepTextField = new JTextField(new TextFieldService(20), null, 0);
		cepTextField.setToolTipText("");
		cepTextField.setMargin(new Insets(10, 10, 10, 10));
		cepTextField.setHorizontalAlignment(SwingConstants.LEFT);
		cepTextField.setForeground(Color.GRAY);
		cepTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		cepTextField.setColumns(10);
		cepTextField.setBackground(Color.WHITE);
		cepTextField.setActionCommand("");
		cepTextField.setBounds(22, 388, 277, 50);
		frmClinicsystem.getContentPane().add(cepTextField);
		
		cepLbl = new JLabel("CEP:");
		cepLbl.setHorizontalAlignment(SwingConstants.LEFT);
		cepLbl.setForeground(Color.GRAY);
		cepLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		cepLbl.setBackground(Color.WHITE);
		cepLbl.setBounds(22, 353, 277, 24);
		frmClinicsystem.getContentPane().add(cepLbl);
		
		limparBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	nomeTextField.setText("");
		    	emailTextField.setText("");
		    	cpfTextField.setText("");
		    	alergiaTextField.setText("");
		        celularTextField.setText("");
		        observacaoTextField.setText("");
		        logradouroTextField.setText("");
		        numeroTextField.setText("");
		        bairroTextField.setText("");
		        cidadeTextField.setText("");
		        cepTextField.setText("");
		        NomeCompletoResponsavelLbl.setText("");
		        responsavelCpfTextField.setText("");
		        responsavelCelularTextField.setText("");
		        erroLbl.setText("");
		    }
		});
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}