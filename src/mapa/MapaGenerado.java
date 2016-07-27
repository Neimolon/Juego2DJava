/*
19 Generar mapas al azar 
***


Creamos la clase MapaGenerado extendiendo Mapa:
-creamos la propiedad Random aleatorio y e instanciamos el objeto

-sobreescribimos el constructor MapaGenerado(alto,ancho) 
--inicializando las propiedades en el padre

-creamos el metodo generarMapa:
--for anidado que recorre el ancho y el alto 
--asignamos un valor aleatorio entre 1 y 3 en cada cuadro del array de cuadros del mapa (asignaremos a cada cuadro que tengamos un identificador correspondiente a estos numeros)

 */
package mapa;

import java.util.Random;

/**
 *
 * @author diego
 */
public class MapaGenerado extends Mapa{
    private final Random aleatorio = new Random();
    
    public MapaGenerado(int ancho, int alto) {
        super(ancho, alto);
    }
    

    @Override
    protected void generarMapa(){
        for(int y = 0; y < this.alto; y++){
            for(int x = 0; x < this.ancho; x++){
                this.cuadros[x + y * ancho] = aleatorio.nextInt(3);
            }
        }
    }
    
    
    
}
