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



/*18 Mostrar Tiles:
***
En Pantalla:
Explicaciones: mostrar actualmente está para comprobar que se muestren las imagenes correctamente, proximamente la 
idea será que los cuadros se dibujen a si mismos llamando el metodo pantalla.mostrar desde su propio metodo mostrar

creamos funcion mostrarCuadro(compensacionX,compensacionY,cuadro) -> La que reemplazara la funcion mostrar
-creamos un doble bucle con el largo de las dimensiones del cuadro
-calculamos los valores x e y mas su compensacion para conseguir el movimiento
-hacemos la comprobacion de que no se dibuje fuera de la pantalla
-copiamos los pixeles del cuadro a la pantalla


En CuadroAsfalto:
(este metodo está pensado para los cuadros estaticos, los que conformarían el fondo del mapa)
en el metodo heredado mostrar(x,y,pantalla):
    llama al metodo mostrar de pantalla pasando this para que los pixeles del sprite de este cuadro se copien a la pantalla
*/


/*
19 Generar mapas al azar 
 ***
en Mapa:

Cambiamos a protected las propiedades alto,ancho y cuadros para que estén en el alcance de las clases heredadas
Cambiamos a protected el metodo generarMapa para que estén en el alcance de las clases heredadas

En MapaGenerado:
Creamos la clase MapaGenerado extendiendo Mapa:
creamos la propiedad Random aleatorio y e instanciamos el objeto
-sobreescribimos el constructor MapaGenerado(alto,ancho) 
--inicializando las propiedades en el padre

-creamos el metodo generarMapa:
--for anidado que recorre el ancho y el alto 
--asignamos un valor aleatorio entre 1 y 3 en cada cuadro del array de cuadros del mapa (asignaremos a cada cuadro que tengamos un identificador correspondiente a estos numeros)
 
*/


20 Lados del mapa

en Mapa:
***
en metodo mostrar:
-creamos las variables n,s,e,o para fijar los limites del mapa

en Pantalla:
***
Creamos getter para ancho y alto

21 - Explicaciones de BitShifting

22 - Asignacion de Tiles
Crearemos un mecanismo que permita obtener los diferentes tiles(cuadros) que componen el mapa, ya que ahora mismo solo se esta imprimiendo el cuadro de Asfalto

En Mapa(que es abstracta):
-creamos la funcion obtenCuadro(x,y):
--escribimos un switch que mira el valor que hay en el array de cuadros del mapa para una posicion dada y devuelve el cuadro correspondiente al valor de la posicion

Como solo existe el cuadro de asfalto necesitaremos crear nuevos tiles(cuadros), en este caso el cuadro vacío que delimitrá el mapa.

En Cuadro:
-Añadimos a la coleccion de cuadros el CuadroVacio

Creamos la clase CuadroVacio que extiende Cuadro:
*habra que evitar la redundancia de escribir el mismo codigo en todas las clases que conforman la coleccion de cuadros (para mas adelante)
-se crea el constructor que inicializa el sprite del padre
-se crea el metodo mostrar() que imprime el cuadro en la pantalla

La clase cuadroVacío necesitará un sprite 

en Sprite:
-Añadimos un nuevo constructor(lado,color):(para colores, ya que estos cuadros del borde no nos interesa sacarlos de la hoja de texturas, sino)
--iniciamos lado
--iniciamos pixeles
--bucle for que recorra los pixeles y les asigne el valor del color correspondiente

-Añadimos la propiedad Sprite vacio a la coleccion de sprites y lo inicializamos con el nuevo contructor

23 - Graficos Mejorados

Vamos a encadenar el codigo desarrollado para generar los mapas en vez de mostrar el sprite de Asfalto:

en Pantalla:
***
-Borramos el codigo marcado como temporal( metodo mostrar() y constantes mascara y lado sprite)
-creamos propiedades diferenciaX e diferenciaY (controlar movimiento del personaje para dibujar solo los sprites correspondientes a la pantalla y no todo el mapa)
-creamos metodo setter estableceDiferencia(x,y) que setea las variables del objeto

-en metodo mostrarCuadro(compensacionX,compensacionY,pantalla):
--restamos a compensacionX y a compensacionY la diferenciaX e diferenciaY 

en Mapa:
***
-en metodo mostrar(compensacionX,compensacionY,pantalla):
--añadimos un for anidado que recorre los cuadrados(32px) de este a oeste y de norte a sur, dentro del for se obtiene el cuadro que se 
  debe mostrar y se llama al metodo mostrar del cuadro para que se imprima en la posicion que corresponde
--añadimos una llamada al metodo pantalla.establecerDiferencia(x,y) para que cada vez que el juego muestre el mapa, el mapa le diga a la pantalla cuanto ha de desplazarse


