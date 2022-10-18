package estoque;

public class ItemEstoque {

	private float PreçoItem;
	private int quantidadeEstoque;
	private ItensDescricao item;

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
	public ItemEstoque(float preçoItem, int quantidadeEstoque, ItensDescricao item) {
	super();
	PreçoItem = preçoItem;
	this.quantidadeEstoque = quantidadeEstoque;
	this.item = item;
	}

////////////////get e set\\\\\\\\\\\\\\\\\\	
	
	public float getPreçoItem() {
		return PreçoItem;
	}

	public void setPreçoItem(float preçoItem) {
		PreçoItem = preçoItem;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public ItensDescricao getItem() {
		return item;
	}

	public void setItem(ItensDescricao item) {
		this.item = item;
	}


	
}
