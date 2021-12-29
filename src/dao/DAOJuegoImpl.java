package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.ExcepcionDuplicado;

import lombok.Getter;
import lombok.Setter;

import model.Genero;
import model.Juego;
import model.Plataforma;
import utils.EntradaTeclado;
import utils.PedirDatos;

public class DAOJuegoImpl implements IDAOJuego {

	private static Logger logger;
	@Getter
	@Setter
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
		try {
			for (Juego game : listaJuegos) {
				if (game.getNombre().equals(juego.getNombre()) && game.getPlataforma().equals(juego.getPlataforma())) {
					throw new ExcepcionDuplicado();
				}
			}
			listaJuegos.add(juego);
			System.out.println("se ha agregado el juego: " + juego);
		} catch (ExcepcionDuplicado e) {
			System.out.println(e.getMensaje());
		}
	}

	@Override
	public void listarJuegosPorGenero() {
		logger.info("Inicio del metodo listar juegos por genero en la capa de datos");
		if (listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			Genero.InformeGenero();
			try {
				listarJuegosPorGenero(Genero.dimeGenero(EntradaTeclado.leeIntConMensaje("Introduzca genero")));
			} catch (Throwable e) {
				System.out.println("\n Valor erroneo \n ");
			}
		}
	}

	@Override
	public List<Juego> listarJuegosPorGenero(Genero genero) {
		List<Juego> juegosFiltradosPorGenero = new ArrayList<>();
		for (Juego juego : listaJuegos) {
			if (genero.equals(juego.getGenero())) {
				System.out.println(juego);
				juegosFiltradosPorGenero.add(juego);
			}
		}
		return juegosFiltradosPorGenero;
	}

	@Override
	public void listarJuegosNintendo() {
		logger.info("Inicio del metodo listar juegos de Nintendo en la capa de datos");
		if (listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			logger.debug("Mostrando la lista de juegos de Nintendo");
			for (Juego juego : listarJuegosNintendo("nintendo")) {
				System.out.println(juego);
			}
		}
	}

	@Override
	public List<Juego> listarJuegosNintendo(String fabricante) {
		List<Juego> juegosFiltradosNintendo = new ArrayList<>();
		for (Juego juego : listaJuegos) {
			if (fabricante.equalsIgnoreCase(juego.getPlataforma().getFabricante())) {
				System.out.println(juego);
				juegosFiltradosNintendo.add(juego);
			}
		}
		return juegosFiltradosNintendo;
	}

	@Override
	public int listarJuegos() {
		logger.info("Inicio del metodo listar juegos en la capa de datos");
		int contador = 0;
		if (listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			logger.debug("Mostrando la lista de juegos");
			for (Juego juego : listaJuegos) {
				System.out.println(juego);
				contador++;
			}
		}
		return contador;
	}

	public void cargarJuegos() {
		String linea;
		String[] juegoArray = new String[5];
		int cont = 0;
		try (FileReader fileReader = new FileReader("vgsales.csv");
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			while ((linea = bufferedReader.readLine()) != null) {
				if (cont > 0) {
					Juego juego = new Juego();
					juegoArray = linea.split(",");

					juego.setNombre(juegoArray[0]);
					juego.setPlataforma(Plataforma.dimePlataforma(juegoArray[1]));
					try {
						juego.setFecha(Integer.parseInt(juegoArray[2]));
					} catch (NumberFormatException e) {
						System.out.println("No se ha insertado un numero");
					}
					juego.setGenero(Genero.dimeGenero(juegoArray[3]));
					juego.setEditor(juegoArray[4]);
					this.darDeAlta(juego);

				}
				cont++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
