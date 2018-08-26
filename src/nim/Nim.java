package nim;

public class Nim {
	static Estado[] vetor = new Estado[568];
	public static void main(String[] args) {
//		teste(123);
//		System.out.println((652/10)%10);
		//		Estado[] dados = new Estado[568];
		for(int i = 0; i<vetor.length; i++) {
			vetor[i] = new Estado();
		}
		for(int estado = 0; estado<vetor.length;estado++) {
			criaRelacoes(estado);
		}
		vetor[1].setPossivel("n");
		vetor[10].setPossivel("n");
		vetor[100].setPossivel("n");
		setVitoria(1, false);
		setVitoria(10, false);
		setVitoria(100, false);
		mostraConeccoes(0);
	}
	
	public static void mostraConeccoes(int pos) {
		System.out.println(pos + " "+ vetor[pos].getPossivel());
		Aresta p = vetor[pos].getProx();
		while(p!=null) {
			System.out.print(p.getLigacao());
			System.out.print("\t");
			p = p.getProx();
		}
	}
	
	public static void setVitoria(int pos, Boolean v) {
		if(vetor[pos].getPossivel() != null) return;
		if(v) 
			vetor[pos].setPossivel("s");
		else
			vetor[pos].setPossivel("n");
		Aresta p = vetor[pos].getProx();
		while(p!=null) {
			if(p.getDirecao() == "v")
				setVitoria(p.getLigacao(), !v);
		}
	}
	
	
	public static void conecta(int partida, int chegada, String direcao) {
//		System.out.print(partida+" "+chegada+" "+direcao+"\t");
		Aresta nova = new Aresta();
		nova.setDirecao(direcao);
		nova.setLigacao(chegada);
		nova.setProx(vetor[partida].getProx());
		vetor[partida].setProx(nova);
	}
	
	public static void criaRelacoes(int dados) {
//		System.out.print(dados+"\t");
		int c = dados/100;
		int d = (dados/10)%10;
		int u = dados%10;
//		System.out.println(u);
		
		for(int cent = 0; cent <c;cent++) {
			conecta(dados, cent*100+d*10+u, "f");
			conecta(cent*100+d*10+u, dados, "v");
		}
		for(int dez = 0; dez < d ;dez++) {
			conecta(dados, c*100+dez*10+u, "f");
			conecta(c*100+dez*10+u, dados, "v");
		}
		for(int uni = 0; uni < u;uni++) {
			conecta(dados, c*100+d*10+uni, "f");
			conecta(c*100+d*10+uni, dados, "v");
		}
//		System.out.println("\n");
	}
}

class Aresta {
	private int ligacao;
	private String direcao;
	private Aresta prox = null;
	
	
	public int getLigacao() {
		return ligacao;
	}

	public void setLigacao(int ligacao) {
		this.ligacao = ligacao;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public Aresta getProx() {
		return prox;
	}

	public void setProx(Aresta prox) {
		this.prox = prox;
	}
	
}
class Estado {

	private String possivel = null;
	private Aresta prox = null;
	public Aresta getProx() {
		return prox;
	}
	public String getPossivel() {
		return possivel;
	}

	public void setPossivel(String possivel) {
		this.possivel = possivel;
	}

	public void setProx(Aresta prox) {
		this.prox = prox;
	}
	
}
