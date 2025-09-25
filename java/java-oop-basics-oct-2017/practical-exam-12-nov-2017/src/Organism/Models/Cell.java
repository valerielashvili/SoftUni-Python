package Organism.Models;

public class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) throws IllegalArgumentException {
        this.setId(id);
        this.setHealth(health);
        this.setPositionRow(positionRow);
        this.setPositionCol(positionCol);
    }

    public String getId() {
        return this.id;
    }

    protected int getHealth() {
        return this.health;
    }

    private void setId(String id) {
        //TODO: validation
        this.id = id;
    }

    private void setHealth(int health) throws IllegalArgumentException {
        if (health < 0) {
            throw new IllegalStateException("");
        }
        this.health = health;
    }

    private void setPositionRow(int positionRow) throws IllegalArgumentException {
        if (positionRow < 0) {
            throw new IllegalStateException("");
        }
        this.positionRow = positionRow;
    }

    private void setPositionCol(int positionCol) throws IllegalArgumentException {
        if (positionCol < 0) {
            throw new IllegalStateException("");
        }
        this.positionCol = positionCol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("------Cell %s [%d,%d]", this.id, this.positionRow, this.positionCol))
        .append(System.lineSeparator());

        return sb.toString();
    }
}
