package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	public void fechaDebeSerInt() {
		// Given
		
		// When
		
		// Then
	}
	
}
