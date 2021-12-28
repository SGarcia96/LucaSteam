package model;

import lombok.Getter;
import lombok.Setter;

public class Juego {
	@Getter @Setter private String nombre;
	@Getter @Setter private int fecha;
	@Getter @Setter private Editor editor;
	@Getter @Setter private Genero genero;
	@Getter @Setter private Plataforma plataforma;
}
