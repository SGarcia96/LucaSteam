package control;

import exceptions.ExcepcionJuegosYaCargados;
import gui.Menu;
import utils.EntradaTeclado;
import services.IJuegoService;
import services.JuegoServiceImpl;

public class GestionJuegos {

	private IJuegoService services = new JuegoServiceImpl();
	static private boolean cargado = false;

	public void inicio() {
		boolean seguir = true;
		do {
			Menu.showMenuPrincipal();
			seguir = this.seleccionOpciones();
		} while (seguir);
	}

	public boolean seleccionOpciones() {
		boolean continuar = true;

		try {
			switch (EntradaTeclado.leeInt()) {
			case 1:
				services.darDeAlta();
				break;
			case 2:
				services.listarJuegos();
				break;
			case 3:
				try {
					if (cargado) {
						throw new ExcepcionJuegosYaCargados();
					}
					services.cargarJuegos();
					cargado = true;
				} catch (Throwable t) {
					System.out.println(((ExcepcionJuegosYaCargados) t).getMensaje());
				}
				break;
			case 4:
				services.listarJuegosPorGenero();
				break;
			case 5:
				services.listarJuegosNintendo();
				break;
			case 6:
				services.listarEditores();
				break;
			case 7:
				services.listarJuegosSigloXX();
				break;
			case 8:
				services.listarGeneros();
				break;
			case 9:
				services.listarJuegosPorPlataforma();
				break;
			case 10:
				services.listarJuegosPorAnyoPar();
				break;
			case 11:
				services.editarJuego();
				break;
			case 12:
				services.eliminarJuego();
				break;
			case 0:
				continuar = salir();
				break;
			}
		} catch (Exception e) {
			System.out.println("error: " + e.toString());
		}
		return continuar;
	}

	private boolean salir() throws Exception {
		String sino = EntradaTeclado.leeStringConMensaje("¿Estas seguro que quieres salir? S/N");
		return (sino.toUpperCase().charAt(0) != 'S');
	}
}
