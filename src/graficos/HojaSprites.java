package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/*11 Gráfico en pantalla
 ***
 *Cambiamos el nombre del directorio de imágenes por recursos/texturas
 *Incluimos el directorio en el Java Build Path
 *
 * *En HojaSprites:
 *-Creamos la propiedad HojaSprites como estática y la inicializamos 
 *
 */

public class HojaSprites {
	public final int ancho;

	public final int alto;
	public final int[] pixeles;

	// coleccion de hojas de sprites
	public static HojaSprites desierto = new HojaSprites("/texturas/desierto.png", 320, 320);
        public static HojaSprites jugador = new HojaSprites("/texturas/jugador.png", 320, 320);
	// fin de la coleccion

	public HojaSprites(final String ruta, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];

		BufferedImage imagen;
		try {
			imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int obtenAncho() {
		return this.ancho;
	}

}
