package mapa.cuadro;
/* 17 Creacion de tiles
Creamos la clase CuadroAsfalto: -> que extiende la clase Cuadro y a la que se le pasa el sprite correspondiente a lo que se quiera dibujar

-Creamos el constructor CuadroAsfalto(sprite):
--se inicializa el sprite del padre

-creamos el metodo mostrar(x,y,pantalla)

*/
import graficos.Pantalla;
import graficos.Sprite;

public class CuadroAsfalto extends Cuadro{
    
    public CuadroAsfalto(Sprite sprite) {
        super(sprite);
    }

    public void mostrar(int x,int y, Pantalla pantalla){
    
    }    

    
}
