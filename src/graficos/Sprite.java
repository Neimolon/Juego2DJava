package graficos;

/*7 Extrayebdo los sprites;
 *** 
 * 
 * Creamos la clase Sprite en el paquete graficos
 * Creamos el atributo lado(tamaño sprite dentro de la joha de strites)
 * Creamos los atributos x e y (guarda las posiciones del sprite en pixeles)
 * Creamos el atributo hoja para tener accesible la Hoja de Sprites de la que extraer el sprite
 * Creamos el array Pixeles para almacenar los pixeles extraidos
 * 
 * Creamos el constructos de Sprite:
 * -Inicializamos las variables
 * -Creamos un bucle que recorra el tamaño de un sprite y fuarde todos sus pixeles en el array de pixeles
 * 
 * */
public final class Sprite {

	public int[] pixeles;

	private final HojaSprites hoja;

	private final int lado;
	private final int x;
	private final int y;

	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.hoja = hoja;
		this.lado = lado;

		pixeles = new int[lado * lado];

		this.x = columna * lado;
		this.y = fila * lado;

		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];
			}
		}

	}

}
