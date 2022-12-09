package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.EstoqueController;
import model.dao.DaoFactory;
import model.dao.EstoqueDao;
import model.entities.Estoque;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EstoqueFrame extends JInternalFrame {
	private JTable tbEstoque;
	private JTextField txtId;
	private JTextField txtNomeItem;
	private JTextField txtValor;
	private JTextField txtMarca;
	private JTextField txtQtd;
	private JTextPane txtDescricao;
	private JComboBox cbxFornecedor;
	private Estoque produto;
	private EstoqueController controller;
	private JButton btNovo;
	private JButton btSalvar;
	private JButton btCancelar;
	private JTextField txtPesquisa;
	private JComboBox cbxTipoPesquisa;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstoqueFrame frame = new EstoqueFrame();
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
	public EstoqueFrame() {
		setFrameIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/package-box32.png")));
		initComponents();
		controller = new EstoqueController(this);
		iniciar();

	}

	public void iniciar() {
		this.controller.boxFornecedor();
		this.controller.preecherEstoque();
	}

	public void initComponents() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1006, 591);

		JPanel dados = new JPanel();
		getContentPane().add(dados, BorderLayout.NORTH);

		JLabel lbCodItem = new JLabel("Código");
		lbCodItem.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setText("0");
		txtId.setColumns(10);

		txtNomeItem = new JTextField();
		txtNomeItem.setEnabled(false);
		txtNomeItem.setColumns(10);

		JLabel lbNomeItem = new JLabel("Item");
		lbNomeItem.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setColumns(10);

		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setColumns(10);

		JLabel lbQuantidade = new JLabel("Quantidade");
		lbQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtQtd = new JTextField();
		txtQtd.setEnabled(false);
		txtQtd.setColumns(10);

		JLabel lbFornecedor = new JLabel("Fornecedor");
		lbFornecedor.setFont(new Font("Tahoma", Font.BOLD, 13));

		cbxFornecedor = new JComboBox();
		cbxFornecedor.setEnabled(false);
		cbxFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.boxFornecedor();
			}
		});

		JLabel lbDescrição = new JLabel("Descrição");
		lbDescrição.setFont(new Font("Tahoma", Font.BOLD, 13));

		JScrollPane paneDescrição = new JScrollPane();

		btNovo = new JButton("");
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.limparJText();
				cbxFornecedor.setEditable(true);
				controller.habilitar();
				btSalvar.setEnabled(true);
				btnExcluir.setEnabled(false);
				btnEditar.setEnabled(false);
				btnAlterar.setEnabled(false);
			}
		});
		btNovo.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/novo-arquivo.png")));

		JLabel lblreal = new JLabel("R$");
		lblreal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblreal.setHorizontalAlignment(SwingConstants.RIGHT);

		btSalvar = new JButton("Salvar");
		btSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btSalvar.setEnabled(false);
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.novoEstoque();
				controller.desabilitar();
			}
		});

		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.desabilitar();
			}
		});
		btCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btCancelar.setEnabled(false);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.editarEstoque();
				controller.desabilitar();
				btnAlterar.setEnabled(true);
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lbCadastroProdutos = new JLabel("Itens no estoque");
		lbCadastroProdutos.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbCadastroProdutos.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));

		GroupLayout gl_dados = new GroupLayout(dados);
		gl_dados.setHorizontalGroup(gl_dados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dados.createSequentialGroup().addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dados.createSequentialGroup().addContainerGap().addGroup(gl_dados
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dados.createSequentialGroup()
										.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
												.addComponent(cbxFornecedor, GroupLayout.PREFERRED_SIZE, 162,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lbFornecedor, GroupLayout.PREFERRED_SIZE, 74,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_dados.createSequentialGroup().addGap(6).addComponent(
														lbDescrição, GroupLayout.PREFERRED_SIZE, 74,
														GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_dados.createSequentialGroup().addGap(12).addComponent(
														paneDescrição, GroupLayout.DEFAULT_SIZE, 1059,
														Short.MAX_VALUE))))
								.addGroup(gl_dados.createSequentialGroup().addGroup(gl_dados
										.createParallelGroup(Alignment.LEADING)
										.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lbCodItem)).addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_dados.createParallelGroup(Alignment.LEADING).addGroup(gl_dados
												.createSequentialGroup()
												.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
														.addComponent(txtNomeItem, GroupLayout.PREFERRED_SIZE, 141,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lbNomeItem, GroupLayout.PREFERRED_SIZE, 43,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblreal)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
														.addComponent(lbValor, GroupLayout.PREFERRED_SIZE, 43,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtValor, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
														.addComponent(lbMarca, GroupLayout.PREFERRED_SIZE, 43,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, 141,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
														.addComponent(txtQtd, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lbQuantidade)))
												.addComponent(lbCadastroProdutos, GroupLayout.PREFERRED_SIZE, 550,
														GroupLayout.PREFERRED_SIZE))
										.addGap(112))))
						.addComponent(btNovo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_dados.createSequentialGroup().addContainerGap()
								.addComponent(btCancelar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btSalvar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAlterar))
						.addGroup(gl_dados.createSequentialGroup().addContainerGap().addComponent(panel,
								GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_dados.setVerticalGroup(gl_dados.createParallelGroup(Alignment.TRAILING).addGroup(gl_dados
				.createSequentialGroup()
				.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
						.addComponent(btNovo, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_dados.createSequentialGroup().addGap(11).addComponent(
								lbCadastroProdutos, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
				.addGap(20)
				.addGroup(gl_dados.createParallelGroup(Alignment.TRAILING).addGroup(gl_dados.createSequentialGroup()
						.addComponent(lbNomeItem, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtNomeItem,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_dados.createSequentialGroup().addComponent(lbCodItem)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_dados.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_dados.createSequentialGroup()
										.addComponent(lbMarca, GroupLayout.PREFERRED_SIZE, 16,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(txtMarca, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_dados.createSequentialGroup()
										.addComponent(
												lbValor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addGroup(gl_dados.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtValor, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblreal)))
								.addGroup(gl_dados.createSequentialGroup()
										.addComponent(lbQuantidade, GroupLayout.PREFERRED_SIZE, 16,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(txtQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
				.addGap(6)
				.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
						.addComponent(lbFornecedor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbDescrição, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dados.createSequentialGroup()
								.addComponent(cbxFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(44)
								.addGroup(gl_dados.createParallelGroup(Alignment.BASELINE).addComponent(btCancelar)
										.addComponent(btSalvar).addComponent(btnAlterar)))
						.addComponent(paneDescrição, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
				.addGap(11)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("     Pesquisar produto          ");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		cbxTipoPesquisa = new JComboBox();
		panel.add(cbxTipoPesquisa);
		cbxTipoPesquisa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		cbxTipoPesquisa.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] { "Nome", "Marca", "Fornecedor", "codigo" }));

		txtPesquisa = new JTextField();
		panel.add(txtPesquisa);
		txtPesquisa.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtPesquisa.setColumns(10);

		JButton btPesquisa = new JButton("Buscar");
		btPesquisa.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(btPesquisa);
		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxFornecedor.setEditable(false);
				controller.habilitar();
				btnExcluir.setEnabled(true);
				btnEditar.setEnabled(true);
				String tipo = cbxTipoPesquisa.getSelectedItem().toString().trim();
				try {
					if (tipo.equals("Nome")) {
						controller.buscarItemNome();
						//controller.preecherEstoquePesquisaNome();
					}
					if (tipo.equals("Marca")) {
						controller.buscarItemMarca();
					}
					if (tipo.equals("Fornecedor")) {
						controller.buscarItemForn();
					}
					if (tipo.equals("codigo")) {
						
						controller.buscarItemID();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"O item buscado não existe ou foi escrito incorretamente \nVerifique se o valor digitado esta escrito corretamente",
							null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btPesquisa.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/procurar.png")));

		txtDescricao = new JTextPane();
		txtDescricao.setEnabled(false);
		paneDescrição.setViewportView(txtDescricao);
		dados.setLayout(gl_dados);

		JPanel opções = new JPanel();
		getContentPane().add(opções, BorderLayout.SOUTH);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.excluirEstoque();
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/lixo.png")));

		btnEditar = new JButton("");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxFornecedor.setEditable(true);
				controller.habilitar();
				btnExcluir.setEnabled(false);
				btnEditar.setEnabled(false);
				btnAlterar.setEnabled(true);
			}
		});
		btnEditar.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/lapis64.png")));

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.limparJText();
				controller.desabilitar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/broom.png")));

		JButton btnAtualizar = new JButton("");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.preecherEstoque();
			}
		});
		btnAtualizar.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/reload.png")));
		GroupLayout gl_opções = new GroupLayout(opções);
		gl_opções.setHorizontalGroup(gl_opções.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opções.createSequentialGroup().addGap(41)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
						.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_opções.setVerticalGroup(gl_opções.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_opções.createSequentialGroup().addContainerGap()
						.addGroup(gl_opções.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_opções
										.createSequentialGroup()
										.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 63,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_opções.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_opções.createSequentialGroup()
												.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 63,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(gl_opções.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_opções.createSequentialGroup()
														.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 63,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
												.addGroup(gl_opções.createSequentialGroup()
														.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 63,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap(GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)))))));
		opções.setLayout(gl_opções);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		tbEstoque = new JTable();
		tbEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.clickLinhaTabela();
				controller.habilitar();
				btnExcluir.setEnabled(true);
				btnEditar.setEnabled(true);
			}
		});
		tbEstoque.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Quantidade", "Nome Item",
				"Marca", "Descri\u00E7\u00E3o", "Pre\u00E7o", "ID Fornecedor", "Nome Fornecedor" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbEstoque.getColumnModel().getColumn(6).setPreferredWidth(83);
		tbEstoque.getColumnModel().getColumn(7).setPreferredWidth(96);
		scrollPane.setViewportView(tbEstoque);
	}

	public JTable getTbEstoque() {
		return tbEstoque;
	}

	public void setTbEstoque(JTable tbEstoque) {
		this.tbEstoque = tbEstoque;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNomeItem() {
		return txtNomeItem;
	}

	public void setTxtNomeItem(JTextField txtNomeItem) {
		this.txtNomeItem = txtNomeItem;
	}

	public JTextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}

	public JTextField getTxtMarca() {
		return txtMarca;
	}

	public void setTxtMarca(JTextField txtMarca) {
		this.txtMarca = txtMarca;
	}

	public JTextField getTxtQtd() {
		return txtQtd;
	}

	public void setTxtQtd(JTextField txtQtd) {
		this.txtQtd = txtQtd;
	}

	public JTextPane getTxtDescricao() {
		return txtDescricao;
	}

	public void setTxtDescricao(JTextPane txtDescricao) {
		this.txtDescricao = txtDescricao;
	}

	public JComboBox getCbxFornecedor() {
		return cbxFornecedor;
	}

	public void setCbxFornecedor(JComboBox cbxFornecedor) {
		this.cbxFornecedor = cbxFornecedor;
	}

	public JButton getBtNovo() {
		return btNovo;
	}

	public void setBtNovo(JButton btNovo) {
		this.btNovo = btNovo;
	}

	public JButton getBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(JButton btSalvar) {
		this.btSalvar = btSalvar;
	}

	public JButton getBtCancelar() {
		return btCancelar;
	}

	public void setBtCancelar(JButton btCancelar) {
		this.btCancelar = btCancelar;
	}

	public JTextField getTxtPesquisa() {
		return txtPesquisa;
	}

	public void setTxtPesquisa(JTextField txtPesquisa) {
		this.txtPesquisa = txtPesquisa;
	}

	public JComboBox getCbxTipoPesquisa() {
		return cbxTipoPesquisa;
	}

	public void setCbxTipoPesquisa(JComboBox cbxTipoPesquisa) {
		this.cbxTipoPesquisa = cbxTipoPesquisa;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public void setBtnAlterar(JButton btnAlterar) {
		this.btnAlterar = btnAlterar;
	}
}
