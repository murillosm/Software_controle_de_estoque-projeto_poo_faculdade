package estoque;

public class ItemVenda {
	
	private float pre�oUnitarioVenda;
	private int quantidadeVenda;
	private ItemEstoque item;

	public void retirarEstoque() {
		// Start of user code for method retirarEstoque
		// End of user code
	}
	
///////////////construtor\\\\\\\\\\\\\\\\
	
public ItemVenda(float pre�oUnitarioVenda, int quantidadeVenda, ItemEstoque item) {
		super();
		this.pre�oUnitarioVenda = pre�oUnitarioVenda;
		this.quantidadeVenda = quantidadeVenda;
		this.item = item;
	}

////////////////get e set\\\\\\\\\\\\\\\
	public float getPre�oUnitarioVenda() {
		return pre�oUnitarioVenda;
	}

	public void setPre�oUnitarioVenda(float pre�oUnitarioVenda) {
		this.pre�oUnitarioVenda = pre�oUnitarioVenda;
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
