package model;

import exceptions.ExcepcionGenero;

public enum Genero {

	ACTION(1),
	ADVENTURE(2),
	FIGHTING(3),
	MISC(4),
	PLATFORM(5),
	PUZZLE(6),
	RACING(7),
	ROLEPLAYING(8),
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
	
	public static Genero dimeGenero(int codigo) throws ExcepcionGenero {
		if(codigo > generos.length || codigo <= 0) {
			throw new ExcepcionGenero();
		} else {
			return generos[codigo - 1];
		}
	}
	
	public static Genero dimeGenero(String texto) {
		for(Genero genero: generos) {
			if(genero.equals(Genero.ROLEPLAYING)) {
				if ( texto.toUpperCase().equals("ROLE-PLAYING")) {
					return genero;
				}
			} else if (genero.toString().equals(texto.toUpperCase())) {
				return genero;
			}
		}
		System.out.println("El genero insertado es incorrecto: " + texto);
		return null;
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


