package entes;

import mapa.Mapa;

/**
 *
 * @author diego
 */
public abstract class Ente {
    protected int x;
    protected int y;
    
    private boolean eliminado = false;
    
    protected Mapa mapa;
    
    public void actualizar(){};
    
    public void mostrar(){};
    
    public void eliminar(){
        this.eliminado = true;
    }

    public int obtenerPosicionX() {
        return x;
    }

    public int obtenerPosicionY() {
        return y;
    }
    
    public void modificarPosicionX(int desplazamientoX){
        this.x += desplazamientoX;
    }
    
    public void modificarPosicionY(int desplazamientoY){
        this.y += desplazamientoY;
    }
    
    

    public boolean estaEliminado() {
        return eliminado;
    }


    
}
