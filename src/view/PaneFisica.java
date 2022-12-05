package view;

import java.awt.Font;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PaneFisica extends JPanel {
	
	private JTable table;

	public PaneFisica() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "", "ID", "Nome", "CPF", "Data de Nascimento",
						"Telefone", "Telefone 2", "E-mail", "Endere\u00E7o", "Numero", "Bairro", "Estado", "Cidade" }) {
					Class[] columnTypes = new Class[] { Boolean.class, Integer.class, String.class, String.class,
							Date.class, String.class, String.class, String.class, String.class, String.class,
							String.class, Object.class, Object.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		table.getColumnModel().getColumn(2).setPreferredWidth(194);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		//getContentPane().add(panel, BorderLayout.NORTH);

		JButton btnExcluirCliente = new JButton("");
		btnExcluirCliente.setIcon(new ImageIcon(TabelaClientesF.class.getResource("/view/imagens/icons/lixo.png")));

		JButton btnEditarCliente = new JButton("");
		btnEditarCliente.setIcon(new ImageIcon(TabelaClientesF.class.getResource("/view/imagens/icons/lapis64.png")));

		JButton btnVisualizarCliente = new JButton("");
		btnVisualizarCliente.setIcon(new ImageIcon(TabelaClientesF.class.getResource("/view/imagens/icons/olho.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(btnExcluirCliente, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnEditarCliente, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnVisualizarCliente, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExcluirCliente, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditarCliente, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVisualizarCliente, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
	}

}
