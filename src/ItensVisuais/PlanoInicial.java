package ItensVisuais;
import java.util.ArrayList;

import itens.Cena;
import myExceptions.CenarioNaoEncontrado;

public class PlanoInicial {
	private ArrayList<Cenario> cenariosCriados = new ArrayList<Cenario>();

	
	// Acoes com cenarios
	public ArrayList<Cenario> getCenariosCriados() {
		return cenariosCriados;
	}
	
	public Cenario criarNovoCenario(int id) {
		Cenario novoCenario = new Cenario(id);
		insereOutroCenario(novoCenario);
		return novoCenario;
	}
	
	private void insereOutroCenario(Cenario novoCenario) {
		cenariosCriados.add(novoCenario);
	}
	
	public void deleteCenario(int cenarioId) {
		for (int i = 0; i < cenariosCriados.size(); i++) {
			for(int j = 0; j< cenariosCriados.get(i).getPossiveisMovimentacoes().size(); j++) {
				if (cenariosCriados.get(i).getPossiveisMovimentacoes().get(j).getCenarioId() == cenarioId)
					cenariosCriados.get(i).getPossiveisMovimentacoes().remove(j);
			}
			
			if (cenariosCriados.get(i).getCenarioId() == cenarioId) {
				cenariosCriados.remove(i);
			}
		}
	}
	
	public void ligarDoisCenarios(int cenarioId1, int cenarioId2) {
		Cenario c1 = null;
		Cenario c2 = null;
		
		for (Cenario c: cenariosCriados){
			if (c.getCenarioId() == cenarioId1)
				c1 = c;
			if (c.getCenarioId() == cenarioId2)
				c2 = c;
		}
		c1.insereNovaMovimentacao(c2);
		c2.insereNovaMovimentacao(c1);
	}
	// *************************************************************
	
	// Possiveis dialogos em cada cenario
	public int inserirNovaRamificacao(int idRamificacao, int cenarioId) throws CenarioNaoEncontrado {
		for (Cenario c : cenariosCriados) {
			if(c.getCenarioId() == cenarioId) {
				c.insereNovaRamificacao(idRamificacao);
			}
		}
		throw new CenarioNaoEncontrado("Não foi possível encontrar o cenário");
	}
	
	public void deletarRamificacao(int idRamificacao, int cenarioId) throws CenarioNaoEncontrado {
		for (Cenario c : cenariosCriados) {
			if(c.getCenarioId() == cenarioId) {
				c.deletarRamificacao(idRamificacao);
			}
		}
		throw new CenarioNaoEncontrado("Não foi possível encontrar o cenário");
	}
	
	public void mostraRamificacoes(int cenarioId) {
		for (Cenario c : cenariosCriados) {
			if(c.getCenarioId() == cenarioId) {
				for(LinhaDeDialogo l : c.getRamificacoesDeDialogo()) {
					System.out.println(l.getId());
				}
			}
		}
	}
	
	public void percorreEstrutura() {

		for (Cenario c : cenariosCriados) {
			System.out.print("\n"+c.getCenarioId() + "\t");
			for (Cenario t:c.getPossiveisMovimentacoes()) {
				System.out.print(t.getCenarioId()+" ");
			}
		}
	}

	public void inserirCena(int cenarioId, int dialogoId, Cena cena) {
		for (Cenario c: cenariosCriados) {
			c.getDialogo(dialogoId).inserirNovaCena(cena);
		}
		
	}
}
