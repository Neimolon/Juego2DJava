package mapa.cuadro;

/* 17 Coleccion de Tiles (tiles de los cuadros que conformarán el mapa)
***
Añadimos un espacio para la coleccion de cuadros
Creamos la propiedad estatica Cuadro con una instancia de CuadroAlfalto (cuadro es abstracto y no se puede instanciar)

*/
import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {
    public static int LADO = 32;
    
    public int x;
    public int y;
    
    
    public Sprite sprite;
    
    /*Coleccion cuadros*/
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
    public static final Cuadro ASFALTO = new Cuadro(Sprite.ASFALTO);
    public static final Cuadro ARENA = new Cuadro(Sprite.ARENA);
    public static final Cuadro BORDE_CARRETERA = new Cuadro(Sprite.BORDE_CARRETERA);
    public static final Cuadro CENTRO_CARRETERA = new Cuadro(Sprite.CENTRO_CARRETERA);
    public static final Cuadro ESQUINA_CARRETERA = new Cuadro(Sprite.ESQUINA_CARRETERA);
    public static final Cuadro PARED_PIEDRA = new Cuadro(Sprite.PARED_PIEDRA);
    public static final Cuadro PARED_PIEDA_INFERIOR = new Cuadro(Sprite.PARED_PIEDA_INFERIOR);
    public static final Cuadro PARED_PIEDRA_CARRETERA = new Cuadro(Sprite.PARED_PIEDRA_CARRETERA);
    public static final Cuadro PUERTA_SUPERIOR_IZQUIERDA = new Cuadro(Sprite.PUERTA_SUPERIOR_IZQUIERDA);
    public static final Cuadro PUERTA_SUPERIOR_CENTRAL = new Cuadro(Sprite.PUERTA_SUPERIOR_CENTRAL);
    public static final Cuadro PUERTA_INTERMEDIA_IZQUIERDA = new Cuadro(Sprite.PUERTA_INTERMEDIA_IZQUIERDA);
    public static final Cuadro OXIDO = new Cuadro(Sprite.OXIDO);
    public static final Cuadro PUERTA_INFERIOR = new Cuadro(Sprite.PUERTA_INFERIOR);
    
    /*fin coleccion cuadros*/
    
    public Cuadro(Sprite sprite){
        this.sprite = sprite;
        
    }

    public void mostrar(int x,int y, Pantalla pantalla){
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }  
    public boolean solido(){
        return false;
    }
}
