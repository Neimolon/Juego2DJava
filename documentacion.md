/* 1 y 2 
 * Creada clase principal del Juego:
 * -La clase extiende a Canvas
 * -Añadir variariables para identificacion y configuracion
 * -Añadir JFrame
 * -Añadir Constructor:
 * --Configurar dimensiones Canvas.
 * --Crear JFrame y configurar(Layout,añadir Canvas,etc...)
 */
 
 /*
 * 3
 *** 
 * Añadimos nuevo Thread
 * Implementar Runnable en clase Principal:
 * -implementar run()
 * Crear metodo iniciar 
 * -crear objeto Thread pasandole la clase "this" para que arranque el run() de esta clase.
 * -lanzar thread
 * Crear metodo detener
 * 
 * 4
 ***
 *Implementar bucle principal en run():
 *-Crear variable control funcionamiento como volatile para bloquear acceso simultaneo
 *-iniciar y detener como synchronized, setear la configuracion de variable funcionamiento
 *-desarrollar metodo detener:
 *--set enFuncionamient
 *--detener thread
 *
 * 5 
 ***
 * Crear metodos actualizar y mostrar y meter en el bucle
 * Temporizador:
 *  se crea variable delta logica para determinar el numero de veces que se actualiza la pantalla
 *  -->Explicacion: -Se fijan cuantas actualizaciones por segundo queremos que haya y se calcula el tiempo.
 *                  -La variable delta  es un coeficiente entre el tiempo transcurrido y el tiempo deseado
 *                  -Si el coeficiente es >=1(ha transcurrido el tiempo deseado) se lanza el metodo de actualizar
 *                  -Si el coeficiente es >1, en delta se guardan los milisegundos excedentes para descontarlos en la siguiente vuelta y ajustar los ciclos con mas precision
 * se crea un bucle que gira mientas delta sea >1 en el que se ejecuta mostrar() , que deberia corresponderse a las APS_OBJETIVO 
 * actualizar() sigue ejecutandose a velocidad máquina en el loop principal;
 * 
 *                    
 * Contador FPS:
 * se crea una variable de clase fps y otra aps
 * en mostrar() se incrementa fps en 1 cada llamada
 * en actualizar() se incrementa aps en 1 cada llamada 
 * en run() se crea la variable referenciaContador y se le asigna el calculo del tiempo correspondiente a un segundo
 * por cada vuelta de segundo se actualiza el titulo, mostrando FPS y APS
 * 
 */
 
 /*6 Hoja de Sprites:
 ***
 * -Creamos el paquete graficos
 * -Creamos la clase HojaSprites (que contendrá los recursos graficos)
 * -creamos las propiedades int ancho, int alto y int[] pixeles
 * -Creamos el constructor:
 * --el constructor acepta los valores ruta,acho y alto de la imagen.
 * --Creamos la variabe BufferedImage imagen
 * --Leemos el sprite y lo cargamos en la variable imagen (valiendonos de la clase ImageIO y BufferedImage)  
 * */
 
 /*7 Extrayebdo los sprites;
 *** 
 * 
 * Creamos la clase Sprite en el paquete graficos
 * Creamos el atributo lado(tamaño sprite dentro de la joha de strites)
 * Creamos los atributos x e y (guarda las posiciones del sprite en pixeles)
 * Creamos el atributo hoja para tener accesible la Hoja de Sprites de la que extraer el sprite
 * Creamos el array Pixeles para almacenar los pixeles extraidos
 * 
 * Creamos el constructos de Sprite:
 * -Inicializamos las variables
 * -Creamos un bucle que recorra el tamaño de un sprite y fuarde todos sus pixeles en el array de pixeles
 * 
 * */
 
 /* 8- Controles con el teclado
 ***
 * Creamos paquete control
 * Creamos clase Teclado en el paquete control
 * Implementamos KeyListener y sus métodos en Teclado(keyPressed,keyReleased,keyTyped)
 * Teclado:
 * -Creamos atributo numeroTeclas asignando el valor del codigo de caracter más alto a usar;
 * -Creamos un array de booleanos con tantas posiciones como numeroTeclas haya
 * -Creamos booleanos de los controles mas habituales(arriba,abajo,izquierda,derecha)
 * 
 * -Creamos metodo actualizar:
 * --se asignan a los controles(arriba,abajo...) el valor de las teclas (si esta pulsado o no)
 * 
 * -en keyPressed():
 * --obtenemos el valor de la tecla pulsada y lo marcamos a true en el array de booleanos en la posicion del codigo de la tecla pulsada
 * 
 * -en keyReleased():
 * --obtenemos el valor de la tecla pulsada y lo marcamos a false en el array de booleanos en la posicion del codigo de la tecla pulsada
 * 
 * */
 
 /*
 * 8 Cotroles de Teclado (en clase Juego)
 *** 
 * Creamos una propiedad Teclado para implementar los controles del teclado
 * 
 * En el constructor:
 * -inicializamos teclado
 * -Añadimos un keylistener al canvas (Juego) y le pasamos la clase Teclado (que implementa keyListener)
 * 
 * En actualizar():
 * -ejecutamos el método teclado.actualizar para actualizar el estado del teclado
 * -Añadimos una escalera de ifs ver si hay algun cambio en las acciones del usuario
 * 
 * En run():
 * -Fix: antes del bucle principal le decimos a la pantalla que tome el foco para que el usuario no tenga que clicar en ella
 * 
 */
 
 9 - Primer Sprite
 en /img
 Creamos Archivo gimp HojaSprites de 320x320 (10 filas y 10 columnas de 32x32px)
 Creamos Sprite asfalto 32x32