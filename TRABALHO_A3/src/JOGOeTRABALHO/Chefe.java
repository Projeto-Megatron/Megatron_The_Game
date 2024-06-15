package JOGOeTRABALHO;

public class Chefe extends Personagem {

	int ataqueEspecial;
	int superAtaque;

	public Chefe(String nome, int vida, int nivel) {
		super(nome, vida, nivel);
	}

	public void ataque(int dado) {
		if (dado > 3) {
			dano = 20 * 2;
			System.out.println("Crítico! " + dano + " damage");
		} else if (dado > 1) {
			dano = 20;
			System.out.println("Ataque normal! " + dano + " damage");
		} else {
			dano = 5;
			System.out.println("Ataque muito fraco!");
		}
	}

	public void ataqueEspecial(int dado) {
		if (dado > 3) {
			dano = 30 * 2;
			System.out.println("Crítico! " + dano + " damage");
		} else if (dado > 1) {
			dano = 30;
			System.out.println("Ataque normal! " + dano + " damage");
		} else {
			dano = 10;
			System.out.println("Ataque fraco!");
		}
	}

	public void superAtaque(int dado) {
		if (dado > 3) {
			dano = 50 * 2;
			System.out.println("Crítico! " + dano + " damage");
		} else if (dado > 1) {
			dano = 50;
			System.out.println("Ataque normal! " + dano + " damage");
		} else {
			dano = 15;
			System.out.println("Ataque simples!");
		}
	}
}
