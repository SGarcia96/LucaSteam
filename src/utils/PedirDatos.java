package utils;

import java.util.InputMismatchException;

import exceptions.ExcepcionFecha;

import exceptions.ExcepcionGenero;

import exceptions.ExcepcionPlat;

import model.Genero;
import model.Juego;
import model.Plataforma;



public class PedirDatos {
	
	public static void pideDatosJuego(Juego juego) {
		
		juego.setNombre(EntradaTeclado.leeStringConMensaje("introduce nombre"));
		
		boolean anyoIncorrecto = true;
		int anyo = 0;
		do {
			try {
				anyo = EntradaTeclado.leeIntConMensaje("introduce anyo");
				if(anyo < 1950){
					throw new ExcepcionFecha();
				}
				juego.setFecha(anyo);
				anyoIncorrecto = false;
			}
			catch (InputMismatchException e) {
				System.out.println("Un número entero por favor");
			}
			catch (Throwable t) {
				System.out.println(((ExcepcionFecha) t).getMensaje());
			}
		} while (anyoIncorrecto);
		
		
		
		
		juego.setEditor(EntradaTeclado.leeStringConMensaje("introduce editor"));

		Plataforma.InformePlataforma();
		juego.setPlataforma(Plataforma.dimePlataforma(EntradaTeclado.leeStringConMensaje("introduce plataforma")));
		
		
		
		
		
		//juego.setGenero(Genero.dimeGenero(EntradaTeclado.leeIntConMensaje("introduce genero")));
		
		
		
		boolean generoIncorrecto = true;
		Genero genero;
		do {
			try {
				Genero.InformeGenero();
				genero = Genero.dimeGenero(EntradaTeclado.leeIntConMensaje("Introduce genero"));
				juego.setGenero(genero);
				generoIncorrecto = false;
			}
			catch (InputMismatchException e) {
				System.out.println("Un número entero por favor");
			}
			catch (Throwable t) {
				System.out.println(((ExcepcionGenero)t).getMensaje());
			}
			
		} while (generoIncorrecto);

		
		
		
		boolean platIncorrecta = true;
		Plataforma plat;
		do {
			try {
				Plataforma.InformePlataforma();
				plat = Plataforma.dimePlataforma(EntradaTeclado.leeStringConMensaje("introduce plataforma"));
				if(plat == null){
					throw new ExcepcionPlat();
				}
				juego.setPlataforma(plat);
				platIncorrecta = false;
			}
			catch (InputMismatchException e) {
				System.out.println("Inserte uno de los códigos");
			}
			catch (Throwable t) {
				System.out.println(((ExcepcionPlat) t).getMensaje());
			}
		} while (platIncorrecta);
		
		
		Genero.InformeGenero();
		try {
			juego.setGenero(Genero.dimeGenero(EntradaTeclado.leeIntConMensaje("introduce genero")));
		} catch (ExcepcionGenero e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
