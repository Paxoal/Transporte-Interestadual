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
	public static Integer respostaCadCidade;
	public static Integer respostaLargarCarga;
	public static String respostaRemoverProduto;
	public static Integer respostaRemoverQuantProduto;

	public static Double peso = 0.0;
	public static Double tonelada;

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

	private static void scannerCadCidade() {
		respostaCadCidade = in.nextInt();
	}

	private static void scannerLargarCarga() {
		respostaLargarCarga = in.nextInt();
	}

	private static void scannerRemoverProduto() {
		respostaRemoverProduto = in.next();
	}

	private static void scannerRemoverQuantProduto() {
		respostaRemoverQuantProduto = in.nextInt();
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
			System.out.println("Resumo de dados do cadastror do produto: \n Nome: " + nomeProduto + "\n Peso: "
					+ pesoProduto + "kg \n Unidades: " + quantProduto);
			System.out.println("Após o cadastro do produto os dados não podem ser alterados");
			System.out.print("Deseja confirmar o cadastro desse produto? Sim [0] ou Não[1]: ");
			scannerRespConfCadastro();
			if (respostaConfirmacaoDeCadastro == 0 || respostaConfirmacaoDeCadastro == 1) {
				if (respostaConfirmacaoDeCadastro == 0) {
					PesoProdutos.add(pesoProduto);
					NomeProdutos.add(nomeProduto);
					QuantProdutos.add(quantProduto);
					peso += pesoProduto * quantProduto;
					System.out.print(" Deseja carregar mais produtos? Sim [0] ou Não[1]: ");
					scannerCadProduto();
					if (respostaCadastro == 0 || respostaCadastro == 1) {
						if (respostaCadastro == 0) {
							novoProduto();
						}
					} else {
						System.out.println("Insira um valor valido: ");
						System.out.print(" Deseja carregar mais produtos? Sim [0] ou Não[1]: ");
						scannerCadProduto();
					}
				} else {
					System.out.println("Os dados anterios não foram salvos");
					novoProduto();

				}
			} else {
				System.out.println("Insira um valor valido: ");
				System.out.print("Deseja confirmar o cadastro desse produto? Sim [0] ou Não[1]: ");
				scannerRespConfCadastro();
			}
			System.out.print("Digite [0] para ser direcionado à escolha de cidades digite: ");
			scannerCadCidade();
			if (respostaCadCidade == 0) {
				Cidades.cadastroTransporte();
			} else {
				System.out.println("Valor invalido, insira um valor valido");
				System.out.print("Deseja seguir para o a escolha de cidades? Sim[0] ou Não[1]: ");
				scannerCadCidade();
				while (respostaCadCidade == 0) {
					Cidades.cadastroTransporte();
				}
			}

		}
	}

	public static void descarregarPordutos() {
		System.out.print("Deseja descarregar algum produto na cidade de parada? Sim[0] ou Não[1]: ");
		scannerLargarCarga();
		if (respostaLargarCarga == 0 || respostaLargarCarga == 1) {
			if (respostaLargarCarga == 0) {
				// renomear essas vars
				int Nome = NomeProdutos.size();
				int i = 0;
				while (i != Nome) {
					System.out.println("Nome do produto: " + NomeProdutos.get(i) + "| Quantidade do produto: "
							+ QuantProdutos.get(i));
					i += 1;
				}
				System.out.print("Qual produto você deseja descarregar: ");
				scannerRemoverProduto();
				Integer x = NomeProdutos.indexOf(respostaRemoverProduto);
				if (NomeProdutos.contains(respostaRemoverProduto) == true) {
					System.out.print("Qual a quantidade de produto que você deseja descarregar na cidade: ");
					scannerRemoverQuantProduto();
					int quantidade = QuantProdutos.get(x);
					if (respostaRemoverQuantProduto < quantidade){
						int novaquantidade = quantidade - respostaRemoverQuantProduto;
						peso -= quantidade - PesoProdutos.get(x);
						QuantProdutos.set(x,novaquantidade);
						peso = novaquantidade * PesoProdutos.get(x);
					} else {
						System.out.println("Quantidade excede o que existe no estoque, favor insira um valor valido: ");
						descarregarPordutos();
					}
				}
				descarregarPordutos();
			}
			else {
				Cidades.escolhaDeCidadeFinal();
			}
		}
		
	}

	public static Double calculoTonelada() {
		tonelada = Math.ceil(peso / 1000);
		return tonelada;
	}

}
