package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Controller.VendasController;
import model.dao.DaoFactory;
import model.dao.EstoqueDao;
import model.dao.VendasDao;
import model.entities.Venda;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VendasFrame extends JInternalFrame {
	private JTextField txtPesquisaNome;
	private JTextField txtPesquisaProduto;
	private JTextField txtQuatidade;
	private JTextField txtValorItem;
	private JTextField txtValorTotal;
	private JTable tbPesquisa;
	private JTable tbVenda;
	private JFormattedTextField txtData;
	private JComboBox cbxUsuario;
	private JComboBox cbxTipoCliente;
	private JButton btnBuscaCliente;
	private JButton btnBuscaProduto;
	private JButton btnAdd;
	private JButton btnCancelarVenda;
	private JButton btnFinalizarVenda;
	private VendasController controller;
	private JTextField txtIDCliente;
	private JTextField txtIDProduto;
	private Venda venda;

	private int flag = 1;
	private double total = 0;
	VendasDao vendasDao = DaoFactory.createVendasDao();
	private JTextField txtIDVenda;

	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VendasFrame frame = new VendasFrame();
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
	public VendasFrame() {
		initComponents();
		formatarCampo();
		controller = new VendasController(this);
		iniciar();
	}
	
	private void formatarCampo() {
		try {
			MaskFormatter dataFormatter = new MaskFormatter("##/##/####");
			dataFormatter.install(txtData);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void iniciar() {
		try {
			this.controller.boxUsuario();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void initComponents() {
		setMaximizable(true);
		setTitle("Formulario de Vendas");
		setBounds(100, 100, 959, 799);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lbFormularioVendas = new JLabel("Formulario de Vendas");
		lbFormularioVendas.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbFormularioVendas.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbFormularioVendas, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.finalizarVenda();
			}
		});
		btnFinalizarVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(btnFinalizarVenda);
		
		btnCancelarVenda = new JButton("Cancelar Venda");
		btnCancelarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.excluirVenda();
			}
		});
		btnCancelarVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(btnCancelarVenda);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel);
		
		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtPesquisaNome = new JTextField();
		txtPesquisaNome.setColumns(10);
		
		txtData = new JFormattedTextField();
		txtData.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				float valorTotal;
				valorTotal = Float.parseFloat(txtValorItem.getText()) * Integer.parseInt(txtQuatidade.getText());
				txtValorTotal.setText(String.valueOf(valorTotal));
			}
		});
		txtData.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		cbxUsuario = new JComboBox();
		
		btnBuscaCliente = new JButton("Busca");
		btnBuscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				controller.buscarNomeCliente();
				controller.iniciarVenda();
			}
		});
		btnBuscaCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblProduto = new JLabel("Item:");
		
		txtPesquisaProduto = new JTextField();
		txtPesquisaProduto.setColumns(10);
		
		btnBuscaProduto = new JButton("Busca");
		btnBuscaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 2;
				controller.buscarItem();
			}
		});
		btnBuscaProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblQuatidade = new JLabel("Quatidade:");
		
		txtQuatidade = new JTextField();
		txtQuatidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Double valorTotal;
				valorTotal = Double.parseDouble(txtValorItem.getText()) * Integer.parseInt(txtQuatidade.getText());
				txtValorTotal.setText(String.valueOf(valorTotal));
			}
		});
		txtQuatidade.setColumns(10);
		
		JLabel lblValorU = new JLabel("Valor por Item:");
		
		txtValorItem = new JTextField();
		txtValorItem.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtValorTotal = new JTextField();
		txtValorTotal.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lbTabelaPesquisa = new JLabel("Tabela de Pesquisa");
		lbTabelaPesquisa.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblItemDaVenda = new JLabel("Item da Venda");
		lblItemDaVenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		tbVenda = new JTable();
		tbVenda.setModel(
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
		scrollPane_1.setViewportView(tbVenda);
		
		tbPesquisa = new JTable();
		tbPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag ==1) {
					controller.clickedTabelaCliente();
				}else {
					controller.clickedTabelaItem();
				}
			}
		});
		scrollPane.setViewportView(tbPesquisa);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.novoItem();
				total = total + Float.parseFloat(txtValorTotal.getText()) * Integer.parseInt(txtQuatidade.getText());
				txtValorTotal.setText(String.valueOf(total));
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		cbxTipoCliente = new JComboBox();
		cbxTipoCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbxTipoCliente.setModel(new DefaultComboBoxModel(new String[] {"Pessoa Fisica", "Pessoa Juridida"}));
		
		JLabel lblTipoCliente = new JLabel("Tipo de Cliente");
		
		txtIDCliente = new JTextField();
		txtIDCliente.setColumns(10);
		
		JLabel lbCliente = new JLabel("ID Cliente:");
		lbCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbIdVedaAberta = new JLabel("Codigo Venda Aberta:");
		lbIdVedaAberta.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtIDVenda = new JTextField();
		txtIDVenda.setEditable(false);
		txtIDVenda.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtIDVenda.setColumns(10);
		
		txtIDProduto = new JTextField();
		txtIDProduto.setColumns(10);
		
		JLabel lblIDProduto = new JLabel("ID Item:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblQuatidade))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblItemDaVenda, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblValorTotal, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblUsuario)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxUsuario, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoCliente)
								.addComponent(cbxTipoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtIDCliente, 0, 0, Short.MAX_VALUE)
								.addComponent(lbCliente, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtPesquisaNome, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBuscaCliente))
								.addComponent(lblNomeCliente, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
							.addGap(45)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIDProduto, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIDProduto, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtPesquisaProduto, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBuscaProduto))
								.addComponent(lblProduto))
							.addGap(321))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lbTabelaPesquisa))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtQuatidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtValorItem, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblValorU))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addGap(318))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbIdVedaAberta)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIDVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(scrollPane_1, Alignment.LEADING)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addComponent(lblUsuario))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(cbxUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoCliente)
						.addComponent(lbCliente)
						.addComponent(lblNomeCliente)
						.addComponent(lblIDProduto)
						.addComponent(lblProduto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxTipoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIDCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPesquisaNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscaCliente)
						.addComponent(txtIDProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPesquisaProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscaProduto))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuatidade)
						.addComponent(lblValorU)
						.addComponent(lblData))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtQuatidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValorItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd))
					.addGap(18)
					.addComponent(lbTabelaPesquisa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbIdVedaAberta, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIDVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(lblItemDaVenda)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblValorTotal)
						.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
	}

	public JTextField getTxtPesquisaNome() {
		return txtPesquisaNome;
	}

	public void setTxtPesquisaNome(JTextField txtPesquisaNome) {
		this.txtPesquisaNome = txtPesquisaNome;
	}

	public JTextField getTxtPesquisaProduto() {
		return txtPesquisaProduto;
	}

	public void setTxtPesquisaProduto(JTextField txtPesquisaProduto) {
		this.txtPesquisaProduto = txtPesquisaProduto;
	}

	public JTextField getTxtQuatidade() {
		return txtQuatidade;
	}

	public void setTxtQuatidade(JTextField txtQuatidade) {
		this.txtQuatidade = txtQuatidade;
	}

	public JTextField getTxtValorItem() {
		return txtValorItem;
	}

	public void setTxtValorItem(JTextField txtValorItem) {
		this.txtValorItem = txtValorItem;
	}

	public JTextField getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(JTextField txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public JTable getTbPesquisa() {
		return tbPesquisa;
	}

	public void setTbPesquisa(JTable tbPesquisaCliente) {
		this.tbPesquisa = tbPesquisaCliente;
	}

	public JTable getTableVenda() {
		return tbVenda;
	}

	public void setTableVenda(JTable tableVenda) {
		this.tbVenda = tableVenda;
	}

	public JFormattedTextField getTxtData() {
		return txtData;
	}

	public void setTxtData(JFormattedTextField txtData) {
		this.txtData = txtData;
	}
	
	public JComboBox getCbxUsuario() {
		return cbxUsuario;
	}

	public void setCbxUsuario(JComboBox cbxUsuario) {
		this.cbxUsuario = cbxUsuario;
	}

	public JButton getBtnBuscaCliente() {
		return btnBuscaCliente;
	}

	public void setBtnBuscaCliente(JButton btnBuscaCliente) {
		this.btnBuscaCliente = btnBuscaCliente;
	}

	public JButton getBtnBuscaProduto() {
		return btnBuscaProduto;
	}

	public void setBtnBuscaProduto(JButton btnBuscaProduto) {
		this.btnBuscaProduto = btnBuscaProduto;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnCancelarVenda() {
		return btnCancelarVenda;
	}

	public void setBtnCancelarVenda(JButton btnCancelarVenda) {
		this.btnCancelarVenda = btnCancelarVenda;
	}

	public JButton getBtnFinalizarVenda() {
		return btnFinalizarVenda;
	}

	public void setBtnFinalizarVenda(JButton btnFinalizarVenda) {
		this.btnFinalizarVenda = btnFinalizarVenda;
	}

	public JComboBox getCbxTipoCliente() {
		return cbxTipoCliente;
	}

	public void setCbxTipoCliente(JComboBox cbxTipoCliente) {
		this.cbxTipoCliente = cbxTipoCliente;
	}

	public JTable getTbVenda() {
		return tbVenda;
	}

	public void setTbVenda(JTable tbVenda) {
		this.tbVenda = tbVenda;
	}

	public JTextField getTxtIDCliente() {
		return txtIDCliente;
	}

	public void setTxtIDCliente(JTextField txtIDCliente) {
		this.txtIDCliente = txtIDCliente;
	}

	public JTextField getTxtIDVenda() {
		return txtIDVenda;
	}

	public void setTxtIDVenda(JTextField txtIDVenda) {
		this.txtIDVenda = txtIDVenda;
	}


	public JTextField getTxtIDProduto() {
		return txtIDProduto;
	}


	public void setTxtIDProduto(JTextField txtIDProduto) {
		this.txtIDProduto = txtIDProduto;
	}
	
	
}
