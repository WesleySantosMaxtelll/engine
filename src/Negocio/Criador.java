package Negocio;

import ItensVisuais.Cenario;
import ItensVisuais.PlanoInicial;

public class Criador {
	private PlanoInicial planoInicial = new PlanoInicial();
	private static Criador criador = new Criador();
	
	public static Criador criarNovoJogo() {
		return criador;
	}
	
	public Cenario novoCenario() {
		return planoInicial.criarNovoCenario();
	}
	
	public void deleteCenario(int cenarioId) {
		planoInicial.deleteCenario(cenarioId);
	}
	
	public void ligarDoisCenarios(int cenarioId1, int cenarioId2) {
		planoInicial.ligarDoisCenarios(cenarioId1, cenarioId2);
	}
	
	
}
