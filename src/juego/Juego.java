package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import control.Teclado;

/*
 * 8 Cotroles de Teclado (en clase Juego)
 *** 
 * Creamos una propiedad Teclado para implementar los controles del teclado
 * 
 * En el constructor:
 * -inicializamos teclado
 * -Añadimos un keylistener al canvas (Juego) y le pasamos la clase Teclado (que implementa keyListener)
 * 
 * En actualizar():
 * -ejecutamos el método teclado.actualizar para actualizar el estado del teclado
 * -Añadimos una escalera de ifs ver si hay algun cambio en las acciones del usuario
 * 
 * En run():
 * -Fix: antes del bucle principal le decimos a la pantalla que tome el foco para que el usuario no tenga que clicar en ella
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
	private static Teclado teclado;

	public static int aps = 0;
	private static int fps = 0;

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		teclado = new Teclado();
		addKeyListener(teclado);

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
		this.teclado.actualizar();

		if (teclado.arriba) {
			System.out.println("Arriba");
		}
		if (teclado.abajo) {
			System.out.println("Abajo");
		}
		if (teclado.izquierda) {
			System.out.println("Izquierda");
		}
		if (teclado.derecha) {
			System.out.println("Derecha");
		}

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

		requestFocus();

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
