/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author amand
 */
public class Actividad {

    private String enunciado;
    private String opcion1;
    private String opcion2;
    private String opcion3;

    //constructor 
    public Actividad(String enunciado, String opcion1, String opcion2, String opcion3) {
        this.enunciado = enunciado;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
    }

    //getter de enunciado 
    public String getEnunciado() {
        return enunciado;
    }

    public String getOpcion(int numeroOpcion) {
        String opcion = "";

        switch (numeroOpcion) {
            case 1:
                opcion = opcion1;
                break;
            case 2:
                opcion = opcion2;
                break;
            case 3:
                opcion = opcion3;
                break;
        }
        return opcion;
    }

}
