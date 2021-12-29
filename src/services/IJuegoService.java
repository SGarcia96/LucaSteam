package services;

import model.Juego;

import java.util.Set;

import model.Genero;

public interface IJuegoService {

	public void listarJuegos();

	// new
	public void listarJuegosPorGenero();

	public void listarJuegosPorGenero(Genero genero);
	
	public void listarJuegosNintendo();

	public void darDeAlta();

	public void darDeAlta(Juego juego);

	public void cargarJuegos();

	public void listarEditores();
	
}
