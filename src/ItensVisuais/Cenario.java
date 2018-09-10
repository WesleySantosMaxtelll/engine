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
	
	public void insereNovaRamificacao(int idRamificacao) {
		LinhaDeDialogo novaLinha = new LinhaDeDialogo(idRamificacao);
		ramificacoesDeDialogo.add(novaLinha);
	}
	
	public LinhaDeDialogo getDialogo(int id) {
		for(LinhaDeDialogo l: ramificacoesDeDialogo) {
			if(l.getId() == id)
				return l;
		}
		return null;
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
	
	public void insereNovaMovimentacao(Cenario cenario) {
		possiveisMovimentacoes.add(cenario);
	}

	public void deletarRamificacao(int idRamificacao) {
		//TODO
	}
	
	public String getPlanoDeFundo() {
		return planoDeFundo;
	}

	public void setPlanoDeFundo(String planoDeFundo) {
		this.planoDeFundo = planoDeFundo;
	}

	
}
