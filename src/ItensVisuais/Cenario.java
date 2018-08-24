package ItensVisuais;
import java.util.ArrayList;

public class Cenario {
	private String planoDeFundo;
	private String nome;
	private int cenarioId;
	private int idRamificacao = 0;
	private ArrayList<Cenario> possiveisMovimentacoes = new ArrayList<Cenario>();
	private ArrayList<LinhaDeDialogo> ramificacoesDeDialogo = new ArrayList<LinhaDeDialogo>();
	
	public ArrayList<LinhaDeDialogo> getRamificacoesDeDialogo() {
		return ramificacoesDeDialogo;
	}

	public void setRamificacoesDeDialogo(ArrayList<LinhaDeDialogo> ramificacoesDeDialogo) {
		this.ramificacoesDeDialogo = ramificacoesDeDialogo;
	}
	public int insereNovaRamificacao(String nome) {
		LinhaDeDialogo novaLinha = new LinhaDeDialogo(idRamificacao, nome);
		ramificacoesDeDialogo.add(novaLinha);
		return idRamificacao++;
	}

	public Cenario(int cenarioId, String nome) {
		super();
		this.cenarioId = cenarioId;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdRamificacao() {
		return idRamificacao;
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

	public String getPlanoDeFundo() {
		return planoDeFundo;
	}

	public void setPlanoDeFundo(String planoDeFundo) {
		this.planoDeFundo = planoDeFundo;
	}
	
	
}
