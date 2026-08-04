/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controlador;

public class ControladorCalculadora {

     private modelo.Calculadora calculadora;
    private vista.FrmCalculadora frmCalculadora;

    private String numeroActual = "";
    private double numero1;
    private String operacion = "";
    private boolean resultadoListo = false;

    public ControladorCalculadora(
            modelo.Calculadora calculadora,
            vista.FrmCalculadora frmCalculadora) {

        this.calculadora = calculadora;
        this.frmCalculadora = frmCalculadora;
    }

    public void agregarNumero(String numero) {

        if(resultadoListo){
            numeroActual = "";
            resultadoListo = false;
        }

        numeroActual=numeroActual+numero;
        frmCalculadora.setTextoPantalla(numeroActual);
    }

    public void agregarPunto() {

        if(!numeroActual.contains(".")) {

            if(numeroActual.isEmpty()) {
                numeroActual = "0.";
            }else{
                numeroActual = numeroActual + ".";
            }
            frmCalculadora.setTextoPantalla(numeroActual);
        }
    }

    public void cambiarSigno(){

        if(numeroActual.isEmpty()) {
            return;
        }
        if(numeroActual.startsWith("-")) {
            numeroActual = numeroActual.substring(1);
        }else{
            numeroActual = "-" + numeroActual;
        }

        frmCalculadora.setTextoPantalla(numeroActual);
    }

    public void seleccionarOperacion(String nuevaOperacion){

        if(numeroActual.isEmpty()){
            frmCalculadora.setTextoPantalla("Ingrese un número primero.");
            return;
        }
        if(!operacion.isEmpty()){
            frmCalculadora.setTextoPantalla("Ya seleccionó una operación.");
            return;
        }

        try {
            numero1 = Double.parseDouble(numeroActual);
            operacion = nuevaOperacion;
            numeroActual = "";
        }catch(NumberFormatException error){

            frmCalculadora.setTextoPantalla("El número no es válido.");
        }
    }

    public void calcularResultado() {

        if(operacion.isEmpty()) {
            frmCalculadora.setTextoPantalla("Seleccione una operación.");
            return;
        }
        if(numeroActual.isEmpty()) {
            frmCalculadora.setTextoPantalla("Ingrese el segundo número.");
            return;
        }
        try{

            double numero2 = Double.parseDouble(numeroActual);
            double resultado = 0;

            switch (operacion) {

                case "+":
                    resultado = calculadora.sumar(numero1, numero2);
                    break;

                case "-":
                    resultado = calculadora.restar(numero1, numero2);
                    break;

                case "*":
                    resultado = calculadora.multiplicar(numero1, numero2);
                    break;

                case "/":
                    resultado = calculadora.dividir(numero1, numero2);
                    break;
            }

            numeroActual = String.valueOf(resultado);
            frmCalculadora.setTextoPantalla(numeroActual);

            operacion = "";
            resultadoListo = true;

        } catch (NumberFormatException error) {
            frmCalculadora.setTextoPantalla("El número no es válido.");
        } catch (Exception error){
            frmCalculadora.setTextoPantalla(error.getMessage());
        }
    }

    public void borrarTodo() {

        numeroActual = "";
        numero1 = 0;
        operacion = "";
        resultadoListo = false;

        frmCalculadora.setTextoPantalla("0");
    }

    public void borrarEntrada() {

        numeroActual = "";
        frmCalculadora.setTextoPantalla("0");
    }

    public void borrarUltimo() {

        if(!numeroActual.isEmpty())
        {numeroActual=numeroActual.substring(0,numeroActual.length()- 1);
        }

        if(numeroActual.isEmpty()){
            frmCalculadora.setTextoPantalla("0");
        }else{
            frmCalculadora.setTextoPantalla(numeroActual);
        }
    }
}