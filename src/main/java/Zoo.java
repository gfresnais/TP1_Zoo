import java.util.List;

public class Zoo {
    private int visiteurs;
    private int limiteVisiteurs = 15;
    private List<Secteur> secteurAnimaux;

    public void ajouterSecteur(String secteur) {
        secteurAnimaux.add(new Secteur(secteur));
    }

    public void nouveauVisiteur() {
        try {
            if( visiteurs++ > limiteVisiteurs ) {
                throw new LimiteVisiteurException();
            }
        } catch (LimiteVisiteurException e) {
            e.printStackTrace();
        }
    }

    public int getLimiteVisiteur() {
        return limiteVisiteurs;
    }

    public void nouvelAnimal(Animal animal) {
        for (Secteur s: secteurAnimaux) {
            s.ajouterAnimal(animal);
        }
    }

    public int nombreAnimaux() {
        return secteurAnimaux.size();
    }
}
