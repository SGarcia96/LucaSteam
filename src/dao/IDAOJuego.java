package dao;

import java.util.List;

import model.Genero;
import model.Juego;

public interface IDAOJuego {
	
	public void darDeAlta();
	public void darDeAlta(Juego juego);
	public void listarJuegos();

	public void listarJuegosPorGenero();
	public List<Juego> listarJuegosPorGenero(Genero genero);

	public void cargarJuegos();

}
