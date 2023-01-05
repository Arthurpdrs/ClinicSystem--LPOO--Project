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
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;

public class JanelaCadastrarPaciente {

	private JFrame frmClinicsystem;
	private JTextField nomeTextField;
	private JLabel nomeLbl;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JLabel enderecoLbl;
	private JTextField enderecoTextField;
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
	private JLabel dataDeNascimentoLbl;
	private JTextField responsavelNomeCompletoTextField;
	private JLabel NomeCompletoResponsavelLbl;
	private JTextField responsavelCelularTextField;
	private JLabel celularResponsavelLbl;
	private JTextField responsavelCpfTextField;
	private JLabel cpfResponsavelLbl;

	/**
	 * Launch the application.
	 */
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
		
		erroLbl = new JLabel("Preencha todos os campos obrigatórios (Indicados pelo * )");
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
		
		enderecoLbl = new JLabel("Endereço:");
		enderecoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		enderecoLbl.setForeground(Color.GRAY);
		enderecoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		enderecoLbl.setBackground(Color.WHITE);
		enderecoLbl.setBounds(412, 65, 380, 24);
		frmClinicsystem.getContentPane().add(enderecoLbl);
		
		enderecoTextField = new JTextField();
		enderecoTextField.setToolTipText("");
		enderecoTextField.setMargin(new Insets(10, 10, 10, 10));
		enderecoTextField.setHorizontalAlignment(SwingConstants.LEFT);
		enderecoTextField.setForeground(Color.GRAY);
		enderecoTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		enderecoTextField.setColumns(10);
		enderecoTextField.setBackground(Color.WHITE);
		enderecoTextField.setActionCommand("");
		enderecoTextField.setBounds(412, 100, 380, 50);
		frmClinicsystem.getContentPane().add(enderecoTextField);
		
		cpfLbl = new JLabel("*CPF:");
		cpfLbl.setHorizontalAlignment(SwingConstants.LEFT);
		cpfLbl.setForeground(Color.GRAY);
		cpfLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		cpfLbl.setBackground(Color.WHITE);
		cpfLbl.setBounds(802, 65, 277, 24);
		frmClinicsystem.getContentPane().add(cpfLbl);
		
		cpfTextField = new JTextField();
		cpfTextField.setToolTipText("");
		cpfTextField.setMargin(new Insets(10, 10, 10, 10));
		cpfTextField.setHorizontalAlignment(SwingConstants.LEFT);
		cpfTextField.setForeground(Color.GRAY);
		cpfTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		cpfTextField.setColumns(10);
		cpfTextField.setBackground(Color.WHITE);
		cpfTextField.setActionCommand("");
		cpfTextField.setBounds(802, 100, 277, 50);
		frmClinicsystem.getContentPane().add(cpfTextField);
		
		emailLbl = new JLabel("*E-mail:");
		emailLbl.setHorizontalAlignment(SwingConstants.LEFT);
		emailLbl.setForeground(Color.GRAY);
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		emailLbl.setBackground(Color.WHITE);
		emailLbl.setBounds(22, 161, 380, 24);
		frmClinicsystem.getContentPane().add(emailLbl);
		
		emailTextField = new JTextField();
		emailTextField.setToolTipText("");
		emailTextField.setMargin(new Insets(10, 10, 10, 10));
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setForeground(Color.GRAY);
		emailTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		emailTextField.setColumns(10);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setActionCommand("");
		emailTextField.setBounds(22, 196, 380, 50);
		frmClinicsystem.getContentPane().add(emailTextField);
		
		CelularLbl = new JLabel("*Celular:");
		CelularLbl.setHorizontalAlignment(SwingConstants.LEFT);
		CelularLbl.setForeground(Color.GRAY);
		CelularLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		CelularLbl.setBackground(Color.WHITE);
		CelularLbl.setBounds(412, 161, 380, 24);
		frmClinicsystem.getContentPane().add(CelularLbl);
		
