package Negocio;

import ItensVisuais.Cenario;

public class Teste {
	public static void main(String[] args) {
		Criador criador = new Criador();
		criador.novoCenario("Sala");
		criador.novoCenario("cozinha");
		criador.novoCenario("Quarto");
		criador.novoCenario("corredor");
		criador.novoCenario("garagem");
		criador.ligarDoisCenarios(2, 4);
		criador.ligarDoisCenarios(0, 1);
		criador.ligarDoisCenarios(2, 1);
		
//		criador.deleteCenario(2);
//		System.out.println(c.getCenarioId());
		criador.percorreEstrutura();
	}
}
