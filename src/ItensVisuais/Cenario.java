package ItensVisuais;
import java.util.ArrayList;

public class Cenario {
	private String planoDeFundo;
	
	private ArrayList<Cenario> possiveisMovimentacoes = new ArrayList<Cenario>();
	
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
