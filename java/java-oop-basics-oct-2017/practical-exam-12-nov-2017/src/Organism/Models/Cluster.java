package Organism.Models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    Map<String, Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.setId(id);
        this.setRows(rows);
        this.setCols(cols);
        this.cells = new LinkedHashMap<>();
    }

    public String getId() {
        return this.id;
    }

    public int getCellsSize() {
        return this.cells.size();
    }

    private void setId(String id) {
        //TODO: validation
        this.id = id;
    }

    private void setRows(int rows) {
        //TODO: validation
        this.rows = rows;
    }

    private void setCols(int cols) {
        //TODO: validation
        this.cols = cols;
    }

    public void addCell(Cell cell) {
        this.cells.putIfAbsent(cell.getId(), cell);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----Cluster %s", this.id)).append(System.lineSeparator());

        return sb.toString();
    }
}
