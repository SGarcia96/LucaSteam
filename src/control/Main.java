package control;

<<<<<<< HEAD
import dao.DAOJuegoImpl;
import services.JuegoServiceImpl;

public class Main {
	public static void main(String args[]) {
		new DAOJuegoImpl().cargarJuegos();
		new JuegoServiceImpl().listarJuegos();
=======
public class Main {
	public static void main(String args[]) {
		new GestionJuegos().inicio();
>>>>>>> 3d1f22178056a65da6f3453cbdcccf1c06955214
	}
}
