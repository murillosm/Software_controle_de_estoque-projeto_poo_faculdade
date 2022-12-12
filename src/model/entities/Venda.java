package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {

	private int idVenda;
	private Usuario usuario;
	private int cliente;
	private Estoque produto;
	private double valor;
	private int qtd;
	private Date data;

	//private Date data = new Date();
	private List<Estoque> item = new ArrayList<Estoque>();

///////////////construtor\\\\\\\\\\\\\\\\
	public Venda() {
	}

	public Venda(Estoque produto) {
		this.produto = produto;
	}
	
	

	public Venda(int idVenda, Usuario usuario, int cliente, double valor, String data) {
		super();
		this.idVenda = idVenda;
		this.usuario = usuario;
		this.cliente = cliente;
		this.valor = valor;
		try {
			this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Venda(int idVenda, Estoque produto, int qtd) {
		super();
		this.idVenda = idVenda;
		this.produto = produto;
		this.qtd = qtd;
	}

	public Venda(int idVenda, Usuario usuario, int cliente, Estoque produto, double valor, int qtd, String data) {
		super();
		this.idVenda = idVenda;
		this.usuario = usuario;
		this.cliente = cliente;
		this.produto = produto;
		this.valor = valor;
		this.qtd = qtd;
		//this.dataString = dataString;
		try {
			this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Venda(Usuario usuario, int cliente, Estoque produto, double valor, int qtd, String data) {
		super();
		this.usuario = usuario;
		this.cliente = cliente;
		this.produto = produto;
		this.valor = valor;
		this.qtd = qtd;
		try {
			this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
////////////////get e set\\\\\\\\\\\\\\\

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int id) {
		this.idVenda = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
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

	public Date getData() {
		return data;
	}
	
	public String getDataFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
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
		result = prime * result + idVenda;
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
		if (idVenda != other.idVenda)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [id=" + idVenda + ", usuario=" + usuario + ", cliente=" + cliente + ", produto=" + produto + ", valor="
				+ valor + ", qtd=" + qtd + ", dataString=" + data + ", data=" + data + ", item=" + item + "]";
	}
	
	
	

}
