package estoque;

public class ItemCompra {
	
	private int quantidadeCompra ;
	private float pre�oUnitarioCompra;
	private ItemEstoque item;
	
	public void adicionarEstoque() {
		// Start of user code for method adicionarEstoque
		// End of user code
	}

	public void aumetarEstoque() {
		// Start of user code for method aumetarEstoque
		// End of user code
	}
////////////////construtor\\\\\\\\\\\\\\\\\\
	public ItemCompra(Integer quantidadeCompra, float pre�oUnitarioCompra, ItemEstoque item) {
		super();
		this.quantidadeCompra = quantidadeCompra;
		this.pre�oUnitarioCompra = pre�oUnitarioCompra;
		this.item = item;
	}
	
////////////////set e get\\\\\\\\\\\\\\\\\\\

	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}


	public float getPre�oUnitarioCompra() {
		return pre�oUnitarioCompra;
	}

	public void setPre�oUnitarioCompra(float pre�oUnitarioCompra) {
		this.pre�oUnitarioCompra = pre�oUnitarioCompra;
	}

	public ItemEstoque getItem() {
		return item;
	}

	public void setItem(ItemEstoque item) {
		this.item = item;
	}
	


}
