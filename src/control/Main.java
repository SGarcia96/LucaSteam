package control;


import dao.DAOJuegoImpl;
import services.JuegoServiceImpl;

public class Main {
	public static void main(String args[]) {
		new DAOJuegoImpl().cargarJuegos();
		new JuegoServiceImpl().listarJuegos();
		new GestionJuegos().inicio();
	

}
}