package Organism.Controllers;

import Organism.Models.BloodCells.RedBloodCell;
import Organism.Models.BloodCells.WhiteBloodCell;
import Organism.Models.Cell;
import Organism.Models.Cluster;
import Organism.Models.Microbes.Bacteria;
import Organism.Models.Microbes.Fungi;
import Organism.Models.Microbes.Virus;
import Organism.Organism;

import java.util.Map;

public class HealthManager {
    private Map<String, Organism> organisms;
    private Map<String, Cluster> clusters;
    private Map<String, Cell> cells;

    public HealthManager(Map<String, Organism> organisms, Map<String, Cluster> clusters, Map<String, Cell> cells) {
        this.organisms = organisms;
        this.clusters = clusters;
        this.cells = cells;
    }

    public String checkCondition(String organismName) {
        return this.organisms.get(organismName).toString();
    }

    public String createOrganism(String name) {
        Organism organism = new Organism(name);
        if (!this.organisms.containsKey(name)) {
            this.organisms.putIfAbsent(name, organism);
            return String.format("Created organism %s", name);
        } else {
            return String.format("Organism %s already exists", name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster cluster = new Cluster(id, rows, cols);
        this.clusters.putIfAbsent(id, cluster);
        return String.format("Organism %s: Created cluster %s", organismName, id);
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId,
                   int health, int positionRow, int positionCol, int additionalProperty) {
        Cell cell = null;
        if ("WhiteBloodCell".equals(cellType)) {
            cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
        } else if ("RedBloodCell".equals(cellType)) {
            cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
        } else if ("Bacteria".equals(cellType)) {
            cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
        } else if ("Virus".equals(cellType)) {
            cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
        } else if ("Fungi".equals(cellType)) {
            cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
        }
        this.organisms.get(organismName).getClusters().get(clusterId).addCell(cell);
        return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
    }

    public String activateCluster(String organismName) {
        String clusterId = "";
        int clusterCellsLeft = 0;
        for (Map.Entry<String, Cluster> clusterEntry : organisms.get(organismName).getClusters().entrySet()) {
            if (clusterEntry.getValue().getCellsSize() > 1) {

                clusterId = clusterEntry.getKey();
                clusterCellsLeft = clusterEntry.getValue().getCellsSize();
            }
        }

        return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, clusterId, clusterCellsLeft);
    }

}
