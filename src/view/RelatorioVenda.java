package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.RelatorioController;
import Controller.VendasController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatorioVenda extends JInternalFrame {
	private RelatorioController controller;
	private JTable tbVenda;
	private JTable tbItemVenda;
	private JTextField txtID;
	private JButton btnButton;
	
	/**
	 * Create the frame.
	 */
	public RelatorioVenda() {
		initComponents();
		controller = new RelatorioController(this);
		iniciar();
	}
	
	public void iniciar() {
		this.controller.ListaVendas();
	}
	public void initComponents() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 981, 685);
		
		JLabel lblNewLabel = new JLabel("Relatorio Vendas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("Itens da Venda");
		
		txtID = new JTextField();
		txtID.setColumns(10);
		
		btnButton = new JButton("Relatorio Venda");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.buscarItemVenda();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 945, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 946, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnButton)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnButton))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
		);
		
		tbItemVenda = new JTable();
		tbItemVenda.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Venda", "ID item", "Quantidade Item", "Item Venda"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(tbItemVenda);
		
		tbVenda = new JTable();
		tbVenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Venda", "Valor Total", "Data", "ID Usuario", "ID Cliente"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbVenda);
		panel.setLayout(gl_panel);
	}

	public JTable getTbVenda() {
		return tbVenda;
	}

	public void setTbVenda(JTable tbVenda) {
		this.tbVenda = tbVenda;
	}

	public JTable getTbItemVenda() {
		return tbItemVenda;
	}

	public void setTbItemVenda(JTable tbItemVenda) {
		this.tbItemVenda = tbItemVenda;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public JButton getBtnButton() {
		return btnButton;
	}

	public void setBtnButton(JButton btnButton) {
		this.btnButton = btnButton;
	}
	
	
}
