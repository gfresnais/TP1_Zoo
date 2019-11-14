public class Chat extends Animal {

    public Chat(String nom) {
        super(nom);
    }

    @Override
    public String getNomAnimal() {
        return super.getNomAnimal();
    }

    @Override
    public String getTypeAnimal() {
        return typeAnimal.valueOf("CHAT").toString();
    }
}
