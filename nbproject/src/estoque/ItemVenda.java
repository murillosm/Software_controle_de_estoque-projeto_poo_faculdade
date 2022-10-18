package estoque;

public class ItemVenda {
	
	private float prešoUnitarioVenda;
	private int quantidadeVenda;
	private ItemEstoque item;

	public void retirarEstoque() {
		// Start of user code for method retirarEstoque
		// End of user code
	}
	
///////////////construtor\\\\\\\\\\\\\\\\
	
public ItemVenda(float prešoUnitarioVenda, int quantidadeVenda, ItemEstoque item) {
		super();
		this.prešoUnitarioVenda = prešoUnitarioVenda;
		this.quantidadeVenda = quantidadeVenda;
		this.item = item;
	}

////////////////get e set\\\\\\\\\\\\\\\
	public float getPrešoUnitarioVenda() {
		return prešoUnitarioVenda;
	}

	public void setPrešoUnitarioVenda(float prešoUnitarioVenda) {
		this.prešoUnitarioVenda = prešoUnitarioVenda;
	}

	public int getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(int quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}

	public ItemEstoque getItem() {
		return item;
	}

	public void setItem(ItemEstoque item) {
		this.item = item;
	}

}
