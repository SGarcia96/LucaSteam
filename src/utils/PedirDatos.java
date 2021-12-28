package utils;

import model.Juego;

public class PedirDatos {
	
	public static void pideDatosJuego(Juego juego) {
		juego.setNombre(EntradaTeclado.leeStringConMensaje("introduce nombre"));
		juego.setFecha(EntradaTeclado.leeIntConMensaje("introduce anyo"));
		// falta enums
	}
}
