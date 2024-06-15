package JOGOeTRABALHO;

import java.util.Scanner;
import java.lang.Math;

public class Batalha {
	private Jogador player;
	private Inimigo inimigo;
	private SubChefe subchefe;
	private Chefe chefe;
	private Scanner ler;

	public Batalha(Jogador player, Inimigo inimigo, Scanner ler) {
		this.player = player;
		this.inimigo = inimigo;
		this.ler = ler;
	}

	public Batalha(Jogador player, SubChefe subchefe, Scanner ler) {
		this.player = player;
		this.subchefe = subchefe;
		this.ler = ler;
	}

	public Batalha(Jogador player, Chefe chefe, Scanner ler) {
		this.player = player;
		this.chefe = chefe;
		this.ler = ler;
	}

	public void batalharInimigo() {
		if (player.vida > 0) {
			System.out.println("Começando a batalha contra: " + inimigo.nome);
			System.out.println();
		}

		while (player.vida > 0 && inimigo.vida > 0) {

			int dadoJogador = (int) (Math.random() * 6) + 1;
			int dadoInimigo = (int) (Math.random() * 6) + 1;

			System.out.println("----------------------------------");
			System.out.println("Você: \n" + player.toString());
			System.out.println();
			System.out.println("Adversário: \n" + inimigo.toString());
			System.out.println();

			System.out.println("----------------------------------");
			System.out.println("O que deseja fazer?" + "\nDigite: " + "\n(1) - Ataque Mágico (-25 mana)"
					+ "\n(2) - Ataque com cajado (-10 estamina)" + "\n(3) - Defender (-15 estamina)" + "\n(4) - Qunt: "
					+ player.getQuantidade() + " Curar");
			System.out.println("----------------------------------");

			int opcaoAtaque = ler.nextInt();
			if (opcaoAtaque == 1) {
				System.out.println("Rolando o dado: " + dadoJogador);
				player.ataqueMagico(dadoJogador);
				inimigo.vida -= player.dano;
			} else if (opcaoAtaque == 2) {
				System.out.println("Rolando o dado: " + dadoJogador);
				player.ataque(dadoJogador);
				inimigo.vida -= player.dano;
			} else if (opcaoAtaque == 4) {
				if (player.getQuantidade() == 1) {
					player.cura();
				} else {
					System.out.println("Você não tem porção de cura!");
				}
			} else {
				player.defesa(dadoJogador);
				System.out.println("Você escolheu defender! Aguarde a jogada do adversário.");
			}

			if (inimigo.vida > 0) {
				System.out.println();
				System.out.println("Rodada do adversário. Aguarde...");
				System.out.println("Rolando o dado: " + dadoInimigo);
				inimigo.ataque(dadoInimigo);

				if (opcaoAtaque != 3) {
					player.vida -= inimigo.dano;
				} else {
					if (dadoJogador > 3) {
						System.out.println("Ataque defendido");
					} else if (dadoJogador > 1) {
						System.out.println("Dano reduzido pela metade");
						player.vida -= inimigo.dano * 0.5;
					} else {
						System.out.println("Defesa do jogador falhou!");
						player.vida -= inimigo.dano;
					}
				}
			}
			System.out.println();
			if (inimigo.vida <= 0) {
				System.out.println("Você venceu a batalha!");
				player.levelUp();
				player.toString();
			}
			System.out.println();
		}
	}

	public void batalharSubChefe() {
		if (player.vida > 0) {
			System.out.println("Começando a batalha contra: " + subchefe.nome);
			System.out.println();
		}

		while (player.vida > 0 && subchefe.vida > 0) {

			int dadoJogador = (int) (Math.random() * 6) + 1;
			int dadoInimigo = (int) (Math.random() * 6) + 1;
			int dadoAtaqueInimigo = (int) (Math.random() * 2) + 1;

			System.out.println("----------------------------------");
			System.out.println("Você: \n" + player.toString());
			System.out.println();
			System.out.println("Adversário: \n" + subchefe.toString());
			System.out.println();

			System.out.println("----------------------------------");
			System.out.println("O que deseja fazer?" + "\nDigite: " + "\n(1) - Ataque Mágico (-25 mana)"
					+ "\n(2) - Ataque com cajado (-10 estamina)" + "\n(3) - Defender (-15 estamina)" + "\n(4) - Qunt: "
					+ player.getQuantidade() + " Curar");
			System.out.println("----------------------------------");

			int opcaoAtaque = ler.nextInt();
			if (opcaoAtaque == 1) {
				System.out.println("Rolando o dado: " + dadoJogador);
				player.ataqueMagico(dadoJogador);
				subchefe.vida -= player.dano;
			} else if (opcaoAtaque == 2) {
				System.out.println("Rolando o dado: " + dadoJogador);
				player.ataque(dadoJogador);
				subchefe.vida -= player.dano;
			} else if (opcaoAtaque == 4) {
				if (player.getQuantidade() == 1) {
					player.cura();
				} else {
					System.out.println("Você não tem porção de cura!");
				}
			} else {
				player.defesa(dadoJogador);
				System.out.println("Você escolheu defender! Aguarde a jogado do adversário.");
			}

			if (subchefe.vida > 0) {
				System.out.println();
				System.out.println("Rodada do adversário. Arguarde...");
				if (dadoAtaqueInimigo == 1) {
					System.out.println(subchefe.nome + " usou ataque normal");
					System.out.println("Rolando o dado: " + dadoInimigo);
					subchefe.ataque(dadoInimigo);
					if (opcaoAtaque != 3) {
						player.vida -= subchefe.dano;
					}
					if (opcaoAtaque == 3) {
						if (dadoJogador > 3) {
							System.out.println("Ataque defendido");
						} else if (dadoJogador > 1) {
							System.out.println("Dano reduzido pela metade");
							player.vida -= subchefe.dano * 0.5;
						} else {
							System.out.println("Defesa do jogador falhou!");
							player.vida -= subchefe.dano;
						}
					}
				} else {
					System.out.println(subchefe.nome + " usou ataque especial");
					System.out.println("Rolando o dado: " + dadoInimigo);
					subchefe.ataqueEspecial(dadoInimigo);
					if (opcaoAtaque != 3) {
						player.vida -= subchefe.ataqueEspecial;
					}
					if (opcaoAtaque == 3) {
						if (dadoJogador > 3) {
							System.out.println("Ataque defendido");
						} else if (dadoJogador > 1) {
							System.out.println("Dano reduzido pela metade");
							player.vida -= subchefe.ataqueEspecial * 0.5;
						} else {
							System.out.println("Defesa do jogador falhou!");
							player.vida -= subchefe.ataqueEspecial;
						}
					}
				}
			}
			System.out.println();
			if (subchefe.vida <= 0) {
				System.out.println("Você venceu a batalha!");
				player.levelUp();
				player.toString();
			}
			System.out.println();
		}
	}