en CuadroAsfalto y CuadroVacío
***
--quitamos el metodo mostrar (y lo vamos a mover a la clase padre, ya que será similar para todos los descendientes)

en Cuadro:
***
--añadimos el metodo mostrar:
---se llama al metodo pantalla.mostrar(x << 5,y<<5,this)
---* es el metodo tal cual lo tenia en las clases descendientes, con un bitshiftin de 5 bits a la izquierda (x32),
     para corregir el bitshifting que se hacia en mapa para calcular el salto de cuadros

en MapaGenerado:
***
-cambiamos la propiedad aleatorio a estatica
*Se genera un crash si no

en Juego:
***
-añadimos la propiedad mapa Mapa

-en el constructor:
--inicializamos el objeto mapa con new MapaGenerado(128,128) (128 tiles, no pixeles)

-en metodo mostrar():
--borramos la llamada al metodo temporal que borramos pantalla.mostrar(x,y) (borrar codigo temporal)
--llamamos el metodo mapa.mostrar()

--en actualizar:
---cambiamos el incremeto de cuando se pulsa arriba/abajo/izda/derecha para corregir que no se mueva invertido



24 - Eliminando Bugs:
***
Eliminar bug IndexOutofBounds cuando nos salimos del mapa

En Mapa:
-en obtenerCuadro(): 
--metemos un if que compruebe si la posicion donde se empieza a dibujar el mapa
  se sale de los cuadros que tiene el mapa y si lo hace devolvemos un cuadro vacío

Hacer que se pinten los cuadrados de los margenes pese a que aún no tienen el margen igual al tamaño del cuadrado

Para las posiciones superior e izquierda
En Pantalla:
-en dibujarCuadro():
--En el if que impide dibujar si la posicion de la pantalla es menor que cero, 
  decirle que permita dibujar si el origen de la pantalla es hasta el tamaño de un cuadro por la izquierda
--Si la posicion X es negativa la forzamos a 0

Para las posiciones sur y este
en Mapa:
-en metodo mostrar:
--donde se asigna la posicion final (sur y este) le sumamos el tamaño de un cuadro

25 - Ventana sin bordes

Quitar bordes ventana

En juego:
-en constructor:
--ventana.setUndecorated(true);

Ahora no podemos cerrar ni tenemos la barra de titulo con los FPS y APS

En Teclado: Añadimos el control para la tecla escape
-Añadimos la propiedad salir
-en actualizar:propiedad salir a true si se pulsa la tecla escape

En Juego:
-en actualizar:
--si salir = true. System.exit(0) 

Mostrar los FPS y APS

En Juego:
creamos las propiedades String contadorAPS y FPS
-en run():
--dentro del gameloop en el if que calcula es paso de un segudo asignamos el valor a las nuevas propiedades
-en mostrar():
--graphics.drawString(FPS y APS,x,y);

26 -Creacion de Sprites en PhotoShop
27 -Creacion de Sprites en PhotoShop II
28 -Crear mapa como referencia 
--Buscar sprites en alguna web en mi caso, pa

29 Traducir el mapa a píxeles 
-Asignamos a cada sprite un color, que hará de id
-Creamos una imagen de tantos pixeles como sprites tiene el mapa y traducimos esos sprites a colores

30 Cargar los nuevos sprites:

En Sprite:
-añadimos propiedades a la coleccion de sprites correspondientes a los sprites de nuestra Hoja

Reestructuramos el codigo, para no tener que andar haciendo 1000 clases
**Eliminamos la clase CuadroAsfalto y CuadroVacio

En Cuadro:
**quitamos el abstract y la hacemos una clase normal
-añadimos propiedades a la coleccion de cuadros correspondientes a los nuevos cuadros

En Mapa:
-en obtenerCuadro:
--añadimos al switch todos los cases correspondientea a los cuadros disponibles

31 Cargar Mapas desde imagenes

En Mapa:
-creamos propiedad Cuadro cuadrosCatalogo
-en constructor(string):
--cambiamos new MapaGenerado por MapaCargado
-en mostrar:
--dejamos de usar el metodo obtener cuadros que nos devolvia un cuadro aleatorio
--hacemos una comprobacion de que estemos dentro de los limites del objeto pantalla y 
--si estamos fuera pintamos un cuadro vacio, sino mostraremos el cuadro correspondiente a la posicion

creamos clase MapaCargado extends Mapa:
-creamos propiedad int[] pixeles (para cargar el mapa de pixeles)
-creamos constructor(ruta):

-sobreescribimos el metodo cargarMapa(string):
--leemos la imagen del mapa de pixeles 
--iniciamos alto y ancho
--iniciamos cuadroCatalogo
--iniciamos pixeles
--cargamos en el array de pixeles la imagen

-sobreescribimos el metodo generarMapa(string):
--recorremos el array de pixeles del mapa
---usamos switch case que traduzca el codigo de color del pixel al cuadro correspondiente y lo diga que se dibuje

