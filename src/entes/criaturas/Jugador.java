package entes.criaturas;

import control.Teclado;

/**
 *
 * @author diego
 */
public class Jugador extends Criatura {

    private Teclado teclado;

    public Jugador(Teclado teclado) {
        this.teclado = teclado;
    }

    public Jugador(Teclado teclado, int posicionX, int posicionY) {
        teclado = teclado;
        x = posicionX;
        y = posicionY;
    }

    public void actualizar() {
        int desplazamientoX = 0;
        int desplazamientoY = 0;

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
        
        if(desplazamientoX != 0 || desplazamientoY != 0){
            mover(desplazamientoX,desplazamientoY);
        }
    }

}
