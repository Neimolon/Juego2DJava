package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;

/**
 *
 * @author diego
 */
public class Jugador extends Criatura {

    private Teclado teclado;
    private int animacion;

    public Jugador(Teclado teclado, Sprite sprite) {
        this.teclado = teclado;
        this.sprite = sprite;

    }

    public Jugador(Teclado teclado, Sprite sprite, int posicionX, int posicionY) {
        this.teclado = teclado;
        this.sprite = sprite;
        x = posicionX;
        y = posicionY;
    }

    public void actualizar() {
        int desplazamientoX = 0;
        int desplazamientoY = 0;

        if (animacion < 32767) {
            animacion++;
        } else {
            animacion = 0;
        }

        if (teclado.arriba) {
            desplazamientoY--;
        }
        if (teclado.abajo) {
            desplazamientoY++;
        }
        if (teclado.derecha) {
            desplazamientoX++;
        }
        if (teclado.izquierda) {
            desplazamientoX--;
        }

        if (desplazamientoX != 0 || desplazamientoY != 0) {

            mover(desplazamientoX, desplazamientoY);
            enMovimiento = true;

        } else {
            enMovimiento = false;
        }

        switch (direccion) {
            case 'n':
                sprite = Sprite.JUGADOR_ARRIBA_0;
                if (enMovimiento) {
                    if (animacion % 30 > 15) {
                        sprite = Sprite.JUGADOR_ARRIBA_1;
                    } else {
                        sprite = Sprite.JUGADOR_ARRIBA_2;
                    }
                }
                break;
            case 's':
                sprite = Sprite.JUGADOR_ABAJO_0;
                if (enMovimiento) {
                    if (animacion % 30 > 15) {
                        sprite = Sprite.JUGADOR_ABAJO_1;
                    } else {
                        sprite = Sprite.JUGADOR_ABAJO_2;
                    }
                }
                break;
            case 'e':
                sprite = Sprite.JUGADOR_DCHA_0;
                if (enMovimiento) {
                    if (animacion % 30 > 15) {
                        sprite = Sprite.JUGADOR_DCHA_1;
                    } else {
                        sprite = Sprite.JUGADOR_DCHA_2;
                    }
                }
                break;
            case 'o':
                sprite = Sprite.JUGADOR_IZDA_0;
                if (enMovimiento) {
                    if (animacion % 30 > 15) {
                        sprite = Sprite.JUGADOR_IZDA_1;
                    } else {
                        sprite = Sprite.JUGADOR_IZDA_2;
                    }
                }
                break;
        }
    }

    public void mostrar(Pantalla pantalla) {
        pantalla.mostrarJugador(x, y, this);
    }

}
