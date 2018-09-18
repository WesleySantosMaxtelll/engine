package ItensVisuais;
import java.util.ArrayList;
import java.util.Iterator;

import itens.Cena;
import myExceptions.CenarioException;
import myExceptions.DialogoException;

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
		Iterator<Cenario> iteratorMain = cenariosCriados.iterator();
		while(iteratorMain.hasNext()) {
			Cenario c = iteratorMain.next();
			if (c.getCenarioId() == cenarioId) {
				iteratorMain.remove();
			} else {
				Iterator<Cenario> iteratorInner = c.getPossiveisMovimentacoes().iterator();
				while(iteratorInner.hasNext()) {
					Cenario possivelCenario = iteratorInner.next();
					if (possivelCenario.getCenarioId() == cenarioId) {
						iteratorInner.remove();
					}
				}
			}
	
		}
	}
	
	public void ligarDoisCenarios(int cenarioId1, int cenarioId2) throws CenarioException {
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
	public void inserirNovaRamificacao(int idRamificacao, int cenarioId) throws CenarioException {
		for (Cenario c : cenariosCriados) {
			if(c.getCenarioId() == cenarioId) {
				c.insereNovaRamificacao(idRamificacao);
				return;
			}
		}
		throw new CenarioException("Não foi possível encontrar o cenário");
	}
	
	public void deletarRamificacao(int idRamificacao, int cenarioId) throws CenarioException {
		for (Cenario c : cenariosCriados) {
			if(c.getCenarioId() == cenarioId) {
				c.deletarRamificacao(idRamificacao);
			}
		}
		throw new CenarioException("Não foi possível encontrar o cenário");
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
	
	public void ligarAoComeco(int cenarioId, int ramificacaoId, int idCenaAtual) throws DialogoException {
		for (Cenario c: cenariosCriados) {
			if(c.getCenarioId() == cenarioId) {
				c.getDialogo(ramificacaoId).ligarAoComeço(idCenaAtual);
			}
		}
	}
	
	public void ligarCena(int cenarioId, int ramificacaoId, int idCenaAnterior, int idOpcao, int idCenaAtual) throws DialogoException {
		for (Cenario c: cenariosCriados) {
			if(c.getCenarioId() == cenarioId) {
				c.getDialogo(ramificacaoId).ligarCena(idCenaAnterior, idOpcao, idCenaAtual);
			}
		}
	}
}
