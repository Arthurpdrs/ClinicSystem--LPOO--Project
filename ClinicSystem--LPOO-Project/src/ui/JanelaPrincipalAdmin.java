package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import core.services.EstatisticaService;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
public class JanelaPrincipalAdmin {

	private JFrame frmClinicsystem;
	private JLabel menuLbl;
	private JLabel mensagemJanelaPrincipalLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JButton menuCadastrarBtn;
	private JButton menuVisualizarProfissionaisBtn;
	private JButton menuConfiguracoesBtn;
	private JLabel textoFuncionariosLbl;
	private JLabel numeroFuncionariosLbl;
	private JLabel iconeFuncionariosLbl;
	private JLabel recepcionistasBoxLbl;
	private JLabel numeroRecepcionistasLbl;
	private JLabel textoRecepcionistasLbl;
	private JLabel iconeMedicosLbl;
	private JLabel iconePacientesLbl;
	private JLabel iconeRecepcionistasLbl;

	
	public JFrame getJanela() {
		return this.frmClinicsystem;
	}
	
	public JanelaPrincipalAdmin() {
		initialize();
	}
	
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaPrincipalAdmin.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		
		iconeRecepcionistasLbl = new JLabel("");
		iconeRecepcionistasLbl.setIcon(new ImageIcon(JanelaPrincipalAdmin.class.getResource("/midia/recepcionistas.png")));
		iconeRecepcionistasLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconeRecepcionistasLbl.setBounds(630, 267, 62, 62);
		frmClinicsystem.getContentPane().add(iconeRecepcionistasLbl);
		
		final JLabel numeroPacientesLbl = new JLabel("-");
		numeroPacientesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numeroPacientesLbl.setForeground(Color.WHITE);
		numeroPacientesLbl.setFont(new Font("Arial", Font.BOLD, 22));
		numeroPacientesLbl.setBounds(725, 145, 130, 59);
		frmClinicsystem.getContentPane().add(numeroPacientesLbl);
		
		iconePacientesLbl = new JLabel("");
		iconePacientesLbl.setIcon(new ImageIcon(JanelaPrincipalAdmin.class.getResource("/midia/pacientes.png")));
		iconePacientesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconePacientesLbl.setBounds(630, 132, 62, 62);
		frmClinicsystem.getContentPane().add(iconePacientesLbl);
		
		iconeMedicosLbl = new JLabel("");
		iconeMedicosLbl.setIcon(new ImageIcon(JanelaPrincipalAdmin.class.getResource("/midia/medicos.png")));
		iconeMedicosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconeMedicosLbl.setBounds(314, 267, 62, 62);
		frmClinicsystem.getContentPane().add(iconeMedicosLbl);
		
