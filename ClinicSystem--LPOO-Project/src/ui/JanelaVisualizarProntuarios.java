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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.services.FuncionarioService;
import core.services.ProntuarioService;
import core.services.TextFieldService;

import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class JanelaVisualizarProntuarios {

	private JFrame frmClinicsystem;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JTextField codigoDoPacienteTextField;
	private JLabel codigoDoPacienteLbl;
	private JButton pesquisarBtn;
	private JScrollPane scrollPane;
	private JTable prontuariosTable;
	private JLabel avisoLbl;

	public JFrame getJanela() {
		return this.frmClinicsystem;
	}
	
	public JanelaVisualizarProntuarios() {
		initialize();
	}

	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaVisualizarProntuarios.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		scrollPane = new JScrollPane(prontuariosTable = new JTable());
		prontuariosTable.setForeground(Color.GRAY);
		prontuariosTable.setFont(new Font("Arial", Font.PLAIN, 12));
		prontuariosTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome do(a) Paciente", "CPF do(a) Paciente", "M\u00E9dico(a)", "Especialidade", "Data", "Queixa", "Prescri\u00E7\u00E3o", "Observa\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setBounds(31, 162, 1048, 444);
		frmClinicsystem.getContentPane().add(scrollPane);
		
		titulodapaginaLbl = new JLabel("Visualizar prontuário");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(31, -1, 371, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaVisualizarProntuarios.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		barraAzul = new JLabel("");
		barraAzul.setBackground(new Color(0, 102, 255));
		barraAzul.setBounds(-1, -1, 1131, 55);
		barraAzul.setOpaque(true);
		frmClinicsystem.getContentPane().add(barraAzul);
		
		codigoDoPacienteTextField = new JTextField(new TextFieldService(11), null, 0);
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
		
		codigoDoPacienteLbl = new JLabel("Pesquisar CPF do paciente:");
		codigoDoPacienteLbl.setHorizontalAlignment(SwingConstants.LEFT);
		codigoDoPacienteLbl.setForeground(Color.GRAY);
		codigoDoPacienteLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		codigoDoPacienteLbl.setBackground(Color.WHITE);
		codigoDoPacienteLbl.setBounds(32, 65, 380, 24);
		frmClinicsystem.getContentPane().add(codigoDoPacienteLbl);
		
		
		pesquisarBtn = new JButton("");
		pesquisarBtn.setIcon(new ImageIcon(JanelaVisualizarProntuarios.class.getResource("/midia/lupa.png")));
		pesquisarBtn.setForeground(new Color(0, 102, 255));
		pesquisarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		pesquisarBtn.setContentAreaFilled(false);
		pesquisarBtn.setBorderPainted(false);
		pesquisarBtn.setBackground(Color.WHITE);
		pesquisarBtn.setBounds(997, 100, 97, 50);
		frmClinicsystem.getContentPane().add(pesquisarBtn);
		
		pesquisarBtn.addActionListener(new java.awt.event.ActionListener() {
			ProntuarioService prontuarioService = new ProntuarioService();
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	String cpf = codigoDoPacienteTextField.getText();
		    	if (TextFieldService.validarNumero(cpf)) {
		    		try {
						prontuarioService.filtrar(prontuariosTable, cpf);
						avisoLbl.setText("");
					} catch (SQLException e) {
						avisoLbl.setText("Ocorreu um erro inesperado");
					}
		    	} else {
		    		try {
		    			avisoLbl.setText("Não foi possível encontrar o paciente");
						prontuarioService.visualizarProntuarios(prontuariosTable);
					} catch (SQLException e) {
						avisoLbl.setText("Ocorreu um erro inesperado");
					}
		    	}
		    }
		});
		
		avisoLbl = new JLabel("Não foi possível encontrar o paciente");
		avisoLbl.setOpaque(true);
		avisoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		avisoLbl.setForeground(new Color(0, 102, 255));
		avisoLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		avisoLbl.setBackground(Color.WHITE);
		avisoLbl.setBounds(240, 65, 747, 24);
		frmClinicsystem.getContentPane().add(avisoLbl);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frmClinicsystem.getContentPane().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
		        	ProntuarioService prontuarioService = new ProntuarioService();
					prontuarioService.visualizarProntuarios(prontuariosTable);
				} catch (SQLException e) {
					avisoLbl.setText("Ocorreu um erro inesperado");
				}
			}
		});
	}
}