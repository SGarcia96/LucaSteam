package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

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
	@Getter @Setter private List<Juego> listaJuegos = new ArrayList<>();

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
	public void eliminarJuego() {
		String nombre = EntradaTeclado.leeStringConMensaje("introduce nombre:");
		Plataforma.InformePlataforma();
		Plataforma plataforma = Plataforma.dimePlataforma(EntradaTeclado.leeStringConMensaje("introduce plataforma del juego: " + nombre));

		Predicate<Juego> condition = juego -> juego.getNombre().equals(nombre);
		Predicate<Juego> condition2 = juego -> juego.getPlataforma().equals(plataforma);

		listaJuegos.removeIf(condition.and(condition2));
	}

	@Override
	public void eliminarJuego(Juego juego) {
		listaJuegos.remove(juego);
		logger.info("se ha eliminado el juego: " + juego);
	}

	@Override
	public void editarJuego() {
		String nombre = EntradaTeclado.leeStringConMensaje("introduce nombre:");
		Plataforma.InformePlataforma();
		Plataforma plataforma = Plataforma.dimePlataforma(EntradaTeclado.leeStringConMensaje("introduce plataforma del juego: " + nombre));
		
		Predicate<Juego> condition = juego -> juego.getNombre().equals(nombre);
		Predicate<Juego> condition2 = juego -> juego.getPlataforma().equals(plataforma);

		listaJuegos.stream()
					.filter(condition.and(condition2))
					.findAny().ifPresent(juego -> PedirDatos.pideDatosJuego(juego));
	}
	
	@Override
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
			if (juego.getPlataforma() != null && fabricante.equalsIgnoreCase(juego.getPlataforma().getFabricante())) {
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
	
	@Override
	public List<Juego> listarJuegosSigloXX() {
		logger.info("Inicio del metodo listar juegos siglo XX");
		List<Juego> juegosSigloXX = new ArrayList<>();

		if (listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			for (Juego juego : listaJuegos) {
				if (1901 <= juego.getFecha() && juego.getFecha() <= 2000) {
					System.out.println(juego);
					juegosSigloXX.add(juego);
				}
			}
		}
		return juegosSigloXX;
	}

	@Override
	public Set<String> listarEditores() {
		Set<String> editores = new HashSet<>();
		
		for (Juego juego : listaJuegos) {
			if (!this.existeEditor(juego.getEditor(), editores)) {
				editores.add(juego.getEditor());
				System.out.println("Editor: " + juego.getEditor());
			}
		}
		return editores;
	}

	@Override
	public Set<Genero> listarGeneros() {
		Set<Genero> generos = new HashSet<>();
		
		for (Juego juego : listaJuegos) {
			if (!this.existeGenero(juego.getGenero(), generos)) {
				generos.add(juego.getGenero());
				System.out.println("Genero: " + juego.getGenero());
			}
		}
		return generos;
	}

	@Override
	public void listarJuegosPorPlataforma() {
		logger.info("Inicio del metodo listar juegos por plataforma en la capa de datos");
		if (listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			Plataforma.InformePlataforma();
			try {
				listarJuegosPorPlataforma(
						Plataforma.dimePlataforma(EntradaTeclado.leeStringConMensaje("Introduzca plataforma")));
			} catch (Throwable e) {
				System.out.println("\n Valor erroneo \n ");
			}
		}
	}

	@Override
	public List<Juego> listarJuegosPorPlataforma(Plataforma plataforma) {
		List<Juego> juegosFiltradosPorPlataforma = new ArrayList<>();
		
		for (Juego juego : listaJuegos) {
			if (plataforma.equals(juego.getPlataforma())) {
				System.out.println(juego);
				juegosFiltradosPorPlataforma.add(juego);
			}
		}
		return juegosFiltradosPorPlataforma;
	}

	@Override
	public List<Juego> listarJuegosPorAnyoPar() {
		logger.info("Inicio del metodo listar juegos anyos pares");
		List<Juego> listarJuegosPorAnyoPar = new ArrayList<>();

		if (listaJuegos.isEmpty()) {
			logger.warn("No hay ningun juego registrado");
			System.out.println("No hay ningun juego registrado");
		} else {
			for (Juego juego : listaJuegos) {
				if (juego.getFecha() % 2 == 0) {
					System.out.println(juego);
					listarJuegosPorAnyoPar.add(juego);
				}
			}
		}
		return listarJuegosPorAnyoPar;
	}

	public boolean existeGenero(Genero genero, Set<Genero> generos) {
		if (generos.contains(genero)) {
			return true;
		}
		return false;
	}

	public boolean existeEditor(String editor, Set<String> editores) {
		if (editores.contains(editor)) {
			return true;
		}
		return false;
	}
}
