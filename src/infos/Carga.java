package infos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Carga {
	// lista para o cadastro de produtos
	public static List<String> NomeProdutos = new ArrayList<String>(Arrays.asList());
	public static List<Double> PesoProdutos = new ArrayList<Double>(Arrays.asList());
	public static List<Integer> QuantProdutos = new ArrayList<Integer>(Arrays.asList());

	// Variaveis para utilizar no scanner
	public static String nomeProduto;
	public static Double pesoProduto;
	public static Integer quantProduto;
	public static Integer respostaConfirmacaoDeCadastro;
	public static Integer respostaCadastro;

	// Scanners para o cadastro de produtos
	public static Scanner in = new Scanner(System.in);

	public static void scannerNomeProduto() {
		nomeProduto = in.next();
	}

	public static void scannerPesoProduto() {
		pesoProduto = in.nextDouble();
	}

	public static void scannerQuantProduto() {
		quantProduto = in.nextInt();
	}

	public static void scannerRespConfCadastro() {
		respostaConfirmacaoDeCadastro = in.nextInt();
	}

	private static void scannerCadProduto() {
		respostaCadastro = in.nextInt();
	}

	public static void novoProduto() {
		System.out.print("Qual o nome do produto: ");
		scannerNomeProduto();
		if (NomeProdutos.contains(nomeProduto) != false) {
			System.out.println("Produto já cadastrado na lista, cadastre outro produto com um nome diferente");
			novoProduto();
		} else {
			System.out.println();
			System.out.print("Qual o peso, em kg, da unidade do produto(Exemplo 1,5): ");
			scannerPesoProduto();
			System.out.println();
			System.out.print("Qual a quantidade de produto que deseja levar: ");
			scannerQuantProduto();
			System.out.println();
			System.out.println(
					"Resumo de dados do cadastror do produto: \n Nome: " + nomeProduto + "\n Peso: " + pesoProduto
							+ "kg \n Unidades: " + quantProduto);
			System.out.println("Após o cadastro do produto os dados não podem ser alterados");
			System.out.print("Deseja confirmar o cadastro desse produto? Sim [0] ou Não[1]: ");
			scannerRespConfCadastro();
			if (respostaConfirmacaoDeCadastro == 0 || respostaConfirmacaoDeCadastro == 1) {
				if (respostaConfirmacaoDeCadastro == 0) {
					PesoProdutos.add(pesoProduto);
					NomeProdutos.add(nomeProduto);
					QuantProdutos.add(quantProduto);
					System.out.print(" Deseja carregar mais produtos? Sim [0] ou Não[1]: ");
					scannerCadProduto();
					if (respostaCadastro == 0 || respostaCadastro == 1) {
						if (respostaCadastro == 0) {
							novoProduto();
						}
					} else {
						System.out.println("Insira um valor valido: ");
						scannerCadProduto();
					}
				}
			} else {
				System.out.println("Os dados anterios não foram salvos");
				novoProduto();
			}
		}

		// fazer um for para printar com celular
		System.out.println();
		System.out.println(NomeProdutos);
		System.out.println(PesoProdutos);
		System.out.println(QuantProdutos);
	}
}
