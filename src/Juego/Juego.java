package Juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/*
 * 3
 *** 
 * Añadimos nuevo Thread
 * Implementar Runnable en clase Principal:
 * -implementar run()
 * Crear metodo iniciar 
 * -crear objeto Thread pasandole la clase "this" para que arranque el run() de esta clase.
 * -lanzar thread
 * Crear metodo detener
 * 
 * 4
 ***
 *Implementar bucle principal en run():
 *-Crear variable control funcionamiento como volatile para bloquear acceso simultaneo
 *-iniciar y detener como synchronized, setear la configuracion de variable funcionamiento
 *-desarrollar metodo detener:
 *--set enFuncionamient
 *--detener thread
 *
 * 5 
 ***
 * Crear metodos actualizar y mostrar y meter en el bucle
 * Temporizador:
 *  se crea variable delta logica para determinar el numero de veces que se actualiza la pantalla
 *  -->Explicacion: -Se fijan cuantas actualizaciones por segundo queremos que haya y se calcula el tiempo.
 *                  -La variable delta  es un coeficiente entre el tiempo transcurrido y el tiempo deseado
 *                  -Si el coeficiente es >=1(ha transcurrido el tiempo deseado) se lanza el metodo de actualizar
 *                  -Si el coeficiente es >1, en delta se guardan los milisegundos excedentes para descontarlos en la siguiente vuelta y ajustar los ciclos con mas precision
 * se crea un bucle que gira mientas delta sea >1 en el que se ejecuta mostrar() , que deberia corresponderse a las APS_OBJETIVO 
 * actualizar() sigue ejecutandose a velocidad máquina en el loop principal;
 * 
 *                    
 * Contador FPS:
 * se crea una variable de clase fps y otra aps
 * en mostrar() se incrementa fps en 1 cada llamada
 * en actualizar() se incrementa aps en 1 cada llamada 
 * en run() se crea la variable referenciaContador y se le asigna el calculo del tiempo correspondiente a un segundo
 * por cada vuelta de segundo se actualiza el titulo, mostrando FPS y APS
 * 
 */
public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private static final String NOMBRE = "Juego";

	private static volatile boolean enFuncionamiento = false;

	private static JFrame ventana;
	private static Thread thread;

	public static int aps = 0;
	private static int fps = 0;

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	public static void main(String args[]) {
		Juego juego = new Juego();
		juego.iniciar();
	}

	private synchronized void iniciar() {
		this.enFuncionamiento = true;

		this.thread = new Thread(this, "Gráficos");
		this.thread.start();
	}

	private synchronized void detener() {
		this.enFuncionamiento = false;

		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void actualizar() {
		this.aps++;
	}

	private void mostrar() {
		this.fps++;
	}

	@Override
	public void run() {
		final int NS_POR_SEGUNO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNO / APS_OBJETIVO;

		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0;

		while (enFuncionamiento) {
			final long INICIO_BUCLE = System.nanoTime();

			tiempoTranscurrido = INICIO_BUCLE - referenciaActualizacion;
			referenciaActualizacion = INICIO_BUCLE;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				this.actualizar();
				delta--;
			}

			this.mostrar();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNO) {
				ventana.setTitle(NOMBRE + " || APS:" + this.aps + " || FPS: " + this.fps);
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}

}
