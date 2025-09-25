package p06_Football_Team_Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Team {
    private String name;
    private List<Player> players;
    private double rating;

    Team(String name) throws IllegalArgumentException {
        this.setName(name);
        this.players = new ArrayList<>();
        this.rating = 0;
    }

    private void setName(String name) throws IllegalArgumentException {
        if (name.length() == 0 || " ".equals(name)) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    void addPlayer(Player player) {
        this.players.add(player);
    }

    void removePlayer(String name) throws IllegalArgumentException {
        if (this.players.stream().map(Player::getName).noneMatch(p -> p.equals(name))) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
        players = players.stream().filter(p -> !p.getName().equals(name)).collect(Collectors.toList());
    }

    void calculateTeamRating() {
        if (players.size() > 0) {
            this.rating = players.stream().mapToDouble(Player::getOverallSkillLevel).sum() / players.size();
        } else {
            this.rating = 0;
        }
    }

    double getRating() {
        return this.rating;
    }
}
