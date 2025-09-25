package Organism.Models;

public class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.setVirulence(virulence);
    }

    private void setVirulence(int virulence) {
        //TODO: validation
        this.virulence = virulence;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
