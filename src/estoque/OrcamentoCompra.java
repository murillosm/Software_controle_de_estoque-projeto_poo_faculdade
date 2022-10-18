package estoque;

import java.util.Date;

public class OrcamentoCompra{
	Date dataCompra = new Date();
	private float valorCompra;
	private Fornecedor fornecedor;
	private ItemCompra itemCompra;
	

	public void calcularCompra() {
		// Start of user code for method calcularCompra
		// End of user code
	}
	
///////////////construtor\\\\\\\\\\\\\\\\	
	
	public OrcamentoCompra(Float valorCompra, Fornecedor fornecedor) {
		super();
		this.valorCompra = valorCompra;
		this.fornecedor = fornecedor;
	}

///////////////set e get\\\\\\\\\\\\\\\	
	
	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ItemCompra getItemCompra() {
		return itemCompra;
	}

	public void setItemCompra(ItemCompra itemCompra) {
		this.itemCompra = itemCompra;
	}
	
	
}
