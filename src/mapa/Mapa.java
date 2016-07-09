package mapa;

import graficos.Pantalla;

/**
 * 15 Introduccion a a los mapas
 ***
 * 
 * Creamos la clase abstracta Mapa:
 *
 * -creamos las propiedades int alto y ancho y un array int cuadros[]
 * -reamos dos constructores:
 * 
 * --Mapa(ancho,alto) -> Para cuando vallamos a generar nosotros el mapa automaticamente
 * ---Inicializamos alto,ancho y el array mapa
 * ---Llamamos al metodo generarMapa();
 * 
 * --Mapa(String ruta)->Se llamará cuando carguemos un mapa previamente  creado en una ruta
 * ---Inicializamos alto,ancho y el array mapa
 * ---Llamamos al metodo generarMapa(ruta);
 * 
 * -creamos los metodos generarMapa(),generarMapa(ruta),mostrar(), actualzar();
 */

public abstract class Mapa {
    private int alto;
    private int ancho;
    
    private int[] cuadros;
    
    public Mapa(int ancho,int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        this.cuadros = new int[ancho * alto];
        
        this.generarMapa();
               
    }
    
    public Mapa(String ruta){
        this.generarMapa(ruta);

    }

    private void generarMapa(){
    
    }
    
    private void generarMapa(String ruta){
    
    }
    
    
    public void actualizar(){
    
    }
    
    public void mostrar(int compensacionX,int compensacionY, Pantalla pantalla ){
    
    }
    
}
