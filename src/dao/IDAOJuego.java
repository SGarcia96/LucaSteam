package dao;

import java.util.List;
import java.util.Set;

import model.Genero;
import model.Juego;
import model.Plataforma;

public interface IDAOJuego {
	
	public void darDeAlta();
	public void darDeAlta(Juego juego);
	
	public int listarJuegos();
	
	public void eliminarJuego();
	public void eliminarJuego(Juego juego);
	
	public void editarJuego();
	

	public void cargarJuegos();
	
	public void listarJuegosPorGenero();
	public List<Juego> listarJuegosPorGenero(Genero genero);
	
	public void listarJuegosPorPlataforma();
	public List<Juego> listarJuegosPorPlataforma(Plataforma plataforma);
	
	public void listarJuegosNintendo();
	public List<Juego> listarJuegosNintendo(String fabricante);
	

	public List<Juego> listarJuegosSigloXX();
	public List<Juego> listarJuegosPorAnyoPar();
	
	public Set<String> listarEditores();
	public Set<Genero> listarGeneros();
}
