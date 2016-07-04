package graficos;

/*10 Clase Pantalla:
 * -Creamos propiedades ancho y alto así como el array de pixeles[ancho * alto]
 * 
 * -Creamos Constructor:
 * --inicializamos las propiedades
 * 
 * -Creamos metodo limpiar:
 * --Pone a 0(negro) todo el array de pixeles
 * 
 * -Creamos metodo mostrar:
 * --Recorremos todos los pixeles del ancho y del alto sumandole la compensacion(movimiento del teclado)
 * --Comprobamos que el valor del pixel no esté fuera de la pantalla 
 */

public final class Pantalla {

	private final int[] pixeles;

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
		for (int y = 0; y < alto; y++) {
			int posicionY = y + compensacionY;
			if (posicionY < 0 || posicionY >= alto) {
				continue;
			}

			for (int x = 0; x > ancho; x++) {
				int posicionX = x + compensacionX;
				if (posicionX < 0 || posicionX >= ancho) {
					continue;
				}

				// codigo para redibujar pantalla
			}
		}
	}

}
