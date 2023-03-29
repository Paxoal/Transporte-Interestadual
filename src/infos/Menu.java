package infos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import application.Main;

public class Menu {

	public static List<Integer> opcoesMenu = new ArrayList<Integer>(Arrays.asList(0, 1, 2));

	public static Integer respostaMenu;
	public static Integer respostaCaminhao;
	public static Scanner in = new Scanner(System.in);

	public static void respostaMenu() {
		respostaMenu = in.nextInt();
	}

	public static void respostaCaminhao() {
		respostaCaminhao = in.nextInt();
	}

	public static void menuDeFunc() throws IOException {
		System.out.println(" Consultar trechos x modalidade [0]:");
		System.out.println(" Cadastror de transportes [1]:");
		System.out.println(" Finalizar o programa [2]: ");
		System.out.print("Opção escolhida: ");
		respostaMenu();
		if (opcoesMenu.contains(respostaMenu) == false) {
			System.out.println("Valor invalido, insira um valor valido");
			menuDeFunc();
		} else {
			if (respostaMenu == 0) {
				ConTrecho();
			} else if (respostaMenu == 1) {
				Carga.novoProduto();
			} else if (respostaMenu == 2) {
				Sair.saidDoPrograma();
			}
		}
	}

	public static void escolhaDeCaminhao() {
		System.out.println(
				"Qual caminhão você deseja: \n Caminhão de pequeno porte[0]  | Caminhão de médio porte[1]  | Caminhão de grande porte[2]");
		System.out.print("Opção de caminhão escolida: ");
		respostaCaminhao();
		Integer distancia = Integer.valueOf(Main.MatrizCidades[Cidades.CidadeF + 1][Cidades.CidadeP]);
		if (Caminhao.verficacao() == false) {
			System.out.println("Valor invalido, insira um valor valido");
			escolhaDeCaminhao();
		} else if (respostaCaminhao == 0) {
			Double ValCppPorKm = distancia * 4.87;
			System.out.println("A distância entre a cidade de partida até a cidade de destiano é " + distancia
					+ "km com o caminhão de pequeno porte com o valor de R$ " + ValCppPorKm);
		} else if (respostaCaminhao == 1) {
			Double ValCmpPorKm = distancia * 11.92;
			System.out.println("A distância entre a cidade de partida até a cidade de destiano é " + distancia
					+ "km com o caminhão de médio porte com o valor de R$ " + ValCmpPorKm);
		} else if (respostaCaminhao == 2) {
			Double ValCgpPorKm = distancia * 27.44;
			System.out.println("A distância entre a cidade de partida até a cidade de destiano é " + distancia
					+ "km com o caminhão de grande porte com o valor de R$ 1" + ValCgpPorKm);
		} else {
			System.out.print("Valor invalido insira um valor valido: ");
			escolhaDeCaminhao();
		}
	}

	public static void ConTrecho() {
		System.out.println("Consultar trechos x modalidade");
		Cidades.escolhaDeCidadePartida();
		Cidades.escolhaDeCidadeFinal();
		escolhaDeCaminhao();

	}

}
