package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroClienteFisicoJDialog extends JDialog {

	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtFone1;
	private JTextField txtFone2;
	private JTextField txtDataNasc;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField textField_4;
	private JTextField txtBairro;
	private final JPanel contentPanel = new JPanel();

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
	public static CadastroClienteFrame getInstacia(){
		if (telaCadastroCliente == null) {
			telaCadastroCliente = new CadastroClienteFrame();
		}
		return telaCadastroCliente;
	}
	
	public CadastroClienteFisicoJDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setBounds(100, 100, 860, 586);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setLayout(null);
		panelEndereco.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(101, 102, 170, 20);
		panelEndereco.add(textField_4);
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 51, 120, 22);
		panelEndereco.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(287, 51, 153, 22);
		panelEndereco.add(comboBox_1);
		
		JPanel panelDadosCliente = new JPanel();
		panelDadosCliente.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDadosCliente.setBounds(10, 106, 782, 158);
		getContentPane().add(panelDadosCliente);
		panelDadosCliente.setLayout(null);
		
		JLabel lblNomeCliente = new JLabel("*Nome:");
		lblNomeCliente.setBounds(10, 29, 81, 14);
		panelDadosCliente.add(lblNomeCliente);
		lblNomeCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblCpf = new JLabel("*CPF:");
		lblCpf.setBounds(10, 54, 81, 14);
		panelDadosCliente.add(lblCpf);
		lblCpf.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblFone1 = new JLabel("*Telefone:");
		lblFone1.setBounds(10, 79, 81, 14);
		panelDadosCliente.add(lblFone1);
		lblFone1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFone1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblFone2 = new JLabel("Telefone 2:");
		lblFone2.setBounds(10, 104, 81, 14);
		panelDadosCliente.add(lblFone2);
		lblFone2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFone2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtNome = new JTextField();
		txtNome.setBounds(101, 27, 400, 20);
		panelDadosCliente.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(101, 52, 200, 20);
		panelDadosCliente.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtFone1 = new JTextField();
		txtFone1.setBounds(101, 77, 200, 20);
		panelDadosCliente.add(txtFone1);
		txtFone1.setColumns(10);
		
		txtFone2 = new JTextField();
		txtFone2.setBounds(101, 102, 200, 20);
		panelDadosCliente.add(txtFone2);
		txtFone2.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("*Data de Nascimento:");
		lblDataNascimento.setBounds(311, 55, 150, 14);
		panelDadosCliente.add(lblDataNascimento);
		lblDataNascimento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtDataNasc = new JTextField();
		txtDataNasc.setBounds(471, 52, 120, 20);
		panelDadosCliente.add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 129, 81, 14);
		panelDadosCliente.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtEmail = new JTextField();
		txtEmail.setBounds(101, 127, 400, 20);
		panelDadosCliente.add(txtEmail);
		txtEmail.setColumns(10);
		
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
				JButton btAdicionar = new JButton("Adicionar");
				btAdicionar.setFont(new Font("Tahoma", Font.BOLD, 14));
				btAdicionar.setActionCommand("OK");
				buttonPane.add(btAdicionar);
				getRootPane().setDefaultButton(btAdicionar);
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

}
