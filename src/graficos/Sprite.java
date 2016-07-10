package graficos;

/*11 Gráfico en pantalla;
 *** 
 * 
 *En Sprite:
 *-Creamos la propiedad Sprite asfalto y la inicializamos 
 *
 * 
 * */
public final class Sprite {

	public int[] pixeles;

	private final HojaSprites hoja;

	/* Coleccion Sprites */
	public static final Sprite ASFALTO = new Sprite(32, 0, 0, HojaSprites.desierto);
	/* Fin Coleccion */

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
