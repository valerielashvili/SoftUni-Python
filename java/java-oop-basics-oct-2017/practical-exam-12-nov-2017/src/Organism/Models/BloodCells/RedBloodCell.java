package Organism.Models.BloodCells;

import Organism.Models.Cell;

public class RedBloodCell extends Cell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.setVelocity(velocity);
    }

    private void setVelocity(int velocity) {
        //TODO: validation
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
