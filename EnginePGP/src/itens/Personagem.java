package itens;
import java.util.ArrayList;

public class Personagem {
	private int id;
	
	private String nome;
	private String imagemPadrao;
	private String Descricao;
	private ArrayList<Caracteristica> caracteristicas = new ArrayList<Caracteristica>(); 
	
	public void inserirCaracteristica(Caracteristica caracteristica) {
		caracteristicas.add(caracteristica);
	}
	
	public ArrayList<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagemPadrao() {
		return imagemPadrao;
	}
	public void setImagemPadrao(String imagemPadrao) {
		this.imagemPadrao = imagemPadrao;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
}