		celularTextField = new JTextField();
		celularTextField.setToolTipText("");
		celularTextField.setMargin(new Insets(10, 10, 10, 10));
		celularTextField.setHorizontalAlignment(SwingConstants.LEFT);
		celularTextField.setForeground(Color.GRAY);
		celularTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		celularTextField.setColumns(10);
		celularTextField.setBackground(Color.WHITE);
		celularTextField.setActionCommand("");
		celularTextField.setBounds(412, 196, 380, 50);
		frmClinicsystem.getContentPane().add(celularTextField);
		
		alergiaLbl = new JLabel("Alergia:");
		alergiaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		alergiaLbl.setForeground(Color.GRAY);
		alergiaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		alergiaLbl.setBackground(Color.WHITE);
		alergiaLbl.setBounds(22, 257, 380, 24);
		frmClinicsystem.getContentPane().add(alergiaLbl);
		
		alergiaTextField = new JTextField();
		alergiaTextField.setToolTipText("");
		alergiaTextField.setMargin(new Insets(10, 10, 10, 10));
		alergiaTextField.setHorizontalAlignment(SwingConstants.LEFT);
		alergiaTextField.setForeground(Color.GRAY);
		alergiaTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		alergiaTextField.setColumns(10);
		alergiaTextField.setBackground(Color.WHITE);
		alergiaTextField.setActionCommand("");
		alergiaTextField.setBounds(22, 292, 380, 50);
		frmClinicsystem.getContentPane().add(alergiaTextField);
		
		observacaoLbl = new JLabel("Observação:");
		observacaoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		observacaoLbl.setForeground(Color.GRAY);
		observacaoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		observacaoLbl.setBackground(Color.WHITE);
		observacaoLbl.setBounds(412, 257, 380, 24);
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
		observacaoTextField.setBounds(412, 292, 380, 50);
		frmClinicsystem.getContentPane().add(observacaoTextField);
		
		tipoSanguineoLbl = new JLabel("Tipo sanguíneo:");
		tipoSanguineoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		tipoSanguineoLbl.setForeground(Color.GRAY);
		tipoSanguineoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		tipoSanguineoLbl.setBackground(Color.WHITE);
		tipoSanguineoLbl.setBounds(802, 161, 277, 24);
		frmClinicsystem.getContentPane().add(tipoSanguineoLbl);
		
		dataDeNascimentoLbl = new JLabel("*Data de nascimento:");
		dataDeNascimentoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		dataDeNascimentoLbl.setForeground(Color.GRAY);
		dataDeNascimentoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		dataDeNascimentoLbl.setBackground(Color.WHITE);
		dataDeNascimentoLbl.setBounds(802, 257, 277, 24);
		frmClinicsystem.getContentPane().add(dataDeNascimentoLbl);
		
		JComboBox tipoSanguineoComboBox = new JComboBox();
		tipoSanguineoComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		tipoSanguineoComboBox.setForeground(new Color(128, 128, 128));
		tipoSanguineoComboBox.setBackground(Color.WHITE);
		tipoSanguineoComboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		tipoSanguineoComboBox.setBounds(802, 196, 277, 50);
		frmClinicsystem.getContentPane().add(tipoSanguineoComboBox);
		
		JDateChooser dataDeNascimentoDateChooser = new JDateChooser();
		dataDeNascimentoDateChooser.setDateFormatString("dd/MM/yyyy");
		dataDeNascimentoDateChooser.setBounds(802, 292, 277, 50);
		frmClinicsystem.getContentPane().add(dataDeNascimentoDateChooser);
		
