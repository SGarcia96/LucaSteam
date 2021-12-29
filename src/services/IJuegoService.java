package services;

import model.Juego;
import model.Plataforma;
import model.Genero;

public interface IJuegoService {

	public void listarJuegos();
	
	public void listarJuegosPorGenero();
	public void listarJuegosPorGenero(Genero genero);
	
	public void listarJuegosPorPlataforma();
	public void listarJuegosPorPlataforma(Plataforma plataforma);
	
	public void listarJuegosNintendo();

	public void darDeAlta();
	public void darDeAlta(Juego juego);
	
	public void eliminarJuego();
	
	public void editarJuego();

	public void cargarJuegos();
	
	public void listarJuegosSigloXX();
	public void listarJuegosPorAnyoPar();

	public void listarEditores();
	public void listarGeneros();
	
}
