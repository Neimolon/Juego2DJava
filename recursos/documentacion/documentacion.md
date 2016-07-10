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
 
 
 /*10 Clase Pantalla:
 * -Creamos propiedades ancho y alto así como el array de pixeles[ancho * alto]
 * 
 * -Creamos Constructor:
 * --inicializamos las propiedades
 * 
 * -Creamos metodo limpiar:
 * --Pone a 0(negro) todo el array de pixeles
 * 
 * -Creamos metodo mostrar:
 * --Recorremos todos los pixeles del ancho y del alto sumandole la compensacion(movimiento del teclado)
 * --Comprobamos que el valor del pixel no esté fuera de la pantalla 
 */
 
 
/*11 Gráfico en pantalla - CAPITULO IMPORTANTE (Explicacion de como pintar pintar imagenes en un canvas a traves de un buffer )
***
*Cambiamos el nombre del directorio de imágenes por recursos/texturas
*Incluimos el directorio en el Java Build Path
*
* *En HojaSprites:
*-Creamos la propiedad HojaSprites como estática y la inicializamos 
*
* 
*En Sprite:
*-Creamos la propiedad Sprite asfalto y la inicializamos 
*
* 
* REMEMBER:Ojito al escribir los putos signos de comparacion! 1h de debug por un > cambiado!!!!!!
*
*Solo temporalmente:
*-Creamos variables lado_sprite y máscara sprite
*
*-en mostrar:
*--asignamos al array de pixeles de la pantalla los pixeles del Sprite que nos interesa de la siguiente forma:
*---pixeles[posicionX + posicionY * this.ancho] = Sprite.asfalto.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE];
*
*--->Explicamos porque es interesante:
*---MASCARA_SPRITE tiene el el valor (tamaño del sprite(LADO_SPRITE) - 1)
*---(posicionX + posicionY * this.ancho)  y  ((x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE) es equivalente
*---   MASCARA_SPRITE  -> int pix 31 ->     011111 en binario
*---   x o y en bucle  ->         32 ->  &  100000 en binario (valor en el que se superaría el rango de posiciones en el array)
*---                                     =  000000 -> despues de recorrer 32 valores (0 a 31), el bucle vuelve a la posicion inicial
*                                                     sin que tengamos que hacer ifs o sumas, se aumenta el rendimiento.
*
*en Juego:
* -creamos dos propiedades int "x" y la "y".
* -creamos propiedad Pantalla pantalla
* -creamos propiedad BufferedImage imagen y lo inicializamos
* -creamos int[]pixeles y lo cargamos con el contenido de imagen(despues de extraerlo con unos metodos esotericos):
* -->Explicaciones esotericas:
* --- imagen.getRaster() devuelve el raster que es la secuencia de pixels, .getDataBuffer devuelve un buffer con esa secuencia, hacemos un cast a DataBufferInt para porder llamar a getData() y obtener el array de pixeles;
* 
* en el constructor:
* -Inicializamos Pantalla pantalla
* 
* en el metodo mostrar()
* -si no existe se crea una estrategia para pintar graficos en el canvas (un objeto BufferStrategy con 3 buffers,)
* -->Explicacion:Este objeto reserva espacio de memoria para 3 buffers que se cargaran desde la CPU antes de ser mostrados en la pantalla.
* -se limpia el array de pixeles del objeto pantalla y se deja en negro
* -se carga el array de pixeles del objeto pantalla 
* -se copia el array de pixels del objeto pantalla al array de pixeles del objeto juego
* -obtenemos un objeto graphics a traves del objeto estrategia
* -cargamos la imagen en el objeto estrategia a través de objeto graphics.drawImage()
* -una vez cargada la imagen la liberamos del objeto graphics con dispose()
* -se imprime el buffer en el canvas con estrategia.show();
* 
* en el método actualizar();
* -en los ifs que detectan las pulsaciones de teclado incrementamos o decremantamos las variables x e y dependiendo de la accion detectada.
* ->Explicacion:
* --al cambiar estos valor se cambia en cada actualizacion del juego los parametros de compensacion que recibe el método mostrar(CompensacionX,compensacionY) 
* --del objeto pantalla, produciendo un offset en las posiciones del array de pixeles de la pantalla en donde son copiados los pixeles recibidos
* --desde el sprite que estamos imprimiendo. De esta forma se despla la posicion donde se empieza a imprimir nuestro dondo dando sensacion
* --de que el centro se está moviendo 
*/
 
 12 - Estudiando el Rendimiento.
 Basicamente recomienda usar un profiler como Java Mission Control
 Ademas explica como exportar un jar ejecutable
 
 /*
 * 13 Icono de la ventana
 *
 *Este episodo es principalmente una practica de photoshop, en mi caso de gimp
 *
 * en Juego:
 * creamos la propiedad icono de la clase ImageIcon y la cargamos desde la libreria de imagenes
 * 
 *  en el Constructor:
 *  -llamamos al JFrame y le decimos setImageIcon(icono);
 */
 
 14- Explicaciones chorras sobre debuggin
 
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

/*Creamos la clase abstracta Cuadro:
 ***

Creamos las propiedades de posicion int x e y, y la propiedad sprite

Creamos el constructor:
-Inicializamos x e y
-Inicializamos el sprite

creamos metodo mostrar(se le pasan las posiciones y un objeto pantalla)

creamos el metodo solido(nos dice si el cuadro se puede atravesar por el personaje)

*/ 

/* 17 Creacion de tiles
Creamos la clase CuadroAsfalto: -> que extiende la clase Cuadro y a la que se le pasa el sprite correspondiente a lo que se quiera dibujar

-Creamos el constructor CuadroAsfalto(sprite):
--se inicializa el sprite del padre

-creamos el metodo mostrar(x,y,pantalla)

*/

/* 17 Coleccion de Tiles (tiles de los cuadros que conformarán el mapa) - En clase Cuadro
***
Añadimos un espacio para la coleccion de cuadros
Creamos la propiedad estatica Cuadro con una instancia de CuadroAlfalto (cuadro es abstracto y no se puede instanciar)

*/