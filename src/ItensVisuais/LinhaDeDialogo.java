package ItensVisuais;
import itens.DialogoSequencia;

public class LinhaDeDialogo {
	private int id;
	private String nome;
	private DialogoSequencia inicio;

	
	public LinhaDeDialogo(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}


	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setId(int prioridade) {
		this.id = prioridade;
	}
	public DialogoSequencia getInicio() {
		return inicio;
	}
	public void setInicio(DialogoSequencia inicio) {
		this.inicio = inicio;
	}
	
}
