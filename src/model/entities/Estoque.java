package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

	private int idItem;
	private Double PrecoItem;
	private Integer quantidade;
	private String nomeItem;
	private String marcaItem;
	private String descricaoItem;
	private Fornecedor forn = new Fornecedor();

//////////////construtor\\\\\\\\\\\\\\\\\
	public Estoque() {
	}
	
	public Estoque(int idItem, Double precoItem, Integer quantidade, String nomeItem, String marcaItem,
			String descricaoItem, Fornecedor forn) {
		super();
		this.idItem = idItem;
		this.PrecoItem = precoItem;
		this.quantidade = quantidade;
		this.nomeItem = nomeItem;
		this.marcaItem = marcaItem;
		this.descricaoItem = descricaoItem;
		this.forn = forn;
	}
	
	public Estoque(Double precoItem, Integer quantidade, String nomeItem, String marcaItem, String descricaoItem,
			Fornecedor forn) {
		super();
		this.PrecoItem = precoItem;
		this.quantidade = quantidade;
		this.nomeItem = nomeItem;
		this.marcaItem = marcaItem;
		this.descricaoItem = descricaoItem;
		this.forn = forn;
	}

///////////////set e get\\\\\\\\\\\\\\\\\\
	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Double getPrecoItem() {
		return PrecoItem;
	}

	public void setPrecoItem(Double precoItem) {
		PrecoItem = precoItem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	

	public Fornecedor getForn() {
		return forn;
	}

	public void setForn(Fornecedor forn) {
		this.forn = forn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idItem;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (idItem != other.idItem)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estoque [idItem=" + idItem + ", PrecoItem=" + PrecoItem + ", quantidade=" + quantidade
				+ ", nomeItem=" + nomeItem + ", marcaItem=" + marcaItem + ", descricaoItem=" + descricaoItem + ", forn="
				+ forn + "]";
	}

	
	
	
	
	
}
