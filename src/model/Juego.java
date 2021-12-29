package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Juego {
	@Getter @Setter private String nombre;
	@Getter @Setter private int fecha;
	@Getter @Setter private String editor;
	@Getter @Setter private Genero genero;
	@Getter @Setter private Plataforma plataforma;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nombre);
		builder.append("\n\t");
		builder.append("fecha: ");
		builder.append(fecha);
		builder.append(", editor: ");
		builder.append(editor);
		builder.append(", genero: ");
		builder.append(genero);
		builder.append(", plataforma: ");
		builder.append(plataforma);
		builder.append("\n");
		
		return builder.toString();
	}
}
