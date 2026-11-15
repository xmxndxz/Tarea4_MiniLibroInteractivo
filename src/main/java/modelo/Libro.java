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
public class Libro {

    private String titulo = "Biodiversidad de Puntarenas";
    private String tema = "Tesoros del Pacífico";
    private String autor = "Amanda AR";
    private ArrayList<Pagina> paginas = new ArrayList<>();
    private PaginaActividad actividad;
    private int posicionActividad;
    private int paginaActual = 0;

    public Libro() {
        String pagina1 = "Puntarenas es la provincia más grande de Costa Rica."
                + "\nSe extiende por la costa del Pacífico, de norte a sur."
                + "\nAllí hay bosques, manglares, playas, islas y mares."
                + "\nEsa variedad de ambientes da hogar a miles de especies.";

        String pagina2 = "En la península de Osa está el Parque Nacional Corcovado,"
                + "\nhogar de la lapa roja, el jaguar y el tapir."
                + "\nEn Manuel Antonio vive el mono tití, una especie amenazada."
                + "\nEn Monteverde, el bosque nuboso protege al quetzal.";

        String pagina3 = "En el Parque Nacional Marino Ballena, en Uvita,"
                + "\nllegan las ballenas jorobadas a tener a sus crías."
                + "\nLa Isla del Coco, también parte de Puntarenas,"
                + "\nes Patrimonio Mundial y refugio de tiburones martillo."
                + "\nCuidar estos lugares protege el tesoro natural del país.";

        String instrucciones = "Responda las tres preguntas."
                + "\nTiene un máximo de tres intentos.";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public String getAutor() {
        return autor;
    }

    public PaginaActividad getActividad() {
        return actividad;
    }

    public int getPosicionActividad() {
        return posicionActividad;
    }

    public boolean esActividad(int posicion) {
        return posicion == posicionActividad;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    public void reiniciarLectura() {
        paginaActual = 0;
    }

    //Agregar paginas al libro
    public void agregarPagina(Pagina pagina) {
        paginas.add(pagina);
    }

    //Consultar una pagina segun su posicion (lanza IndexOutOfBoundsException si no existe)
    public Pagina getPagina(int posicion) {
        return paginas.get(posicion);
    }

    //Obtener la cantidad de paginas disponibles
    public int cantidadPaginas() {
        return paginas.size();
    }

    //Recorrer la coleccion
    public ArrayList<String> indice() {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < paginas.size(); i++) {
            Pagina p = paginas.get(i);
            lista.add(p.getNumeroPagina() + ". " + p.getTitulo());
        }
        return lista;
    }
}
