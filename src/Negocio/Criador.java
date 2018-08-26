package Negocio;

import ItensVisuais.Cenario;
import ItensVisuais.PlanoInicial;

public class Criador {
	private PlanoInicial planoInicial = new PlanoInicial();

	public Cenario novoCenario(String nome) {
		return planoInicial.criarNovoCenario(nome);
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
	
	
	public int inserirNovaRamificacao(int cenarioId, String nome) {
		return planoInicial.inserirNovaRamificacao(cenarioId, nome);
	}
	
	public void mostraRamificacoes(int cenarioId) {
		planoInicial.mostraRamificacoes(cenarioId);
	}
}
