package Controller.helpers;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.entities.Estoque;
import model.entities.Venda;
import view.RelatorioVenda;

public class RelatorioHelper {
	private final RelatorioVenda view;

	public RelatorioHelper(RelatorioVenda view) {
		this.view = view;
	}
	
	public void preencherVendas(ArrayList<Venda> listVenda) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbVenda().getModel();
		tableModel.setNumRows(0);

		for (Venda venda : listVenda) {
			tableModel.addRow(new Object[] {
					venda.getIdVenda(),
					venda.getValor(),
					venda.getData(),
					venda.getUsuario().getIdUsuario(),
					venda.getCliente()});
		}
	}
	
	
	public void preencherItensList(ArrayList<Venda> listVendas) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getTbItemVenda().getModel();
		tableModel.setNumRows(0);

		for (Venda venda : listVendas) {
			tableModel.addRow(new Object[] {
					venda.getIdVenda(),
					venda.getProduto().getIdItem(),
					venda.getQtd(),
					venda.getProduto().getNomeItem()});
		}
	}
}
