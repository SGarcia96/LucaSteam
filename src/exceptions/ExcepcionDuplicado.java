package exceptions;

@SuppressWarnings("serial")
public class ExcepcionDuplicado extends Throwable {

	private String mensaje = "Ese juego ya existe";

	public String getMensaje() {
		return mensaje;
	}

	public ExcepcionDuplicado() {
		super();
	}

	public ExcepcionDuplicado(String msg) {
		super(msg);
	}
}
