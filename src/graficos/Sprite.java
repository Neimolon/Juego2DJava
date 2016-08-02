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
    
    /*Constantes para las diferentes versiones de manipulacion de Sprites*/
    public static final int CLONAR = 0;
    public static final int INVERTIR_X = 1;
    public static final int INVERTIR_Y = 2;
    public static final int INVERTIR_XY = 3;
    public static final int ROTAR_90_IZDA = 4;
    public static final int ROTAR_90_DCHA = 5;
    public static final int ROTAR_90_IZDA_INVERTIR_Y = 6;
    public static final int ROTAR_90_DCHA_INVERTIR_Y = 7;

    /* Coleccion Sprites del Mapa jugador*/
    public static final Sprite JUGADOR_ABAJO_0 = new Sprite(32, 0, 0, CLONAR, HojaSprites.jugador);
    public static final Sprite JUGADOR_ABAJO_1 = new Sprite(32, 0, 1, CLONAR, HojaSprites.jugador);
    public static final Sprite JUGADOR_ABAJO_2 = new Sprite(32, 0, 2, CLONAR, HojaSprites.jugador);
    
    public static final Sprite JUGADOR_ARRIBA_0 = new Sprite(32, 1, 0, CLONAR, HojaSprites.jugador);
    public static final Sprite JUGADOR_ARRIBA_1 = new Sprite(32, 1, 1, CLONAR, HojaSprites.jugador);
    public static final Sprite JUGADOR_ARRIBA_2 = new Sprite(32, 1, 2, CLONAR, HojaSprites.jugador);
    
    public static final Sprite JUGADOR_DCHA_0 = new Sprite(32, 2, 0, CLONAR, HojaSprites.jugador);
    public static final Sprite JUGADOR_DCHA_1 = new Sprite(32, 2, 1, CLONAR, HojaSprites.jugador);
    public static final Sprite JUGADOR_DCHA_2 = new Sprite(32, 2, 2, CLONAR, HojaSprites.jugador);
    
    public static final Sprite JUGADOR_IZDA_0 = new Sprite(32, 3, 0, CLONAR, HojaSprites.jugador);
    public static final Sprite JUGADOR_IZDA_1 = new Sprite(32, 3, 1, CLONAR, HojaSprites.jugador);
    public static final Sprite JUGADOR_IZDA_2 = new Sprite(32, 3, 2, CLONAR, HojaSprites.jugador);
    /* Fin de la coleccion */

    /* Coleccion Sprites del Mapa desierto*/
    public static final Sprite VACIO = new Sprite(32, 0x000000);
    public static final Sprite ASFALTO = new Sprite(32, 0, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite ARENA = new Sprite(32, 1, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite BORDE_CARRETERA_IZDA = new Sprite(32, 2, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite BORDE_CARRETERA_DCHA = new Sprite(32, 2, 0, INVERTIR_X, HojaSprites.desierto);
    public static final Sprite BORDE_CARRETERA_ARRIBA = new Sprite(32, 2, 0, ROTAR_90_DCHA, HojaSprites.desierto);
    public static final Sprite BORDE_CARRETERA_ABAJO = new Sprite(32, 2, 0, ROTAR_90_DCHA_INVERTIR_Y, HojaSprites.desierto);
    public static final Sprite CENTRO_CARRETERA_VERTICAL = new Sprite(32, 3, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite CENTRO_CARRETERA_HORIZONTAL = new Sprite(32, 3, 0, ROTAR_90_DCHA, HojaSprites.desierto);
    public static final Sprite ESQUINA_CARRETERA_IZDA_ABAJO = new Sprite(32, 4, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite ESQUINA_CARRETERA_DCHA_ABAJO = new Sprite(32, 4, 0, ROTAR_90_IZDA, HojaSprites.desierto);
    public static final Sprite ESQUINA_CARRETERA_IZDA_ARRIBA = new Sprite(32, 4, 0, ROTAR_90_DCHA, HojaSprites.desierto);
    public static final Sprite ESQUINA_CARRETERA_DCHA_ARRIBA = new Sprite(32, 4, 0, INVERTIR_XY, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA = new Sprite(32, 5, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA_INFERIOR = new Sprite(32, 6, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA_CARRETERA_IZDA = new Sprite(32, 6, 1, CLONAR, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA_CARRETERA_DCHA = new Sprite(32, 6, 1, INVERTIR_X, HojaSprites.desierto);
    public static final Sprite PUERTA_SUPERIOR_IZQUIERDA = new Sprite(32, 7, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite PUERTA_SUPERIOR_DERECHA = new Sprite(32, 7, 0, INVERTIR_X, HojaSprites.desierto);
    public static final Sprite PUERTA_SUPERIOR_CENTRAL = new Sprite(32, 8, 0, CLONAR, HojaSprites.desierto);
    public static final Sprite PUERTA_INTERMEDIA_IZQUIERDA = new Sprite(32, 7, 1, CLONAR, HojaSprites.desierto);
    public static final Sprite PUERTA_INTERMEDIA_DERECHA = new Sprite(32, 7, 1, INVERTIR_X, HojaSprites.desierto);
    public static final Sprite PUERTA_INFERIOR = new Sprite(32, 7, 2, CLONAR, HojaSprites.desierto);
    public static final Sprite OXIDO = new Sprite(32, 9, 0, CLONAR, HojaSprites.desierto);
    
    public static final Sprite CARTEL_PUTIS_IZDA = new Sprite(32, 5, 9, CLONAR, HojaSprites.desierto);
    public static final Sprite CARTEL_PUTIS_DCHA = new Sprite(32, 6, 9, CLONAR, HojaSprites.desierto);
    public static final Sprite XAVIER = new Sprite(32, 9, 9, CLONAR, HojaSprites.desierto);

    /* Fin Coleccion */
    private final int lado;

    private int x;
    private int y;

    public Sprite(final int lado, final int color) {
        this.lado = lado;
        this.pixeles = new int[lado * lado];

        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = color;
        }
    }

    public Sprite(final int lado, final int columna, final int fila, final int version, final HojaSprites hoja) {
        this.hoja = hoja;
        this.lado = lado;

        pixeles = new int[lado * lado];

        this.x = columna * lado;
        this.y = fila * lado;

        cargarSprite(version);

    }

    public int obtenLado() {
        return lado;
    }

    private void cargarSprite(int version) {
        if (version == CLONAR) {
            cargaNormal();
        } else {
            cargaManipulada(version);
        }
    }

    private void cargaNormal() {
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];
            }
        }

    }

    private void cargaManipulada(int version) {
        int[] pixelesTemporales = iniciarPixelesTemporales();

        switch (version) {
            case INVERTIR_X:
                invertirX(pixelesTemporales);
                break;
            case INVERTIR_Y:
                invertirY(pixelesTemporales);
                break;
            case INVERTIR_XY:
                invertirXY(pixelesTemporales);
                break;
            case ROTAR_90_DCHA:
                rotarD90(pixelesTemporales);
                break;
            case ROTAR_90_IZDA:
                rotarI90(pixelesTemporales);
                break;
            case ROTAR_90_IZDA_INVERTIR_Y:
                rotarI90InvertirY(pixelesTemporales);
                break;
            case ROTAR_90_DCHA_INVERTIR_Y:
                rotarD90InvertirY(pixelesTemporales);
                break;
            default:
                cargaNormal();
        }

    }

    private int[] iniciarPixelesTemporales() {
        int[] pixelesTemporales = new int[lado * lado];

        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixelesTemporales[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];
            }
        }

        return pixelesTemporales;
    }

    //version 1
    private void invertirX(int[] pixelesTemporales) {
        int i = 0;

        for (int y = 0; y < lado; y++) {
            for (x = lado - 1; x >= 0; x--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }

    }

    //version 2
    private void invertirY(int[] pixelesTemporales) {
        int i = 0;

        for (int y = lado; y >= 0; y--) {
            for (x = 0; x > lado; x++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
        
    }

    //version 3
    private void invertirXY(int[] pixelesTemporales) {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = pixelesTemporales[pixelesTemporales.length -1 -i];
        }    
    }

    //version 4
    private void rotarI90(int[] pixelesTemporales) {      
        int i = 0;       
        for (x = lado - 1; x >= 0; x--) {
            for (int y = 0; y < lado; y++) {      
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
        
    }

    //version 5
    private void rotarD90(int[] pixelesTemporales) {
        int i = 0;
        for (x = 0; x <  lado; x++) {
            for (int y = lado - 1; y >= 0; y--) {      
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //version 6
    private void rotarI90InvertirY(int[] pixelesTemporales) {
        int i = 0;
        
        for (x = 0; x < lado; x++) {
            for (int y = 0; y < lado; y++) {      
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
        
    }

    //version 7
    private void rotarD90InvertirY(int[] pixelesTemporales) {
        int i = 0;
        
        for (x = lado -1; x >= 0; x--) {
            for (int y = lado - 1; y >= 0 ; y--) {      
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
        
    }

}
