package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DAOJuegoImpl;
import dao.IDAOJuego;
import model.Juego;
import model.Plataforma;
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

	@Override
	public void listarJuegosPorGenero() {
		logger.info("Inicio del metodo listar juegos por genero en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos por genero de la capa de datos");
		daoJuego.listarJuegosPorGenero();
	}

	@Override
	public void listarJuegosPorGenero(Genero genero) {
		logger.info("Inicio del metodo listar juegos por genero en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos por genero de la capa de datos");
		daoJuego.listarJuegosPorGenero(genero);
	}

	@Override
	public void listarJuegosNintendo() {
		logger.info("Inicio del metodo listar juegos de Nintendo en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos nintendo de la capa de datos");
		daoJuego.listarJuegosNintendo();
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
	public void eliminarJuego() {
		logger.info("Inicio del metodo eliminar juego en la capa de servicios");
		logger.debug("Llamando al metodo eliminar juego de la capa de datos");
		daoJuego.eliminarJuego();
	}

	@Override
	public void editarJuego() {
		logger.info("Inicio del metodo editar juego en la capa de servicios");
		logger.debug("Llamando al metodo editar juego de la capa de datos");
		daoJuego.editarJuego();
	}

	@Override
	public void cargarJuegos() {
		logger.info("Inicio del metodo cargar juego en la capa de servicios");
		logger.debug("Llamando al metodo cargar juego de la capa de datos");
		daoJuego.cargarJuegos();
	}

	@Override
	public void listarJuegosSigloXX() {
		logger.info("Inicio del metodo listar juegos siglo XX en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos siglo XX de la capa de datos");
		daoJuego.listarJuegosSigloXX();
	}

	@Override
	public void listarEditores() {
		logger.info("Inicio del metodo listar editores en la capa de servicios");
		logger.debug("Llamando al metodo listar editores de la capa de datos");
		daoJuego.listarEditores();
	}

	@Override
	public void listarGeneros() {
		logger.info("Inicio del metodo listar editores en la capa de servicios");
		logger.debug("Llamando al metodo listar editores de la capa de datos");
		daoJuego.listarGeneros();
	}

	@Override
	public void listarJuegosPorAnyoPar() {
		logger.info("Inicio del metodo listar juegos anyo par en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos anyo par en la capa de datos");
		daoJuego.listarJuegosPorAnyoPar();
	}

	@Override
	public void listarJuegosPorPlataforma() {
		logger.info("Inicio del metodo listar juegos por plataforma en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos por plataforma en la capa de datos");
		daoJuego.listarJuegosPorPlataforma();
	}

	@Override
	public void listarJuegosPorPlataforma(Plataforma plataforma) {
		logger.info("Inicio del metodo listar juegos por plataforma en la capa de servicios");
		logger.debug("Llamando al metodo listar juegos por plataforma de la capa de datos");
		daoJuego.listarJuegosPorPlataforma(plataforma);
	}
}
