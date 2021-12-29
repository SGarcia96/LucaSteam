package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.DAOJuegoImpl;
import model.Genero;
import model.Juego;
import model.Plataforma;

public class listarGenerosTest {

	private static Logger logger;
	private Juego juego;
	private DAOJuegoImpl daoJuego;

	static {
		try {
			logger = LogManager.getLogger(listarGenerosTest.class);
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
	public void listaCorrectamenteGenerosDistintos() {
		// Given
		juego = new Juego("Spirits & Spells", 2003, "Wanadoo", Genero.ADVENTURE, Plataforma.GAMEBOY_ADVANCE);
		Juego juego2 = new Juego("Teslagrad", 2015, "Rain Games", Genero.PLATFORM, Plataforma.PS_VITA);
		Juego juego3 = new Juego("End of Nations", 2012, "Trion Worlds", Genero.STRATEGY, Plataforma.PC);
		// When
		daoJuego.darDeAlta(juego);
		daoJuego.darDeAlta(juego2);
		daoJuego.darDeAlta(juego3);
		Set<Genero> generos = daoJuego.listarGeneros();
		// Then
		assertThat(generos).hasSize(3).containsExactlyInAnyOrder(Genero.ADVENTURE, Genero.PLATFORM, Genero.STRATEGY);
	}

	@Test
	public void listaVacia() {
		// When
		Set<Genero> generos = daoJuego.listarGeneros();
		// Then
		assertThat(generos).isEmpty();
	}

	@Test
	public void listaCorrectamenteGenerosIguales() {
		// Given
		juego = new Juego("Spirits & Spells", 2003, "Wanadoo", Genero.ADVENTURE, Plataforma.GAMEBOY_ADVANCE);
		Juego juego2 = new Juego("Teslagrad", 2015, "Rain Games", Genero.ADVENTURE, Plataforma.PS_VITA);
		Juego juego3 = new Juego("End of Nations", 2012, "Trion Worlds", Genero.STRATEGY, Plataforma.PC);
		// When
		daoJuego.darDeAlta(juego);
		daoJuego.darDeAlta(juego2);
		daoJuego.darDeAlta(juego3);
		Set<Genero> generos = daoJuego.listarGeneros();
		// Then
		assertThat(generos).hasSize(2).containsExactlyInAnyOrder(Genero.ADVENTURE, Genero.STRATEGY);
	}
}
