package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.FornecedorController;
import Controller.helpers.FornecedorHelper;
import model.dao.DaoFactory;
import model.dao.FornecedorDao;
import model.entities.Fornecedor;

public class CadastroFornecedorFrame extends JInternalFrame {
	private static JComboBox cbxTipoPesquisa;
	private static CadastroFornecedorFrame telaCadastroCliente;
	private JTextField txtPesquisa;
	private FornecedorController controller;
	private JButton btnAddFornecedor;
	private JTable tbFornecedor;
	FornecedorDao fornecedorDao;
	FornecedorHelper helper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFornecedorFrame frame = new CadastroFornecedorFrame();
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

	public static CadastroFornecedorFrame getInstacia() {
		if (telaCadastroCliente == null) {
			telaCadastroCliente = new CadastroFornecedorFrame();
		}
		return telaCadastroCliente;
	}

	public CadastroFornecedorFrame() {
		setEnabled(false);
		initComponents();
		controller = new FornecedorController(this);
		iniciar();
		helper = new FornecedorHelper(this);
//		try {
//			fornecedorDao = DaoFactory.createFornecedorDao();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}

	public void iniciar() {
		// this.controller.atualizarFornecedor();
	}

	public void initComponents() {
		setMaximizable(true);
		setFrameIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/trolley32.png")));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("Cadastros de Fonecedores");
		setBounds(100, 100, 978, 739);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		tbFornecedor = new JTable();
		tbFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		tbFornecedor.setFillsViewportHeight(true);
		tbFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tbFornecedor.setColumnSelectionAllowed(true);
		tbFornecedor.setCellSelectionEnabled(true);
		tbFornecedor.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome Fantasia", "CNPJ", "Raz\u00E3o Social", "Telefone", "Telefone 2", "E-mail",
						"Endere\u00E7o", "Numero", "Bairro", "Estado", "Cidade" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class, String.class, String.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbFornecedor.getColumnModel().getColumn(1).setPreferredWidth(194);
		tbFornecedor.getColumnModel().getColumn(3).setPreferredWidth(110);
		scrollPane.setViewportView(tbFornecedor);

		JPanel panelPesquisaConfg = new JPanel();
		getContentPane().add(panelPesquisaConfg, BorderLayout.NORTH);

		JLabel lblCadastrosFornecedores = new JLabel("Cadastros de Fonecedores");
		lblCadastrosFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrosFornecedores.setFont(new Font("Tahoma", Font.BOLD, 22));

		JLabel label_1 = new JLabel("");

		cbxTipoPesquisa = new JComboBox();
		cbxTipoPesquisa.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] { "Nome", "CNPJ", "ID" }));

		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//DefaultTableModel tableModel = (DefaultTableModel) tbFornecedor.getModel();
//				String tipo = cbxTipoPesquisa.getSelectedItem().toString().trim();
//				if (tipo.equals("Nome")) {
//					fornecedorDao.findByNome(txtPesquisa.getText());
//				}
//				if (tipo.equals("CNPJ")) {
//
//				}
//				if (tipo.equals("ID")) {
//
//				}

			}
		});
		txtPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("");
		btnPesquisar
				.setIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/procurar.png")));

		btnAddFornecedor = new JButton("");
		btnAddFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.novoFornecedor();
			}
		});
		btnAddFornecedor.setIcon(
				new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/novo-arquivo.png")));

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/lapis64.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/lixo.png")));

		JButton btnVisualizar = new JButton("");
		btnVisualizar.setIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/olho.png")));

		JButton btnAtualizar = new JButton("");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.atualizarFornecedor();
			}
		});
		btnAtualizar
				.setIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/reload.png")));
		GroupLayout gl_panelPesquisaConfg = new GroupLayout(panelPesquisaConfg);
		gl_panelPesquisaConfg.setHorizontalGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisaConfg.createSequentialGroup().addContainerGap().addGroup(gl_panelPesquisaConfg
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup().addGap(313).addComponent(
								lblCadastrosFornecedores, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
								.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.TRAILING)
										.addComponent(cbxTipoPesquisa, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAddFornecedor, 0, 0, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
												.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 64,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 64,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnVisualizar,
														GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 628,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelPesquisaConfg.createSequentialGroup().addGap(874).addComponent(
										label_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPesquisar,
												GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelPesquisaConfg.createSequentialGroup().addGap(194).addComponent(
										btnAtualizar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))));
		gl_panelPesquisaConfg
				.setVerticalGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup().addGap(11)
								.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCadastrosFornecedores))
								.addGap(7)
								.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
										.addComponent(btnPesquisar)
										.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.BASELINE)
												.addComponent(cbxTipoPesquisa, GroupLayout.PREFERRED_SIZE, 27,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														txtPesquisa, GroupLayout.PREFERRED_SIZE, 27,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 63,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAddFornecedor, GroupLayout.PREFERRED_SIZE, 63,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 63,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 63,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 63,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		panelPesquisaConfg.setLayout(gl_panelPesquisaConfg);

	}

	public static CadastroFornecedorFrame getTelaCadastroCliente() {
		return telaCadastroCliente;
	}

	public static void setTelaCadastroCliente(CadastroFornecedorFrame telaCadastroCliente) {
		CadastroFornecedorFrame.telaCadastroCliente = telaCadastroCliente;
	}

	public JTable getTbFornecedor() {
		return tbFornecedor;
	}

	public void setTbFornecedor(JTable tbFornecedor) {
		this.tbFornecedor = tbFornecedor;
	}

	public JTextField getTxtPesquisa() {
		return txtPesquisa;
	}

	public void setTxtPesquisa(JTextField txtPesquisa) {
		this.txtPesquisa = txtPesquisa;
	}

	public JButton getBtnAddFornecedor() {
		return btnAddFornecedor;
	}

	public void setBtnAddFornecedor(JButton btnAddFornecedor) {
		this.btnAddFornecedor = btnAddFornecedor;
	}

	public static void setCbxTipoPesquisa(JComboBox cbxTipoPesquisa) {
		CadastroFornecedorFrame.cbxTipoPesquisa = cbxTipoPesquisa;
	}

	public static JComboBox getCbxTipoPesquisa() {
		return cbxTipoPesquisa;
	}

	public static void setCbxTipoPesquisaBox(JComboBox cbxTipoPesquisa) {
		CadastroFornecedorFrame.cbxTipoPesquisa = cbxTipoPesquisa;
	}
}
