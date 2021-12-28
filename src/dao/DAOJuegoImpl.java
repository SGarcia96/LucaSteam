package dao;

import java.util.ArrayList;
import java.util.List;

import model.Juego;

public class DAOJuegoImpl implements IDAOJuego {

	List<Juego> listaJuegos = new ArrayList<>();

	@Override
	public void darDeAlta() {
		Juego juego = new Juego();
	}

	@Override
	public void darDeAlta(Juego juego) {
		listaJuegos.add(juego);
		System.out.println("se ha dado de alta el juego: " + juego);
	}

}
