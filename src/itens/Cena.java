package itens;
import java.util.ArrayList;

import ItensVisuais.Mensagem;

public class Cena {
	private ArrayList<Personagem> personagensNaCena = new ArrayList<Personagem>();
	private ArrayList<Mensagem> mensagensNaCena = new ArrayList<Mensagem>();
	private ArrayList<String> respostas = new ArrayList<String>();

	
	public ArrayList<String> getRespostas() {
		return respostas;
	}
	public void setRespostas(ArrayList<String> respostas) {
		this.respostas = respostas;
	}
	public ArrayList<Personagem> getPersonagensNaCena() {
		return personagensNaCena;
	}
	public void setPersonagensNaCena(ArrayList<Personagem> personagensNaCena) {
		this.personagensNaCena = personagensNaCena;
	}
	public ArrayList<Mensagem> getMensagensNaCena() {
		return mensagensNaCena;
	}
	public void setMensagensNaCena(ArrayList<Mensagem> mensagensNaCena) {
		this.mensagensNaCena = mensagensNaCena;
	}	
}
