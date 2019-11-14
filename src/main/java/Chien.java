public class Chien extends Animal {

    public Chien(String nom) {
        super(nom);
    }

    @Override
    public String getNomAnimal() {
        return super.getNomAnimal();
    }

    @Override
    public String getTypeAnimal() {
        return typeAnimal.valueOf("CHIEN").toString();
    }
}
