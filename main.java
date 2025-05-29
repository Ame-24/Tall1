import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos iniciales
        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        System.out.print("Ingrese tasa de interés anual (%): ");
        double tasaInteres = sc.nextDouble();

        CuentaAhorro cuenta = new CuentaAhorro(saldoInicial, tasaInteres);

        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("Transacciones realizadas: " + cuenta.getTransacciones());
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Ver saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese cantidad a depositar: ");
                    double deposito = sc.nextDouble();
                    cuenta.depositar(deposito);
                    System.out.println("Depósito realizado.");
                    break;
                case 2:
                    System.out.print("Ingrese cantidad a retirar: ");
                    double retiro = sc.nextDouble();
                    if (cuenta.retirar(retiro)) {
                        System.out.println("Retiro realizado.");
                    } else {
                        System.out.println("Fondos insuficientes o cantidad inválida.");
                    }
                    break;
                case 3:
                    System.out.println("Saldo actual: $" + cuenta.getSaldo());
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}
