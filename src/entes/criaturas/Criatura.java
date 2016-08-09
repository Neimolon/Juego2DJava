package entes.criaturas;

import entes.Ente;
import graficos.Sprite;

/**
 *
 * @author diego
 */
public abstract class Criatura extends Ente{
    protected Sprite sprite;
    protected char direccion = 'n';
    protected boolean enMovimiento = false;
    
    @Override
    public void actualizar(){
    
    }
    
    @Override
    public void mostrar(){
    
    }
    
    public void mover(int desplazamientoX, int desplazamientoY){
    
        if(desplazamientoX > 0){
            direccion = 'e';
        }
        if(desplazamientoX < 0){
            direccion = 'o';
        }
        if(desplazamientoY > 0){
            direccion = 's';
        }
        if(desplazamientoY < 0){
            direccion = 'n';
        }
        
        if(!estaEliminado()){
            if(!enColision(desplazamientoX, 0)){
                modificarPosicionX(desplazamientoX);
            }
            
            if(!enColision(0, desplazamientoY)){
                modificarPosicionY(desplazamientoY);
            }
        }

    }
    
    private boolean enColision(int desplazamientoX, int desplazamientoY){
        boolean colision = false;
        
        
        int posicionX = x + desplazamientoX;
        int posicionY = y + desplazamientoY;
        
        
        //aire del sprite del jugador
        int margenIzquierdo = -6;
        int margenDerecho = 18;
        int margenSuperior = -4;
        int margenInferior = 31;
        
        int bordeIzquierdo = (posicionX + margenDerecho) / sprite.obtenLado();
        int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.obtenLado();
        int bordeSuperior = (posicionY + margenInferior) / sprite.obtenLado();
        int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.obtenLado();

    //algo raro pasa aqui
        if(mapa.obtenerCuadroCatalogo(bordeIzquierdo + bordeSuperior * mapa.obtenerAncho()).esSolido()){
            colision = true;
        }
        
        if(mapa.obtenerCuadroCatalogo(bordeIzquierdo + bordeInferior * mapa.obtenerAncho()).esSolido()){
            colision = true;
        }
        
        if(mapa.obtenerCuadroCatalogo(bordeDerecho + bordeSuperior * mapa.obtenerAncho()).esSolido()){
            colision = true;
        }
        
        if(mapa.obtenerCuadroCatalogo(bordeDerecho + bordeInferior * mapa.obtenerAncho()).esSolido()){
            colision = true;
        }
        //Raro raro
        

        return colision;
    }
    
    public Sprite obtenSprite(){
        return this.sprite;
    }
    
}
