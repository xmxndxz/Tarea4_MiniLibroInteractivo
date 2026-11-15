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
public class PaginaInformativa extends Pagina {
    public PaginaInformativa(String titulo , int numeroPagina, ArrayList<String> contenido){
        super (titulo, numeroPagina, contenido);
    }

    @Override
    public ArrayList<String> mostrarContenido() {
      return getContenido();
    }
}
