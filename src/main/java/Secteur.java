import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Secteur {

    private static final Logger LOGGER = LogManager.getLogger(Secteur.class.getName());

    /* Attributs énoncés */
    private enum typeAnimauxDansSecteur {
        CHIEN,
        CHAT
    }

    private List<Animal> animauxDansSecteur = new ArrayList<Animal>();

    /* Attributs ajoutés */
    private int limiteVisiteurs = 15;
    private int visiteurs = 0;

    private String nom;

    public Secteur(String nom) {
        this.nom = nom;
    }

    public void ajouterAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
        String type = animal.getTypeAnimal();
        if (!type.equals(typeAnimauxDansSecteur.CHAT.toString()) && !type.equals(typeAnimauxDansSecteur.CHIEN.toString())) {
            throw new AnimalDansMauvaisSecteurException();
        }
        animauxDansSecteur.add(animal);
    }

    public int getNombreAnimaux() {
        return animauxDansSecteur.size();
    }

    public String obtenirType(String typeDemande) {
        String type = "";
        try {
            type = typeAnimauxDansSecteur.valueOf(typeDemande).toString();
        } catch (IllegalArgumentException e) {
            type = typeDemande;
        }
        return type;
    }

    public boolean ajouterVisiteur() {
        try {
            if (visiteurs++ > limiteVisiteurs) {
                throw new LimiteVisiteurException();
            }
            return true;
        } catch (LimiteVisiteurException e) {
            LOGGER.error("Exception Limite Visiteur");
            return false;
        }
    }

    public int getVisiteurs() {
        return visiteurs;
    }

    public int getLimiteVisiteurs() {
        return limiteVisiteurs;
    }
}
