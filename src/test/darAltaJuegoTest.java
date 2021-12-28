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

public class darAltaJuegoTest {

	private static Logger logger;
	private Juego juego;
	private DAOJuegoImpl daoJuego;

	static {
		try {
			logger = LogManager.getLogger(darAltaJuegoTest.class);
		} catch (Throwable e) {
			System.out.println("Don't work");
		}
	}

	@BeforeEach
	public void inicioTest() {
		logger.info(">>>>> Inicio test");
		juego = new Juego();
		daoJuego = new DAOJuegoImpl();
		// List listjuegos...
	}

	@AfterEach
	public void finTest() {
		logger.info(">>>>> Fin test");
	}

	/*** TEST ***/
	@Test
	public void juegoSeCreaCorrectamente() {
		// Given
		juego.setNombre("mario");
		// When
		daoJuego.darDeAlta(juego);
		ArrayList<Juego> juegos = (ArrayList<Juego>) daoJuego.getListaJuegos();
		// Then
		assertThat(juegos).anyMatch(e -> e.getNombre().equals("mario"));
	}
	
	@Test
	public void juegoNotDuplicated() {
		/*
		// Given
		Juego juegoRepe = new Juego();
		juegoRepe.setNombre("mario");
		juegoRepe.setPlataforma(Plataforma.ARCADE);
		// When
		juego.setNombre("nombre");
		juego.setPlataforma(Plataforma.ARCADE);
		// Then
		//assertThat...
		 * 
		 */
	}

	@Test
	public void fechaDebeSerMenorA1951() {
		// Given

		// When
		
		// Then
		
	}
}
