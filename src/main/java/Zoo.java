import java.util.ArrayList;
import java.util.List;

public class Zoo {
    /* Liés aux opérations de liste */
    private int visiteurs = 0;
    private int nbAnimaux = 0;
    private int limiteVisiteurs = 0;

    private List<Secteur> secteurAnimaux = new ArrayList<Secteur>();

    public void ajouterSecteur(String secteur) {
        secteurAnimaux.add(new Secteur(secteur));
    }

    public int getNbSecteurs() {
        return secteurAnimaux.size();
    }

    public void nouveauVisiteur() throws LimiteVisiteurException {
        if (visiteurs++ > limiteVisiteurs) {
            throw new LimiteVisiteurException();
        }
        for (Secteur s : secteurAnimaux) {
            // Si on a bien ajouté un visiteur, on arrête la recherche
            if (s.ajouterVisiteur()) break;
        }
    }

    public int getLimiteVisiteur() {
        for (Secteur s : secteurAnimaux) {
            limiteVisiteurs += s.getLimiteVisiteurs();
        }
        return limiteVisiteurs;
    }

    public int getVisiteurs() {
        for (Secteur s : secteurAnimaux) {
            visiteurs += s.getVisiteurs();
        }
        return visiteurs;
    }

    public void nouvelAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
        for (Secteur s : secteurAnimaux) {
            if (s.obtenirType(animal.getTypeAnimal()).equals(animal.getTypeAnimal())) {
                s.ajouterAnimal(animal);
            }
        }
    }

    public int nombreAnimaux() {
        for (Secteur s : secteurAnimaux) {
            nbAnimaux += s.getNombreAnimaux();
        }
        return nbAnimaux;
    }
}
