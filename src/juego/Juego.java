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
import entes.criaturas.Jugador;
import graficos.Pantalla;
import graficos.Sprite;
import java.awt.Color;
import mapa.Mapa;
import mapa.MapaCargado;
import mapa.cuadro.Cuadro;

public class Juego extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private static final int ANCHO = 480;
    private static final int ALTO = 360;
    private static final String NOMBRE = "Juego";

    private String CONTADOR_APS = "";
    private String CONTADOR_FPS = "";

    private static volatile boolean enFuncionamiento = false;

    private static JFrame ventana;
    private static Thread thread;
    private static Teclado teclado;
    private static Pantalla pantalla;
    private static Mapa mapa;
    private static Jugador jugador;

    private static BufferStrategy estrategia;
    private static Graphics g;

    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));

    public static int aps = 0;
    private static int fps = 0;

    private Juego() {
        setPreferredSize(new Dimension(ANCHO, ALTO));

        pantalla = new Pantalla(ANCHO, ALTO);

        teclado = new Teclado();
        addKeyListener(teclado);

        mapa = new MapaCargado("/mapas/desierto.png");
        jugador = new Jugador(mapa,teclado, Sprite.JUGADOR_ARRIBA_0,225,225);

        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setIconImage(icono.getImage());
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setUndecorated(true);
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

        jugador.actualizar();

        if (teclado.salir) {
            System.exit(0);
        }

        this.aps++;
    }

    private void mostrar() {
        estrategia = getBufferStrategy();

        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }

        //pantalla.limpiar();
        mapa.mostrar(jugador.obtenerPosicionX() - pantalla.obtenAncho() / 2 + jugador.obtenSprite().obtenLado() / 2, 
                     jugador.obtenerPosicionY() - pantalla.obtenAlto() / 2 + jugador.obtenSprite().obtenLado() / 2,
                     pantalla);
        
        jugador.mostrar(pantalla);

        System.arraycopy(pantalla.pixeles, 0, this.pixeles, 0, this.pixeles.length);

        g = estrategia.getDrawGraphics();

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.white);
        g.drawString(CONTADOR_APS, 10, 20);
        g.drawString(CONTADOR_FPS, 10, 35);
        g.drawString("X: " + jugador.obtenerPosicionX(), 10, 50);
        g.drawString("Y: " + jugador.obtenerPosicionY(), 10, 65);
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
                CONTADOR_APS = "APS:" + aps;
                CONTADOR_FPS = "FPS:" + fps;
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }

}
