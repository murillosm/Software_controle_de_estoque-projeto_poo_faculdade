package estoque;

import java.util.Date;

public class OrçamentoVenda {
	
	Date dataVenda = new Date();
	private float ValorTotal;
	private int codVenda;
	private Usuario Vendedor;
	private ItemVenda itemVenda;

	public void pagamento() {
		// Start of user code for method pagamento
		// End of user code
	}

	public void calcularVenda() {
		// Start of user code for method calcularVenda
		// End of user code
	}
/////////////construtor\\\\\\\\\\\\\\
	public OrçamentoVenda(float valorTotal, int codVenda, Usuario vendedor, ItemVenda itemVenda) {
		super();
		ValorTotal = valorTotal;
		this.codVenda = codVenda;
		Vendedor = vendedor;
		this.itemVenda = itemVenda;
	}

//////////////set e get\\\\\\\\\\\\\\
	
	public float getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(float valorTotal) {
		ValorTotal = valorTotal;
	}

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public Usuario getVendedor() {
		return Vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		Vendedor = vendedor;
	}

	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

}
