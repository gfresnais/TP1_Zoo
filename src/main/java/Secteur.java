import java.util.List;

public class Secteur {
    private enum typeAnimauxDansSecteur {
        CHIEN,
        CHAT
    }
    private List<Animal> animauxDansSecteur;

    private String nom;

    public Secteur(String nom) {
        this.nom = nom;
    }

    public void ajouterAnimal(Animal animal) {
        try {
            String type = animal.getTypeAnimal();
            if( !type.equals( typeAnimauxDansSecteur.CHAT.toString() ) && !type.equals( typeAnimauxDansSecteur.CHIEN.toString() ) ) {
                throw new AnimalDansMauvaisSecteurException();
            }
            animauxDansSecteur.add(animal);
        } catch (AnimalDansMauvaisSecteurException e) {
            e.printStackTrace();
        }
    }

    public int getNombreAnimaux() {
        return animauxDansSecteur.size();
    }

    public String obtenirType() {
        String t = "";
        for (typeAnimauxDansSecteur type: typeAnimauxDansSecteur.values()) {
            t += type;
        }
        return t;
    }
}
