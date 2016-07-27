package mapa;

import graficos.Pantalla;

/*
20 Lados del mapa
 ***
en Mapa:
-en metodo mostrar:
--creamos las variables n,s,e,o para fijar los limites del mapa


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
        int o = compensacionX >> 5;  //BitShifting de 5 bits, equivale a dividir por 32
        int e = (compensacionX + pantalla.obtenAncho()) >> 5;
        int n = compensacionY >> 5;
        int s = (compensacionY + pantalla.obtenAlto()) >> 5;
    }
    
}
