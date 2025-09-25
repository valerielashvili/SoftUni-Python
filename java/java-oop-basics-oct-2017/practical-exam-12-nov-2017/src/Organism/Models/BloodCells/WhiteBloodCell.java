package Organism.Models.BloodCells;

import Organism.Models.BloodCell;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.setSize(size);
    }

    private void setSize(int size) {
        //TODO: validation
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("--------Health %s | Size %d | Energy {energy}", super.getHealth(), this.size)); //TODO: energy

        return sb.toString();
    }
}
