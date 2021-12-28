package model;

public enum Plataforma {
	
	ATARI_2600 ("2600", "Atari"), 
	NINTENDO_3DS ("3DS", "Nintendo"), 
	SEGA_DREAMCAST ("DC", "Sega"),
	NINTENDO_DS ("DS", "Nintendo"),
	GAMEBOY ("GB", "Nintendo"), 
	GAMEBOY_ADVANCE ("GBA", "Nintendo"), 
	GAMECUBE ("GC", "Nintendo") ,
	SEGA_GENESIS ("GEN", "Sega"), 
	NINTENDO_64 ("N64", "Nintendo"), 
	NES ("NES", "Nintendo"), 
	ARCADE ("NG", ""), 
	PC ("PC", ""),
	PLAY_STATION("PS", "Sony"),
	PLAY_STATION_2("PS", "Sony"),
	PLAY_STATION_3("PS", "Sony"),
	PLAY_STATION_4("PS", "Sony"),
	PSP("PSP", "Sony"), 
	PS_VITA("PSV", "Sony"), 
	SEGA_SATURN ("SAT", "Sega"), 
	SUPER_NES("SNES", "Nintendo"), 
	WII ("Wii", "Nintendo"), 
	WII_U ("WiiU", "Nintendo"), 
	XBOX ("XB", "Microsoft"),
	XBOX_360 ("X360", "Microsoft"),
	XBOX_ONE ("XOne", "Microsoft");
	
	private static Plataforma[] plataformas = Plataforma.values();
	
	private final String codigo;
	private final String fabricante;
	
	private Plataforma(String codigo, String fabricante) {
		this.codigo = codigo;
		this.fabricante = fabricante;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getFabricante() {
		return fabricante;
	}
	
	public static Plataforma dimePlataforma(String codigo) {
		for(Plataforma plataforma: Plataforma.values()) {
			if (plataforma.codigo.equals(codigo)) {
				return plataforma;
			}
		}
		System.out.println("El codigo seleccionado para la plataforma es incorrecto: " + codigo);
		return null;
	}
	
	public static void InformePlataforma() {
		StringBuilder stringBuilder;
		for(Plataforma plataforma: Plataforma.values()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append("(");
			stringBuilder.append(plataforma.codigo);
			stringBuilder.append(")");
			stringBuilder.append(plataforma);
			System.out.println(stringBuilder);
		}
	}

	public static Plataforma[] getPlataformas() {
		return plataformas;
	}
}
