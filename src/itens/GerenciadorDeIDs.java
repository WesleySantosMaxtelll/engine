package itens;

import java.util.ArrayList;

import ItensVisuais.Cenario;
import myExceptions.CenarioException;

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

	private boolean nomeSendoUsado(String nome) throws CenarioException {
		for (IdComCenario c: cenarios) {
			if (c.getNome() == nome) {
				return true;
			}
		}
		return false;
	}
	public int inserirNovoCenario(String cenario) throws CenarioException {
		if(nomeSendoUsado(cenario))
			throw new CenarioException("Nome de cenário já está sendo utilizado");
		
		IdComCenario novo = new IdComCenario();
		novo.setNome(cenario);
		novo.setId(cenarioId);
		cenarios.add(novo);
		return cenarioId++;
	}
	
	public int novaRamificacao(String ramificacao, int cenarioId) throws CenarioException {
		for (int i = 0; i <cenarios.size(); i++) {
			if(cenarios.get(i).getId() == cenarioId) {
				return cenarios.get(i).insereNovaRamificacao(ramificacao);
			}
		}
		throw new CenarioException("Não foi possível encontrar o cenário");
	}
	
	public int getCenarioId(String nome) throws CenarioException {
		for (int i = 0; i <cenarios.size(); i++) {
			if(cenarios.get(i).getNome() == nome) {
				return cenarios.get(i).getId();
			}
		}
		throw new CenarioException("Não foi possível encontrar o cenário");
	}
	
	public int getRamificacaoId(String nomeR, String nomeC) throws CenarioException {
		for (int i = 0; i <cenarios.size(); i++) {
			if(cenarios.get(i).getNome() == nomeC) {
				return cenarios.get(i).getRamificacaoId(nomeR);
			}
		}
		throw new CenarioException("Não foi possível encontrar o cenário");
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

	
	public int deleteCenario(String cenario) throws CenarioException {
		int id;
		for (int i = 0; i <cenarios.size(); i++) {
			if(cenarios.get(i).getNome() == cenario) {
				id = cenarios.get(i).getId();
				cenarios.remove(i);
				return id;
			}
		}
		throw new CenarioException("Não foi possível encontrar o cenário");
	}


	public void atualizaNomeCenario(String cenario, String novoNome) throws CenarioException {
		if(nomeSendoUsado(novoNome))
			throw new CenarioException("Nome de cenário já está sendo utilizado");
		
		for (IdComCenario c: cenarios) {
			if (c.getNome() == cenario) {
				c.setNome(novoNome);
				return;
			}
		}
		throw new CenarioException("Não foi possível encontrar o cenário");
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
	
	public int getRamificacaoId(String nome) throws CenarioException {
		for(IdComRamificacao i: ramificacoes) {
			if(i.getNome() == nome) 
				return i.getId();
		}
		throw new CenarioException("Não foi possível encontrar o dialogo");
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