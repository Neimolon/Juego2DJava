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
    
    private boolean solido;

    /*Coleccion cuadros*/
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO,true);
    public static final Cuadro ASFALTO = new Cuadro(Sprite.ASFALTO);
    public static final Cuadro ARENA = new Cuadro(Sprite.ARENA);
    public static final Cuadro BORDE_CARRETERA = new Cuadro(Sprite.BORDE_CARRETERA_IZDA);
    public static final Cuadro BORDE_CARRETERA_DERECHA = new Cuadro(Sprite.BORDE_CARRETERA_DCHA);
    public static final Cuadro BORDE_CARRETERA_ARRIBA = new Cuadro(Sprite.BORDE_CARRETERA_ARRIBA);
    public static final Cuadro BORDE_CARRETERA_ABAJO = new Cuadro(Sprite.BORDE_CARRETERA_ABAJO);
    public static final Cuadro CENTRO_CARRETERA = new Cuadro(Sprite.CENTRO_CARRETERA_VERTICAL);
    public static final Cuadro CENTRO_CARRETERA_HORIZONTAL = new Cuadro(Sprite.CENTRO_CARRETERA_HORIZONTAL);
    public static final Cuadro ESQUINA_CARRETERA = new Cuadro(Sprite.ESQUINA_CARRETERA_IZDA_ABAJO);
    public static final Cuadro ESQUINA_CARRETERA_DERECHA = new Cuadro(Sprite.ESQUINA_CARRETERA_DCHA_ABAJO);
    public static final Cuadro ESQUINA_CARRETERA_ARRIBA = new Cuadro(Sprite.ESQUINA_CARRETERA_IZDA_ARRIBA);
    public static final Cuadro ESQUINA_CARRETERA_ARRIBA_DERECHA = new Cuadro(Sprite.ESQUINA_CARRETERA_DCHA_ARRIBA);
    //marcados como solidos para probar
    public static final Cuadro PARED_PIEDRA = new Cuadro(Sprite.PARED_PIEDRA);
    public static final Cuadro PARED_PIEDRA_INFERIOR = new Cuadro(Sprite.PARED_PIEDRA_INFERIOR);
    public static final Cuadro PARED_PIEDRA_CARRETERA = new Cuadro(Sprite.PARED_PIEDRA_CARRETERA_IZDA);
    public static final Cuadro PARED_PIEDRA_CARRETERA_INVERTIDA_X = new Cuadro(Sprite.PARED_PIEDRA_CARRETERA_DCHA);
    public static final Cuadro PUERTA_SUPERIOR_IZQUIERDA = new Cuadro(Sprite.PUERTA_SUPERIOR_IZQUIERDA);
    public static final Cuadro PUERTA_SUPERIOR_DERECHA = new Cuadro(Sprite.PUERTA_SUPERIOR_DERECHA);
    public static final Cuadro PUERTA_SUPERIOR_CENTRAL = new Cuadro(Sprite.PUERTA_SUPERIOR_CENTRAL);
    public static final Cuadro PUERTA_INTERMEDIA_IZQUIERDA = new Cuadro(Sprite.PUERTA_INTERMEDIA_IZQUIERDA);
    public static final Cuadro PUERTA_INTERMEDIA_DERECHA = new Cuadro(Sprite.PUERTA_INTERMEDIA_DERECHA);
    public static final Cuadro OXIDO = new Cuadro(Sprite.OXIDO);
    public static final Cuadro PUERTA_INFERIOR = new Cuadro(Sprite.PUERTA_INFERIOR);
    
    public static final Cuadro CARTEL_PUTIS_IZDA = new Cuadro(Sprite.CARTEL_PUTIS_IZDA);
    public static final Cuadro CARTEL_PUTIS_DCHA = new Cuadro(Sprite.CARTEL_PUTIS_DCHA);
    public static final Cuadro XAVIER = new Cuadro(Sprite.XAVIER);

    /*fin coleccion cuadros*/
    public Cuadro(Sprite sprite) {
        this.sprite = sprite;
        this.solido = false;

    }
    
    public Cuadro(Sprite sprite, boolean solido){
        this.sprite = sprite;
        this.solido = solido;

    }

    public void mostrar(int x, int y, Pantalla pantalla) {
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }

    public boolean esSolido() {
        return solido;
    }
}
