public abstract class Animal {
    private String nomAnimal;
    private enum typeAnimal {
        CHIEN,
        CHAT
    }

    public String getNomAnimal() {
        return nomAnimal;
    }

    public String getTypeAnimal() {
        return typeAnimal.valueOf("CHAT").toString();
    }
}
