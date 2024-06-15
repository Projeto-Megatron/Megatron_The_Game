package JOGOeTRABALHO;

public abstract class Personagem {

	protected String nome;
	protected int vida;
	protected int nivel;
	protected int dano;

	public Personagem(String nome, int vida, int nivel) {
		this.nome = nome;
		this.vida = vida;
		this.nivel = nivel;
		this.dano = 0;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nNível: " + nivel + "\nVida: " + vida;
	}

	public abstract void ataque(int dado);

}
