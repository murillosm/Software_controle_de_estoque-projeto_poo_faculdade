package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridLayout;
import java.text.ParseException;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class VendasFrame extends JInternalFrame {
	private JTextField txtPesquisaNome;
	private JTextField txtPesquisaProduto;
	private JTextField txtQuatidade;
	private JTextField txtValorItem;
	private JTextField txtValorTotal;
	private JTable tablePesquisa;
	private JTable tableVenda;
	private JFormattedTextField txtData;
	private JComboBox comboBox;
	private JButton btnBuscaCliente;
	private JButton btnBuscaProduto;
	private JButton btnAdd;
	private JButton btnCancelarVenda;
	private JButton btnFinalizarVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendasFrame frame = new VendasFrame();
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
	public VendasFrame() {
		initComponents();
		formatarCampo();
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
	}
	
	public void initComponents() {
		setMaximizable(true);
		setTitle("Formulario de Vendas");
		setClosable(true);
		setBounds(100, 100, 800, 695);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lbFormularioVendas = new JLabel("Formulario de Vendas");
		lbFormularioVendas.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbFormularioVendas.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbFormularioVendas, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(btnFinalizarVenda);
		
		btnCancelarVenda = new JButton("Cancelar Venda");
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
		txtData.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		comboBox = new JComboBox();
		
		btnBuscaCliente = new JButton("Busca");
		btnBuscaCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel = new JLabel("Produto:");
		
		txtPesquisaProduto = new JTextField();
		txtPesquisaProduto.setColumns(10);
		
		btnBuscaProduto = new JButton("Busca");
		btnBuscaProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblQuatidade = new JLabel("Quatidade:");
		
		txtQuatidade = new JTextField();
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
		
		tableVenda = new JTable();
		scrollPane_1.setViewportView(tableVenda);
		
		tablePesquisa = new JTable();
		scrollPane.setViewportView(tablePesquisa);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQuatidade)
					.addGap(600))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblItemDaVenda, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblValorTotal, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(567))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lbTabelaPesquisa))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtQuatidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblValorU)
								.addComponent(txtValorItem, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdd)
					.addContainerGap(478, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNomeCliente, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(txtPesquisaNome))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblUsuario)
									.addGap(4)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscaCliente)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtPesquisaProduto, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnBuscaProduto))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(291, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(lblUsuario))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(lblNomeCliente)
							.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPesquisaNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscaCliente)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(7)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPesquisaProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscaProduto))))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuatidade)
						.addComponent(lblValorU)
						.addComponent(lblData))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtQuatidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValorItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lbTabelaPesquisa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
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

	public JTable getTablePesquisa() {
		return tablePesquisa;
	}

	public void setTablePesquisa(JTable tablePesquisa) {
		this.tablePesquisa = tablePesquisa;
	}

	public JTable getTableVenda() {
		return tableVenda;
	}

	public void setTableVenda(JTable tableVenda) {
		this.tableVenda = tableVenda;
	}

	public JFormattedTextField getTxtData() {
		return txtData;
	}

	public void setTxtData(JFormattedTextField txtData) {
		this.txtData = txtData;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
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
	
	
	
}
