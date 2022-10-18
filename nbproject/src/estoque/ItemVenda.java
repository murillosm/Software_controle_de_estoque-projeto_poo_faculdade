package estoque;

public class ItemVenda {
	
	private float preçoUnitarioVenda;
	private int quantidadeVenda;
	private ItemEstoque item;

	public void retirarEstoque() {
		// Start of user code for method retirarEstoque
		// End of user code
	}
	
///////////////construtor\\\\\\\\\\\\\\\\
	
public ItemVenda(float preçoUnitarioVenda, int quantidadeVenda, ItemEstoque item) {
		super();
		this.preçoUnitarioVenda = preçoUnitarioVenda;
		this.quantidadeVenda = quantidadeVenda;
		this.item = item;
	}

////////////////get e set\\\\\\\\\\\\\\\
	public float getPreçoUnitarioVenda() {
		return preçoUnitarioVenda;
	}

	public void setPreçoUnitarioVenda(float preçoUnitarioVenda) {
		this.preçoUnitarioVenda = preçoUnitarioVenda;
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
