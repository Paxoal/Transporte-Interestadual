package infos;

import java.util.Scanner;

public class Exit {

	public static Integer repExit;

	public static void repExit() {
		try (Scanner in = new Scanner(System.in)) {
			repExit = in.nextInt();
		}
	}

	public static void exitProgram() {
		if (repExit == 0 || repExit == 1) {
			if (repExit == 0) {
				System.exit(0);

			}
		}
	}
}