		titulodapaginaLbl = new JLabel("Bem-vindo(a)!");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(22, -1, 380, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaPrincipalAdmin.class.getResource("/midia/logo_menu.png")));
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
		
		mensagemJanelaPrincipalLbl = new JLabel("Você está logado como administrador.");
		mensagemJanelaPrincipalLbl.setOpaque(true);
		mensagemJanelaPrincipalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		mensagemJanelaPrincipalLbl.setForeground(new Color(0, 102, 255));
		mensagemJanelaPrincipalLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		mensagemJanelaPrincipalLbl.setBackground(Color.WHITE);
		mensagemJanelaPrincipalLbl.setBounds(300, 65, 546, 24);
		frmClinicsystem.getContentPane().add(mensagemJanelaPrincipalLbl);
		
		
		menuCadastrarBtn = new JButton("  Cadastrar profissionais");
		menuCadastrarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuCadastrarBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuCadastrarBtn.setForeground(new Color(0, 102, 255));
		menuCadastrarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuCadastrarBtn.setContentAreaFilled(false);
		menuCadastrarBtn.setBorderPainted(false);
		menuCadastrarBtn.setBackground(Color.WHITE);
		menuCadastrarBtn.setBounds(-1, 100, 276, 34);
		frmClinicsystem.getContentPane().add(menuCadastrarBtn);
		
		menuCadastrarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JanelaCadastrarProfissional janelaCadastrar = new JanelaCadastrarProfissional();
		    	janelaCadastrar.getJanela().setVisible(true);
		    }
		});
		
		
		menuVisualizarProfissionaisBtn = new JButton("  Visualizar profissionais");
		menuVisualizarProfissionaisBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuVisualizarProfissionaisBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuVisualizarProfissionaisBtn.setForeground(new Color(0, 102, 255));
		menuVisualizarProfissionaisBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuVisualizarProfissionaisBtn.setContentAreaFilled(false);
		menuVisualizarProfissionaisBtn.setBorderPainted(false);
		menuVisualizarProfissionaisBtn.setBackground(Color.WHITE);
		menuVisualizarProfissionaisBtn.setBounds(-1, 145, 236, 34);
		frmClinicsystem.getContentPane().add(menuVisualizarProfissionaisBtn);
		
		menuVisualizarProfissionaisBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JanelaVisualizarProfissionais janelaVisualizarProfissionais = new JanelaVisualizarProfissionais();
		    	janelaVisualizarProfissionais.getJanela().setVisible(true);
		    }
		});
		
		
		menuConfiguracoesBtn = new JButton("  Configurações");
		menuConfiguracoesBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuConfiguracoesBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuConfiguracoesBtn.setForeground(new Color(0, 102, 255));
		menuConfiguracoesBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuConfiguracoesBtn.setContentAreaFilled(false);
		menuConfiguracoesBtn.setBorderPainted(false);
		menuConfiguracoesBtn.setBackground(Color.WHITE);
		menuConfiguracoesBtn.setBounds(-1, 190, 276, 34);
		frmClinicsystem.getContentPane().add(menuConfiguracoesBtn);
		
		menuConfiguracoesBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JanelaDadosClinica janelaDados = new JanelaDadosClinica();
		    	janelaDados.getJanela().setVisible(true);
		    }
		});
		
		textoFuncionariosLbl = new JLabel("Total de funcionários");
		textoFuncionariosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		textoFuncionariosLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textoFuncionariosLbl.setForeground(new Color(255, 255, 255));
		textoFuncionariosLbl.setBounds(415, 100, 130, 59);
		frmClinicsystem.getContentPane().add(textoFuncionariosLbl);
		
		numeroFuncionariosLbl = new JLabel("-");
		numeroFuncionariosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numeroFuncionariosLbl.setForeground(Color.WHITE);
		numeroFuncionariosLbl.setFont(new Font("Arial", Font.BOLD, 22));
		numeroFuncionariosLbl.setBounds(415, 145, 130, 59);
		frmClinicsystem.getContentPane().add(numeroFuncionariosLbl);
		
		iconeFuncionariosLbl = new JLabel("");
		iconeFuncionariosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconeFuncionariosLbl.setIcon(new ImageIcon(JanelaPrincipalAdmin.class.getResource("/midia/funcionarios.png")));
		iconeFuncionariosLbl.setBounds(314, 128, 62, 62);
		frmClinicsystem.getContentPane().add(iconeFuncionariosLbl);
		
		JLabel funcionariosBoxLbl = new JLabel("");
		funcionariosBoxLbl.setBorder(null);
		funcionariosBoxLbl.setBackground(new Color(0, 102, 204));
		funcionariosBoxLbl.setForeground(Color.WHITE);
		funcionariosBoxLbl.setBounds(300, 100, 276, 124);
		funcionariosBoxLbl.setOpaque(true);
		frmClinicsystem.getContentPane().add(funcionariosBoxLbl);
		
		JLabel textoPacientesLbl = new JLabel("Total de pacientes");
		textoPacientesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		textoPacientesLbl.setForeground(Color.WHITE);
		textoPacientesLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textoPacientesLbl.setBounds(725, 100, 130, 59);
		frmClinicsystem.getContentPane().add(textoPacientesLbl);
		
		final JLabel numeroMedicosLbl = new JLabel("-");
		numeroMedicosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numeroMedicosLbl.setForeground(Color.WHITE);
		numeroMedicosLbl.setFont(new Font("Arial", Font.BOLD, 22));
		numeroMedicosLbl.setBounds(415, 280, 130, 59);
		frmClinicsystem.getContentPane().add(numeroMedicosLbl);
		
		JLabel pacientesBoxLbl = new JLabel("");
		pacientesBoxLbl.setOpaque(true);
		pacientesBoxLbl.setForeground(Color.WHITE);
		pacientesBoxLbl.setBorder(null);
		pacientesBoxLbl.setBackground(new Color(0, 102, 204));
		pacientesBoxLbl.setBounds(610, 100, 276, 124);
		frmClinicsystem.getContentPane().add(pacientesBoxLbl);
		
		JLabel textoMedicosLbl = new JLabel("Total de médicos");
		textoMedicosLbl.setHorizontalAlignment(SwingConstants.CENTER);
		textoMedicosLbl.setForeground(Color.WHITE);
		textoMedicosLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textoMedicosLbl.setBounds(415, 235, 130, 59);
		frmClinicsystem.getContentPane().add(textoMedicosLbl);
		
		numeroRecepcionistasLbl = new JLabel("-");
		numeroRecepcionistasLbl.setHorizontalAlignment(SwingConstants.CENTER);
		numeroRecepcionistasLbl.setForeground(Color.WHITE);
		numeroRecepcionistasLbl.setFont(new Font("Arial", Font.BOLD, 22));
		numeroRecepcionistasLbl.setBounds(725, 280, 130, 59);
		frmClinicsystem.getContentPane().add(numeroRecepcionistasLbl);
		
		textoRecepcionistasLbl = new JLabel("Total de recepcionistas");
		textoRecepcionistasLbl.setHorizontalAlignment(SwingConstants.CENTER);
		textoRecepcionistasLbl.setForeground(Color.WHITE);
		textoRecepcionistasLbl.setFont(new Font("Arial", Font.PLAIN, 12));
		textoRecepcionistasLbl.setBounds(725, 235, 130, 59);
		frmClinicsystem.getContentPane().add(textoRecepcionistasLbl);
		
		recepcionistasBoxLbl = new JLabel("");
		recepcionistasBoxLbl.setOpaque(true);
		recepcionistasBoxLbl.setForeground(Color.WHITE);
		recepcionistasBoxLbl.setBorder(null);
		recepcionistasBoxLbl.setBackground(new Color(0, 102, 204));
		recepcionistasBoxLbl.setBounds(610, 235, 276, 124);
		frmClinicsystem.getContentPane().add(recepcionistasBoxLbl);
		
		JLabel medicosBoxLbl = new JLabel("");
		medicosBoxLbl.setOpaque(true);
		medicosBoxLbl.setForeground(Color.WHITE);
		medicosBoxLbl.setBorder(null);
		medicosBoxLbl.setBackground(new Color(0, 102, 204));
		medicosBoxLbl.setBounds(300, 235, 276, 124);
		frmClinicsystem.getContentPane().add(medicosBoxLbl);
		
		JButton menuSairBtn = new JButton("  Sair");
		menuSairBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuSairBtn.setHorizontalAlignment(SwingConstants.LEFT);
		menuSairBtn.setForeground(new Color(255, 0, 51));
		menuSairBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		menuSairBtn.setContentAreaFilled(false);
		menuSairBtn.setBorderPainted(false);
		menuSairBtn.setBackground(Color.WHITE);
		menuSairBtn.setBounds(-1, 235, 276, 34);
		frmClinicsystem.getContentPane().add(menuSairBtn);
		
		menuSairBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	System.clearProperty("cargo");
                System.clearProperty("cpf_logado");
		    	JanelaLogin janelaLogin = new JanelaLogin();
		    	janelaLogin.getJanela().setVisible(true);
		    	frmClinicsystem.dispose();
		    }
		});
		
		
		JButton visualizarBtn = new JButton("");
		visualizarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					EstatisticaService.totalPacientes(numeroPacientesLbl);
					EstatisticaService.totalRecepcionista(numeroRecepcionistasLbl);
					EstatisticaService.totalMedico(numeroMedicosLbl);
					EstatisticaService.totalFuncionario(numeroFuncionariosLbl);
				} catch (SQLException e1) {
					mensagemJanelaPrincipalLbl.setText("Ocorreu um erro inesperado");
				}
				
			}
		});
		visualizarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		visualizarBtn.setIcon(new ImageIcon(JanelaPrincipalAdmin.class.getResource("/midia/olho.png")));
		visualizarBtn.setBounds(846, 56, 40, 40);
		visualizarBtn.setBorderPainted(false);
		frmClinicsystem.getContentPane().add(visualizarBtn);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
