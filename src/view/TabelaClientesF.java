package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

public class TabelaClientesF extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaClientesF frame = new TabelaClientesF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		setMaximizable(true);
		setFrameIcon(null);
		setTitle("Clientes Pessoas Fisicas");

		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 1903, 539);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "", "ID", "Nome", "CPF", "Data de Nascimento",
						"Telefone", "Telefone 2", "E-mail", "Endere\u00E7o", "Numero", "Bairro", "Estado", "Cidade" }) {
					Class[] columnTypes = new Class[] { Boolean.class, Integer.class, String.class, String.class,
							Object.class, String.class, String.class, String.class, String.class, String.class,
							String.class, Object.class, Object.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		table.getColumnModel().getColumn(2).setPreferredWidth(194);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

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
					.addContainerGap()
					.addComponent(btnExcluirCliente, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditarCliente, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVisualizarCliente, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1673, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVisualizarCliente, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluirCliente, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
						.addComponent(btnEditarCliente, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

	}
}
