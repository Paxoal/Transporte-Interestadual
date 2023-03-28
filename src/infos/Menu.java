package infos;

import java.util.Scanner;

import application.Main;

public class Menu {

	public static Integer respMenu;
	public static Integer respCaminhao;
	public static Scanner in = new Scanner(System.in);

	public static void RespMenu() {
		respMenu = in.nextInt();
	}

	public static void RespCaminhao() {
        respCaminhao = in.nextInt();
    }

	public static void MenuDeFunc() {
		System.out.println(" Consultar trechos x modalidade [0]:");
		System.out.println(" Cadastrar de transportes [1]:");
		System.out.println(" Finalizar o programa [2]: ");
		System.out.print(" Opção escolida: ");
		RespMenu();

		if (respMenu == 0) {
			ConTrecho();
		} else if (respMenu == 1) {
			Carga.novoProduto();
		} else if (respMenu == 2) {
			Exit.exitProgram();
			MenuDeFunc();
		}
	}

	public static void EscolhaDeCaminhao() {
        System.out.println("Qual caminhão você deseja: \n Caminhão de pequeno porte[0]  | Caminhão de médio porte[1]  | Caminhão de grande porte[2]");
        System.out.print("Opção de caminhão escolida: ");
        RespCaminhao();
    }

	public static void ConTrecho() {
		System.out.println("Consultar trechos x modalidade");
		Cidades.EscolhaDeCidadePartida();
		Cidades.EscolhaDeCidadeFinal();
		Integer dis = Integer.valueOf(Main.MatrizCidades[Cidades.CidadeF + 1][Cidades.CidadeP]);
		EscolhaDeCaminhao();
			if (respCaminhao != 0 || respCaminhao != 1 || respCaminhao != 2) {
				System.out.print("Valor invalido insira um valor valido: ");
				EscolhaDeCaminhao();
			} else if (respCaminhao == 0) {
				Double ValCppPorKm = dis * 4.87;
				System.out.println("A distância entre a cidade de partida até a cidade de destiano é " + dis
						+ "km com o caminhão de pequeno porte com o valor de R$ " + ValCppPorKm);
			} else if (respCaminhao == 1) {
				Double ValCmpPorKm = dis * 11.92;
				System.out.println("A distância entre a cidade de partida até a cidade de destiano é " + dis
						+ "km com o caminhão de médio porte com o valor de R$ " + ValCmpPorKm);
			} else if (respCaminhao == 2) {
				Double ValCgpPorKm = dis * 27.44;
				System.out.println("A distância entre a cidade de partida até a cidade de destiano é " + dis
						+ "km com o caminhão de grande porte com o valor de R$ 1" + ValCgpPorKm);
			}

	}

}
