package ItensVisuais;
import itens.DialogoSequencia;

public class LinhaDeDialogo {
	private int prioridade;
	private DialogoSequencia inicio;
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public DialogoSequencia getInicio() {
		return inicio;
	}
	public void setInicio(DialogoSequencia inicio) {
		this.inicio = inicio;
	}
	
}
