
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int answer;
    static double monto;
    static String inicio, fin;

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ejecutarPregunta(sc);
    }

    public static void opciones() {
        System.out.println("***********************************************\n");
        System.out.println("Sea Bienvenido al conversor de moneda");
        System.out.println("\n1) Dolar => Peso argentino");
        System.out.println("2) Peso argentino => Dolar");
        System.out.println("3) Dolar => Real Brasileño");
        System.out.println("4) Real Brasileño => Dolar");
        System.out.println("5) Dolar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dolar");
        System.out.println("7) Salir");
        System.out.println("\n*************************************************");
        System.out.print("Seleccione una opción: ");
    }

    public static void ejecutarPregunta(Scanner sc) {
        do {
            opciones();
            answer = sc.nextInt();
            if (answer == 7) {
                System.out.println("Gracias por usar el conversor de moneda. ¡Hasta luego!");
                break;
            }
            else if(answer > 7) {
                System.out.println("Opcion no valida");
                continue;
            }
            System.out.println("Ingrese el valor que desea convertir: ");
            monto = sc.nextDouble();
            ManejoConversion();
        }
        while (answer != 7);
    }

    public static void ManejoConversion() {
        switch (answer) {
            case 1:
                inicio = "USD";
                fin = "ARS";
                break;
            case 2:
                inicio = "ARS";
                fin = "USD";
                break;
            case 3:
                inicio = "USD";
                fin = "BRL";
                break;
            case 4:
                inicio = "BRL";
                fin = "USD";
                break;
            case 5:
                inicio = "USD";
                fin = "COP";
                break;
            case 6:
                inicio = "COP";
                fin = "USD";
                break;
            default:
                System.out.println("Opcion no válida.");
                return;
        }

        Conexion conexion = new Conexion(inicio, fin, monto);

        try {
            String resultado = conexion.ConexionOn();
            System.out.println(resultado);
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Ocurrio un error al conectar con la API.");
        }
    }
}
