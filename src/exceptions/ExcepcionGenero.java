package exceptions;

import model.Genero;

@SuppressWarnings("serial")
public class ExcepcionGenero extends Throwable {

	private String mensaje = "Por favor, solo valen valores entre 1 y " + ((Genero.values().length));

	public String getMensaje() {
		return mensaje;
	}

	public ExcepcionGenero() {
		super();
	}

	public ExcepcionGenero(String msg) {
		super(msg);
	}
}
