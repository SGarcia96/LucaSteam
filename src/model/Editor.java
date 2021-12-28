package model;

public enum Editor {

	ELECTRONICS_ARTS(1),
	ACTIVISION(2),
	NAMCO_BANDAI_GAMES(3),
	UBISOFT(4),
	KONAMI_DIGITAL_ENTERTAINMENT(5);
	
	private final int codigo;
	
	private static Editor[] editores = Editor.values();
	
	private Editor(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static Editor dimeEditor(int codigo) {
		if(codigo > editores.length || codigo < 0) {
			System.out.println("El numero seleccionado para el editor es incorrecto");
			return null;
		} else {
			return editores[codigo - 1];
		}
	}
	
	public static void InformeEditor() {
		StringBuilder stringBuilder;
		for(Editor editor: Editor.values()) {
			stringBuilder = new StringBuilder();
			stringBuilder.append("(");
			stringBuilder.append(editor.codigo);
			stringBuilder.append(")");
			stringBuilder.append(editor);
			System.out.println(stringBuilder);
		}
	}
	
}
