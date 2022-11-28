package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TipoPessoa extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TipoPessoa dialog = new TipoPessoa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TipoPessoa() {
		CadastroClienteFisicoJDialog cadastrof = new CadastroClienteFisicoJDialog();
		CadastroClienteJuridicoJDialog cadastroj = new CadastroClienteJuridicoJDialog(); 
		
		setResizable(false);
		setBounds(100, 100, 350, 148);
		this.setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Qual é o tipo de cliente?");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 11, 334, 16);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			getContentPane().add(lblNewLabel);
		}
		
		JButton btnPF = new JButton("Pessoa Fisica");
		btnPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				cadastrof.setLocationRelativeTo(null);
				cadastrof.setVisible(true);
			}
		});
		btnPF.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPF.setBounds(10, 47, 150, 23);
		getContentPane().add(btnPF);
		
		JButton btnPJ = new JButton("Pessoa Juridica");
		btnPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				cadastroj.setLocationRelativeTo(null);
				cadastroj.setVisible(true);
			}
		});
		btnPJ.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPJ.setBounds(170, 48, 150, 23);
		getContentPane().add(btnPJ);
	}
}
