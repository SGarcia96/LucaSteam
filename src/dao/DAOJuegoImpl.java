package dao;

import java.util.ArrayList;
import java.util.List;

import model.Juego;
import utils.PedirDatos;

public class DAOJuegoImpl implements IDAOJuego {

	private List<Juego> listaJuegos = new ArrayList<>();

	@Override
	public void darDeAlta() {
		Juego juego = new Juego();
		PedirDatos.pideDatosJuego(juego);
		darDeAlta(juego);
	}

	@Override
	public void darDeAlta(Juego juego) {
		listaJuegos.add(juego);
		System.out.println("se ha agregado el juego:" + juego);
	}
}
