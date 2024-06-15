package JOGOeTRABALHO;

public class Inimigo extends Personagem{

	public Inimigo(String nome, int vida, int nivel) {
		super (nome, vida, nivel);
	}

	public void ataque(int dado) {
		if (dado > 3) {
			dano = 10 * 2;
			System.out.println("Crítico! " + dano + " damage");
		} else if (dado > 1) {
			dano = 10;
			System.out.println("Ataque normal! " + dano + " damage");
		} else {
			dano = 0;
			System.out.println("Ataque muito fraco, nem arranhou!");
		}
	}
	
}
