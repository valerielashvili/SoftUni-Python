package p06_Animals;

class Dog extends Animal {
    private static final String SOUND = "BauBau";

    Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    String produceSound() {
        return SOUND;
    }
}
