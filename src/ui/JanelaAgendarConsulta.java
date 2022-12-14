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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaAgendarConsulta {

	private JFrame frmClinicsystem;
	private JTextField nomeTextField;
	private JLabel nomeLbl;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JLabel cpfLbl;
	private JTextField cpfTextField;
	private JLabel emailLbl;
	private JTextField emailTextField;
	private JLabel CelularLbl;
	private JTextField celularTextField;
	private JLabel responsavelLbl;
	private JTextField responsavelTextField;
	private JLabel observacaoLbl;
	private JTextField observacaoTextField;
	private JLabel especialidadeLbl;
	private JLabel dataDaConsultaLbl;
	private JTextField codigoDoPacienteTextField;
	private JComboBox medicoComboBox;
	private JLabel medicoLbl;
	private JLabel horarioLbl;
	private JTextField horarioTextField;
	private JTextField valorTextField;
	private JLabel valorLbl;
	private JComboBox estadoComboBox;
	private JLabel estadoLbl;
	private JButton pesquisarBtn;
	private JLabel avisoLbl;
	private JLabel codigoDoPacienteLbl;

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
					JanelaAgendarConsulta window = new JanelaAgendarConsulta();
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
	public JanelaAgendarConsulta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaAgendarConsulta.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		titulodapaginaLbl = new JLabel("Agendar consulta");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(22, -1, 380, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaAgendarConsulta.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		nomeLbl = new JLabel("*Nome completo:");
		nomeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLbl.setBackground(Color.WHITE);
		nomeLbl.setForeground(Color.GRAY);
		nomeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		nomeLbl.setBounds(32, 161, 380, 24);
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
		nomeTextField.setBounds(32, 196, 380, 50);
		nomeTextField.setColumns(10);
		frmClinicsystem.getContentPane().add(nomeTextField);
		
		erroLbl = new JLabel("Consulta agendada com sucesso");
		erroLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		erroLbl.setForeground(new Color(0, 102, 255));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(422, 545, 664, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		//Bot??o
		JButton enviarBtn = new JButton("Enviar");
		enviarBtn.setBorderPainted(false);
		enviarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviarBtn.setBackground(new Color(255, 255, 255));
		enviarBtn.setForeground(new Color(0, 102, 255));
		enviarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		enviarBtn.setBounds(997, 582, 89, 34);
		enviarBtn.setContentAreaFilled(false);
		frmClinicsystem.getContentPane().add(enviarBtn);
		
		enviarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        //Inserir a????o aqui
		    }
		});
		
		cpfLbl = new JLabel("*CPF:");
		cpfLbl.setHorizontalAlignment(SwingConstants.LEFT);
		cpfLbl.setForeground(Color.GRAY);
		cpfLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		cpfLbl.setBackground(Color.WHITE);
		cpfLbl.setBounds(812, 161, 277, 24);
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
		cpfTextField.setBounds(812, 196, 277, 50);
		frmClinicsystem.getContentPane().add(cpfTextField);
		
		emailLbl = new JLabel("*E-mail:");
		emailLbl.setHorizontalAlignment(SwingConstants.LEFT);
		emailLbl.setForeground(Color.GRAY);
		emailLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		emailLbl.setBackground(Color.WHITE);
		emailLbl.setBounds(422, 161, 380, 24);
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
		emailTextField.setBounds(422, 196, 380, 50);
		frmClinicsystem.getContentPane().add(emailTextField);
		
		CelularLbl = new JLabel("*Celular:");
		CelularLbl.setHorizontalAlignment(SwingConstants.LEFT);
		CelularLbl.setForeground(Color.GRAY);
		CelularLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		CelularLbl.setBackground(Color.WHITE);
		CelularLbl.setBounds(32, 257, 380, 24);
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
		celularTextField.setBounds(32, 292, 380, 50);
		frmClinicsystem.getContentPane().add(celularTextField);
		
		responsavelLbl = new JLabel("Respons??vel");
		responsavelLbl.setHorizontalAlignment(SwingConstants.LEFT);
		responsavelLbl.setForeground(Color.GRAY);
		responsavelLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		responsavelLbl.setBackground(Color.WHITE);
		responsavelLbl.setBounds(32, 353, 380, 24);
		frmClinicsystem.getContentPane().add(responsavelLbl);
		
		responsavelTextField = new JTextField();
		responsavelTextField.setToolTipText("");
		responsavelTextField.setMargin(new Insets(10, 10, 10, 10));
		responsavelTextField.setHorizontalAlignment(SwingConstants.LEFT);
		responsavelTextField.setForeground(Color.GRAY);
		responsavelTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		responsavelTextField.setColumns(10);
		responsavelTextField.setBackground(Color.WHITE);
		responsavelTextField.setActionCommand("");
		responsavelTextField.setBounds(32, 388, 380, 50);
		frmClinicsystem.getContentPane().add(responsavelTextField);
		
		observacaoLbl = new JLabel("Observa????o:");
		observacaoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		observacaoLbl.setForeground(Color.GRAY);
		observacaoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		observacaoLbl.setBackground(Color.WHITE);
		observacaoLbl.setBounds(422, 257, 380, 24);
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
		observacaoTextField.setBounds(422, 292, 380, 50);
		frmClinicsystem.getContentPane().add(observacaoTextField);
		
		especialidadeLbl = new JLabel("*Especialidade:");
		especialidadeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		especialidadeLbl.setForeground(Color.GRAY);
		especialidadeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		especialidadeLbl.setBackground(Color.WHITE);
		especialidadeLbl.setBounds(812, 257, 277, 24);
		frmClinicsystem.getContentPane().add(especialidadeLbl);
		
		dataDaConsultaLbl = new JLabel("*Data da consulta:");
		dataDaConsultaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		dataDaConsultaLbl.setForeground(Color.GRAY);
		dataDaConsultaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		dataDaConsultaLbl.setBackground(Color.WHITE);
		dataDaConsultaLbl.setBounds(812, 353, 277, 24);
		frmClinicsystem.getContentPane().add(dataDaConsultaLbl);
		
		JComboBox especialidadeComboBox = new JComboBox();
		especialidadeComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		especialidadeComboBox.setForeground(new Color(128, 128, 128));
		especialidadeComboBox.setBackground(Color.WHITE);
		especialidadeComboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE UMA ESPECIALIDADE", "CL??NICA M??DICA", "PEDIATRIA", "GINECOLOGIA", "UROLOGIA", "PSIQUIATRIA", "ANGIOLOGIA", "OFTALMOLOGIA", "OTORRINOLARINGOLOGIA", "GASTROENTEROLOGIA"}));
		especialidadeComboBox.setBounds(812, 292, 277, 50);
		frmClinicsystem.getContentPane().add(especialidadeComboBox);
		
		JDateChooser dataDaConsultaDateChooser = new JDateChooser();
		dataDaConsultaDateChooser.setDateFormatString("dd/MM/yyyy");
		dataDaConsultaDateChooser.setBounds(812, 388, 277, 50);
		frmClinicsystem.getContentPane().add(dataDaConsultaDateChooser);
		
		codigoDoPacienteTextField = new JTextField();
		codigoDoPacienteTextField.setToolTipText("");
		codigoDoPacienteTextField.setMargin(new Insets(10, 10, 10, 10));
		codigoDoPacienteTextField.setHorizontalAlignment(SwingConstants.LEFT);
		codigoDoPacienteTextField.setForeground(Color.GRAY);
		codigoDoPacienteTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		codigoDoPacienteTextField.setColumns(10);
		codigoDoPacienteTextField.setBackground(Color.WHITE);
		codigoDoPacienteTextField.setActionCommand("");
		codigoDoPacienteTextField.setBounds(32, 100, 955, 50);
		frmClinicsystem.getContentPane().add(codigoDoPacienteTextField);
		
		//Bot??o
		JButton limparBtn = new JButton("Limpar");
		limparBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limparBtn.setForeground(Color.GRAY);
		limparBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		limparBtn.setContentAreaFilled(false);
		limparBtn.setBorderPainted(false);
		limparBtn.setBackground(Color.WHITE);
		limparBtn.setBounds(898, 582, 89, 34);
		frmClinicsystem.getContentPane().add(limparBtn);
		
		limparBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        //Inserir a????o aqui
		    }
		});
		
		medicoComboBox = new JComboBox();
		medicoComboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE UM(A) M??DICO(A)"}));
		medicoComboBox.setForeground(Color.GRAY);
		medicoComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		medicoComboBox.setBackground(Color.WHITE);
		medicoComboBox.setBounds(422, 388, 380, 50);
		frmClinicsystem.getContentPane().add(medicoComboBox);
		
		medicoLbl = new JLabel("*M??dico(a):");
		medicoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		medicoLbl.setForeground(Color.GRAY);
		medicoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		medicoLbl.setBackground(Color.WHITE);
		medicoLbl.setBounds(422, 360, 380, 24);
		frmClinicsystem.getContentPane().add(medicoLbl);
		
		horarioLbl = new JLabel("*Hor??rio:");
		horarioLbl.setHorizontalAlignment(SwingConstants.LEFT);
		horarioLbl.setForeground(Color.GRAY);
		horarioLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		horarioLbl.setBackground(Color.WHITE);
		horarioLbl.setBounds(32, 449, 380, 24);
		frmClinicsystem.getContentPane().add(horarioLbl);
		
		horarioTextField = new JTextField();
		horarioTextField.setToolTipText("");
		horarioTextField.setMargin(new Insets(10, 10, 10, 10));
		horarioTextField.setHorizontalAlignment(SwingConstants.LEFT);
		horarioTextField.setForeground(Color.GRAY);
		horarioTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		horarioTextField.setColumns(10);
		horarioTextField.setBackground(Color.WHITE);
		horarioTextField.setActionCommand("");
		horarioTextField.setBounds(32, 484, 380, 50);
		frmClinicsystem.getContentPane().add(horarioTextField);
		
		valorTextField = new JTextField();
		valorTextField.setToolTipText("");
		valorTextField.setMargin(new Insets(10, 10, 10, 10));
		valorTextField.setHorizontalAlignment(SwingConstants.LEFT);
		valorTextField.setForeground(Color.GRAY);
		valorTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		valorTextField.setColumns(10);
		valorTextField.setBackground(Color.WHITE);
		valorTextField.setActionCommand("");
		valorTextField.setBounds(422, 484, 380, 50);
		frmClinicsystem.getContentPane().add(valorTextField);
		
		valorLbl = new JLabel("Valor:");
		valorLbl.setHorizontalAlignment(SwingConstants.LEFT);
		valorLbl.setForeground(Color.GRAY);
		valorLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		valorLbl.setBackground(Color.WHITE);
		valorLbl.setBounds(422, 449, 380, 24);
		frmClinicsystem.getContentPane().add(valorLbl);
		
		estadoComboBox = new JComboBox();
		estadoComboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE UM ESTADO", "PAGO", "PENDENTE", "AUTORIZADA", "CANCELADA"}));
		estadoComboBox.setForeground(Color.GRAY);
		estadoComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		estadoComboBox.setBackground(Color.WHITE);
		estadoComboBox.setBounds(812, 484, 277, 50);
		frmClinicsystem.getContentPane().add(estadoComboBox);
		
		estadoLbl = new JLabel("Estado:");
		estadoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		estadoLbl.setForeground(Color.GRAY);
		estadoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		estadoLbl.setBackground(Color.WHITE);
		estadoLbl.setBounds(812, 449, 277, 24);
		frmClinicsystem.getContentPane().add(estadoLbl);
		
		//Bot??o
		pesquisarBtn = new JButton("");
		pesquisarBtn.setIcon(new ImageIcon(JanelaAgendarConsulta.class.getResource("/midia/lupa.png")));
		pesquisarBtn.setForeground(new Color(0, 102, 255));
		pesquisarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		pesquisarBtn.setContentAreaFilled(false);
		pesquisarBtn.setBorderPainted(false);
		pesquisarBtn.setBackground(Color.WHITE);
		pesquisarBtn.setBounds(997, 100, 97, 50);
		frmClinicsystem.getContentPane().add(pesquisarBtn);
		
		pesquisarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        //Inserir a????o aqui
		    }
		});
		
		avisoLbl = new JLabel("N??o foi poss??vel encontrar o paciente");
		avisoLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		avisoLbl.setOpaque(true);
		avisoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		avisoLbl.setForeground(new Color(0, 102, 255));
		avisoLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		avisoLbl.setBackground(Color.WHITE);
		avisoLbl.setBounds(236, 65, 751, 24);
		frmClinicsystem.getContentPane().add(avisoLbl);
		
		codigoDoPacienteLbl = new JLabel("Pesquisar CPF do paciente:");
		codigoDoPacienteLbl.setHorizontalAlignment(SwingConstants.LEFT);
		codigoDoPacienteLbl.setForeground(Color.GRAY);
		codigoDoPacienteLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		codigoDoPacienteLbl.setBackground(Color.WHITE);
		codigoDoPacienteLbl.setBounds(32, 67, 221, 24);
		frmClinicsystem.getContentPane().add(codigoDoPacienteLbl);
		logoMenu.setBounds(919, -1, 160, 55);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}