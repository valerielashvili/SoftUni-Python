package p06_Animals;

class Cat extends Animal {
    private static final String SOUND = "MiauMiau";

    Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    String produceSound() {
        return SOUND;
    }
}
