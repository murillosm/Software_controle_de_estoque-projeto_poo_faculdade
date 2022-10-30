package model.entities;

public class ItemCompra {
	
	private Integer quantidadeCompra ;
	private Float precoUnitarioCompra;
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
	public ItemCompra(Integer quantidadeCompra, Float precoUnitarioCompra, ItemEstoque item) {
		super();
		this.quantidadeCompra = quantidadeCompra;
		this.precoUnitarioCompra = precoUnitarioCompra;
		this.item = item;
	}
	
////////////////set e get\\\\\\\\\\\\\\\\\\\

	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}

	public void setQuantidadeCompra(Integer quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}


	public float getPrecoUnitarioCompra() {
		return precoUnitarioCompra;
	}

	public void setPrecoUnitarioCompra(Float precoUnitarioCompra) {
		this.precoUnitarioCompra = precoUnitarioCompra;
	}

	public ItemEstoque getItem() {
		return item;
	}

	public void setItem(ItemEstoque item) {
		this.item = item;
	}
	


}
