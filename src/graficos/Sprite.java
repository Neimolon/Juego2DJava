package graficos;

/*11 Gráfico en pantalla;
 *** 
 * 
 *En Sprite:
 *-Creamos la propiedad Sprite asfalto y la inicializamos 
 *
 * 
 * */
public final class Sprite {

    public int[] pixeles;

    private HojaSprites hoja;

    /* Coleccion Sprites */
    public static final Sprite VACIO = new Sprite(32, 0x000000);
    public static final Sprite ASFALTO = new Sprite(32, 0, 0, HojaSprites.desierto); 
    public static final Sprite ARENA = new Sprite(32, 1, 0, HojaSprites.desierto);
    public static final Sprite BORDE_CARRETERA = new Sprite(32, 2, 0, HojaSprites.desierto);
    public static final Sprite CENTRO_CARRETERA = new Sprite(32, 3, 0, HojaSprites.desierto);
    public static final Sprite ESQUINA_CARRETERA = new Sprite(32, 4, 0, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA = new Sprite(32, 5, 0, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA_INFERIOR = new Sprite(32, 6, 0, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA_CARRETERA = new Sprite(32, 6, 1, HojaSprites.desierto);
    public static final Sprite PUERTA_SUPERIOR_IZQUIERDA = new Sprite(32, 7, 0, HojaSprites.desierto);
    public static final Sprite PUERTA_SUPERIOR_CENTRAL = new Sprite(32, 8, 0, HojaSprites.desierto);
    public static final Sprite PUERTA_INTERMEDIA_IZQUIERDA = new Sprite(32, 7, 1, HojaSprites.desierto);
    public static final Sprite PUERTA_INFERIOR = new Sprite(32, 7, 2, HojaSprites.desierto);
    public static final Sprite OXIDO = new Sprite(32, 9, 0, HojaSprites.desierto);
    
    /* Fin Coleccion */

    private final int lado;

    private  int x;
    private  int y;
    
    public Sprite(final int lado, final int color){
        this.lado = lado;
        this.pixeles = new int[lado * lado];
        
        for(int i = 0; i<pixeles.length;i++){
            pixeles[i] = color;
        }
    }
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
        this.hoja = hoja;
        this.lado = lado;

        pixeles = new int[lado * lado];

        this.x = columna * lado;
        this.y = fila * lado;

        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];
            }
        }

    }
    
    public int obtenLado() {
        return lado;
    }

}
