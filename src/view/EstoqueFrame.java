package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.EstoqueController;
import model.dao.DaoFactory;
import model.dao.EstadoDao;
import model.dao.FornecedorDao;
import model.entities.Cidades;
import model.entities.Estados;
import model.entities.Estoque;
import model.entities.Fornecedor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

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
		initComponents();
		controller = new EstoqueController(this);
		iniciar();
		

	}
	
	public void iniciar() {
		this.controller.boxFornecedor();
		this.controller.atualizarEstoque();
	}
	
	public void initComponents() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 692, 591);
		
		JPanel dados = new JPanel();
		getContentPane().add(dados, BorderLayout.NORTH);
		
		JLabel lbCodItem = new JLabel("Código");
		lbCodItem.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtId = new JTextField();
		txtId.setText("0");
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtNomeItem = new JTextField();
		txtNomeItem.setColumns(10);
		
		JLabel lbNomeItem = new JLabel("Item");
		lbNomeItem.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		
		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		
		JLabel lbQuantidade = new JLabel("Quantidade");
		lbQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtQtd = new JTextField();
		txtQtd.setColumns(10);
		
		JLabel lbFornecedor = new JLabel("Fornecedor");
		lbFornecedor.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		cbxFornecedor = new JComboBox();
		cbxFornecedor.setEditable(true);
		cbxFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.boxFornecedor();
			}
		});
		
		JLabel lbDescrição = new JLabel("Descrição");
		lbDescrição.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane paneDescrição = new JScrollPane();
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.novoEstoque();
				//controller.atualizarEstoque();
			}
		});
		btnSalvar.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/novo-arquivo.png")));
		GroupLayout gl_dados = new GroupLayout(dados);
		gl_dados.setHorizontalGroup(
			gl_dados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dados.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dados.createSequentialGroup()
							.addGroup(gl_dados.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtId, Alignment.LEADING)
								.addComponent(lbCodItem, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
								.addComponent(lbNomeItem, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNomeItem, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
								.addComponent(lbValor, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
								.addComponent(lbMarca, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
								.addComponent(txtQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbQuantidade)))
						.addGroup(gl_dados.createSequentialGroup()
							.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxFornecedor, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbFornecedor, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dados.createSequentialGroup()
									.addGap(6)
									.addComponent(lbDescrição, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 344, Short.MAX_VALUE))
								.addGroup(gl_dados.createSequentialGroup()
									.addGap(12)
									.addComponent(paneDescrição, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
									.addGap(6)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_dados.setVerticalGroup(
			gl_dados.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dados.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dados.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_dados.createSequentialGroup()
							.addComponent(lbNomeItem, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomeItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_dados.createSequentialGroup()
							.addComponent(lbCodItem)
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_dados.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_dados.createSequentialGroup()
								.addComponent(lbMarca, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_dados.createSequentialGroup()
								.addComponent(lbValor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_dados.createSequentialGroup()
								.addComponent(lbQuantidade, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtQtd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(6)
					.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
						.addComponent(lbFornecedor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbDescrição, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_dados.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(paneDescrição, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		txtDescricao = new JTextPane();
		paneDescrição.setViewportView(txtDescricao);
		dados.setLayout(gl_dados);
		
		JPanel opções = new JPanel();
		getContentPane().add(opções, BorderLayout.SOUTH);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/lixo.png")));
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/lapis64.png")));
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/broom.png")));
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(EstoqueFrame.class.getResource("/view/imagens/icons/reload.png")));
		GroupLayout gl_opções = new GroupLayout(opções);
		gl_opções.setHorizontalGroup(
			gl_opções.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opções.createSequentialGroup()
					.addGap(41)
					.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
					.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_opções.setVerticalGroup(
			gl_opções.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_opções.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_opções.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_opções.createSequentialGroup()
							.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_opções.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_opções.createSequentialGroup()
								.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_opções.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_opções.createSequentialGroup()
									.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_opções.createSequentialGroup()
									.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
		);
		opções.setLayout(gl_opções);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tbEstoque = new JTable();
		tbEstoque.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Quantidade", "Nome Item", "Marca", "Descri\u00E7\u00E3o", "Pre\u00E7o", "Fornecedor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
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
	
	
}
