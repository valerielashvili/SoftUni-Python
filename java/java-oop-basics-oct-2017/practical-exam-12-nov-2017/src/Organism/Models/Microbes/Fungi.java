package Organism.Models.Microbes;

import Organism.Models.Microbe;

public class Fungi extends Microbe {

    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
