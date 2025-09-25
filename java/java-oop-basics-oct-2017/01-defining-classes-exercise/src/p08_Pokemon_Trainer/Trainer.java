package p08_Pokemon_Trainer;

import java.util.ArrayList;
import java.util.List;

class Trainer {
    private static final int DEFAULT_BADGES_COUNT = 0;

    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    Trainer(String name) {
        this.name = name;
        this.badges = DEFAULT_BADGES_COUNT;
        this.pokemonList = new ArrayList<>();
    }

    int getBadges() {
        return this.badges;
    }

    void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    void checkForElement(String element) {
        boolean elementIsFound = this.pokemonList.stream().anyMatch(p -> p.getElement().equals(element));
        if (elementIsFound) {
            this.badges += 1;
        } else {
            this.pokemonList.forEach(Pokemon::decreasePokemonHealth);
            for (int i = 0; i <= this.pokemonList.size() - 1; i++) {
                if (this.pokemonList.get(i).getHealth() <= 0) {
                    this.pokemonList.remove(i);
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemonList.size());
    }
}
