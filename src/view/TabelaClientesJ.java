package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.TabelaClienteFisicoController;
import Controller.TabelaClienteJuridicoController;

import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabelaClientesJ extends JInternalFrame {
	private JTable tbClienteJ;
	private TabelaClienteJuridicoController controller;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TabelaClientesJ frame = new TabelaClientesJ();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

	private static TabelaClientesJ tabelaClientesF;

	public static TabelaClientesJ getInstacia() {
		if (tabelaClientesF == null) {
			tabelaClientesF = new TabelaClientesJ();
		}
		return tabelaClientesF;
	}
	
	public TabelaClientesJ() {
		initComponents();
		controller = new TabelaClienteJuridicoController(this);
		iniciar();
	}
	
	private void iniciar() {
		//this.controller.atualizarClienteJ();
	}

	public void initComponents(){
		setMaximizable(true);
		setFrameIcon(null);
		setTitle("Clientes Pessoas Juridica");

		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 993, 539);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);

		tbClienteJ = new JTable();
		tbClienteJ.setFillsViewportHeight(true);
		tbClienteJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tbClienteJ.setColumnSelectionAllowed(true);
		tbClienteJ.setCellSelectionEnabled(true);
		tbClienteJ.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome Fantasia", "CNPJ", "Raz\u00E3o Social", "Telefone", "Telefone 2", "E-mail", "Endere\u00E7o", "Numero", "Bairro", "Estado", "Cidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbClienteJ.getColumnModel().getColumn(1).setPreferredWidth(194);
		tbClienteJ.getColumnModel().getColumn(3).setPreferredWidth(110);
		scrollPane.setViewportView(tbClienteJ);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.atualizarClienteJ();
			}
		});
		btnAtualizar.setIcon(new ImageIcon(TabelaClientesJ.class.getResource("/view/imagens/icons/reload.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(903, Short.MAX_VALUE)
					.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

	}

	public JTable getTbClienteJ() {
		return tbClienteJ;
	}

	public void setTbClienteJ(JTable tbClienteJ) {
		this.tbClienteJ = tbClienteJ;
	}
	
	
}
