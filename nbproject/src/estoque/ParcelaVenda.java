package estoque;

public class ParcelaVenda {

	private int numParcelas;
	private float valorParcela;
	private int diaVencPagar;
	private int mesVencPagar;
	private int anoVencPagar;

/////////////construtor\\\\\\\\\\\\\\\
	public ParcelaVenda(int numParcelas, float valorParcela, int diaVencPagar, int mesVencPagar, int anoVencPagar) {
		super();
		this.numParcelas = numParcelas;
		this.valorParcela = valorParcela;
		this.diaVencPagar = diaVencPagar;
		this.mesVencPagar = mesVencPagar;
		this.anoVencPagar = anoVencPagar;
	}
///////////////set e get\\\\\\\\\\\\\\\\

	public int getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(int numParcelas) {
		this.numParcelas = numParcelas;
	}

	public float getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(float valorParcela) {
		this.valorParcela = valorParcela;
	}

	public int getDiaVencPagar() {
		return diaVencPagar;
	}

	public void setDiaVencPagar(int diaVencPagar) {
		this.diaVencPagar = diaVencPagar;
	}

	public int getMesVencPagar() {
		return mesVencPagar;
	}

	public void setMesVencPagar(int mesVencPagar) {
		this.mesVencPagar = mesVencPagar;
	}

	public int getAnoVencPagar() {
		return anoVencPagar;
	}

	public void setAnoVencPagar(int anoVencPagar) {
		this.anoVencPagar = anoVencPagar;
	}
	
}
