import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Siempre se va a ejecutar el menu, dando así la funcionalidad de manera infinita ( El menu no se cierra )
        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("==================");
            System.out.println("\nPor Favor seleccione su opción de manera numérica");
            System.out.println("1. Reuniones");
            System.out.println("2. Cálculo de Porcentaje");
            System.out.println("3. Calcular IMC");
            System.out.println("s. Salir");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();
            // Aquí se valida la opción del usuario de manera numérica ej: 1,2,3
            // Más abajo se ha creado una función, para facilitar - reutilizar, la manera en la que se muestran las reuniones, ingresando como parametro solo el mes
            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el mes: ");
                    String mes = scanner.nextLine().toLowerCase();
                    mostrarReunion(mes);
                    break;
                case "2":
                    // Más abajo se ha creado una función, para facilitar - reutilizar la manera en la que se calcula el porcentaje, teniendo como parametros el valor de la venta y la categoría
                    System.out.print("Ingrese el valor de la venta: ");
                    double valorVenta = Double.parseDouble(scanner.nextLine()); // la función de esta línea sirve para redondear / parsear el resultado que como su tipo de dato lo indica es decimal
                    System.out.print("Ingrese la categoría del producto (medias, camisetas, chaqueta, otras): ");
                    String categoria = scanner.nextLine().toLowerCase();
                    calcularPorcentaje(valorVenta, categoria);
                    break;
                case "3":
                    // Más abajo se crea una función para calcular el IMC de la operación
                    System.out.print("Ingrese la unidad de Peso (Kg - Lb): ");
                    String unidadMedida = scanner.nextLine().toLowerCase();
                    System.out.print("Ingrese el peso: ");
                    double peso = Double.parseDouble(scanner.nextLine());

                    // Realizar la conversión si se ingresó en libras
                    if (unidadMedida.equals("lb")) {
                        peso *= 0.453592; // Formula de conversión a kilos
                    }

                    System.out.print("Ingrese su altura (en metros): ");
                    double altura = Double.parseDouble(scanner.nextLine());
                    calcularIMC(peso, altura);
                    break;
                case "s":
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void mostrarReunion(String mes) {
        String reunion = "";
        String encargado = "";

        switch (mes) {
            case "enero":
            case "febrero":
            case "marzo":
                reunion = "Rendición de Cuentas";
                encargado = "[Sweety Fox]";
                break;
            case "abril":
                reunion = "Análisis de Trabajo Junta Directiva";
                encargado = "[Pipe Malo]";
                break;
            case "mayo":
            case "junio":
            case "julio":
            case "agosto":
                reunion = "Reunión Ventas Exterior";
                encargado = "[Juan Granizo]";
                break;
            case "septiembre":
            case "octubre":
                reunion = "Reunión de Exportación";
                encargado = "[German Merienda]";
                break;
            case "noviembre":
                reunion = "Reunión para Determinar Horarios Decembrinos";
                encargado = "[Jose Jornadas Jones]";
                break;
            case "diciembre":
                reunion = "Reunión Regalos Empleados";
                encargado = "[El duende loco]";
                break;
            default:
                System.out.println("El mes que ingresó no tiene validez, por favor ingrese uno válido.");
                return;
        }

        System.out.println("Reunión: " + reunion);
        System.out.println("Encabezada por: " + encargado);
    }

    public static void calcularPorcentaje(double valorVenta, String categoria) {
        double descuento = 0.0;

        switch (categoria) {
            case "medias":
                descuento = 0.02;
                break;
            case "camisetas":
                descuento = 0.04;
                break;
            case "chaqueta":
                descuento = 0.10;
                break;
            default:
                descuento = 0.06;
                break;
        }

        double valorTotalSinDescuento = valorVenta;
        double descuentoAplicado = valorVenta * descuento;
        double valorAPagar = valorVenta - descuentoAplicado;

        System.out.println("Valor total sin descuento: " + valorTotalSinDescuento);
        System.out.println("Descuento aplicado: " + descuentoAplicado);
        System.out.println("Valor a pagar con descuento aplicado: " + valorAPagar);
    }

    public static void calcularIMC(double peso, double altura) {

        double imc = peso / (altura * altura);
        String resultado = "";

        if (imc < 18) {
            resultado = "Bajo de peso";
        } else if (imc >= 18 && imc <= 24) {
            resultado = "Peso normal";
        } else if (imc >= 25 && imc <= 29) {
            resultado = "Sobrepeso";
        } else if (imc >= 30 && imc <= 34) {
            resultado = "Obesidad grado 1";
        }

        System.out.println("Su IMC es: " + imc);
        System.out.println("Resultado: " + resultado);
    }
}