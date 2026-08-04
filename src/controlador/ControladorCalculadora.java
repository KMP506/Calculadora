/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;


import modelo.Calculadora;
import modelo.Calculadora.DivisionEntreCeroException;
import vista.FrmCalculadora;

import javax.swing.JOptionPane;

public class ControladorCalculadora {

    private Calculadora modelo;
    private FrmCalculadora vista;

    private String valorActual = "";
    private double primerValor;
    private String operacion = "";

    public ControladorCalculadora(Calculadora modelo, FrmCalculadora vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Agregar números
    public void agregarNumero(String numero) {
        valorActual += numero;
        vista.setTextoPantalla(valorActual);
    }

    // Agregar punto decimal
    public void agregarPunto() {
        if (!valorActual.contains(".")) {
            if (valorActual.isEmpty()) {
                valorActual = "0.";
            } else {
                valorActual += ".";
            }
            vista.setTextoPantalla(valorActual);
        }
    }

    // Cambiar signo
    public void cambiarSigno() {
        if (!valorActual.isEmpty()) {
            if (valorActual.startsWith("-")) {
                valorActual = valorActual.substring(1);
            } else {
                valorActual = "-" + valorActual;
            }
            vista.setTextoPantalla(valorActual);
        }
    }

    // Seleccionar operación
    public void seleccionarOperacion(String op) {

        if (valorActual.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Ingrese un número primero.");
            return;
        }

        if (!operacion.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Ya seleccionó una operación.");
            return;
        }

        try {
            primerValor = Double.parseDouble(valorActual);
            operacion = op;
            valorActual = "";

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista,
                    "Número inválido.");
        }
    }

    // Igual
    public void calcularResultado() {

        if (operacion.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Seleccione una operación.");
            return;
        }

        if (valorActual.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Ingrese el segundo número.");
            return;
        }

        try {

            double segundoValor = Double.parseDouble(valorActual);
            double resultado = 0;

            switch (operacion) {

                case "+":
                    resultado = modelo.sumar(primerValor, segundoValor);
                    break;

                case "-":
                    resultado = modelo.restar(primerValor, segundoValor);
                    break;

                case "*":
                    resultado = modelo.multiplicar(primerValor, segundoValor);
                    break;

                case "/":
                    resultado = modelo.dividir(primerValor, segundoValor);
                    break;
            }

            valorActual = String.valueOf(resultado);
            operacion = "";
            vista.setTextoPantalla(valorActual);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(vista,
                    "Número inválido.");

        } catch (DivisionEntreCeroException e) {

            JOptionPane.showMessageDialog(vista,
                    e.getMessage());
        }
    }

    // AC
    public void borrarTodo() {
        valorActual = "";
        primerValor = 0;
        operacion = "";
        vista.setTextoPantalla("0");
    }

    // CE
    public void borrarEntrada() {
        valorActual = "";
        vista.setTextoPantalla("0");
    }

    // Borrar último carácter
    public void borrarUltimo() {

        if (!valorActual.isEmpty()) {

            valorActual = valorActual.substring(0,
                    valorActual.length() - 1);

            if (valorActual.isEmpty()) {
                vista.setTextoPantalla("0");
            } else {
                vista.setTextoPantalla(valorActual);
            }
        }
    }
}