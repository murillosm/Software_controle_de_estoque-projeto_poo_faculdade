package estoque;

public class ItemEstoque {

	private float Pre�oItem;
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
	public ItemEstoque(float pre�oItem, int quantidadeEstoque, ItensDescricao item) {
	super();
	Pre�oItem = pre�oItem;
	this.quantidadeEstoque = quantidadeEstoque;
	this.item = item;
	}

////////////////get e set\\\\\\\\\\\\\\\\\\	
	
	public float getPre�oItem() {
		return Pre�oItem;
	}

	public void setPre�oItem(float pre�oItem) {
		Pre�oItem = pre�oItem;
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
