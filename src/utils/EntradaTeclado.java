package utils;

import java.util.Scanner;

public class EntradaTeclado {
	public static String leeString() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static String leeStringConMensaje(String mensaje) {
		System.out.println(mensaje);
		return leeString();
	}

	public static int leeInt() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static int leeIntConMensaje(String mensaje) {
		System.out.println(mensaje);
		return leeInt();
	}
}
