package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/*6 Hoja de Sprites:
 ***
 * -Creamos el paquete graficos
 * -Creamos la clase HojaSprites (que contendrá los recursos graficos)
 * -creamos las propiedades int ancho, int alto y int[] pixeles
 * -Creamos el constructor:
 * --el constructor acepta los valores ruta,acho y alto de la imagen.
 * --Creamos la variabe BufferedImage imagen
 * --Leemos el sprite y lo cargamos en la variable imagen (valiendonos de la clase ImageIO y BufferedImage)  
 * */

public class HojaSprites {
	public final int ancho;

	public final int alto;
	public final int[] pixeles;

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
