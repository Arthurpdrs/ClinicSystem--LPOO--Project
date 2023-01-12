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
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaVisualizarProfissionais {

	private JFrame frmClinicsystem;
	private JLabel erroLbl;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JTextField codigoDoProfissionalTextField;
	private JLabel codigoDoProfissionalLbl;
	private JButton pesquisarBtn;
	private JScrollPane scrollPane;
	private JTable profissionaisTable;
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
					JanelaVisualizarProfissionais window = new JanelaVisualizarProfissionais();
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
	public JanelaVisualizarProfissionais() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaVisualizarProfissionais.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});
		
		scrollPane = new JScrollPane(profissionaisTable = new JTable());
		profissionaisTable.setForeground(Color.GRAY);
		profissionaisTable.setFont(new Font("Arial", Font.PLAIN, 12));
		profissionaisTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome completo", "Usu\u00E1rio", "Senha", "CPF", "E-mail", "Telefone", "Fun\u00E7\u00E3o", "Especialidade", "CRM"
			}
		));
		scrollPane.setBounds(31, 162, 1048, 356);
		frmClinicsystem.getContentPane().add(scrollPane);
		
		titulodapaginaLbl = new JLabel("Visualizar profissionais");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(31, -1, 371, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaVisualizarProfissionais.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		barraAzul = new JLabel("");
		barraAzul.setBackground(new Color(0, 102, 255));
		barraAzul.setBounds(-1, -1, 1131, 55);
		barraAzul.setOpaque(true);
		frmClinicsystem.getContentPane().add(barraAzul);
		
		erroLbl = new JLabel("Excluído com sucesso");
		erroLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		erroLbl.setForeground(new Color(0, 102, 255));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(422, 545, 664, 14);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		//Botão
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
		        //Inserir ação aqui
		    }
		});
		
		
		codigoDoProfissionalTextField = new JTextField();
		codigoDoProfissionalTextField.setToolTipText("");
		codigoDoProfissionalTextField.setMargin(new Insets(10, 10, 10, 10));
		codigoDoProfissionalTextField.setHorizontalAlignment(SwingConstants.LEFT);
		codigoDoProfissionalTextField.setForeground(Color.GRAY);
		codigoDoProfissionalTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		codigoDoProfissionalTextField.setColumns(10);
		codigoDoProfissionalTextField.setBackground(Color.WHITE);
		codigoDoProfissionalTextField.setActionCommand("");
		codigoDoProfissionalTextField.setBounds(32, 100, 955, 50);
		frmClinicsystem.getContentPane().add(codigoDoProfissionalTextField);
		
		codigoDoProfissionalLbl = new JLabel("Pesquisar CPF do profissional:");
		codigoDoProfissionalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		codigoDoProfissionalLbl.setForeground(Color.GRAY);
		codigoDoProfissionalLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		codigoDoProfissionalLbl.setBackground(Color.WHITE);
		codigoDoProfissionalLbl.setBounds(32, 65, 380, 24);
		frmClinicsystem.getContentPane().add(codigoDoProfissionalLbl);
		
		//Botão
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
		        //Inserir ação aqui
		    }
		});
		
		//Botão
		pesquisarBtn = new JButton("");
		pesquisarBtn.setIcon(new ImageIcon(JanelaVisualizarProfissionais.class.getResource("/midia/lupa.png")));
		pesquisarBtn.setForeground(new Color(0, 102, 255));
		pesquisarBtn.setFont(new Font("Arial", Font.PLAIN, 16));
		pesquisarBtn.setContentAreaFilled(false);
		pesquisarBtn.setBorderPainted(false);
		pesquisarBtn.setBackground(Color.WHITE);
		pesquisarBtn.setBounds(997, 100, 97, 50);
		frmClinicsystem.getContentPane().add(pesquisarBtn);
		
		pesquisarBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        //Inserir ação aqui
		    }
		});
		
		avisoLbl = new JLabel("Não foi possível encontrar o profissional");
		avisoLbl.setOpaque(true);
		avisoLbl.setHorizontalAlignment(SwingConstants.LEFT);
		avisoLbl.setForeground(new Color(0, 102, 255));
		avisoLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		avisoLbl.setBackground(Color.WHITE);
		avisoLbl.setBounds(257, 65, 730, 24);
		frmClinicsystem.getContentPane().add(avisoLbl);
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
