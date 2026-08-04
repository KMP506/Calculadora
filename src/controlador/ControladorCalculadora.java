/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
try {

    double num1 = Double.parseDouble(primerValor);
    double num2 = Double.parseDouble(segundoValor);

    double resultado = 0;

    switch (operacion) {

        case "+":
            resultado = modelo.sumar(num1, num2);
            break;

        case "-":
            resultado = modelo.restar(num1, num2);
            break;

        case "*":
            resultado = modelo.multiplicar(num1, num2);
            break;

        case "/":
            resultado = modelo.dividir(num1, num2);
            break;
    }

    vista.setTextoPantalla(String.valueOf(resultado));

} catch (NumberFormatException e) {

    JOptionPane.showMessageDialog(null,
            "Número inválido.");

} catch (Calculadora.DivisionEntreCeroException e) {

    JOptionPane.showMessageDialog(null,
            e.getMessage());

}