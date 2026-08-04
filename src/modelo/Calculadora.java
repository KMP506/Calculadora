/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author efrai
 */
public class Calculadora {
    public static class DivisionEntreCeroException extends Exception{
        public DivisionEntreCeroException(String mensaje){
            super(mensaje);
        }
    }
    
    public double sumar(double n1, double n2){
        return n1 + n2;
    }
    
    public double restar(double n1, double n2){
        return n1 - n2;
    }
    public double multiplicar(double n1, double n2){
        return n1*n2;
    }
   public double dividir(double n1, double n2)
    throws DivisionEntreCeroException {
        if (n2 == 0) {
         throw new DivisionEntreCeroException("No se puede dividir entre cero.");
        }
    return n1 / n2; 
    }
}
