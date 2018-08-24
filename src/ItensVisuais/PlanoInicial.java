package ItensVisuais;
import java.util.ArrayList;

public class PlanoInicial {
	private int proximoCenarioId = 0;
	private ArrayList<Cenario> cenariosCriados = new ArrayList<Cenario>();

	public ArrayList<Cenario> getCenariosCriados() {
		return cenariosCriados;
	}

	public void setCenariosCriados(ArrayList<Cenario> cenariosCriados) {
		this.cenariosCriados = cenariosCriados;
	}
	
	public Cenario criarNovoCenario(String nome) {
		Cenario novoCenario = new Cenario(proximoCenarioId++, nome);
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
	
	public int inserirNovaRamificacao(int cenarioId, String nome) {
		for (Cenario c : cenariosCriados) {
			if(c.getCenarioId() == cenarioId) {
				return c.insereNovaRamificacao(nome);
			}
		}
		return -1;
	}
	
	
	public void percorreEstrutura() {
		for (Cenario c : cenariosCriados) {
			System.out.print("\n"+c.getCenarioId() + "\t");
			for (Cenario t:c.getPossiveisMovimentacoes()) {
				System.out.print(t.getCenarioId()+" ");
			}
		}
	}
}
