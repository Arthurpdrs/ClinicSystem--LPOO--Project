package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class JanelaPrincipalMedico {

	private JFrame frmClinicsystem;
	private JLabel menuLbl;
	private JLabel mensagemJanelaPrincipalLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JButton menuAnexarRegistroBtn;
	private JButton menuVisualizarHistoricoBtn;
	private JButton menuAgendaDeConsultasBtn;
	private JLabel textoConsultasLbl;
	private JLabel numeroConsultasLbl;
	private JLabel iconeConsultasLbl;
	private JLabel iconePacientesLbl;
	private JButton menuVisualizarProntuariosBtn;
	private JTable consultasDoDiaTable;

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
					JanelaPrincipalMedico window = new JanelaPrincipalMedico();
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
	public JanelaPrincipalMedico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaPrincipalMedico.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		
		JLabel numeroPacientesLbl = new JLabel("20000");
		numeroPacientesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numeroPacientesLbl.setForeground(Color.WHITE);
		numeroPacientesLbl.setFont(new Font("Arial", Font.BOLD, 22));
		numeroPacientesLbl.setBounds(725, 145, 130, 59);
		frmClinicsystem.getContentPane().add(numeroPacientesLbl);
		
		iconePacientesLbl = new JLabel("");
		iconePacientesLbl.setIcon(new ImageIcon(JanelaPrincipalMedico.class.getResource("/midia/pacientes.png")));
		iconePacientesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconePacientesLbl.setBounds(630, 132, 62, 62);
		frmClinicsystem.getContentPane().add(iconePacientesLbl);
		
		titulodapaginaLbl = new JLabel("Bem-vindo(a)!");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(22, -1, 380, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaPrincipalMedico.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		menuLbl = new JLabel("Menu");
		menuLbl.setHorizontalAlignment(SwingConstants.LEFT);
		menuLbl.setBackground(Color.WHITE);
		menuLbl.setForeground(Color.GRAY);
		menuLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		menuLbl.setBounds(22, 65, 170, 24);
		frmClinicsystem.getContentPane().add(menuLbl);
		
		barraAzul = new JLabel("");
		barraAzul.setBackground(new Color(0, 102, 255));
		barraAzul.setBounds(-1, -1, 1131, 55);
		barraAzul.setOpaque(true);
		frmClinicsystem.getContentPane().add(barraAzul);
		
		mensagemJanelaPrincipalLbl = new JLabel("Você está logado como médico.");
		mensagemJanelaPrincipalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		mensagemJanelaPrincipalLbl.setForeground(new Color(0, 102, 255));
		mensagemJanelaPrincipalLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		mensagemJanelaPrincipalLbl.setBackground(Color.WHITE);
		mensagemJanelaPrincipalLbl.setBounds(300, 65, 586, 24);
		frmClinicsystem.getContentPane().add(mensagemJanelaPrincipalLbl);
		
		//Botão
		menuAnexarRegistroBtn = new JButton("  Anexar registro");
		menuAnexarRegistroBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuAnexarRegistroBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuAnexarRegistroBtn.setForeground(new Color(0, 102, 255));
		menuAnexarRegistroBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuAnexarRegistroBtn.setContentAreaFilled(false);
		menuAnexarRegistroBtn.setBorderPainted(false);
		menuAnexarRegistroBtn.setBackground(Color.WHITE);
		menuAnexarRegistroBtn.setBounds(-1, 100, 276, 34);
		frmClinicsystem.getContentPane().add(menuAnexarRegistroBtn);
		
		menuAnexarRegistroBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JanelaNovoRegistro janelaNovoRegistro = new JanelaNovoRegistro();
		    	janelaNovoRegistro.getJanela().setVisible(true);
		    }
		});
		
		//Botão
		menuVisualizarHistoricoBtn = new JButton("  Histórico de consultas");
		menuVisualizarHistoricoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuVisualizarHistoricoBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuVisualizarHistoricoBtn.setForeground(new Color(0, 102, 255));
		menuVisualizarHistoricoBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuVisualizarHistoricoBtn.setContentAreaFilled(false);
		menuVisualizarHistoricoBtn.setBorderPainted(false);
		menuVisualizarHistoricoBtn.setBackground(Color.WHITE);
		menuVisualizarHistoricoBtn.setBounds(-1, 145, 276, 34);
		frmClinicsystem.getContentPane().add(menuVisualizarHistoricoBtn);
		
		menuVisualizarHistoricoBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JanelaVisualizarHistoricoDeConsultas janelaHistorico = new JanelaVisualizarHistoricoDeConsultas();
		    	janelaHistorico.getJanela().setVisible(true);
		    }
		});
		
		//Botão
		menuAgendaDeConsultasBtn = new JButton("  Agenda de consultas");
		menuAgendaDeConsultasBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuAgendaDeConsultasBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuAgendaDeConsultasBtn.setForeground(new Color(0, 102, 255));
		menuAgendaDeConsultasBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuAgendaDeConsultasBtn.setContentAreaFilled(false);
		menuAgendaDeConsultasBtn.setBorderPainted(false);
		menuAgendaDeConsultasBtn.setBackground(Color.WHITE);
		menuAgendaDeConsultasBtn.setBounds(-1, 190, 276, 34);
		frmClinicsystem.getContentPane().add(menuAgendaDeConsultasBtn);
		
		menuAgendaDeConsultasBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JanelaVisualizarAgenda janelaAgenda = new JanelaVisualizarAgenda();
		    	janelaAgenda.getJanela().setVisible(true);
		    }
		});
		
		textoConsultasLbl = new JLabel("Número de consultas\r\n do dia");
		textoConsultasLbl.setHorizontalAlignment(SwingConstants.CENTER);
		textoConsultasLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textoConsultasLbl.setForeground(new Color(255, 255, 255));
		textoConsultasLbl.setBounds(385, 100, 191, 59);
		frmClinicsystem.getContentPane().add(textoConsultasLbl);
		
		numeroConsultasLbl = new JLabel("20000");
		numeroConsultasLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numeroConsultasLbl.setForeground(Color.WHITE);
		numeroConsultasLbl.setFont(new Font("Arial", Font.BOLD, 22));
		numeroConsultasLbl.setBounds(415, 145, 130, 59);
		frmClinicsystem.getContentPane().add(numeroConsultasLbl);
		
		iconeConsultasLbl = new JLabel("");
		iconeConsultasLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconeConsultasLbl.setIcon(new ImageIcon(JanelaPrincipalMedico.class.getResource("/midia/consultas.png")));
		iconeConsultasLbl.setBounds(314, 128, 62, 62);
		frmClinicsystem.getContentPane().add(iconeConsultasLbl);
		
		JLabel consultasBoxLbl = new JLabel("");
		consultasBoxLbl.setBorder(null);
		consultasBoxLbl.setBackground(new Color(0, 102, 204));
		consultasBoxLbl.setForeground(Color.WHITE);
		consultasBoxLbl.setBounds(300, 100, 276, 124);
		consultasBoxLbl.setOpaque(true);
		frmClinicsystem.getContentPane().add(consultasBoxLbl);
		
		JLabel textoPacientesLbl = new JLabel("Total de pacientes");
		textoPacientesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		textoPacientesLbl.setForeground(Color.WHITE);
		textoPacientesLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textoPacientesLbl.setBounds(725, 100, 130, 59);
		frmClinicsystem.getContentPane().add(textoPacientesLbl);
		
		JLabel pacientesBoxLbl = new JLabel("");
		pacientesBoxLbl.setOpaque(true);
		pacientesBoxLbl.setForeground(Color.WHITE);
		pacientesBoxLbl.setBorder(null);
		pacientesBoxLbl.setBackground(new Color(0, 102, 204));
		pacientesBoxLbl.setBounds(610, 100, 276, 124);
		frmClinicsystem.getContentPane().add(pacientesBoxLbl);
		
		//Botão
		JButton menuSairBtn = new JButton("  Sair");
		menuSairBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuSairBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuSairBtn.setForeground(new Color(255, 0, 51));
		menuSairBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuSairBtn.setContentAreaFilled(false);
		menuSairBtn.setBorderPainted(false);
		menuSairBtn.setBackground(Color.WHITE);
		menuSairBtn.setBounds(-1, 280, 276, 34);
		frmClinicsystem.getContentPane().add(menuSairBtn);
		
		menuSairBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JanelaLogin janelaLogin = new JanelaLogin();
		    	janelaLogin.getJanela().setVisible(true);
		    }
		});
		
		//Botão
		menuVisualizarProntuariosBtn = new JButton("  Visualizar prontuários");
		menuVisualizarProntuariosBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuVisualizarProntuariosBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuVisualizarProntuariosBtn.setForeground(new Color(0, 102, 255));
		menuVisualizarProntuariosBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuVisualizarProntuariosBtn.setContentAreaFilled(false);
		menuVisualizarProntuariosBtn.setBorderPainted(false);
		menuVisualizarProntuariosBtn.setBackground(Color.WHITE);
		menuVisualizarProntuariosBtn.setBounds(-1, 235, 276, 34);
		frmClinicsystem.getContentPane().add(menuVisualizarProntuariosBtn);
		
		menuVisualizarProntuariosBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JanelaVisualizarProntuarios janelaProntuarios = new JanelaVisualizarProntuarios();
		    	janelaProntuarios.getJanela().setVisible(true);
		    }
		});
		
		JScrollPane scrollPane = new JScrollPane(consultasDoDiaTable = new JTable());
		scrollPane.setBounds(300, 348, 586, 244);
		frmClinicsystem.getContentPane().add(scrollPane);
		
		consultasDoDiaTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hor\u00E1rio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		consultasDoDiaTable.setBounds(0, 0, 1, 1);
		
		JLabel lblConsultasDoDia = new JLabel("Consultas do dia");
		lblConsultasDoDia.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsultasDoDia.setForeground(Color.GRAY);
		lblConsultasDoDia.setFont(new Font("Arial", Font.PLAIN, 16));
		lblConsultasDoDia.setBackground(Color.WHITE);
		lblConsultasDoDia.setBounds(300, 292, 170, 24);
		frmClinicsystem.getContentPane().add(lblConsultasDoDia);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}