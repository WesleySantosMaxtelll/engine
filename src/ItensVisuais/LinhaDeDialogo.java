package ItensVisuais;
import java.util.ArrayList;

import itens.Cena;

public class LinhaDeDialogo {
	private int id;
	private CenaInteracao cenas = new CenaInteracao();

	public LinhaDeDialogo(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}
	public void setId(int prioridade) {
		this.id = prioridade;
	}
	
	public void deletarCena(int index) {
		//TODO
	}
	
	public void inserirNovaCena(Cena nova) {
		//TODO
	}
}

class CenaInteracao {
	private Cena cena;
	private OpcaoProximaCena[] opcoesDeInteracoes;
	
	public Cena getCena() {
		return cena;
	}
	public void setCena(Cena cena) {
		this.cena = cena;
	}
	public OpcaoProximaCena[] getOpcoesDeInteracoes() {
		return opcoesDeInteracoes;
	}
	public void setOpcoesDeInteracoes(OpcaoProximaCena[] opcoesDeInteracoes) {
		this.opcoesDeInteracoes = opcoesDeInteracoes;
	}
}

class OpcaoProximaCena {
	private CenaInteracao proxInteracao;
	private String opcao;
	public CenaInteracao getProxInteracao() {
		return proxInteracao;
	}
	public void setProxInteracao(CenaInteracao proxInteracao) {
		this.proxInteracao = proxInteracao;
	}
	public String getOpcao() {
		return opcao;
	}
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	
}
