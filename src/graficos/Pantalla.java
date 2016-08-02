package graficos;

import entes.criaturas.Jugador;
import mapa.cuadro.Cuadro;

/* 20 Lados del mapa

en Pantalla:
-Creamos getter para ancho y alto

 */
public final class Pantalla {

    public final int[] pixeles;
    private final int ancho;
    private final int alto;

    private int diferenciaX;
    private int diferenciaY;

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

    public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) {

        compensacionX -= this.diferenciaX;
        compensacionY -= this.diferenciaY;

        for (int y = 0; y < cuadro.sprite.obtenLado(); y++) {

            int posicionY = y + compensacionY;
            for (int x = 0; x < cuadro.sprite.obtenLado(); x++) {
                int posicionX = x + compensacionX;

                if (posicionX < -cuadro.sprite.obtenLado() || posicionX >= this.ancho || posicionY < 0 || posicionY >= this.alto) {
                    break;
                }

                if (posicionX < 0) {
                    posicionX = 0;
                }

                pixeles[posicionX + posicionY * this.ancho] = cuadro.sprite.pixeles[x + y * cuadro.sprite.obtenLado()];

            }
        }
    }
    
    public void mostrarJugador(int compensacionX, int compensacionY,Jugador jugador){
        compensacionX -= this.diferenciaX;
        compensacionY -= this.diferenciaY;

        for (int y = 0; y < jugador.obtenSprite().obtenLado(); y++) {

            int posicionY = y + compensacionY;
            for (int x = 0; x < jugador.obtenSprite().obtenLado(); x++) {
                int posicionX = x + compensacionX;

                if (posicionX < -jugador.obtenSprite().obtenLado() || posicionX >= this.ancho || posicionY < 0 || posicionY >= this.alto) {
                    break;
                }

                if (posicionX < 0) {
                    posicionX = 0;
                }

                pixeles[posicionX + posicionY * this.ancho] = jugador.obtenSprite().pixeles[x + y * jugador.obtenSprite().obtenLado()];

            }
        }
    }

    public void estableceDiferencia(final int diferenciaX, final int diferenciaY) {
        this.diferenciaX = diferenciaX;
        this.diferenciaY = diferenciaY;
    }

    public int obtenAncho() {
        return ancho;
    }

    public int obtenAlto() {
        return alto;
    }

}
