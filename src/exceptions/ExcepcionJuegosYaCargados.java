package exceptions;

public class ExcepcionJuegosYaCargados extends Throwable {

	private String mensaje = "Ya se han cargado los juegos del fichero";

	public String getMensaje() {
		return mensaje;
	}

	public ExcepcionJuegosYaCargados() {
		super();
	}

	public ExcepcionJuegosYaCargados(String msg) {
		super(msg);
	}
}
