package estoque;

public class ItensDescricao
{

	private String descriçãoItem;
	private String nomeItem;
	public String marcaItem;
	private int codItem;

	public void descreverItem() {
		// Start of user code for method descreverItem
		// End of user code
	}
//////////////construtor\\\\\\\\\\\\\\\\\
	public ItensDescricao(String descriçãoItem, String nomeItem, String marcaItem, int codItem) {
		super();
		this.descriçãoItem = descriçãoItem;
		this.nomeItem = nomeItem;
		this.marcaItem = marcaItem;
		this.codItem = codItem;
	}
	
///////////////set e get\\\\\\\\\\\\\\\\\\
	
	public String getDescriçãoItem() {
		return descriçãoItem;
	}

	public void setDescriçãoItem(String descriçãoItem) {
		this.descriçãoItem = descriçãoItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getMarcaItem() {
		return marcaItem;
	}

	public void setMarcaItem(String marcaItem) {
		this.marcaItem = marcaItem;
	}

	public int getCodItem() {
		return codItem;
	}

	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}


}
