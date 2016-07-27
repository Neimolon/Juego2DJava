package graficos;

import mapa.cuadro.Cuadro;

/* 20 Lados del mapa

en Pantalla:
-Creamos getter para ancho y alto

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

    /* Temporal */
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
                pixeles[posicionX + posicionY * ancho] = Sprite.ASFALTO.pixeles[(x & MASCARA_SPRITE)
                        + (y & MASCARA_SPRITE) * LADO_SPRITE];
            }
        }
    }

    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {

        for (int y = 0; y < cuadro.sprite.obtenLado(); y++) {

            int posicionY = y + compensacionY;
            for (int x = 0; x < cuadro.sprite.obtenLado(); x++) {
                int posicionX = x + compensacionX;

                if (posicionX < 0 || posicionX > this.ancho || posicionY < 0 || posicionY > this.alto) {
                    break;
                }

                pixeles[posicionX + posicionY * ancho] = cuadro.sprite.pixeles[x + y + cuadro.sprite.obtenLado()];
            }
        }
    }
    
    public int obtenAncho() {
        return ancho;
    }

    public int obtenAlto() {
        return alto;
    }

}
