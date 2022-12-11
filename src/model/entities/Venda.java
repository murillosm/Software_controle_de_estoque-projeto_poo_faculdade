package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {

	private int id;
	private Usuario usuario;
	private Cliente cliente;
	private Estoque produto;
	private double valor;
	private int qtd;
	private String dataString;

	private Date data = new Date();
	private List<Estoque> item = new ArrayList<Estoque>();

///////////////construtor\\\\\\\\\\\\\\\\
	public Venda() {
	}

	public Venda(int id, Usuario usuario, Cliente cliente, Estoque produto, double valor, int qtd, String dataString) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.cliente = cliente;
		this.produto = produto;
		this.valor = valor;
		this.qtd = qtd;
		this.dataString = dataString;
	}

	public Venda(Usuario usuario, Cliente cliente, Estoque produto, double valor, int qtd, String dataString) {
		super();
		this.usuario = usuario;
		this.cliente = cliente;
		this.produto = produto;
		this.valor = valor;
		this.qtd = qtd;
		this.dataString = dataString;
	}
////////////////get e set\\\\\\\\\\\\\\\

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estoque getProduto() {
		return produto;
	}

	public void setProduto(Estoque produto) {
		this.produto = produto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Estoque> getItem() {
		return item;
	}

	public void setItem(List<Estoque> item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Venda other = (Venda) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", usuario=" + usuario + ", cliente=" + cliente + ", produto=" + produto + ", valor="
				+ valor + ", qtd=" + qtd + ", dataString=" + dataString + ", data=" + data + ", item=" + item + "]";
	}
	
	
	

}
