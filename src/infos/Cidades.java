package infos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import application.Main;

public class Cidades {

	public static Integer CidadeP;
	public static Integer CidadeM;
	public static Integer CidadeF;
	public static Integer Resp;
	public static Integer Resp2;
	public static Integer Resp3;
	public static List<Integer> LCidades = new ArrayList<Integer>(
			Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23));
	public static String Cidades = "             Sitema de transporte interestadual \n Aracaju[0]         | Belém[1]          | Belo_Horizonte[2] \n Brasília[3]        | Campo Grande[4]   | Cuiabá[5] \n Curitiba[6]        | Florianópulis[7]  | Fortaleza[8] \n Goiânia[9]         | João_Pessoa[10]   | Maceió[11] \n Manaus[12]         | Natal[13]         | Porto_alegre[14] \n Porto_Velho[15]    | Recife[16]        | Rio_Branco[17] \n Rio_de_Janeiro[18] | Salvador[19]      | São_Luis[20] \n São_Paulo[21]      | Teresina[22]      | Vitória[23] \n ";
	static String Conf = "\nDeseja confirmar a cidade inserida? Sim[0] ou Não[1] ";
	static String Conf2 = "\nÉ um transporte direto para a cidade final? Sim[0] ou Não[1]  ";
	public static Scanner in = new Scanner(System.in);

	// Varivavel da cidade de Partida
	public static void scCidadeP() {
		CidadeP = in.nextInt();
	}

	// Varivavel da cidade dp Meio
	public static void scCidadeM() {
		CidadeM = in.nextInt();
	}

	public static void scCidadeF() {
		CidadeF = in.nextInt();
	}

	public static void scResp() {
		Resp = in.nextInt();
	}

	public static void scResp2() {
		Resp2 = in.nextInt();
	}

	public static void scResp3() {
		Resp3 = in.nextInt();
	}

	public static void escolhaDeCidadePartida() {
		System.out.print(Cidades);
		System.out.print("Esolha a cidade de partida:");
		scCidadeP();
		if (LCidades.contains(CidadeP) != true) {
			while (LCidades.contains(CidadeP) == false) {
				System.out.println("Cidade não encontrada insira uma cidade que está na lista");
				System.out.print(Cidades);
				System.out.print("Esolha a cidade de partida:");
				scCidadeP();
			}
		}
	}

	// mudar esse nome
	public static void ConfDoTransp() {
		System.out.println(Cidades);
		System.out.print("Esolha um ponto de parada:");
		scCidadeM();
		if (LCidades.contains(CidadeM) != true) {
			while (LCidades.contains(CidadeM) == false) {
				System.out.println("Cidade não encontrada insira uma cidade que está na lista");
				System.out.print(Cidades);
				System.out.print("Esolha a cidade de parada:");
				scCidadeM();
			}
		}
		if (Menu.respostaMenu == 1) {
			Integer distancia = Integer.valueOf(Main.MatrizCidades[CidadeM + 1][CidadeP]);
			Carga.descarregarPordutos();
		}

	}

	public static void escolhaDeCidadeFinal() {
		System.out.print(Cidades);
		System.out.print("Esolha a cidade de Destino:");
		scCidadeF();
		if (LCidades.contains(CidadeF) != true) {
			while (LCidades.contains(CidadeF) == false) {
				System.out.println("Cidade não encontrada insira uma cidade que está na lista");
				System.out.print(Cidades);
				System.out.print("Esolha a cidade de Destino:");
				scCidadeF();
			}
		}
		// Integer distancia = Integer.valueOf(Main.MatrizCidades[CidadeF +
		// 1][CidadeM]);
		// System.out.println(distancia);
	}

	public static void cadastroTransporte() {
		escolhaDeCidadePartida();
		ConfDoTransp();
		// dados estatisticos
	}
}
