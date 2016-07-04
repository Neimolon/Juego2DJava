package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import control.Teclado;
import graficos.Pantalla;

/*
 * 11 Graficos en pantalla
 ***
 *en Juego:
 * -creamos dos propiedades int "x" y la "y".
 * -creamos propiedad Pantalla pantalla
 * -creamos propiedad BufferedImage imagen y lo inicializamos
 * -creamos int[]pixeles y lo cargamos con el contenido de imagen(despues de extraerlo con unos metodos esotericos):
 * -->Explicaciones esotericas:
 * --- imagen.getRaster() devuelve el raster que es la secuencia de pixels, .getDataBuffer devuelve un buffer con esa secuencia, hacemos un cast a DataBufferInt para porder llamar a getData() y obtener el array de pixeles;
 * 
 * en el constructor:
 * -Inicializamos Pantalla pantalla
 * 
 * en el metodo mostrar()
 * -si no existe se crea una estrategia para pintar graficos en el canvas (un objeto BufferStrategy con 3 buffers,)
 * -->Explicacion:Este objeto reserva espacio de memoria para 3 buffers que se cargaran desde la CPU antes de ser mostrados en la pantalla.
 * -se limpia el array de pixeles del objeto pantalla y se deja en negro
 * -se carga el array de pixeles del objeto pantalla 
 * -se copia el array de pixels del objeto pantalla al array de pixeles del objeto juego
 * -obtenemos un objeto graphics a traves del objeto estrategia
 * -cargamos la imagen en el objeto estrategia a través de objeto graphics.drawImage()
 * -una vez cargada la imagen la liberamos del objeto graphics con dispose()
 * -se imprime el buffer en el canvas con estrategia.show();
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
	private static Pantalla pantalla;

	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

	public static int aps = 0;
	private static int fps = 0;
	public static int x = 0;
	public static int y = 0;

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		pantalla = new Pantalla(ANCHO, ALTO);

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
		BufferStrategy estrategia = getBufferStrategy();

		if (estrategia == null) {
			createBufferStrategy(3);
			return;
		}

		pantalla.limpiar();
		pantalla.mostrar(Juego.x, Juego.y);

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
