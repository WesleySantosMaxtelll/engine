package ItensVisuais;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;

import itens.Cena;
import myExceptions.DialogoException;

public class LinhaDeDialogo {
	private int id;
	private int idProxCena = 0;
	private No inicio = null;
	private ArrayList<CenaNaLista> cenas = new ArrayList<>();
	
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
	
	public void inserirNovaCena(Cena cena) {
		CenaNaLista nova = new CenaNaLista(idProxCena);
		nova.setCena(cena);
		cenas.add(nova);
	}
	
	public void ligarAoComeço(int idCenaAtual) throws DialogoException {
		No novo = new No(idCenaAtual);
		novo.setProximos(quantidadeDeOpcoes(idCenaAtual));
		inicio = novo;
	}
	public void ligarCena(int idCenaAnterior, int idOpcao, int idCenaAtual) throws DialogoException {
		No p = inicio;
		No novo = new No(idCenaAtual);
		novo.setProximos(quantidadeDeOpcoes(idCenaAtual));
		percursoNaLG(p, idCenaAnterior, idOpcao, novo);
	}
	
	private void percursoNaLG(No p, int idCenaAnterior, int idOpcao, No novo) {
		if(p == null) return;
		if(p.getIdCena() == idCenaAnterior) {
			p.getProximos()[0] = novo;
			return;
		}
		for(int i = 0; i<p.getProximos().length; i++) 
			percursoNaLG(p.getProximos()[i], idCenaAnterior, idOpcao, novo);
	}
	
	private int quantidadeDeOpcoes(int idCenaAtual) throws DialogoException {
		for(CenaNaLista c:cenas) {
			if(c.getId() == idCenaAtual) {
				return c.getCena().getRespostas().size();
			}
		}
		throw new DialogoException("Cena não encontrada");
	}

	class CenaNaLista {
		private Cena cena;
		private int id;
		public Cena getCena() {
			return cena;
		}
		public void setCena(Cena cena) {
			this.cena = cena;
		}
		public int getId() {
			return id;
		}
		public CenaNaLista(int id) {
			this.id = id;
		}
		
	}
	
	class No {
		private int idCena;
		private No[] proximos;
		
		public No(int id) {
			idCena = id;
		}
		
		public int getIdCena() {
			return idCena;
		}

		public No[] getProximos() {
			return proximos;
		}
		public void setProximos(int tamanho) {
			proximos = new No[tamanho];
			for(int i = 0; i < tamanho; i++)
				proximos[i] = null;
		}
		
	}
}

