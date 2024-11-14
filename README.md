# Liga de Fútbol - Torneo BBVA

Este proyecto es una aplicación de consola en Java que simula un torneo de fútbol de eliminación directa, como el formato usado en la liga BBVA. Los equipos avanzan en diferentes etapas, desde octavos de final hasta la final, y cada partido define un ganador que continúa en el torneo.

## Características

- Permite registrar equipos participantes en cada etapa del torneo (Octavos, Cuartos, Semifinales y Final).
- Control de errores con excepciones personalizadas:
  - **EquipoRepetidoException**: asegura que no se puedan registrar equipos duplicados.
  - **CompetidorIgualOponenteException**: asegura que un equipo no juegue contra sí mismo.
- Sistema de manejo de errores y validaciones para una experiencia de usuario más amigable.
- Simulación de enfrentamientos en cada etapa del torneo.

## Estructura de Clases

- **Main**: Clase principal que ejecuta la aplicación y permite al usuario ingresar los equipos y avanzar en el torneo.
- **Liga**: Administra los equipos y organiza los enfrentamientos en cada etapa.
- **Equipo**: Representa un equipo participante en el torneo.
- **Partido**: Modela un enfrentamiento entre dos equipos.
- **Excepciones**:
  - **EquipoRepetidoException**: Lanza una excepción si un equipo ya ha sido registrado.
  - **CompetidorIgualOponenteException**: Lanza una excepción si un equipo intenta jugar contra sí mismo.

## Requisitos

- **Eclipse IDE** (opcional, pero recomendado para desarrollo y edición de PlantUML)


## Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/danielcj16/LigaFutbol.git
