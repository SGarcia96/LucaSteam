package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import model.Genero;
import model.Juego;
import model.Plataforma;

public class darAltaJuegoTest {
	
	private static Logger logger;
	private static Juego juego;
	
	static {
		try {
			logger = LogManager.getLogger(darAltaJuegoTest.class);
		} catch (Throwable e) {
			System.out.println("Don't work");
		}
	}
	
	@BeforeEach
	public static void inicioTest() {
		logger.info(">>>>> Inicio test");
		juego = new Juego();
	}
	
	@AfterEach
	public static void finTest() {
		logger.info(">>>>> Fin test");
	}
	
	
	/*** TEST ***/
	@Test
	public void fechaDebeSerMenorA1951() {
		// Given
		
		// When
		juego.setFecha(1500);
		// Then
		assertThat("fecha no valida");
	}

}
