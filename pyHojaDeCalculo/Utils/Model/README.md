# Clase Cell
### ¿Por Que?
### Que Cambiamos

# Clase MathOperations
### ¿Por Que?
La clase MathOperations muestra una moderada cohesión y acoplamiento. Depende de la clase Sheet, y el método [getCellValue](https://github.com/pablarce/23-24-IdSw2-SDD/blob/fead6900c7c9dcd2f1063ecd556f2c7d42b19b14/pyHojaDeCalculo/Utils/Model/MathOperations.java#L74) está acoplado a la implementación específica de Sheet. Su enfoque principal es la evaluación de fórmulas matemáticas simples, esto se evidencia en los métodos [evaluateFormula](https://github.com/pablarce/23-24-IdSw2-SDD/blob/fead6900c7c9dcd2f1063ecd556f2c7d42b19b14/pyHojaDeCalculo/Utils/Model/MathOperations.java#L8), [evaluateExpression](https://github.com/pablarce/23-24-IdSw2-SDD/blob/fead6900c7c9dcd2f1063ecd556f2c7d42b19b14/pyHojaDeCalculo/Utils/Model/MathOperations.java#L22) y en los métodos privados [isOperator, precedence y applyOperation](https://github.com/pablarce/23-24-IdSw2-SDD/blob/fead6900c7c9dcd2f1063ecd556f2c7d42b19b14/pyHojaDeCalculo/Utils/Model/MathOperations.java#L85). Todos estos métodos comparten una responsabilidad unificada, ya que colaboran para encontrar el resultado de una fórmula matemática. Además, es escalable, ya que la adición de nuevas operaciones solo requiere insertar otro caso en un switch junto con la lógica de cálculo correspondiente.

Cumple con el principio S (Single Responsibility Principle) al concentrarse principalmente en el cálculo de operaciones matemáticas simples. Sin embargo, el método [getCellValue](https://github.com/pablarce/23-24-IdSw2-SDD/blob/fead6900c7c9dcd2f1063ecd556f2c7d42b19b14/pyHojaDeCalculo/Utils/Model/MathOperations.java#L74) podría ser considerado una responsabilidad adicional que podría comprometer parcialmente este principio, aunque su uso se limita a esta clase y su extracción podría fragmentar el proyecto. Además, la clase es parcialmente compatible con el principio O (Open/Closed Principle), ya que está abierta a la extensión mediante la adición de nuevos operadores.

### Que Cambiamos

# Clase Sheet
### ¿Por Que?
### Que Cambiamos

# Clase Spreadsheet
### ¿Por Que?
### Que Cambiamos
