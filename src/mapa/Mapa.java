package mapa;

import graficos.Pantalla;

/*
19 Generar mapas al azar 
 ***
en Mapa:

Cambiamos a protected las propiedades alto,ancho y cuadros para que estén en el alcance de las clases heredadas
Cambiamos a protected el metodo generarMapa para que estén en el alcance de las clases heredadas
*/

public abstract class Mapa {
    protected int alto;
    protected int ancho;
    
    protected int[] cuadros;
    
    public Mapa(int ancho,int alto){
        this.ancho = ancho;
        this.alto = alto;
        
        this.cuadros = new int[ancho * alto];
        
        this.generarMapa();
               
    }
    
    public Mapa(String ruta){
        this.generarMapa(ruta);

    }

    protected void generarMapa(){
    
    }
    
    private void generarMapa(String ruta){
    
    }
    
    
    public void actualizar(){
    
    }
    
    public void mostrar(int compensacionX,int compensacionY, Pantalla pantalla ){
    
    }
    
}
