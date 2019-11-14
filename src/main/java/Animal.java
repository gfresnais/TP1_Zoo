public abstract class Animal {
    private String nomAnimal;
    protected enum typeAnimal {
        CHIEN,
        CHAT
    }

    public Animal(String nomAnimal) {
        this.nomAnimal = nomAnimal;
    }

    public String getNomAnimal() {
        return nomAnimal;
    }

    public abstract String getTypeAnimal();
}
