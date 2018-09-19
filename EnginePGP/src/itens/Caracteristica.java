package itens;

public class Caracteristica {
	private int codigo;
	private String nomeCaracteristica;
	private String descricaoCaracteristica;
	private float minimo;
	private float maximo;
	private float valor;
	
	
	
	public Caracteristica(int codigo, String nomeCaracteristica, String descricaoCaracteristica, float minimo,
			float maximo, float valor) {
		super();
		this.codigo = codigo;
		this.nomeCaracteristica = nomeCaracteristica;
		this.descricaoCaracteristica = descricaoCaracteristica;
		this.minimo = minimo;
		this.maximo = maximo;
		this.valor = valor;
	}
	
	
	public int getCodigo() {
		return codigo;
	}

	public String getNomeCaracteristica() {
		return nomeCaracteristica;
	}
	public String getDescricaoCaracteristica() {
		return descricaoCaracteristica;
	}

	public float getMinimo() {
		return minimo;
	}
	
	public float getMaximo() {
		return maximo;
	}

	public float getValor() {
		return valor;
	}
	public void setSomaValor(float valor) {
		
		float possivel = this.valor + valor;
		if (possivel <= maximo && possivel >= minimo)
			this.valor = possivel;
	}
	
}
