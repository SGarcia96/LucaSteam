package utils;

import model.Genero;
import model.Juego;
import model.Plataforma;

public class PedirDatos {
	
	public static void pideDatosJuego(Juego juego) {
		juego.setNombre(EntradaTeclado.leeStringConMensaje("introduce nombre"));
		juego.setFecha(EntradaTeclado.leeIntConMensaje("introduce anyo"));
		juego.setEditor(EntradaTeclado.leeStringConMensaje("introduce editor"));
		Plataforma.InformePlataforma();
		juego.setPlataforma(Plataforma.dimePlataforma(EntradaTeclado.leeStringConMensaje("introduce plataforma")));
		Genero.InformeGenero();
		juego.setGenero(Genero.dimeGenero(EntradaTeclado.leeIntConMensaje("introduce genero")));
	}
}
