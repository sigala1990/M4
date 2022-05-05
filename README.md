# M4
Game-MasterMind

![imagen](https://user-images.githubusercontent.com/9555509/166883302-17ec12ab-6b1a-4299-94ef-aa289d444ea5.png)

## Branches

#### Branch 1: EleccionNivel

Al comenzar el juego se va a mostrar un panel para seleccionar el nivel de juego:

- **Principiante** -> 4 colores disponibles y 10 intentos
- **Medio** ->  5 colores disponibles y 8 intentos
- **Avanzado** ->  6 colores disponibles y 6 intentos

Se implementará con 3 "radioButton" siendo posible solamente seleccionar una de las tres opciones. Además tendremos dos "button" uno para *Aceptar* y otro para *Cancelar*.

- Si pulsamos *Cancelar* se jugará con el nivel **Principiante**

### Branch 2: ColoresDisponibles

El número de *PictureBox* dependerá del nivel escogid por el jugador.

- **crear_colores()** -> Crea tantos *PictureBox* como sean necesarios
- Cada *PictureBox* se va a llamar **bolacolores**
- **Los colores de los componentes se obtendrán de un vector de Colores previamente creado e inicializado ALEATORIAMENTE!!!**
- Guardar los Colores de los componentes en un vectpr para la siguiente branch de combinacionSecreta -> **"colores_disponibles"**
- Por defecto -> 4 *PictureBoxes*

### Branch 3: ColmbinaciónSecreta

El número de *PictureBox* dependerá del nivel escogid por el jugador.

- **NO** es visible al iniciar el juego
- **crear_solucion()** -> Crea tantos *PictureBox* como sean necesarios
- Cada *PictureBox* se va a llamar **bolacolores**
- **Los colores de los componentes se obtendrán del vector de Colores "colores_disponibles" poniendolos en un orden ALEATORIO!!!**
- Se pueden REPETIR!

### Branch 4: MenuArchivoAyuda

Se implementarán las opciones disponibles en el menú del juego distinguiendo entre *Archivo* y *Ayuda*:

##### Archivo

- **Nuevo juego** -> Al pulsarlo de comenzará la primera partida, y se va a crear el método **borrar_componentes()** para borrar todos los componentes creados durante el juego 
- **Salir** -> Terminará la partida actual
- **Nivel** -> Podremos seleccionar el nivel del mismo. Mostrandonos la pestaña de EleccionNivel

#### Ayuda

- **Como jugar** -> Explicación del juego
- **Acerca De** -> Nombre de los alumnos

### Branch 5: CrearCombinaciónDelUsuario

Creamos los *PictureBox* necesarios para introducir la combinación que quiere el jugador:

- **crear_linea_bola()** -> Crea tantos *PictureBox* como sean necesarios. Junto a estos se creará un botón que permita comprobar cuántos colores hemos acertador llamado *Comprobar*
- Cada *PictureBox* se va a llamar **bola**

### Branch 6: PonerCombinaciónDelUsuario

Añadiremos la funcionalidad para seleccionar los colores a comprobar en los *PictureBox* de la rama anterior.

- **Click Izquierdo** -> Al pulsar con el click izquierdo en los *PictureBox* pondremos el color en este siguiendo un orden de izquierda a derecha tal y como nos salen en el apartat de **Colores Disponibles**
- **Click Derecho** -> Al pulsar con el click derecho en los *PictureBox* pondremos el color en este siguiendo un orden de derecha a izquierda tal y como nos salen en el apartat de **Colores Disponibles**
- **Mantener la secuencia de click-color, seguir en la posicion del color en la que nos quedamos cuando se hace click derecho o izquierdo, es decir una consistencia en quanto al orden de poner los colores**

### Branch 7: ComprobandoAciertos

Añadiremos la funcionalidad cunado pulsamos el botón "Comprobar":

- **Comprobar Negras** -> Debemos comprobar cuantos colores estan correctamente encontrados y en su sitio, se pondrá un *PictureBox* de color negro llamado **bolaresul**
- **Comprobar Blancas** -> Debemos comprobar cuantos colores estan correctamente encontrados. Se debe eliminar de esta comprobación los colores encontrados en su sitio (negras).Si un color esta en +1 posición solo se mostrará un *PictureBox*. Se pondrán los *PictureBox* de color blancos a la derecha de las negras, llamadas **bolaresul** también
- **Colores sin coincidencia** -> Si los colores introducidos 

#### Tras mostrar las bolas negras y blancas

- **Ganado** -> Mostrar mensaje al usuario
- **Gastado todos los intentos** -> Mostrar mensaje de no superado y revelar la combinación secreta. **Por defecot 10 intentos!!**
- **Seguir jugando** -> Si no hemos ganado ni perdido seguimos jugando creando una nueva fila de componentes debajo de la anterior para que se puedan elegir de nuevo los colores

### Branch 8: ElegirColores

En menú archivo ñadir una nueva sección llamda *Opciones*: 

- Abrirá una nueva pestaña con tantos colores *PictureBox* como tengamos según el nivel. Estarán en BLANCO en un inicio
- Para abrir esta opción mínimo se tiene que haber jugado 1 vez
- Estos colores correponderán a los **Colores Disponibles**

## Esquema Adrià

![imagen](https://user-images.githubusercontent.com/9555509/166882782-2942d512-b001-4d15-a21e-b70c05f92327.png)
