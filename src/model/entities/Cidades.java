package model.entities;

public class Cidades {
	private int idCidade;
	private String nomeCidade;
	private Estados estado;

	public Cidades(int idCidade) {
		super();
		this.idCidade = idCidade;
	}

	public Cidades(int idCidade, String nomeCidade, Estados estado) {
		super();
		this.idCidade = idCidade;
		this.nomeCidade = nomeCidade;
		this.estado = estado;
	}

	public Cidades(int idCidade, String nomeCidade) {
		super();
		this.idCidade = idCidade;
		this.nomeCidade = nomeCidade;
	}

	public Cidades() {
	}

	public int getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}




	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCidade;
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
		Cidades other = (Cidades) obj;
		if (idCidade != other.idCidade)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nomeCidade;
	}


	
	
	
}
