package ItensVisuais;
import java.util.ArrayList;

public class PlanoInicial {
	private ArrayList<Cenario> cenariosCriados = new ArrayList<Cenario>();

	public ArrayList<Cenario> getCenariosCriados() {
		return cenariosCriados;
	}

	public void setCenariosCriados(ArrayList<Cenario> cenariosCriados) {
		this.cenariosCriados = cenariosCriados;
	}
	
	public void insereOutroCenario(Cenario novoCenario) {
		cenariosCriados.add(novoCenario);
	}
}
