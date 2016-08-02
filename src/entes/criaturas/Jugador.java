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
    
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarJugador(x, y, this);
    }

}
