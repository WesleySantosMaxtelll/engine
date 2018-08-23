package ItensVisuais;
import itens.DialogoSequencia;

public class LinhaDeDialogo {
	private int id;
	private DialogoSequencia inicio;
	
	
	public LinhaDeDialogo(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
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
