/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mapa.cuadro.Cuadro;

/**
 *
 * @author diego
 */
public class MapaCargado extends Mapa {

    private int[] pixeles;

    public MapaCargado(String ruta) {
        super(ruta);

    }

    @Override
    protected void cargarMapa(String ruta) {
        try {
            BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));

            ancho = imagen.getWidth();
            alto = imagen.getHeight();

            cuadrosCatalogo = new Cuadro[ancho * alto];
            pixeles = new int[ancho * alto];

            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void generarMapa() {
        for (int i = 0; i < pixeles.length; i++) {
            switch (pixeles[i]) {
                case 0xFF000000:
                    cuadrosCatalogo[i] = Cuadro.ASFALTO;
                    continue;
                case 0xFFd9bb13:
                    cuadrosCatalogo[i] = Cuadro.ARENA;
                    continue;
                case 0xFF7d6b07:
                    cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA;
                    continue;
                case 0xFFa19346:
                    cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_DERECHA;
                    continue;
                case 0xFFa8ba54:
                    cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_ARRIBA;
                    continue;
                case 0xFF454f14:
                    cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA_ABAJO;
                    continue;
                case 0xFF939188:
                    cuadrosCatalogo[i] = Cuadro.CENTRO_CARRETERA;
                    continue;
                case 0xFFaaa9a3:
                    cuadrosCatalogo[i] = Cuadro.CENTRO_CARRETERA_HORIZONTAL;
                    continue;
                case 0xFF837e64:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA;
                    continue;
                case 0xFFd3d462:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_DERECHA;
                    continue;
                case 0xFF58590e:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_ARRIBA;
                    continue;
                case 0xFFc2c374:
                    cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA_ARRIBA_DERECHA;
                    continue;
                    
                case 0xFF443f24:
                    cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA;
                    continue;
                case 0xFF6e642a:
                    cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_INFERIOR;
                    continue;
                case 0xFF425a47:
                    cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_CARRETERA;
                    continue;
                case 0xFF36dc56:
                    cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_CARRETERA_INVERTIDA_X;
                    continue;
                case 0xFFec243c:
                    cuadrosCatalogo[i] = Cuadro.OXIDO;
                    continue;
                case 0xFFab1e2e:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_CENTRAL;
                    continue;
                case 0xFF765257:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_IZQUIERDA;
                    continue;
                case 0xFF683a40:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_DERECHA;
                    continue;
                case 0xFFc63042:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_INTERMEDIA_IZQUIERDA;
                    continue;
                case 0xFF772055:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_INTERMEDIA_DERECHA;
                    continue;
                case 0xFFa14653:
                    cuadrosCatalogo[i] = Cuadro.PUERTA_INFERIOR;
                    continue;
                case 0xFF00ccff:
                    cuadrosCatalogo[i] = Cuadro.CARTEL_PUTIS_IZDA;
                    continue;
                case 0xFF6edcf7:
                    cuadrosCatalogo[i] = Cuadro.CARTEL_PUTIS_DCHA;
                    continue;
                default:
                    cuadrosCatalogo[i] = Cuadro.VACIO;

            }
        }
    }

}
