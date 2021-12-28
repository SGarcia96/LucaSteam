package dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Juego;
import utils.PedirDatos;

public class DAOJuegoImpl implements IDAOJuego {

	private static Logger logger;
	
	private List<Juego> listaJuegos = new ArrayList<>();
	
	static {
		try {
			logger = LogManager.getLogger(DAOJuegoImpl.class);
		} catch (Throwable e) {
			System.out.println("Logger no funciona correctamente");
		}
	}
	
	@Override
	public void darDeAlta() {
		Juego juego = new Juego();
		PedirDatos.pideDatosJuego(juego);
		darDeAlta(juego);
	}

	@Override
	public void darDeAlta(Juego juego) {
		listaJuegos.add(juego);
		System.out.println("se ha agregado el juego:" + juego);
	}

	@Override
	public void listarJuegos() {
		logger.info("Inicio del metodo listar juegos en la capa de datos");
		if (listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			logger.debug("Mostrando la lista de juegos");
			for (Juego juego : listaJuegos) {
				System.out.println(juego);
			}
		}

	}

}
