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

	public void listarJuegosPorGenero();
	public List<Juego> listarJuegosPorGenero(Genero genero);
	
	public void listarJuegosNintendo();
	public List<Juego> listarJuegosNintendo(String fabricante);
	
	public void cargarJuegos();

	public void listarJuegosSigloXX();

	
	public Set<String> listarEditores();
	public Set<Genero> listarGeneros();


}
