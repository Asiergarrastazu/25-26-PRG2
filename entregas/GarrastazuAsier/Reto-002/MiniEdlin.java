import java.util.Scanner;

public class MiniEdlin {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String[] texto = new String[10];
        int lineaActiva = 0;
        int opcion = 0;

        for (int i = 0; i < 10; i++) texto[i] = "";

        do {

            System.out.println("1 mostrar");
            System.out.println("2 activa");
            System.out.println("3 editar");
            System.out.println("4 borrar");
            System.out.println("5 salir");

            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1) {

                for (int i = 0; i < 10; i++) {
                    if (i == lineaActiva)
                        System.out.println(">" + (i + 1) + ":" + texto[i]);
                    else
                        System.out.println(" " + (i + 1) + ":" + texto[i]);
                }
            }

            else if (opcion == 2) {

                int nueva = teclado.nextInt();
                teclado.nextLine();

                if (nueva > 0 && nueva <= 10)
                    lineaActiva = nueva - 1;
            }

            else if (opcion == 3) {

                texto[lineaActiva] = teclado.nextLine();
            }

            else if (opcion == 4) {

                int borrar = teclado.nextInt();
                teclado.nextLine();

                if (borrar > 0 && borrar <= 10)
                    texto[borrar - 1] = "";
            }

        } while (opcion != 5);
    }
}