package services;

import model.Juego;
import model.Genero;

public interface IJuegoService {

	public void listarJuegos();

	// new
	public void listarJuegosPorGenero();

	public void listarJuegosPorGenero(Genero genero);

	public void darDeAlta();

	public void darDeAlta(Juego juego);

}
