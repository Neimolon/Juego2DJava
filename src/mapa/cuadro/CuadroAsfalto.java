package mapa.cuadro;
/* 18 Mostrar tiles

    (este metodo está pensado para los cuadros estaticos, los que conformarían el fondo del mapa)
    en el metodo heredado mostrar(x,y,pantalla):
        llama al metodo mostrar de pantalla pasando this para que los pixeles del sprite de este cuadro se copien a la pantalla
*/
import graficos.Pantalla;
import graficos.Sprite;

public class CuadroAsfalto extends Cuadro{
    
    public CuadroAsfalto(Sprite sprite) {
        super(sprite);
    }

    public void mostrar(int x,int y, Pantalla pantalla){
        pantalla.mostrarCuadro(x, y, this);
    }    

    
}
