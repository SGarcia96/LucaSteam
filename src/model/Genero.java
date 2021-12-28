package model;

public enum Genero {

	ACTION(1),
	SPORTS(2),
	MISC(3),
	ROLE_PLAYING(4),
	SHOOTER(5);
	
	private final int codigo;
	
	private static Genero[] generos = Genero.values();
	
	private Genero(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static Genero dimeGenero(int codigo) {
		if(codigo > generos.length) {
			System.out.println("El numero seleccionado para el genero es incorrecto");
			return null;
		} else {
			return generos[codigo - 1];
		}
	}
	
	public static void InformeGenero() {
		StringBuilder stringBuilder;
		for(Genero genero: Genero.values()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append("(");
			stringBuilder.append(genero.codigo);
			stringBuilder.append(")");
			stringBuilder.append(genero);
			System.out.println(stringBuilder);
		}
	}
}


