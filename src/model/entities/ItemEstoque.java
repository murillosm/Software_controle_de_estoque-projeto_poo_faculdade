package model.entities;

import java.util.ArrayList;
import java.util.List;

public class ItemEstoque {

	private Float PrecoItem;
	private Integer quantidadeEstoque;
	private ItensDescricao item;
	private List<ItensDescricao> itensDescricao = new ArrayList<>();

	public void consutarItem() {
		// Start of user code for method consutarItem
		// End of user code
	}

	public void registrarItem() {
		// Start of user code for method registrarItem
		// End of user code
	}

	public void atualizarEstoque() {
		// Start of user code for method atualizarEstoque
		// End of user code
	}
///////////////construtor\\\\\\\\\\\\\\\\\
	public ItemEstoque(Float precoItem, Integer quantidadeEstoque, ItensDescricao item) {
	super();
	PrecoItem = precoItem;
	this.quantidadeEstoque = quantidadeEstoque;
	this.item = item;
	}

////////////////get e set\\\\\\\\\\\\\\\\\\	
	
	public float getPrecoItem() {
		return PrecoItem;
	}

	public void setPrecoItem(Float precoItem) {
		PrecoItem = precoItem;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public ItensDescricao getItem() {
		return item;
	}

	public void setItem(ItensDescricao item) {
		this.item = item;
	}


	
}
