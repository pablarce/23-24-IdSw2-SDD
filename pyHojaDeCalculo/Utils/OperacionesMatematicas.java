package Utils;

public class OperacionesMatematicas {

    public static String evaluarFormula(String formula) {
        if (formula.startsWith("=")) {
            String expresion = formula.substring(1);
            return Double.toString(evaluarExpresion(expresion));
        } else {
            return formula;
        }
    }

    private static double evaluarExpresion(String expresion) {
        char[] caracteres = expresion.toCharArray();
        double resultado = 0;
        char operador = '+';
        StringBuilder numeroActual = new StringBuilder();

        for (char caracter : caracteres) {
            if (Character.isDigit(caracter) || caracter == '.') {
                numeroActual.append(caracter);
            } else {
                double numero = Double.parseDouble(numeroActual.toString());
                resultado = aplicarOperacion(resultado, numero, operador);

                numeroActual = new StringBuilder();
                operador = caracter;
            }
        }

        double ultimoNumero = Double.parseDouble(numeroActual.toString());
        resultado = aplicarOperacion(resultado, ultimoNumero, operador);

        return resultado;
    }

    private static double aplicarOperacion(double num1, double num2, char operador) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.err.println("Error: División por cero.");
                    return Double.NaN;
                }
            default:
                System.err.println("Error: Operador no reconocido.");
                return Double.NaN;
        }
    }
}

