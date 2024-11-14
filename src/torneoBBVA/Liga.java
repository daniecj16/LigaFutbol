package torneoBBVA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Liga {
    private List<Equipo> equipos = new ArrayList<>();
    private String[] etapas = {"Octavos de Final", "Cuartos de Final", "Semifinal", "Final"};
    private Set<String> partidosRegistrados = new HashSet<>();

    public void agregarEquipo(Equipo equipo) throws EquipoRepetidoException {
        for (Equipo e : equipos) {
            if (e.getNombre().equals(equipo.getNombre())) {
                throw new EquipoRepetidoException("El equipo " + equipo.getNombre() + " ya existe en la liga.");
            }
        }
        equipos.add(equipo);
    }

    public void iniciarTorneo(int etapaIndex) {
        if (equipos.size() % 2 != 0) {
            System.out.println("El número de equipos debe ser par para organizar el torneo.");
            return;
        }

        List<Equipo> equiposEnRonda = new ArrayList<>(equipos);
        System.out.println("\n=== Comienza el torneo ===\n");
        Equipo campeon = jugarTorneoRecursivo(equiposEnRonda, etapaIndex);  // Comienza en la etapa seleccionada
        System.out.println("\n*** Campeón del Torneo: " + campeon.getNombre() + " ***\n");
    }

    private Equipo jugarTorneoRecursivo(List<Equipo> equiposEnRonda, int etapaIndex) {
        // Condición base: si solo queda un equipo, es el campeón
        if (equiposEnRonda.size() == 1) {
            return equiposEnRonda.get(0);
        }

        // Obtener la etapa actual de forma segura
        String etapa = obtenerEtapaActual(etapaIndex);
        System.out.println("\n=== " + etapa + " ===\n");

        // Jugar los partidos de la ronda actual
        List<Equipo> ganadores = new ArrayList<>();
        Collections.shuffle(equiposEnRonda);  // Mezcla los equipos aleatoriamente

        for (int i = 0; i < equiposEnRonda.size(); i += 2) {
            Equipo equipo1 = equiposEnRonda.get(i);
            Equipo equipo2 = equiposEnRonda.get(i + 1);

            if (!equipo1.equals(equipo2)) {
                String partidoId = equipo1.getNombre() + " vs " + equipo2.getNombre();
                String partidoIdReverso = equipo2.getNombre() + " vs " + equipo1.getNombre();

                // Verificar que el partido no haya sido jugado en la misma etapa
                if (!partidosRegistrados.contains(partidoId) && !partidosRegistrados.contains(partidoIdReverso)) {
                    try {
                        Partido partido = new Partido(equipo1, equipo2);
                        System.out.println(partido);
                        ganadores.add(partido.getGanador());  // El ganador avanza a la siguiente ronda
                        partidosRegistrados.add(partidoId);  // Registrar el partido
                    } catch (CompetidorIgualOponenteException e) {
                        System.out.println("Error al crear el partido: " + e.getMessage());
                    }
                } else {
                    System.out.println("El partido " + partidoId + " ya se jugó en esta etapa.");
                }
            } else {
                System.out.println("Error: Un equipo no puede competir contra sí mismo.");
            }
        }

        // Llamada recursiva para la siguiente etapa, avanzando el índice de la etapa
        return jugarTorneoRecursivo(ganadores, etapaIndex + 1);
    }

    private String obtenerEtapaActual(int etapaIndex) {
        if (etapaIndex < etapas.length) {
            return etapas[etapaIndex];
        } else {
            return "Final";  // Usar "Final" si se excede el índice del arreglo de etapas
        }
    }
}
