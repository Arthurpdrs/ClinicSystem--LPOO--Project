package ui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.toedter.calendar.JCalendar;

import core.services.ConsultaService;

public class JanelaVisualizarAgenda {

	private JFrame frmClinicsystem;
	private JLabel barraAzul;
	private JLabel logoMenu;
	private JLabel titulodapaginaLbl;
	private JScrollPane scrollPane;
	private JTable agendaTable;

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
					JanelaVisualizarAgenda window = new JanelaVisualizarAgenda();
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
	public JanelaVisualizarAgenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicsystem = new JFrame();
		frmClinicsystem.setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaVisualizarAgenda.class.getResource("/midia/icone.png")));
		frmClinicsystem.setTitle("ClinicSystem");
		frmClinicsystem.getContentPane().setBackground(new Color(255, 255, 255));
		frmClinicsystem.getContentPane().setLayout(null);
		frmClinicsystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frmClinicsystem.dispose();
			}
		});

		scrollPane = new JScrollPane(agendaTable = new JTable());
		agendaTable.setForeground(Color.GRAY);
		agendaTable.setFont(new Font("Arial", Font.PLAIN, 12));
		agendaTable.setModel(new DefaultTableModel(
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
		scrollPane.setBounds(31, 422, 1048, 184);
		frmClinicsystem.getContentPane().add(scrollPane);
		
		titulodapaginaLbl = new JLabel("Visualizar agenda");
		titulodapaginaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		titulodapaginaLbl.setForeground(Color.WHITE);
		titulodapaginaLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		titulodapaginaLbl.setBackground(Color.WHITE);
		titulodapaginaLbl.setBounds(31, -1, 371, 55);
		frmClinicsystem.getContentPane().add(titulodapaginaLbl);
		
		logoMenu = new JLabel("");
		logoMenu.setIcon(new ImageIcon(JanelaVisualizarAgenda.class.getResource("/midia/logo_menu.png")));
		logoMenu.setBounds(919, -1, 160, 55);
		frmClinicsystem.getContentPane().add(logoMenu);
		
		barraAzul = new JLabel("");
		barraAzul.setBackground(new Color(0, 102, 255));
		barraAzul.setBounds(-1, -1, 1131, 55);
		barraAzul.setOpaque(true);
		frmClinicsystem.getContentPane().add(barraAzul);
		
		//Calendário
		final JCalendar calendar = new JCalendar();
		calendar.getMonthChooser().getSpinner().setFont(new Font("Arial", Font.PLAIN, 12));
		calendar.getMonthChooser().setBackground(Color.WHITE);
		calendar.setDecorationBackgroundColor(Color.WHITE);
		calendar.setBounds(31, 65, 1048, 346);
		frmClinicsystem.getContentPane().add(calendar);
		
		final JLabel erroLbl = new JLabel("Ocorreu um erro inesperado. Tente novamente.");
		erroLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		erroLbl.setOpaque(true);
		erroLbl.setHorizontalAlignment(SwingConstants.LEFT);
		erroLbl.setForeground(new Color(0, 102, 255));
		erroLbl.setFont(new Font("Arial", Font.PLAIN, 14));
		erroLbl.setBackground(Color.WHITE);
		erroLbl.setBounds(31, 606, 751, 24);
		frmClinicsystem.getContentPane().add(erroLbl);
		
		calendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
		       public void propertyChange(java.beans.PropertyChangeEvent evt) {
		    	   Date dataInicial = calendar.getDate();
		           SimpleDateFormat FormatadorDaData = new SimpleDateFormat("dd/MM/yyyy");
		           String dataFormatada = FormatadorDaData.format(dataInicial);	  
		           ConsultaService consultaService = new ConsultaService();
				   try {
					if(consultaService.horariosConsultas(agendaTable, dataFormatada)) {
						erroLbl.setText("Visualizando consultas do dia " + dataFormatada);
					} else {
						erroLbl.setText("");
					}
				   } catch (SQLException e) {
						erroLbl.setText("Ocorreu um erro inesperado. Tente novamente");
				   }
		       }
		});
		
		frmClinicsystem.setBackground(new Color(255, 255, 255));
		frmClinicsystem.setResizable(false);
		frmClinicsystem.setBounds(100, 100, 1120, 680);
		frmClinicsystem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}