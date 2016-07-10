package mapa.cuadro;

/* 17 Coleccion de Tiles (tiles de los cuadros que conformarán el mapa)
***
Añadimos un espacio para la coleccion de cuadros
Creamos la propiedad estatica Cuadro con una instancia de CuadroAlfalto (cuadro es abstracto y no se puede instanciar)

*/
import graficos.Pantalla;
import graficos.Sprite;

public abstract class Cuadro {
    public int x;
    public int y;
    
    public Sprite sprite;
    
    /*Coleccion cuadros*/
    public static final Cuadro ASFALTO = new CuadroAsfalto(Sprite.ASFALTO);
    
    /*fin coleccion cuadros*/
    
    public Cuadro(Sprite sprite){
        this.sprite = sprite;
        
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
    
    }
    
    public boolean solido(){
        return false;
    }
}
