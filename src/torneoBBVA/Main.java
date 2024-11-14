package torneoBBVA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Liga liga = new Liga();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la etapa del torneo:");
        System.out.println("1. Octavos de Final (16 equipos)");
        System.out.println("2. Cuartos de Final (8 equipos)");
        System.out.println("3. Semifinal (4 equipos)");
        System.out.println("4. Final (2 equipos)");

        int seleccionEtapa = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea restante

        // Validación de la etapa seleccionada
        if (seleccionEtapa < 1 || seleccionEtapa > 4) {
            System.out.println("Selección inválida. Debe elegir entre 1 y 4.");
            scanner.close();
            return;
        }

        // Determinar el número de equipos según la etapa seleccionada
        int numEquipos = (int) Math.pow(2, 5 - seleccionEtapa);

        System.out.println("Ingrese los nombres de los " + numEquipos + " equipos para esta etapa:");

        // Ingreso de equipos
        for (int i = 1; i <= numEquipos; i++) {
            System.out.print("Nombre del equipo " + i + ": ");
            String nombreEquipo = scanner.nextLine();
            try {
                liga.agregarEquipo(new Equipo(nombreEquipo));
            } catch (EquipoRepetidoException e) {
                System.out.println(e.getMessage());
                i--; // Repetir el ingreso del equipo si está duplicado
            }
        
        }

        // Iniciar el torneo desde la etapa seleccionada
        liga.iniciarTorneo(seleccionEtapa - 1);  // Paso el índice de la etapa seleccionada
        scanner.close();
    }
}
