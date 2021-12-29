package exceptions;

public class ExcepcionRepetido extends Throwable{
	
	private String mensaje = "Ese juego ya existe";
	
	public String getMensaje() {
		return mensaje;
	}
	
	public ExcepcionRepetido() {
		super();
	}
	
	public ExcepcionRepetido(String msg) {
		super(msg);
	}
}
