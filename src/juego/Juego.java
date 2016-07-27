//test -- Ignorar
package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.Teclado;
import graficos.Pantalla;
import mapa.Mapa;
import mapa.MapaGenerado;


public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private static final String NOMBRE = "Juego";

	private static volatile boolean enFuncionamiento = false;

	private static JFrame ventana;
	private static Thread thread;
	private static Teclado teclado;
	private static Pantalla pantalla;
        private static Mapa mapa;

	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
	private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));

	public static int aps = 0;
	private static int fps = 0;
	public static int x = 0;
	public static int y = 0;

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		pantalla = new Pantalla(ANCHO, ALTO);
                
                mapa = new MapaGenerado(128, 128);

		teclado = new Teclado();
		addKeyListener(teclado);

		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setIconImage(icono.getImage());
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
			y--;
		}
		if (teclado.abajo) {
			y++;
		}
		if (teclado.izquierda) {
			x--;
		}
		if (teclado.derecha) {
			x++;
		}

		this.aps++;
	}

	private void mostrar() {
		BufferStrategy estrategia = getBufferStrategy();

		if (estrategia == null) {
			createBufferStrategy(3);
			return;
		}

		pantalla.limpiar();
                mapa.mostrar(this.x, this.y, pantalla);


		System.arraycopy(pantalla.pixeles, 0, this.pixeles, 0, this.pixeles.length);

		Graphics g = estrategia.getDrawGraphics();

		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.dispose();

		estrategia.show();

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
