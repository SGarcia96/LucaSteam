package exceptions;

@SuppressWarnings("serial")
public class ExcepcionPlataforma extends Throwable {

	private String mensaje = "Ese código no es de una plataforma existente";

	public String getMensaje() {
		return mensaje;
	}

	public ExcepcionPlataforma() {
		super();
	}

	public ExcepcionPlataforma(String msg) {
		super(msg);
	}
}
