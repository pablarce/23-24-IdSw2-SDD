package Utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class OperacionesMatematicas {

    public static String evaluarFormula(String formula, Sheet sheet) {
        if (formula.startsWith("=")) {
            String expresion = formula.substring(1);
            try {
                double resultado = evaluarExpresion(expresion, sheet);
                return Double.toString(resultado);
            } catch (Exception e) {
                return "Error en la expresión matemática: " + e.getMessage();
            }
        } else {
            return formula;
        }
    }


    private static double evaluarExpresion(String expresion, Sheet sheet) {
        Deque<Double> numeros = new ArrayDeque<>();
        Deque<Character> operadores = new ArrayDeque<>();

        char[] caracteres = expresion.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            char caracter = caracteres[i];

            if (Character.isLetter(caracter)) {
                StringBuilder referenciaCelda = new StringBuilder();

                while (i < caracteres.length && Character.isLetterOrDigit(caracteres[i])) {
                    referenciaCelda.append(caracteres[i]);
                    i++;
                }
                i--;

                double valorCelda = obtenerValorCelda(referenciaCelda.toString(), sheet);
                numeros.push(valorCelda);
            } else if (Character.isDigit(caracter) || caracter == '.') {
                StringBuilder numeroActual = new StringBuilder();

                while (i < caracteres.length && (Character.isDigit(caracteres[i]) || caracteres[i] == '.')) {
                    numeroActual.append(caracteres[i]);
                    i++;
                }
                i--;

                numeros.push(Double.parseDouble(numeroActual.toString()));
            } else if (caracter == '(') {
                operadores.push(caracter);
            } else if (caracter == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    aplicarOperacion(numeros, operadores.pop());
                }
                operadores.pop();
            } else if (esOperador(caracter)) {
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(caracter)) {
                    aplicarOperacion(numeros, operadores.pop());
                }
                operadores.push(caracter);
            }
        }

        while (!operadores.isEmpty()) {
            aplicarOperacion(numeros, operadores.pop());
        }

        return numeros.pop();
    }

    private static double obtenerValorCelda(String referenciaCelda, Sheet sheet) {
        int columna = referenciaCelda.charAt(0) - 'A' + 1;
        int fila = Integer.parseInt(referenciaCelda.substring(1)) - 1;
        String valorCelda = sheet.getSheetData()[fila + 2][columna].getCellValue().trim();
        try {
            return Double.parseDouble(valorCelda);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Referencia de celda no válida o celda vacía.");
        }
    }
    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
    private static void aplicarOperacion(Deque<Double> numeros, char operador) {
        double num2 = numeros.pop();
        double num1 = numeros.pop();

        switch (operador) {
            case '+':
                numeros.push(num1 + num2);
                break;
            case '-':
                numeros.push(num1 - num2);
                break;
            case '*':
                numeros.push(num1 * num2);
                break;
            case '/':
                if (num2 != 0) {
                    numeros.push(num1 / num2);
                } else {
                    throw new ArithmeticException("División por cero.");
                }
                break;
            default:
                throw new IllegalArgumentException("Operador no reconocido.");
        }
    }
}


