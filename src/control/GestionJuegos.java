package control;

import gui.Menu;
//import utilidades.Datos;
import utils.EntradaTeclado;
import services.IJuegoService;
import services.JuegoServiceImpl;

public class GestionJuegos {

	private IJuegoService services = new JuegoServiceImpl();

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
				services.cargarJuegos();
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
