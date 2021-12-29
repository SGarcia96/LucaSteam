package dao;

import java.util.List;
import java.util.Set;

import model.Genero;
import model.Juego;

public interface IDAOJuego {
	
	public void darDeAlta();
	public void darDeAlta(Juego juego);
	public int listarJuegos();

	public void listarJuegosPorGenero();
	public List<Juego> listarJuegosPorGenero(Genero genero);

	public void cargarJuegos();
	
	public Set<String> listarEditores();

}
