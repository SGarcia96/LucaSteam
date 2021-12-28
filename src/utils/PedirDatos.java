package utils;

import model.Editor;
import model.Genero;
import model.Juego;
import model.Plataforma;

public class PedirDatos {
	
	public static void pideDatosJuego(Juego juego) {
		juego.setNombre(EntradaTeclado.leeStringConMensaje("introduce nombre"));
		juego.setFecha(EntradaTeclado.leeIntConMensaje("introduce anyo"));
		Editor.InformeEditor();
		juego.setEditor(Editor.dimeEditor(EntradaTeclado.leeIntConMensaje("introduce editor")));
		Plataforma.InformePlataforma();
		juego.setPlataforma(Plataforma.dimePlataforma(EntradaTeclado.leeStringConMensaje("introduce plataforma")));
		Genero.InformeGenero();
		juego.setGenero(Genero.dimeGenero(EntradaTeclado.leeIntConMensaje("introduce genero")));
	}
}
