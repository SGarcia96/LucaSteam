package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.DAOJuegoImpl;
import model.Genero;
import model.Juego;
import model.Plataforma;

public class listarJuegosNintendoTest {
	
	private static Logger logger;
	private DAOJuegoImpl daoJuego;

	static {
		try {
			logger = LogManager.getLogger(listarJuegosNintendoTest.class);
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
	public void listaSoloJuegosDeFabricanteNintendo() {
		// Given
		Juego juego = new Juego("Spirits & Spells", 2003, "Wanadoo", Genero.PLATFORM, Plataforma.GAMEBOY_ADVANCE);
		Juego juego2 = new Juego("Teslagrad",2015, "Rain Games", Genero.PLATFORM, Plataforma.GAMECUBE);
		Juego juego3 = new Juego("End of Nations", 2012, "Trion Worlds", Genero.STRATEGY, Plataforma.PC);
		Juego juego4 = new Juego("Mighty No. 9", 2016, "Deep Silver", Genero.PLATFORM, Plataforma.XBOX_ONE);
		// When
		daoJuego.darDeAlta(juego);
		daoJuego.darDeAlta(juego2);
		daoJuego.darDeAlta(juego3);
		daoJuego.darDeAlta(juego4);
		List<Juego> juegos = daoJuego.listarJuegosNintendo("nintendo");
		// Then
		assertThat(juegos).
					hasSize(2).
					extracting(Juego::getNombre).
					containsExactlyInAnyOrder("Spirits & Spells","Teslagrad");
	}
	
	@Test
	public void listaVacia() {
		// When
		List<Juego> juegos = daoJuego.listarJuegosPorGenero(Genero.ADVENTURE);
		// Then
		assertThat(juegos).hasSize(0);
	}
}
