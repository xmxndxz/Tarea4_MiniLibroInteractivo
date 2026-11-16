/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Libro;
import vista.VistaLibro;
import vista.VistaMenu;

/**
 *
 * @author amand
 */
public class ControladorMenu implements ActionListener{
     //modelo
    private Libro modelo = new Libro();
    //vista
    private VistaMenu vista = new VistaMenu();

    public ControladorMenu() {
        vista.addMenuListener(this);
        vista.mostrarPortada(modelo.getTitulo(), "Tema: " + modelo.getTema(),
                "Autor: " + modelo.getAutor());
        mostrarIndice();
    }

    //recorre la lista de paginas y las muestra en la portada
    private void mostrarIndice() {
        ArrayList<String> indice = modelo.indice();
        for (int i = 0; i < indice.size(); i++) {
            vista.mostrarIndice(i + 1, indice.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();

        switch (op) {
            case "INICIO":
                abrirLibro();
                break;
            case "SALIR":
                System.exit(0);
                break;
        }
    }

    public void inicioMenu() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void abrirLibro() {
        modelo.reiniciarLectura();
        VistaLibro vistaLibro = new VistaLibro();
        ControladorLibro control = new ControladorLibro(modelo, vistaLibro, vista);

        vista.setVisible(false);
        vistaLibro.setLocationRelativeTo(null);
        vistaLibro.setVisible(true);
    }
}
