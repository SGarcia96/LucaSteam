package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DAOJuegoImpl;
import dao.IDAOJuego;

public class JuegoServiceImpl implements IJuegoService{
	
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

}
