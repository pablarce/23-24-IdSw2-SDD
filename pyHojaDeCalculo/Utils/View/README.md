### Clase MenuInterface


**¿Por Qué?**

La clase `MenuInterface`, en términos de programación modular, tiene un bajo acoplamiento con otras clases, lo cual es positivo para la mantenibilidad y escalabilidad del sistema. La alta cohesión de la clase garantiza que todas sus responsabilidades están relacionadas y centradas en la tarea de mostrar un menú de movimientos. Además, cumple con el principio de responsabilidad única del diseño SOLID, al estar dedicada únicamente a la visualización del menú, y con el principio de segregación de interfaces, al no depender de métodos innecesarios.

A pesar de que la clase no está completamente cerrada para modificaciones, lo cual podría ser una mejora potencial en términos de adherencia al principio de abierto/cerrado (OCP), su diseño actual es adecuado para un sistema simple. Esto facilita la comprensión y el mantenimiento del código, permitiendo que la clase `MenuInterface` sea fácilmente modificable y extensible en el futuro.
