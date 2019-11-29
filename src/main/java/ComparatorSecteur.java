import java.util.Comparator;

public class ComparatorSecteur implements Comparator<Secteur> {
    @Override
    public int compare(Secteur secteur, Secteur t1) {
        return Integer.compare(secteur.getNombreAnimaux(), t1.getNombreAnimaux());
    }
}
