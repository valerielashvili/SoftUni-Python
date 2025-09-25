package p04_Mordors_Cruelty_Plan;

class MoodFactory extends FoodFactory {
    private String mood;

    String getMood() {
        return this.mood;
    }

    void setMood() {
        if (super.getHappinessPoints() < -5) {
            this.mood = "Angry";
        } else if (super.getHappinessPoints() >= -5 && super.getHappinessPoints() < 0) {
            this.mood = "Sad";
        } else if (super.getHappinessPoints() >= 0 && super.getHappinessPoints() <= 15) {
            this.mood = "Happy";
        } else if (this.getHappinessPoints() > 15) {
            this.mood = "JavaScript";
        }
    }
}
