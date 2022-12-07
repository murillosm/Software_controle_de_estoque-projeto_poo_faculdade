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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
				/*if (clientePane.isVisible()) {
					clientePane.toFront();
					clientePane.requestFocus();
					JOptionPane.showMessageDialog(null, "Cadastro de clientes\n já esta em uso", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						desktopPane.add(clientePane);
						desktopPane.moveToFront(clientePane);
						clientePane.setSize(desktopPane.getWidth(), desktopPane.getHeight());
						clientePane.setLocation(0, 0);
						clientePane.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}*/
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

		JMenu mnNewMenu_1 = new JMenu("Opções");
		mnNewMenu_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/lista-de-controle.png")));
		mnNewMenu_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("SAIR");
		mntmNewMenuItem.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/imagens/icons/logout32.png")));
		mntmNewMenuItem.setFont(new Font("SansSerif", Font.BOLD, 13));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		
	}

	public static JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public static void setDesktopPane(JDesktopPane desktopPane) {
		MenuPrincipal.desktopPane = desktopPane;
	}
	
	
}
