package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Juego {
	@Getter @Setter private String nombre;
	@Getter @Setter private int fecha;
	@Getter @Setter private Editor editor;
	@Getter @Setter private Genero genero;
	@Getter @Setter private Plataforma plataforma;
}
