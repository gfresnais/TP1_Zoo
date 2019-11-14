public class LimiteVisiteurException extends Exception {
    public LimiteVisiteurException() {
        super("Erreur, la limite du nombre de visiteurs a été dépassée");
    }
}
