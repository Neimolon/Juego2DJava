package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

/**
 *
 * @author diego
 */
public class Jugador extends Criatura {

    private Teclado teclado;
    private int animacion;

    public Jugador(Mapa mapa, Teclado teclado, Sprite sprite) {
        this.mapa = mapa;
        this.teclado = teclado;
        this.sprite = sprite;
        
    }

    public Jugador(Mapa mapa,Teclado teclado, Sprite sprite, int posicionX, int posicionY) {
        this(mapa,teclado,sprite);
        x = posicionX;
        y = posicionY;
    }

    public void actualizar() {
        int desplazamientoX = 0;
        int desplazamientoY = 0;
        
        int velocidadMovimiento = 1;

        if (animacion < 32767) {
            animacion++;
        } else {
            animacion = 0;
        }
        if(teclado.correr){
            velocidadMovimiento = 2;
        }

        if (teclado.arriba) {
            desplazamientoY -= velocidadMovimiento;
        }
        if (teclado.abajo) {
            desplazamientoY += velocidadMovimiento;
        }
        if (teclado.derecha) {
            desplazamientoX += velocidadMovimiento;
        }
        if (teclado.izquierda) {
            desplazamientoX -= velocidadMovimiento;
        }

        if (desplazamientoX != 0 || desplazamientoY != 0) {

            mover(desplazamientoX, desplazamientoY);
            enMovimiento = true;

        } else {
            enMovimiento = false;
        }

        int resto = animacion % 40;

        switch (direccion) {
            case 'n':
                sprite = Sprite.JUGADOR_ARRIBA_0;
                if (enMovimiento) {
                    if (resto > 10 && resto <= 20) {
                        sprite = Sprite.JUGADOR_ARRIBA_1;
                    } else if (resto > 20 && resto <= 30) {
                        sprite = Sprite.JUGADOR_ARRIBA_0;
                    } else if (resto > 23 && resto <= 40) {
                        sprite = Sprite.JUGADOR_ARRIBA_2;
                    } else {
                        sprite = Sprite.JUGADOR_ARRIBA_0;
                    }
                }
                break;
            case 's':
                sprite = Sprite.JUGADOR_ABAJO_0;
                if (enMovimiento) {
                    if (resto > 10 && resto <= 20) {
                        sprite = Sprite.JUGADOR_ABAJO_1;
                    } else if (resto > 20 && resto <= 30) {
                        sprite = Sprite.JUGADOR_ABAJO_0;
                    } else if (resto > 23 && resto <= 40) {
                        sprite = Sprite.JUGADOR_ABAJO_2;
                    } else {
                        sprite = Sprite.JUGADOR_ABAJO_0;
                    }
                }

                break;
            case 'e':
                sprite = Sprite.JUGADOR_DCHA_0;
                if (enMovimiento) {
                    if (resto > 10 && resto <= 20) {
                        sprite = Sprite.JUGADOR_DCHA_1;
                    } else if (resto > 20 && resto <= 30) {
                        sprite = Sprite.JUGADOR_DCHA_0;
                    } else if (resto > 23 && resto <= 40) {
                        sprite = Sprite.JUGADOR_DCHA_2;
                    } else {
                        sprite = Sprite.JUGADOR_DCHA_0;
                    }
                }
                break;

            case 'o':
                sprite = Sprite.JUGADOR_IZDA_0;
                if (enMovimiento) {
                    if (resto > 10 && resto <= 20) {
                        sprite = Sprite.JUGADOR_IZDA_1;
                    } else if (resto > 20 && resto <= 30) {
                        sprite = Sprite.JUGADOR_IZDA_0;
                    } else if (resto > 23 && resto <= 40) {
                        sprite = Sprite.JUGADOR_IZDA_2;
                    } else {
                        sprite = Sprite.JUGADOR_IZDA_0;
                    }
                }
        }
    }

    public void mostrar(Pantalla pantalla) {
        pantalla.mostrarJugador(x, y, this);
    }

}
