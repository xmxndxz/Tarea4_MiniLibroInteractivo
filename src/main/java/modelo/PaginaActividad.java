/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author amand
 */
public class PaginaActividad extends Pagina {

    private int totalPreguntas = 3;
    private int maxIntentos = 3;
    //arraylist
    private ArrayList<Actividad> preguntas = new ArrayList<>();

    //arreglos unidemnsionales 
    private int[] respuestasCorrectas = {2, 1, 3};
    private int[] respuestasSeleccionadas = new int[3];
    
    //areglo bidimensional
    private int[][] historial = new int[3][3];

    private int preguntaActual = 0;
    private int intentosRealizados = 0;

    public PaginaActividad(String titulo, int numeroPagina, String contenido) {
        super(titulo, numeroPagina, contenido);
        preguntas.add(new Actividad("¿Por qué Puntarenas alberga miles de especies?", 
                "Porque es la provincia más pequeña de Costa Rica.", 
                "Por su gran variedad de bosques, manglares, playas, islas y mares", 
                "Porque se extiende únicamente por la costa del Caribe"));
        preguntas.add(new Actividad("¿Cuál parque nacional de la península de Osa es hogar de la lapa roja, el jaguar y el tapir?", 
                "El Parque Nacional Corcovado", "El Parque Nacional Manuel Antonio", "El Parque Nacional Marino Ballena"));
        preguntas.add(new Actividad("¿Qué especie encuentra refugio en la Isla del Coco?", 
                "El mono tití", "El quetzal", "El tiburón martillo"));
    }
    
    //implementacion distinta a la PaginaInformativa
    @Override
    public String mostrarContenido() {
       String texto = "";
        if (isTerminada()) {
            if (intentosRealizados >= maxIntentos) {
                texto = "Ya utilizó los " + maxIntentos + " intentos de la actividad."
                        + "\nPresione RESULTADOS para consultarlos.";
            } else {
                texto = "Intento terminado."
                        + "\nPresione IR A LA ACTIVIDAD para realizar otro intento.";
            }
            return texto;
        }
        Actividad p = preguntas.get(preguntaActual);
        texto = "Intento " + (intentosRealizados + 1) + " de " + maxIntentos
                + " - Pregunta " + (preguntaActual + 1) + " de " + totalPreguntas
                + "\n" + p.getEnunciado()
                + "\nOpción 1: " + p.getOpcion(1)
                + "\nOpción 2: " + p.getOpcion(2)
                + "\nOpción 3: " + p.getOpcion(3);
        return texto;
    }
    
    //getters

    public int getTotalPreguntas() {
        return totalPreguntas;
    }

    public int getMaxIntentos() {
        return maxIntentos;
    }

    public int getIntentosRealizados() {
        return intentosRealizados;
    }
    
    
     public boolean isTerminada() {
        return preguntaActual >= totalPreguntas;
    }

    public boolean puedeResponder() {
        return !isTerminada();
    }

    public boolean puedeNuevoIntento() {
        return intentosRealizados < maxIntentos;
    }
    
    
    //metodos
    
    //devuelve false si la respuesta no es ls correcta o si el intento ya termino
     public boolean registrarRespuesta(int opcion) {
        if (opcion < 1 || opcion > 3 || isTerminada()) {
            return false;
        }
        respuestasSeleccionadas[preguntaActual] = opcion;
        preguntaActual++;
        return true;
    }

    //Compara los dos arreglos unidimensionales
    public int contarCorrectas() {
        int correctas = 0;
        for (int i = 0; i < totalPreguntas; i++) {
            if (respuestasSeleccionadas[i] == respuestasCorrectas[i]) {
                correctas++;
            }
        }
        return correctas;
    }

    //Guarda las respuestas del intento como una fila de la matriz
    public void guardarIntento() {
        if (intentosRealizados < maxIntentos) {
            for (int columna = 0; columna < totalPreguntas; columna++) {
                historial[intentosRealizados][columna] = respuestasSeleccionadas[columna];
            }
            intentosRealizados++;
        }
    }

    public void nuevoIntento() {
        if (puedeNuevoIntento()) {
            preguntaActual = 0;
            for (int i = 0; i < totalPreguntas; i++) {
                respuestasSeleccionadas[i] = 0;
            }
        }
    }

    //numeroIntento va de 1 a 3; si esta fuera de ese rango Java lanza ArrayIndexOutOfBoundsException
    public int contarCorrectasIntento(int numeroIntento) {
        int correctas = 0;
        for (int columna = 0; columna < totalPreguntas; columna++) {
            if (historial[numeroIntento - 1][columna] == respuestasCorrectas[columna]) {
                correctas++;
            }
        }
        return correctas;
    }

    //la primera linea es el titulo y las siguientes una por pregunta
    public ArrayList<String> detalleIntento(int numeroIntento) {
        ArrayList<String> detalle = new ArrayList<>();
        detalle.add("Intento " + numeroIntento + ":");
        for (int columna = 0; columna < totalPreguntas; columna++) {
            int elegida = historial[numeroIntento - 1][columna];
            String linea = "Pregunta " + (columna + 1) + ": eligió " + elegida;
            if (elegida == respuestasCorrectas[columna]) {
                linea += " (correcta)";
            } else {
                linea += " (incorrecta, era la " + respuestasCorrectas[columna] + ")";
            }
            detalle.add(linea);
        }
        return detalle;
    }

    //una linea por cada intento posible
    public ArrayList<String> resumenHistorial() {
        ArrayList<String> resumen = new ArrayList<>();
        for (int fila = 0; fila < maxIntentos; fila++) {
            if (fila < intentosRealizados) {
                resumen.add("Intento " + (fila + 1) + ": " + contarCorrectasIntento(fila + 1)
                        + " de " + totalPreguntas + " correctas");
            } else {
                resumen.add("Intento " + (fila + 1) + ": sin realizar");
            }
        }
        return resumen;
    }

}
