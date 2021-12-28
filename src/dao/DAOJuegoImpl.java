package dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Juego;

public class DAOJuegoImpl implements IDAOJuego {
	
	private static Logger logger;

	List<Juego> listaJuegos = new ArrayList<>();
	
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
	}

	@Override
	public void darDeAlta(Juego juego) {
		listaJuegos.add(juego);
		System.out.println("se ha dado de alta el juego: " + juego);
	}

	@Override
	public void listarJuegos() {
		logger.info("Inicio del metodo listar juegos");
		if(listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			logger.debug("Mostrando la lista de juegos");
			for(Juego juego: listaJuegos) {
				System.out.println(juego);
			}
		}
		
	}

}
