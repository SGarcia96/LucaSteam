package model;

public enum Plataforma {
	
	ATARI2600 ("2600", "Atari"), 
	N3DS ("3DS", "Nintendo"), 
	DREAMCAST ("DC", "Sega"),
	DS ("DS", "Nintendo"),
	GAMEBOY ("GB", "Nintendo"), 
	GAMEBOY_ADVANCE ("GBA", "Nintendo"), 
	GAMECUBE ("GC", "Nintendo") ,
	GENESIS ("GEN", "Sega"), 
	N64 ("N64", "Nintendo"), 
	NES ("NES", "Nintendo"), 
	ARCADE ("NG", ""), 
	PC ("PC", ""),
	PLAY_STATION("PS", "Sony"),
	PLAY_STATION2("PS2", "Sony"),
	PLAY_STATION3("PS3", "Sony"),
	PLAY_STATION4("PS4", "Sony"),
	PSP("PSP", "Sony"), 
	PS_VITA("PSV", "Sony"), 
	SATURN ("SAT", "Sega"), 
	SUPER_NES("SNES", "Nintendo"), 
	WII ("Wii", "Nintendo"), 
	WIIU ("WiiU", "Nintendo"), 
	XBOX ("XB", "Microsoft"),
	XBOX360 ("X360", "Microsoft"),
	XONE ("XOne", "Microsoft");
	
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
