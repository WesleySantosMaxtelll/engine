package ItensVisuais;
import java.util.ArrayList;

public class Cenario {
	private String planoDeFundo;
	private int cenarioId;
	private ArrayList<Cenario> possiveisMovimentacoes = new ArrayList<Cenario>();
	private ArrayList<LinhaDeDialogo> ramificacoesDeDialogo = new ArrayList<LinhaDeDialogo>();
	
	public ArrayList<LinhaDeDialogo> getRamificacoesDeDialogo() {
		return ramificacoesDeDialogo;
	}

	public void setRamificacoesDeDialogo(ArrayList<LinhaDeDialogo> ramificacoesDeDialogo) {
		this.ramificacoesDeDialogo = ramificacoesDeDialogo;
	}

	public Cenario(int cenarioId) {
		super();
		this.cenarioId = cenarioId;
	}
	
	public int getCenarioId() {
		return cenarioId;
	}
	public ArrayList<Cenario> getPossiveisMovimentacoes() {
		return possiveisMovimentacoes;
	}

	public void setPossiveisMovimentacoes(ArrayList<Cenario> possiveisMovimentacoes) {
		this.possiveisMovimentacoes = possiveisMovimentacoes;
	}
	
	public ArrayList<Cenario> getCenarios() {
		return possiveisMovimentacoes;
	}
	
	public void insereNovaMovimentacao(Cenario cenario) {
		possiveisMovimentacoes.add(cenario);
	}

	public String getPlanoDeFundo() {
		return planoDeFundo;
	}

	public void setPlanoDeFundo(String planoDeFundo) {
		this.planoDeFundo = planoDeFundo;
	}
	
	
}