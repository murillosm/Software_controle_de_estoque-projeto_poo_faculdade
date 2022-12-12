package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import model.dao.FornecedorDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroFornecedorFrame extends JInternalFrame {
	private static JComboBox cbxTipoPesquisa;
	private static CadastroFornecedorFrame telaCadastroCliente;
	private JTextField txtPesquisa;
	private FornecedorController controller;
	private JButton btnAddFornecedor;
	private JTable tbFornecedor;
	FornecedorDao fornecedorDao;
	FornecedorHelper helper;
	private JTextField txtID;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CadastroFornecedorFrame frame = new CadastroFornecedorFrame();
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
		this.controller.preencherFornecedor();
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
		tbFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.clickLinhaTabela();
			}
		});
		tbFornecedor.setFillsViewportHeight(true);
		tbFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tbFornecedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome Fantasia", "CNPJ", "Raz\u00E3o Social", "Telefone", "Telefone 2", "E-mail", "Endere\u00E7o", "Numero", "CEP", "Bairro", "Estado", "Cidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false
			};
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
		cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"ID", "Nome", "CNPJ" }));

		txtPesquisa = new JTextField();
		txtPesquisa.setColumns(10);

		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = (String) cbxTipoPesquisa.getSelectedItem();
				try {
					if (tipo.equals("ID")) {
						controller.buscarID();
					}else
						if (tipo.equals("Nome")) {
						controller.buscarNome(); 
					}else
						if (tipo.equals("CNPJ")) {
						controller.buscarCnpj();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"O item buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",
							null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
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

		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.excluirFornecedor();
			}
		});
		btnExcluir.setIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/lixo.png")));

		JButton btnVisualizar = new JButton("");
		btnVisualizar.setIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/olho.png")));

		JButton btnAtualizar = new JButton("");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.preencherFornecedor();
			}
		});
		btnAtualizar
				.setIcon(new ImageIcon(CadastroFornecedorFrame.class.getResource("/view/imagens/icons/reload.png")));
		
		JLabel ldID = new JLabel("ID:");
		ldID.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtID = new JTextField();
		txtID.setColumns(10);
		GroupLayout gl_panelPesquisaConfg = new GroupLayout(panelPesquisaConfg);
		gl_panelPesquisaConfg.setHorizontalGroup(
			gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
							.addGap(313)
							.addComponent(lblCadastrosFornecedores, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
							.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.TRAILING)
								.addComponent(cbxTipoPesquisa, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddFornecedor, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
									.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ldID)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 628, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
							.addGap(874)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
							.addGap(194)
							.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panelPesquisaConfg.setVerticalGroup(
			gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCadastrosFornecedores))
					.addGap(7)
					.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPesquisar)
						.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.BASELINE)
							.addComponent(cbxTipoPesquisa, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddFornecedor, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.BASELINE)
							.addComponent(ldID)
							.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
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

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}
	
	
}