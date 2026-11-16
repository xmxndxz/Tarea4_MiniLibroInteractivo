/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.PaginaActividad;
import vista.VistaResultados;

/**
 *
 * @author amand
 */
public class ControladorResultados implements ActionListener{
      //modelo
    private PaginaActividad modelo;
    //vista
    private VistaResultados vista;
    private ControladorLibro controladorLibro;

    public ControladorResultados(PaginaActividad modelo, VistaResultados vista, ControladorLibro controladorLibro) {
        this.modelo = modelo;
        this.vista = vista;
        this.controladorLibro = controladorLibro;

        vista.addResultadosListener(this);
        actualizarVista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();

        switch (op) {
            case "CONSULTAR":
                consultarIntento();
                break;
            case "NUEVO":
                nuevoIntento();
                break;
            case "LIBRO":
                vista.dispose();
                controladorLibro.mostrarLibro();
                break;
            case "MENU":
                vista.dispose();
                controladorLibro.volverMenu();
                break;
            case "SALIR":
                System.exit(0);
                break;
        }
    }

    //Pide el numero de intento
    private void consultarIntento() {
        String texto = JOptionPane.showInputDialog("¿Qué intento desea ver? (1 a " + modelo.getMaxIntentos() + ")");
        if (texto == null) {
            return;
        }
        try {
            int numeroIntento = Integer.parseInt(texto);
            if (numeroIntento > modelo.getIntentosRealizados() && numeroIntento <= modelo.getMaxIntentos()) {
                JOptionPane.showMessageDialog(null, "El intento " + numeroIntento + " todavía no se ha realizado");
                return;
            }
            mostrarDetalle(modelo.detalleIntento(numeroIntento));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Respuesta inválida: debe escribir un número");
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "El intento está fuera del rango permitido (1 a "
                    + modelo.getMaxIntentos() + ")");
        }
    }

    private void nuevoIntento() {
        if (!modelo.puedeNuevoIntento()) {
            JOptionPane.showMessageDialog(null, "Ya utilizó los " + modelo.getMaxIntentos() + " intentos");
            return;
        }
        modelo.nuevoIntento();
        vista.dispose();
        controladorLibro.mostrarActividad();
    }

    public void actualizarVista() {
        int ultimo = modelo.getIntentosRealizados();
        String puntaje = "Último intento: " + modelo.contarCorrectasIntento(ultimo)
                + " de " + modelo.getTotalPreguntas() + " correctas";
        vista.mostrarPuntaje(puntaje);

        ArrayList<String> resumen = modelo.resumenHistorial();
        for (int i = 0; i < resumen.size(); i++) {
            vista.mostrarIntento(i + 1, resumen.get(i));
        }
        mostrarDetalle(modelo.detalleIntento(ultimo));
    }

    private void mostrarDetalle(ArrayList<String> detalle) {
        for (int i = 0; i < detalle.size(); i++) {
            vista.mostrarDetalle(i + 1, detalle.get(i));
        }
    }
}
