package infos;

import java.util.Scanner;

public class Sair {

	public static Integer repExit;

	public static void repExit() {
		try (Scanner in = new Scanner(System.in)) {
			repExit = in.nextInt();
		}
	}

	public static void saidDoPrograma() {
		System.exit(0);

	}
}
