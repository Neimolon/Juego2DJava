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
    public static final Sprite ASFALTO = new Sprite(32, 0, 0, 0, HojaSprites.desierto);
    public static final Sprite ARENA = new Sprite(32, 1, 0, 0, HojaSprites.desierto);
    public static final Sprite BORDE_CARRETERA = new Sprite(32, 2, 0, 0, HojaSprites.desierto);
    public static final Sprite CENTRO_CARRETERA = new Sprite(32, 3, 0, 0, HojaSprites.desierto);
    public static final Sprite ESQUINA_CARRETERA = new Sprite(32, 4, 0, 0, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA = new Sprite(32, 5, 0, 0, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA_INFERIOR = new Sprite(32, 6, 0, 0, HojaSprites.desierto);
    public static final Sprite PARED_PIEDRA_CARRETERA = new Sprite(32, 6, 1, 0, HojaSprites.desierto);
    public static final Sprite PUERTA_SUPERIOR_IZQUIERDA = new Sprite(32, 7, 0, 0, HojaSprites.desierto);
    public static final Sprite PUERTA_SUPERIOR_CENTRAL = new Sprite(32, 8, 0, 0, HojaSprites.desierto);
    public static final Sprite PUERTA_INTERMEDIA_IZQUIERDA = new Sprite(32, 7, 1, 0, HojaSprites.desierto);
    public static final Sprite PUERTA_INFERIOR = new Sprite(32, 7, 2, 0, HojaSprites.desierto);
    public static final Sprite OXIDO = new Sprite(32, 9, 0, 0, HojaSprites.desierto);

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
        if (version == 0) {
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
            case 1:
                invertirX(pixelesTemporales);
                break;
            case 2:
                invertirY(pixelesTemporales);
                break;
            case 3:
                invertirXY(pixelesTemporales);
                break;
            case 4:
                rotarD90(pixelesTemporales);
                break;
            case 5:
                rotarI90(pixelesTemporales);
                break;
            case 6:
                rotarI90InvertirI(pixelesTemporales);
                break;
            case 7:
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
            i++;
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
    private void rotarI90InvertirI(int[] pixelesTemporales) {
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
