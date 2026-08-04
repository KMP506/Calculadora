/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

import modelo.Calculadora;
import vista.FrmCalculadora;
import javax.swing.JOptionPane;

public class ControladorCalculadora {

    private Calculadora modelo;
    private FrmCalculadora vista;

    private String valorActual = "";
    private double primerValor = 0;
    private String operacion = "";
    private boolean resultadoMostrado = false;

    public ControladorCalculadora(Calculadora modelo, FrmCalculadora vista) {

        this.modelo = modelo;
        this.vista = vista;

        iniciarEventos();
    }

    private void iniciarEventos() {

    }

}