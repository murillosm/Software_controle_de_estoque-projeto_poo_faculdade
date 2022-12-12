package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ClienteController;
import Controller.TabelaClienteFisicoController;

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

public class TabelaClientesF extends JInternalFrame {
	private JTable tbClienteF;
	private TabelaClienteFisicoController controller;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TabelaClientesF frame = new TabelaClientesF();
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

	private static TabelaClientesF tabelaClientesF;

	public static TabelaClientesF getInstacia() {
		if (tabelaClientesF == null) {
			tabelaClientesF = new TabelaClientesF();
		}
		return tabelaClientesF;
	}

	public TabelaClientesF() {
		initComponents();
		controller = new TabelaClienteFisicoController(this);
		iniciar();
	}
	
	private void initComponents() {
		setMaximizable(true);
		setFrameIcon(null);
		setTitle("Clientes Pessoas Fisicas");

		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 972, 514);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);

		tbClienteF = new JTable();
		tbClienteF.setSurrendersFocusOnKeystroke(true);
		tbClienteF.setFillsViewportHeight(true);
		tbClienteF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tbClienteF.setColumnSelectionAllowed(true);
		tbClienteF.setCellSelectionEnabled(true);
		tbClienteF.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Data de Nascimento", "Telefone", "Telefone 2", "E-mail", "Endere\u00E7o", "Numero", "Bairro", "Estado", "Cidade"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbClienteF.getColumnModel().getColumn(1).setPreferredWidth(194);
		tbClienteF.getColumnModel().getColumn(3).setPreferredWidth(110);
		scrollPane.setViewportView(tbClienteF);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.atualizarClienteF();
			}
		});
		btnAtualizar.setIcon(new ImageIcon(TabelaClientesF.class.getResource("/view/imagens/icons/reload.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(882, Short.MAX_VALUE)
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

	private void iniciar() {
		//this.controller.atualizarClienteF();
	}

	public JTable getTbClienteF() {
		return tbClienteF;
	}

	public void setTbClienteF(JTable tbClienteF) {
		this.tbClienteF = tbClienteF;
	}
	
	
}
