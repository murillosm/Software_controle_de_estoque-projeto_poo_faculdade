package estoque;

public class ItemCompra {
	
	private int quantidadeCompra ;
	private float prešoUnitarioCompra;
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
	public ItemCompra(Integer quantidadeCompra, float prešoUnitarioCompra, ItemEstoque item) {
		super();
		this.quantidadeCompra = quantidadeCompra;
		this.prešoUnitarioCompra = prešoUnitarioCompra;
		this.item = item;
	}
	
////////////////set e get\\\\\\\\\\\\\\\\\\\

	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}


	public float getPrešoUnitarioCompra() {
		return prešoUnitarioCompra;
	}

	public void setPrešoUnitarioCompra(float prešoUnitarioCompra) {
		this.prešoUnitarioCompra = prešoUnitarioCompra;
	}

	public ItemEstoque getItem() {
		return item;
	}

	public void setItem(ItemEstoque item) {
		this.item = item;
	}
	


}
