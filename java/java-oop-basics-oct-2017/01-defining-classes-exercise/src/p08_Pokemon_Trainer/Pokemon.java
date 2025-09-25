package p08_Pokemon_Trainer;

class Pokemon {
    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    int getHealth() {
        return this.health;
    }

    String getElement() {
        return this.element;
    }

    void decreasePokemonHealth() {
        this.health -= 10;
    }
}
