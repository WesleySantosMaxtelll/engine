package ItensVisuais;
import java.util.ArrayList;

import itens.Cena;

public class LinhaDeDialogo {
	private int id;
	private ArrayList<Cena> cenas = new ArrayList<Cena>();

	public LinhaDeDialogo(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}
	public void setId(int prioridade) {
		this.id = prioridade;
	}
	
	public void deletarCena(int index) {
		cenas.remove(index);
	}
	
	public void inserirNovaCena(Cena nova) {
		cenas.add(nova);
	}
}
