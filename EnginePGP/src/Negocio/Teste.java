package Negocio;

import java.util.ArrayList;

import ItensVisuais.Cenario;
import ItensVisuais.Mensagem;
import itens.Personagem;
import myExceptions.CenarioException;
import myExceptions.DialogoException;

public class Teste {

	public static void main(String[] args) throws CenarioException, DialogoException {
		
		// Testar as ramificacoes
		Criador criador = new Criador();
		
		criador.novoCenario("Sala");
		criador.novoCenario("Cozinha");
		criador.novoCenario("MeuQuarto");
		criador.novoCenario("Suite");
		criador.novoCenario("Corredor");
		criador.novoCenario("Garagem");
		criador.novoCenario("Jardim");
		criador.ligarDoisCenarios("Sala", "Corredor");
		criador.ligarDoisCenarios("Sala", "Cozinha");
		criador.ligarDoisCenarios("Corredor", "MeuQuarto");
		criador.ligarDoisCenarios("Corredor", "Suite");
		criador.ligarDoisCenarios("Sala", "Garagem");
		criador.ligarDoisCenarios("Sala", "Jardim");
		criador.ligarDoisCenarios("Garagem", "Jardim");
//		criador.deleteCenario("Suite");
//		criador.deleteCenario("Garagem");
//		for (String nome:criador.nomeDosCenarios())
//			System.out.println(nome);
		
		criador.atualizaNomeCenario("Jardim", "Piscina");
		criador.novoCenario("Jardim");
		//		criador.novoCenario("Suite");
//		criador.ligarDoisCenarios(0, 1);
//		criador.ligarDoisCenarios(2, 1);
//		
		criador.novaRamificacao("Dialogo com o pai", "Sala");
		criador.novaRamificacao("Dialogo com a mae", "Jardim");
		criador.novaRamificacao("Dialogo com a mae", "Sala");
//		for (String nome:criador.nomeDosCenarios())
//			System.out.println(nome);
		
//		criador.mostraRamificacoes("Sala");
//		criador.inserirNovaRamificacao(1, "Dialogo com a mae");
//		criador.inserirNovaRamificacao(1, "Dialogo com o irmao");
//		criador.insereEmRamificacao(1, "Dialogo com o pai");
//		
//		criador.deleteCenario(2);
//		System.out.println(c.getCenarioId());
//		criador.percorreEstrutura();
//		criador.mostraRamificacoes(1);
	}
	
	public static void inserirCenaTeste() {
		String cenario = "Sala";
		String dialogo = "Dialogo com a mae";
		ArrayList<Personagem> personagensNaCena = new ArrayList<>();
//		Personagem p1 = new 
//		ArrayList<Mensagem> mensagensNaCena = new ArrayList<>();
//		
	}
}
