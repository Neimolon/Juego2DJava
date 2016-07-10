package mapa.cuadro;

/*Creamos la clase abstracta Cuadro:
 ***

Creamos las propiedades de posicion int x e y, y la propiedad sprite

Creamos el constructor:
-Inicializamos x e y
-Inicializamos el sprite

creamos metodo mostrar(se le pasan las posiciones y un objeto pantalla)

creamos el metodo solido(nos dice si el cuadro se puede atravesar por el personaje)

*/
import graficos.Pantalla;
import graficos.Sprite;

public abstract class Cuadro {
    public int x;
    public int y;
    
    public Sprite sprite;
    
    public Cuadro(Sprite sprite){
        this.sprite = sprite;
        
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
    
    }
    
    public boolean solido(){
        return false;
    }
}
