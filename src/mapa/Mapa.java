package mapa;

import graficos.Pantalla;
import graficos.Sprite;
import mapa.cuadro.Cuadro;

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
    protected Cuadro[] cuadrosCatalogo;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        this.cuadros = new int[ancho * alto];

        generarMapa();

    }

    public Mapa(String ruta) {
        cargarMapa(ruta);
        generarMapa();

    }

    protected void generarMapa() {

    }

    protected void cargarMapa(String ruta) {

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
                //this.obtenCuadro(x, y).mostrar(x, y, pantalla);
                if(x < 0 || y < 0 || x >= ancho || y >= alto){
                    Cuadro.VACIO.mostrar(x, y, pantalla);
                }else{
                    cuadrosCatalogo[x + y * ancho].mostrar(x, y, pantalla);
                }
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
                return Cuadro.ARENA;
            case 2:
                return Cuadro.BORDE_CARRETERA;
            case 3:
                return Cuadro.CENTRO_CARRETERA;
            case 4:
                return Cuadro.ESQUINA_CARRETERA;
            case 5:
                return Cuadro.PARED_PIEDRA;
            case 6:
                return Cuadro.PARED_PIEDRA_INFERIOR;
            case 7:
                return Cuadro.PARED_PIEDRA_CARRETERA;
            case 8:
                return Cuadro.PUERTA_SUPERIOR_IZQUIERDA;
            case 9:
                return Cuadro.PUERTA_INTERMEDIA_IZQUIERDA;
            case 10:
                return Cuadro.PUERTA_INFERIOR;
            case 11:
                return Cuadro.OXIDO;
            case 12:
                return Cuadro.PUERTA_SUPERIOR_CENTRAL;
            default:
                return Cuadro.VACIO;
        }
    }
    
    public Cuadro obtenerCuadroCatalogo(int posicion){
        System.out.println("Posicion Cuadros Adyacentes: "+posicion);

        if(posicion > 0 && posicion < cuadrosCatalogo.length){
            return cuadrosCatalogo[posicion];
        }else{
            return Cuadro.VACIO;
        }
        
    }

    public int obtenerAncho(){
        return ancho;
    }
}
