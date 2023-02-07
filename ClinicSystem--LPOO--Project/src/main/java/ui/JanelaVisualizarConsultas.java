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

import core.services.ConsultaService;
import core.services.EmailService;
import core.services.PacienteService;
import core.services.TextFieldService;

import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class JanelaVisualizarConsultas {

	private JFrame frmClinicsystem;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JTextField codigoDoPacienteTextField;
	private JLabel codigoDoPacienteLbl;
	private JButton pesquisarBtn;
	private JScrollPane scrollPane;
	private JTable consultasTable;
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
					JanelaVisualizarConsultas window = new JanelaVisualizarConsultas();
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
	public JanelaVisualizarConsultas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaVisualizarConsultas.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});

		scrollPane = new JScrollPane(consultasTable = new JTable());
		consultasTable.setForeground(Color.GRAY);
		consultasTable.setFont(new Font("Arial", Font.PLAIN, 12));
		consultasTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome completo", "E-mail", "CPF", "Observa\u00E7\u00E3o", "Especialidade", "M\u00E9dico(a)", "Data da consulta", "Hor\u00E1rio da consulta", "Valor", "Estado", "ID"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setBounds(31, 162, 1048, 356);
		frmClinicsystem.getContentPane().add(scrollPane);
		
		titulodapaginaLbl = new JLabel("Visualizar consultas");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(31, -1, 371, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaVisualizarConsultas.class.getResource("/midia/logo_menu.png")));
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
		erroLbl.setBounds(31, 545, 1055, 14);
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
				int linha = consultasTable.getSelectedRow();
		        if(linha != -1) {
		        	int id = Integer.parseInt(consultasTable.getValueAt(linha, 10).toString());
		        	String data = consultasTable.getValueAt(linha, 6).toString();
		            String horario = consultasTable.getValueAt(linha, 7).toString();
		            String valor = consultasTable.getValueAt(linha, 8).toString();
		            String pago = consultasTable.getValueAt(linha, 9).toString();
		        	ConsultaService consultaService = new ConsultaService();
		        	try {
						if(consultaService.alterar(data, valor, pago, horario, id)) {
							erroLbl.setText("Consulta editada com sucesso");
						} else {
							erroLbl.setText("Verifique os campos e formatos informados");
						}
					} catch (SQLException e) {
						erroLbl.setText("Ocorreu um erro inesperado. Tente novamente");					}
		        }
		    }
		});
		
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
		    	int linha = consultasTable.getSelectedRow();
		        if(linha != -1) {
		        	int id = Integer.parseInt(consultasTable.getValueAt(linha, 10).toString());
		        	ConsultaService consultaService = new ConsultaService();
		        	try {
		        		if(consultaService.remover(id)) {
		        			erroLbl.setText("Consulta apagada com sucesso.");
		        			((DefaultTableModel) consultasTable.getModel()).removeRow(linha);
		        		} else {
		        			erroLbl.setText("Não foi possível deletar a consulta.");
		        		}
						
					} catch (SQLException e) {
						erroLbl.setText("Ocorreu um erro inesperado");
					}
		        }
		    }
		});
		
		pesquisarBtn = new JButton("");
		pesquisarBtn.setIcon(new ImageIcon(JanelaVisualizarConsultas.class.getResource("/midia/lupa.png")));
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

				  ConsultaService consultaService = new ConsultaService();
	 		      if (TextFieldService.validarNumero(cpf)) {
				      try {
						boolean retorno = consultaService.filtrar(consultasTable, cpf);
						if (retorno == false) {
							avisoLbl.setText("Não foi possível encontrar a consulta");
							consultaService.visualizarConsultas(consultasTable);
						} else {
							avisoLbl.setText("");
						}
					} catch (SQLException e) {
						avisoLbl.setText("Ocorreu um erro inesperado. Tente novamente");
					}
	 		      } else {
	 		    	  avisoLbl.setText("CPF inválido");
	 		    	  try {
						consultaService.visualizarConsultas(consultasTable);
					} catch (SQLException e) {
						avisoLbl.setText("Ocorreu um erro inesperado. Tente novamente");
					}
	 		      }
		    }
		});
		
		JButton lembrarBtn = new JButton("");
		lembrarBtn.setToolTipText("Enviar lembrete de consulta via e-mail");
		lembrarBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		lembrarBtn.setIcon(new ImageIcon(JanelaVisualizarConsultas.class.getResource("/midia/sino.png")));
		lembrarBtn.setForeground(Color.GRAY);
		lembrarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		lembrarBtn.setContentAreaFilled(false);
		lembrarBtn.setBorderPainted(false);
		lembrarBtn.setBackground(Color.WHITE);
		lembrarBtn.setBounds(31, 567, 89, 49);
		frmClinicsystem.getContentPane().add(lembrarBtn);
		
		lembrarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	int linha = consultasTable.getSelectedRow();
		        if(linha != -1) {
		        	String email = consultasTable.getValueAt(linha, 1).toString();
		        	String nome = consultasTable.getValueAt(linha, 0).toString();
		        	String data = consultasTable.getValueAt(linha, 6).toString();
		        	String horario = consultasTable.getValueAt(linha, 7).toString();
		        	String profissional = consultasTable.getValueAt(linha, 5).toString();
		        		if(TextFieldService.validarEmail(email) && TextFieldService.validarData(data) && TextFieldService.validarHorario(horario)) {
		        			try {
								if(EmailService.enviarEmail("lembrete", email, nome, data, horario, profissional)) {
									erroLbl.setText("E-mail enviado com sucesso.");
								} else {
									erroLbl.setText("Não foi possível enviar o e-mail.");
								}
							} catch (SQLException e) {
								erroLbl.setText("Não foi possível enviar o e-mail.");
							}
		        		} else {
		        			erroLbl.setText("Não foi possível enviar o e-mail. Verifique os campos e formatos informados");
		        		}
		        }
		    }
		});
		
		//Botão
		JButton cancelarBtn = new JButton("");
		cancelarBtn.setIcon(new ImageIcon(JanelaVisualizarConsultas.class.getResource("/midia/block.png")));
		cancelarBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		cancelarBtn.setToolTipText("Enviar aviso de cancelamento de consulta via e-mail");
		cancelarBtn.setForeground(Color.GRAY);
		cancelarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		cancelarBtn.setContentAreaFilled(false);
		cancelarBtn.setBorderPainted(false);
		cancelarBtn.setBackground(Color.WHITE);
		cancelarBtn.setBounds(130, 567, 89, 49);
		frmClinicsystem.getContentPane().add(cancelarBtn);
		
		avisoLbl = new JLabel("");
		avisoLbl.setOpaque(true);
		avisoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		avisoLbl.setForeground(new Color(0, 102, 255));
		avisoLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		avisoLbl.setBackground(Color.WHITE);
		avisoLbl.setBounds(240, 65, 747, 24);
		frmClinicsystem.getContentPane().add(avisoLbl);
		
		cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	int linha = consultasTable.getSelectedRow();
		        if(linha != -1) {
		        	String email = consultasTable.getValueAt(linha, 1).toString();
		        	String nome = consultasTable.getValueAt(linha, 0).toString();
		        	String data = consultasTable.getValueAt(linha, 6).toString();
		        	String horario = consultasTable.getValueAt(linha, 7).toString();
		        	String profissional = consultasTable.getValueAt(linha, 5).toString();
		        		if(TextFieldService.validarEmail(email) && TextFieldService.validarData(data) && TextFieldService.validarHorario(horario)) {
		        			try {
								if(EmailService.enviarEmail("cancelamento", email, nome, data, horario, profissional)) {
									erroLbl.setText("E-mail enviado com sucesso.");
								} else {
									erroLbl.setText("Não foi possível enviar o e-mail.");
								}
							} catch (SQLException e) {
								erroLbl.setText("Não foi possível enviar o e-mail.");
							}
		        		} else {
		        			erroLbl.setText("Não foi possível enviar o e-mail. Verifique os campos e formatos informados");
		        		}
		        }
		    }
		});
		
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frmClinicsystem.getContentPane().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					ConsultaService consultaService = new ConsultaService();
					consultaService.visualizarConsultas(consultasTable);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}
}