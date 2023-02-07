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
import javax.swing.JFormattedTextField;

import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import core.model.Paciente;
import core.model.Pessoa;
import core.services.FuncionarioService;
import core.services.MedicoService;
import core.services.PacienteService;
import core.services.ProntuarioService;
import core.services.TextFieldService;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.ParseException;

public class JanelaNovoRegistro {

	private JFrame frmClinicsystem;
	private JTextField nomeTextField;
	private JLabel nomeLbl;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JLabel cpfLbl;
	private JTextField cpfTextField;
	private JTextField pesquisarTextField;
	private JLabel codigoDoPacienteLbl;
	private JButton pesquisarBtn;
	private JTextField nomeMedicoTextField;
	private JLabel nomeMedicoLbl;
	private JTextField especialidadeTextField;
	private JLabel especialidadeLbl;
	private JLabel queixaLbl;
	private JLabel dataLbl;
	private JLabel avisoLbl;
	private JTextField dataTextField;
	private JTextArea queixaTextArea;
	private JTextArea observacaoTextArea;
	private JTextArea prescricaoTextArea;

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
					JanelaNovoRegistro window = new JanelaNovoRegistro();
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
	public JanelaNovoRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaNovoRegistro.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		//Botão
		pesquisarBtn = new JButton("");
		pesquisarBtn.setIcon(new ImageIcon(JanelaNovoRegistro.class.getResource("/midia/lupa.png")));
		pesquisarBtn.setForeground(new Color(0, 102, 255));
		pesquisarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		pesquisarBtn.setContentAreaFilled(false);
		pesquisarBtn.setBorderPainted(false);
		pesquisarBtn.setBackground(Color.WHITE);
		pesquisarBtn.setBounds(678, 100, 97, 50);
		frmClinicsystem.getContentPane().add(pesquisarBtn);
		
		pesquisarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       PacienteService pacienteService = new PacienteService(); 
		       try {
				if(pacienteService.filtrarPaciente(pesquisarTextField, nomeTextField)) {
					;
					avisoLbl.setText("");
				} else {
					avisoLbl.setText("Não foi possível encontrar o paciente");
				}
			} catch (SQLException e) {
				avisoLbl.setText("Ocorreu um erro inesperado. Tente novamente");
			}
		    }
		});
		
		titulodapaginaLbl = new JLabel("Novo registro");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(22, -1, 380, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaNovoRegistro.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		nomeLbl = new JLabel("Nome do paciente:");
		nomeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLbl.setBackground(Color.WHITE);
		nomeLbl.setForeground(Color.GRAY);
		nomeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		nomeLbl.setBounds(22, 161, 380, 24);
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
		nomeTextField.setBounds(22, 196, 380, 50);
		nomeTextField.setColumns(10);
		nomeTextField.setEditable(false);
		frmClinicsystem.getContentPane().add(nomeTextField);
		
		erroLbl = new JLabel("");
		erroLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		erroLbl.setForeground(new Color(0, 102, 255));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(415, 551, 664, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		//Botão
		JButton enviarBtn = new JButton("Enviar");
		enviarBtn.setBorderPainted(false);
		enviarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviarBtn.setBackground(new Color(255, 255, 255));
		enviarBtn.setForeground(new Color(0, 102, 255));
		enviarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		enviarBtn.setBounds(990, 596, 89, 34);
		enviarBtn.setContentAreaFilled(false);
		frmClinicsystem.getContentPane().add(enviarBtn);
		
		enviarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	String nome_paciente = nomeTextField.getText().toUpperCase().trim();
		        String cpf_paciente = cpfTextField.getText().toUpperCase().trim();
		        String queixa = queixaTextArea.getText().toUpperCase().trim();
		        String data = dataTextField.getText().toUpperCase().trim();
		        String observacao = observacaoTextArea.getText().toUpperCase().trim();
		        String prescricao = prescricaoTextArea.getText().toUpperCase().trim();
		        String nome_medico = nomeMedicoTextField.getText().toUpperCase().trim();	
		        String especialidade = especialidadeTextField.getText().toUpperCase().trim();
		        
		        ProntuarioService prontuarioService = new ProntuarioService();
		        try {
		        	if(prontuarioService.inserir(queixa, observacao, data, prescricao, cpf_paciente, nome_paciente, nome_medico, especialidade) == false) {
		        		erroLbl.setText("Verifique os valores inseridos");
		        	}else {
		        		prontuarioService.inserir(queixa, observacao, data, prescricao, cpf_paciente, nome_paciente, nome_medico, especialidade);
		        		erroLbl.setText("Prontuario enviado com sucesso!");	
		        	}
		       }
		       catch(SQLException e){
		    	   erroLbl.setText("Ocorreu um erro inesperado. Tente novamente");
		       }
		        
		    }
		});
		
		cpfLbl = new JLabel("CPF do Paciente:");
		cpfLbl.setHorizontalAlignment(SwingConstants.LEFT);
		cpfLbl.setForeground(Color.GRAY);
		cpfLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		cpfLbl.setBackground(Color.WHITE);
		cpfLbl.setBounds(22, 257, 380, 24);
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
		cpfTextField.setEditable(false);
		cpfTextField.setBounds(22, 292, 380, 50);
		frmClinicsystem.getContentPane().add(cpfTextField);
		
		//Botão
		JButton limparBtn = new JButton("Limpar");
		limparBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limparBtn.setForeground(Color.GRAY);
		limparBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		limparBtn.setContentAreaFilled(false);
		limparBtn.setBorderPainted(false);
		limparBtn.setBackground(Color.WHITE);
		limparBtn.setBounds(891, 596, 89, 34);
		frmClinicsystem.getContentPane().add(limparBtn);
		
		limparBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       cpfTextField.setText("");
		       dataTextField.setText("");
		       erroLbl.setText("");
		       avisoLbl.setText("");
		       nomeMedicoTextField.setText("");
		       nomeTextField.setText("");
		       especialidadeTextField.setText("");
		       queixaTextArea.setText("");
		       observacaoTextArea.setText("");
		       prescricaoTextArea.setText("");
		    }
		});
		
		pesquisarTextField = new JTextField(new TextFieldService(11), null, 0);
		pesquisarTextField.setToolTipText("");
		pesquisarTextField.setMargin(new Insets(10, 10, 10, 10));
		pesquisarTextField.setHorizontalAlignment(SwingConstants.LEFT);
		pesquisarTextField.setForeground(Color.GRAY);
		pesquisarTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		pesquisarTextField.setColumns(10);
		pesquisarTextField.setBackground(Color.WHITE);
		pesquisarTextField.setActionCommand("");
		pesquisarTextField.setBounds(22, 100, 646, 50);
		pesquisarTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldNumerica(pesquisarTextField))) {
					erroLbl.setText("O campo CPF deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(pesquisarTextField);
		
		codigoDoPacienteLbl = new JLabel("Pesquisar CPF do paciente:");
		codigoDoPacienteLbl.setHorizontalAlignment(SwingConstants.LEFT);
		codigoDoPacienteLbl.setForeground(Color.GRAY);
		codigoDoPacienteLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		codigoDoPacienteLbl.setBackground(Color.WHITE);
		codigoDoPacienteLbl.setBounds(22, 65, 221, 24);
		frmClinicsystem.getContentPane().add(codigoDoPacienteLbl);
		
		nomeMedicoTextField = new JTextField();
		nomeMedicoTextField.setToolTipText("");
		nomeMedicoTextField.setMargin(new Insets(10, 10, 10, 10));
		nomeMedicoTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nomeMedicoTextField.setForeground(Color.GRAY);
		nomeMedicoTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		nomeMedicoTextField.setColumns(10);
		nomeMedicoTextField.setBackground(Color.WHITE);
		nomeMedicoTextField.setActionCommand("");
		nomeMedicoTextField.setBounds(22, 388, 380, 50);
		nomeMedicoTextField.setEditable(false);
		frmClinicsystem.getContentPane().add(nomeMedicoTextField);
		
		nomeMedicoLbl = new JLabel("Nome do(a) médico(a):");
		nomeMedicoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		nomeMedicoLbl.setForeground(Color.GRAY);
		nomeMedicoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		nomeMedicoLbl.setBackground(Color.WHITE);
		nomeMedicoLbl.setBounds(22, 353, 380, 24);
		frmClinicsystem.getContentPane().add(nomeMedicoLbl);
		
		especialidadeTextField = new JTextField();
		especialidadeTextField.setToolTipText("");
		especialidadeTextField.setMargin(new Insets(10, 10, 10, 10));
		especialidadeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		especialidadeTextField.setForeground(Color.GRAY);
		especialidadeTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		especialidadeTextField.setColumns(10);
		especialidadeTextField.setBackground(Color.WHITE);
		especialidadeTextField.setActionCommand("");
		especialidadeTextField.setBounds(22, 491, 380, 50);
		especialidadeTextField.setEditable(false);
		frmClinicsystem.getContentPane().add(especialidadeTextField);
		
		especialidadeLbl = new JLabel("Especialidade do(a) médico(a):");
		especialidadeLbl.setHorizontalAlignment(SwingConstants.LEFT);
		especialidadeLbl.setForeground(Color.GRAY);
		especialidadeLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		especialidadeLbl.setBackground(Color.WHITE);
		especialidadeLbl.setBounds(22, 456, 380, 24);
		frmClinicsystem.getContentPane().add(especialidadeLbl);
		
		queixaLbl = new JLabel("Queixa:");
		queixaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		queixaLbl.setForeground(Color.GRAY);
		queixaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		queixaLbl.setBackground(Color.WHITE);
		queixaLbl.setBounds(415, 161, 380, 24);
		frmClinicsystem.getContentPane().add(queixaLbl);
		
		queixaTextArea = new JTextArea(new TextFieldService(100));
		queixaTextArea.setForeground(Color.GRAY);
		queixaTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
		queixaTextArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		queixaTextArea.setBounds(412, 196, 667, 146);
		frmClinicsystem.getContentPane().add(queixaTextArea);
		
		prescricaoTextArea = new JTextArea(new TextFieldService(100));
		prescricaoTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
		prescricaoTextArea.setForeground(Color.GRAY);
		prescricaoTextArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		prescricaoTextArea.setBounds(415, 396, 360, 146);
		frmClinicsystem.getContentPane().add(prescricaoTextArea);
		
		JLabel prescricaoLbl = new JLabel("Prescrição:");
		prescricaoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		prescricaoLbl.setForeground(Color.GRAY);
		prescricaoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		prescricaoLbl.setBackground(Color.WHITE);
		prescricaoLbl.setBounds(418, 361, 357, 24);
		frmClinicsystem.getContentPane().add(prescricaoLbl);
		
		observacaoTextArea = new JTextArea(new TextFieldService(100));
		observacaoTextArea.setForeground(Color.GRAY);
		observacaoTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
		observacaoTextArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		observacaoTextArea.setBounds(785, 396, 294, 146);
		frmClinicsystem.getContentPane().add(observacaoTextArea);
		
		JLabel observacaoLbl = new JLabel("Observação:");
		observacaoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		observacaoLbl.setForeground(Color.GRAY);
		observacaoLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		observacaoLbl.setBackground(Color.WHITE);
		observacaoLbl.setBounds(788, 361, 291, 24);
		frmClinicsystem.getContentPane().add(observacaoLbl);
		
		dataLbl = new JLabel("Data:");
		dataLbl.setHorizontalAlignment(SwingConstants.LEFT);
		dataLbl.setForeground(Color.GRAY);
		dataLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		dataLbl.setBackground(Color.WHITE);
		dataLbl.setBounds(777, 65, 302, 24);
		frmClinicsystem.getContentPane().add(dataLbl);
		
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
		dataTextField.setBounds(777, 100, 302, 50);
		dataTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!(TextFieldService.validarTextFieldData(dataTextField))) {
					erroLbl.setText("O campo data deve conter apenas números");
				}
			}
		});
		frmClinicsystem.getContentPane().add(dataTextField);
		
		avisoLbl = new JLabel("");
		avisoLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		avisoLbl.setOpaque(true);
		avisoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		avisoLbl.setForeground(new Color(0, 102, 255));
		avisoLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		avisoLbl.setBackground(Color.WHITE);
		avisoLbl.setBounds(228, 63, 440, 24);
		frmClinicsystem.getContentPane().add(avisoLbl);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frmClinicsystem.getContentPane().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
		        	MedicoService medicoService = new MedicoService();
		        	
					medicoService.filtrarMedico(nomeMedicoTextField, especialidadeTextField);
					
				} catch (SQLException e) {
					erroLbl.setText("Ocorreu um erro inesperado");
				}
			}
		});
	}
}