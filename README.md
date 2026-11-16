# Mini libro interactivo: Biodiversidad de Puntarenas – Tesoros del Pacífico
# Descripción :
**Biodiversidad de Puntarenas: Tesoros del Pacífico.** Puntarenas es la provincia más grande de Costa Rica y reúne bosques, manglares, playas, islas y mares con una enorme variedad de especies. El libro presenta:
 Parte - Contenido 
 Portada - Título, tema, autor e índice de páginas 
 Página 1 - *Puntarenas: una provincia llena de vida* – ubicación y variedad de ambientes 
 Página 2 - *Parques y bosques de tierra firme* – Corcovado (lapa roja, jaguar, tapir), Manuel Antonio (mono tití) y Monteverde (quetzal) 
 Página 3 - *El mar y las islas del Pacífico* – Marino Ballena (ballenas jorobadas) e Isla del Coco (tiburones martillo) 
 Página 4 - Actividad interactiva de 3 preguntas, con hasta 3 intentos 
 Resultados - Cantidad de respuestas correctas, historial de intentos y consulta del detalle de cada uno 

## Instrucciones para ejecutar el programa

**Requisitos:** Apache NetBeans, JDK 25 y conexión a internet la primera vez 
1. Descomprimir el ZIP y abrir la carpeta del proyecto en NetBeans con "File > Open Project".
2. Ejecutar dandole paly al boton verde o usando el comando MAYUS+F6

**Flujo de uso**
1. Se muestra la portada del libro con su índice.
2. **INICIAR LECTURA** abre la página 1.
3. **Siguiente** y **Anterior** navegan entre las páginas.
4. **Ir a Actividad** abre las preguntas; se responde con botones de **Opcion 1, 2 o 3**.
5. Al contestar la tercera pregunta se muestra la cantidad de respuestas correctas y se abre la pantalla de resultados.
6. En resultados: **Consultar** (pide un número de intento de 1 a 3), **Nuevo Intento** (máximo 3), **Volver al Libro**, **Menú Principal** o **SALIR**.
7. Desde el libro, **Resultados** vuelve a abrir la pantalla de resultados; **Menú Principal** y **SALIR** están disponibles en el libro y en resultados 

## Principales clases
El proyecto está dividido en modelo, vista y controlador (MVC).
**Modelo**
- Pagina: clase abstracta con el título, el número de página y el contenido. Tiene el método abstracto mostrarContenido().
- PaginaInformativa: hereda de Pagina y muestra el texto de cada página del libro.
- PaginaActividad: hereda de Pagina y muestra las preguntas. Usa los arreglos int[] para las respuestas correctas y las seleccionadas, y el arreglo int[][] para guardar el historial de intentos.
- Actividad: es una pregunta con su enunciado y tres opciones.
- Libro: guarda las páginas en un ArrayList<Pagina>.
-
**Vista**
- VistaMenu, VistaLibro y VistaResultados: son las ventanas que ve el usuario. Solo muestran la información y tienen los botones.
**Controlador**
- ControladorMenu, ControladorLibro y ControladorResultados: reciben los clics de los botones y conectan el modelo con la vista.

## Manejo de excepciones
Se usó try/catch en dos lugares:
- En ControladorLibro, para cuando se intenta ir a una página que no existe.
- En ControladorResultados, para cuando se consulta un intento que no está en el rango (1 a 3) o cuando lo que se escribe no es un número.