	public void batalharChefe() {
		if (player.vida > 0) {
			System.out.println("Começando a batalha contra: " + chefe.nome);
			System.out.println();
		}

		while (player.vida > 0 && chefe.vida > 0) {

			int dadoJogador = (int) (Math.random() * 6) + 1;
			int dadoInimigo = (int) (Math.random() * 6) + 1;
			int dadoAtaqueInimigo = (int) (Math.random() * 3) + 1;

			System.out.println("----------------------------------");
			System.out.println("Você: \n" + player.toString());
			System.out.println();
			System.out.println("Adversário: \n" + chefe.toString());
			System.out.println();

			System.out.println("----------------------------------");
			System.out.println("O que deseja fazer?" + "\nDigite: " + "\n(1) - Ataque Mágico (-25 mana)"
					+ "\n(2) - Ataque com cajado (-10 estamina)" + "\n(3) - Defender (-15 estamina)" + "\n(4) - Qunt: "
					+ player.getQuantidade() + " Curar");
			System.out.println("----------------------------------");

			int opcaoAtaque = ler.nextInt();
			if (opcaoAtaque == 1) {
				System.out.println("Rolando o dado: " + dadoJogador);
				player.ataqueMagico(dadoJogador);
				chefe.vida -= player.dano;
			} else if (opcaoAtaque == 2) {
				System.out.println("Rolando o dado: " + dadoJogador);
				player.ataque(dadoJogador);
				chefe.vida -= player.dano;
			} else if (opcaoAtaque == 4) {
				if (player.getQuantidade() == 1) {
					player.cura();
				} else {
					System.out.println("Você não tem porção de cura!");
				}
			} else {
				player.defesa(dadoJogador);
				System.out.println("Você escolheu defender! Aguarde a jogado do adversário.");
			}

			if (chefe.vida > 0) {
				System.out.println();
				System.out.println("Rodada do adversário. Aguarde...");
				if (dadoAtaqueInimigo == 1) {
					player.vida -= chefe.dano;
					System.out.println(chefe.nome + " usou ataque normal");
					System.out.println("Rolando o dado: " + dadoInimigo);
					chefe.ataque(dadoInimigo);
					if (opcaoAtaque != 3) {
						player.vida -= chefe.dano;
					}
					if (opcaoAtaque == 3) {
						if (dadoJogador > 3) {
							System.out.println("Ataque defendido");
						} else if (dadoJogador > 1) {
							System.out.println("Dano reduzido pela metade");
							player.vida -= chefe.dano * 0.5;
						} else {
							System.out.println("Defesa do jogador falhou!");
							player.vida -= chefe.dano;
						}
					}
				} else if (dadoAtaqueInimigo == 2) {
					System.out.println(chefe.nome + " usou ataque especial");
					System.out.println("Rolando o dado: " + dadoInimigo);
					chefe.ataqueEspecial(dadoInimigo);
					if (opcaoAtaque != 3) {
						player.vida -= chefe.ataqueEspecial;
					}
					if (opcaoAtaque == 3) {
						if (dadoJogador > 3) {
							System.out.println("Ataque defendido");
						} else if (dadoJogador > 1) {
							System.out.println("Dano reduzido pela metade");
							player.vida -= chefe.ataqueEspecial * 0.5;
						} else {
							System.out.println("Defesa do jogador falhou!");
							player.vida -= chefe.ataqueEspecial;
						}
					}
				} else {
					System.out.println(chefe.nome + " usou SUPER ATAQUE");
					System.out.println("Rolando o dado: " + dadoInimigo);
					chefe.superAtaque(dadoInimigo);
					if (opcaoAtaque != 3) {
						player.vida -= chefe.superAtaque;
					}
					if (opcaoAtaque == 3) {
						if (dadoJogador > 3) {
							System.out.println("Ataque defendido");
						} else if (dadoJogador > 1) {
							System.out.println("Dano reduzido pela metade");
							player.vida -= chefe.superAtaque * 0.5;
						} else {
							System.out.println("Defesa do jogador falhou!");
							player.vida -= chefe.superAtaque;
						}
					}
				}
			}
			System.out.println();
			if (chefe.vida <= 0) {
				System.out.println("Você venceu a batalha!");
				player.levelUp();
				player.toString();
			}
			System.out.println();
		}
	}
}
