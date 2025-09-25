package p06_Animals;

class Frog extends Animal {
    private static final String SOUND = "Frogggg";

    Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    String produceSound() {
        return SOUND;
    }
}
