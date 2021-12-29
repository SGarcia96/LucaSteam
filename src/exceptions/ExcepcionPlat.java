package exceptions;

public class ExcepcionPlat extends Throwable{
	
	private String mensaje = "Ese c�digo no es de una plataforma existente";
	
	public String getMensaje() {
		return mensaje;
	}
	
	public ExcepcionPlat() {
		super();
	}
	
	public ExcepcionPlat(String msg) {
		super(msg);
	}
}
