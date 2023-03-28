package infos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Carga {
	//lista para o cadastro de produtos
	public static List<String> NomeProdutos = new ArrayList<String>(Arrays.asList());
	public static List<Double> PesoProdutos = new ArrayList<Double>(Arrays.asList());
	public static List<Integer> QuantProdutos = new ArrayList<Integer>(Arrays.asList());
	
	//Variaveis para utilizar no scanner
	public static String nomeProduto;
	public static Double pesoProduto;
	public static Integer quantProdutos;
	public static Integer cadProdutos;
	
	

	//Scanners para o cadastro de produtos
	public static Scanner in = new Scanner(System.in);
	
	public static void scNomeProduto() {
		nomeProduto = in.next();
	}
	public static void scPesoProduto() {
		pesoProduto = in.nextDouble();
	}
	public static void scQuantProduto() {
		quantProdutos = in.nextInt();
	}
	public static void scCadProdutos() {
		cadProdutos = in.nextInt();
	}
	
	
	public static void addList() {
		System.out.print("Qual o nome do produto: ");
		scNomeProduto();
		NomeProdutos.add(nomeProduto);
		System.out.println();
		System.out.print("Qual o peso da unidade do produto(Exemplo 1,5): ");
		scPesoProduto();
		PesoProdutos.add(pesoProduto);
		System.out.println();
		System.out.print("Qual a quantidade de produto que deseja levar: ");
		scQuantProduto();
		QuantProdutos.add(quantProdutos);
		System.out.println();
		System.out.print(" Deseja carregar mais produtos? Sim [0] ou Não[1]: ");
		scCadProdutos();
		if (cadProdutos == 0 || cadProdutos == 1) {
			if (cadProdutos == 0) {
				addList();
			}
		} else {
			System.out.println("Insira um valor valido: ");
			scCadProdutos();
		} 
		
		// fazer um for para printar com celular
		System.out.println();
		System.out.println(NomeProdutos);
		System.out.println(PesoProdutos);
		System.out.println(QuantProdutos);
	}
}