		responsavelNomeCompletoTextField = new JTextField();
		responsavelNomeCompletoTextField.setToolTipText("Do responsável");
		responsavelNomeCompletoTextField.setMargin(new Insets(10, 10, 10, 10));
		responsavelNomeCompletoTextField.setHorizontalAlignment(SwingConstants.LEFT);
		responsavelNomeCompletoTextField.setForeground(Color.GRAY);
		responsavelNomeCompletoTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		responsavelNomeCompletoTextField.setColumns(10);
		responsavelNomeCompletoTextField.setBackground(Color.WHITE);
		responsavelNomeCompletoTextField.setActionCommand("");
		responsavelNomeCompletoTextField.setBounds(22, 388, 380, 50);
		frmClinicsystem.getContentPane().add(responsavelNomeCompletoTextField);
		
		NomeCompletoResponsavelLbl = new JLabel("Nome completo (Responsável):");
		NomeCompletoResponsavelLbl.setHorizontalAlignment(SwingConstants.LEFT);
		NomeCompletoResponsavelLbl.setForeground(Color.GRAY);
		NomeCompletoResponsavelLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		NomeCompletoResponsavelLbl.setBackground(Color.WHITE);
		NomeCompletoResponsavelLbl.setBounds(22, 353, 380, 24);
		frmClinicsystem.getContentPane().add(NomeCompletoResponsavelLbl);
		
		responsavelCelularTextField = new JTextField();
		responsavelCelularTextField.setToolTipText("Do responsável");
		responsavelCelularTextField.setMargin(new Insets(10, 10, 10, 10));
		responsavelCelularTextField.setHorizontalAlignment(SwingConstants.LEFT);
		responsavelCelularTextField.setForeground(Color.GRAY);
		responsavelCelularTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		responsavelCelularTextField.setColumns(10);
		responsavelCelularTextField.setBackground(Color.WHITE);
		responsavelCelularTextField.setActionCommand("");
		responsavelCelularTextField.setBounds(412, 388, 380, 50);
		frmClinicsystem.getContentPane().add(responsavelCelularTextField);
		
		celularResponsavelLbl = new JLabel("Celular (Responsável):");
		celularResponsavelLbl.setHorizontalAlignment(SwingConstants.LEFT);
		celularResponsavelLbl.setForeground(Color.GRAY);
		celularResponsavelLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		celularResponsavelLbl.setBackground(Color.WHITE);
		celularResponsavelLbl.setBounds(412, 353, 380, 24);
		frmClinicsystem.getContentPane().add(celularResponsavelLbl);
		
		responsavelCpfTextField = new JTextField();
		responsavelCpfTextField.setToolTipText("Do responsável");
		responsavelCpfTextField.setMargin(new Insets(10, 10, 10, 10));
		responsavelCpfTextField.setHorizontalAlignment(SwingConstants.LEFT);
		responsavelCpfTextField.setForeground(Color.GRAY);
		responsavelCpfTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		responsavelCpfTextField.setColumns(10);
		responsavelCpfTextField.setBackground(Color.WHITE);
		responsavelCpfTextField.setActionCommand("");
		responsavelCpfTextField.setBounds(802, 388, 277, 50);
		frmClinicsystem.getContentPane().add(responsavelCpfTextField);
		
		cpfResponsavelLbl = new JLabel("CPF (Responsável):");
		cpfResponsavelLbl.setHorizontalAlignment(SwingConstants.LEFT);
		cpfResponsavelLbl.setForeground(Color.GRAY);
		cpfResponsavelLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		cpfResponsavelLbl.setBackground(Color.WHITE);
		cpfResponsavelLbl.setBounds(802, 353, 277, 24);
		frmClinicsystem.getContentPane().add(cpfResponsavelLbl);
		
		JButton limparBtn = new JButton("Limpar");
		limparBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limparBtn.setForeground(Color.GRAY);
		limparBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		limparBtn.setContentAreaFilled(false);
		limparBtn.setBorderPainted(false);
		limparBtn.setBackground(Color.WHITE);
		limparBtn.setBounds(891, 553, 89, 34);
		frmClinicsystem.getContentPane().add(limparBtn);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}