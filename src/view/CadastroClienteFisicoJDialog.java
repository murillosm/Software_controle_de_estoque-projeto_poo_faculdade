package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Controller.CadastroClienteFisicoController;
import Controller.LoginController;
import model.dao.CidadeDao;
import model.dao.DaoFactory;
import model.entities.Cidades;
import model.entities.Estados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;

public class CadastroClienteFisicoJDialog extends JDialog {

	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtFone1;
	private JFormattedTextField txtFone2;
	private JFormattedTextField txtDataNasc;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JFormattedTextField txtCep;
	private JTextField txtBairro;
	private JComboBox cbxEstado;
	private JComboBox cbxCidade;
	private final JPanel contentPanel = new JPanel();
	private final CadastroClienteFisicoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroClienteFisicoJDialog dialog = new CadastroClienteFisicoJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	private static CadastroClienteFrame telaCadastroCliente;
	private JTextField txtIdCliente;

	public static CadastroClienteFrame getInstacia() {
		if (telaCadastroCliente == null) {
			telaCadastroCliente = new CadastroClienteFrame();
		}
		return telaCadastroCliente;
	}

	public CadastroClienteFisicoJDialog() {
		initComponents();
		formatarCampo();
		controller = new CadastroClienteFisicoController(this);
		iniciar();
	}

	private void iniciar() {
		this.controller.estado();
		this.controller.cidades();
	}
	
	private void formatarCampo() {
		try {
			MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
			cpfFormatter.install(txtCpf);
			MaskFormatter dataFormatter = new MaskFormatter("##/##/####");
			dataFormatter.install(txtDataNasc);
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

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 860, 586);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel panelEndereco = new JPanel();
		panelEndereco.setLayout(null);
		panelEndereco.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEndereco.setBounds(10, 291, 782, 158);
		getContentPane().add(panelEndereco);

		JLabel lblEndereco = new JLabel("*Endereco:");
		lblEndereco.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco.setBounds(10, 29, 81, 14);
		panelEndereco.add(lblEndereco);

		JLabel lblbairro = new JLabel("*Bairro:");
		lblbairro.setHorizontalAlignment(SwingConstants.TRAILING);
		lblbairro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblbairro.setBounds(453, 54, 57, 14);
		panelEndereco.add(lblbairro);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero.setBounds(10, 79, 81, 14);
		panelEndereco.add(lblNumero);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCep.setBounds(57, 104, 34, 14);
		panelEndereco.add(lblCep);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(101, 27, 610, 20);
		panelEndereco.add(txtEndereco);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(101, 77, 101, 20);
		panelEndereco.add(txtNumero);

		txtCep = new JFormattedTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(101, 102, 170, 20);
		panelEndereco.add(txtCep);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setBounds(10, 54, 81, 14);
		panelEndereco.add(lblEstado);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(520, 52, 191, 20);
		panelEndereco.add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCidade.setBounds(220, 52, 57, 14);
		panelEndereco.add(lblCidade);

		cbxEstado = new JComboBox();
		cbxEstado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					controller.cidades();
				}

			}
		});
		cbxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.estado();
			}
		});

		cbxEstado.setBounds(101, 51, 120, 22);
		panelEndereco.add(cbxEstado);

		cbxCidade = new JComboBox();
//		cbxCidade.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controller.cidades();
//			}
//		});
		cbxCidade.setBounds(287, 51, 153, 22);
		panelEndereco.add(cbxCidade);

		JPanel panelDadosCliente = new JPanel();
		panelDadosCliente
				.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDadosCliente.setBounds(10, 106, 782, 180);
		getContentPane().add(panelDadosCliente);
		panelDadosCliente.setLayout(null);

		JLabel lblNomeCliente = new JLabel("*Nome:");
		lblNomeCliente.setBounds(20, 51, 81, 14);
		panelDadosCliente.add(lblNomeCliente);
		lblNomeCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblCpf = new JLabel("*CPF:");
		lblCpf.setBounds(20, 76, 81, 14);
		panelDadosCliente.add(lblCpf);
		lblCpf.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblFone1 = new JLabel("*Telefone:");
		lblFone1.setBounds(20, 101, 81, 14);
		panelDadosCliente.add(lblFone1);
		lblFone1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFone1.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblFone2 = new JLabel("Telefone 2:");
		lblFone2.setBounds(20, 126, 81, 14);
		panelDadosCliente.add(lblFone2);
		lblFone2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFone2.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtNome = new JTextField();
		txtNome.setBounds(111, 49, 400, 20);
		panelDadosCliente.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JFormattedTextField();
		txtCpf.setBounds(111, 74, 200, 20);
		panelDadosCliente.add(txtCpf);

		txtFone1 = new JFormattedTextField();
		txtFone1.setBounds(111, 99, 200, 20);
		panelDadosCliente.add(txtFone1);
		txtFone1.setColumns(10);

		txtFone2 = new JFormattedTextField();
		txtFone2.setBounds(111, 124, 200, 20);
		panelDadosCliente.add(txtFone2);
		txtFone2.setColumns(10);

		JLabel lblDataNascimento = new JLabel("*Data de Nascimento:");
		lblDataNascimento.setBounds(321, 77, 150, 14);
		panelDadosCliente.add(lblDataNascimento);
		lblDataNascimento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtDataNasc = new JFormattedTextField();
		txtDataNasc.setBounds(481, 74, 120, 20);
		panelDadosCliente.add(txtDataNasc);
		txtDataNasc.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 151, 81, 14);
		panelDadosCliente.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));

		txtEmail = new JTextField();
		txtEmail.setBounds(111, 149, 400, 20);
		panelDadosCliente.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setText("0");
		txtIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtIdCliente.setBounds(111, 11, 81, 31);
		panelDadosCliente.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JLabel lblidCliente = new JLabel("ID cliente");
		lblidCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblidCliente.setBounds(20, 19, 81, 14);
		panelDadosCliente.add(lblidCliente);

		JLabel lblNewLabel = new JLabel("Cadastro Cliente Físico");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 782, 46);
		getContentPane().add(lblNewLabel);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btSalvar = new JButton("Salvar");
				btSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.novoCliente();
					}
				});
				btSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
				btSalvar.setActionCommand("OK");
				buttonPane.add(btSalvar);
				getRootPane().setDefaultButton(btSalvar);
			}
			{
				JButton btCancel = new JButton("Cancel");
				btCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
				btCancel.setActionCommand("Cancel");
				buttonPane.add(btCancel);
			}
		}
	}
	
	public JTextField getTxtIdCliente() {
		return txtIdCliente;
	}

	public void setTxtIdCliente(JTextField txtIdCliente) {
		this.txtIdCliente = txtIdCliente;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JFormattedTextField getTxtCpf() {
		return txtCpf;
	}

	public void setTxtCpf(JFormattedTextField txtCpf) {
		this.txtCpf = txtCpf;
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

	public JFormattedTextField getTxtDataNasc() {
		return txtDataNasc;
	}

	public void setTxtDataNasc(JFormattedTextField txtDataNasc) {
		this.txtDataNasc = txtDataNasc;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(JTextField txtEndereco) {
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

	public static CadastroClienteFrame getTelaCadastroCliente() {
		return telaCadastroCliente;
	}

	public static void setTelaCadastroCliente(CadastroClienteFrame telaCadastroCliente) {
		CadastroClienteFisicoJDialog.telaCadastroCliente = telaCadastroCliente;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public CadastroClienteFisicoController getController() {
		return controller;
	}
}