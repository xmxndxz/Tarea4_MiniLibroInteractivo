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
public class PaginaActividad extends Pagina{
    
    private int totalPreguntas=3;
    private int maxIntentos=3;
    //arraylist
    private ArrayList<Actividad> preguntas = new ArrayList<>();
    
    //arreglos unidemnsionales 
    //areglo bidimensional

    public PaginaActividad(String titulo, int numeroPagina, ArrayList<String> contenido) {
        super(titulo, numeroPagina, contenido);
    }

    @Override
    public ArrayList<String> mostrarContenido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
