package p06_Football_Team_Generator;

class Player {
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;
    private double overallSkillLevel;

    Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) throws IllegalArgumentException {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
        this.calculateOverallSkill(endurance, sprint, dribble, passing, shooting);
    }

    private void setName(String name) throws IllegalArgumentException {
        if (name.length() == 0 || " ".equals(name)) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(double endurance) throws IllegalArgumentException {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(double sprint) throws IllegalArgumentException {
        if (sprint < 0 || sprint > 100) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(double dribble) throws IllegalArgumentException {
        if (dribble < 0 || dribble > 100) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(double passing) throws IllegalArgumentException {
        if (passing < 0 || passing > 100) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(double shooting) throws IllegalArgumentException {
        if (shooting < 0 || shooting > 100) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    private void calculateOverallSkill(double endurance, double sprint, double dribble, double passing, double shooting) {
        this.overallSkillLevel = (endurance + sprint + dribble + passing + shooting) / 5;
    }

    String getName() {
        return this.name;
    }

    double getOverallSkillLevel() {
        return this.overallSkillLevel;
    }
}
