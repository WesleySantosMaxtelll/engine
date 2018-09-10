package Negocio;

import java.util.ArrayList;

import ItensVisuais.Cenario;
import ItensVisuais.Mensagem;
import ItensVisuais.PlanoInicial;
import itens.Cena;
import itens.GerenciadorDeIDs;
import itens.Personagem;
import myExceptions.CenarioNaoEncontrado;

public class Criador {
	public Criador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static GerenciadorDeIDs gerenciador = GerenciadorDeIDs.getInstance();
	
	private PlanoInicial planoInicial = new PlanoInicial();
	
	public void inserirCena(String cenario, String dialogo,ArrayList<Personagem> personagensNaCena, 
			ArrayList<Mensagem> mensagensNaCena) throws CenarioNaoEncontrado {
		Cena cena = new Cena();
		cena.setMensagensNaCena(mensagensNaCena);
		cena.setPersonagensNaCena(personagensNaCena);
		int cenarioId = gerenciador.getCenarioId(cenario);
		int dialogoId = gerenciador.getRamificacaoId(dialogo, cenario);
		planoInicial.inserirCena(cenarioId, dialogoId, cena);
	}
	
	public void novoCenario(String nome) {
		int id = gerenciador.inserirNovoCenario(nome);
		planoInicial.criarNovoCenario(id);
	}
	
	public void novaRamificacao(String ramificacao, String cenario) throws CenarioNaoEncontrado{
		int cenarioId = gerenciador.getCenarioId(cenario);
		int id = gerenciador.novaRamificacao(ramificacao, cenarioId);
		planoInicial.inserirNovaRamificacao(id, cenarioId);
	}
	public void deleteCenario(int cenarioId) {
		planoInicial.deleteCenario(cenarioId);
	}
	
	public void ligarDoisCenarios(int cenarioId1, int cenarioId2) {
		planoInicial.ligarDoisCenarios(cenarioId1, cenarioId2);
	}
	
	public void percorreEstrutura() {
		planoInicial.percorreEstrutura();
	}

	
	public void mostraRamificacoes(int cenarioId) {
		planoInicial.mostraRamificacoes(cenarioId);
	}
	
	public ArrayList<String> nomeDosCenarios() {
		return gerenciador.nomeDosCenarios();
	}
}
