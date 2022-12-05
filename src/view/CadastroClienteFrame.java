package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.lang.ModuleLayer.Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Controller.ClienteController;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CadastroClienteFrame extends JInternalFrame {

	private static JDesktopPane desktopPaneClientes;
	private static JComboBox cbxTipoPesquisa;
	private static CadastroClienteFrame telaCadastroCliente;
	private JTextField textField;
	private ClienteController clienteController;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClienteFrame frame = new CadastroClienteFrame();
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
	
	public static CadastroClienteFrame getInstacia(){
		if (telaCadastroCliente == null) {
			telaCadastroCliente = new CadastroClienteFrame();
		}
		return telaCadastroCliente;
	}
	
	
	public CadastroClienteFrame() {
		initComponents();
		clienteController = new ClienteController(this);
	}

	private void initComponents() {
		TabelaClientesF clienteF = new TabelaClientesF();
		TabelaClientesJ clienteJ = new TabelaClientesJ();
		//PaneFisica paneFisica = new PaneFisica();
		
		setMaximizable(true);
		setFrameIcon(new ImageIcon(CadastroClienteFrame.class.getResource("/view/imagens/icons/cliente.png")));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setClosable(true);
		setEnabled(false);
		setRootPaneCheckingEnabled(false);
		setTitle("Cadastro de Clientes");
		setBounds(100, 100, 978, 739);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		desktopPaneClientes = new JDesktopPane();
		scrollPane.setViewportView(desktopPaneClientes);
		
		JPanel panelPesquisaConfg = new JPanel();
		getContentPane().add(panelPesquisaConfg, BorderLayout.NORTH);
		
		JLabel lblCadastrosClientes = new JLabel("Cadastros de Clientes");
		lblCadastrosClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrosClientes.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel label_1 = new JLabel("");
		
		cbxTipoPesquisa = new JComboBox();
		cbxTipoPesquisa.setFont(new Font("Tahoma", Font.BOLD, 13));
		//cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Nome", "CPF", "CNPJ", "ID"}));
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JComboBox cbxTipoCliente = new JComboBox();
		cbxTipoCliente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					//String valorSelecionado = e.getItem().toString();
					String tipo = cbxTipoCliente.getSelectedItem().toString().trim();
					if (tipo.equals("Pessoa Fisica")) {
						cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Nome", "CPF", "ID"}));
					}else 
						if (tipo.equals("Pessoa Jurídica")) {
							cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Nome", "CNPJ", "ID"}));
					}
				}	
			}
		});
		cbxTipoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = cbxTipoCliente.getSelectedItem().toString().trim();
			
				if (tipo.equals("Pessoa Fisica")) {
					clienteController.visualizarClientesFisico();
				}else 
					if (tipo.equals("Pessoa Jurídica")) {
					clienteController.visualizarClientesJuridico();
				}else if (tipo.equals("Escolha um campo")) {
					clienteController.escolherTipo();	
				} 	
			}
		});
		cbxTipoCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbxTipoCliente.setModel(new DefaultComboBoxModel(new String[] {"Escolha um campo", "Pessoa Fisica", "Pessoa Jurídica"}));
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(CadastroClienteFrame.class.getResource("/view/imagens/icons/procurar.png")));
		
		JButton btnAddCliente = new JButton("");
		btnAddCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteController.tipoCliente();
			}
		});
		btnAddCliente.setIcon(new ImageIcon(CadastroClienteFrame.class.getResource("/view/imagens/icons/novo-arquivo.png")));
		GroupLayout gl_panelPesquisaConfg = new GroupLayout(panelPesquisaConfg);
		gl_panelPesquisaConfg.setHorizontalGroup(
			gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
					.addGap(10)
					.addComponent(btnAddCliente, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbxTipoCliente, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbxTipoPesquisa, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
							.addGap(6)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
							.addGap(159)
							.addComponent(lblCadastrosClientes, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
							.addGap(398)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panelPesquisaConfg.setVerticalGroup(
			gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCadastrosClientes)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_panelPesquisaConfg.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxTipoCliente, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxTipoPesquisa, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addComponent(btnAddCliente))
				.addGroup(gl_panelPesquisaConfg.createSequentialGroup()
					.addGap(44)
					.addComponent(btnPesquisar))
		);
		panelPesquisaConfg.setLayout(gl_panelPesquisaConfg);
		
	}


	public static JDesktopPane getDesktopPaneClientes() {
		return desktopPaneClientes;
	}


	public static void setDesktopPaneClientes(JDesktopPane desktopPaneClientes) {
		CadastroClienteFrame.desktopPaneClientes = desktopPaneClientes;
	}


	public static CadastroClienteFrame getTelaCadastroCliente() {
		return telaCadastroCliente;
	}


	public static void setTelaCadastroCliente(CadastroClienteFrame telaCadastroCliente) {
		CadastroClienteFrame.telaCadastroCliente = telaCadastroCliente;
	}


	public JTextField getTextField() {
		return textField;
	}


	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	public ClienteController getClienteController() {
		return clienteController;
	}


	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}


	public static JComboBox getCbxTipoPesquisa() {
		return cbxTipoPesquisa;
	}


	public static void setCbxTipoPesquisaBox(JComboBox cbxTipoPesquisa) {
		CadastroClienteFrame.cbxTipoPesquisa = cbxTipoPesquisa;
	}
	
	
}
