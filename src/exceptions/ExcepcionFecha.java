package exceptions;

@SuppressWarnings("serial")
public class ExcepcionFecha extends Throwable {

	private String mensaje = "Solo anyos a partir de 1950";

	public String getMensaje() {
		return mensaje;
	}

	public ExcepcionFecha() {
		super();
	}

	public ExcepcionFecha(String msg) {
		super(msg);
	}
}
