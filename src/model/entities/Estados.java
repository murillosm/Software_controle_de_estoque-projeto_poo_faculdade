package model.entities;

public class Estados {
	private int idEstado;
    private String nomeEstado;
    private String UF;
    
    
    
	public Estados(int idEstado) {
		super();
		this.idEstado = idEstado;
	}

	public Estados(int idEstado, String nomeEstado) {
		super();
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
	}

	public Estados(int idEstado, String nomeEstado, String uF) {
		super();
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
		this.UF = uF;
	}

	public Estados() {
		super();
	}


	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}


	public String getNomeEstado() {
		return nomeEstado;
	}


	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}


	public String getUF() {
		return UF;
	}


	public void setUF(String UF) {
		this.UF = UF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEstado;
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
		Estados other = (Estados) obj;
		if (idEstado != other.idEstado)
			return false;
		return true;
	}
    
	@Override
	public String toString() {
		return "idEstado=" + idEstado + ", nomeEstado=" + nomeEstado ;
	}

}
