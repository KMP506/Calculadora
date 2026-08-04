/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Calculadora;
import modelo.Calculadora.DivisionEntreCeroException;
import modelo.Calculadora.NumeroInvalidoException;
import vista.FrmCalculadora;

public class ControladorCalculadora {

    private Calculadora modelo;
    private FrmCalculadora vista;

    private String valorActual = "";
    private double primerValor;
    private String operacion = "";
    private boolean resultadoMostrado = false;

    public ControladorCalculadora(Calculadora modelo, FrmCalculadora vista) {

        this.modelo = modelo;
        this.vista = vista;

        agregarEventos();
    }

    private void agregarEventos() {

        // Botones numéricos
        vista.btn0.addActionListener(e -> agregarNumero("0"));
        vista.btn1.addActionListener(e -> agregarNumero("1"));
        vista.btn2.addActionListener(e -> agregarNumero("2"));
        vista.btn3.addActionListener(e -> agregarNumero("3"));
        vista.btn4.addActionListener(e -> agregarNumero("4"));
        vista.btn5.addActionListener(e -> agregarNumero("5"));
        vista.btn6.addActionListener(e -> agregarNumero("6"));
        vista.btn7.addActionListener(e -> agregarNumero("7"));
        vista.btn8.addActionListener(e -> agregarNumero("8"));
        vista.btn9.addActionListener(e -> agregarNumero("9"));

        // Punto decimal
        vista.btnPunto.addActionListener(e -> agregarPunto());

    