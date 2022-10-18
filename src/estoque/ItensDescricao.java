package estoque;

public class ItensDescricao
{

	private String descricaoItem;
	private String nomeItem;
	public String marcaItem;
	private int codItem;

	public void descreverItem() {
		// Start of user code for method descreverItem
		// End of user code
	}
//////////////construtor\\\\\\\\\\\\\\\\\
	public ItensDescricao(String descricaoItem, String nomeItem, String marcaItem, int codItem) {
		super();
		this.descricaoItem = descricaoItem;
		this.nomeItem = nomeItem;
		this.marcaItem = marcaItem;
		this.codItem = codItem;
	}
	
///////////////set e get\\\\\\\\\\\\\\\\\\
	
	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
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
//////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Itens Descrição [descrição Item=" + descricaoItem + ", nome Item=" + nomeItem + ", marca Item=" + marcaItem
				+ ", codItem=" + codItem + "]";
	}
	

}
