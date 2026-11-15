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
public abstract class Pagina {
    private String titulo;
    private int numeroPagina;
    private ArrayList<String> contenido;
    
    //constructor

    public Pagina(String titulo, int numeroPagina, ArrayList<String> contenido) {
        this.titulo = titulo;
        this.numeroPagina = numeroPagina;
        this.contenido = contenido;
    }

    //getters and setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public ArrayList<String> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList<String> contenido) {
        this.contenido = contenido;
    }
    
    //metodo abstracto
    public abstract ArrayList<String> mostrarContenido();
    
    
}
