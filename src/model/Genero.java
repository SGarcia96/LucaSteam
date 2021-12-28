package model;

public enum Genero {

	ACTION(1),
	AVENTURE(2),
	FIGHTING(3),
	MISC(4),
	PLATAFORM(5),
	PUZZLE(6),
	RACING(7),
	ROLE_PLAYING(8),
	SHOOTER(9),
	SIMULATION(10),
	SPORTS(11),
	STRATEGY(12);
	
	private final int codigo;
	
	private static Genero[] generos = Genero.values();
	
	private Genero(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static Genero dimeGenero(int codigo) {
		if(codigo > generos.length || codigo < 0) {
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


