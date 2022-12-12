package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.MenuPrincipalController;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.UIManager;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private MenuPrincipalController controller;
	static JDesktopPane desktopPane;
	MenuPrincipal menuPrincipal;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {

		CadastroClienteFrame clientePane = new CadastroClienteFrame();
		CadastroFornecedorFrame fornecedorFrame = new CadastroFornecedorFrame();
		this.controller = new MenuPrincipalController(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		desktopPane = new JDesktopPane();
		desktopPane.setBorder(UIManager.getBorder("TitledBorder.border"));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu menuCadastros = new JMenu("Cadastros");
		menuCadastros.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/local-na-rede-internet.png")));
		menuCadastros.setFont(new Font("SansSerif", Font.BOLD, 12));
		menuBar.add(menuCadastros);

		JMenuItem MenuItemCadastroCliente = new JMenuItem("Cadastro Cliente");
		MenuItemCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CadastroCliente();
			}
		});
		MenuItemCadastroCliente
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/cliente.png")));
		MenuItemCadastroCliente.setFont(new Font("SansSerif", Font.BOLD, 13));
		menuCadastros.add(MenuItemCadastroCliente);

		JMenuItem MenuItemCadastroFornecedor = new JMenuItem("Cadastro Fornecedor");
		MenuItemCadastroFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CadastroFornecedores();
			}
		});
		MenuItemCadastroFornecedor
				.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/trolley32.png")));
		MenuItemCadastroFornecedor.setFont(new Font("SansSerif", Font.BOLD, 13));
		menuCadastros.add(MenuItemCadastroFornecedor);

		JMenuItem MenuItemCadastroProduto = new JMenuItem("Cadastro Produto");
		MenuItemCadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CadastroProdutos();
			}
		});
		MenuItemCadastroProduto.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/package-box32.png")));
		MenuItemCadastroProduto.setFont(new Font("SansSerif", Font.BOLD, 13));
		menuCadastros.add(MenuItemCadastroProduto);
		
		JMenu menuCaixa = new JMenu("Caixa");
		menuCaixa.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/caixa-registradora32.png")));
		menuCaixa.setFont(new Font("SansSerif", Font.BOLD, 13));
		menuBar.add(menuCaixa);
		
		JMenuItem menuVendas = new JMenuItem("Vendas");
		menuVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.formVendas();
			}
		});
		menuVendas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/cart32.png")));
		menuVendas.setFont(new Font("SansSerif", Font.BOLD, 13));
		menuCaixa.add(menuVendas);

		JMenu menuOpcoes = new JMenu("Opções");
		menuOpcoes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/lista-de-controle.png")));
		menuOpcoes.setFont(new Font("SansSerif", Font.BOLD, 13));
		menuBar.add(menuOpcoes);
		
		JMenuItem menuSair = new JMenuItem("SAIR");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				if (login.isVisible()) {
					dispose();
				}
			}
		});
		menuSair.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/logout32.png")));
		menuSair.setFont(new Font("SansSerif", Font.BOLD, 13));
		menuOpcoes.add(menuSair);
		
		
	}

	public static JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public static void setDesktopPane(JDesktopPane desktopPane) {
		MenuPrincipal.desktopPane = desktopPane;
	}
}
