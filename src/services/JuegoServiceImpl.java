package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DAOJuegoImpl;
import dao.IDAOJuego;
import model.Juego;
import model.Genero;

public class JuegoServiceImpl implements IJuegoService {

	private IDAOJuego daoJuego = new DAOJuegoImpl();

	private static Logger logger;

	static {
		try {
			logger = LogManager.getLogger(DAOJuegoImpl.class);
		} catch (Throwable e) {
			System.out.println("Logger no funciona correctamente");
		}
	}

	@Override
	public void listarJuegos() {
		logger.info("Inicio del metodo listar juegos en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos de la capa de datos");
		daoJuego.listarJuegos();
	}

	// new

	@Override
	public void listarJuegosPorGenero() {
		logger.info("Inicio del metodo listar juegos por genero en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos por genero de la capa de datos");
		// daoJuego.listarJuegosPorGenero();
	}

	@Override
	public void listarJuegosPorGenero(Genero genero) {
		logger.info("Inicio del metodo listar juegos por genero en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos por genero de la capa de datos");
		// daoJuego.listarJuegosPorGenero(genero);
	}

	@Override
	public void darDeAlta() {
		logger.info("Inicio del metodo dar de alta en la capa de servicios");
		logger.debug("Llamando al metodo dar de alta de la capa de datos");
		daoJuego.darDeAlta();
	}

	@Override
	public void darDeAlta(Juego juego) {
		logger.info("Inicio del metodo dar de alta en la capa de servicios");
		logger.debug("Llamando al metodo dar de alta de la capa de datos");
		daoJuego.darDeAlta(juego);
	}


	@Override
	public void cargarJuegos() {
		logger.info("Inicio del metodo cargar juego en la capa de servicios");
		logger.debug("Llamando al metodo cargar juego de la capa de datos");
		daoJuego.cargarJuegos();
	}

}
