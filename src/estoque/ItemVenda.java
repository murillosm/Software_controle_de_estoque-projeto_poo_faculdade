package estoque;

public class ItemVenda {
	
	private Float precoUnitarioVenda;
	private Integer quantidadeVenda;
	private ItemEstoque item;
////////////////////////////////////////////////
	//public int retirarEstoque() {
		//return quantidadeVenda - item; 
	//}
	
///////////////construtor\\\\\\\\\\\\\\\\
	
public ItemVenda(Float precoUnitarioVenda, Integer quantidadeVenda, ItemEstoque item) {
		super();
		this.precoUnitarioVenda = precoUnitarioVenda;
		this.quantidadeVenda = quantidadeVenda;
		this.item = item;
	}

////////////////get e set\\\\\\\\\\\\\\\
	public float getPrecoUnitarioVenda() {
		return precoUnitarioVenda;
	}

	public void setPrecoUnitarioVenda(Float precoUnitarioVenda) {
		this.precoUnitarioVenda = precoUnitarioVenda;
	}

	public int getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(Integer quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}

	public ItemEstoque getItem() {
		return item;
	}

	public void setItem(ItemEstoque item) {
		this.item = item;
	}

}
