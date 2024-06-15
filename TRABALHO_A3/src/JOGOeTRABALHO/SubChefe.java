package JOGOeTRABALHO;

public class SubChefe extends Personagem {
	
	int ataqueEspecial;
	
	public SubChefe (String nome, int vida, int nivel) {
		super (nome, vida, nivel);
	}
	
	public void ataque(int dado) {
		if (dado > 3) {
			dano= 15 * 2;
			System.out.println("Crítico! " +dano+ " damage");
		} else if (dado > 1) {
			dano= 15;
			System.out.println("Ataque normal! " +dano+ " damage");
		} else {
			dano= 2;
			System.out.println("Ataque muito fraco, só arranhou!");
		}
	}
	
	public void ataqueEspecial(int dado) {
		if (dado > 3) {
			dano= 25 * 2;
			System.out.println("Crítico! " +dano+ " damage");
		} else if (dado > 1) {
			dano= 25;
			System.out.println("Ataque normal! " +dano+ " damage");
		} else {
			dano= 5;
			System.out.println("Ataque muito fraco!");
		}
	}

}
