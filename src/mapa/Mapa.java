package mapa;

import graficos.Pantalla;
import graficos.Sprite;
import mapa.cuadro.Cuadro;
import mapa.cuadro.CuadroAsfalto;

/*
20 Lados del mapa
 ***
en Mapa:
-en metodo mostrar:
--creamos las variables n,s,e,o para fijar los limites del mapa


 */
public abstract class Mapa {

    protected int alto;
    protected int ancho;

    protected int[] cuadros;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        this.cuadros = new int[ancho * alto];

        this.generarMapa();

    }

    public Mapa(String ruta) {
        this.generarMapa(ruta);

    }

    protected void generarMapa() {

    }

    private void generarMapa(String ruta) {

    }

    public void actualizar() {

    }

    public void mostrar(final int compensacionX, final int compensacionY, final Pantalla pantalla) {

        pantalla.estableceDiferencia(compensacionX, compensacionY);

        int o = compensacionX >> 5;  //BitShifting de 5 bits, equivale a dividir por 32
        int e = (compensacionX + pantalla.obtenAncho() + Cuadro.LADO) >> 5;
        int n = compensacionY >> 5;
        int s = (compensacionY + pantalla.obtenAlto() + Cuadro.LADO) >> 5;

        for (int y = n; y < s; y++) {
            for (int x = o; x < e; x++) {
                this.obtenCuadro(x, y).mostrar(x, y, pantalla);
            }
        }
    }

    public Cuadro obtenCuadro(final int x, final int y) {

        if (x < 0 || y < 0 || x >= this.ancho || y >= this.ancho) {
            return Cuadro.VACIO;
        }

        switch (this.cuadros[x + y * this.ancho]) {
            case 0:
                return Cuadro.ASFALTO;
            case 1:
            case 2:
            case 3:
            default:
                return Cuadro.VACIO;
        }
    }

}
