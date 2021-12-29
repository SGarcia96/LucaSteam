package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class listarJuegosTest {
	
	private static Logger logger;
	
	static {
		try {
			logger = LogManager.getLogger(listarJuegosTest.class);
		} catch (Throwable e) {
			System.out.println("Don't work");
		}
	}
	
	@BeforeEach
	public static void inicioTest() {
		logger.info(">>>>> Inicio test");
	}
	
	@AfterEach
	public static void finTest() {
		logger.info(">>>>> Fin test");
	}
	
	
	/*** TEST ***/
	@Test
	public void comprobarNumeroDeLineas() {
		// Given
		
		// When
		try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
		
		} catch(IOException e) {
			
		}
		// Then
	}
	
}
