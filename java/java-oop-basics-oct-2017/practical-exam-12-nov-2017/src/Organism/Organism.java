package Organism;

import Organism.Models.Cluster;

import java.util.LinkedHashMap;
import java.util.Map;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.setName(name);
        this.clusters = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Map<String, Cluster> getClusters() {
        return this.clusters;
    }

    public void addCluster(Cluster cluster) {
        this.clusters.putIfAbsent(cluster.getId(), cluster);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Organism - %s", this.name)).append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.clusters.size()))
                .append(System.lineSeparator())
                .append(String.format("--Models: %d", this.clusters.values().stream().mapToInt(cluster -> cluster.getCellsSize()).sum()))
        .append(System.lineSeparator());

        return sb.toString();
    }
}
