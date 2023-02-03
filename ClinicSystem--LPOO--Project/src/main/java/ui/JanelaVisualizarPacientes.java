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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.model.Clinica;
import core.services.ClinicaService;
import core.services.PacienteService;
import core.services.TextFieldService;

import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class JanelaVisualizarPacientes {

	private JFrame frmClinicsystem;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JTextField codigoDoPacienteTextField;
	private JLabel codigoDoPacienteLbl;
	private JButton pesquisarBtn;
	private JScrollPane scrollPane;
	private JTable pacientesTable;
	private JLabel avisoLbl;

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
					JanelaVisualizarPacientes window = new JanelaVisualizarPacientes();
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
	public JanelaVisualizarPacientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaVisualizarPacientes.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		scrollPane = new JScrollPane(pacientesTable = new JTable());
		pacientesTable.setForeground(Color.GRAY);
		pacientesTable.setFont(new Font("Arial", Font.PLAIN, 12));
		pacientesTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome completo", "Endere\u00E7o", "CPF", "E-mail", "Celular", "Tipo sangu\u00EDneo", "Alergia", "Observa\u00E7\u00E3o", "Data de nascimento", "Respons\u00E1vel - Nome completo", "Respons\u00E1vel - Celular", "Respons\u00E1vel - CPF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true, true, true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setBounds(31, 162, 1048, 356);
		frmClinicsystem.getContentPane().add(scrollPane);
		
		titulodapaginaLbl = new JLabel("Visualizar pacientes");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(32, -1, 370, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaVisualizarPacientes.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		barraAzul = new JLabel("");
		barraAzul.setBackground(new Color(0, 102, 255));
		barraAzul.setBounds(-1, -1, 1131, 55);
		barraAzul.setOpaque(true);
		frmClinicsystem.getContentPane().add(barraAzul);
		
		erroLbl = new JLabel("");
		erroLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		erroLbl.setForeground(new Color(0, 102, 255));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(415, 544, 664, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		JButton editarBtn = new JButton("Editar");
		editarBtn.setBorderPainted(false);
		editarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarBtn.setBackground(new Color(255, 255, 255));
		editarBtn.setForeground(new Color(0, 102, 255));
		editarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		editarBtn.setBounds(997, 582, 89, 34);
		editarBtn.setContentAreaFilled(false);
		frmClinicsystem.getContentPane().add(editarBtn);
		
		editarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	int linha = pacientesTable.getSelectedRow();
		        if(linha != -1) {
		        	String nome = pacientesTable.getValueAt(linha, 0).toString();
		        	String endereco = pacientesTable.getValueAt(linha, 1).toString();
		        	String cpf = pacientesTable.getValueAt(linha, 2).toString();
		        	String email = pacientesTable.getValueAt(linha, 3).toString();
		        	String telefone = pacientesTable.getValueAt(linha, 4).toString();
		        	String tipoSanguineo = pacientesTable.getValueAt(linha, 5).toString();
		        	String alergia = pacientesTable.getValueAt(linha, 6).toString();
		        	String observacao = pacientesTable.getValueAt(linha, 7).toString();
		        	String dataNascimento = pacientesTable.getValueAt(linha, 8).toString();
		        	String nomeResponsavel = pacientesTable.getValueAt(linha, 9).toString();
		        	String telefoneResponsavel = pacientesTable.getValueAt(linha, 10).toString();
		        	String cpfResponsavel = pacientesTable.getValueAt(linha, 11).toString();
		        	
		        	if (TextFieldService.validarNumero(telefone)) {
		        		erroLbl.setText("Telefone deve conter apenas números");
		        	} else {
			        	PacienteService pacienteService = new PacienteService();
			        	try {
							if(pacienteService.alterarPaciente(cpf, nome, email, telefone, alergia, tipoSanguineo, dataNascimento, endereco, cpfResponsavel, nomeResponsavel, telefoneResponsavel, observacao)) {
								erroLbl.setText("Paciente editado com sucesso");
							} else {
								erroLbl.setText("Não foi possível editar o paciente. Verifique os valores informados");
							}
							
						} catch (SQLException e) {
							erroLbl.setText("Ocorreu um erro inesperado. Tente novamente");
						}
			        	}
		        }
		    }
		});
		
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
		
		codigoDoPacienteLbl = new JLabel("Pesquisar CPF do paciente:");
		codigoDoPacienteLbl.setHorizontalAlignment(SwingConstants.LEFT);
		codigoDoPacienteLbl.setForeground(Color.GRAY);
		codigoDoPacienteLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		codigoDoPacienteLbl.setBackground(Color.WHITE);
		codigoDoPacienteLbl.setBounds(32, 65, 380, 24);
		frmClinicsystem.getContentPane().add(codigoDoPacienteLbl);
		
		JButton excluirBtn = new JButton("Excluir");
		excluirBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		excluirBtn.setForeground(Color.GRAY);
		excluirBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		excluirBtn.setContentAreaFilled(false);
		excluirBtn.setBorderPainted(false);
		excluirBtn.setBackground(Color.WHITE);
		excluirBtn.setBounds(898, 582, 89, 34);
		frmClinicsystem.getContentPane().add(excluirBtn);
		
		excluirBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	int linha = pacientesTable.getSelectedRow();
		        if(linha != -1) {
		        	String cpf = pacientesTable.getValueAt(linha, 2).toString();
		        	PacienteService pacienteService = new PacienteService();
		        	try {
		        		if(pacienteService.deletarPaciente(cpf)) {
		        			erroLbl.setText("Paciente apagado com sucesso.");
		        			((DefaultTableModel) pacientesTable.getModel()).removeRow(linha);
		        		} else {
		        			erroLbl.setText("Não foi possível deletar o paciente.");
		        		}
						
					} catch (SQLException e) {
						erroLbl.setText("Ocorreu um erro inesperado");
					}
		        }
		    }
		});
		
		pesquisarBtn = new JButton("");
		pesquisarBtn.setIcon(new ImageIcon(JanelaVisualizarPacientes.class.getResource("/midia/lupa.png")));
		pesquisarBtn.setForeground(new Color(0, 102, 255));
		pesquisarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		pesquisarBtn.setContentAreaFilled(false);
		pesquisarBtn.setBorderPainted(false);
		pesquisarBtn.setBackground(Color.WHITE);
		pesquisarBtn.setBounds(997, 100, 97, 50);
		frmClinicsystem.getContentPane().add(pesquisarBtn);
		
		pesquisarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		      String cpf = codigoDoPacienteTextField.getText();
		      try {
			    PacienteService pacienteService = new PacienteService();
				boolean retorno = pacienteService.visualizarPacientesFiltrados(pacientesTable, cpf);
				if (retorno == false) {
					avisoLbl.setText("Não foi possível encontrar o paciente");
					pacienteService.visualizarPacientes(pacientesTable);
				} else {
					avisoLbl.setText("");
				}
			} catch (SQLException e) {
				avisoLbl.setText("Ocorreu um erro inesperado. Tente novamente");
			}
		    }
		});
		
		avisoLbl = new JLabel("");
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
		frmClinicsystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmClinicsystem.getContentPane().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
		        	PacienteService pacienteService = new PacienteService();
					pacienteService.visualizarPacientes(pacientesTable);
				} catch (SQLException e) {
					avisoLbl.setText("Ocorreu um erro inesperado. Tente novamente");
				}
			}
		});
	}
}