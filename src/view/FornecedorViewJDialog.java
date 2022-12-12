package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Controller.CadastroClienteJuridicoController;
import Controller.CadastroFornecedorController;
import Controller.FornecedorController;

import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FornecedorViewJDialog extends JDialog {
	
	private JTextField txtNome;
	private JFormattedTextField txtCnpj;
	private JFormattedTextField txtFone1;
	private JFormattedTextField txtFone2;
	private JTextField txtRazao;
	private JTextField txtEmail;
	private JTextArea txtEndereco;
	private JTextField txtNumero;
	private JFormattedTextField txtCep;
	private JTextField txtBairro;
	private JComboBox cbxEstado;
	private JComboBox cbxCidade;
	private JButton btVer;
	private JButton btnNovo;
	private JButton btSalvar;
	private JButton btCancel;
	private JButton btAlterar;
	private final JPanel contentPanel = new JPanel();
	private CadastroFornecedorController controller;
	private FornecedorController fornController;
	private CadastroFornecedorFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			FornecedorViewJDialog dialog = new FornecedorViewJDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * Create the dialog
	 */
	
	private static CadastroFornecedorFrame telaCadastroFornecedor;
	private JTextField txtIdFornecedor;
	private JTextField txtIdPesquisa;
	public static CadastroFornecedorFrame getInstacia(){
		if (telaCadastroFornecedor == null) {
			telaCadastroFornecedor = new CadastroFornecedorFrame();
		}
		return telaCadastroFornecedor;
	}
	
	public FornecedorViewJDialog() {
		setModal(true);
		setAutoRequestFocus(false);
		setTitle("Fornecedores");
		initComponents();
		formatarCampo();
		controller = new CadastroFornecedorController(this);
		//frame = new CadastroFornecedorFrame();
		//fornController = new FornecedorController(frame);
		iniciar();
	}
	
	private void iniciar() {
		this.controller.estado();
		this.controller.cidades();
		//this.controller.novoFornecedor();
	}
	
	private void formatarCampo() {
		try {
			MaskFormatter cnpjFormatter = new MaskFormatter("###.###.###/####-##");
			cnpjFormatter.install(txtCnpj);
			MaskFormatter fone1Formatter = new MaskFormatter("(##)#####-####");
			fone1Formatter.install(txtFone1);
			MaskFormatter fone2Formatter = new MaskFormatter("(##)#####-####");
			fone2Formatter.install(txtFone2);
			MaskFormatter cepFormatter = new MaskFormatter("#####-###");
			cepFormatter.install(txtCep);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto","Erro", JOptionPane.ERROR_MESSAGE);
		}
	}


	public void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 860, 586);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEndereco.setBounds(10, 291, 782, 158);
		getContentPane().add(panelEndereco);
		
		JLabel lblEndereco = new JLabel("*Endereco:");
		lblEndereco.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblbairro = new JLabel("*Bairro:");
		lblbairro.setHorizontalAlignment(SwingConstants.TRAILING);
		lblbairro.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtNumero = new JTextField();
		txtNumero.setEnabled(false);
		txtNumero.setColumns(10);
		
		txtCep = new JFormattedTextField();
		txtCep.setEnabled(false);
		txtCep.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtBairro = new JTextField();
		txtBairro.setEnabled(false);
		txtBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		cbxEstado = new JComboBox();
		cbxEstado.setEnabled(false);
		cbxEstado.setMaximumRowCount(16);
		cbxEstado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					controller.cidades();
				}
			}
		});
		cbxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.estado();
			}
		});
		
		cbxCidade = new JComboBox();
		cbxCidade.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelEndereco = new GroupLayout(panelEndereco);
		gl_panelEndereco.setHorizontalGroup(
			gl_panelEndereco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEndereco.createSequentialGroup()
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(4)
							.addComponent(lblEndereco, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane))
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(4)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxEstado, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelEndereco.createSequentialGroup()
									.addGap(141)
									.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addComponent(cbxCidade, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(lblbairro, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(51)
							.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_panelEndereco.setVerticalGroup(
			gl_panelEndereco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEndereco.createSequentialGroup()
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(19)
							.addComponent(lblEndereco, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbxCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(3)
							.addComponent(lblbairro, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(1)
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		
		txtEndereco = new JTextArea();
		txtEndereco.setEnabled(false);
		scrollPane.setViewportView(txtEndereco);
		txtEndereco.setColumns(10);
		panelEndereco.setLayout(gl_panelEndereco);
		
		JPanel panelDadosCliente = new JPanel();
		panelDadosCliente.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDadosCliente.setBounds(10, 106, 782, 180);
		getContentPane().add(panelDadosCliente);
		panelDadosCliente.setLayout(null);
		
		JLabel lblNomeFantasia = new JLabel("*Nome Fantasia:");
		lblNomeFantasia.setBounds(10, 51, 106, 14);
		panelDadosCliente.add(lblNomeFantasia);
		lblNomeFantasia.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNomeFantasia.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblCnpj = new JLabel("*CNPJ:");
		lblCnpj.setBounds(35, 76, 81, 14);
		panelDadosCliente.add(lblCnpj);
		lblCnpj.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblFone1 = new JLabel("*Telefone:");
		lblFone1.setBounds(10, 126, 81, 14);
		panelDadosCliente.add(lblFone1);
		lblFone1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFone1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblFone2 = new JLabel("Telefone 2:");
		lblFone2.setBounds(311, 126, 81, 14);
		panelDadosCliente.add(lblFone2);
		lblFone2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFone2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(126, 49, 400, 20);
		panelDadosCliente.add(txtNome);
		txtNome.setColumns(10);
		
		txtCnpj = new JFormattedTextField();
		txtCnpj.setEnabled(false);
		txtCnpj.setBounds(126, 74, 248, 20);
		panelDadosCliente.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		txtFone1 = new JFormattedTextField();
		txtFone1.setEnabled(false);
		txtFone1.setBounds(101, 124, 200, 20);
		panelDadosCliente.add(txtFone1);
		txtFone1.setColumns(10);
		
		txtFone2 = new JFormattedTextField();
		txtFone2.setEnabled(false);
		txtFone2.setBounds(402, 124, 200, 20);
		panelDadosCliente.add(txtFone2);
		txtFone2.setColumns(10);
		
		JLabel lblRazaoSocial = new JLabel("*Razão Social:");
		lblRazaoSocial.setBounds(10, 101, 106, 14);
		panelDadosCliente.add(lblRazaoSocial);
		lblRazaoSocial.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRazaoSocial.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtRazao = new JTextField();
		txtRazao.setEnabled(false);
		txtRazao.setBounds(126, 99, 476, 20);
		panelDadosCliente.add(txtRazao);
		txtRazao.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 151, 81, 14);
		panelDadosCliente.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setBounds(101, 149, 400, 20);
		panelDadosCliente.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtIdFornecedor = new JTextField();
		txtIdFornecedor.setEnabled(false);
		txtIdFornecedor.setEditable(false);
		txtIdFornecedor.setText("0");
		txtIdFornecedor.setBounds(66, 18, 86, 20);
		panelDadosCliente.add(txtIdFornecedor);
		txtIdFornecedor.setColumns(10);
		
		JLabel lbID = new JLabel("ID");
		lbID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbID.setBounds(10, 20, 46, 14);
		panelDadosCliente.add(lbID);
		
		JLabel lblFornecedores = new JLabel("Cadastro Fornecedores");
		lblFornecedores.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblFornecedores.setBounds(10, 11, 782, 46);
		getContentPane().add(lblFornecedores);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				btSalvar = new JButton("Salvar");
				btSalvar.setEnabled(false);
				btSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.novoFornecedor();
					}
				});
				
				btnNovo = new JButton("Novo");
				btnNovo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.habilitar();
						btSalvar.setEnabled(true);
						btAlterar.setEnabled(!true);
					}
				});
				btnNovo.setFont(new Font("Tahoma", Font.BOLD, 13));
				buttonPane.add(btnNovo);
				btSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
				btSalvar.setActionCommand("OK");
				buttonPane.add(btSalvar);
				getRootPane().setDefaultButton(btSalvar);
			}
			{
				btCancel = new JButton("Cancel");
				btCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.desabilitar();
					}
				});
				btCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
				btCancel.setActionCommand("Cancel");
				buttonPane.add(btCancel);
			}
			
			btAlterar = new JButton("Alterar");
			btAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.atualizarFornecedor();
				}
			});
			btAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btAlterar.setActionCommand("OK");
			buttonPane.add(btAlterar);
			
			JLabel lbID_1 = new JLabel("ID");
			lbID_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lbID_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonPane.add(lbID_1);
			
			txtIdPesquisa = new JTextField();
			txtIdPesquisa.setText("0");
			txtIdPesquisa.setColumns(10);
			buttonPane.add(txtIdPesquisa);
			
			btVer = new JButton("Vizualizar");
			btVer.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonPane.add(btVer);
			
			JButton btFechar = new JButton("Fechar");
			btFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btFechar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btFechar.setActionCommand("Cancel");
			buttonPane.add(btFechar);
			btVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.habilitar();
					controller.visualizarFornecedor();
				}
			});
		}
		
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JFormattedTextField getTxtCnpj() {
		return txtCnpj;
	}

	public void setTxtCnpj(JFormattedTextField txtCnpj) {
		this.txtCnpj = txtCnpj;
	}

	public JFormattedTextField getTxtFone1() {
		return txtFone1;
	}

	public void setTxtFone1(JFormattedTextField txtFone1) {
		this.txtFone1 = txtFone1;
	}

	public JFormattedTextField getTxtFone2() {
		return txtFone2;
	}

	public void setTxtFone2(JFormattedTextField txtFone2) {
		this.txtFone2 = txtFone2;
	}

	public JTextField getTxtRazao() {
		return txtRazao;
	}

	public void setTxtRazao(JTextField txtRazao) {
		this.txtRazao = txtRazao;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextArea getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(JTextArea txtEndereco) {
		this.txtEndereco = txtEndereco;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}

	public JFormattedTextField getTxtCep() {
		return txtCep;
	}

	public void setTxtCep(JFormattedTextField txtCep) {
		this.txtCep = txtCep;
	}

	public JTextField getTxtBairro() {
		return txtBairro;
	}

	public void setTxtBairro(JTextField txtBairro) {
		this.txtBairro = txtBairro;
	}

	public JComboBox getCbxEstado() {
		return cbxEstado;
	}

	public void setCbxEstado(JComboBox cbxEstado) {
		this.cbxEstado = cbxEstado;
	}

	public JComboBox getCbxCidade() {
		return cbxCidade;
	}

	public void setCbxCidade(JComboBox cbxCidade) {
		this.cbxCidade = cbxCidade;
	}

	public JTextField getTxtIdFornecedor() {
		return txtIdFornecedor;
	}

	public void setTxtIdFornecedor(JTextField txtIdFornecedor) {
		this.txtIdFornecedor = txtIdFornecedor;
	}

	public JButton getBtVer() {
		return btVer;
	}

	public void setBtVer(JButton btVer) {
		this.btVer = btVer;
	}

	public CadastroFornecedorFrame getFrame() {
		return frame;
	}

	public void setFrame(CadastroFornecedorFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtIdPesquisa() {
		return txtIdPesquisa;
	}

	public void setTxtIdPesquisa(JTextField txtIdPesquisa) {
		this.txtIdPesquisa = txtIdPesquisa;
	}

	public JButton getBtnNovo() {
		return btnNovo;
	}

	public void setBtnNovo(JButton btnNovo) {
		this.btnNovo = btnNovo;
	}

	public JButton getBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(JButton btSalvar) {
		this.btSalvar = btSalvar;
	}

	public JButton getBtCancel() {
		return btCancel;
	}

	public void setBtCancel(JButton btCancel) {
		this.btCancel = btCancel;
	}

	public JButton getBtAlterar() {
		return btAlterar;
	}

	public void setBtAlterar(JButton btAlterar) {
		this.btAlterar = btAlterar;
	}
	
	
	
}
