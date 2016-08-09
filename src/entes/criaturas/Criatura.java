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
        
        //ajustar estos valores a mi sprite de jugador
        int margenIzquierdo = 0;
        int margenDerecho = 0;
        int margenSuperior = 0;
        int margenInferior = 0;
        
        int bordeIzquierdo = (posicionX + margenDerecho) / sprite.obtenLado();
        int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.obtenLado();
        int bordeSuperior = (posicionY + margenInferior) / sprite.obtenLado();
        int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.obtenLado();

/*   FIX: Una de estas busquedas en el array de posiciones sobrepasa los limites del tamaño del cuadro de catálogo, algo hay mal
        
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
*/
        return colision;
    }
    
    public Sprite obtenSprite(){
        return this.sprite;
    }
    
}
