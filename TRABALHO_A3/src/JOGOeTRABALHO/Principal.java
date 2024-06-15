package JOGOeTRABALHO;

import java.util.Scanner;

public class Principal {

	public static void main(String args[]) {

		Scanner ler = new Scanner(System.in);

		int n = 1;
		int escolha = 0;

		String[] nomes = { "Iza - A desproteinada", "Victor - O golpista", "Arthur - O homem bomba",
				"Gabriel - O comedor de planetas" };

		Inimigo[] inimigos = new Inimigo[] { new Inimigo(nomes[0], 100, 24), new Inimigo(nomes[1], 150, 60) };
		SubChefe subchefe = new SubChefe(nomes[2], 200, 120);
		Chefe chefe = new Chefe(nomes[3], 250, 200);

		System.out.println("");
		System.out.println("Digite:");
		System.out.println("--------------------------");
		System.out.println("|(1) -   NEW GAME        |");
		System.out.println("--------------------------");
		System.out.println("|(2) -     EXIT          |");
		System.out.println("--------------------------");

		int opcao = ler.nextInt();
		ler.nextLine();

		if (opcao == 2) {
			System.exit(0);
		}

		System.out.print("Escolha o nome do seu Mago: ");
		String nome = ler.nextLine();

		Jogador player = new Jogador(nome, 60, 1, 60, 40);

		System.out.println("---------------------------");
		System.out.println("|    MEGATRON THE GAME    |");
		System.out.println("---------------------------");

		System.out.println("Bem-vindo à torre dos cincos grandes chefes!");
		System.out.println();

		Batalha primeiraBatalha = new Batalha(player, inimigos[0], ler);
		Batalha segundaBatalha = new Batalha(player, inimigos[1], ler);
		Batalha terceiraBatalha = new Batalha(player, subchefe, ler);
		Batalha quartaBatalha = new Batalha(player, chefe, ler);

		for (int i = 0; i < n; i++) {
			
			if(player.vida <= 0) {
				inimigos[0].vida = 100;
				inimigos[1].vida = 150;
				subchefe.vida = 200;
				chefe.vida = 250;
				player.vida = 60;
				player.setMana(60);
				player.setEstamina(40);
				player.nivel = 1;
				player.setQuantidade(1);
			}
			
			primeiraBatalha.batalharInimigo();
			segundaBatalha.batalharInimigo();
			terceiraBatalha.batalharSubChefe();
			quartaBatalha.batalharChefe();

			if (player.vida < 0) {
				System.out.println("Deseja reniciar? 1/sim - 2/Não");
				escolha = ler.nextInt();

				switch (escolha) {
				case 1:
					n++;
					break;
				case 2:
					System.out.println("Fim de jogo!");
					System.exit(0);
				}
			}
		}
		if (player.vida > 0) {
			System.out.println("Parabéns! Você derrotou todos os chefes!");
			System.out.println("Créditos: \n" + "Arthur Beraldo R. Diniz\n" + "Izabella Silva Moraes\n"
					+ "Victor Raphael\n" + "Gabriel César Duarte");
			System.out.println();
			System.out.println("Obrigado por jogar!");

			ler.close();

		}
	}
}
