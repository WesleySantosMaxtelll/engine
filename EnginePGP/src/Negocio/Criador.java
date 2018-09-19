package Negocio;

import java.util.ArrayList;

import ItensVisuais.Cenario;
import ItensVisuais.Mensagem;
import ItensVisuais.PlanoInicial;
import itens.Cena;
import itens.GerenciadorDeIDs;
import itens.Personagem;
import myExceptions.CenarioException;
import myExceptions.DialogoException;

public class Criador {
	public Criador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static GerenciadorDeIDs gerenciador = GerenciadorDeIDs.getInstance();
	
	private PlanoInicial planoInicial = new PlanoInicial();
	
	public void inserirCena(String cenario, String dialogo, ArrayList<Personagem> personagensNaCena, 
			ArrayList<Mensagem> mensagensNaCena) throws CenarioException {
		Cena cena = new Cena();
		cena.setMensagensNaCena(mensagensNaCena);
		cena.setPersonagensNaCena(personagensNaCena);
		int cenarioId = gerenciador.getCenarioId(cenario);
		int dialogoId = gerenciador.getRamificacaoId(dialogo, cenario);
		planoInicial.inserirCena(cenarioId, dialogoId, cena);
	}
	
	public void novoCenario(String nome) throws CenarioException {
		planoInicial.criarNovoCenario(gerenciador.inserirNovoCenario(nome));
	}
	
	public void novaRamificacao(String ramificacao, String cenario) throws CenarioException, DialogoException{
		int cenarioId = gerenciador.getCenarioId(cenario);
		int id = gerenciador.novaRamificacao(ramificacao, cenarioId);
		planoInicial.inserirNovaRamificacao(id, cenarioId);
	}
	
	public void deleteCenario(String cenario) throws CenarioException {
		planoInicial.deleteCenario(gerenciador.deleteCenario(cenario));
	}
	
	public void ligarDoisCenarios(String cenario1, String cenario2) throws CenarioException {
		int cenarioId1 = gerenciador.getCenarioId(cenario1);
		int cenarioId2 = gerenciador.getCenarioId(cenario2);
		planoInicial.ligarDoisCenarios(cenarioId1, cenarioId2);
	}
	
	
	public void ligarAoComeco(String cenario, String ramificacao, int idCenaAtual) throws DialogoException, CenarioException {
		int cenarioId = gerenciador.getCenarioId(cenario);
		int ramificacaoId = gerenciador.getRamificacaoId(ramificacao, cenario);
		planoInicial.ligarAoComeco(cenarioId, ramificacaoId, idCenaAtual);
	}
	
	public void ligarCena(String cenario, String ramificacao,
			int idCenaAnterior, int idOpcao, int idCenaAtual) throws DialogoException, CenarioException {
		int cenarioId = gerenciador.getCenarioId(cenario);
		int ramificacaoId = gerenciador.getRamificacaoId(ramificacao, cenario);
		planoInicial.ligarCena(cenarioId, ramificacaoId, idCenaAnterior, idOpcao, idCenaAtual);
	}
	
	
	public void atualizaNomeCenario(String cenario, String novoNome) throws CenarioException {
		gerenciador.atualizaNomeCenario(cenario, novoNome);
	}
	
	public void percorreEstrutura() {
		planoInicial.percorreEstrutura();
	}

	
	public void mostraRamificacoes(String cenario) throws CenarioException {
		int idCenario = gerenciador.getCenarioId(cenario);
		planoInicial.mostraRamificacoes(idCenario);
	}
	
	public ArrayList<String> nomeDosCenarios() {
		return gerenciador.nomeDosCenarios();
	}
}
