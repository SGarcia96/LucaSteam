package dao;

import model.Juego;

public interface IDAOJuego {
	
	public void darDeAlta();
	public void darDeAlta(Juego juego);
	public void listarJuegos();
	public void cargarJuegos();
}
