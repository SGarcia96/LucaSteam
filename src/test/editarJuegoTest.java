package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.DAOJuegoImpl;
import model.Genero;
import model.Juego;
import model.Plataforma;

public class editarJuegoTest {
	private static Logger logger;
	private DAOJuegoImpl daoJuego;

	static {
		try {
			logger = LogManager.getLogger(editarJuegoTest.class);
		} catch (Throwable e) {
			System.out.println("Don't work");
		}
	}

	@BeforeEach
	public void inicioTest() {
		logger.info(">>>>> Inicio test");
		daoJuego = new DAOJuegoImpl();
	}

	@AfterEach
	public void finTest() {
		logger.info(">>>>> Fin test");
	}

	/*** TEST ***/
	@Test
	public void juegoEditadoConExito() {
		// Given
		Juego juego = new Juego("Baba", 2003, "Wanadoo", Genero.PLATFORM, Plataforma.GAMEBOY_ADVANCE);
		// When
		daoJuego.darDeAlta(juego);
		daoJuego.editarJuego();
		ArrayList<Juego> juegos = (ArrayList<Juego>) daoJuego.getListaJuegos();
		// Then
		assertThat(juegos).anyMatch(x -> x.getNombre().equals("Baba"));
	}

	
}
