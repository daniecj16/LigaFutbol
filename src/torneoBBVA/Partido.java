package torneoBBVA;

import java.util.Random;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo ganador;

    public Partido(Equipo equipo1, Equipo equipo2) throws CompetidorIgualOponenteException {
        if (equipo1.equals(equipo2)) {
            throw new CompetidorIgualOponenteException("Un equipo no puede jugar contra sí mismo.");
        }
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ganador = determinarGanador();
    }

    // Determina el ganador de forma aleatoria
    private Equipo determinarGanador() {
        Random random = new Random();
        return random.nextBoolean() ? equipo1 : equipo2;
    }

    public Equipo getGanador() {
        return ganador;
    }

    @Override
    public String toString() {
        return equipo1.getNombre() + " vs " + equipo2.getNombre() + " | Ganador: " + ganador.getNombre();
    }
}

