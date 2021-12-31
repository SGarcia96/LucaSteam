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

public class listarEditoresTest {

	private static Logger logger;
	private Juego juego;
	private DAOJuegoImpl daoJuego;

	static {
		try {
			logger = LogManager.getLogger(listarEditoresTest.class);
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
	public void listaCorrectamenteEditoresDistintos() {
		// Given
		juego = new Juego("Spirits & Spells", 2003, "Wanadoo", Genero.PLATFORM, Plataforma.GAMEBOY_ADVANCE);
		Juego juego2 = new Juego("Teslagrad", 2015, "Rain Games", Genero.PLATFORM, Plataforma.PS_VITA);
		Juego juego3 = new Juego("End of Nations", 2012, "Trion Worlds", Genero.STRATEGY, Plataforma.PC);
		// When
		daoJuego.darDeAlta(juego);
		daoJuego.darDeAlta(juego2);
		daoJuego.darDeAlta(juego3);
		Set<String> editores = daoJuego.listarEditores();
		// Then
		assertThat(editores).hasSize(3).containsExactlyInAnyOrder("Wanadoo", "Rain Games", "Trion Worlds");
	}

	@Test
	public void listaVacia() {
		// When
		Set<String> editores = daoJuego.listarEditores();
		// Then
		assertThat(editores).isEmpty();
	}

	@Test
	public void listaCorrectamenteEditoresIguales() {
		// Given
		juego = new Juego("Usavichi: Game no Jikan", 2011, "Namco Bandai Games", Genero.ACTION, Plataforma.NINTENDO_DS);
		Juego juego2 = new Juego("Battle Spirits: Hero's Soul", 2010, "Namco Bandai Games", Genero.ROLEPLAYING,
				Plataforma.PSP);
		Juego juego3 = new Juego("Portable Island: Tenohira Resort", 2006, "Namco Bandai Games", Genero.SIMULATION,
				Plataforma.PSP);
		// When
		daoJuego.darDeAlta(juego);
		daoJuego.darDeAlta(juego2);
		daoJuego.darDeAlta(juego3);
		Set<String> editores = daoJuego.listarEditores();
		// Then
		assertThat(editores).hasSize(1).containsExactly("Namco Bandai Games");
	}
}
