package graficos;

/*11 Graficos en Pantalla:
 ***
 *REMEMBER:Ojito al escribir los putos signos de comparacion! 1h de debug por un > cambiado!!!!!!
 *
 *Solo temporalmente:
 *-Creamos variables lado_sprite y máscara sprite
 *
 *-en mostrar:
 *--asignamos al array de pixeles de la pantalla los pixeles del Sprite que nos interesa de la siguiente forma:
 *---pixeles[posicionX + posicionY * this.ancho] = Sprite.asfalto.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE];
 *
 *--->Explicamos porque es interesante:
 *---MASCARA_SPRITE tiene el el valor (tamaño del sprite(LADO_SPRITE) - 1)
 *---(posicionX + posicionY * this.ancho)  y  ((x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE) es equivalente
 *---   MASCARA_SPRITE  -> int pix 31 ->     011111 en binario
 *---   x o y en bucle  ->         32 ->  &  100000 en binario (valor en el que se superaría el rango de posiciones en el array)
 *---                                     =  000000 -> despues de recorrer 32 valores (0 a 31), el bucle vuelve a la posicion inicial
 *                                                     sin que tengamos que hacer ifs o sumas, se aumenta el rendimiento.
 */

public final class Pantalla {

	public final int[] pixeles;

	// Temporal
	private final static int LADO_SPRITE = 32;
	private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
	// Fin Temporal

	private final int ancho;
	private final int alto;

	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];

	}

	public void limpiar() {
		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}

	public void mostrar(final int compensacionX, final int compensacionY) {
		for (int y = 0; y < this.alto; y++) {
			int posicionY = y + compensacionY;
			if (posicionY < 0 || posicionY >= this.alto) {
				continue;
			}

			for (int x = 0; x < this.ancho; x++) {
				int posicionX = x + compensacionX;
				if (posicionX < 0 || posicionX >= this.ancho) {
					continue;
				}
				// temporal
				pixeles[posicionX + posicionY * ancho] = Sprite.asfalto.pixeles[(x & MASCARA_SPRITE)
						+ (y & MASCARA_SPRITE) * LADO_SPRITE];
			}
		}
	}

}
