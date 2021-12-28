package dao;

import model.Genero;
import model.Juego;

public interface IDAOJuego {
	
	public void darDeAlta();
	public void darDeAlta(Juego juego);
	public void listarJuegos();

	public void listarJuegosPorGenero();
	public void listarJuegosPorGenero(Genero genero);

	public void cargarJuegos();

}
