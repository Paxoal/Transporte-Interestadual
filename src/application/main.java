package application;

import java.io.File;
import java.io.FileNotFoundException;

import infos.Menu;
import java.util.Scanner;

public class main {

	public static Double Km;
	public static String[][] MatrizCidades;
	public static void main(String[] args) throws FileNotFoundException{
		File arquivo = new File("C:\\Users\\arthu\\Downloads\\DNIT-Distancias.csv");
		try (Scanner scanner = new Scanner(arquivo)) {
			MatrizCidades = new String [25][];
			int i = 0;
			while (scanner.hasNext()) {
				String[] line = scanner.nextLine().split(";");
				MatrizCidades[i] = line;
				i++;
				
		
			}
		}
		Menu.MenuDeFunc();

		
		
	}
}