package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* 8- Controles con el teclado
 ***
 * Creamos paquete control
 * Creamos clase Teclado en el paquete control
 * Implementamos KeyListener y sus métodos en Teclado(keyPressed,keyReleased,keyTyped)
 * Teclado:
 * -Creamos atributo numeroTeclas asignando el valor del codigo de caracter más alto a usar;
 * -Creamos un array de booleanos con tantas posiciones como numeroTeclas haya
 * -Creamos booleanos de los controles mas habituales(arriba,abajo,izquierda,derecha)
 * 
 * -Creamos metodo actualizar:
 * --se asignan a los controles(arriba,abajo...) el valor de las teclas (si esta pulsado o no)
 * 
 * -en keyPressed():
 * --obtenemos el valor de la tecla pulsada y lo marcamos a true en el array de booleanos en la posicion del codigo de la tecla pulsada
 * 
 * -en keyReleased():
 * --obtenemos el valor de la tecla pulsada y lo marcamos a false en el array de booleanos en la posicion del codigo de la tecla pulsada
 * 
 * */
public final class Teclado implements KeyListener {
	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[this.numeroTeclas];

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
        
        public boolean salir;

	public void actualizar() {
		this.arriba = teclas[KeyEvent.VK_W];
		this.abajo = teclas[KeyEvent.VK_S];
		this.izquierda = teclas[KeyEvent.VK_A];
		this.derecha = teclas[KeyEvent.VK_D];
                this.salir = teclas[KeyEvent.VK_ESCAPE];
                
	}

	@Override
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