32 Ocho Sprites en uno
Explicaciones de como rotar y voltear sprites en los bucles anidados

***

33 Cargar sprites manipulados I 
En este episodio veremos la estructura básica necesaria en la clase Sprite para comenzar a cargar sprites manipulados.

En Sprite:
-constructor:
--añadimos el parametro version
--reemplazamos el blucle de carga por el metodo cargarSprite()

-creamos metodo cargaNormal():
--movemos el bucle anidado del constructor a este metodo

--creamos el metodo cargarSprite(version){
-si version el 0 llamamos a cargaNormal sino (por desarrollar) llamaremos al metodo correspondiente

-modificamos las instancias de los sprites para adaptarlas al nuevo constructor

}

***

34 Cargar sprites manipulados II 
En este episodio continuamos escribiendo código en la clase Sprite

En Sprite
-creamos metodo cargaManipulada(version)
--switch case de 1 a 7, en el que se llama al metodo correspondiente a cada version del sprite 

-creamos metodos para manipular sprites: (invertirX,invertirY,invertirXX,rotarD90,rotarI90,rotarI90InvertirY,rotarD90InvertirY) que reciben array pixelesTemporales


***

35 Cargar sprites manipulados III  + 36 Cargar sprites manipulados IV
rellenamos los metodos para manipular sprites

-invertirX(pixelesTemporales):
--bucle anidado x,y en el que se recorre la x de posicion final a posicion inicial

-invertirY(pixelesTemporales):
--bucle anidado x,y en el que se recorre la y de posicion final a posicion inicial

-invertirXY(pixelesTemporales):
--recorrempos todo el array de pixeles y asignamos la lectura de forma invertida

-rotarI90(pixelesTemporales):
--eje x pasa a ser el blucle externo y se recorre x de final a inicio

-rotarD90(pixelesTemporales):
--eje x pasa a ser el blucle externo y se recorre y de final a inicio


-rotarI90InvertirY(pixelesTemporales):
--eje x pasa a ser el blucle externo y se recorren ambos de inicio a final

-rotarD90InvertirY(pixelesTemporales):
--eje x pasa a ser el blucle externo y se recorren ambos de final a inicio

***

37 Rellenando el mapa 

En este episodio al fin eliminaremos los huecos negros de nuestro mapa gracias al nuevo constructor que tenemos para cargar sprites manipulados.

En sprite:
creo propiedades constantes para cada variante de manupulacion de sprites;
creamos los sprites modificados

En cuadro:
añadimos a la coleccion de cuadros los nuevos sprites

En MapaCargado:
anadimos en el metodo generarMapa los casos correspondientes a los nuevos sprites


***

38 Capas de dibujo 
(Explicaciones conceptuales)
En este episodio os explicaré algunas particularidades sobre las capas de dibujo.
Normalmente necesitaremos dibujar todos los elementos en varias pasadas y capas, ya que algunas cosas van debajo (o encima) de otras.
Por eso es importante pensar cuidadosamente el orden en que debemos dibujar, ya que lo primero que dibujemos será lo que esté debajo de lo demás y así sucesivamente.

***

39 Personaje pixel art I 
40 Personaje pixel art II 
41 Personaje pixel art III 
42 Personaje pixel art IV 
En este episodio dibujaremos nuestro personaje para el juego usando el estilo pixel art.
Crear hoja sprites personaje front,back y lados y efectos de movimiento




43 Entes, criaturas y el jugador
Explicaciones sobre en que consisten los Entes,Criaturas y jugador

crear paquete entes
crear clase abstrarcta Ente

crear paquete entes.criaturas
crear clase abstracta Criatura extends Ente
crear clase Jugador extends Criatura

***

44 - Desarrollando Ente y Criatura:

en Ente:
-creamos propiedades x e y: para la posicion
-creamos propiedad boolean eliminado: para saber el estado del ente
-creamos la propiedad Mapa: para poder pintar el sprite en el mapa

-creamos metodo actualizar()
-creamos metodo mostrar()
-creamos getter y setter para x e y (en setter no se asiga el parametro, se suma)    

en Criatura:

-creamos propiedad sprite:
-creamos propiedad direccion : nos indica la posicion a la que estará mirando el sprite de la criatura
-creamos propiedad enMovimiento:

-sobreescribimos metodo actualizar;
-sobreescribimos metodo mostrar;
-creamos metodo mover(desplazamientoX,desplazamientoY):
--si el desplazamiento X e Y es positivo o negativo se asigna a direccion un char representativo de la cardinalidad correspondiente
--si no está eliminado se modifica la posicion acorde al desplazamiento
-creamos metodo enColision(por desarrollar): futuro motor de colisiones
    
***

45 - clase Jugador

En Jugador:
-creamos propiedad teclado

