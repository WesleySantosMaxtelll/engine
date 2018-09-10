package itens;

import java.util.ArrayList;

import myExceptions.CenarioNaoEncontrado;

public class GerenciadorDeIDs {
	private GerenciadorDeIDs() {
	}
	private static GerenciadorDeIDs instancia = new GerenciadorDeIDs();
	
	public static GerenciadorDeIDs getInstance() {
		return instancia;
	}
	
	
	private ArrayList<IdComCenario> cenarios = new ArrayList<>(); 
	private int ramificacaoId = 0;
	private int cenarioId = 0;
	
	
	public ArrayList<String> nomeDosCenarios() {
		ArrayList<String> nomes = new ArrayList<String>();
		for (IdComCenario c: cenarios) {
			nomes.add(c.getNome());
		}
		return nomes;
	}

	
	public int inserirNovoCenario(String cenario) {
		IdComCenario novo = new IdComCenario();
		novo.setNome(cenario);
		novo.setId(cenarioId);
		cenarios.add(novo);
		return cenarioId;
	}
	
	public int novaRamificacao(String ramificacao, int cenarioId) throws CenarioNaoEncontrado {
		for (int i = 0; i <cenarios.size(); i++) {
			if(cenarios.get(i).getId() == cenarioId) {
				return cenarios.get(i).insereNovaRamificacao(ramificacao);
			}
		}
		throw new CenarioNaoEncontrado("Não foi possível encontrar o cenário");
	}
	
	public int getCenarioId(String nome) throws CenarioNaoEncontrado {
		for (int i = 0; i <cenarios.size(); i++) {
			if(cenarios.get(i).getNome() == nome) {
				return cenarios.get(i).getId();
			}
		}
		throw new CenarioNaoEncontrado("Não foi possível encontrar o cenário");
	}
	
	public int getRamificacaoId(String nomeR, String nomeC) throws CenarioNaoEncontrado {
		for (int i = 0; i <cenarios.size(); i++) {
			if(cenarios.get(i).getNome() == nomeC) {
				return cenarios.get(i).getRamificacaoId(nomeR);
			}
		}
		throw new CenarioNaoEncontrado("Não foi possível encontrar o cenário");
	}
	
	public ArrayList<IdComCenario> getCenarios() {
		return cenarios;
	}
	public void setCenarios(ArrayList<IdComCenario> cenarios) {
		this.cenarios = cenarios;
	}
	public int getRamificacaoId() {
		return ramificacaoId;
	}
	public void setRamificacaoId(int ramificacaoId) {
		this.ramificacaoId = ramificacaoId;
	}
	
}

class IdComCenario{
	private String nome;
	private int id;
	private int idProxRamificacao;
	private ArrayList<IdComRamificacao> ramificacoes = new ArrayList<>();
	
	public int insereNovaRamificacao(String ramificacao) {
		IdComRamificacao novo = new IdComRamificacao();
		novo.setNome(ramificacao);
		novo.setId(idProxRamificacao);
		ramificacoes.add(novo);
		return idProxRamificacao++;
	}
	
	public int getRamificacaoId(String nome) throws CenarioNaoEncontrado {
		for(IdComRamificacao i: ramificacoes) {
			if(i.getNome() == nome) 
				return i.getId();
		}
		throw new CenarioNaoEncontrado("Não foi possível encontrar o dialogo");
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProxRamificacao() {
		return idProxRamificacao;
	}
	public void setIdProxRamificacao(int idProxRamificacao) {
		this.idProxRamificacao = idProxRamificacao;
	}
	
}

class IdComRamificacao{
	private String nome;
	private int id;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}