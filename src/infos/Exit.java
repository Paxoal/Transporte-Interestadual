package infos;

import java.util.Scanner;

public class Exit {

	public static Integer repExit;

	public static void repExit() {
		Scanner in = new Scanner(System.in);
		repExit = in.nextInt();
	}
	// pensar melhor
	public static void exitProgram() {
		System.out.print(" Deseja finalizar o programa? Sim[0] ou Não[1]: ");
		repExit();
		if (repExit == 0 || repExit == 1) {
			if (repExit == 0) {
				System.exit(0);
			}
		}
	}
}