-creamos constructor Jugador(teclado):
--inicializa teclado

-creamos constructor Jugador(teclado,posX,posY):
--inicializa teclado
--asignamos las posiciones de salida del Jugador

-creamos metodo actualizar():
--creamos variables para desplazamientoX e Y
--comprobamos si se pulsa alguna tecla de movimiento en el teclado y incrementamos/decrementamos el desplazamiento correspondiente
--comprobamos si se ha modificado el desplazamiento y llamamos al metodo mover pasandole el nuevo desplazamiento

***

46 - Conectando al Jugador

Hasta ahora el movimiento se conseguía a través de incrementar/decrementar las propiedades x,y de la clase juego a traves del keyListener y desplazar el mapa.
A partir de ahora, la posicion del mapa se calculará a partir de las propiedades x,y de la superclase Ente de Jugador.

en Jugador:
-Eliminamos propiedades x e y
-Creamos propiedad jugador

-en constructor:
--instaciamos jugador(teclado) : Importante instanciar despues de teclado o no va a funcionar

-en actualizar:
--eliminamos la escalera de ifs que modificaban x,y de la clase Jugador
--insertamos llamada a jugador.actualizar();

-en mostrar:
--cambiamos la llamada mapa.mostrar(x,y, pantalla) por (jugador.obtenerPosicionX(),jugador.obtenerPosicionY(), pantalla);
--Añadimos dibujado de strings para la posicion X e Y del Jugador para asi tenerla monitorizada

***

47 - Mostrando el Sprite de Jugador

-copiamos la hoja de sprites del jugador en recursos/texturas

en HojaSprites:
-añadimos a la colleccion de Hojas de sprites la hoja jugador y la instanciamos

en Sprite:
-Creamos todos los sprites correspondientes a la nueva hoja de sprites

en Jugador:

-modificamos los constructores para que reciban (teclado,sprite) y (teclado,sprite, posicionx e Y)

-creamos el metodo mostrar(pantalla):
--pantalla.mostrarJugador(x,y,this)

en Criatura:
-hacemos un getter para criatura

en Juego:
-arreglamos cuando se instancia Jugador para que funcione con su nuevo constructor

-en mostrar()
--añadimos llamada a jugador.mostrar(pantalla,posicionOrigenX,posicionOrigenY)
--quitamos el cuadrado que referenciaba el centro de la pantalla
--cambiamos la llamada mapa.mostrar() y le pasamos la posicion del jugador - ancho de la pantalla/2 - tamaño sprite jugador / 2 (Esto es temporal) 

en Pantalla:
-creamos el metodo mostrarJugador(compensacionX e Y,Jugador)
--el metodo es identico a mostrar cuadro pero recorriendo el sprite del jugador

***

48 - Dirección jugador:

En Pantalla:
-en mostrarJugador:
--añadimos un if que evita pintar los pixeles del croma de la hoja de sprites del jugador

En Jugador:
-en actualiar:
--dentro del if de mover añadimos un switch case que cambia el sprite del jugador según la direccion en la que se seleccione en el teclado

***

49 Animación del jugador

En jugador:

-creamos propiedad int animacion;

-en actualizar:
--comprobamos que animacion no desborde y la incrementamos en cada vuelta
--movemos el switch de movimiento del if de movimiento al final del metodo
--en el if de movimiento seteamos la variable enMovimiento a true o false segun corresponda
--en cada case añadimos la siguiente operacion:
        case 'e':
         sprite = Sprite.JUGADOR_DCHA_0;
         if (enMovimiento) {
             if (animacion % 30 > 15) {
                 sprite = Sprite.JUGADOR_DCHA_1;
             } else {
                 sprite = Sprite.JUGADOR_DCHA_2;
             }
         }

Explicacion:
si está en movimiento debemos alternar las imagenes de la animacion, en animacion se capturan los 
frames en los que el jugador debio moverse, se divide entre un numero de frames suficientes para que 
su animacion tenga una velocidad acorde y el resto debe estar en un rango igual al total de velocidad 
de la animacion entre el numero de sprites que la componen.Cada uno de esos rangos debe estar en un if o en un case

En nuestro caso cada 30 frames con movimiento activo y para dos animaciones da un resto de 15, que corresponden a dos 
rangos de 15 frames que se alternan y asignan la animacion intercalandola
 

***

50 Andar y correr:

En Jugador:
-en mostrar: 
--añadimos mas sprites a las animaciones para un movimiento mas realista
--añadimos cariable velocidad de movimiento = 1 y en donde se incrementa el desplazamiento si las teclas estan pulsadas cambiamos el incremento para pasar a operar con esa variable
--antes de los if que comprueban las teclas pulsadas, comprobamos si se pulsa la tecla correr y si está pulsada cambiamos la velocidad de movimiento por 2

En Teclado:
-añadimos nueva propiedad correr y la iniciamos