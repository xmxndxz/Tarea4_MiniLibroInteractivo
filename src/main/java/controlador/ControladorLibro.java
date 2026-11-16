/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.Pagina;
import modelo.PaginaActividad;
import vista.VistaLibro;
import vista.VistaMenu;
import vista.VistaResultados;
/**
 *
 * @author amand
 */

public class ControladorLibro implements ActionListener {

    //modelo
    private Libro modelo;
    //vistas
    private VistaLibro vista;
    private VistaMenu vistaMenu;

    public ControladorLibro(Libro modelo, VistaLibro vista, VistaMenu vistaMenu) {
        this.modelo = modelo;
        this.vista = vista;
        this.vistaMenu = vistaMenu;

        vista.addLibroListener(this);
        actualizarVista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();

        switch (op) {
            case "SIGUIENTE":
                irAPagina(modelo.getPaginaActual() + 1);
                break;
            case "ANTERIOR":
                irAPagina(modelo.getPaginaActual() - 1);
                break;
            case "ACTIVIDAD":
                irAPagina(modelo.getPosicionActividad());
                break;
            case "OP1":
                responder(1);
                break;
            case "OP2":
                responder(2);
                break;
            case "OP3":
                responder(3);
                break;
            case "RESULTADOS":
                abrirResultados();
                break;
            case "MENU":
                volverMenu();
                break;
            case "SALIR":
                System.exit(0);
                break;
        }
    }

    //cambia de pagina solo si la posicion existe en el arrayList
    private void irAPagina(int posicion) {
        try {
            modelo.getPagina(posicion);
            modelo.setPaginaActual(posicion);
            prepararActividad();
            actualizarVista();
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "La página solicitada no existe");
        }
    }

    //si el intento anterior ya termino y quedan intento , empieza un nuevo intento
    private void prepararActividad() {
        PaginaActividad actividad = modelo.getActividad();
        if (modelo.esActividad(modelo.getPaginaActual()) && actividad.isTerminada() && actividad.puedeNuevoIntento()) {
            actividad.nuevoIntento();
        }
    }

    private void responder(int opcion) {
        PaginaActividad actividad = modelo.getActividad();

        if (!actividad.registrarRespuesta(opcion)) {
            JOptionPane.showMessageDialog(null, "Respuesta inválida");
            return;
        }

        if (actividad.isTerminada()) {
            actividad.guardarIntento();
            JOptionPane.showMessageDialog(null, "Intento terminado. Respuestas correctas: "
                    + actividad.contarCorrectas() + " de " + actividad.getTotalPreguntas());
            abrirResultados();
        }
        actualizarVista();
    }

    public void abrirResultados() {
        if (modelo.getActividad().getIntentosRealizados() == 0) {
            JOptionPane.showMessageDialog(null, "Todavía no ha realizado ningún intento de la actividad");
            return;
        }
        VistaResultados vistaResultados = new VistaResultados();
        ControladorResultados control = new ControladorResultados(modelo.getActividad(), vistaResultados, this);

        vista.setVisible(false);
        vistaResultados.setLocationRelativeTo(null);
        vistaResultados.setVisible(true);
    }

    //metodos que usa ControladorResultados para regresar al libro
    public void mostrarLibro() {
        prepararActividad();
        actualizarVista();
        vista.setVisible(true);
    }

    public void mostrarActividad() {
        modelo.setPaginaActual(modelo.getPosicionActividad());
        actualizarVista();
        vista.setVisible(true);
    }

    public void volverMenu() {
        vista.dispose();
        vistaMenu.setVisible(true);
    }

    public void actualizarVista() {
        int posicion = modelo.getPaginaActual();
        Pagina pagina = modelo.getPagina(posicion);

        vista.mostrarPagina("Página " + pagina.getNumeroPagina() + " de " + modelo.cantidadPaginas(),
                pagina.getTitulo());
        vista.mostrarContenido(pagina.mostrarContenido());

        PaginaActividad actividad = modelo.getActividad();
        boolean mostrarOpciones = modelo.esActividad(posicion) && actividad.puedeResponder();
        vista.mostrarOpciones(mostrarOpciones);
    }
}

