package torneoBBVA;

public class CompetidorIgualOponenteException extends Exception {
    private static final long serialVersionUID = 1L; // Añadir este campo

    public CompetidorIgualOponenteException(String mensaje) {
        super(mensaje);
    }
}
