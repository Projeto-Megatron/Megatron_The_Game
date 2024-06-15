package JOGOeTRABALHO;

public class Jogador extends Personagem {

	private int mana;
	private int estamina;
	private int quantidade;

	public Jogador(String nome, int vida, int nivel, int mana, int estamina) {
		super(nome, vida, nivel);
		this.mana = mana;
		this.estamina = estamina;
		this.quantidade = 1;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public void setEstamina(int estamina) {
		this.estamina = estamina;
	}

	@Override
	public String toString() {
		return super.toString() + "\nMana: " + mana + "\nEstamina: "
				+ estamina;
	}
	
	public void cura() {
		this.vida += 50;
		System.out.println("Usou porção de cura! +50 de vida");
		setQuantidade(0); 
	}
	
	@Override
	public void ataque(int dado) {
		if (estamina > 10) {
			if (dado > 3) {
				dano = (nivel/10+1) * 15 * 2;
				System.out.println("Crítico! " + dano + " damage");
				estamina -= 10;
			} else if (dado > 1) {
				dano = (nivel/10+1) * 15;
				System.out.println("Ataque normal! " + dano + " damage");
				estamina -= 10;
			} else {
				dano = 0;
				System.out.println("Ataque falhou!");
				estamina -= 10;
			}
		} else {
			System.out.println("Estamina insuficiente! Descansando...");
			recuperacao();
		}
	}

	public void ataqueMagico(int dado) {
		if (mana > 25) {
			if (dado > 3) {
				dano = (nivel/10+1) * 30 * 2;
				System.out.println("Crítico! " + dano + " damage");
				mana -= 25;
			} else if (dado > 1) {
				dano = (nivel/10+1) * 30;
				System.out.println("Ataque normal! " + dano + " damage");
				mana -= 25;
			} else {
				dano = 0;
				System.out.println("Ataque falhou!");
				mana -= 25;
			}
		} else {
			System.out.println("Mana insuficiente! Recuperando mana...");
			recuperacao();
		}
	}

	public void defesa(int dado) {
		if (estamina > 15) {
			if (dado > 3) {
				System.out.println("Defesa bem-sucedida!");
				mana += 10;
				estamina -= 15;
			} else if (dado > 1) {
				System.out.println("Defesa parcial");
				mana += 10;
				estamina -= 15;
			} else {
				System.out.println("Defesa falhou");
				mana += 10;
				estamina -= 15;
			}
		}
	}

	public void recuperacao() {
		mana += 10;
		estamina += 10;
		System.out.println("Mana e Estamina recuperadas.");
	}
	
	public void levelUp() {
		nivel++;
		vida = vida * 0 + 60 + (20 * nivel);
		mana = mana * 0 + 60 + (20 * nivel);
		estamina = estamina * 0 + 40 + (20 * nivel);
		System.out.println("Status recuperados! Upgrade em todos atributos!");
	}
}
