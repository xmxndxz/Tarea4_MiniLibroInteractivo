/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author amand
 */
public class PaginaInformativa extends Pagina {
    public PaginaInformativa(String titulo , int numeroPagina, String contenido){
        super (titulo, numeroPagina, contenido);
    }

    @Override
    public String mostrarContenido() {
      return getContenido();
    }
}
