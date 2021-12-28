package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Genero;
import model.Juego;
import model.Plataforma;
import utils.PedirDatos;

public class DAOJuegoImpl implements IDAOJuego {

	private static Logger logger;

	private List<Juego> listaJuegos = new ArrayList<>();

	static {
		try {
			logger = LogManager.getLogger(DAOJuegoImpl.class);
		} catch (Throwable e) {
			System.out.println("Logger no funciona correctamente");
		}
	}

	@Override
	public void darDeAlta() {
		Juego juego = new Juego();
		PedirDatos.pideDatosJuego(juego);
		darDeAlta(juego);
	}

	@Override
	public void darDeAlta(Juego juego) {
		listaJuegos.add(juego);
		System.out.println("se ha agregado el juego: " + juego);
	}

	@Override
	public void listarJuegos() {
		logger.info("Inicio del metodo listar juegos en la capa de datos");
		if (listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			logger.debug("Mostrando la lista de juegos");
			for (Juego juego : listaJuegos) {
				System.out.println(juego);
			}
		}
	}
	
	public void cargarJuegos() {
		String linea;
		String[] juegoArray = new String[5];
		Juego juego = new Juego();
		int cont = 0;
		try(FileReader fileReader = new FileReader("vgsales.csv");
				BufferedReader bufferedReader = new BufferedReader(fileReader)){
			while((linea = bufferedReader.readLine()) != null) {
				if(cont > 0) {
					juegoArray = linea.split(",");
<<<<<<< HEAD
=======
//					System.out.println(linea);
//					System.out.println(Arrays.toString(juegoArray));
>>>>>>> nombresPlataformas
					juego.setNombre(juegoArray[0]);
					juego.setPlataforma(Plataforma.dimePlataforma(juegoArray[1]));
					try {
						juego.setFecha(Integer.parseInt(juegoArray[2]));
					} catch(NumberFormatException e) {
						System.out.println("No se ha insertado un numero");
					}
					juego.setGenero(Genero.dimeGenero(juegoArray[3]));
					juego.setEditor(juegoArray[4]);
					this.darDeAlta(juego);
<<<<<<< HEAD
=======
//					System.out.println(juego);
//					System.out.println("===========================================");
>>>>>>> nombresPlataformas
				}
				cont++;
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
