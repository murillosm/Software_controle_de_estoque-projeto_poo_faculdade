package estoque;

public class ItemCompra {
	
	private int quantidadeCompra ;
	private float preçoUnitarioCompra;
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
	public ItemCompra(Integer quantidadeCompra, float preçoUnitarioCompra, ItemEstoque item) {
		super();
		this.quantidadeCompra = quantidadeCompra;
		this.preçoUnitarioCompra = preçoUnitarioCompra;
		this.item = item;
	}
	
////////////////set e get\\\\\\\\\\\\\\\\\\\

	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}


	public float getPreçoUnitarioCompra() {
		return preçoUnitarioCompra;
	}

	public void setPreçoUnitarioCompra(float preçoUnitarioCompra) {
		this.preçoUnitarioCompra = preçoUnitarioCompra;
	}

	public ItemEstoque getItem() {
		return item;
	}

	public void setItem(ItemEstoque item) {
		this.item = item;
	}
	


}
